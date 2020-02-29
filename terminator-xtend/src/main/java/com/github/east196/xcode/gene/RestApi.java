package com.github.east196.xcode.gene;

import com.github.east196.xcode.bot.Bots;
import com.github.east196.xcode.gene.Base;
import com.github.east196.xcode.meta.DocMetaParser;
import com.github.east196.xcode.model.Field;
import com.github.east196.xcode.model.Project;
import com.github.east196.xcode.model.Record;
import com.github.east196.xcode.model.Three;
import com.google.common.base.Objects;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Generated;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class RestApi {
  public static void main(final String[] args) {
    DocMetaParser _docMetaParser = new DocMetaParser();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("E:\\backup\\xcode\\统一数据文档20180913.doc");
    List<Three> _action = _docMetaParser.action(_builder.toString());
    final Consumer<Three> _function = (Three three) -> {
      Project _project = three.getProject();
      Record _record = three.getRecord();
      List<Field> _fields = three.getFields();
      RestApi.gene(_project, _record, _fields);
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
    CharSequence content = RestApi.bean(project, record, fields);
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
    _builder.append(".xtend");
    String path = _builder.toString();
    InputOutput.<String>println(path);
    Bots.copy(content, path);
    CharSequence _repo = RestApi.repo(project, record, fields);
    content = _repo;
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
    _builder_1.append("Repository.xtend");
    path = _builder_1.toString();
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
      {
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(basePackageName);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          _builder.append(basePackageName, "");
          _builder.append(".");
        }
      }
      _builder.append(packageName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.annotations.EqualsHashCode");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.annotations.ToString");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.append("import java.util.Date;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import javax.persistence.Entity;");
      _builder.newLine();
      _builder.append("import javax.persistence.GeneratedValue;");
      _builder.newLine();
      _builder.append("import javax.persistence.GenerationType;");
      _builder.newLine();
      _builder.append("import javax.persistence.Id;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import javax.validation.constraints.NotEmpty");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Accessors");
      _builder.newLine();
      _builder.append("@EqualsHashCode");
      _builder.newLine();
      _builder.append("@ToString(singleLine=true)");
      _builder.newLine();
      _builder.append("@Entity");
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(klassType, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        for(final Field f : fields) {
          _builder.append("\t");
          {
            String _keyType = f.getKeyType();
            boolean _equals = Objects.equal(_keyType, "P");
            if (_equals) {
              _builder.append("@Id @GeneratedValue(strategy = GenerationType.IDENTITY)");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            String _required = f.getRequired();
            boolean _equals_1 = Objects.equal(_required, "required");
            if (_equals_1) {
              _builder.append("@NotEmpty");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          String _javaType = f.javaType();
          _builder.append(_javaType, "\t");
          _builder.append(" ");
          String _name_2 = f.getName();
          String _firstLower = StringExtensions.toFirstLower(_name_2);
          _builder.append(_firstLower, "\t");
          _builder.append("\t\t\t//");
          String _label = f.getLabel();
          _builder.append(_label, "\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence repo(final Project project, final Record record, final List<Field> fields) {
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
      {
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(basePackageName);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          _builder.append(basePackageName, "");
          _builder.append(".");
        }
      }
      _builder.append(packageName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.springframework.data.jpa.repository.JpaRepository;");
      _builder.newLine();
      _builder.append("import org.springframework.data.jpa.repository.JpaSpecificationExecutor;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public interface ");
      _builder.append(klassType, "");
      _builder.append(" extends JpaRepository<");
      _builder.append(beanType, "");
      _builder.append(", Long>, JpaSpecificationExecutor<");
      _builder.append(beanType, "");
      _builder.append("> {");
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
}
