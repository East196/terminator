package com.github.east196.terminator.xtend.meta

import com.google.common.base.Charsets
import com.google.common.io.Files
import java.io.File
import java.util.List
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.boon.Boon
import org.boon.core.reflection.BeanUtils
import org.eclipse.xtend.lib.annotations.Data

class XlsParser {

	static def copy(CharSequence content, String path) {
		val file = new File(path)
		Files.createParentDirs(file);
		Files.write(content, file, Charsets.UTF_8)
	}

	def static void main(String[] args) {
		val basePath = '''F:\workspace\dsl-new\miniserver\src\main\java\com\github\east196\miniserver\xlsbean'''
		val basePackageName = "com.github.east196.miniserver.xlsbean"
		val baseXlsPath = '''D:/tmp/data/'''
		Files.fileTreeTraverser.children(new File(baseXlsPath)).filter[it.absolutePath.endsWith("xls")].forEach [
			val tables = readSchemas(it.absolutePath).filter[it.valid]
			tables.forEach [ table |
				var klassType = table.name.toFirstUpper
				var content = bean(basePackageName, table)
				var path = '''«basePath»\«klassType».java'''
				copy(content, path)
			]
		]

		val tables = readSchemas("d:/tmp/data/状态表.xls").filter[it.valid]
		tables.forEach [ table |
			var klassType = table.name.toFirstUpper
			var content = bean(basePackageName, table)
			var path = '''«basePath»\«klassType».java'''
			copy(content, path)
			table.getTypedRecords(Class.forName('''«basePackageName».«klassType»''')).forEach[
				println(Boon.toPrettyJson(it))
			]
		]
	}

	static def bean(String basePackageName, Table table) {
		val klassType = table.name.toFirstUpper
		val klassDescription = table.description
		val fields = table.schemas
		print('''
package «basePackageName»;
import com.google.common.base.Objects;

public class «klassType» {//«klassDescription»

	«FOR f : fields»
	private «f.javaType» «f.enName»;//«f.cnName»
	«ENDFOR»

	public «klassType»() {
	}
	
	public «klassType»(«fields.map[f|'''«f.javaType» «f.enName»'''].join(", ")»){
		«FOR f : fields»
		this.«f.enName»=«f.enName»;
		«ENDFOR»
	}

	«FOR f : fields»
	public «f.javaType» get«f.enName.toFirstUpper»() {
		return «f.enName»;
	}

	public void set«f.enName.toFirstUpper»(«f.javaType» «f.enName») {
		this.«f.enName» = «f.enName»;
	}
	«ENDFOR»

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        «klassType» that = («klassType») o;
        return «FOR f : fields SEPARATOR '&&' AFTER ';'»Objects.equal(«f.enName», that.«f.enName»)«ENDFOR»
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(«fields.map[it.enName].join(", ")»);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)«FOR f : fields».add("«f.enName»", «f.enName»)«ENDFOR».toString();
    }
}		
		''')
	}

	def static List<Table> readSchemas(String xlsName) {
		println(xlsName)
		val xlsOrxlsxFile = new File(xlsName);
		val wb = WorkbookFactory.create(xlsOrxlsxFile);
		wb.sheetIterator.map[readSchemaBySheet(it)].toList
	}

	def static Table readSchema(String xlsName, String sheetName) {
		val xlsOrxlsxFile = new File(xlsName);
		val wb = WorkbookFactory.create(xlsOrxlsxFile);
		val sheet = wb.getSheet(sheetName)
		readSchemaBySheet(sheet)
	}

	def static readSchemaBySheet(Sheet sheet) {
		println(sheet.sheetName)
		val records = newArrayList()
		val firstRowNum = sheet.getFirstRowNum();
		val lastRowNum = sheet.getLastRowNum();
		for (var rowIndex = firstRowNum; rowIndex <= lastRowNum; rowIndex++) {
			val row = sheet.getRow(rowIndex);
			if (null != row) {
				val record = newArrayList()
				val lastCellNum = row.getLastCellNum();
				for (var cellIndex = 0; cellIndex < lastCellNum; cellIndex++) { // 遍历cell（列 0开始）
					val cell = row.getCell(cellIndex, MissingCellPolicy.RETURN_BLANK_AS_NULL);
					var cellValue = getCellValue(cell)
					record.add(cellIndex, cellValue + "")
				}
				records.add(record)
			}
		}
		val sheetName = sheet.sheetName
		var name = sheetName
		var description = ""
		if (sheetName.split("-").size == 2) {
			description = sheetName.split("-").get(1)
		}
		new Table(name, description, records)
	}

	def static getCellValue(Cell cell) {
		if (null != cell) {
			switch cell.getCellTypeEnum() {
				case CellType.NUMERIC: cell.numericCellValue
				case CellType.STRING: cell.stringCellValue
				case CellType.FORMULA: cell.cellFormula
				default: cell.richStringCellValue.string
			}
		}
	}

	@Data
	static class Table {
		String name
		String description
		List<List<String>> records

		def printDetail() {
			println('''«name»  «description»''')
			records.forEach[println(it.join("\t"))]
		}

		def isValid() {
			records.size > 3
		}

		def getSchemas() {
			val cnNames = records.get(0)
			val enNames = records.get(1)
			val types = records.get(2)
			var schemas = newArrayList()
			for (var i = 0; i < cnNames.size; i++) {
				val cnName = cnNames.get(i)
				val enName = enNames.get(i)
				val type = types.get(i)
				schemas.add(new Schema(cnName, enName, type))
			}
			schemas
		}
		
		def <T> List<T> getTypedRecords(Class<T> type){
			val enNames = records.get(1)
			var typedRecords = newArrayList()
			for (var i = 3; i < records.size; i++) {
				var cells=records.get(i)
				val instance=type.newInstance
				for(var j=0;j<enNames.size;j++){
					BeanUtils.idx(instance,enNames.get(j),cells.get(j))
				}
				typedRecords.add(instance)
			}
			typedRecords
		}
	}

	@Data
	static class Schema {
		String cnName
		String enName
		String type

		def String javaType() {
			switch type {
				case "string": "String"
				case "num": "int"
				default: type
			}
		}
	}

}
