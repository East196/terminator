package com.github.east196.terminator.xtend.bot

import com.google.common.base.Charsets
import com.google.common.io.Files
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStreamWriter
import java.io.Writer
import java.util.List
import org.dom4j.Attribute
import org.dom4j.Document
import org.dom4j.Element
import org.dom4j.io.OutputFormat
import org.dom4j.io.SAXReader
import org.dom4j.io.XMLWriter

class AndroidXmlHandler {
	var static i = 1

	def static void main(String[] args) {
		// 根据文件名+xml的节点类型+数字生成id
		// 根据节点类型+节点ID生成  Type name =  findViewById(R.id.节点id),初始化
//		var path = '''C:\Users\threepangpang\Desktop\person_city_item.xml'''
//		Files.copy(new File(path), new File(path + ".bak"))
//		handleXml(path)

		var dir = '''C:\Users\threepangpang\Desktop\entity'''
		entity2beanByDir(dir)

	}
	
	def static void entity2beanByDir(String javaDir) {
		new File(javaDir).listFiles.forEach[
			entity2bean(it.path)
		]
	}
	
	def static void entity2bean(String javaFile) {
		println(javaFile)
		var lines = Files.readLines(new File(javaFile),Charsets.UTF_8).filter[
			!(it.contains("@")|| it.contains("spring")||it.contains("javax")||it.contains("hibernate")
				||it.contains("jackson")||it.contains("jeecg")||it.contains("testDemo")
			)||it.contains("@Data")
		].toList.join(System.lineSeparator)
		Files.write(lines,new File(javaFile),Charsets.UTF_8)
	}

	def static handleXml(String path) {
		var SAXReader reader = new SAXReader()

		// 通过reader对象的read方法加载books.xml文件,获取docuemnt对象。
		val file = new File(path)
		println(file.name.split("\\.").get(0))
		val fileId = file.name.split("\\.").get(0)
		var Document document = reader.read(file)
		// 通过document对象获取根节点bookstore
		var Element root = document.getRootElement()

		addAttr(fileId, root)
		java(fileId, root)

		writeData2Xml(file, document)

	}

	/** 
	 * 将document数据写入file文件中
	 * @param xmlFile
	 * @param document
	 * @throws IOException
	 */
	def static void writeData2Xml(File xmlFile, Document document) throws IOException {
		var OutputFormat format = OutputFormat.createPrettyPrint()
		var Writer xmlwriter = new OutputStreamWriter(new FileOutputStream(xmlFile), "UTF-8")
		format.setEncoding("UTF-8")
		var XMLWriter writer = new XMLWriter(xmlwriter, format)
		writer.write(document)
		writer.close()
		xmlwriter.close()
	}

	def static addAttr(String fileId, Element book) {
		System.out.println("=====开始遍历=====" + book.name)
		// 获取book的属性名以及 属性值
		var List<Attribute> bookAttrs = book.attributes()
		if (bookAttrs.filter[attr|attr.qualifiedName.equals("android:id")].length == 0) {
			book.addAttribute("android:id", '''@+id/«fileId»_«book.name.split("\\.").last.toLowerCase»_«i++»''')
//			if(bookAttrs.filter[attr|attr.qualifiedName.equals("android:text")].length == 0){
//				book.addAttribute("android:id", '''@+id/«fileId»_«book.name»_«i++»''')
//			}else{
//				book.addAttribute("android:id", '''@+id/«fileId»_«book.name»_«Translate.execute(book.attributeValue("android:text"))»_«i++»''')
//			}
		}
		for (Attribute attr : bookAttrs) {
			System.out.println('''属性名：«attr.getName()» «attr.qualifiedName»--属性值：«attr.getValue()»''')
		}
		var itt = book.elementIterator()
		while (itt.hasNext()) {
			var Element bookChild = (itt.next() as Element)
			System.out.println('''节点名：«bookChild.getName()»''')
			addAttr(fileId, bookChild)
		}
		System.out.println("=====结束遍历=====" + book.name)
	}

	def static java(String fileId, Element element) {
		var List<Attribute> bookAttrs = element.attributes()
		val attr = bookAttrs.findFirst[attr|attr.qualifiedName.equals("android:id")]
		val code = '''
			«element.name» «attr.value.split("/").get(1)» = findViewById(R.id.«attr.value.split("/").get(1)»);
			«IF element.name == "TextView"»«attr.value.split("/").get(1)».setText("");«ENDIF»
		'''
		println(code)
		var itt = element.elementIterator()
		while (itt.hasNext()) {
			var Element bookChild = (itt.next() as Element)
			java(fileId, bookChild)
		}
	}
}
