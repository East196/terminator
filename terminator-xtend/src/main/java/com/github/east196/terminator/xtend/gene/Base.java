package com.github.east196.terminator.xtend.gene;

import com.github.east196.terminator.xtend.bot.Bots;
import com.github.east196.terminator.xtend.model.Field;
import com.github.east196.terminator.xtend.model.Project;
import com.github.east196.terminator.xtend.model.Record;
import java.util.List;
import javax.annotation.Generated;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class Base {
  public static void app(final Project project) {
    String _root = project.getRoot();
    String[] _split = _root.split("\\.");
    final String javaPath = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_split)), "\\");
    final String basePackageName = project.getRoot();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(basePackageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import org.springframework.boot.SpringApplication");
    _builder.newLine();
    _builder.append("import org.springframework.boot.autoconfigure.SpringBootApplication");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@SpringBootApplication");
    _builder.newLine();
    _builder.append("class Application {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("SpringApplication.run(Application, args)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    String content = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    String _path = project.getPath();
    _builder_1.append(_path, "");
    _builder_1.append("\\src\\main\\java\\");
    _builder_1.append(javaPath, "");
    _builder_1.append("\\Application.xtend");
    String path = _builder_1.toString();
    Bots.copy(content, path);
  }
  
  public static CharSequence bean(final Project project, final Record record, final List<Field> fields) {
    CharSequence _xblockexpression = null;
    {
      final String basePackageName = project.getRoot();
      String _name = record.getName();
      String klassType = StringExtensions.toFirstUpper(_name);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.append("import java.util.Date;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import lombok.Data;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Data");
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
          _builder.append("private ");
          String _javaType = f.javaType();
          _builder.append(_javaType, "\t");
          _builder.append(" ");
          String _name_1 = f.getName();
          String _firstLower = StringExtensions.toFirstLower(_name_1);
          _builder.append(_firstLower, "\t");
          _builder.append(";\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
