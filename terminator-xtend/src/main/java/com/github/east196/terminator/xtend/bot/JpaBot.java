package com.github.east196.terminator.xtend.bot;

import com.google.common.base.CaseFormat;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Generated;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class JpaBot {
  @Data
  public static class VisonTable {
    private final String _klassType;
    
    private final String _klassName;
    
    private final List<JpaBot.VisonField> _fields;
    
    public VisonTable(final String klassType, final String klassName, final List<JpaBot.VisonField> fields) {
      super();
      this._klassType = klassType;
      this._klassName = klassName;
      this._fields = fields;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this._klassType== null) ? 0 : this._klassType.hashCode());
      result = prime * result + ((this._klassName== null) ? 0 : this._klassName.hashCode());
      result = prime * result + ((this._fields== null) ? 0 : this._fields.hashCode());
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
      JpaBot.VisonTable other = (JpaBot.VisonTable) obj;
      if (this._klassType == null) {
        if (other._klassType != null)
          return false;
      } else if (!this._klassType.equals(other._klassType))
        return false;
      if (this._klassName == null) {
        if (other._klassName != null)
          return false;
      } else if (!this._klassName.equals(other._klassName))
        return false;
      if (this._fields == null) {
        if (other._fields != null)
          return false;
      } else if (!this._fields.equals(other._fields))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      String result = new ToStringHelper().toString(this);
      return result;
    }
    
    @Pure
    public String getKlassType() {
      return this._klassType;
    }
    
    @Pure
    public String getKlassName() {
      return this._klassName;
    }
    
    @Pure
    public List<JpaBot.VisonField> getFields() {
      return this._fields;
    }
  }
  
  @Data
  public static class VisonField {
    private final String _name;
    
    private final String _type;
    
    private final String _require;
    
    private final String _key;
    
    private final String _comment;
    
    private final String _show;
    
    public String javaName() {
      String _name = this.getName();
      String _lowerCase = _name.toLowerCase();
      return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, _lowerCase);
    }
    
    public String javaType() {
      String _switchResult = null;
      String _type = this.getType();
      String _firstLower = StringExtensions.toFirstLower(_type);
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
          String _type_1 = this.getType();
          _switchResult = StringExtensions.toFirstUpper(_type_1);
          break;
      }
      return _switchResult;
    }
    
    public VisonField(final String name, final String type, final String require, final String key, final String comment, final String show) {
      super();
      this._name = name;
      this._type = type;
      this._require = require;
      this._key = key;
      this._comment = comment;
      this._show = show;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this._name== null) ? 0 : this._name.hashCode());
      result = prime * result + ((this._type== null) ? 0 : this._type.hashCode());
      result = prime * result + ((this._require== null) ? 0 : this._require.hashCode());
      result = prime * result + ((this._key== null) ? 0 : this._key.hashCode());
      result = prime * result + ((this._comment== null) ? 0 : this._comment.hashCode());
      result = prime * result + ((this._show== null) ? 0 : this._show.hashCode());
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
      JpaBot.VisonField other = (JpaBot.VisonField) obj;
      if (this._name == null) {
        if (other._name != null)
          return false;
      } else if (!this._name.equals(other._name))
        return false;
      if (this._type == null) {
        if (other._type != null)
          return false;
      } else if (!this._type.equals(other._type))
        return false;
      if (this._require == null) {
        if (other._require != null)
          return false;
      } else if (!this._require.equals(other._require))
        return false;
      if (this._key == null) {
        if (other._key != null)
          return false;
      } else if (!this._key.equals(other._key))
        return false;
      if (this._comment == null) {
        if (other._comment != null)
          return false;
      } else if (!this._comment.equals(other._comment))
        return false;
      if (this._show == null) {
        if (other._show != null)
          return false;
      } else if (!this._show.equals(other._show))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      String result = new ToStringHelper().toString(this);
      return result;
    }
    
    @Pure
    public String getName() {
      return this._name;
    }
    
    @Pure
    public String getType() {
      return this._type;
    }
    
    @Pure
    public String getRequire() {
      return this._require;
    }
    
    @Pure
    public String getKey() {
      return this._key;
    }
    
    @Pure
    public String getComment() {
      return this._comment;
    }
    
    @Pure
    public String getShow() {
      return this._show;
    }
  }
  
  public static void main(final String[] args) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("E:\\backup\\xcode\\huawei设备管理平台数据库设计文档.doc");
      String src = _builder.toString();
      final String basePackageName = "cn.device";
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("E:\\workspace\\github\\east196\\java\\xcode\\src\\main\\");
      final String basePath = _builder_1.toString();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("E:\\workspace\\github\\east196\\java\\xcode\\src\\main\\java\\cn\\device\\");
      final String beanBasePath = _builder_2.toString();
      FileInputStream is = new FileInputStream(src);
      HWPFDocument doc = new HWPFDocument(is);
      Range range = doc.getRange();
      final ArrayList<Table> tables = CollectionLiterals.<Table>newArrayList();
      TableIterator tableIterator = new TableIterator(range);
      while (tableIterator.hasNext()) {
        {
          Table table = tableIterator.next();
          tables.add(table);
        }
      }
      int _size = tables.size();
      String _plus = ("表格总数：" + Integer.valueOf(_size));
      InputOutput.<String>println(_plus);
      final Consumer<Table> _function = (Table table) -> {
        try {
          int rowNum = table.numRows();
          InputOutput.<Integer>println(Integer.valueOf(rowNum));
          ArrayList<JpaBot.VisonField> fields = CollectionLiterals.<JpaBot.VisonField>newArrayList();
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
              JpaBot.VisonField field = new JpaBot.VisonField(name, type, require, key, comment, show);
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
          JpaBot.VisonTable visonTable = new JpaBot.VisonTable(klassType, klassName, fields);
          CharSequence content = JpaBot.showList(basePackageName, visonTable);
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append(basePath, "");
          _builder_3.append("resources\\static\\views\\");
          String _trim = klassType.trim();
          String _firstLower = StringExtensions.toFirstLower(_trim);
          _builder_3.append(_firstLower, "");
          _builder_3.append("\\");
          String _trim_1 = klassType.trim();
          String _firstLower_1 = StringExtensions.toFirstLower(_trim_1);
          _builder_3.append(_firstLower_1, "");
          _builder_3.append("List.html");
          String path = _builder_3.toString();
          final File file = new File(path);
          Files.createParentDirs(file);
          Files.write(content, file, Charsets.UTF_8);
          CharSequence content2 = JpaBot.add(basePackageName, visonTable);
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append(basePath, "");
          _builder_4.append("resources\\static\\views\\");
          String _trim_2 = klassType.trim();
          String _firstLower_2 = StringExtensions.toFirstLower(_trim_2);
          _builder_4.append(_firstLower_2, "");
          _builder_4.append("\\add");
          String _trim_3 = klassType.trim();
          String _firstUpper = StringExtensions.toFirstUpper(_trim_3);
          _builder_4.append(_firstUpper, "");
          _builder_4.append(".html");
          String path2 = _builder_4.toString();
          final File file2 = new File(path2);
          Files.createParentDirs(file2);
          Files.write(content2, file2, Charsets.UTF_8);
          CharSequence content3 = JpaBot.edit(basePackageName, visonTable);
          StringConcatenation _builder_5 = new StringConcatenation();
          _builder_5.append(basePath, "");
          _builder_5.append("resources\\static\\views\\");
          String _trim_4 = klassType.trim();
          String _firstLower_3 = StringExtensions.toFirstLower(_trim_4);
          _builder_5.append(_firstLower_3, "");
          _builder_5.append("\\edit");
          String _trim_5 = klassType.trim();
          String _firstUpper_1 = StringExtensions.toFirstUpper(_trim_5);
          _builder_5.append(_firstUpper_1, "");
          _builder_5.append(".html");
          String path3 = _builder_5.toString();
          final File file3 = new File(path3);
          Files.createParentDirs(file3);
          Files.write(content3, file3, Charsets.UTF_8);
          CharSequence content4 = JpaBot.jsController(basePackageName, visonTable);
          StringConcatenation _builder_6 = new StringConcatenation();
          _builder_6.append(basePath, "");
          _builder_6.append("resources\\static\\js\\controllers\\");
          String _trim_6 = klassType.trim();
          String _firstLower_4 = StringExtensions.toFirstLower(_trim_6);
          _builder_6.append(_firstLower_4, "");
          _builder_6.append("\\");
          String _trim_7 = klassType.trim();
          String _firstUpper_2 = StringExtensions.toFirstUpper(_trim_7);
          _builder_6.append(_firstUpper_2, "");
          _builder_6.append("Controller.js");
          String path4 = _builder_6.toString();
          final File file4 = new File(path4);
          Files.createParentDirs(file4);
          Files.write(content4, file4, Charsets.UTF_8);
          CharSequence content5 = JpaBot.dataTable(basePackageName, visonTable);
          StringConcatenation _builder_7 = new StringConcatenation();
          _builder_7.append(basePath, "");
          _builder_7.append("resources\\static\\js\\scripts\\");
          String _trim_8 = klassType.trim();
          String _firstLower_5 = StringExtensions.toFirstLower(_trim_8);
          _builder_7.append(_firstLower_5, "");
          _builder_7.append("\\");
          String _trim_9 = klassType.trim();
          String _firstLower_6 = StringExtensions.toFirstLower(_trim_9);
          _builder_7.append(_firstLower_6, "");
          _builder_7.append("Table.js");
          String path5 = _builder_7.toString();
          final File file5 = new File(path5);
          Files.createParentDirs(file5);
          Files.write(content5, file5, Charsets.UTF_8);
          CharSequence content6 = JpaBot.bean(basePackageName, visonTable);
          StringConcatenation _builder_8 = new StringConcatenation();
          _builder_8.append(beanBasePath, "");
          _builder_8.append("model\\");
          String _trim_10 = klassType.trim();
          String _firstUpper_3 = StringExtensions.toFirstUpper(_trim_10);
          _builder_8.append(_firstUpper_3, "");
          _builder_8.append(".java");
          String path6 = _builder_8.toString();
          final File file6 = new File(path6);
          Files.createParentDirs(file6);
          Files.write(content6, file6, Charsets.UTF_8);
          CharSequence content7 = JpaBot.service(basePackageName, visonTable);
          StringConcatenation _builder_9 = new StringConcatenation();
          _builder_9.append(beanBasePath, "");
          _builder_9.append("service\\");
          String _trim_11 = klassType.trim();
          String _firstUpper_4 = StringExtensions.toFirstUpper(_trim_11);
          _builder_9.append(_firstUpper_4, "");
          _builder_9.append("Service.java");
          String path7 = _builder_9.toString();
          final File file7 = new File(path7);
          Files.createParentDirs(file7);
          Files.write(content7, file7, Charsets.UTF_8);
          CharSequence content8 = JpaBot.serviceImpl(basePackageName, visonTable);
          StringConcatenation _builder_10 = new StringConcatenation();
          _builder_10.append(beanBasePath, "");
          _builder_10.append("service\\impl\\");
          String _trim_12 = klassType.trim();
          String _firstUpper_5 = StringExtensions.toFirstUpper(_trim_12);
          _builder_10.append(_firstUpper_5, "");
          _builder_10.append("ServiceImpl.java");
          String path8 = _builder_10.toString();
          final File file8 = new File(path8);
          Files.createParentDirs(file8);
          Files.write(content8, file8, Charsets.UTF_8);
          CharSequence content9 = JpaBot.dao(basePackageName, visonTable);
          StringConcatenation _builder_11 = new StringConcatenation();
          _builder_11.append(beanBasePath, "");
          _builder_11.append("jpa\\");
          String _trim_13 = klassType.trim();
          String _firstUpper_6 = StringExtensions.toFirstUpper(_trim_13);
          _builder_11.append(_firstUpper_6, "");
          _builder_11.append("Repository.java");
          String path9 = _builder_11.toString();
          final File file9 = new File(path9);
          Files.createParentDirs(file9);
          Files.write(content9, file9, Charsets.UTF_8);
          CharSequence content10 = JpaBot.controller(basePackageName, visonTable);
          StringConcatenation _builder_12 = new StringConcatenation();
          _builder_12.append(beanBasePath, "");
          _builder_12.append("\\controller\\");
          String _trim_14 = klassType.trim();
          String _firstUpper_7 = StringExtensions.toFirstUpper(_trim_14);
          _builder_12.append(_firstUpper_7, "");
          _builder_12.append("Controller.java");
          String path10 = _builder_12.toString();
          final File file10 = new File(path10);
          Files.createParentDirs(file10);
          Files.write(content10, file10, Charsets.UTF_8);
          CharSequence content11 = JpaBot.validator(basePackageName, visonTable);
          StringConcatenation _builder_13 = new StringConcatenation();
          _builder_13.append(beanBasePath, "");
          _builder_13.append("\\validator\\");
          String _trim_15 = klassType.trim();
          String _firstUpper_8 = StringExtensions.toFirstUpper(_trim_15);
          _builder_13.append(_firstUpper_8, "");
          _builder_13.append("Validator.java");
          String path11 = _builder_13.toString();
          final File file11 = new File(path11);
          Files.createParentDirs(file11);
          Files.write(content11, file11, Charsets.UTF_8);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      tables.forEach(_function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static CharSequence showList(final String basePackageName, final JpaBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      List<JpaBot.VisonField> _fields = table.getFields();
      final Function1<JpaBot.VisonField, Boolean> _function = (JpaBot.VisonField it) -> {
        String _show = it.getShow();
        return Boolean.valueOf(_show.contains("L"));
      };
      Iterable<JpaBot.VisonField> _filter = IterableExtensions.<JpaBot.VisonField>filter(_fields, _function);
      final List<JpaBot.VisonField> fields = IterableExtensions.<JpaBot.VisonField>toList(_filter);
      List<JpaBot.VisonField> _fields_1 = table.getFields();
      final Function1<JpaBot.VisonField, Boolean> _function_1 = (JpaBot.VisonField it) -> {
        String _show = it.getShow();
        return Boolean.valueOf(_show.contains("S"));
      };
      Iterable<JpaBot.VisonField> _filter_1 = IterableExtensions.<JpaBot.VisonField>filter(_fields_1, _function_1);
      final List<JpaBot.VisonField> searchFields = IterableExtensions.<JpaBot.VisonField>toList(_filter_1);
      String klassType = table.getKlassType();
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
        for(final JpaBot.VisonField f : searchFields) {
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
          String _comment = f.getComment();
          String[] _split = _comment.split("-");
          String _get = _split[0];
          _builder.append(_get, "\t\t\t        ");
          _builder.append("：</label>");
          _builder.newLineIfNotEmpty();
          _builder.append("                    ");
          _builder.append("<div class=\"col-sm-3\">");
          _builder.newLine();
          _builder.append("                         ");
          String _parseSearchInput = JpaBot.parseSearchInput(table, f);
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
              _builder.append("</div>  ");
              _builder.newLine();
            }
          }
          {
            if (((searchFields.indexOf(f) == (((Object[])Conversions.unwrapArray(searchFields, Object.class)).length - 1)) && ((searchFields.indexOf(f) % 3) == 0))) {
              _builder.append(" ");
              _builder.append("<label class=\"col-sm-8 control-label\"><button class=\"btn red\" type=\"reset\"><i class=\"glyphicon glyphicon-repeat\"></i>重置</button><button class=\"btn red search-submit\"><i class=\"glyphicon glyphicon-search\"></i>查询</button></label></div>  ");
              _builder.newLine();
            }
          }
          {
            if (((searchFields.indexOf(f) == (((Object[])Conversions.unwrapArray(searchFields, Object.class)).length - 1)) && ((searchFields.indexOf(f) % 3) == 1))) {
              _builder.append("\t\t\t     ");
              _builder.append("<label class=\"col-sm-4 control-label\"><button class=\"btn red\" type=\"reset\"><i class=\"glyphicon glyphicon-repeat\"></i>重置</button><button class=\"btn red search-submit\"><i class=\"glyphicon glyphicon-search\"></i>查询</button></label>");
              _builder.newLine();
              _builder.append("\t\t\t     ");
              _builder.append("    ");
              _builder.append("</div>  ");
              _builder.newLine();
            }
          }
          {
            if (((searchFields.indexOf(f) == (((Object[])Conversions.unwrapArray(searchFields, Object.class)).length - 1)) && ((searchFields.indexOf(f) % 3) == 2))) {
              _builder.append("\t\t\t         ");
              _builder.append("<div class=\"form-group\">");
              _builder.newLine();
              _builder.append("<label class=\"col-sm-12 control-label\"><button class=\"btn red\" type=\"reset\"><i class=\"glyphicon glyphicon-repeat\"></i>重置</button><button class=\"btn red search-submit\"><i class=\"glyphicon glyphicon-search\"></i>查询</button></label>");
              _builder.newLine();
              _builder.append("\t\t\t         ");
              _builder.append("</div>  ");
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
      _builder.append("<div class=\"portlet box red-intense\">");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("<div class=\"portlet-title\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("<div class=\"caption\">");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      String _klassName = table.getKlassName();
      _builder.append(_klassName, "\t\t\t\t\t\t");
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
        for(final JpaBot.VisonField f_1 : fields) {
          _builder.append("\t\t\t\t\t\t\t\t ");
          _builder.append("<label><input type=\"checkbox\" checked data-column=\"");
          int _indexOf_2 = fields.indexOf(f_1);
          int _plus = (_indexOf_2 + 1);
          _builder.append(_plus, "\t\t\t\t\t\t\t\t ");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t\t\t\t\t\t\t");
          _builder.append("value=\"");
          String _name = f_1.getName();
          String _firstLower_1 = StringExtensions.toFirstLower(_name);
          _builder.append(_firstLower_1, "\t\t\t\t\t\t\t\t\t");
          _builder.append("\">");
          String _comment_1 = f_1.getComment();
          String[] _split_1 = _comment_1.split("-");
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
        for(final JpaBot.VisonField f_2 : fields) {
          _builder.append("\t\t\t\t\t\t\t\t ");
          _builder.append("<th class=\"hidden-xs\">");
          String _comment_2 = f_2.getComment();
          String[] _split_2 = _comment_2.split("-");
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
  
  public static CharSequence add(final String basePackageName, final JpaBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      List<JpaBot.VisonField> _fields = table.getFields();
      final Function1<JpaBot.VisonField, Boolean> _function = (JpaBot.VisonField it) -> {
        String _show = it.getShow();
        return Boolean.valueOf(_show.contains("C"));
      };
      Iterable<JpaBot.VisonField> _filter = IterableExtensions.<JpaBot.VisonField>filter(_fields, _function);
      final List<JpaBot.VisonField> fields = IterableExtensions.<JpaBot.VisonField>toList(_filter);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<div class=\"modal-header\">");
      _builder.newLine();
      _builder.append("     ");
      _builder.append("<h3 class=\"modal-title\">新增");
      String _klassName = table.getKlassName();
      _builder.append(_klassName, "     ");
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
      String _klassType = table.getKlassType();
      String _firstLower = StringExtensions.toFirstLower(_klassType);
      _builder.append(_firstLower, "\t\t\t\t");
      _builder.append("-add-form\" class=\"form-horizontal\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t\t\t");
      _builder.append("<div class=\"form-body\">");
      _builder.newLine();
      {
        for(final JpaBot.VisonField f : fields) {
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
          String _comment = f.getComment();
          String[] _split = _comment.split("-");
          String _get = _split[0];
          _builder.append(_get, "                                ");
          _builder.newLineIfNotEmpty();
          {
            String _require = f.getRequire();
            boolean _contains = _require.contains("A");
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
          String _parseInput = JpaBot.parseInput(table, f);
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
              _builder.append("</div>  ");
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
      _builder.append("\t\t\t");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence edit(final String basePackageName, final JpaBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      List<JpaBot.VisonField> _fields = table.getFields();
      final Function1<JpaBot.VisonField, Boolean> _function = (JpaBot.VisonField it) -> {
        String _show = it.getShow();
        return Boolean.valueOf(_show.contains("H"));
      };
      Iterable<JpaBot.VisonField> _filter = IterableExtensions.<JpaBot.VisonField>filter(_fields, _function);
      final List<JpaBot.VisonField> hideFields = IterableExtensions.<JpaBot.VisonField>toList(_filter);
      List<JpaBot.VisonField> _fields_1 = table.getFields();
      final Function1<JpaBot.VisonField, Boolean> _function_1 = (JpaBot.VisonField it) -> {
        String _show = it.getShow();
        return Boolean.valueOf(_show.contains("U"));
      };
      Iterable<JpaBot.VisonField> _filter_1 = IterableExtensions.<JpaBot.VisonField>filter(_fields_1, _function_1);
      final List<JpaBot.VisonField> fields = IterableExtensions.<JpaBot.VisonField>toList(_filter_1);
      String klassType = table.getKlassType();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<div class=\"modal-header\">");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("<h3 class=\"modal-title\">编辑");
      String _klassName = table.getKlassName();
      _builder.append(_klassName, "\t ");
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
        for(final JpaBot.VisonField f : hideFields) {
          _builder.append("\t\t\t\t ");
          _builder.append("<input type=\"hidden\" class=\"form-control\" ng-model=\"");
          String _firstLower_1 = StringExtensions.toFirstLower(klassType);
          _builder.append(_firstLower_1, "\t\t\t\t ");
          _builder.append(".");
          String _name = f.getName();
          String _firstLower_2 = StringExtensions.toFirstLower(_name);
          _builder.append(_firstLower_2, "\t\t\t\t ");
          _builder.append("\" name=\"");
          String _name_1 = f.getName();
          String _firstLower_3 = StringExtensions.toFirstLower(_name_1);
          _builder.append(_firstLower_3, "\t\t\t\t ");
          _builder.append("\" />");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        for(final JpaBot.VisonField f_1 : fields) {
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
          String _comment = f_1.getComment();
          String[] _split = _comment.split("-");
          String _get = _split[0];
          _builder.append(_get, "\t");
          _builder.newLineIfNotEmpty();
          {
            String _require = f_1.getRequire();
            boolean _contains = _require.contains("A");
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
          String _parseInput = JpaBot.parseInput(table, f_1);
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
              _builder.append("</div>  ");
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
      _builder.append("\t\t\t");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence jsController(final String basePackageName, final JpaBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      String klassType = table.getKlassType();
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
        List<JpaBot.VisonField> _fields = table.getFields();
        final Function1<JpaBot.VisonField, Boolean> _function = (JpaBot.VisonField it) -> {
          String _comment = it.getComment();
          return Boolean.valueOf(_comment.contains("-select"));
        };
        Iterable<JpaBot.VisonField> _filter = IterableExtensions.<JpaBot.VisonField>filter(_fields, _function);
        List<JpaBot.VisonField> _list = IterableExtensions.<JpaBot.VisonField>toList(_filter);
        for(final JpaBot.VisonField f : _list) {
          {
            String _comment = f.getComment();
            String[] _split = _comment.split("-");
            int _length = _split.length;
            boolean _greaterThan = (_length > 2);
            if (_greaterThan) {
              _builder.append("$http.get(\'/controller/v1/");
              String _comment_1 = f.getComment();
              String[] _split_1 = _comment_1.split("-");
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
              String _comment_2 = f.getComment();
              String[] _split_2 = _comment_2.split("-");
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
        List<JpaBot.VisonField> _fields_1 = table.getFields();
        final Function1<JpaBot.VisonField, Boolean> _function_1 = (JpaBot.VisonField it) -> {
          String _comment_3 = it.getComment();
          return Boolean.valueOf(_comment_3.contains("-date"));
        };
        Iterable<JpaBot.VisonField> _filter_1 = IterableExtensions.<JpaBot.VisonField>filter(_fields_1, _function_1);
        List<JpaBot.VisonField> _list_1 = IterableExtensions.<JpaBot.VisonField>toList(_filter_1);
        for(final JpaBot.VisonField f_1 : _list_1) {
          _builder.append("$scope.$watch(\'");
          String _comment_3 = f_1.getComment();
          String[] _split_3 = _comment_3.split("-");
          String _get_2 = _split_3[0];
          String _firstLower_2 = StringExtensions.toFirstLower(_get_2);
          _builder.append(_firstLower_2, "");
          _builder.append("\', function(newValue, oldValue) {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("$scope.");
          String _comment_4 = f_1.getComment();
          String[] _split_4 = _comment_4.split("-");
          String _get_3 = _split_4[0];
          String _firstLower_3 = StringExtensions.toFirstLower(_get_3);
          _builder.append(_firstLower_3, "\t");
          _builder.append("_LTE = moment($scope.");
          String _comment_5 = f_1.getComment();
          String[] _split_5 = _comment_5.split("-");
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
      _builder.append("\t");
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
      _builder.append("\t\t");
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
        List<JpaBot.VisonField> _fields_2 = table.getFields();
        final Function1<JpaBot.VisonField, Boolean> _function_2 = (JpaBot.VisonField it) -> {
          String _comment_6 = it.getComment();
          return Boolean.valueOf(_comment_6.contains("-select"));
        };
        Iterable<JpaBot.VisonField> _filter_2 = IterableExtensions.<JpaBot.VisonField>filter(_fields_2, _function_2);
        List<JpaBot.VisonField> _list_2 = IterableExtensions.<JpaBot.VisonField>toList(_filter_2);
        for(final JpaBot.VisonField f_2 : _list_2) {
          {
            String _comment_6 = f_2.getComment();
            String[] _split_6 = _comment_6.split("-");
            int _length_1 = _split_6.length;
            boolean _greaterThan_1 = (_length_1 > 2);
            if (_greaterThan_1) {
              _builder.append("$http.get(\'/controller/v1/");
              String _comment_7 = f_2.getComment();
              String[] _split_7 = _comment_7.split("-");
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
              String _comment_8 = f_2.getComment();
              String[] _split_8 = _comment_8.split("-");
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
      _builder.append("focusInvalid : false, ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ignore : \"\", ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("rules : {");
      _builder.newLine();
      {
        List<JpaBot.VisonField> _fields_3 = table.getFields();
        final Function1<JpaBot.VisonField, Boolean> _function_3 = (JpaBot.VisonField it) -> {
          String _require = it.getRequire();
          String _upperCase = _require.toUpperCase();
          return Boolean.valueOf(_upperCase.contains("A"));
        };
        Iterable<JpaBot.VisonField> _filter_3 = IterableExtensions.<JpaBot.VisonField>filter(_fields_3, _function_3);
        List<JpaBot.VisonField> _list_3 = IterableExtensions.<JpaBot.VisonField>toList(_filter_3);
        for(final JpaBot.VisonField f_3 : _list_3) {
          _builder.append("\t\t\t\t");
          String _name = f_3.getName();
          _builder.append(_name, "\t\t\t\t");
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
        List<JpaBot.VisonField> _fields_4 = table.getFields();
        final Function1<JpaBot.VisonField, Boolean> _function_4 = (JpaBot.VisonField it) -> {
          String _require = it.getRequire();
          String _upperCase = _require.toUpperCase();
          return Boolean.valueOf(_upperCase.contains("A"));
        };
        Iterable<JpaBot.VisonField> _filter_4 = IterableExtensions.<JpaBot.VisonField>filter(_fields_4, _function_4);
        List<JpaBot.VisonField> _list_4 = IterableExtensions.<JpaBot.VisonField>toList(_filter_4);
        for(final JpaBot.VisonField f_4 : _list_4) {
          _builder.append("\t\t\t\t");
          String _name_1 = f_4.getName();
          _builder.append(_name_1, "\t\t\t\t");
          _builder.append(" : {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t\t");
          _builder.append("\t");
          _builder.append("required : \"请输入");
          String _comment_9 = f_4.getComment();
          String[] _split_9 = _comment_9.split("-");
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
      _builder.append("unhighlight : function(element) { ");
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
        List<JpaBot.VisonField> _fields_5 = table.getFields();
        final Function1<JpaBot.VisonField, Boolean> _function_5 = (JpaBot.VisonField it) -> {
          String _comment_10 = it.getComment();
          return Boolean.valueOf(_comment_10.contains("-select"));
        };
        Iterable<JpaBot.VisonField> _filter_5 = IterableExtensions.<JpaBot.VisonField>filter(_fields_5, _function_5);
        List<JpaBot.VisonField> _list_5 = IterableExtensions.<JpaBot.VisonField>toList(_filter_5);
        for(final JpaBot.VisonField f_5 : _list_5) {
          {
            String _comment_10 = f_5.getComment();
            String[] _split_10 = _comment_10.split("-");
            int _length_2 = _split_10.length;
            boolean _greaterThan_2 = (_length_2 > 2);
            if (_greaterThan_2) {
              _builder.append("$scope.");
              String _firstLower_11 = StringExtensions.toFirstLower(klassType);
              _builder.append(_firstLower_11, "");
              _builder.append(".");
              String _comment_11 = f_5.getComment();
              String[] _split_11 = _comment_11.split("-");
              String _get_8 = _split_11[2];
              String _firstLower_12 = StringExtensions.toFirstLower(_get_8);
              _builder.append(_firstLower_12, "");
              _builder.append(" = $scope.");
              String _comment_12 = f_5.getComment();
              String[] _split_12 = _comment_12.split("-");
              String _get_9 = _split_12[2];
              String _firstLower_13 = StringExtensions.toFirstLower(_get_9);
              _builder.append(_firstLower_13, "");
              _builder.append(".id; ");
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
        List<JpaBot.VisonField> _fields_6 = table.getFields();
        final Function1<JpaBot.VisonField, Boolean> _function_6 = (JpaBot.VisonField it) -> {
          String _comment_13 = it.getComment();
          return Boolean.valueOf(_comment_13.contains("-select"));
        };
        Iterable<JpaBot.VisonField> _filter_6 = IterableExtensions.<JpaBot.VisonField>filter(_fields_6, _function_6);
        List<JpaBot.VisonField> _list_6 = IterableExtensions.<JpaBot.VisonField>toList(_filter_6);
        for(final JpaBot.VisonField f_6 : _list_6) {
          {
            String _comment_13 = f_6.getComment();
            String[] _split_13 = _comment_13.split("-");
            int _length_3 = _split_13.length;
            boolean _greaterThan_3 = (_length_3 > 2);
            if (_greaterThan_3) {
              _builder.append("$scope.");
              String _comment_14 = f_6.getComment();
              String[] _split_14 = _comment_14.split("-");
              String _get_10 = _split_14[2];
              String _firstLower_16 = StringExtensions.toFirstLower(_get_10);
              _builder.append(_firstLower_16, "");
              _builder.append("s = [];");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
              _builder.append("$http.get(\'/controller/v1/");
              String _comment_15 = f_6.getComment();
              String[] _split_15 = _comment_15.split("-");
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
              String _comment_16 = f_6.getComment();
              String[] _split_16 = _comment_16.split("-");
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
      _builder.append("/?id_EQ=\' + id, \"\").success(function(data, status, headers, config) {");
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
        List<JpaBot.VisonField> _fields_7 = table.getFields();
        final Function1<JpaBot.VisonField, Boolean> _function_7 = (JpaBot.VisonField it) -> {
          String _comment_17 = it.getComment();
          return Boolean.valueOf(_comment_17.contains("-select"));
        };
        Iterable<JpaBot.VisonField> _filter_7 = IterableExtensions.<JpaBot.VisonField>filter(_fields_7, _function_7);
        List<JpaBot.VisonField> _list_7 = IterableExtensions.<JpaBot.VisonField>toList(_filter_7);
        for(final JpaBot.VisonField f_7 : _list_7) {
          {
            String _comment_17 = f_7.getComment();
            String[] _split_17 = _comment_17.split("-");
            int _length_4 = _split_17.length;
            boolean _greaterThan_4 = (_length_4 > 2);
            if (_greaterThan_4) {
              _builder.append("$scope.");
              String _comment_18 = f_7.getComment();
              String[] _split_18 = _comment_18.split("-");
              String _get_13 = _split_18[2];
              String _firstLower_21 = StringExtensions.toFirstLower(_get_13);
              _builder.append(_firstLower_21, "");
              _builder.append(" = _.find($scope.");
              String _comment_19 = f_7.getComment();
              String[] _split_19 = _comment_19.split("-");
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
              String _comment_20 = f_7.getComment();
              String[] _split_20 = _comment_20.split("-");
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
      _builder.append("\t");
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
      _builder.append("errorElement : \'span\', ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("errorClass : \'help-block help-block-error\',");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("focusInvalid : false, ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("ignore : \"\", ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("rules : {");
      _builder.newLine();
      {
        List<JpaBot.VisonField> _fields_8 = table.getFields();
        final Function1<JpaBot.VisonField, Boolean> _function_8 = (JpaBot.VisonField it) -> {
          String _require = it.getRequire();
          String _upperCase = _require.toUpperCase();
          return Boolean.valueOf(_upperCase.contains("A"));
        };
        Iterable<JpaBot.VisonField> _filter_8 = IterableExtensions.<JpaBot.VisonField>filter(_fields_8, _function_8);
        List<JpaBot.VisonField> _list_8 = IterableExtensions.<JpaBot.VisonField>toList(_filter_8);
        for(final JpaBot.VisonField f_8 : _list_8) {
          _builder.append("\t\t\t\t");
          String _name_2 = f_8.getName();
          _builder.append(_name_2, "\t\t\t\t");
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
        List<JpaBot.VisonField> _fields_9 = table.getFields();
        final Function1<JpaBot.VisonField, Boolean> _function_9 = (JpaBot.VisonField it) -> {
          String _require = it.getRequire();
          String _upperCase = _require.toUpperCase();
          return Boolean.valueOf(_upperCase.contains("A"));
        };
        Iterable<JpaBot.VisonField> _filter_9 = IterableExtensions.<JpaBot.VisonField>filter(_fields_9, _function_9);
        List<JpaBot.VisonField> _list_9 = IterableExtensions.<JpaBot.VisonField>toList(_filter_9);
        for(final JpaBot.VisonField f_9 : _list_9) {
          _builder.append("\t\t\t\t");
          String _name_3 = f_9.getName();
          _builder.append(_name_3, "\t\t\t\t");
          _builder.append(" : {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t\t");
          _builder.append("\t");
          _builder.append("required : \"请输入");
          String _comment_21 = f_9.getComment();
          String[] _split_21 = _comment_21.split("-");
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
      _builder.append("unhighlight : function(element) { ");
      _builder.newLine();
      _builder.append("\t\t\t\t");
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
        List<JpaBot.VisonField> _fields_10 = table.getFields();
        final Function1<JpaBot.VisonField, Boolean> _function_10 = (JpaBot.VisonField it) -> {
          String _comment_22 = it.getComment();
          return Boolean.valueOf(_comment_22.contains("-select"));
        };
        Iterable<JpaBot.VisonField> _filter_10 = IterableExtensions.<JpaBot.VisonField>filter(_fields_10, _function_10);
        List<JpaBot.VisonField> _list_10 = IterableExtensions.<JpaBot.VisonField>toList(_filter_10);
        for(final JpaBot.VisonField f_10 : _list_10) {
          {
            String _comment_22 = f_10.getComment();
            String[] _split_22 = _comment_22.split("-");
            int _length_5 = _split_22.length;
            boolean _greaterThan_5 = (_length_5 > 2);
            if (_greaterThan_5) {
              _builder.append("$scope.");
              String _firstLower_26 = StringExtensions.toFirstLower(klassType);
              _builder.append(_firstLower_26, "");
              _builder.append(".");
              String _comment_23 = f_10.getComment();
              String[] _split_23 = _comment_23.split("-");
              String _get_17 = _split_23[2];
              String _firstLower_27 = StringExtensions.toFirstLower(_get_17);
              _builder.append(_firstLower_27, "");
              _builder.append(" = $scope.");
              String _comment_24 = f_10.getComment();
              String[] _split_24 = _comment_24.split("-");
              String _get_18 = _split_24[2];
              String _firstLower_28 = StringExtensions.toFirstLower(_get_18);
              _builder.append(_firstLower_28, "");
              _builder.append(".id; ");
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
  
  public static CharSequence dataTable(final String basePackageName, final JpaBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      List<JpaBot.VisonField> _fields = table.getFields();
      final Function1<JpaBot.VisonField, Boolean> _function = (JpaBot.VisonField it) -> {
        String _require = it.getRequire();
        boolean _contains = _require.contains("L");
        return Boolean.valueOf((!_contains));
      };
      Iterable<JpaBot.VisonField> _filter = IterableExtensions.<JpaBot.VisonField>filter(_fields, _function);
      final List<JpaBot.VisonField> fields = IterableExtensions.<JpaBot.VisonField>toList(_filter);
      String klassType = table.getKlassType();
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
      _builder.append("\"language\" : {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("\"aria\" : {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("\"sortAscending\" : \"激活升序排序\",");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("\"sortDescending\" : \"激活降序排序\"");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("},");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("\"processing\" : \"正在加载...\",");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("\"emptyTable\" : \"表中没有数据\",");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("\"info\" : \"显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录\",");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("\"infoEmpty\" : \"显示 0 到 0 条，共 0 条记录\",");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("\"infoFiltered\" : \"(由原数据集 _MAX_ 条记录中过滤所得)\",");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("\"lengthMenu\" : \"_MENU_ 条记录每页\",");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("\"search\" : \"搜索:\",");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("\"zeroRecords\" : \"没有搜索到符合条件的记录\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("},");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\"searching\" : false,");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\"dom\" : \"<\'row\'<\'col-sm-10 hs-btns\'><\'col-sm-2\'l>>\" + \"<\'row\'<\'col-sm-12\'tr>>\" + \"<\'row\'<\'col-sm-5\'i><\'col-sm-7\'p>>\",");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\"columnDefs\" : [ {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("\"searchable\" : false,");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("\"orderable\" : false,");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("\"targets\" : 0");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("} ],");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\"order\" : [ [ 1, \'asc\' ] ],");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\"lengthMenu\" : [ [ 5, 10, 20, 30, 50 ], [ 5, 10, 20, 30, 50 ] ");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("],");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\"pageLength\" : 20,");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\"processing\" : true,");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\"serverSide\" : true,");
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
      _builder.append("\"bStateSave\" : false, ");
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
      _builder.append("return \'<label class=\"checkbox\"><div class=\"checker \"><span class=\"\"><input type=\"checkbox\" class=\"checkboxes\" value=\"\' + data.id");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t\t\t\t");
      _builder.append("+ \'\"/></span></div><span class=\"index-number\"></span></label>\';");
      _builder.newLine();
      _builder.append("\t\t\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("},");
      {
        List<JpaBot.VisonField> _fields_1 = table.getFields();
        final Function1<JpaBot.VisonField, Boolean> _function_1 = (JpaBot.VisonField it) -> {
          String _show = it.getShow();
          return Boolean.valueOf(_show.contains("L"));
        };
        Iterable<JpaBot.VisonField> _filter_1 = IterableExtensions.<JpaBot.VisonField>filter(_fields_1, _function_1);
        List<JpaBot.VisonField> _list = IterableExtensions.<JpaBot.VisonField>toList(_filter_1);
        for(final JpaBot.VisonField f : _list) {
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t\t\t");
          _builder.append("{");
          _builder.newLine();
          _builder.append("\t\t\t\t\t");
          _builder.append("    ");
          _builder.append("\"data\" : \"");
          String _name = f.getName();
          _builder.append(_name, "\t\t\t\t\t    ");
          _builder.append("\",");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t\t\t\t");
          _builder.append("    ");
          _builder.append("\"defaultContent\" : \"\"");
          _builder.newLine();
          _builder.append("\t\t\t\t\t");
          _builder.append("}");
          {
            int _indexOf = fields.indexOf(f);
            int _length = ((Object[])Conversions.unwrapArray(fields, Object.class)).length;
            int _minus = (_length - 1);
            boolean _notEquals = (_indexOf != _minus);
            if (_notEquals) {
              _builder.append(",");
            }
          }
          _builder.append(" ");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t\t\t\t");
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
      String _firstLower_2 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_2, "\t\t");
      _builder.append("_sample_4_wrapper\'); ");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("var tableColumnToggler = $(\'#");
      String _firstLower_3 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_3, "\t\t");
      _builder.append("_sample_4_column_toggler\');");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("tableWrapper.find(\'.dataTables_length select\').select2(); ");
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
      _builder.append("table.find(\'.group-checkable\').change(function() {");
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
      String _firstLower_4 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_4, "\t\t\t\t");
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
      String _firstLower_5 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_5, "\t\t\t\t");
      _builder.append("-editBtn\").attr(\"disabled\", false);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$(\"#");
      String _firstLower_6 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_6, "\t\t\t\t");
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
      String _firstLower_7 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_7, "\t\t\t\t");
      _builder.append("-deleteBtn\").attr(\"disabled\", false);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("$(\"#");
      String _firstLower_8 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_8, "\t\t\t\t");
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
      String _firstLower_9 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_9, "\t\t\t");
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
      String _firstLower_10 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_10, "\t\t");
      _builder.append("-editBtn\").attr(\"disabled\", true);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("$(\"#");
      String _firstLower_11 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_11, "\t\t");
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
  
  public static CharSequence bean(final String basePackageName, final JpaBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      final List<JpaBot.VisonField> fields = table.getFields();
      String klassType = table.getKlassType();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".model;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import javax.persistence.Entity;");
      _builder.newLine();
      _builder.append("import javax.persistence.GeneratedValue;");
      _builder.newLine();
      _builder.append("import javax.persistence.Id;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.HashCodeBuilder;");
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.EqualsBuilder;");
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.ToStringBuilder;");
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.ToStringStyle;");
      _builder.newLine();
      _builder.append("import org.hibernate.annotations.GenericGenerator;");
      _builder.newLine();
      {
        for(final JpaBot.VisonField f : fields) {
          {
            String _javaType = f.javaType();
            String _upperCase = _javaType.toUpperCase();
            boolean _equals = _upperCase.equals("DATE");
            if (_equals) {
              _builder.newLine();
              _builder.append("import java.util.Date;");
              _builder.newLine();
              _builder.newLine();
              _builder.append("import org.springframework.format.annotation.DateTimeFormat;");
              _builder.newLine();
              _builder.append("import com.google.gson.annotations.JsonAdapter;");
              _builder.newLine();
              _builder.append("import cn.visionchina.gson.adapter.Yyyy_MM_ddAdapter;");
              _builder.newLine();
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("@Entity");
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(klassType, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        for(final JpaBot.VisonField f_1 : fields) {
          _builder.append("\t");
          _builder.append("/**");
          String _comment = f_1.getComment();
          String[] _split = _comment.split("-");
          String _get = _split[0];
          _builder.append(_get, "\t");
          _builder.append("**/");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          String _parseFieldAnnotation = JpaBot.parseFieldAnnotation(f_1);
          _builder.append(_parseFieldAnnotation, "\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(klassType, "\t");
      _builder.append("(){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(klassType, "\t");
      _builder.append("(");
      final Function1<JpaBot.VisonField, String> _function = (JpaBot.VisonField it) -> {
        String _javaType_1 = it.javaType();
        String _plus = (_javaType_1 + " ");
        String _name = it.getName();
        String _firstLower = StringExtensions.toFirstLower(_name);
        return (_plus + _firstLower);
      };
      List<String> _map = ListExtensions.<JpaBot.VisonField, String>map(fields, _function);
      String _join = IterableExtensions.join(_map, ",");
      _builder.append(_join, "\t");
      _builder.append("){");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("super();");
      _builder.newLine();
      {
        for(final JpaBot.VisonField f_2 : fields) {
          _builder.append("\t\t");
          _builder.append("this.");
          String _name = f_2.getName();
          String _firstLower = StringExtensions.toFirstLower(_name);
          _builder.append(_firstLower, "\t\t");
          _builder.append("=");
          String _name_1 = f_2.getName();
          String _firstLower_1 = StringExtensions.toFirstLower(_name_1);
          _builder.append(_firstLower_1, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      {
        for(final JpaBot.VisonField f_3 : fields) {
          _builder.append("\t");
          _builder.append("public ");
          String _javaType_1 = f_3.javaType();
          _builder.append(_javaType_1, "\t");
          _builder.append(" get");
          String _name_2 = f_3.getName();
          String _firstUpper = StringExtensions.toFirstUpper(_name_2);
          _builder.append(_firstUpper, "\t");
          _builder.append("() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return ");
          String _name_3 = f_3.getName();
          String _firstLower_2 = StringExtensions.toFirstLower(_name_3);
          _builder.append(_firstLower_2, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void set");
          String _name_4 = f_3.getName();
          String _firstUpper_1 = StringExtensions.toFirstUpper(_name_4);
          _builder.append(_firstUpper_1, "\t");
          _builder.append("(");
          String _javaType_2 = f_3.javaType();
          _builder.append(_javaType_2, "\t");
          _builder.append(" ");
          String _name_5 = f_3.getName();
          String _firstLower_3 = StringExtensions.toFirstLower(_name_5);
          _builder.append(_firstLower_3, "\t");
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("this.");
          String _name_6 = f_3.getName();
          String _firstLower_4 = StringExtensions.toFirstLower(_name_6);
          _builder.append(_firstLower_4, "\t\t");
          _builder.append(" = ");
          String _name_7 = f_3.getName();
          String _firstLower_5 = StringExtensions.toFirstLower(_name_7);
          _builder.append(_firstLower_5, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t");
      _builder.append("@Override ");
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
      _builder.append("@Override ");
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
      _builder.append("@Override ");
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
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence service(final String basePackageName, final JpaBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      String klassType = table.getKlassType();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".service;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.springframework.data.domain.Page;");
      _builder.newLine();
      _builder.append("import org.springframework.data.domain.PageRequest;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import ");
      _builder.append(basePackageName, "");
      _builder.append(".model.");
      _builder.append(klassType, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("import com.github.east196.xcode.common.SearchFilter;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public interface ");
      _builder.append(klassType, "");
      _builder.append("Service {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public List<");
      _builder.append(klassType, "\t");
      _builder.append("> findAll(List<SearchFilter> searchFilters);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public Page<");
      _builder.append(klassType, "\t");
      _builder.append("> findAll(List<SearchFilter> searchFilters, PageRequest pageRequest);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void save(");
      _builder.append(klassType, "\t");
      _builder.append(" ");
      String _firstLower = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower, "\t");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public void delete(String id);");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence serviceImpl(final String basePackageName, final JpaBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      String klassType = table.getKlassType();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".service.impl;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.springframework.beans.factory.annotation.Autowired;");
      _builder.newLine();
      _builder.append("import org.springframework.data.domain.Page;");
      _builder.newLine();
      _builder.append("import org.springframework.data.domain.PageRequest;");
      _builder.newLine();
      _builder.append("import org.springframework.data.jpa.domain.Specification;");
      _builder.newLine();
      _builder.append("import org.springframework.stereotype.Service;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import ");
      _builder.append(basePackageName, "");
      _builder.append(".jpa.");
      _builder.append(klassType, "");
      _builder.append("Repository;");
      _builder.newLineIfNotEmpty();
      _builder.append("import ");
      _builder.append(basePackageName, "");
      _builder.append(".model.");
      _builder.append(klassType, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("import ");
      _builder.append(basePackageName, "");
      _builder.append(".service.");
      _builder.append(klassType, "");
      _builder.append("Service;");
      _builder.newLineIfNotEmpty();
      _builder.append("import com.github.east196.xcode.common.DynamicSpecifications;");
      _builder.newLine();
      _builder.append("import com.github.east196.xcode.common.SearchFilter;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Service");
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(klassType, "");
      _builder.append("ServiceImpl implements ");
      _builder.append(klassType, "");
      _builder.append("Service{");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Autowired");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private ");
      _builder.append(klassType, "\t");
      _builder.append("Repository ");
      String _firstLower = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower, "\t");
      _builder.append("Repository;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("public List<");
      _builder.append(klassType, "    ");
      _builder.append("> findAll(List<SearchFilter> searchFilters) {");
      _builder.newLineIfNotEmpty();
      _builder.append("    \t ");
      _builder.append("Specification<");
      _builder.append(klassType, "    \t ");
      _builder.append("> spec = DynamicSpecifications.bySearchFilter(searchFilters, ");
      _builder.append(klassType, "    \t ");
      _builder.append(".class);");
      _builder.newLineIfNotEmpty();
      _builder.append("         ");
      _builder.append("return ");
      String _firstLower_1 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_1, "         ");
      _builder.append("Repository.findAll(spec);");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("public Page<");
      _builder.append(klassType, "    ");
      _builder.append("> findAll(List<SearchFilter> searchFilters, PageRequest pageRequest) {");
      _builder.newLineIfNotEmpty();
      _builder.append("    \t");
      _builder.append("Specification<");
      _builder.append(klassType, "    \t");
      _builder.append("> spec = DynamicSpecifications.bySearchFilter(searchFilters, ");
      _builder.append(klassType, "    \t");
      _builder.append(".class);");
      _builder.newLineIfNotEmpty();
      _builder.append("         ");
      _builder.append("return ");
      String _firstLower_2 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_2, "         ");
      _builder.append("Repository.findAll(spec, pageRequest);");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("public void save(");
      _builder.append(klassType, "    ");
      _builder.append(" ");
      String _firstLower_3 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_3, "    ");
      _builder.append(") {");
      _builder.newLineIfNotEmpty();
      _builder.append("         ");
      String _firstLower_4 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_4, "         ");
      _builder.append("Repository.saveAndFlush(");
      String _firstLower_5 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_5, "         ");
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
      _builder.append("public void delete(String id) {");
      _builder.newLine();
      _builder.append("         ");
      String _firstLower_6 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_6, "         ");
      _builder.append("Repository.deleteById(id);");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence dao(final String basePackageName, final JpaBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      String klassType = table.getKlassType();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".jpa;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.springframework.data.jpa.repository.JpaRepository;");
      _builder.newLine();
      _builder.append("import org.springframework.data.jpa.repository.JpaSpecificationExecutor;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import ");
      _builder.append(basePackageName, "");
      _builder.append(".model.");
      _builder.append(klassType, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("public interface ");
      _builder.append(klassType, "");
      _builder.append("Repository extends JpaRepository<");
      _builder.append(klassType, "");
      _builder.append(", String>, JpaSpecificationExecutor<");
      _builder.append(klassType, "");
      _builder.append("> {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence controller(final String basePackageName, final JpaBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      String klassType = table.getKlassType();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".controller;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.append("import java.util.Map;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import javax.servlet.http.HttpServletRequest;");
      _builder.newLine();
      _builder.append("import javax.validation.Valid;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.slf4j.Logger;");
      _builder.newLine();
      _builder.append("import org.slf4j.LoggerFactory;");
      _builder.newLine();
      _builder.append("import org.springframework.beans.factory.annotation.Autowired;");
      _builder.newLine();
      _builder.append("import org.springframework.data.domain.Page;");
      _builder.newLine();
      _builder.append("import org.springframework.data.domain.PageRequest;");
      _builder.newLine();
      _builder.append("import org.springframework.validation.BindingResult;");
      _builder.newLine();
      _builder.append("import org.springframework.validation.DataBinder;");
      _builder.newLine();
      _builder.append("import org.springframework.validation.ObjectError;");
      _builder.newLine();
      _builder.append("import org.springframework.web.bind.annotation.InitBinder;");
      _builder.newLine();
      _builder.append("import org.springframework.web.bind.annotation.PathVariable;");
      _builder.newLine();
      _builder.append("import org.springframework.web.bind.annotation.RequestBody;");
      _builder.newLine();
      _builder.append("import org.springframework.web.bind.annotation.RequestMapping;");
      _builder.newLine();
      _builder.append("import org.springframework.web.bind.annotation.RequestMethod;");
      _builder.newLine();
      _builder.append("import org.springframework.web.bind.annotation.RequestParam;");
      _builder.newLine();
      _builder.append("import org.springframework.web.bind.annotation.RestController;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import com.github.east196.xcode.common.DataTableResult;");
      _builder.newLine();
      _builder.append("import com.github.east196.xcode.common.SearchFilter;");
      _builder.newLine();
      _builder.append("import ");
      _builder.append(basePackageName, "");
      _builder.append(".model.");
      _builder.append(klassType, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("import ");
      _builder.append(basePackageName, "");
      _builder.append(".service.");
      _builder.append(klassType, "");
      _builder.append("Service;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import com.github.east196.xcode.common.DataResponse;");
      _builder.newLine();
      _builder.append("import com.github.east196.xcode.common.Response;");
      _builder.newLine();
      _builder.append("import ");
      _builder.append(basePackageName, "");
      _builder.append(".validator.");
      _builder.append(klassType, "");
      _builder.append("Validator;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("@RestController");
      _builder.newLine();
      _builder.append("@RequestMapping(\"/controller/v1/");
      String _firstLower = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower, "");
      _builder.append("\")");
      _builder.newLineIfNotEmpty();
      _builder.append("public class ");
      _builder.append(klassType, "");
      _builder.append("Controller {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("private static final Logger LOGGER = LoggerFactory.getLogger(");
      _builder.append(klassType, "");
      _builder.append(".class);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Autowired");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private ");
      _builder.append(klassType, "\t");
      _builder.append("Service ");
      String _firstLower_1 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_1, "\t");
      _builder.append("Service;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@RequestMapping(value = \"/\", method = RequestMethod.GET)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public DataResponse<List<");
      _builder.append(klassType, "\t");
      _builder.append(">> ");
      String _firstLower_2 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_2, "\t");
      _builder.append("(HttpServletRequest request) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("Map<String, String[]> requestParameterMap = request.getParameterMap();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("List<SearchFilter> searchFilters = SearchFilter.from(requestParameterMap, ");
      _builder.append(klassType, "\t\t");
      _builder.append(".class);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("List<");
      _builder.append(klassType, "\t\t");
      _builder.append("> ");
      String _firstLower_3 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_3, "\t\t");
      _builder.append("s = ");
      String _firstLower_4 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_4, "\t\t");
      _builder.append("Service.findAll(searchFilters);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("return new DataResponse<List<");
      _builder.append(klassType, "\t\t");
      _builder.append(">>(\"0\", \"查询成功!\", ");
      String _firstLower_5 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_5, "\t\t");
      _builder.append("s);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@RequestMapping(value = \"/page\", method = RequestMethod.POST)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public DataTableResult page(@RequestParam(value = \"draw\", required = false, defaultValue = \"1\") Integer sEcho,");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@RequestParam(value = \"start\", required = false, defaultValue = \"0\") Integer iDisplayStart,");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@RequestParam(value = \"length\", required = false, defaultValue = \"20\") Integer numPerPage,");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("HttpServletRequest request) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Map<String, String[]> requestParameterMap = request.getParameterMap();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("List<SearchFilter> searchFilters = SearchFilter.from(requestParameterMap, ");
      _builder.append(klassType, "\t\t");
      _builder.append(".class);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("PageRequest pageRequest = SearchFilter.sort(requestParameterMap, iDisplayStart, numPerPage);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Page<");
      _builder.append(klassType, "\t\t");
      _builder.append("> ");
      String _firstLower_6 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_6, "\t\t");
      _builder.append("s = ");
      String _firstLower_7 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_7, "\t\t");
      _builder.append("Service.findAll(searchFilters, pageRequest);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("DataTableResult dataTableResult = new DataTableResult();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("dataTableResult.setDraw(sEcho);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("dataTableResult.setRecordsTotal(");
      String _firstLower_8 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_8, "\t\t");
      _builder.append("s.getTotalElements());");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("dataTableResult.setRecordsFiltered(");
      String _firstLower_9 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_9, "\t\t");
      _builder.append("s.getTotalElements());");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("dataTableResult.setData(");
      String _firstLower_10 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_10, "\t\t");
      _builder.append("s.getContent());");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("return dataTableResult;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@RequestMapping(value = \"/\", method = RequestMethod.POST)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public Response ");
      String _firstLower_11 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_11, "\t");
      _builder.append("Add(@RequestBody @Valid ");
      _builder.append(klassType, "\t");
      _builder.append(" ");
      String _firstLower_12 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_12, "\t");
      _builder.append(", BindingResult result) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("LOGGER.debug(\"add ");
      String _firstLower_13 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_13, "\t\t");
      _builder.append(":  {}\", ");
      String _firstLower_14 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_14, "\t\t");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("if (result.hasErrors()) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("StringBuffer sb = new StringBuffer();");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("for (ObjectError msg : result.getAllErrors())");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("sb.append(msg.getDefaultMessage()).append(\" \");");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("return new Response(\"-1\", sb.toString());");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t");
      String _firstLower_15 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_15, "\t\t\t");
      _builder.append("Service.save(");
      String _firstLower_16 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_16, "\t\t\t");
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t    ");
      _builder.append("return new Response(\"0\", \"ok\");");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@RequestMapping(value = \"/{id}\", method = RequestMethod.DELETE)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public Response ");
      String _firstLower_17 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_17, "\t");
      _builder.append("Delete(@PathVariable String id) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("LOGGER.debug(\"id:  {}\", id);");
      _builder.newLine();
      _builder.append("\t\t");
      String _firstLower_18 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_18, "\t\t");
      _builder.append("Service.delete(id);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("return new Response(\"0\", \"ok\");");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@RequestMapping(value = \"/deletes\", method = RequestMethod.POST)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public Response ");
      String _firstLower_19 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_19, "\t");
      _builder.append("Deletes(@RequestBody List<String> ids) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("LOGGER.debug(\"ids:  {}\", ids);");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("for (String id : ids) {");
      _builder.newLine();
      _builder.append("\t\t\t");
      String _firstLower_20 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_20, "\t\t\t");
      _builder.append("Service.delete(id);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return new Response(\"0\", \"ok\");");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@InitBinder(\"");
      String _firstLower_21 = StringExtensions.toFirstLower(klassType);
      _builder.append(_firstLower_21, "\t");
      _builder.append("\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("public void initBinder(DataBinder binder) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("binder.setValidator(new ");
      _builder.append(klassType, "\t\t");
      _builder.append("Validator());");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence validator(final String basePackageName, final JpaBot.VisonTable table) {
    CharSequence _xblockexpression = null;
    {
      List<JpaBot.VisonField> fields = table.getFields();
      String klassType = table.getKlassType();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".validator;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.springframework.validation.Errors;");
      _builder.newLine();
      _builder.append("import org.springframework.validation.ValidationUtils;");
      _builder.newLine();
      _builder.append("import org.springframework.validation.Validator;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import ");
      _builder.append(basePackageName, "");
      _builder.append(".model.");
      _builder.append(klassType, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
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
        final Function1<JpaBot.VisonField, Boolean> _function = (JpaBot.VisonField it) -> {
          String _require = it.getRequire();
          String _upperCase = _require.toUpperCase();
          return Boolean.valueOf(_upperCase.contains("A"));
        };
        Iterable<JpaBot.VisonField> _filter = IterableExtensions.<JpaBot.VisonField>filter(fields, _function);
        List<JpaBot.VisonField> _list = IterableExtensions.<JpaBot.VisonField>toList(_filter);
        for(final JpaBot.VisonField f : _list) {
          _builder.append("\t\t");
          _builder.append("ValidationUtils.rejectIfEmpty(arg1, \"");
          String _name = f.getName();
          String _firstLower = StringExtensions.toFirstLower(_name);
          _builder.append(_firstLower, "\t\t");
          _builder.append("\", null, \"");
          String _comment = f.getComment();
          _builder.append(_comment, "\t\t");
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
  
  public static String parseSearchInput(final JpaBot.VisonTable t, final JpaBot.VisonField f) {
    String _switchResult = null;
    String _comment = f.getComment();
    boolean _matched = false;
    String _comment_1 = f.getComment();
    boolean _contains = _comment_1.contains("-date");
    if (_contains) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<div class=\"input-group input-large date-picker input-daterange\" data-date-format=\"yyyy-mm-dd\">");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("<input type=\"text\" class=\"form-control\" name=\"");
      String _name = f.getName();
      String _firstLower = StringExtensions.toFirstLower(_name);
      _builder.append(_firstLower, "\t ");
      _builder.append("_GTE\"> ");
      _builder.newLineIfNotEmpty();
      _builder.append("\t ");
      _builder.append("<span class=\"input-group-addon\">至</span> ");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("<input type=\"text\" class=\"form-control\" name=\"");
      String _name_1 = f.getName();
      String _firstLower_1 = StringExtensions.toFirstLower(_name_1);
      _builder.append(_firstLower_1, "\t ");
      _builder.append("\">");
      _builder.newLineIfNotEmpty();
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("<input type=\"hidden\" name=\"");
      String _name_2 = f.getName();
      String _firstLower_2 = StringExtensions.toFirstLower(_name_2);
      _builder.append(_firstLower_2, "");
      _builder.append("_LTE\" value=\"{{");
      String _name_3 = f.getName();
      String _firstLower_3 = StringExtensions.toFirstLower(_name_3);
      _builder.append(_firstLower_3, "");
      _builder.append("_LTE}}\" />");
      _builder.newLineIfNotEmpty();
      _switchResult = _builder.toString();
    }
    if (!_matched) {
      String _comment_2 = f.getComment();
      boolean _contains_1 = _comment_2.contains("-select");
      if (_contains_1) {
        _matched=true;
        String _xifexpression = null;
        String _comment_3 = f.getComment();
        String[] _split = _comment_3.split("-");
        int _length = _split.length;
        boolean _greaterThan = (_length > 2);
        if (_greaterThan) {
          String _xblockexpression = null;
          {
            String _comment_4 = f.getComment();
            String[] _split_1 = _comment_4.split("-");
            String _get = _split_1[2];
            String name = StringExtensions.toFirstLower(_get);
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("<select name=\"");
            String _name_4 = f.getName();
            String _firstLower_4 = StringExtensions.toFirstLower(_name_4);
            _builder_1.append(_firstLower_4, "");
            _builder_1.append("_EQ\" class=\"form-control\" ng-model=\"");
            _builder_1.append(name, "");
            _builder_1.append("\" ng-options=\"d.name for d in ");
            _builder_1.append(name, "");
            _builder_1.append("s\" ");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("data-value=\"{{");
            _builder_1.append(name, "");
            _builder_1.append("}}\">");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("     ");
            _builder_1.append("<option value=\"\">-- 请选择 --</option>");
            _builder_1.newLine();
            _builder_1.append("</select>");
            _builder_1.newLine();
            _xblockexpression = _builder_1.toString();
          }
          _xifexpression = _xblockexpression;
        } else {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("<select name=\"");
          String _name_4 = f.getName();
          String _firstLower_4 = StringExtensions.toFirstLower(_name_4);
          _builder_1.append(_firstLower_4, "");
          _builder_1.append("_EQ\" class=\"form-control\" ng-model=\"");
          String _name_5 = f.getName();
          String _firstLower_5 = StringExtensions.toFirstLower(_name_5);
          _builder_1.append(_firstLower_5, "");
          _builder_1.append("\" ng-options=\"d for d in ");
          String _name_6 = f.getName();
          String _firstLower_6 = StringExtensions.toFirstLower(_name_6);
          _builder_1.append(_firstLower_6, "");
          _builder_1.append("s\" ");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("data-value=\"{{");
          String _name_7 = f.getName();
          String _firstLower_7 = StringExtensions.toFirstLower(_name_7);
          _builder_1.append(_firstLower_7, "");
          _builder_1.append("}}\" ");
          {
            String _name_8 = f.getName();
            String _upperCase = _name_8.toUpperCase();
            boolean _equals = _upperCase.equals("CITY");
            if (_equals) {
              _builder_1.append("ng-click=\"getCitys()\"");
            }
          }
          _builder_1.append(">");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("     ");
          _builder_1.append("<option value=\"\">-- 请选择 --</option>");
          _builder_1.newLine();
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
      String _name_9 = f.getName();
      String _firstLower_8 = StringExtensions.toFirstLower(_name_9);
      _builder_2.append(_firstLower_8, "");
      _builder_2.append("_LIKE\" ng-model=\"");
      String _klassType = t.getKlassType();
      String _firstLower_9 = StringExtensions.toFirstLower(_klassType);
      _builder_2.append(_firstLower_9, "");
      _builder_2.append(".");
      String _name_10 = f.getName();
      String _firstLower_10 = StringExtensions.toFirstLower(_name_10);
      _builder_2.append(_firstLower_10, "");
      _builder_2.append("\" class=\"form-control\" />");
      _builder_2.newLineIfNotEmpty();
      _switchResult = _builder_2.toString();
    }
    return _switchResult;
  }
  
  public static String parseInput(final JpaBot.VisonTable t, final JpaBot.VisonField f) {
    String _switchResult = null;
    String _comment = f.getComment();
    boolean _matched = false;
    String _comment_1 = f.getComment();
    boolean _contains = _comment_1.contains("-date");
    if (_contains) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<div class=\"input-group input-large date-picker input-daterange\" data-date-format=\"yyyy-mm-dd\">");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("<input type=\"text\" class=\"form-control\" name=\"");
      String _name = f.getName();
      String _firstLower = StringExtensions.toFirstLower(_name);
      _builder.append(_firstLower, "\t ");
      _builder.append("\"> ");
      _builder.newLineIfNotEmpty();
      _builder.append("\t ");
      _builder.append("<span class=\"input-group-addon\">至</span> ");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("<input type=\"text\" class=\"form-control\" name=\"");
      String _name_1 = f.getName();
      String _firstLower_1 = StringExtensions.toFirstLower(_name_1);
      _builder.append(_firstLower_1, "\t ");
      _builder.append("\">");
      _builder.newLineIfNotEmpty();
      _builder.append("</div>");
      _builder.newLine();
      _switchResult = _builder.toString();
    }
    if (!_matched) {
      String _comment_2 = f.getComment();
      boolean _contains_1 = _comment_2.contains("-select");
      if (_contains_1) {
        _matched=true;
        String _xifexpression = null;
        String _comment_3 = f.getComment();
        String[] _split = _comment_3.split("-");
        int _length = _split.length;
        boolean _greaterThan = (_length > 2);
        if (_greaterThan) {
          String _xblockexpression = null;
          {
            String _comment_4 = f.getComment();
            String[] _split_1 = _comment_4.split("-");
            String _get = _split_1[2];
            String name = StringExtensions.toFirstLower(_get);
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("<select name=\"");
            String _name_2 = f.getName();
            String _firstLower_2 = StringExtensions.toFirstLower(_name_2);
            _builder_1.append(_firstLower_2, "");
            _builder_1.append("\" class=\"form-control\" ng-model=\"");
            _builder_1.append(name, "");
            _builder_1.append("\" ng-options=\"d.name for d in ");
            _builder_1.append(name, "");
            _builder_1.append("s\" ");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("data-value=\"{{");
            _builder_1.append(name, "");
            _builder_1.append("}}\">");
            _builder_1.newLineIfNotEmpty();
            _builder_1.append("     ");
            _builder_1.append("<option value=\"\">-- 请选择 --</option>");
            _builder_1.newLine();
            _builder_1.append("</select>");
            _builder_1.newLine();
            _xblockexpression = _builder_1.toString();
          }
          _xifexpression = _xblockexpression;
        } else {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("<select name=\"");
          String _name_2 = f.getName();
          String _firstLower_2 = StringExtensions.toFirstLower(_name_2);
          _builder_1.append(_firstLower_2, "");
          _builder_1.append("\" class=\"form-control\" ng-model=\"");
          String _name_3 = f.getName();
          String _firstLower_3 = StringExtensions.toFirstLower(_name_3);
          _builder_1.append(_firstLower_3, "");
          _builder_1.append("\" ng-options=\"d for d in ");
          String _name_4 = f.getName();
          String _firstLower_4 = StringExtensions.toFirstLower(_name_4);
          _builder_1.append(_firstLower_4, "");
          _builder_1.append("s\" ");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("data-value=\"{{");
          String _name_5 = f.getName();
          String _firstLower_5 = StringExtensions.toFirstLower(_name_5);
          _builder_1.append(_firstLower_5, "");
          _builder_1.append("}}\"");
          {
            String _name_6 = f.getName();
            String _upperCase = _name_6.toUpperCase();
            boolean _equals = _upperCase.equals("CITY");
            if (_equals) {
              _builder_1.append("ng-click=\"getCitys()\"");
            }
          }
          _builder_1.append(">");
          _builder_1.newLineIfNotEmpty();
          _builder_1.append("     ");
          _builder_1.append("<option value=\"\">-- 请选择 --</option>");
          _builder_1.newLine();
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
      String _name_7 = f.getName();
      String _firstLower_6 = StringExtensions.toFirstLower(_name_7);
      _builder_2.append(_firstLower_6, "");
      _builder_2.append("\" ng-model=\"");
      String _klassType = t.getKlassType();
      String _firstLower_7 = StringExtensions.toFirstLower(_klassType);
      _builder_2.append(_firstLower_7, "");
      _builder_2.append(".");
      String _name_8 = f.getName();
      String _firstLower_8 = StringExtensions.toFirstLower(_name_8);
      _builder_2.append(_firstLower_8, "");
      _builder_2.append("\" class=\"form-control\" />");
      _builder_2.newLineIfNotEmpty();
      _switchResult = _builder_2.toString();
    }
    return _switchResult;
  }
  
  public static String parseFieldAnnotation(final JpaBot.VisonField f) {
    String _switchResult = null;
    boolean _matched = false;
    String _key = f.getKey();
    String _upperCase = _key.toUpperCase();
    boolean _contains = _upperCase.contains("P");
    if (_contains) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@Id");
      _builder.newLine();
      _builder.append("@GenericGenerator(name = \"system_uuid\", strategy = \"uuid\")");
      _builder.newLine();
      _builder.append("@GeneratedValue(generator = \"system_uuid\")");
      _builder.newLine();
      _builder.append("private ");
      String _javaType = f.javaType();
      _builder.append(_javaType, "");
      _builder.append(" ");
      String _name = f.getName();
      String _firstLower = StringExtensions.toFirstLower(_name);
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
        _builder_1.append("@DateTimeFormat(pattern = \"yyyy-MM-dd\")");
        _builder_1.newLine();
        _builder_1.append("@JsonAdapter(value = Yyyy_MM_ddAdapter.class)");
        _builder_1.newLine();
        _builder_1.append("private ");
        String _javaType_2 = f.javaType();
        _builder_1.append(_javaType_2, "");
        _builder_1.append(" ");
        String _name_1 = f.getName();
        String _firstLower_1 = StringExtensions.toFirstLower(_name_1);
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
      String _name_2 = f.getName();
      String _firstLower_2 = StringExtensions.toFirstLower(_name_2);
      _builder_2.append(_firstLower_2, "");
      _builder_2.append(";");
      _switchResult = _builder_2.toString();
    }
    return _switchResult;
  }
}
