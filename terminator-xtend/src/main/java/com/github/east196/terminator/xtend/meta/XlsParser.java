package com.github.east196.terminator.xtend.meta;

import com.google.common.base.Charsets;
import com.google.common.base.Objects;
import com.google.common.collect.TreeTraverser;
import com.google.common.io.Files;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Generated;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.boon.Boon;
import org.boon.core.reflection.BeanUtils;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class XlsParser {
  @Data
  public static class Table {
    private final String name;
    
    private final String description;
    
    private final List<List<String>> records;
    
    public void printDetail() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(this.name, "");
      _builder.append("  ");
      _builder.append(this.description, "");
      InputOutput.<String>println(_builder.toString());
      final Consumer<List<String>> _function = (List<String> it) -> {
        String _join = IterableExtensions.join(it, "\t");
        InputOutput.<String>println(_join);
      };
      this.records.forEach(_function);
    }
    
    public boolean isValid() {
      int _size = this.records.size();
      return (_size > 3);
    }
    
    public ArrayList<XlsParser.Schema> getSchemas() {
      ArrayList<XlsParser.Schema> _xblockexpression = null;
      {
        final List<String> cnNames = this.records.get(0);
        final List<String> enNames = this.records.get(1);
        final List<String> types = this.records.get(2);
        ArrayList<XlsParser.Schema> schemas = CollectionLiterals.<XlsParser.Schema>newArrayList();
        for (int i = 0; (i < cnNames.size()); i++) {
          {
            final String cnName = cnNames.get(i);
            final String enName = enNames.get(i);
            final String type = types.get(i);
            XlsParser.Schema _schema = new XlsParser.Schema(cnName, enName, type);
            schemas.add(_schema);
          }
        }
        _xblockexpression = schemas;
      }
      return _xblockexpression;
    }
    
    public <T extends Object> List<T> getTypedRecords(final Class<T> type) {
      try {
        ArrayList<T> _xblockexpression = null;
        {
          final List<String> enNames = this.records.get(1);
          ArrayList<T> typedRecords = CollectionLiterals.<T>newArrayList();
          for (int i = 3; (i < this.records.size()); i++) {
            {
              List<String> cells = this.records.get(i);
              final T instance = type.newInstance();
              for (int j = 0; (j < enNames.size()); j++) {
                String _get = enNames.get(j);
                String _get_1 = cells.get(j);
                BeanUtils.idx(instance, _get, _get_1);
              }
              typedRecords.add(instance);
            }
          }
          _xblockexpression = typedRecords;
        }
        return _xblockexpression;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
    
    public Table(final String name, final String description, final List<List<String>> records) {
      super();
      this.name = name;
      this.description = description;
      this.records = records;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
      result = prime * result + ((this.description== null) ? 0 : this.description.hashCode());
      result = prime * result + ((this.records== null) ? 0 : this.records.hashCode());
      return result;
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      XlsParser.Table other = (XlsParser.Table) obj;
      if (this.name == null) {
        if (other.name != null)
          return false;
      } else if (!this.name.equals(other.name))
        return false;
      if (this.description == null) {
        if (other.description != null)
          return false;
      } else if (!this.description.equals(other.description))
        return false;
      if (this.records == null) {
        if (other.records != null)
          return false;
      } else if (!this.records.equals(other.records))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("name", this.name);
      b.add("description", this.description);
      b.add("records", this.records);
      return b.toString();
    }
    
    @Pure
    public String getName() {
      return this.name;
    }
    
    @Pure
    public String getDescription() {
      return this.description;
    }
    
    @Pure
    public List<List<String>> getRecords() {
      return this.records;
    }
  }
  
  @Data
  public static class Schema {
    private final String cnName;
    
    private final String enName;
    
    private final String type;
    
    public String javaType() {
      String _switchResult = null;
      final String type = this.type;
      switch (type) {
        case "string":
          _switchResult = "String";
          break;
        case "num":
          _switchResult = "int";
          break;
        default:
          _switchResult = this.type;
          break;
      }
      return _switchResult;
    }
    
    public Schema(final String cnName, final String enName, final String type) {
      super();
      this.cnName = cnName;
      this.enName = enName;
      this.type = type;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.cnName== null) ? 0 : this.cnName.hashCode());
      result = prime * result + ((this.enName== null) ? 0 : this.enName.hashCode());
      result = prime * result + ((this.type== null) ? 0 : this.type.hashCode());
      return result;
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      XlsParser.Schema other = (XlsParser.Schema) obj;
      if (this.cnName == null) {
        if (other.cnName != null)
          return false;
      } else if (!this.cnName.equals(other.cnName))
        return false;
      if (this.enName == null) {
        if (other.enName != null)
          return false;
      } else if (!this.enName.equals(other.enName))
        return false;
      if (this.type == null) {
        if (other.type != null)
          return false;
      } else if (!this.type.equals(other.type))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("cnName", this.cnName);
      b.add("enName", this.enName);
      b.add("type", this.type);
      return b.toString();
    }
    
    @Pure
    public String getCnName() {
      return this.cnName;
    }
    
    @Pure
    public String getEnName() {
      return this.enName;
    }
    
    @Pure
    public String getType() {
      return this.type;
    }
  }
  
  public static void copy(final CharSequence content, final String path) {
    try {
      final File file = new File(path);
      Files.createParentDirs(file);
      Files.write(content, file, Charsets.UTF_8);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void main(final String[] args) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("F:\\workspace\\dsl-new\\miniserver\\src\\main\\java\\com\\github\\east196\\miniserver\\xlsbean");
    final String basePath = _builder.toString();
    final String basePackageName = "com.github.east196.miniserver.xlsbean";
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("D:/tmp/data/");
    final String baseXlsPath = _builder_1.toString();
    TreeTraverser<File> _fileTreeTraverser = Files.fileTreeTraverser();
    File _file = new File(baseXlsPath);
    Iterable<File> _children = _fileTreeTraverser.children(_file);
    final Function1<File, Boolean> _function = (File it) -> {
      String _absolutePath = it.getAbsolutePath();
      return Boolean.valueOf(_absolutePath.endsWith("xls"));
    };
    Iterable<File> _filter = IterableExtensions.<File>filter(_children, _function);
    final Consumer<File> _function_1 = (File it) -> {
      String _absolutePath = it.getAbsolutePath();
      List<XlsParser.Table> _readSchemas = XlsParser.readSchemas(_absolutePath);
      final Function1<XlsParser.Table, Boolean> _function_2 = (XlsParser.Table it_1) -> {
        return Boolean.valueOf(it_1.isValid());
      };
      final Iterable<XlsParser.Table> tables = IterableExtensions.<XlsParser.Table>filter(_readSchemas, _function_2);
      final Consumer<XlsParser.Table> _function_3 = (XlsParser.Table table) -> {
        String klassType = StringExtensions.toFirstUpper(table.name);
        String content = XlsParser.bean(basePackageName, table);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append(basePath, "");
        _builder_2.append("\\");
        _builder_2.append(klassType, "");
        _builder_2.append(".java");
        String path = _builder_2.toString();
        XlsParser.copy(content, path);
      };
      tables.forEach(_function_3);
    };
    _filter.forEach(_function_1);
    List<XlsParser.Table> _readSchemas = XlsParser.readSchemas("d:/tmp/data/状态表.xls");
    final Function1<XlsParser.Table, Boolean> _function_2 = (XlsParser.Table it) -> {
      return Boolean.valueOf(it.isValid());
    };
    final Iterable<XlsParser.Table> tables = IterableExtensions.<XlsParser.Table>filter(_readSchemas, _function_2);
    final Consumer<XlsParser.Table> _function_3 = (XlsParser.Table table) -> {
      try {
        String klassType = StringExtensions.toFirstUpper(table.name);
        String content = XlsParser.bean(basePackageName, table);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append(basePath, "");
        _builder_2.append("\\");
        _builder_2.append(klassType, "");
        _builder_2.append(".java");
        String path = _builder_2.toString();
        XlsParser.copy(content, path);
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append(basePackageName, "");
        _builder_3.append(".");
        _builder_3.append(klassType, "");
        Class<?> _forName = Class.forName(_builder_3.toString());
        List<?> _typedRecords = table.getTypedRecords(_forName);
        final Consumer<Object> _function_4 = (Object it) -> {
          String _prettyJson = Boon.toPrettyJson(it);
          InputOutput.<String>println(_prettyJson);
        };
        _typedRecords.forEach(_function_4);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    tables.forEach(_function_3);
  }
  
  public static String bean(final String basePackageName, final XlsParser.Table table) {
    String _xblockexpression = null;
    {
      final String klassType = StringExtensions.toFirstUpper(table.name);
      final String klassDescription = table.description;
      final ArrayList<XlsParser.Schema> fields = table.getSchemas();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("import com.google.common.base.Objects;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(klassType, "");
      _builder.append(" {//");
      _builder.append(klassDescription, "");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        for(final XlsParser.Schema f : fields) {
          _builder.append("\t");
          _builder.append("private ");
          String _javaType = f.javaType();
          _builder.append(_javaType, "\t");
          _builder.append(" ");
          _builder.append(f.enName, "\t");
          _builder.append(";//");
          _builder.append(f.cnName, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(klassType, "\t");
      _builder.append("() {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(klassType, "\t");
      _builder.append("(");
      final Function1<XlsParser.Schema, String> _function = (XlsParser.Schema f_1) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        String _javaType_1 = f_1.javaType();
        _builder_1.append(_javaType_1, "");
        _builder_1.append(" ");
        _builder_1.append(f_1.enName, "");
        return _builder_1.toString();
      };
      List<String> _map = ListExtensions.<XlsParser.Schema, String>map(fields, _function);
      String _join = IterableExtensions.join(_map, ", ");
      _builder.append(_join, "\t");
      _builder.append("){");
      _builder.newLineIfNotEmpty();
      {
        for(final XlsParser.Schema f_1 : fields) {
          _builder.append("\t\t");
          _builder.append("this.");
          _builder.append(f_1.enName, "\t\t");
          _builder.append("=");
          _builder.append(f_1.enName, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      {
        for(final XlsParser.Schema f_2 : fields) {
          _builder.append("\t");
          _builder.append("public ");
          String _javaType_1 = f_2.javaType();
          _builder.append(_javaType_1, "\t");
          _builder.append(" get");
          String _firstUpper = StringExtensions.toFirstUpper(f_2.enName);
          _builder.append(_firstUpper, "\t");
          _builder.append("() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return ");
          _builder.append(f_2.enName, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void set");
          String _firstUpper_1 = StringExtensions.toFirstUpper(f_2.enName);
          _builder.append(_firstUpper_1, "\t");
          _builder.append("(");
          String _javaType_2 = f_2.javaType();
          _builder.append(_javaType_2, "\t");
          _builder.append(" ");
          _builder.append(f_2.enName, "\t");
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("this.");
          _builder.append(f_2.enName, "\t\t");
          _builder.append(" = ");
          _builder.append(f_2.enName, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("    ");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("public boolean equals(Object o) {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("if (this == o) return true;");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("if (o == null || getClass() != o.getClass()) return false;");
      _builder.newLine();
      _builder.append("        ");
      _builder.append(klassType, "        ");
      _builder.append(" that = (");
      _builder.append(klassType, "        ");
      _builder.append(") o;");
      _builder.newLineIfNotEmpty();
      _builder.append("        ");
      _builder.append("return ");
      {
        boolean _hasElements = false;
        for(final XlsParser.Schema f_3 : fields) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate("&&", "        ");
          }
          _builder.append("Objects.equal(");
          _builder.append(f_3.enName, "        ");
          _builder.append(", that.");
          _builder.append(f_3.enName, "        ");
          _builder.append(")");
        }
        if (_hasElements) {
          _builder.append(";", "        ");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("public int hashCode() {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("return Objects.hashCode(");
      final Function1<XlsParser.Schema, String> _function_1 = (XlsParser.Schema it) -> {
        return it.enName;
      };
      List<String> _map_1 = ListExtensions.<XlsParser.Schema, String>map(fields, _function_1);
      String _join_1 = IterableExtensions.join(_map_1, ", ");
      _builder.append(_join_1, "        ");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("public String toString() {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("return Objects.toStringHelper(this)");
      {
        for(final XlsParser.Schema f_4 : fields) {
          _builder.append(".add(\"");
          _builder.append(f_4.enName, "        ");
          _builder.append("\", ");
          _builder.append(f_4.enName, "        ");
          _builder.append(")");
        }
      }
      _builder.append(".toString();");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}\t\t");
      _builder.newLine();
      _xblockexpression = InputOutput.<String>print(_builder.toString());
    }
    return _xblockexpression;
  }
  
  public static List<XlsParser.Table> readSchemas(final String xlsName) {
    try {
      List<XlsParser.Table> _xblockexpression = null;
      {
        InputOutput.<String>println(xlsName);
        final File xlsOrxlsxFile = new File(xlsName);
        final Workbook wb = WorkbookFactory.create(xlsOrxlsxFile);
        Iterator<Sheet> _sheetIterator = wb.sheetIterator();
        final Function1<Sheet, XlsParser.Table> _function = (Sheet it) -> {
          return XlsParser.readSchemaBySheet(it);
        };
        Iterator<XlsParser.Table> _map = IteratorExtensions.<Sheet, XlsParser.Table>map(_sheetIterator, _function);
        _xblockexpression = IteratorExtensions.<XlsParser.Table>toList(_map);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static XlsParser.Table readSchema(final String xlsName, final String sheetName) {
    try {
      XlsParser.Table _xblockexpression = null;
      {
        final File xlsOrxlsxFile = new File(xlsName);
        final Workbook wb = WorkbookFactory.create(xlsOrxlsxFile);
        final Sheet sheet = wb.getSheet(sheetName);
        _xblockexpression = XlsParser.readSchemaBySheet(sheet);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static XlsParser.Table readSchemaBySheet(final Sheet sheet) {
    XlsParser.Table _xblockexpression = null;
    {
      String _sheetName = sheet.getSheetName();
      InputOutput.<String>println(_sheetName);
      final ArrayList<List<String>> records = CollectionLiterals.<List<String>>newArrayList();
      final int firstRowNum = sheet.getFirstRowNum();
      final int lastRowNum = sheet.getLastRowNum();
      for (int rowIndex = firstRowNum; (rowIndex <= lastRowNum); rowIndex++) {
        {
          final Row row = sheet.getRow(rowIndex);
          boolean _notEquals = (!Objects.equal(null, row));
          if (_notEquals) {
            final ArrayList<String> record = CollectionLiterals.<String>newArrayList();
            final short lastCellNum = row.getLastCellNum();
            for (int cellIndex = 0; (cellIndex < lastCellNum); cellIndex++) {
              {
                final Cell cell = row.getCell(cellIndex, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                Object cellValue = XlsParser.getCellValue(cell);
                String _plus = (cellValue + "");
                record.add(cellIndex, _plus);
              }
            }
            records.add(record);
          }
        }
      }
      final String sheetName = sheet.getSheetName();
      String name = sheetName;
      String description = "";
      String[] _split = sheetName.split("-");
      int _size = ((List<String>)Conversions.doWrapArray(_split)).size();
      boolean _equals = (_size == 2);
      if (_equals) {
        String[] _split_1 = sheetName.split("-");
        String _get = _split_1[1];
        description = _get;
      }
      _xblockexpression = new XlsParser.Table(name, description, records);
    }
    return _xblockexpression;
  }
  
  public static Object getCellValue(final Cell cell) {
    Object _xifexpression = null;
    boolean _notEquals = (!Objects.equal(null, cell));
    if (_notEquals) {
      Object _switchResult = null;
      CellType _cellTypeEnum = cell.getCellTypeEnum();
      if (_cellTypeEnum != null) {
        switch (_cellTypeEnum) {
          case NUMERIC:
            _switchResult = Double.valueOf(cell.getNumericCellValue());
            break;
          case STRING:
            _switchResult = cell.getStringCellValue();
            break;
          case FORMULA:
            _switchResult = cell.getCellFormula();
            break;
          default:
            RichTextString _richStringCellValue = cell.getRichStringCellValue();
            _switchResult = _richStringCellValue.getString();
            break;
        }
      } else {
        RichTextString _richStringCellValue = cell.getRichStringCellValue();
        _switchResult = _richStringCellValue.getString();
      }
      _xifexpression = ((Object)_switchResult);
    }
    return _xifexpression;
  }
}
