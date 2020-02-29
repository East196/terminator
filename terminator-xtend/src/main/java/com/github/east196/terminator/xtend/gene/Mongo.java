package com.github.east196.terminator.xtend.gene;

import com.github.east196.terminator.xtend.bot.Bots;
import com.github.east196.terminator.xtend.gene.Base;
import com.github.east196.terminator.xtend.meta.DocMetaParser;
import com.github.east196.terminator.xtend.model.Field;
import com.github.east196.terminator.xtend.model.Project;
import com.github.east196.terminator.xtend.model.Record;
import com.github.east196.terminator.xtend.model.Three;
import com.google.common.base.Objects;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Generated;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class Mongo {
  public static void main(final String[] args) {
    DocMetaParser _docMetaParser = new DocMetaParser();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("E:\\backup\\xcode\\统一数据文档20180913.doc");
    List<Three> _action = _docMetaParser.action(_builder.toString());
    final Consumer<Three> _function = (Three three) -> {
      Project _project = three.getProject();
      Record _record = three.getRecord();
      List<Field> _fields = three.getFields();
      Mongo.gene(_project, _record, _fields);
      Project _project_1 = three.getProject();
      Base.app(_project_1);
    };
    _action.forEach(_function);
  }
  
  public static void gene(final Project project, final Record record, final List<Field> fields) {
    String _root = project.getRoot();
    String[] _split = _root.split("\\.");
    final String javaPath = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_split)), "\\");
    String _name = record.getName();
    String packageName = StringExtensions.toFirstLower(_name);
    CharSequence content = Mongo.bean(project, record, fields);
    StringConcatenation _builder = new StringConcatenation();
    String _path = project.getPath();
    _builder.append(_path, "");
    _builder.append("\\src\\main\\java\\");
    _builder.append(javaPath, "");
    _builder.append("\\");
    _builder.append(packageName, "");
    _builder.append("\\");
    String _name_1 = record.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_1);
    _builder.append(_firstUpper, "");
    _builder.append(".java");
    String path = _builder.toString();
    InputOutput.<String>println(path);
    Bots.copy(content, path);
    CharSequence _dao = Mongo.dao(project, record, fields);
    content = _dao;
    StringConcatenation _builder_1 = new StringConcatenation();
    String _path_1 = project.getPath();
    _builder_1.append(_path_1, "");
    _builder_1.append("\\src\\main\\java\\");
    _builder_1.append(javaPath, "");
    _builder_1.append("\\");
    _builder_1.append(packageName, "");
    _builder_1.append("\\");
    String _name_2 = record.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_2);
    _builder_1.append(_firstUpper_1, "");
    _builder_1.append("Repository.java");
    path = _builder_1.toString();
    InputOutput.<String>println(path);
    Bots.copy(content, path);
    CharSequence _controller = Mongo.controller(project, record, fields);
    content = _controller;
    StringConcatenation _builder_2 = new StringConcatenation();
    String _path_2 = project.getPath();
    _builder_2.append(_path_2, "");
    _builder_2.append("\\src\\main\\java\\");
    _builder_2.append(javaPath, "");
    _builder_2.append("\\");
    _builder_2.append(packageName, "");
    _builder_2.append("\\");
    String _name_3 = record.getName();
    String _firstUpper_2 = StringExtensions.toFirstUpper(_name_3);
    _builder_2.append(_firstUpper_2, "");
    _builder_2.append("Controller.java");
    path = _builder_2.toString();
    InputOutput.<String>println(path);
    Bots.copy(content, path);
    CharSequence _validator = Mongo.validator(project, record, fields);
    content = _validator;
    StringConcatenation _builder_3 = new StringConcatenation();
    String _path_3 = project.getPath();
    _builder_3.append(_path_3, "");
    _builder_3.append("\\src\\main\\java\\");
    _builder_3.append(javaPath, "");
    _builder_3.append("\\");
    _builder_3.append(packageName, "");
    _builder_3.append("\\");
    String _name_4 = record.getName();
    String _firstUpper_3 = StringExtensions.toFirstUpper(_name_4);
    _builder_3.append(_firstUpper_3, "");
    _builder_3.append("Validator.java");
    path = _builder_3.toString();
    InputOutput.<String>println(path);
    Bots.copy(content, path);
    CharSequence _tableHtml = Mongo.tableHtml(project, record, fields);
    content = _tableHtml;
    StringConcatenation _builder_4 = new StringConcatenation();
    String _path_4 = project.getPath();
    _builder_4.append(_path_4, "");
    _builder_4.append("\\src\\main\\resources\\templates\\");
    String _name_5 = record.getName();
    _builder_4.append(_name_5, "");
    _builder_4.append(".html");
    path = _builder_4.toString();
    InputOutput.<String>println(path);
    Bots.copy(content, path);
    CharSequence _js = Mongo.js(project, record, fields);
    content = _js;
    StringConcatenation _builder_5 = new StringConcatenation();
    String _path_5 = project.getPath();
    _builder_5.append(_path_5, "");
    _builder_5.append("\\src\\main\\resources\\static\\js\\");
    String _name_6 = record.getName();
    _builder_5.append(_name_6, "");
    _builder_5.append(".js");
    path = _builder_5.toString();
    InputOutput.<String>println(path);
    Bots.copy(content, path);
    CharSequence _controllerTxt = Mongo.controllerTxt(project, record, fields);
    content = _controllerTxt;
    StringConcatenation _builder_6 = new StringConcatenation();
    String _path_6 = project.getPath();
    _builder_6.append(_path_6, "");
    _builder_6.append("\\src\\main\\resources\\static\\tmp\\");
    String _name_7 = record.getName();
    _builder_6.append(_name_7, "");
    _builder_6.append(".txt");
    path = _builder_6.toString();
    InputOutput.<String>println(path);
    Bots.copy(content, path);
  }
  
  public static CharSequence bean(final Project project, final Record record, final List<Field> fields) {
    CharSequence _xblockexpression = null;
    {
      final String basePackageName = project.getRoot();
      String _name = record.getName();
      String klassType = StringExtensions.toFirstUpper(_name);
      String _name_1 = record.getName();
      String packageName = StringExtensions.toFirstLower(_name_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      _builder.append(packageName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import com.google.common.base.Objects;");
      _builder.newLine();
      _builder.append("import org.springframework.data.annotation.Id;");
      _builder.newLine();
      _builder.newLine();
      {
        final Function1<Field, Boolean> _function = (Field f) -> {
          String _type = f.getType();
          return Boolean.valueOf(_type.equals("repeated"));
        };
        boolean _exists = IterableExtensions.<Field>exists(fields, _function);
        if (_exists) {
          _builder.append("import java.util.List;");
          _builder.newLine();
        }
      }
      {
        final Function1<Field, Boolean> _function_1 = (Field f) -> {
          String _type = f.getType();
          return Boolean.valueOf(_type.equals("datetime"));
        };
        boolean _exists_1 = IterableExtensions.<Field>exists(fields, _function_1);
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
        for(final Field f : fields) {
          _builder.append("\t");
          _builder.append("/**");
          String _doc = f.getDoc();
          _builder.append(_doc, "\t");
          _builder.append("**/");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            String _keyType = f.getKeyType();
            boolean _equals = Objects.equal(_keyType, "P");
            if (_equals) {
              _builder.append("@Id");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("private ");
          String _javaType = f.javaType();
          _builder.append(_javaType, "\t");
          _builder.append(" ");
          String _name_2 = f.getName();
          String _firstLower = StringExtensions.toFirstLower(_name_2);
          _builder.append(_firstLower, "\t");
          _builder.append(";");
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
        for(final Field f_1 : fields) {
          {
            if ((f_1.javaType().toUpperCase().equals("DATE") && StringExtensions.toFirstLower(f_1.getName()).equals("updateTime"))) {
              _builder.append("\t\t");
              _builder.append("this.");
              String _name_3 = f_1.getName();
              String _firstLower_1 = StringExtensions.toFirstLower(_name_3);
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
      final Function1<Field, String> _function_2 = (Field it) -> {
        String _javaType_1 = it.javaType();
        String _plus = (_javaType_1 + " ");
        String _name_4 = it.getName();
        String _firstLower_2 = StringExtensions.toFirstLower(_name_4);
        return (_plus + _firstLower_2);
      };
      List<String> _map = ListExtensions.<Field, String>map(fields, _function_2);
      String _join = IterableExtensions.join(_map, ",");
      _builder.append(_join, "\t");
      _builder.append("){");
      _builder.newLineIfNotEmpty();
      {
        for(final Field f_2 : fields) {
          _builder.append("\t\t");
          _builder.append("this.");
          String _name_4 = f_2.getName();
          String _firstLower_2 = StringExtensions.toFirstLower(_name_4);
          _builder.append(_firstLower_2, "\t\t");
          _builder.append("=");
          String _name_5 = f_2.getName();
          String _firstLower_3 = StringExtensions.toFirstLower(_name_5);
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
        for(final Field f_3 : fields) {
          _builder.append("\t");
          _builder.append("public ");
          String _javaType_1 = f_3.javaType();
          _builder.append(_javaType_1, "\t");
          _builder.append(" get");
          String _name_6 = f_3.getName();
          String _firstUpper = StringExtensions.toFirstUpper(_name_6);
          _builder.append(_firstUpper, "\t");
          _builder.append("() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return ");
          String _name_7 = f_3.getName();
          String _firstLower_4 = StringExtensions.toFirstLower(_name_7);
          _builder.append(_firstLower_4, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void set");
          String _name_8 = f_3.getName();
          String _firstUpper_1 = StringExtensions.toFirstUpper(_name_8);
          _builder.append(_firstUpper_1, "\t");
          _builder.append("(");
          String _javaType_2 = f_3.javaType();
          _builder.append(_javaType_2, "\t");
          _builder.append(" ");
          String _name_9 = f_3.getName();
          String _firstLower_5 = StringExtensions.toFirstLower(_name_9);
          _builder.append(_firstLower_5, "\t");
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("this.");
          String _name_10 = f_3.getName();
          String _firstLower_6 = StringExtensions.toFirstLower(_name_10);
          _builder.append(_firstLower_6, "\t\t");
          _builder.append(" = ");
          String _name_11 = f_3.getName();
          String _firstLower_7 = StringExtensions.toFirstLower(_name_11);
          _builder.append(_firstLower_7, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("\t");
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
        for(final Field f_4 : fields) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate("&&", "        ");
          }
          _builder.append("Objects.equal(");
          String _name_12 = f_4.getName();
          _builder.append(_name_12, "        ");
          _builder.append(", that.");
          String _name_13 = f_4.getName();
          _builder.append(_name_13, "        ");
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
      final Function1<Field, String> _function_3 = (Field it) -> {
        return it.getName();
      };
      List<String> _map_1 = ListExtensions.<Field, String>map(fields, _function_3);
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
        for(final Field f_5 : fields) {
          _builder.append(".add(\"");
          String _name_14 = f_5.getName();
          _builder.append(_name_14, "        ");
          _builder.append("\", ");
          String _name_15 = f_5.getName();
          _builder.append(_name_15, "        ");
          _builder.append(")");
        }
      }
      _builder.append(".toString();");
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
  
  public static CharSequence dao(final Project project, final Record record, final List<Field> fields) {
    CharSequence _xblockexpression = null;
    {
      final String basePackageName = project.getRoot();
      String _name = record.getName();
      String beanType = StringExtensions.toFirstUpper(_name);
      String _name_1 = record.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name_1);
      String klassType = (_firstUpper + "Repository");
      String _name_2 = record.getName();
      String packageName = StringExtensions.toFirstLower(_name_2);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      _builder.append(packageName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.springframework.data.mongodb.repository.MongoRepository;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public interface ");
      _builder.append(klassType, "");
      _builder.append(" extends MongoRepository<");
      _builder.append(beanType, "");
      _builder.append(", String>{");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("// add more ...");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence controller(final Project project, final Record record, final List<Field> fields) {
    CharSequence _xblockexpression = null;
    {
      final String basePackageName = project.getRoot();
      String _name = record.getName();
      String beanType = StringExtensions.toFirstUpper(_name);
      String _name_1 = record.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name_1);
      String daoType = (_firstUpper + "Repository");
      String _name_2 = record.getName();
      String _firstUpper_1 = StringExtensions.toFirstUpper(_name_2);
      String klassType = (_firstUpper_1 + "Controller");
      String _name_3 = record.getName();
      String packageName = StringExtensions.toFirstLower(_name_3);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      _builder.append(packageName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
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
      _builder.append("import org.springframework.web.bind.annotation.RestController;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import com.github.east196.xcode.common.DataResponse;");
      _builder.newLine();
      _builder.append("import com.github.east196.xcode.common.Response;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@RestController");
      _builder.newLine();
      _builder.append("@RequestMapping(\"/controller/v1/");
      String _firstLower = StringExtensions.toFirstLower(beanType);
      _builder.append(_firstLower, "");
      _builder.append("\")");
      _builder.newLineIfNotEmpty();
      _builder.append("public class ");
      _builder.append(klassType, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private static final Logger LOGGER = LoggerFactory.getLogger(");
      _builder.append(klassType, "\t");
      _builder.append(".class);");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Autowired");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private ");
      _builder.append(daoType, "\t");
      _builder.append(" ");
      String _firstLower_1 = StringExtensions.toFirstLower(daoType);
      _builder.append(_firstLower_1, "\t");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@RequestMapping(value = \"/\", method = RequestMethod.GET)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public DataResponse<List<");
      _builder.append(beanType, "\t");
      _builder.append(">> read() {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("List<");
      _builder.append(beanType, "\t\t");
      _builder.append("> ");
      String _firstLower_2 = StringExtensions.toFirstLower(beanType);
      _builder.append(_firstLower_2, "\t\t");
      _builder.append("s = ");
      String _firstLower_3 = StringExtensions.toFirstLower(daoType);
      _builder.append(_firstLower_3, "\t\t");
      _builder.append(".findAll();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("return new DataResponse<List<");
      _builder.append(beanType, "\t\t");
      _builder.append(">>(\"0\", \"查询成功!\", ");
      String _firstLower_4 = StringExtensions.toFirstLower(beanType);
      _builder.append(_firstLower_4, "\t\t");
      _builder.append("s);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@RequestMapping(value = \"/\", method = RequestMethod.POST)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public Response createOrUpdate(@RequestBody @Valid ");
      _builder.append(beanType, "\t");
      _builder.append(" ");
      String _firstLower_5 = StringExtensions.toFirstLower(beanType);
      _builder.append(_firstLower_5, "\t");
      _builder.append(", BindingResult result) {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("LOGGER.debug(\"add ");
      String _firstLower_6 = StringExtensions.toFirstLower(beanType);
      _builder.append(_firstLower_6, "\t\t");
      _builder.append(":  {}\", ");
      String _firstLower_7 = StringExtensions.toFirstLower(beanType);
      _builder.append(_firstLower_7, "\t\t");
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
      String _firstLower_8 = StringExtensions.toFirstLower(daoType);
      _builder.append(_firstLower_8, "\t\t\t");
      _builder.append(".save(");
      String _firstLower_9 = StringExtensions.toFirstLower(beanType);
      _builder.append(_firstLower_9, "\t\t\t");
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
      _builder.append("public Response delete(@PathVariable String id) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("LOGGER.debug(\"id:  {}\", id);");
      _builder.newLine();
      _builder.append("\t\t");
      String _firstLower_10 = StringExtensions.toFirstLower(daoType);
      _builder.append(_firstLower_10, "\t\t");
      _builder.append(".deleteById(id);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("return new Response(\"0\", \"ok\");");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@InitBinder(\"");
      String _firstLower_11 = StringExtensions.toFirstLower(beanType);
      _builder.append(_firstLower_11, "\t");
      _builder.append("\")");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("public void initBinder(DataBinder binder) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("binder.setValidator(new ");
      _builder.append(beanType, "\t\t");
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
  
  public static CharSequence validator(final Project project, final Record record, final List<Field> fields) {
    CharSequence _xblockexpression = null;
    {
      final String basePackageName = project.getRoot();
      String _name = record.getName();
      String beanType = StringExtensions.toFirstUpper(_name);
      String _name_1 = record.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name_1);
      String klassType = (_firstUpper + "Validator");
      String _name_2 = record.getName();
      String packageName = StringExtensions.toFirstLower(_name_2);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      _builder.append(packageName, "");
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
      _builder.append(" implements Validator {");
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
      _builder.append(beanType, "\t\t");
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
        final Function1<Field, Boolean> _function = (Field it) -> {
          String _required = it.getRequired();
          return Boolean.valueOf(_required.equals("required"));
        };
        Iterable<Field> _filter = IterableExtensions.<Field>filter(fields, _function);
        List<Field> _list = IterableExtensions.<Field>toList(_filter);
        for(final Field f : _list) {
          _builder.append("\t\t");
          _builder.append("ValidationUtils.rejectIfEmpty(arg1, \"");
          String _name_3 = f.getName();
          String _firstLower = StringExtensions.toFirstLower(_name_3);
          _builder.append(_firstLower, "\t\t");
          _builder.append("\", null, \"");
          String _label = f.getLabel();
          _builder.append(_label, "\t\t");
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
  
  public static CharSequence tableHtml(final Project project, final Record record, final List<Field> fields) {
    CharSequence _xblockexpression = null;
    {
      String beanName = record.getName();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<div class=\"container inner-container\">");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<div class=\"row\"></div>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<div class=\"row\">");
      _builder.newLine();
      _builder.append("\t  ");
      _builder.append("<table id=\"");
      _builder.append(beanName, "\t  ");
      _builder.append("-table\" class=\"table table-striped table-bordered\" cellspacing=\"0\" width=\"100%\">");
      _builder.newLineIfNotEmpty();
      _builder.append("\t    ");
      _builder.append("<thead>");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append("<tr>");
      _builder.newLine();
      {
        for(final Field f : fields) {
          _builder.append("\t\t        ");
          _builder.append("<th>");
          String _label = f.getLabel();
          _builder.append(_label, "\t\t        ");
          _builder.append("</th>");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t        ");
      _builder.append("</tr>");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append("</thead>");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append("<tfoot>");
      _builder.newLine();
      _builder.append("\t        ");
      _builder.append("<tr>");
      _builder.newLine();
      {
        for(final Field f_1 : fields) {
          _builder.append("\t\t\t\t");
          _builder.append("<th>");
          String _name = f_1.getName();
          _builder.append(_name, "\t\t\t\t");
          _builder.append("</th>");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t        ");
      _builder.append("</tr>");
      _builder.newLine();
      _builder.append("\t    ");
      _builder.append("</tfoot>");
      _builder.newLine();
      _builder.append("\t  ");
      _builder.append("</table>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("<script src=\"/js/");
      _builder.append(beanName, "");
      _builder.append(".js\"></script>");
      _builder.newLineIfNotEmpty();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence js(final Project project, final Record record, final List<Field> fields) {
    CharSequence _xblockexpression = null;
    {
      String beanName = record.getName();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("$(document).ready(function() {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("$(\'#");
      _builder.append(beanName, "    ");
      _builder.append("-table\').dataTable( {");
      _builder.newLineIfNotEmpty();
      _builder.append("        ");
      _builder.append("\"ajax\": \"/");
      _builder.append(beanName, "        ");
      _builder.append("/\",");
      _builder.newLineIfNotEmpty();
      _builder.append("        ");
      _builder.append("\"columns\": [");
      _builder.newLine();
      {
        boolean _hasElements = false;
        for(final Field f : fields) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(",", "\t\t\t");
          }
          _builder.append("\t\t\t");
          _builder.append("{ \"data\": \"");
          String _name = f.getName();
          _builder.append(_name, "\t\t\t");
          _builder.append("\" }");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("        ");
      _builder.append("]");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("} );");
      _builder.newLine();
      _builder.append("} );");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence controllerTxt(final Project project, final Record record, final List<Field> fields) {
    CharSequence _xblockexpression = null;
    {
      String _name = record.getName();
      String beanType = StringExtensions.toFirstUpper(_name);
      String beanName = record.getName();
      String _name_1 = record.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name_1);
      String klassType = (_firstUpper + "Contoller");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.springframework.beans.factory.annotation.Autowired;");
      _builder.newLine();
      _builder.append("import org.springframework.stereotype.Controller;");
      _builder.newLine();
      _builder.append("import org.springframework.web.bind.annotation.RequestMapping;");
      _builder.newLine();
      _builder.append("import org.springframework.web.bind.annotation.RequestMethod;");
      _builder.newLine();
      _builder.append("import org.springframework.web.bind.annotation.ResponseBody;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import vc.xd.demo.common.DataResponse;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Controller");
      _builder.newLine();
      _builder.append("@RequestMapping(\"/");
      _builder.append(beanName, "");
      _builder.append("\")");
      _builder.newLineIfNotEmpty();
      _builder.append("public class ");
      _builder.append(klassType, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Autowired");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private ");
      _builder.append(beanType, "\t");
      _builder.append("Repository ");
      _builder.append(beanName, "\t");
      _builder.append("Repository;");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@ResponseBody");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@RequestMapping(value = \"/\", method = RequestMethod.GET)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public DataResponse<List<");
      _builder.append(beanType, "\t");
      _builder.append(">> read() {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("List<");
      _builder.append(beanType, "\t\t");
      _builder.append("> ");
      _builder.append(beanName, "\t\t");
      _builder.append("s = ");
      _builder.append(beanName, "\t\t");
      _builder.append("Repository.findAll();");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("return new DataResponse<List<");
      _builder.append(beanType, "\t\t");
      _builder.append(">>(\"0\", \"查询成功!\", ");
      _builder.append(beanName, "\t\t");
      _builder.append("s);");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@RequestMapping(value = \"/table\", method = RequestMethod.GET)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public String table() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return \"");
      _builder.append(beanName, "\t\t");
      _builder.append("\";");
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
}
