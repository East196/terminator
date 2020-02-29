package com.github.east196.xcode.bot;

import com.google.common.base.Charsets;
import com.google.common.base.Objects;
import com.google.common.collect.TreeTraverser;
import com.google.common.io.Files;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.annotation.Generated;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class Bots {
  public static void main(final String[] args) {
    Bots.printClassDefine("TypeInMore/type\tdefaultType\tmongoType\tesType");
  }
  
  public Object fakeIt(final String func) {
    return null;
  }
  
  public static boolean ok(final String ok) {
    boolean _switchResult = false;
    String _upperCase = ok.toUpperCase();
    switch (_upperCase) {
      case "YES":
        _switchResult = true;
        break;
      case "Y":
        _switchResult = true;
        break;
      case "OK":
        _switchResult = true;
        break;
      case "ON":
        _switchResult = true;
        break;
      case "O":
        _switchResult = true;
        break;
      default:
        _switchResult = false;
        break;
    }
    return _switchResult;
  }
  
  public static Function<String, String> noop() {
    final Function<String, String> _function = (String in) -> {
      return in;
    };
    return _function;
  }
  
  public static void smartCopy(final String fromDir, final String toDir) {
    String _xifexpression = null;
    boolean _endsWith = toDir.endsWith("\\");
    if (_endsWith) {
      _xifexpression = toDir;
    } else {
      _xifexpression = (toDir + "\\");
    }
    final String fixedToDir = _xifexpression;
    final Function<String, String> _function = (String path) -> {
      return path.replace(fromDir, fixedToDir);
    };
    final Function<String, String> pathTrans = _function;
    final String fromPackage = Bots.getPackage(fromDir);
    final String toPackage = Bots.getPackage(toDir);
    final Function<String, String> _function_1 = (String content) -> {
      return content.replace(fromPackage, toPackage);
    };
    final Function<String, String> contentTrans = _function_1;
    Bots.copy(fromDir, pathTrans, contentTrans);
  }
  
  public static String getPackage(final String path) {
    String _xblockexpression = null;
    {
      String package_ = "";
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\\src\\main\\xtend\\");
      boolean _contains = path.contains(_builder);
      if (_contains) {
        String[] _split = path.split("xtend");
        String _get = _split[1];
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("\\\\");
        String[] _split_1 = _get.split(_builder_1.toString());
        final Function1<String, Boolean> _function = (String it) -> {
          return Boolean.valueOf(((!it.contains(".")) && (!StringExtensions.isNullOrEmpty(it))));
        };
        Iterable<String> _filter = IterableExtensions.<String>filter(((Iterable<String>)Conversions.doWrapArray(_split_1)), _function);
        String _join = IterableExtensions.join(_filter, ".");
        package_ = _join;
      }
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("\\src\\main\\java\\");
      boolean _contains_1 = path.contains(_builder_2);
      if (_contains_1) {
        String[] _split_2 = path.split("java");
        String _get_1 = _split_2[1];
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("\\\\");
        String[] _split_3 = _get_1.split(_builder_3.toString());
        final Function1<String, Boolean> _function_1 = (String it) -> {
          return Boolean.valueOf(((!it.contains(".")) && (!StringExtensions.isNullOrEmpty(it))));
        };
        Iterable<String> _filter_1 = IterableExtensions.<String>filter(((Iterable<String>)Conversions.doWrapArray(_split_3)), _function_1);
        String _join_1 = IterableExtensions.join(_filter_1, ".");
        package_ = _join_1;
      }
      _xblockexpression = package_;
    }
    return _xblockexpression;
  }
  
  public static void copy(final String dir, final Function<String, String> pathTrans, final Function<String, String> contentTrans) {
    if ((Objects.equal(pathTrans, null) && Objects.equal(contentTrans, null))) {
      return;
    }
    InputOutput.<String>println("start");
    TreeTraverser<File> _fileTreeTraverser = Files.fileTreeTraverser();
    File _file = new File(dir);
    final Iterable<File> files = _fileTreeTraverser.children(_file);
    final Consumer<File> _function = (File file) -> {
      try {
        final String path = file.getAbsolutePath();
        final String content = Files.toString(file, Charsets.UTF_8);
        InputOutput.<String>println(path);
        String _apply = contentTrans.apply(content);
        String _apply_1 = pathTrans.apply(path);
        Bots.copy(_apply, _apply_1);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    files.forEach(_function);
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
  
  public static String printClassDefine(final String info) {
    String _xblockexpression = null;
    {
      String[] _split = info.split("/");
      final String klass = _split[0];
      final String klassType = StringExtensions.toFirstUpper(klass);
      String[] _split_1 = info.split("/");
      String _get = _split_1[1];
      final String[] fields = _get.split("\t");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import com.google.common.base.Objects;");
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
        for(final String f : fields) {
          _builder.append("\t");
          _builder.append("private String ");
          _builder.append(f, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("}\t\t");
      _builder.newLine();
      _xblockexpression = InputOutput.<String>print(_builder.toString());
    }
    return _xblockexpression;
  }
  
  public static HWPFDocument doc(final String path) {
    try {
      HWPFDocument _xblockexpression = null;
      {
        FileInputStream is = new FileInputStream(path);
        _xblockexpression = new HWPFDocument(is);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static ArrayList<Table> tables(final String path) {
    ArrayList<Table> _xblockexpression = null;
    {
      HWPFDocument _doc = Bots.doc(path);
      Range range = _doc.getRange();
      final ArrayList<Table> tables = CollectionLiterals.<Table>newArrayList();
      TableIterator tableIterator = new TableIterator(range);
      while (tableIterator.hasNext()) {
        {
          Table table = tableIterator.next();
          tables.add(table);
        }
      }
      _xblockexpression = tables;
    }
    return _xblockexpression;
  }
}
