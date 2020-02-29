package com.github.east196.terminator.xtend.bot;

import com.github.east196.terminator.xtend.bot.Bots;
import com.google.common.base.CaseFormat;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Generated;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class MongoBot {
  @Data
  public static class VisonTable {
    private final String gene;
    
    private final String klassType;
    
    private final String klassName;
    
    private final List<MongoBot.VisonField> fields;
    
    public VisonTable(final String gene, final String klassType, final String klassName, final List<MongoBot.VisonField> fields) {
      super();
      this.gene = gene;
      this.klassType = klassType;
      this.klassName = klassName;
      this.fields = fields;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.gene== null) ? 0 : this.gene.hashCode());
      result = prime * result + ((this.klassType== null) ? 0 : this.klassType.hashCode());
      result = prime * result + ((this.klassName== null) ? 0 : this.klassName.hashCode());
      result = prime * result + ((this.fields== null) ? 0 : this.fields.hashCode());
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
      MongoBot.VisonTable other = (MongoBot.VisonTable) obj;
      if (this.gene == null) {
        if (other.gene != null)
          return false;
      } else if (!this.gene.equals(other.gene))
        return false;
      if (this.klassType == null) {
        if (other.klassType != null)
          return false;
      } else if (!this.klassType.equals(other.klassType))
        return false;
      if (this.klassName == null) {
        if (other.klassName != null)
          return false;
      } else if (!this.klassName.equals(other.klassName))
        return false;
      if (this.fields == null) {
        if (other.fields != null)
          return false;
      } else if (!this.fields.equals(other.fields))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("gene", this.gene);
      b.add("klassType", this.klassType);
      b.add("klassName", this.klassName);
      b.add("fields", this.fields);
      return b.toString();
    }
    
    @Pure
    public String getGene() {
      return this.gene;
    }
    
    @Pure
    public String getKlassType() {
      return this.klassType;
    }
    
    @Pure
    public String getKlassName() {
      return this.klassName;
    }
    
    @Pure
    public List<MongoBot.VisonField> getFields() {
      return this.fields;
    }
  }
  
  @Data
  public static class VisonField {
    private final String name;
    
    private final String type;
    
    private final String require;
    
    private final String key;
    
    private final String comment;
    
    private final String show;
    
    public String javaName() {
      String _lowerCase = this.name.toLowerCase();
      return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, _lowerCase);
    }
    
    public String javaType() {
      String _switchResult = null;
      String _firstLower = StringExtensions.toFirstLower(this.type);
      switch (_firstLower) {
        case "bigint":
          _switchResult = "Integer";
          break;
        case "varchar":
          _switchResult = "String";
          break;
        case "datetime":
          _switchResult = "Date";
          break;
        case "int":
          _switchResult = "Integer";
          break;
        default:
          _switchResult = StringExtensions.toFirstUpper(this.type);
          break;
      }
      return _switchResult;
    }
    
    public CharSequence defaultValue() {
      CharSequence _switchResult = null;
      String _firstLower = StringExtensions.toFirstLower(this.type);
      boolean _matched = false;
      if (Objects.equal(_firstLower, "bigint")) {
        _matched=true;
        _switchResult = "99L";
      }
      if (!_matched) {
        if (Objects.equal(_firstLower, "varchar")) {
          _matched=true;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("\"SSS\"");
          _switchResult = _builder;
        }
      }
      if (!_matched) {
        if (Objects.equal(_firstLower, "datetime")) {
          _matched=true;
          _switchResult = "new Date()";
        }
      }
      if (!_matched) {
        if (Objects.equal(_firstLower, "date")) {
          _matched=true;
          _switchResult = "new Date()";
        }
      }
      if (!_matched) {
        if (Objects.equal(_firstLower, "int")) {
          _matched=true;
          _switchResult = "99";
        }
      }
      if (!_matched) {
        String _firstLower_1 = StringExtensions.toFirstLower(this.type);
        boolean _startsWith = _firstLower_1.startsWith("list");
        if (_startsWith) {
          _matched=true;
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("new Array");
          String _firstUpper = StringExtensions.toFirstUpper(this.type);
          _builder_1.append(_firstUpper, "");
          _builder_1.append("()");
          _switchResult = _builder_1;
        }
      }
      if (!_matched) {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("new ");
        String _firstUpper_1 = StringExtensions.toFirstUpper(this.type);
        _builder_2.append(_firstUpper_1, "");
        _builder_2.append("()");
        _switchResult = _builder_2;
      }
      return _switchResult;
    }
    
    public VisonField(final String name, final String type, final String require, final String key, final String comment, final String show) {
      super();
      this.name = name;
      this.type = type;
      this.require = require;
      this.key = key;
      this.comment = comment;
      this.show = show;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
      result = prime * result + ((this.type== null) ? 0 : this.type.hashCode());
      result = prime * result + ((this.require== null) ? 0 : this.require.hashCode());
      result = prime * result + ((this.key== null) ? 0 : this.key.hashCode());
      result = prime * result + ((this.comment== null) ? 0 : this.comment.hashCode());
      result = prime * result + ((this.show== null) ? 0 : this.show.hashCode());
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
      MongoBot.VisonField other = (MongoBot.VisonField) obj;
      if (this.name == null) {
        if (other.name != null)
          return false;
      } else if (!this.name.equals(other.name))
        return false;
      if (this.type == null) {
        if (other.type != null)
          return false;
      } else if (!this.type.equals(other.type))
        return false;
      if (this.require == null) {
        if (other.require != null)
          return false;
      } else if (!this.require.equals(other.require))
        return false;
      if (this.key == null) {
        if (other.key != null)
          return false;
      } else if (!this.key.equals(other.key))
        return false;
      if (this.comment == null) {
        if (other.comment != null)
          return false;
      } else if (!this.comment.equals(other.comment))
        return false;
      if (this.show == null) {
        if (other.show != null)
          return false;
      } else if (!this.show.equals(other.show))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("name", this.name);
      b.add("type", this.type);
      b.add("require", this.require);
      b.add("key", this.key);
      b.add("comment", this.comment);
      b.add("show", this.show);
      return b.toString();
    }
    
    @Pure
    public String getName() {
      return this.name;
    }
    
    @Pure
    public String getType() {
      return this.type;
    }
    
    @Pure
    public String getRequire() {
      return this.require;
    }
    
    @Pure
    public String getKey() {
      return this.key;
    }
    
    @Pure
    public String getComment() {
      return this.comment;
    }
    
    @Pure
    public String getShow() {
      return this.show;
    }
  }
  
  public static void main(final String[] args) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("E:\\backup\\xcode\\Mongo数据库设计文档.doc");
    String src = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("cn.device.mongo");
    final String basePackageName = _builder_1.toString();
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("E:\\workspace\\github\\east196\\java\\xcode\\src\\main\\");
    final String basePath = _builder_2.toString();
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("E:\\workspace\\github\\east196\\java\\xcode\\src\\main\\java\\cn\\device\\mongo\\");
    final String beanBasePath = _builder_3.toString();
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("E:\\workspace\\github\\east196\\java\\xcode\\src\\test\\java\\cn\\device\\mongo\\");
    final String beanTestBasePath = _builder_4.toString();
    final ArrayList<Table> tables = Bots.tables(src);
    int _size = tables.size();
    String _plus = ("--表格总数：" + Integer.valueOf(_size));
    InputOutput.<String>println(_plus);
    final Function1<Table, MongoBot.VisonTable> _function = (Table table) -> {
      int rowNum = table.numRows();
      InputOutput.<String>println(("表格行数：" + Integer.valueOf(rowNum)));
      ArrayList<MongoBot.VisonField> fields = CollectionLiterals.<MongoBot.VisonField>newArrayList();
      for (int j = 3; (j < rowNum); j++) {
        {
          TableRow row = table.getRow(j);
          TableCell _cell = row.getCell(0);
          String _text = _cell.text();
          String name = _text.trim();
          TableCell _cell_1 = row.getCell(1);
          String _text_1 = _cell_1.text();
          String type = _text_1.trim();
          TableCell _cell_2 = row.getCell(3);
          String _text_2 = _cell_2.text();
          String require = _text_2.trim();
          TableCell _cell_3 = row.getCell(4);
          String _text_3 = _cell_3.text();
          String key = _text_3.trim();
          TableCell _cell_4 = row.getCell(5);
          String _text_4 = _cell_4.text();
          String comment = _text_4.trim();
          TableCell _cell_5 = row.getCell(6);
          String _text_5 = _cell_5.text();
          String show = _text_5.trim();
          MongoBot.VisonField field = new MongoBot.VisonField(name, type, require, key, comment, show);
          fields.add(field);
        }
      }
      TableRow _row = table.getRow(1);
      TableCell _cell = _row.getCell(2);
      String _text = _cell.text();
      String klassType = _text.trim();
      TableRow _row_1 = table.getRow(1);
      TableCell _cell_1 = _row_1.getCell(3);
      String _text_1 = _cell_1.text();
      String klassName = _text_1.trim();
      TableRow _row_2 = table.getRow(1);
      TableCell _cell_2 = _row_2.getCell(4);
      String _text_2 = _cell_2.text();
      String gene = _text_2.trim();
      MongoBot.VisonTable visonTable = new MongoBot.VisonTable(gene, klassType, klassName, fields);
      return visonTable;
    };
    List<MongoBot.VisonTable> visonTables = ListExtensions.<Table, MongoBot.VisonTable>map(tables, _function);
    final Function1<MongoBot.VisonTable, Boolean> _function_1 = (MongoBot.VisonTable it) -> {
      return Boolean.valueOf(Objects.equal(it.gene, "Now"));
    };
    Iterable<MongoBot.VisonTable> _filter = IterableExtensions.<MongoBot.VisonTable>filter(visonTables, _function_1);
    final Consumer<MongoBot.VisonTable> _function_2 = (MongoBot.VisonTable visonTable) -> {
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("start gene   ");
      _builder_5.append(visonTable.klassType, "");
      InputOutput.<String>println(_builder_5.toString());
      String klassType = visonTable.klassType;
      CharSequence content = MongoBot.showList(basePackageName, visonTable);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append(basePath, "");
      _builder_6.append("resources\\static\\views\\");
      String _trim = klassType.trim();
      String _firstLower = StringExtensions.toFirstLower(_trim);
      _builder_6.append(_firstLower, "");
      _builder_6.append("\\");
      String _trim_1 = klassType.trim();
      String _firstLower_1 = StringExtensions.toFirstLower(_trim_1);
      _builder_6.append(_firstLower_1, "");
      _builder_6.append("List.html");
      String path = _builder_6.toString();
      Bots.copy(content, path);
      CharSequence _add = MongoBot.add(basePackageName, visonTable);
      content = _add;
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append(basePath, "");
      _builder_7.append("resources\\static\\views\\");
      String _trim_2 = klassType.trim();
      String _firstLower_2 = StringExtensions.toFirstLower(_trim_2);
      _builder_7.append(_firstLower_2, "");
      _builder_7.append("\\add");
      String _trim_3 = klassType.trim();
      String _firstUpper = StringExtensions.toFirstUpper(_trim_3);
      _builder_7.append(_firstUpper, "");
      _builder_7.append(".html");
      path = _builder_7.toString();
      Bots.copy(content, path);
      CharSequence _edit = MongoBot.edit(basePackageName, visonTable);
      content = _edit;
      StringConcatenation _builder_8 = new StringConcatenation();
      _builder_8.append(basePath, "");
      _builder_8.append("resources\\static\\views\\");
      String _trim_4 = klassType.trim();
      String _firstLower_3 = StringExtensions.toFirstLower(_trim_4);
      _builder_8.append(_firstLower_3, "");
      _builder_8.append("\\edit");
      String _trim_5 = klassType.trim();
      String _firstUpper_1 = StringExtensions.toFirstUpper(_trim_5);
      _builder_8.append(_firstUpper_1, "");
      _builder_8.append(".html");
      path = _builder_8.toString();
      Bots.copy(content, path);
      CharSequence _jsController = MongoBot.jsController(basePackageName, visonTable);
      content = _jsController;
      StringConcatenation _builder_9 = new StringConcatenation();
      _builder_9.append(basePath, "");
      _builder_9.append("resources\\static\\js\\controllers\\");
      String _trim_6 = klassType.trim();
      String _firstLower_4 = StringExtensions.toFirstLower(_trim_6);
      _builder_9.append(_firstLower_4, "");
      _builder_9.append("\\");
      String _trim_7 = klassType.trim();
      String _firstUpper_2 = StringExtensions.toFirstUpper(_trim_7);
      _builder_9.append(_firstUpper_2, "");
      _builder_9.append("Controller.js");
      path = _builder_9.toString();
      Bots.copy(content, path);
      CharSequence _dataTable = MongoBot.dataTable(basePackageName, visonTable);
      content = _dataTable;
      StringConcatenation _builder_10 = new StringConcatenation();
      _builder_10.append(basePath, "");
      _builder_10.append("resources\\static\\js\\scripts\\");
      String _trim_8 = klassType.trim();
      String _firstLower_5 = StringExtensions.toFirstLower(_trim_8);
      _builder_10.append(_firstLower_5, "");
      _builder_10.append("\\");
      String _trim_9 = klassType.trim();
      String _firstLower_6 = StringExtensions.toFirstLower(_trim_9);
      _builder_10.append(_firstLower_6, "");
      _builder_10.append("Table.js");
      path = _builder_10.toString();
      Bots.copy(content, path);
      CharSequence _bean = MongoBot.bean(basePackageName, visonTable);
      content = _bean;
      StringConcatenation _builder_11 = new StringConcatenation();
      _builder_11.append(beanBasePath, "");
      String _trim_10 = klassType.trim();
      String _firstLower_7 = StringExtensions.toFirstLower(_trim_10);
      _builder_11.append(_firstLower_7, "");
      _builder_11.append("\\");
      String _trim_11 = klassType.trim();
      String _firstUpper_3 = StringExtensions.toFirstUpper(_trim_11);
      _builder_11.append(_firstUpper_3, "");
      _builder_11.append(".java");
      path = _builder_11.toString();
      Bots.copy(content, path);
      CharSequence _service = MongoBot.service(basePackageName, visonTable);
      content = _service;
      StringConcatenation _builder_12 = new StringConcatenation();
      _builder_12.append(beanBasePath, "");
      String _trim_12 = klassType.trim();
      String _firstLower_8 = StringExtensions.toFirstLower(_trim_12);
      _builder_12.append(_firstLower_8, "");
      _builder_12.append("\\");
      String _trim_13 = klassType.trim();
      String _firstUpper_4 = StringExtensions.toFirstUpper(_trim_13);
      _builder_12.append(_firstUpper_4, "");
      _builder_12.append("Service.java");
      path = _builder_12.toString();
      Bots.copy(content, path);
      CharSequence _mongoServiceImpl = MongoBot.mongoServiceImpl(basePackageName, visonTable);
      content = _mongoServiceImpl;
      StringConcatenation _builder_13 = new StringConcatenation();
      _builder_13.append(beanBasePath, "");
      String _trim_14 = klassType.trim();
      String _firstLower_9 = StringExtensions.toFirstLower(_trim_14);
      _builder_13.append(_firstLower_9, "");
      _builder_13.append("\\");
      String _trim_15 = klassType.trim();
      String _firstUpper_5 = StringExtensions.toFirstUpper(_trim_15);
      _builder_13.append(_firstUpper_5, "");
      _builder_13.append("MongoServiceImpl.java");
      path = _builder_13.toString();
      Bots.copy(content, path);
      CharSequence _mongoDao = MongoBot.mongoDao(basePackageName, visonTable);
      content = _mongoDao;
      StringConcatenation _builder_14 = new StringConcatenation();
      _builder_14.append(beanBasePath, "");
      String _trim_16 = klassType.trim();
      String _firstLower_10 = StringExtensions.toFirstLower(_trim_16);
      _builder_14.append(_firstLower_10, "");
      _builder_14.append("\\");
      String _trim_17 = klassType.trim();
      String _firstUpper_6 = StringExtensions.toFirstUpper(_trim_17);
      _builder_14.append(_firstUpper_6, "");
      _builder_14.append("Mongo.java");
      path = _builder_14.toString();
      Bots.copy(content, path);
      CharSequence _mongoDaoImpl = MongoBot.mongoDaoImpl(basePackageName, visonTable);
      content = _mongoDaoImpl;
      StringConcatenation _builder_15 = new StringConcatenation();
      _builder_15.append(beanBasePath, "");
      String _trim_18 = klassType.trim();
      String _firstLower_11 = StringExtensions.toFirstLower(_trim_18);
      _builder_15.append(_firstLower_11, "");
      _builder_15.append("\\");
      String _trim_19 = klassType.trim();
      String _firstUpper_7 = StringExtensions.toFirstUpper(_trim_19);
      _builder_15.append(_firstUpper_7, "");
      _builder_15.append("MongoImpl.java");
      path = _builder_15.toString();
      Bots.copy(content, path);
      CharSequence _controller = MongoBot.controller(basePackageName, visonTable);
      content = _controller;
      StringConcatenation _builder_16 = new StringConcatenation();
      _builder_16.append(beanBasePath, "");
      String _trim_20 = klassType.trim();
      String _firstLower_12 = StringExtensions.toFirstLower(_trim_20);
      _builder_16.append(_firstLower_12, "");
      _builder_16.append("\\");
      String _trim_21 = klassType.trim();
      String _firstUpper_8 = StringExtensions.toFirstUpper(_trim_21);
      _builder_16.append(_firstUpper_8, "");
      _builder_16.append("Controller.java");
      path = _builder_16.toString();
      Bots.copy(content, path);
      CharSequence _validator = MongoBot.validator(basePackageName, visonTable);
      content = _validator;
      StringConcatenation _builder_17 = new StringConcatenation();
      _builder_17.append(beanBasePath, "");
      String _trim_22 = klassType.trim();
      String _firstLower_13 = StringExtensions.toFirstLower(_trim_22);
      _builder_17.append(_firstLower_13, "");
      _builder_17.append("\\");
      String _trim_23 = klassType.trim();
      String _firstUpper_9 = StringExtensions.toFirstUpper(_trim_23);
      _builder_17.append(_firstUpper_9, "");
      _builder_17.append("Validator.java");
      path = _builder_17.toString();
      Bots.copy(content, path);
      CharSequence _httpcaller = MongoBot.httpcaller(basePackageName, visonTable);
      content = _httpcaller;
      StringConcatenation _builder_18 = new StringConcatenation();
      _builder_18.append(beanTestBasePath, "");
      _builder_18.append("http\\");
      String _trim_24 = klassType.trim();
      String _firstUpper_10 = StringExtensions.toFirstUpper(_trim_24);
      _builder_18.append(_firstUpper_10, "");
      _builder_18.append("HttpCaller.java");
      path = _builder_18.toString();
      Bots.copy(content, path);
      CharSequence _httpcallertest = MongoBot.httpcallertest(basePackageName, visonTable);
      content = _httpcallertest;
      StringConcatenation _builder_19 = new StringConcatenation();
      _builder_19.append(beanTestBasePath, "");
      _builder_19.append("http\\");
      String _trim_25 = klassType.trim();
      String _firstUpper_11 = StringExtensions.toFirstUpper(_trim_25);
      _builder_19.append(_firstUpper_11, "");
      _builder_19.append("HttpCallerTest.java");
      path = _builder_19.toString();
      Bots.copy(content, path);
      InputOutput.<String>println("");
      CharSequence _appState = MongoBot.appState(basePackageName, visonTable);
      content = _appState;
      InputOutput.<CharSequence>println(content);
      InputOutput.<String>println("");
      CharSequence _sidebarLi = MongoBot.sidebarLi(basePackageName, visonTable);
      content = _sidebarLi;
      InputOutput.<CharSequence>print(content);
    };
    _filter.forEach(_function_2);
  }
  
  public static CharSequence appState(final String string, final MongoBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      String klassType = table.klassType;
      String klassName = StringExtensions.toFirstLower(table.klassType);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("         ");
      _builder.append("// ");
      _builder.append(table.klassName, "         ");
      _builder.newLineIfNotEmpty();
      _builder.append(".state(\'");
      _builder.append(klassName, "");
      _builder.append("List\', {");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("url: \"/");
      _builder.append(klassName, "    ");
      _builder.append("List.html\",");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("templateUrl: \"views/");
      _builder.append(klassName, "    ");
      _builder.append("/");
      _builder.append(klassName, "    ");
      _builder.append("List.html\",");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("data: {pageTitle: \'");
      _builder.append(table.klassName, "    ");
      _builder.append("\'},");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("controller: \"GeneralPageController\",");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("resolve: {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("deps : [ \'$ocLazyLoad\', function($ocLazyLoad) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("return $ocLazyLoad.load([ {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("name : \'angularFileUpload\',");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("files : [ \'assets/global/plugins/angularjs/plugins/angular-file-upload/angular-file-upload.min.js\']");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("},{");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("name : \'MetronicApp\',");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("insertBefore : \'#ng_load_plugins_before\', // load");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("files : [ \'js/controllers/GeneralPageController.js\',\'js/controllers/");
      _builder.append(klassName, "\t\t\t\t\t\t");
      _builder.append("/");
      _builder.append(klassType, "\t\t\t\t\t\t");
      _builder.append("Controller.js\',\'js/scripts/");
      _builder.append(klassName, "\t\t\t\t\t\t");
      _builder.append("/");
      _builder.append(klassName, "\t\t\t\t\t\t");
      _builder.append("Table.js\' ]");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t");
      _builder.append("} ]);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("} ]");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("})");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence sidebarLi(final String string, final MongoBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      String klassName = StringExtensions.toFirstLower(table.klassType);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<li>");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("<a href=\"#/");
      _builder.append(klassName, "    ");
      _builder.append("List.html\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("<i class=\"icon-home\"></i>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<span class=\"title\">");
      _builder.append(table.klassName, "\t\t\t");
      _builder.append("</span>");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("</a>");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("</li>");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence showList(final String basePackageName, final MongoBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      final Function1<MongoBot.VisonField, Boolean> _function = (MongoBot.VisonField it) -> {
        return Boolean.valueOf(it.show.contains("L"));
      };
      Iterable<MongoBot.VisonField> _filter = IterableExtensions.<MongoBot.VisonField>filter(table.fields, _function);
      final List<MongoBot.VisonField> fields = IterableExtensions.<MongoBot.VisonField>toList(_filter);
      final Function1<MongoBot.VisonField, Boolean> _function_1 = (MongoBot.VisonField it) -> {
        return Boolean.valueOf(it.show.contains("S"));
      };
      Iterable<MongoBot.VisonField> _filter_1 = IterableExtensions.<MongoBot.VisonField>filter(table.fields, _function_1);
      final List<MongoBot.VisonField> searchFields = IterableExtensions.<MongoBot.VisonField>toList(_filter_1);
      String klassType = table.klassType;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<div ng-controller=\"");
      String _firstUpper = StringExtensions.toFirstUpper(klassType);
      _builder.append(_firstUpper, "");
      _builder.append("Controller\">");
      _builder.newLineIfNotEmpty();
      _builder.append("<!-- BEGIN PAGE HEADER-->");
      _builder.newLine();
      _builder.append("<div class=\"form-search\">");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("<form action=\"#\" class=\"form-horizontal form-bordered\">");
      _builder.newLine();
      {
        for(final MongoBot.VisonField f : searchFields) {
          {
            int _indexOf = searchFields.indexOf(f);
            int _modulo = (_indexOf % 3);
            boolean _equals = (_modulo == 0);
            if (_equals) {
              _builder.append("\t\t\t    ");
              _builder.append("<div class=\"form-group\">");
              _builder.newLine();
            }
          }
          _builder.append("\t\t\t        ");
          _builder.append("<label class=\"col-sm-1 control-label\">");
          String[] _split = f.comment.split("-");
          String _get = _split[0];
          _builder.append(_get, "\t\t\t        ");
          _builder.append("：</label>");
          _builder.newLineIfNotEmpty();
          _builder.append("                    ");
          _builder.append("<div class=\"col-sm-3\">");
          _builder.newLine();
          _builder.append("                         ");
          String _parseSearchInput = MongoBot.parseSearchInput(table, f);
          _builder.append(_parseSearchInput, "                         ");
          _builder.newLineIfNotEmpty();
          _builder.append("                    ");
          _builder.append("</div>");
          _builder.newLine();
          {
            int _indexOf_1 = searchFields.indexOf(f);
            int _modulo_1 = (_indexOf_1 % 3);
            boolean _equals_1 = (_modulo_1 == 2);
            if (_equals_1) {
              _builder.append("</div>");
              _builder.newLine();
            }
          }
          {
            if (((searchFields.indexOf(f) == (((Object[])Conversions.unwrapArray(searchFields, Object.class)).length - 1)) && ((searchFields.indexOf(f) % 3) == 0))) {
              _builder.append(" ");
              _builder.append("<label class=\"col-sm-8 control-label\"><button class=\"btn red search-submit\">查询</button></label>");
              _builder.newLine();
              _builder.append("\t\t\t         ");
              _builder.append("</div>");
              _builder.newLine();
            }
          }
          {
            if (((searchFields.indexOf(f) == (((Object[])Conversions.unwrapArray(searchFields, Object.class)).length - 1)) && ((searchFields.indexOf(f) % 3) == 1))) {
              _builder.append("\t\t\t     ");
              _builder.append("<label class=\"col-sm-4 control-label\"><button class=\"btn red search-submit\">查询</button></label>");
              _builder.newLine();
              _builder.append("\t\t\t     ");
              _builder.append("    ");
              _builder.append("</div>");
              _builder.newLine();
            }
          }
          {
            if (((searchFields.indexOf(f) == (((Object[])Conversions.unwrapArray(searchFields, Object.class)).length - 1)) && ((searchFields.indexOf(f) % 3) == 2))) {
              _builder.append("\t\t\t         ");
              _builder.append("<div class=\"form-group\">");
              _builder.newLine();
              _builder.append("<label class=\"col-sm-12 control-label\"><button class=\"btn red search-submit\">查询</button></label>");
              _builder.newLine();
              _builder.append("\t\t\t         ");
              _builder.append("</div>");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\t\t");
      _builder.append("</form>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<!-- BEGIN MAIN CONTENT -->");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<div class=\"row\">");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("<!-- BEGIN EXAMPLE TABLE PORTLET-->");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("<div class=\"col-md-12 dev-msg\">");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<div class=\"portlet box blue-hoki\">");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("<div class=\"portlet-title\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("<div class=\"caption\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append(table.klassName, "\t\t\t\t\t\t");
      _builder.append("信息");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("<div class=\"actions\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t    ");
      _builder.append("<div class=\"btn-group\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("<a class=\"btn default btn-search\" href=\"#\">搜索<i");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("class=\"fa fa-angle-up\"></i></a>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("<div class=\"btn-group\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("<a class=\"btn default\" href=\"#\" data-toggle=\"dropdown\"> 字段<i");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("class=\"fa fa-angle-down\"></i>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("</a>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("<div id=\"");
      String _firstLower = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower, "\t\t\t\t\t\t\t");
      _builder.append("_sample_4_column_toggler\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("class=\"dropdown-menu hold-on-click dropdown-checkboxes pull-right\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("<label><input type=\"checkbox\" checked data-column=\"0\">序号</label>");
      _builder.newLine();
      {
        for(final MongoBot.VisonField f_1 : fields) {
          _builder.append("\t\t\t\t\t\t\t\t ");
          _builder.append("<label><input type=\"checkbox\" checked data-column=\"");
          int _indexOf_2 = fields.indexOf(f_1);
          int _plus = (_indexOf_2 + 1);
          _builder.append(_plus, "\t\t\t\t\t\t\t\t ");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t\t\t\t\t\t\t");
          _builder.append("value=\"");
          String _firstLower_1 = StringExtensions.toFirstLower(f_1.name);
          _builder.append(_firstLower_1, "\t\t\t\t\t\t\t\t\t");
          _builder.append("\">");
          String[] _split_1 = f_1.comment.split("-");
          String _get_1 = _split_1[0];
          _builder.append(_get_1, "\t\t\t\t\t\t\t\t\t");
          _builder.append("</label>");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("<div class=\"portlet-body\" ng-controller=\"");
      _builder.append(klassType, "\t\t\t\t");
      _builder.append("-BtnGroupController\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t");
      _builder.append("<div class=\"hs-btn-group\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("<button class=\"btn btn-primary btn-sm\" ng-click=\"add(\'lg\')\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("<i class=\"glyphicon glyphicon-plus\"></i>增加");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("</button>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("<button id=\"");
      String _firstLower_2 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_2, "\t\t\t\t\t\t");
      _builder.append("-editBtn\" class=\"btn btn-success btn-sm\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("ng-click=\"edit(\'lg\')\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("<i class=\"glyphicon glyphicon-pencil\"></i>修改");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("</button>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("<button id=\"");
      String _firstLower_3 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_3, "\t\t\t\t\t\t");
      _builder.append("-deleteBtn\" class=\"btn btn-danger btn-sm\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("ng-click=\"remove()\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("<i class=\"glyphicon glyphicon-trash\"></i>删除");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("</button>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("<table class=\"table table-striped table-bordered table-hover\"");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("id=\"");
      String _firstLower_4 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_4, "\t\t\t\t\t\t");
      _builder.append("-table\" width=\"100%\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("<thead>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("<tr>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("<th><input type=\"checkbox\" name=\"selectAll\"");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t");
      _builder.append("class=\"group-checkable\" data-set=\"#");
      String _firstLower_5 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_5, "\t\t\t\t\t\t\t\t\t");
      _builder.append("-table .checkboxes\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("</th>");
      _builder.newLine();
      {
        for(final MongoBot.VisonField f_2 : fields) {
          _builder.append("\t\t\t\t\t\t\t\t ");
          _builder.append("<th class=\"hidden-xs\">");
          String[] _split_2 = f_2.comment.split("-");
          String _get_2 = _split_2[0];
          _builder.append(_get_2, "\t\t\t\t\t\t\t\t ");
          _builder.append("</th>");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("</tr>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("</thead>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("</table>");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("<!-- END EXAMPLE TABLE PORTLET-->");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<!-- END MAIN CONTENT -->");
      _builder.newLine();
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("<!-- BEGIN MAIN JS -->");
      _builder.newLine();
      _builder.append("<script>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(klassType, "\t");
      _builder.append("TableAdvanced.init();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("ComponentsPickers.init(); // init todo page");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("ComponentsFormTools.init(); // init todo page");
      _builder.newLine();
      _builder.append("</script>");
      _builder.newLine();
      _builder.append("<!-- END MAIN JS -->");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence add(final String basePackageName, final MongoBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      final Function1<MongoBot.VisonField, Boolean> _function = (MongoBot.VisonField it) -> {
        return Boolean.valueOf(it.show.contains("C"));
      };
      Iterable<MongoBot.VisonField> _filter = IterableExtensions.<MongoBot.VisonField>filter(table.fields, _function);
      final List<MongoBot.VisonField> fields = IterableExtensions.<MongoBot.VisonField>toList(_filter);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<div class=\"modal-header\">");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("<h3 class=\"modal-title\">新增");
      _builder.append(table.klassName, "     ");
      _builder.append("信息</h3>");
      _builder.newLineIfNotEmpty();
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("<div class=\"modal-body\">");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<div class=\"portlet-body form\">");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("<!-- BEGIN FORM-->");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("<form action=\"#\" id=\"");
      String _firstLower = StringExtensions.toFirstLower(table.klassType);
      _builder.append(_firstLower, "\t\t\t\t");
      _builder.append("-add-form\" class=\"form-horizontal\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t");
      _builder.append("<div class=\"form-body\">");
      _builder.newLine();
      {
        for(final MongoBot.VisonField f : fields) {
          {
            int _indexOf = fields.indexOf(f);
            int _modulo = (_indexOf % 2);
            boolean _equals = (_modulo == 0);
            if (_equals) {
              _builder.append("\t\t\t          ");
              _builder.append("<div class=\"form-group\">");
              _builder.newLine();
            }
          }
          _builder.append("                           ");
          _builder.append("<div class=\"hs-td col-md-6\">");
          _builder.newLine();
          _builder.append("                                ");
          _builder.append("<label class=\"control-label col-md-4\">");
          String[] _split = f.comment.split("-");
          String _get = _split[0];
          _builder.append(_get, "                                ");
          _builder.newLineIfNotEmpty();
          {
            boolean _contains = f.require.contains("A");
            if (_contains) {
              _builder.append("\t");
              _builder.append("<span class=\"required\"> * </span>");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("</label>");
          _builder.newLine();
          _builder.append("                                ");
          _builder.append("<div class=\"col-md-8\">");
          _builder.newLine();
          _builder.append("                                \t");
          _builder.append("<div class=\"input-icon right\">");
          _builder.newLine();
          _builder.append("                               \t\t");
          _builder.append("<i class=\"fa\"></i> ");
          String _parseInput = MongoBot.parseInput(table, f);
          _builder.append(_parseInput, "                               \t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("                                \t");
          _builder.append("</div>");
          _builder.newLine();
          _builder.append("                                ");
          _builder.append("</div>");
          _builder.newLine();
          _builder.append("</div>");
          _builder.newLine();
          {
            if ((((fields.indexOf(f) % 2) == 1) || (fields.indexOf(f) == (((Object[])Conversions.unwrapArray(fields, Object.class)).length - 1)))) {
              _builder.append("\t\t\t\t     ");
              _builder.append("</div>");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\t\t\t        ");
      _builder.append("<div class=\"form-group\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t    ");
      _builder.append("<div id=\"message\" class=\"alert alert-danger display-hide\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t    ");
      _builder.append("<button class=\"close\" data-close=\"alert\"></button>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t    ");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t\t    ");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("<div class=\"form-actions\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("<div class=\"row\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("<div class=\"modal-footer\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("<!-- ng-click=\"ok() -->");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("<button type=\"submit\" class=\"btn btn-primary\">新增</button>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("<button type=\"button\" class=\"btn btn-danger\" ng-click=\"cancel()\">取消</button>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("</form>");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("<!-- END FORM-->");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<div class=\"modal-footer\"></div>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<!-- BEGIN MAIN JS -->");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<script>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ComponentsPickers.init();");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("</script>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<!-- END MAIN JS -->");
      _builder.newLine();
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence edit(final String basePackageName, final MongoBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      final Function1<MongoBot.VisonField, Boolean> _function = (MongoBot.VisonField it) -> {
        return Boolean.valueOf(it.show.contains("H"));
      };
      Iterable<MongoBot.VisonField> _filter = IterableExtensions.<MongoBot.VisonField>filter(table.fields, _function);
      final List<MongoBot.VisonField> hideFields = IterableExtensions.<MongoBot.VisonField>toList(_filter);
      final Function1<MongoBot.VisonField, Boolean> _function_1 = (MongoBot.VisonField it) -> {
        return Boolean.valueOf(it.show.contains("U"));
      };
      Iterable<MongoBot.VisonField> _filter_1 = IterableExtensions.<MongoBot.VisonField>filter(table.fields, _function_1);
      final List<MongoBot.VisonField> fields = IterableExtensions.<MongoBot.VisonField>toList(_filter_1);
      String klassType = table.klassType;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<div class=\"modal-header\">");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("<h3 class=\"modal-title\">编辑");
      _builder.append(table.klassName, "     ");
      _builder.append("信息</h3>");
      _builder.newLineIfNotEmpty();
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("<div class=\"modal-body\">");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<div class=\"portlet-body form\">");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("<!-- BEGIN FORM-->");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("<form action=\"#\" id=\"");
      String _firstLower = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower, "\t\t\t\t");
      _builder.append("-edit-form\" class=\"form-horizontal\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t");
      _builder.append("<div class=\"form-body\">");
      _builder.newLine();
      {
        for(final MongoBot.VisonField f : hideFields) {
          _builder.append("\t\t\t\t ");
          _builder.append("<input type=\"hidden\" class=\"form-control\" ng-model=\"");
          String _firstLower_1 = StringExtensions.toFirstLower(klassType);
          _builder.append(_firstLower_1, "\t\t\t\t ");
          _builder.append(".");
          String _firstLower_2 = StringExtensions.toFirstLower(f.name);
          _builder.append(_firstLower_2, "\t\t\t\t ");
          _builder.append("\" name=\"");
          String _firstLower_3 = StringExtensions.toFirstLower(f.name);
          _builder.append(_firstLower_3, "\t\t\t\t ");
          _builder.append("\" />");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        for(final MongoBot.VisonField f_1 : fields) {
          {
            int _indexOf = fields.indexOf(f_1);
            int _modulo = (_indexOf % 2);
            boolean _equals = (_modulo == 0);
            if (_equals) {
              _builder.append("\t\t\t          ");
              _builder.append("<div class=\"form-group\">");
              _builder.newLine();
            }
          }
          _builder.append("\t\t\t             ");
          _builder.append("<div class=\"hs-td col-md-6\">");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("<label class=\"control-label col-md-4\">");
          String[] _split = f_1.comment.split("-");
          String _get = _split[0];
          _builder.append(_get, "\t");
          _builder.newLineIfNotEmpty();
          {
            boolean _contains = f_1.require.contains("A");
            if (_contains) {
              _builder.append("\t");
              _builder.append("<span class=\"required\"> * </span>");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("</label>");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("<div class=\"col-md-8\">");
          _builder.newLine();
          _builder.append("\t\t");
          _builder.append("<div class=\"input-icon right\">");
          _builder.newLine();
          _builder.append("\t\t\t");
          _builder.append("<i class=\"fa\"></i> ");
          String _parseInput = MongoBot.parseInput(table, f_1);
          _builder.append(_parseInput, "\t\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("</div>");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("</div>");
          _builder.newLine();
          _builder.append("</div>");
          _builder.newLine();
          {
            if ((((fields.indexOf(f_1) % 2) == 1) || (fields.indexOf(f_1) == (((Object[])Conversions.unwrapArray(fields, Object.class)).length - 1)))) {
              _builder.append("</div>");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\t\t\t        ");
      _builder.append("<div class=\"form-group\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t    ");
      _builder.append("<div id=\"message\" class=\"alert alert-danger display-hide\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t    ");
      _builder.append("<button class=\"close\" data-close=\"alert\"></button>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t    ");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t\t    ");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("<div class=\"form-actions\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("<div class=\"row\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("<div class=\"modal-footer\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("<!-- ng-click=\"ok() -->");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("<button type=\"submit\" class=\"btn btn-primary\">修改</button>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t");
      _builder.append("<button type=\"button\" class=\"btn btn-danger\" ng-click=\"cancel()\">取消</button>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("</form>");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("<!-- END FORM-->");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<div class=\"modal-footer\"></div>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<!-- BEGIN MAIN JS -->");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<script>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ComponentsPickers.init();");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("</script>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<!-- END MAIN JS -->");
      _builder.newLine();
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence jsController(final String basePackageName, final MongoBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      final Function1<MongoBot.VisonField, Boolean> _function = (MongoBot.VisonField it) -> {
        return Boolean.valueOf(it.key.contains("P"));
      };
      MongoBot.VisonField _findFirst = IterableExtensions.<MongoBot.VisonField>findFirst(table.fields, _function);
      final String key = StringExtensions.toFirstLower(_findFirst.name);
      String klassType = table.klassType;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\'use strict\';");
      _builder.newLine();
      _builder.newLine();
      _builder.append("MetronicApp.controller(\'");
      String _firstUpper = StringExtensions.toFirstUpper(klassType);
      _builder.append(_firstUpper, "");
      _builder.append("Controller\', function($rootScope, $scope, $http, $timeout) {");
      _builder.newLineIfNotEmpty();
      {
        final Function1<MongoBot.VisonField, Boolean> _function_1 = (MongoBot.VisonField it) -> {
          return Boolean.valueOf(it.comment.contains("-select"));
        };
        Iterable<MongoBot.VisonField> _filter = IterableExtensions.<MongoBot.VisonField>filter(table.fields, _function_1);
        List<MongoBot.VisonField> _list = IterableExtensions.<MongoBot.VisonField>toList(_filter);
        for(final MongoBot.VisonField f : _list) {
          {
            String[] _split = f.comment.split("-");
            int _length = _split.length;
            boolean _greaterThan = (_length > 2);
            if (_greaterThan) {
              _builder.append("$http.get(\'/controller/v1/");
              String[] _split_1 = f.comment.split("-");
              String _get = _split_1[2];
              String _firstLower = StringExtensions.toFirstLower(_get);
              _builder.append(_firstLower, "");
              _builder.append("/\', \"\").success(function(data, status, headers, config) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("if (data.errcode == \'0\') {");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("$scope.");
              String[] _split_2 = f.comment.split("-");
              String _get_1 = _split_2[2];
              String _firstLower_1 = StringExtensions.toFirstLower(_get_1);
              _builder.append(_firstLower_1, "\t\t");
              _builder.append("s = data.data;");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("} else {");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("notific(\"错误\", data.errmsg, 5000);");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("}).error(function(data, status, headers, config) {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("notific(\"错误\", \"请求失败！\", 5000);");
              _builder.newLine();
              _builder.append("});");
              _builder.newLine();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("$scope.$watch(\'lastModifyTime\', function(newValue, oldValue) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("$scope.lastModifyTime_LTE = moment($scope.lastModifyTime).add(1, \'days\').format(\"YYYY-MM-DD\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("});");
      _builder.newLine();
      {
        final Function1<MongoBot.VisonField, Boolean> _function_2 = (MongoBot.VisonField it) -> {
          return Boolean.valueOf(it.comment.contains("-date"));
        };
        Iterable<MongoBot.VisonField> _filter_1 = IterableExtensions.<MongoBot.VisonField>filter(table.fields, _function_2);
        List<MongoBot.VisonField> _list_1 = IterableExtensions.<MongoBot.VisonField>toList(_filter_1);
        for(final MongoBot.VisonField f_1 : _list_1) {
          _builder.append("$scope.$watch(\'");
          String[] _split_3 = f_1.comment.split("-");
          String _get_2 = _split_3[0];
          String _firstLower_2 = StringExtensions.toFirstLower(_get_2);
          _builder.append(_firstLower_2, "");
          _builder.append("\', function(newValue, oldValue) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("$scope.");
          String[] _split_4 = f_1.comment.split("-");
          String _get_3 = _split_4[0];
          String _firstLower_3 = StringExtensions.toFirstLower(_get_3);
          _builder.append(_firstLower_3, "\t");
          _builder.append("_LTE = moment($scope.");
          String[] _split_5 = f_1.comment.split("-");
          String _get_4 = _split_5[0];
          String _firstLower_4 = StringExtensions.toFirstLower(_get_4);
          _builder.append(_firstLower_4, "\t");
          _builder.append(").add(1, \'days\').format(\"YYYY-MM-DD\")");
          _builder.newLineIfNotEmpty();
          _builder.append("});");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("$scope.getCitys = function() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (null != $scope.provice && \"undefined\" != $scope.provice) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("var citys = _.find($scope.proviceCitys, function(d) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return d.text == $scope.provice;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}).children;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("$scope.citys = _.map(citys, function(d) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return d.text;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      _builder.append("});");
      _builder.newLine();
      _builder.newLine();
      _builder.append("MetronicApp.controller(\'");
      _builder.append(klassType, "");
      _builder.append("-BtnGroupController\', function($rootScope, $scope, $http, $modal, $log) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("// 新增");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("$scope.add = function(size) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var modalInstance = $modal.open({");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("templateUrl : \'views/");
      String _firstLower_5 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_5, "\t\t\t");
      _builder.append("/add");
      String _firstUpper_1 = StringExtensions.toFirstUpper(klassType);
      _builder.append(_firstUpper_1, "\t\t\t");
      _builder.append(".html\',");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("controller : \'Add");
      String _firstUpper_2 = StringExtensions.toFirstUpper(klassType);
      _builder.append(_firstUpper_2, "\t\t\t");
      _builder.append("Controller\',");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("size : size,");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("backdrop : \'static\',");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("resolve : {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("items : function() {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("return $scope.items;");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("};");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// 编辑");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("$scope.edit = function(size) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// 获取选中值");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var temp = $(\"tbody tr input:checkbox:checked\").map(function() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return $(this).val();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}).toArray();");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (temp.length == 0) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("prompt(\"警告\", \"请选择！\");");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("var id = temp[0];");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("var modalInstance = $modal.open({");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("templateUrl : \'views/");
      String _firstLower_6 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_6, "\t\t\t\t");
      _builder.append("/edit");
      String _firstUpper_3 = StringExtensions.toFirstUpper(klassType);
      _builder.append(_firstUpper_3, "\t\t\t\t");
      _builder.append(".html\',");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("controller : \'Edit");
      String _firstUpper_4 = StringExtensions.toFirstUpper(klassType);
      _builder.append(_firstUpper_4, "\t\t\t\t");
      _builder.append("Controller\',");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("size : size,");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("backdrop : \'static\',");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("resolve : {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("items : function() {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("return id;");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// 删除");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("$scope.remove = function() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// 获取选中值");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var temp = $(\"tbody tr input:checkbox:checked\").map(function() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return $(this).val();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}).toArray();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (temp.length == 0) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("prompt(\"警告\", \"请选择！\");");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("confirm(\"提示\", \"确认删除?\", function() {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$http.post(\'/controller/v1/");
      String _firstLower_7 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_7, "\t\t\t\t");
      _builder.append("/deletes\', temp, \'\').success(function(data, status, headers, config) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t");
      _builder.append("notific(\"提示\", \"删除成功！\", 5000);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append(klassType, "\t\t\t\t\t");
      _builder.append("TableAdvanced.reload();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("}).error(function(data, status, headers, config) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("notific(\"错误\", \"删除失败！\", 5000);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("};");
      _builder.newLine();
      _builder.append("});");
      _builder.newLine();
      _builder.newLine();
      _builder.append("// 新增");
      _builder.newLine();
      _builder.append("MetronicApp.controller(\'Add");
      String _firstUpper_5 = StringExtensions.toFirstUpper(klassType);
      _builder.append(_firstUpper_5, "");
      _builder.append("Controller\', function($scope, $modalInstance, $http, items) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("$scope.obj = items;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("$scope.$watch(\'$viewContentLoaded\', function() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("handleWysihtml5();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("handleValidation();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("});");
      _builder.newLine();
      {
        final Function1<MongoBot.VisonField, Boolean> _function_3 = (MongoBot.VisonField it) -> {
          return Boolean.valueOf(it.comment.contains("-select"));
        };
        Iterable<MongoBot.VisonField> _filter_2 = IterableExtensions.<MongoBot.VisonField>filter(table.fields, _function_3);
        List<MongoBot.VisonField> _list_2 = IterableExtensions.<MongoBot.VisonField>toList(_filter_2);
        for(final MongoBot.VisonField f_2 : _list_2) {
          {
            String[] _split_6 = f_2.comment.split("-");
            int _length_1 = _split_6.length;
            boolean _greaterThan_1 = (_length_1 > 2);
            if (_greaterThan_1) {
              _builder.append("$http.get(\'/controller/v1/");
              String[] _split_7 = f_2.comment.split("-");
              String _get_5 = _split_7[2];
              String _firstLower_8 = StringExtensions.toFirstLower(_get_5);
              _builder.append(_firstLower_8, "");
              _builder.append("/\', \"\").success(function(data, status, headers, config) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("if (data.errcode == \'0\') {");
              _builder.newLine();
              _builder.append("\t\t\t");
              _builder.append("$scope.");
              String[] _split_8 = f_2.comment.split("-");
              String _get_6 = _split_8[2];
              String _firstLower_9 = StringExtensions.toFirstLower(_get_6);
              _builder.append(_firstLower_9, "\t\t\t");
              _builder.append("s = data.data;");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("} else {");
              _builder.newLine();
              _builder.append("\t\t\t");
              _builder.append("notific(\"错误\", data.errmsg, 5000);");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}).error(function(data, status, headers, config) {");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("notific(\"错误\", \"请求失败！\", 5000);");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("});");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\t");
      _builder.append("$scope.ok = function() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("$modalInstance.close($scope.obj);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("$scope.cancel = function() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("$modalInstance.dismiss(\'cancel\');");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var handleWysihtml5 = function() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (!jQuery().wysihtml5) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if ($(\'.wysihtml5\').size() > 0) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("$(\'.wysihtml5\').wysihtml5({");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("\"stylesheets\" : [ \"../../assets/global/plugins/bootstrap-wysihtml5/wysiwyg-color.css\" ]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// validation using icons");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var handleValidation = function() {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var form2 = $(\'#");
      String _firstLower_10 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_10, "\t\t");
      _builder.append("-add-form\');");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("form2.validate({");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("errorElement : \'span\',");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("errorClass : \'help-block help-block-error\',");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("focusInvalid : false,");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ignore : \"\",");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("rules : {");
      _builder.newLine();
      {
        final Function1<MongoBot.VisonField, Boolean> _function_4 = (MongoBot.VisonField it) -> {
          String _upperCase = it.require.toUpperCase();
          return Boolean.valueOf(_upperCase.contains("A"));
        };
        Iterable<MongoBot.VisonField> _filter_3 = IterableExtensions.<MongoBot.VisonField>filter(table.fields, _function_4);
        List<MongoBot.VisonField> _list_3 = IterableExtensions.<MongoBot.VisonField>toList(_filter_3);
        for(final MongoBot.VisonField f_3 : _list_3) {
          _builder.append("\t\t\t\t");
          _builder.append(f_3.name, "\t\t\t\t");
          _builder.append(" : {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t\t");
          _builder.append("\t");
          _builder.append("required : true");
          _builder.newLine();
          _builder.append("\t\t\t\t");
          _builder.append("},");
          _builder.newLine();
        }
      }
      _builder.append("\t\t\t");
      _builder.append("},");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("messages : {");
      _builder.newLine();
      {
        final Function1<MongoBot.VisonField, Boolean> _function_5 = (MongoBot.VisonField it) -> {
          String _upperCase = it.require.toUpperCase();
          return Boolean.valueOf(_upperCase.contains("A"));
        };
        Iterable<MongoBot.VisonField> _filter_4 = IterableExtensions.<MongoBot.VisonField>filter(table.fields, _function_5);
        List<MongoBot.VisonField> _list_4 = IterableExtensions.<MongoBot.VisonField>toList(_filter_4);
        for(final MongoBot.VisonField f_4 : _list_4) {
          _builder.append("\t\t\t\t");
          _builder.append(f_4.name, "\t\t\t\t");
          _builder.append(" : {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t\t");
          _builder.append("\t");
          _builder.append("required : \"请输入");
          String[] _split_9 = f_4.comment.split("-");
          String _get_7 = _split_9[0];
          _builder.append(_get_7, "\t\t\t\t\t");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t\t");
          _builder.append("},");
          _builder.newLine();
        }
      }
      _builder.append("\t\t\t");
      _builder.append("},");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("invalidHandler : function(event, validator) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("//Metronic.scrollTo(error2, -200);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("},");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("errorPlacement : function(error, element) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("var icon = $(element).parent(\'.input-icon\').children(\'i\');");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("icon.removeClass(\'fa-check\').addClass(\"fa-warning\");");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("icon.attr(\"data-original-title\", error.text()).tooltip({");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("\'container\' : \'.modal-body\'");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("},");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("highlight : function(element) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$(element).closest(\'.hs-td\').removeClass(\"has-success\").addClass(\'has-error\');");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("},");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("unhighlight : function(element) {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("},");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("success : function(label, element) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("var icon = $(element).parent(\'.input-icon\').children(\'i\');");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$(element).closest(\'.hs-td\').removeClass(\'has-error\').addClass(\'has-success\');");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("icon.removeClass(\"fa-warning\").addClass(\"fa-check\");");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("},");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("submitHandler : function(form) {");
      _builder.newLine();
      {
        final Function1<MongoBot.VisonField, Boolean> _function_6 = (MongoBot.VisonField it) -> {
          return Boolean.valueOf(it.comment.contains("-select"));
        };
        Iterable<MongoBot.VisonField> _filter_5 = IterableExtensions.<MongoBot.VisonField>filter(table.fields, _function_6);
        List<MongoBot.VisonField> _list_5 = IterableExtensions.<MongoBot.VisonField>toList(_filter_5);
        for(final MongoBot.VisonField f_5 : _list_5) {
          {
            String[] _split_10 = f_5.comment.split("-");
            int _length_2 = _split_10.length;
            boolean _greaterThan_2 = (_length_2 > 2);
            if (_greaterThan_2) {
              _builder.append("$scope.");
              String _firstLower_11 = StringExtensions.toFirstLower(klassType);
              _builder.append(_firstLower_11, "");
              _builder.append(".");
              String[] _split_11 = f_5.comment.split("-");
              String _get_8 = _split_11[2];
              String _firstLower_12 = StringExtensions.toFirstLower(_get_8);
              _builder.append(_firstLower_12, "");
              _builder.append(" = $scope.");
              String[] _split_12 = f_5.comment.split("-");
              String _get_9 = _split_12[2];
              String _firstLower_13 = StringExtensions.toFirstLower(_get_9);
              _builder.append(_firstLower_13, "");
              _builder.append(".id;");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("                ");
      _builder.append("$(\"#message\").hide();");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$http.post(\'/controller/v1/");
      String _firstLower_14 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_14, "\t\t\t\t");
      _builder.append("/\', $scope.");
      String _firstLower_15 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_15, "\t\t\t\t");
      _builder.append(", \'\').success(function(data, status, headers, config) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t");
      _builder.append("if (\"0\" == data.errcode) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("$modalInstance.close($scope.obj);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t    ");
      _builder.append("notific(\"提示\", \"新增成功！\", 5000);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t    ");
      _builder.append(klassType, "\t\t\t\t\t    ");
      _builder.append("TableAdvanced.reload();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("$(\"#message\").show();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("$(\"#message\").text(data.errmsg);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}).error(function(data, status, headers, config) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("notific(\"提示\", \"新增失败！\", 5000);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("});");
      _builder.newLine();
      _builder.newLine();
      _builder.append("// 编辑");
      _builder.newLine();
      _builder.append("MetronicApp.controller(\'Edit");
      String _firstUpper_6 = StringExtensions.toFirstUpper(klassType);
      _builder.append(_firstUpper_6, "");
      _builder.append("Controller\', function($scope, $modalInstance, $http, items) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("var id = items;");
      _builder.newLine();
      {
        final Function1<MongoBot.VisonField, Boolean> _function_7 = (MongoBot.VisonField it) -> {
          return Boolean.valueOf(it.comment.contains("-select"));
        };
        Iterable<MongoBot.VisonField> _filter_6 = IterableExtensions.<MongoBot.VisonField>filter(table.fields, _function_7);
        List<MongoBot.VisonField> _list_6 = IterableExtensions.<MongoBot.VisonField>toList(_filter_6);
        for(final MongoBot.VisonField f_6 : _list_6) {
          {
            String[] _split_13 = f_6.comment.split("-");
            int _length_3 = _split_13.length;
            boolean _greaterThan_3 = (_length_3 > 2);
            if (_greaterThan_3) {
              _builder.append("$scope.");
              String[] _split_14 = f_6.comment.split("-");
              String _get_10 = _split_14[2];
              String _firstLower_16 = StringExtensions.toFirstLower(_get_10);
              _builder.append(_firstLower_16, "");
              _builder.append("s = [];");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("$http.get(\'/controller/v1/");
              String[] _split_15 = f_6.comment.split("-");
              String _get_11 = _split_15[2];
              String _firstLower_17 = StringExtensions.toFirstLower(_get_11);
              _builder.append(_firstLower_17, "\t");
              _builder.append("/\', \"\").success(function(data, status, headers, config) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("if (data.errcode == \'0\') {");
              _builder.newLine();
              _builder.append("\t\t\t");
              _builder.append("$scope.");
              String[] _split_16 = f_6.comment.split("-");
              String _get_12 = _split_16[2];
              String _firstLower_18 = StringExtensions.toFirstLower(_get_12);
              _builder.append(_firstLower_18, "\t\t\t");
              _builder.append("s = data.data;");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("} else {");
              _builder.newLine();
              _builder.append("\t\t\t");
              _builder.append("notific(\"错误\", data.errmsg, 5000);");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("}");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("}).error(function(data, status, headers, config) {");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("notific(\"错误\", \"请求失败！\", 5000);");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("});");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\t");
      _builder.append("$http.get(\'/controller/v1/");
      String _firstLower_19 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_19, "\t");
      _builder.append("/?");
      _builder.append(key, "\t");
      _builder.append("_EQ=\' + id, \"\").success(function(data, status, headers, config) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("if (data.errcode == \'0\') {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("$scope.");
      String _firstLower_20 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_20, "\t\t\t");
      _builder.append(" = data.data[0];");
      _builder.newLineIfNotEmpty();
      {
        final Function1<MongoBot.VisonField, Boolean> _function_8 = (MongoBot.VisonField it) -> {
          return Boolean.valueOf(it.comment.contains("-select"));
        };
        Iterable<MongoBot.VisonField> _filter_7 = IterableExtensions.<MongoBot.VisonField>filter(table.fields, _function_8);
        List<MongoBot.VisonField> _list_7 = IterableExtensions.<MongoBot.VisonField>toList(_filter_7);
        for(final MongoBot.VisonField f_7 : _list_7) {
          {
            String[] _split_17 = f_7.comment.split("-");
            int _length_4 = _split_17.length;
            boolean _greaterThan_4 = (_length_4 > 2);
            if (_greaterThan_4) {
              _builder.append("$scope.");
              String[] _split_18 = f_7.comment.split("-");
              String _get_13 = _split_18[2];
              String _firstLower_21 = StringExtensions.toFirstLower(_get_13);
              _builder.append(_firstLower_21, "");
              _builder.append(" = _.find($scope.");
              String[] _split_19 = f_7.comment.split("-");
              String _get_14 = _split_19[2];
              String _firstLower_22 = StringExtensions.toFirstLower(_get_14);
              _builder.append(_firstLower_22, "");
              _builder.append("s, function(n) {");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t");
              _builder.append("return n.id == $scope.");
              String _firstLower_23 = StringExtensions.toFirstLower(klassType);
              _builder.append(_firstLower_23, "\t\t\t");
              _builder.append(".");
              String[] _split_20 = f_7.comment.split("-");
              String _get_15 = _split_20[2];
              String _firstLower_24 = StringExtensions.toFirstLower(_get_15);
              _builder.append(_firstLower_24, "\t\t\t");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("});");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("notific(\"错误\", data.errmsg, 5000);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}).error(function(data, status, headers, config) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("notific(\"错误\", \"请求失败！\", 5000);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("$scope.$watch(\'$viewContentLoaded\', function() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("handleWysihtml5();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("handleValidation();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("});");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("$scope.ok = function() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("$modalInstance.close($scope.obj);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("$scope.cancel = function() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("$modalInstance.dismiss(\'cancel\');");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("};");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var handleWysihtml5 = function() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if (!jQuery().wysihtml5) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("if ($(\'.wysihtml5\').size() > 0) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("$(\'.wysihtml5\').wysihtml5({");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("\"stylesheets\" : [ \"../../assets/global/plugins/bootstrap-wysihtml5/wysiwyg-color.css\" ]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var handleValidation = function() {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var form2 = $(\'#");
      String _firstLower_25 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_25, "\t\t");
      _builder.append("-edit-form\');");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("form2.validate({");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("errorElement : \'span\',");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("errorClass : \'help-block help-block-error\',");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("focusInvalid : false,");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ignore : \"\",");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("rules : {");
      _builder.newLine();
      {
        final Function1<MongoBot.VisonField, Boolean> _function_9 = (MongoBot.VisonField it) -> {
          String _upperCase = it.require.toUpperCase();
          return Boolean.valueOf(_upperCase.contains("A"));
        };
        Iterable<MongoBot.VisonField> _filter_8 = IterableExtensions.<MongoBot.VisonField>filter(table.fields, _function_9);
        List<MongoBot.VisonField> _list_8 = IterableExtensions.<MongoBot.VisonField>toList(_filter_8);
        for(final MongoBot.VisonField f_8 : _list_8) {
          _builder.append("\t\t\t\t");
          _builder.append(f_8.name, "\t\t\t\t");
          _builder.append(" : {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t\t");
          _builder.append("\t");
          _builder.append("required : true");
          _builder.newLine();
          _builder.append("\t\t\t\t");
          _builder.append("},");
          _builder.newLine();
        }
      }
      _builder.append("\t\t\t");
      _builder.append("},");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("messages : {");
      _builder.newLine();
      {
        final Function1<MongoBot.VisonField, Boolean> _function_10 = (MongoBot.VisonField it) -> {
          String _upperCase = it.require.toUpperCase();
          return Boolean.valueOf(_upperCase.contains("A"));
        };
        Iterable<MongoBot.VisonField> _filter_9 = IterableExtensions.<MongoBot.VisonField>filter(table.fields, _function_10);
        List<MongoBot.VisonField> _list_9 = IterableExtensions.<MongoBot.VisonField>toList(_filter_9);
        for(final MongoBot.VisonField f_9 : _list_9) {
          _builder.append("\t\t\t\t");
          _builder.append(f_9.name, "\t\t\t\t");
          _builder.append(" : {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t\t");
          _builder.append("\t");
          _builder.append("required : \"请输入");
          String[] _split_21 = f_9.comment.split("-");
          String _get_16 = _split_21[0];
          _builder.append(_get_16, "\t\t\t\t\t");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t\t");
          _builder.append("},");
          _builder.newLine();
        }
      }
      _builder.append("\t\t\t");
      _builder.append("},");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("invalidHandler : function(event, validator) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("//Metronic.scrollTo(error2, -200);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("},");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("errorPlacement : function(error, element) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("var icon = $(element).parent(\'.input-icon\').children(\'i\');");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("icon.removeClass(\'fa-check\').addClass(\"fa-warning\");");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("icon.attr(\"data-original-title\", error.text()).tooltip({");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("\'container\' : \'.modal-body\'");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("},");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("highlight : function(element) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$(element).closest(\'.hs-td\').removeClass(\"has-success\").addClass(\'has-error\');");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("},");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("unhighlight : function(element) {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("},");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("success : function(label, element) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("var icon = $(element).parent(\'.input-icon\').children(\'i\');");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$(element).closest(\'.hs-td\').removeClass(\'has-error\').addClass(\'has-success\');");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("icon.removeClass(\"fa-warning\").addClass(\"fa-check\");");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("},");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("submitHandler : function(form) {");
      _builder.newLine();
      {
        final Function1<MongoBot.VisonField, Boolean> _function_11 = (MongoBot.VisonField it) -> {
          return Boolean.valueOf(it.comment.contains("-select"));
        };
        Iterable<MongoBot.VisonField> _filter_10 = IterableExtensions.<MongoBot.VisonField>filter(table.fields, _function_11);
        List<MongoBot.VisonField> _list_10 = IterableExtensions.<MongoBot.VisonField>toList(_filter_10);
        for(final MongoBot.VisonField f_10 : _list_10) {
          {
            String[] _split_22 = f_10.comment.split("-");
            int _length_5 = _split_22.length;
            boolean _greaterThan_5 = (_length_5 > 2);
            if (_greaterThan_5) {
              _builder.append("$scope.");
              String _firstLower_26 = StringExtensions.toFirstLower(klassType);
              _builder.append(_firstLower_26, "");
              _builder.append(".");
              String[] _split_23 = f_10.comment.split("-");
              String _get_17 = _split_23[2];
              String _firstLower_27 = StringExtensions.toFirstLower(_get_17);
              _builder.append(_firstLower_27, "");
              _builder.append(" = $scope.");
              String[] _split_24 = f_10.comment.split("-");
              String _get_18 = _split_24[2];
              String _firstLower_28 = StringExtensions.toFirstLower(_get_18);
              _builder.append(_firstLower_28, "");
              _builder.append(".id;");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("                ");
      _builder.append("$(\"#message\").hide();");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$http.post(\'/controller/v1/");
      String _firstLower_29 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_29, "\t\t\t\t");
      _builder.append("/\', $scope.");
      String _firstLower_30 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_30, "\t\t\t\t");
      _builder.append(", \'\').success(function(data, status, headers, config) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t");
      _builder.append("if (\"0\" == data.errcode) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("$modalInstance.close($scope.obj);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t    ");
      _builder.append("notific(\"提示\", \"修改成功！\", 5000);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t    ");
      _builder.append(klassType, "\t\t\t\t\t    ");
      _builder.append("TableAdvanced.reload();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("$(\"#message\").show();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("$(\"#message\").text(data.errmsg);");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}).error(function(data, status, headers, config) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("notific(\"提示\", \"修改失败！\", 5000);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("});");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence dataTable(final String basePackageName, final MongoBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      final Function1<MongoBot.VisonField, Boolean> _function = (MongoBot.VisonField it) -> {
        return Boolean.valueOf(it.key.contains("P"));
      };
      MongoBot.VisonField _findFirst = IterableExtensions.<MongoBot.VisonField>findFirst(table.fields, _function);
      final String key = StringExtensions.toFirstLower(_findFirst.name);
      final Function1<MongoBot.VisonField, Boolean> _function_1 = (MongoBot.VisonField it) -> {
        return Boolean.valueOf(it.show.contains("L"));
      };
      Iterable<MongoBot.VisonField> _filter = IterableExtensions.<MongoBot.VisonField>filter(table.fields, _function_1);
      final List<MongoBot.VisonField> fields = IterableExtensions.<MongoBot.VisonField>toList(_filter);
      String klassType = table.klassType;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("var ");
      _builder.append(klassType, "");
      _builder.append("TableAdvanced = function() {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("var oTable;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var initTable = function() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var table = $(\'#");
      String _firstLower = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower, "\t\t");
      _builder.append("-table\');");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("oTable = table.DataTable({");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\"scrollX\" : true,");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\"ajax\" : {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("\"url\" : \"/controller/v1/");
      String _firstLower_1 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_1, "\t\t\t\t");
      _builder.append("/page\",");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("\"type\" : \"POST\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("},");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\"columnDefs\" : [");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("\"searchable\" : false,");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("\"orderable\" : false,");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("\"targets\" : 0");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("},");
      {
        for(final MongoBot.VisonField f : fields) {
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t\t\t");
          {
            String _javaType = f.javaType();
            String _upperCase = _javaType.toUpperCase();
            boolean _equals = _upperCase.equals("DATE");
            if (_equals) {
              _builder.append("{");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t\t\t");
              _builder.append("\t");
              _builder.append("\"render\" : function(data, type, row) {");
              _builder.newLine();
              _builder.append("\t\t\t\t\t");
              _builder.append("\t\t");
              _builder.append("return moment(data).format(\"YYYY-MM-DD HH:mm:ss\");");
              _builder.newLine();
              _builder.append("\t\t\t\t\t");
              _builder.append("\t");
              _builder.append("},");
              _builder.newLine();
              _builder.append("\t\t\t\t\t");
              _builder.append("\t");
              _builder.append("\"targets\" : ");
              int _indexOf = fields.indexOf(f);
              int _plus = (_indexOf + 1);
              _builder.append(_plus, "\t\t\t\t\t\t");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t\t\t");
              _builder.append("}");
              {
                int _indexOf_1 = fields.indexOf(f);
                int _length = ((Object[])Conversions.unwrapArray(fields, Object.class)).length;
                int _minus = (_length - 1);
                boolean _notEquals = (_indexOf_1 != _minus);
                if (_notEquals) {
                  _builder.append(",");
                }
              }
            }
          }
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t    ");
      _builder.append("],");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\"columns\" : [");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("\"data\" : function(data) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t");
      _builder.append("return \'<label class=\"checkbox\"><div class=\"checker \"><span class=\"\"><input type=\"checkbox\" class=\"checkboxes\" value=\"\' + data.");
      _builder.append(key, "\t\t\t\t\t\t\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t\t\t\t\t");
      _builder.append("+ \'\"/></span></div><span class=\"index-number\"></span></label>\';");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("},");
      {
        for(final MongoBot.VisonField f_1 : fields) {
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t\t\t");
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t\t\t\t\t");
          _builder.append("    ");
          _builder.append("\"data\" : \"");
          String _firstLower_2 = StringExtensions.toFirstLower(f_1.name);
          _builder.append(_firstLower_2, "\t\t\t\t\t    ");
          _builder.append("\",");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t\t\t");
          _builder.append("    ");
          _builder.append("\"defaultContent\" : \"\"");
          _builder.newLine();
          _builder.append("\t\t\t\t\t");
          _builder.append("}");
          {
            int _indexOf_2 = fields.indexOf(f_1);
            int _length_1 = ((Object[])Conversions.unwrapArray(fields, Object.class)).length;
            int _minus_1 = (_length_1 - 1);
            boolean _notEquals_1 = (_indexOf_2 != _minus_1);
            if (_notEquals_1) {
              _builder.append(",");
            }
          }
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t\t");
      _builder.append("]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// 序号");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("oTable.on(\'order.dt search.dt processing.dt\', function() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("oTable.column(0, {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("search : \'applied\',");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("order : \'applied\'");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}).nodes().each(function(cell, i) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$(cell).find(\".index-number\").html(i + 1);");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}).draw();");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var tableWrapper = $(\'#");
      String _firstLower_3 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_3, "\t\t");
      _builder.append("_sample_4_wrapper\');");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("var tableColumnToggler = $(\'#");
      String _firstLower_4 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_4, "\t\t");
      _builder.append("_sample_4_column_toggler\');");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("tableWrapper.find(\'.dataTables_length select\').select2();");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("$(\'input[type=\"checkbox\"]\', tableColumnToggler).change(function() {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("var column = oTable.column($(this).attr(\'data-column\'));");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("column.visible(!column.visible());");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// 初始化操作，选中未选中字段，使其在表单行影藏");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("$(\".dropdown-checkboxes input:checkbox\").not(\"input:checked\").each(function() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("var column = oTable.column($(this).attr(\'data-column\'));");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("column.visible(false);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("// 全选");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("$(\'input[name=selectAll]\').change(function() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("var set = jQuery(this).attr(\"data-set\");");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("var checked = jQuery(this).is(\":checked\");");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("jQuery(set).each(function() {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("if (checked) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("$(this).closest(\'span\').addClass(\"checked\");");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("$(this).closest(\'span\').removeClass(\"checked\");");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$(this).attr(\"checked\", checked);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$(\"#");
      String _firstLower_5 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_5, "\t\t\t\t");
      _builder.append("-deleteBtn\").attr(\"disabled\", !checked);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("jQuery.uniform.update(set);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("table.on(\'change\', \'tbody tr .checkboxes\', function() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("$(this).attr(\"checked\", this.checked);// 赋值选中");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (this.checked) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$(this).closest(\'span\').addClass(\"checked\");");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$(this).closest(\'span\').removeClass(\"checked\");");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("var checkAll = table.find(\'.group-checkable\');");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("// 改变全选");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("var flag = true;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("$(\"tbody tr .checkboxes\").each(function() {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("if (!this.checked) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("flag = false;");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (flag) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("checkAll.closest(\'span\').addClass(\"checked\");");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("checkAll.closest(\'span\').removeClass(\"checked\");");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("checkAll.attr(\"checked\", flag);");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("// 当选择2个以上屏蔽编辑按钮");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if ($(\"tbody tr .checkboxes:checked\").length == 1) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$(\"#");
      String _firstLower_6 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_6, "\t\t\t\t");
      _builder.append("-editBtn\").attr(\"disabled\", false);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$(\"#");
      String _firstLower_7 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_7, "\t\t\t\t");
      _builder.append("-editBtn\").attr(\"disabled\", true);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if ($(\"tbody tr .checkboxes:checked\").length > 0) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$(\"#");
      String _firstLower_8 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_8, "\t\t\t\t");
      _builder.append("-deleteBtn\").attr(\"disabled\", false);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$(\"#");
      String _firstLower_9 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_9, "\t\t\t\t");
      _builder.append("-deleteBtn\").attr(\"disabled\", true);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("$(\".form-search\").on(\'click\', \'.search-submit\', function(e) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("e.preventDefault();");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("oTable.ajax.url(\"/controller/v1/");
      String _firstLower_10 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_10, "\t\t\t");
      _builder.append("/page\" + getSearchParams());");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("oTable.ajax.reload();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("//监听查询按钮");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("$(\".dev-msg\").on(\'click\', \'.btn-search\', function(e) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if($(\".form-search\").is(\":hidden\")){");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$(\".form-search\").show();");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$(this).html(\'搜索<i class=\"fa fa-angle-down\"></i>\');");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}else{");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$(\".form-search\").hide();");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$(this).html(\'搜索<i class=\"fa fa-angle-up\"></i>\');");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("});");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("// 按钮组");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var hsBtnGroup = function() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var btns = $(\".hs-btn-group\");");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("$(\".hs-btns\").html(btns.html());");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("btns.remove();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("$(\"#");
      String _firstLower_11 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_11, "\t\t");
      _builder.append("-editBtn\").attr(\"disabled\", true);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("$(\"#");
      String _firstLower_12 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_12, "\t\t");
      _builder.append("-deleteBtn\").attr(\"disabled\", true);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("return {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("init : function() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("if (!jQuery().dataTable) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("initTable();");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("hsBtnGroup();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("},");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("reload : function() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("oTable.ajax.reload();");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("$(\'input[name=selectAll]\').closest(\'span\').removeClass(\"checked\");");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("};");
      _builder.newLine();
      _builder.append("}();");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence bean(final String basePackageName, final MongoBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      final List<MongoBot.VisonField> fields = table.fields;
      String klassType = table.klassType;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("        ");
      _builder.append("package ");
      _builder.append(basePackageName, "        ");
      _builder.append(".");
      String _trim = klassType.trim();
      String _firstLower = StringExtensions.toFirstLower(_trim);
      _builder.append(_firstLower, "        ");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.EqualsBuilder;");
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.HashCodeBuilder;");
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.ToStringBuilder;");
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.ToStringStyle;");
      _builder.newLine();
      _builder.append("import org.springframework.data.annotation.Id;");
      _builder.newLine();
      _builder.newLine();
      {
        final Function1<MongoBot.VisonField, Boolean> _function = (MongoBot.VisonField f) -> {
          String _firstUpper = StringExtensions.toFirstUpper(f.type);
          return Boolean.valueOf(_firstUpper.startsWith("List"));
        };
        boolean _exists = IterableExtensions.<MongoBot.VisonField>exists(fields, _function);
        if (_exists) {
          _builder.append("import java.util.List;");
          _builder.newLine();
        }
      }
      {
        final Function1<MongoBot.VisonField, Boolean> _function_1 = (MongoBot.VisonField f) -> {
          String _javaType = f.javaType();
          String _upperCase = _javaType.toUpperCase();
          return Boolean.valueOf(_upperCase.equals("DATE"));
        };
        boolean _exists_1 = IterableExtensions.<MongoBot.VisonField>exists(fields, _function_1);
        if (_exists_1) {
          _builder.append("import java.util.Date;");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(klassType, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        for(final MongoBot.VisonField f : fields) {
          _builder.append("\t");
          _builder.append("/**");
          String[] _split = f.comment.split("-");
          String _get = _split[0];
          _builder.append(_get, "\t");
          _builder.append("**/");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          String _parseFieldAnnotation = MongoBot.parseFieldAnnotation(f);
          _builder.append(_parseFieldAnnotation, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(klassType, "\t");
      _builder.append("(){");
      _builder.newLineIfNotEmpty();
      {
        for(final MongoBot.VisonField f_1 : fields) {
          {
            if ((f_1.javaType().toUpperCase().equals("DATE") && StringExtensions.toFirstLower(f_1.name).equals("updateTime"))) {
              _builder.append("\t\t");
              _builder.append("this.");
              String _firstLower_1 = StringExtensions.toFirstLower(f_1.name);
              _builder.append(_firstLower_1, "\t\t");
              _builder.append("=new Date();");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(klassType, "\t");
      _builder.append("(");
      final Function1<MongoBot.VisonField, String> _function_2 = (MongoBot.VisonField it) -> {
        String _javaType = it.javaType();
        String _plus = (_javaType + " ");
        String _firstLower_2 = StringExtensions.toFirstLower(it.name);
        return (_plus + _firstLower_2);
      };
      List<String> _map = ListExtensions.<MongoBot.VisonField, String>map(fields, _function_2);
      String _join = IterableExtensions.join(_map, ",");
      _builder.append(_join, "\t");
      _builder.append("){");
      _builder.newLineIfNotEmpty();
      {
        for(final MongoBot.VisonField f_2 : fields) {
          _builder.append("\t\t");
          _builder.append("this.");
          String _firstLower_2 = StringExtensions.toFirstLower(f_2.name);
          _builder.append(_firstLower_2, "\t\t");
          _builder.append("=");
          String _firstLower_3 = StringExtensions.toFirstLower(f_2.name);
          _builder.append(_firstLower_3, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      {
        for(final MongoBot.VisonField f_3 : fields) {
          _builder.append("\t");
          _builder.append("public ");
          String _javaType = f_3.javaType();
          _builder.append(_javaType, "\t");
          _builder.append(" get");
          String _firstUpper = StringExtensions.toFirstUpper(f_3.name);
          _builder.append(_firstUpper, "\t");
          _builder.append("() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return ");
          String _firstLower_4 = StringExtensions.toFirstLower(f_3.name);
          _builder.append(_firstLower_4, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void set");
          String _firstUpper_1 = StringExtensions.toFirstUpper(f_3.name);
          _builder.append(_firstUpper_1, "\t");
          _builder.append("(");
          String _javaType_1 = f_3.javaType();
          _builder.append(_javaType_1, "\t");
          _builder.append(" ");
          String _firstLower_5 = StringExtensions.toFirstLower(f_3.name);
          _builder.append(_firstLower_5, "\t");
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("this.");
          String _firstLower_6 = StringExtensions.toFirstLower(f_3.name);
          _builder.append(_firstLower_6, "\t\t");
          _builder.append(" = ");
          String _firstLower_7 = StringExtensions.toFirstLower(f_3.name);
          _builder.append(_firstLower_7, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public int hashCode() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return HashCodeBuilder.reflectionHashCode(this);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public boolean equals(Object other) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return EqualsBuilder.reflectionEquals(this, other);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public String toString() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return ToStringBuilder.reflectionToString(this,ToStringStyle.DEFAULT_STYLE);");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence service(final String basePackageName, final MongoBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      String klassType = table.klassType;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      String _trim = klassType.trim();
      String _firstLower = StringExtensions.toFirstLower(_trim);
      _builder.append(_firstLower, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.data.domain.Page;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.data.domain.PageRequest;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import com.github.east196.xcode.common.SearchFilter;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("public interface ");
      _builder.append(klassType, "\t\t");
      _builder.append("Service {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public List<");
      _builder.append(klassType, "\t\t\t");
      _builder.append("> findAll(List<SearchFilter> searchFilters);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public Page<");
      _builder.append(klassType, "\t\t\t");
      _builder.append("> findAll(List<SearchFilter> searchFilters, PageRequest pageRequest);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public void save(");
      _builder.append(klassType, "\t\t\t");
      _builder.append(" ");
      String _firstLower_1 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_1, "\t\t\t");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public void delete(String id);");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence mongoServiceImpl(final String basePackageName, final MongoBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      String klassType = table.klassType;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      String _trim = klassType.trim();
      String _firstLower = StringExtensions.toFirstLower(_trim);
      _builder.append(_firstLower, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.beans.factory.annotation.Autowired;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.data.domain.Page;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.data.domain.PageRequest;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.stereotype.Service;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import com.github.east196.xcode.common.SearchFilter;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("@Service");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("public class ");
      _builder.append(klassType, "\t\t");
      _builder.append("MongoServiceImpl implements ");
      _builder.append(klassType, "\t\t");
      _builder.append("Service{");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("@Autowired");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("private ");
      _builder.append(klassType, "\t\t\t");
      _builder.append("Mongo ");
      String _firstLower_1 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_1, "\t\t\t");
      _builder.append("Mongo;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("public List<");
      _builder.append(klassType, "\t\t    ");
      _builder.append("> findAll(List<SearchFilter> searchFilters) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t         ");
      _builder.append("return ");
      String _firstLower_2 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_2, "\t\t         ");
      _builder.append("Mongo.findAll(searchFilters,");
      _builder.append(klassType, "\t\t         ");
      _builder.append(".class);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t    ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("public Page<");
      _builder.append(klassType, "\t\t    ");
      _builder.append("> findAll(List<SearchFilter> searchFilters, PageRequest pageRequest) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t         ");
      _builder.append("return ");
      String _firstLower_3 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_3, "\t\t         ");
      _builder.append("Mongo.findAll(searchFilters, pageRequest,");
      _builder.append(klassType, "\t\t         ");
      _builder.append(".class);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t    ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("public void save(");
      _builder.append(klassType, "\t\t    ");
      _builder.append(" ");
      String _firstLower_4 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_4, "\t\t    ");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t         ");
      String _firstLower_5 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_5, "\t\t         ");
      _builder.append("Mongo.save(");
      String _firstLower_6 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_6, "\t\t         ");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t    ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t\t    ");
      _builder.append("public void delete(String id) {");
      _builder.newLine();
      _builder.append("\t\t         ");
      String _firstLower_7 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_7, "\t\t         ");
      _builder.append("Mongo.deleteById(id);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t    ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence mongoDao(final String basePackageName, final MongoBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      String klassType = table.klassType;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      String _trim = klassType.trim();
      String _firstLower = StringExtensions.toFirstLower(_trim);
      _builder.append(_firstLower, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.data.mongodb.repository.MongoRepository;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import com.github.east196.xcode.common.MongoSpecificationExecutor;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("public interface ");
      _builder.append(klassType, "\t\t");
      _builder.append("Mongo extends MongoRepository<");
      _builder.append(klassType, "\t\t");
      _builder.append(", String>, MongoSpecificationExecutor {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("// add more ...");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence mongoDaoImpl(final String basePackageName, final MongoBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      String klassType = table.klassType;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      String _trim = klassType.trim();
      String _firstLower = StringExtensions.toFirstLower(_trim);
      _builder.append(_firstLower, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import com.github.east196.xcode.common.MongoSpecificationExecutorImpl;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("public class ");
      _builder.append(klassType, "\t\t");
      _builder.append("MongoImpl extends MongoSpecificationExecutorImpl {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t     ");
      _builder.append("// add more ...");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence controller(final String basePackageName, final MongoBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      String klassType = table.klassType;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      String _trim = klassType.trim();
      String _firstLower = StringExtensions.toFirstLower(_trim);
      _builder.append(_firstLower, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import java.util.Map;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import javax.validation.Valid;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.slf4j.Logger;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.slf4j.LoggerFactory;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.beans.factory.annotation.Autowired;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.data.domain.Page;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.data.domain.PageRequest;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.validation.BindingResult;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.validation.DataBinder;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.validation.ObjectError;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.web.bind.annotation.InitBinder;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.web.bind.annotation.PathVariable;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.web.bind.annotation.RequestBody;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.web.bind.annotation.RequestMapping;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.web.bind.annotation.RequestMethod;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.web.bind.annotation.RequestParam;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import org.springframework.web.bind.annotation.RestController;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import com.github.east196.xcode.common.DataTableResult;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import com.github.east196.xcode.common.DataResponse;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import com.github.east196.xcode.common.Response;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import com.github.east196.xcode.common.SearchFilter;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("@RestController");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("@RequestMapping(\"/controller/v1/");
      String _firstLower_1 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_1, "\t\t");
      _builder.append("\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("public class ");
      _builder.append(klassType, "\t\t");
      _builder.append("Controller {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("private static final Logger LOGGER = LoggerFactory.getLogger(");
      _builder.append(klassType, "\t\t");
      _builder.append("Controller.class);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("@Autowired");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("private ");
      _builder.append(klassType, "\t\t\t");
      _builder.append("Service ");
      String _firstLower_2 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_2, "\t\t\t");
      _builder.append("Service;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("@RequestMapping(value = \"/page\", method = RequestMethod.POST)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public DataTableResult<List<");
      _builder.append(klassType, "\t\t\t");
      _builder.append(">> read(@RequestParam(value = \"draw\", required = false, defaultValue = \"1\") Integer draw,");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("@RequestParam(value = \"start\", required = false, defaultValue = \"0\") Integer start,");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("@RequestParam(value = \"length\", required = false, defaultValue = \"20\") Integer length,");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("@RequestParam Map<String,String> queryMap) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("List<SearchFilter> searchFilters = SearchFilter.fromQueryMap(queryMap, ");
      _builder.append(klassType, "\t\t\t\t");
      _builder.append(".class);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("PageRequest pageRequest = SearchFilter.sortQueryMap(queryMap, start, length);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("Page<");
      _builder.append(klassType, "\t\t\t\t");
      _builder.append("> ");
      String _firstLower_3 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_3, "\t\t\t\t");
      _builder.append("s = ");
      String _firstLower_4 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_4, "\t\t\t\t");
      _builder.append("Service.findAll(searchFilters, pageRequest);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("DataTableResult<List<");
      _builder.append(klassType, "\t\t\t\t");
      _builder.append(">> dataTableResult = new DataTableResult<>();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("dataTableResult.setDraw(draw);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("dataTableResult.setRecordsTotal(");
      String _firstLower_5 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_5, "\t\t\t\t");
      _builder.append("s.getTotalElements());");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("dataTableResult.setRecordsFiltered(");
      String _firstLower_6 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_6, "\t\t\t\t");
      _builder.append("s.getTotalElements());");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("dataTableResult.setData(");
      String _firstLower_7 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_7, "\t\t\t\t");
      _builder.append("s.getContent());");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("return dataTableResult;");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("@RequestMapping(value = \"/\", method = RequestMethod.GET)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public DataResponse<List<");
      _builder.append(klassType, "\t\t\t");
      _builder.append(">> read(@RequestParam Map<String,String> queryMap) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("List<SearchFilter> searchFilters = SearchFilter.fromQueryMap(queryMap, ");
      _builder.append(klassType, "\t\t\t\t");
      _builder.append(".class);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("List<");
      _builder.append(klassType, "\t\t\t\t");
      _builder.append("> ");
      String _firstLower_8 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_8, "\t\t\t\t");
      _builder.append("s = ");
      String _firstLower_9 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_9, "\t\t\t\t");
      _builder.append("Service.findAll(searchFilters);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("return new DataResponse<List<");
      _builder.append(klassType, "\t\t\t\t");
      _builder.append(">>(\"0\", \"查询成功!\", ");
      String _firstLower_10 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_10, "\t\t\t\t");
      _builder.append("s);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("@RequestMapping(value = \"/\", method = RequestMethod.POST)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public Response createOrUpdate(@RequestBody @Valid ");
      _builder.append(klassType, "\t\t\t");
      _builder.append(" ");
      String _firstLower_11 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_11, "\t\t\t");
      _builder.append(", BindingResult result) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("LOGGER.debug(\"add ");
      String _firstLower_12 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_12, "\t\t\t\t");
      _builder.append(":  {}\", ");
      String _firstLower_13 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_13, "\t\t\t\t");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("if (result.hasErrors()) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("StringBuffer sb = new StringBuffer();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("for (ObjectError msg : result.getAllErrors())");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("sb.append(msg.getDefaultMessage()).append(\" \");");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("return new Response(\"-1\", sb.toString());");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      String _firstLower_14 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_14, "\t\t\t\t\t");
      _builder.append("Service.save(");
      String _firstLower_15 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_15, "\t\t\t\t\t");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t    ");
      _builder.append("return new Response(\"0\", \"ok\");");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("@RequestMapping(value = \"/{id}\", method = RequestMethod.DELETE)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public Response delete(@PathVariable String id) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("LOGGER.debug(\"id:  {}\", id);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      String _firstLower_16 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_16, "\t\t\t\t");
      _builder.append("Service.delete(id);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("return new Response(\"0\", \"ok\");");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("@RequestMapping(value = \"/deletes\", method = RequestMethod.POST)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public Response delete(@RequestBody List<String> ids) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("LOGGER.debug(\"ids:  {}\", ids);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("for (String id : ids) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      String _firstLower_17 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_17, "\t\t\t\t\t");
      _builder.append("Service.delete(id);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("return new Response(\"0\", \"ok\");");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("@InitBinder(\"");
      String _firstLower_18 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_18, "\t\t\t");
      _builder.append("\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("public void initBinder(DataBinder binder) {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("binder.setValidator(new ");
      _builder.append(klassType, "\t\t\t\t");
      _builder.append("Validator());");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence validator(final String basePackageName, final MongoBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      List<MongoBot.VisonField> fields = table.fields;
      String klassType = table.klassType;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("        ");
      _builder.append("package ");
      _builder.append(basePackageName, "        ");
      _builder.append(".");
      String _trim = klassType.trim();
      String _firstLower = StringExtensions.toFirstLower(_trim);
      _builder.append(_firstLower, "        ");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.springframework.validation.Errors;");
      _builder.newLine();
      _builder.append("import org.springframework.validation.ValidationUtils;");
      _builder.newLine();
      _builder.append("import org.springframework.validation.Validator;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(klassType, "");
      _builder.append("Validator implements Validator {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public boolean supports(Class<?> arg0) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return ");
      _builder.append(klassType, "\t\t");
      _builder.append(".class.equals(arg0);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void validate(Object arg0, Errors arg1) {");
      _builder.newLine();
      {
        final Function1<MongoBot.VisonField, Boolean> _function = (MongoBot.VisonField it) -> {
          String _upperCase = it.require.toUpperCase();
          return Boolean.valueOf(_upperCase.contains("A"));
        };
        Iterable<MongoBot.VisonField> _filter = IterableExtensions.<MongoBot.VisonField>filter(fields, _function);
        List<MongoBot.VisonField> _list = IterableExtensions.<MongoBot.VisonField>toList(_filter);
        for(final MongoBot.VisonField f : _list) {
          _builder.append("\t\t");
          _builder.append("ValidationUtils.rejectIfEmpty(arg1, \"");
          String _firstLower_1 = StringExtensions.toFirstLower(f.name);
          _builder.append(_firstLower_1, "\t\t");
          _builder.append("\", null, \"");
          _builder.append(f.comment, "\t\t");
          _builder.append("不能为空！\");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence httpcaller(final String basePackageName, final MongoBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      String klassType = table.klassType.trim();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".http;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import java.util.Map;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import ");
      _builder.append(basePackageName, "\t\t");
      _builder.append(".");
      String _firstLower = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower, "\t\t");
      _builder.append(".");
      _builder.append(klassType, "\t\t");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("import com.github.east196.xcode.common.DataResponse;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import com.github.east196.xcode.common.DataTableResult;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import com.github.east196.xcode.common.Response;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import retrofit.http.Body;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import retrofit.http.DELETE;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import retrofit.http.GET;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import retrofit.http.POST;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import retrofit.http.Path;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import retrofit.http.Query;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("import retrofit.http.QueryMap;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("public interface ");
      _builder.append(klassType, "\t\t");
      _builder.append("HttpCaller {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("@POST(\"/controller/v1/");
      String _firstLower_1 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_1, "\t\t\t");
      _builder.append("/page\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("DataTableResult<List<");
      _builder.append(klassType, "\t\t\t");
      _builder.append(">> read(@Query(\"draw\") Integer draw, @Query(\"start\") Integer start, @Query(\"length\") Integer length,");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t");
      _builder.append("@QueryMap Map<String, String> queryMap);");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("@GET(\"/controller/v1/");
      String _firstLower_2 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_2, "\t\t\t");
      _builder.append("/\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("DataResponse<List<");
      _builder.append(klassType, "\t\t\t");
      _builder.append(">> read(@QueryMap Map<String, String> queryMap);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("@POST(\"/controller/v1/");
      String _firstLower_3 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_3, "\t\t\t");
      _builder.append("/\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("Response createOrUpdate(@Body ");
      _builder.append(klassType, "\t\t\t");
      _builder.append(" ");
      String _firstLower_4 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_4, "\t\t\t");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("@DELETE(\"/controller/v1/");
      String _firstLower_5 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_5, "\t\t\t");
      _builder.append("/{id}\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("Response delete(@Path(\"id\") String id);");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("@DELETE(\"/controller/v1/");
      String _firstLower_6 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_6, "\t\t\t");
      _builder.append("/\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("Response deletes(@Body List<String> ids);");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence httpcallertest(final String basePackageName, final MongoBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      String klassType = table.klassType.trim();
      String _trim = table.klassType.trim();
      String klassName = StringExtensions.toFirstLower(_trim);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("        ");
      _builder.append("package ");
      _builder.append(basePackageName, "        ");
      _builder.append(".http;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import java.util.HashMap;");
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      {
        final Function1<MongoBot.VisonField, Boolean> _function = (MongoBot.VisonField f) -> {
          String _firstUpper = StringExtensions.toFirstUpper(f.type);
          return Boolean.valueOf(_firstUpper.startsWith("List"));
        };
        boolean _exists = IterableExtensions.<MongoBot.VisonField>exists(table.fields, _function);
        if (_exists) {
          _builder.append("import java.util.ArrayList;");
          _builder.newLine();
        }
      }
      {
        final Function1<MongoBot.VisonField, Boolean> _function_1 = (MongoBot.VisonField f) -> {
          String _upperCase = f.type.toUpperCase();
          return Boolean.valueOf(_upperCase.contains("DATE"));
        };
        boolean _exists_1 = IterableExtensions.<MongoBot.VisonField>exists(table.fields, _function_1);
        if (_exists_1) {
          _builder.append("import java.util.Date;");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("import org.junit.BeforeClass;");
      _builder.newLine();
      _builder.append("import org.junit.Test;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      _builder.append(klassName, "");
      _builder.append(".");
      _builder.append(klassType, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("import com.github.east196.xcode.common.DataResponse;");
      _builder.newLine();
      _builder.append("import retrofit.RestAdapter;");
      _builder.newLine();
      _builder.append("import retrofit.RestAdapter.LogLevel;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(klassType, "");
      _builder.append("HttpCallerTest {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static ");
      _builder.append(klassType, "\t");
      _builder.append("HttpCaller ");
      _builder.append(klassName, "\t");
      _builder.append("HttpCaller;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@BeforeClass");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static void beforeClass() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(LogLevel.FULL)");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append(".setEndpoint(\"http://192.168.7.200:8099/\").build();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append(klassName, "\t\t");
      _builder.append("HttpCaller = restAdapter.create(");
      _builder.append(klassType, "\t\t");
      _builder.append("HttpCaller.class);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Test");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void testCrud() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append(klassType, "\t\t");
      _builder.append(" ");
      _builder.append(klassName, "\t\t");
      _builder.append(" = new ");
      _builder.append(klassType, "\t\t");
      _builder.append("();");
      _builder.newLineIfNotEmpty();
      {
        List<MongoBot.VisonField> _list = IterableExtensions.<MongoBot.VisonField>toList(table.fields);
        for(final MongoBot.VisonField f : _list) {
          _builder.append("\t\t");
          _builder.append(klassName, "\t\t");
          _builder.append(".set");
          String _firstUpper = StringExtensions.toFirstUpper(f.name);
          _builder.append(_firstUpper, "\t\t");
          _builder.append("(");
          CharSequence _defaultValue = f.defaultValue();
          _builder.append(_defaultValue, "\t\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append(klassName, "\t\t");
      _builder.append("HttpCaller.createOrUpdate(");
      _builder.append(klassName, "\t\t");
      _builder.append(");// Create");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("@SuppressWarnings(\"unused\")");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("DataResponse<List<");
      _builder.append(klassType, "\t\t");
      _builder.append(">> read = ");
      _builder.append(klassName, "\t\t");
      _builder.append("HttpCaller.read(new HashMap<>());// Read after Create");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        final Function1<MongoBot.VisonField, Boolean> _function_2 = (MongoBot.VisonField it) -> {
          boolean _contains = it.key.contains("P");
          return Boolean.valueOf((!_contains));
        };
        Iterable<MongoBot.VisonField> _filter = IterableExtensions.<MongoBot.VisonField>filter(table.fields, _function_2);
        List<MongoBot.VisonField> _list_1 = IterableExtensions.<MongoBot.VisonField>toList(_filter);
        for(final MongoBot.VisonField f_1 : _list_1) {
          _builder.append("\t\t");
          _builder.append(klassName, "\t\t");
          _builder.append(".set");
          String _firstUpper_1 = StringExtensions.toFirstUpper(f_1.name);
          _builder.append(_firstUpper_1, "\t\t");
          _builder.append("(");
          CharSequence _defaultValue_1 = f_1.defaultValue();
          _builder.append(_defaultValue_1, "\t\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.append(klassName, "\t\t");
      _builder.append("HttpCaller.createOrUpdate(");
      _builder.append(klassName, "\t\t");
      _builder.append(");// Update");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("read = ");
      _builder.append(klassName, "\t\t");
      _builder.append("HttpCaller.read(new HashMap<>());// Read after Update");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append(klassName, "\t\t");
      _builder.append("HttpCaller.delete(");
      final Function1<MongoBot.VisonField, Boolean> _function_3 = (MongoBot.VisonField it) -> {
        return Boolean.valueOf(it.key.contains("P"));
      };
      MongoBot.VisonField _findFirst = IterableExtensions.<MongoBot.VisonField>findFirst(table.fields, _function_3);
      CharSequence _defaultValue_2 = _findFirst.defaultValue();
      _builder.append(_defaultValue_2, "\t\t");
      _builder.append(");// Delete");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("read = ");
      _builder.append(klassName, "\t\t");
      _builder.append("HttpCaller.read(new HashMap<>());// Read after Delete");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static String parseSearchInput(final MongoBot.VisonTable t, final MongoBot.VisonField f) {
    String _switchResult = null;
    final String _switchValue = f.comment;
    boolean _matched = false;
    boolean _contains = f.comment.contains("-date");
    if (_contains) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<div class=\"input-group input-large date-picker input-daterange\" data-date-format=\"yyyy-mm-dd\">");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("<input type=\"text\" class=\"form-control\" name=\"");
      String _firstLower = StringExtensions.toFirstLower(f.name);
      _builder.append(_firstLower, "     ");
      _builder.append("_GTE\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t ");
      _builder.append("<span class=\"input-group-addon\">至</span>");
      _builder.newLine();
      _builder.append("\t\t\t\t ");
      _builder.append("<input type=\"text\" class=\"form-control\" name=\"");
      String _firstLower_1 = StringExtensions.toFirstLower(f.name);
      _builder.append(_firstLower_1, "\t\t\t\t ");
      _builder.append("\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("<input type=\"hidden\" name=\"");
      String _firstLower_2 = StringExtensions.toFirstLower(f.name);
      _builder.append(_firstLower_2, "\t\t\t");
      _builder.append("_LTE\" value=\"{{");
      String _firstLower_3 = StringExtensions.toFirstLower(f.name);
      _builder.append(_firstLower_3, "\t\t\t");
      _builder.append("_LTE}}\" />");
      _builder.newLineIfNotEmpty();
      _switchResult = _builder.toString();
    }
    if (!_matched) {
      boolean _contains_1 = f.comment.contains("-select");
      if (_contains_1) {
        _matched=true;
        String _xifexpression = null;
        String[] _split = f.comment.split("-");
        int _length = _split.length;
        boolean _greaterThan = (_length > 2);
        if (_greaterThan) {
          String _xblockexpression = null;
          {
            String[] _split_1 = f.comment.split("-");
            String _get = _split_1[2];
            String name = StringExtensions.toFirstLower(_get);
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("<select name=\"");
            String _firstLower_4 = StringExtensions.toFirstLower(f.name);
            _builder_1.append(_firstLower_4, "");
            _builder_1.append("_EQ\" class=\"form-control\" ng-model=\"");
            _builder_1.append(name, "");
            _builder_1.append("\" ng-options=\"d.name for d in ");
            _builder_1.append(name, "");
            _builder_1.append("s\"");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("\t\t\t\t\t");
            _builder_1.append("data-value=\"{{");
            _builder_1.append(name, "\t\t\t\t\t");
            _builder_1.append("}}\">");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("\t\t\t\t\t     ");
            _builder_1.append("<option value=\"\">-- 请选择 --</option>");
            _builder_1.newLine();
            _builder_1.append("\t\t\t\t\t");
            _builder_1.append("</select>");
            _builder_1.newLine();
            _xblockexpression = _builder_1.toString();
          }
          _xifexpression = _xblockexpression;
        } else {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("<select name=\"");
          String _firstLower_4 = StringExtensions.toFirstLower(f.name);
          _builder_1.append(_firstLower_4, "");
          _builder_1.append("_EQ\" class=\"form-control\" ng-model=\"");
          String _firstLower_5 = StringExtensions.toFirstLower(f.name);
          _builder_1.append(_firstLower_5, "");
          _builder_1.append("\" ng-options=\"d for d in ");
          String _firstLower_6 = StringExtensions.toFirstLower(f.name);
          _builder_1.append(_firstLower_6, "");
          _builder_1.append("s\"");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t\t\t\t\t");
          _builder_1.append("data-value=\"{{");
          String _firstLower_7 = StringExtensions.toFirstLower(f.name);
          _builder_1.append(_firstLower_7, "\t\t\t\t\t");
          _builder_1.append("}}\" ");
          {
            String _upperCase = f.name.toUpperCase();
            boolean _equals = _upperCase.equals("CITY");
            if (_equals) {
              _builder_1.append("ng-click=\"getCitys()\"");
            }
          }
          _builder_1.append(">");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t\t\t\t\t     ");
          _builder_1.append("<option value=\"\">-- 请选择 --</option>");
          _builder_1.newLine();
          _builder_1.append("\t\t\t\t\t");
          _builder_1.append("</select>");
          _builder_1.newLine();
          _xifexpression = _builder_1.toString();
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("<input type=\"text\" name=\"");
      String _firstLower_8 = StringExtensions.toFirstLower(f.name);
      _builder_2.append(_firstLower_8, "");
      _builder_2.append("_LIKE\" ng-model=\"");
      String _firstLower_9 = StringExtensions.toFirstLower(t.klassType);
      _builder_2.append(_firstLower_9, "");
      _builder_2.append(".");
      String _firstLower_10 = StringExtensions.toFirstLower(f.name);
      _builder_2.append(_firstLower_10, "");
      _builder_2.append("\" class=\"form-control\" />");
      _builder_2.newLineIfNotEmpty();
      _switchResult = _builder_2.toString();
    }
    return _switchResult;
  }
  
  public static String parseInput(final MongoBot.VisonTable t, final MongoBot.VisonField f) {
    String _switchResult = null;
    final String _switchValue = f.comment;
    boolean _matched = false;
    boolean _contains = f.comment.contains("-date");
    if (_contains) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<div class=\"input-group input-large date-picker input-daterange\" data-date-format=\"yyyy-mm-dd\">");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("<input type=\"text\" class=\"form-control\" name=\"");
      String _firstLower = StringExtensions.toFirstLower(f.name);
      _builder.append(_firstLower, "     ");
      _builder.append("\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t ");
      _builder.append("<span class=\"input-group-addon\">至</span>");
      _builder.newLine();
      _builder.append("\t\t\t\t ");
      _builder.append("<input type=\"text\" class=\"form-control\" name=\"");
      String _firstLower_1 = StringExtensions.toFirstLower(f.name);
      _builder.append(_firstLower_1, "\t\t\t\t ");
      _builder.append("\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("</div>");
      _builder.newLine();
      _switchResult = _builder.toString();
    }
    if (!_matched) {
      boolean _contains_1 = f.comment.contains("-select");
      if (_contains_1) {
        _matched=true;
        String _xifexpression = null;
        String[] _split = f.comment.split("-");
        int _length = _split.length;
        boolean _greaterThan = (_length > 2);
        if (_greaterThan) {
          String _xblockexpression = null;
          {
            String[] _split_1 = f.comment.split("-");
            String _get = _split_1[2];
            String name = StringExtensions.toFirstLower(_get);
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("<select name=\"");
            String _firstLower_2 = StringExtensions.toFirstLower(f.name);
            _builder_1.append(_firstLower_2, "");
            _builder_1.append("\" class=\"form-control\" ng-model=\"");
            _builder_1.append(name, "");
            _builder_1.append("\" ng-options=\"d.name for d in ");
            _builder_1.append(name, "");
            _builder_1.append("s\"");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("\t\t\t\t\t");
            _builder_1.append("data-value=\"{{");
            _builder_1.append(name, "\t\t\t\t\t");
            _builder_1.append("}}\">");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("\t\t\t\t\t     ");
            _builder_1.append("<option value=\"\">-- 请选择 --</option>");
            _builder_1.newLine();
            _builder_1.append("\t\t\t\t\t");
            _builder_1.append("</select>");
            _builder_1.newLine();
            _xblockexpression = _builder_1.toString();
          }
          _xifexpression = _xblockexpression;
        } else {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("<select name=\"");
          String _firstLower_2 = StringExtensions.toFirstLower(f.name);
          _builder_1.append(_firstLower_2, "");
          _builder_1.append("\" class=\"form-control\" ng-model=\"");
          String _firstLower_3 = StringExtensions.toFirstLower(f.name);
          _builder_1.append(_firstLower_3, "");
          _builder_1.append("\" ng-options=\"d for d in ");
          String _firstLower_4 = StringExtensions.toFirstLower(f.name);
          _builder_1.append(_firstLower_4, "");
          _builder_1.append("s\"");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t\t\t\t\t");
          _builder_1.append("data-value=\"{{");
          String _firstLower_5 = StringExtensions.toFirstLower(f.name);
          _builder_1.append(_firstLower_5, "\t\t\t\t\t");
          _builder_1.append("}}\"");
          {
            String _upperCase = f.name.toUpperCase();
            boolean _equals = _upperCase.equals("CITY");
            if (_equals) {
              _builder_1.append("ng-click=\"getCitys()\"");
            }
          }
          _builder_1.append(">");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("\t\t\t\t\t     ");
          _builder_1.append("<option value=\"\">-- 请选择 --</option>");
          _builder_1.newLine();
          _builder_1.append("\t\t\t\t\t");
          _builder_1.append("</select>");
          _builder_1.newLine();
          _xifexpression = _builder_1.toString();
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("<input type=\"text\" name=\"");
      String _firstLower_6 = StringExtensions.toFirstLower(f.name);
      _builder_2.append(_firstLower_6, "");
      _builder_2.append("\" ng-model=\"");
      String _firstLower_7 = StringExtensions.toFirstLower(t.klassType);
      _builder_2.append(_firstLower_7, "");
      _builder_2.append(".");
      String _firstLower_8 = StringExtensions.toFirstLower(f.name);
      _builder_2.append(_firstLower_8, "");
      _builder_2.append("\" class=\"form-control\" />");
      _builder_2.newLineIfNotEmpty();
      _switchResult = _builder_2.toString();
    }
    return _switchResult;
  }
  
  public static String parseFieldAnnotation(final MongoBot.VisonField f) {
    String _switchResult = null;
    boolean _matched = false;
    String _upperCase = f.key.toUpperCase();
    boolean _contains = _upperCase.contains("P");
    if (_contains) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@Id");
      _builder.newLine();
      _builder.append("private ");
      String _javaType = f.javaType();
      _builder.append(_javaType, "");
      _builder.append(" ");
      String _firstLower = StringExtensions.toFirstLower(f.name);
      _builder.append(_firstLower, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _switchResult = _builder.toString();
    }
    if (!_matched) {
      String _javaType_1 = f.javaType();
      String _upperCase_1 = _javaType_1.toUpperCase();
      boolean _equals = _upperCase_1.equals("DATE");
      if (_equals) {
        _matched=true;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("private ");
        String _javaType_2 = f.javaType();
        _builder_1.append(_javaType_2, "");
        _builder_1.append(" ");
        String _firstLower_1 = StringExtensions.toFirstLower(f.name);
        _builder_1.append(_firstLower_1, "");
        _builder_1.append(";");
        _builder_1.newLineIfNotEmpty();
        _switchResult = _builder_1.toString();
      }
    }
    if (!_matched) {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("private ");
      String _javaType_3 = f.javaType();
      _builder_2.append(_javaType_3, "");
      _builder_2.append(" ");
      String _firstLower_2 = StringExtensions.toFirstLower(f.name);
      _builder_2.append(_firstLower_2, "");
      _builder_2.append(";");
      _switchResult = _builder_2.toString();
    }
    return _switchResult;
  }
}
