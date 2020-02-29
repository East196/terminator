package com.github.east196.terminator.xtend.bot;

import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.TreeTraverser;
import com.google.common.io.Files;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Generated;
import org.apache.commons.io.FileUtils;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class Copyer {
  public static void main(final String[] args) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("E:\\workspace\\github\\east196\\java\\maker\\maker\\src\\main\\xtend\\cn\\tung\\system\\maker\\util");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("E:\\workspace\\github\\east196\\java\\maker\\maker\\src\\main\\xtend\\com\\github\\east196\\maker\\util");
    Copyer.smartCopy(_builder.toString(), _builder_1.toString());
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
    final String fromPackage = Copyer.getPackage(fromDir);
    final String toPackage = Copyer.getPackage(toDir);
    final Function<String, String> _function_1 = (String content) -> {
      return content.replace(fromPackage, toPackage);
    };
    final Function<String, String> contentTrans = _function_1;
    Copyer.copy(fromDir, pathTrans, contentTrans);
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
      InputOutput.<File>println(file);
    };
    files.forEach(_function);
    final Consumer<File> _function_1 = (File file) -> {
      try {
        boolean _isDirectory = file.isDirectory();
        boolean _not = (!_isDirectory);
        if (_not) {
          final String path = file.getAbsolutePath();
          InputOutput.<String>println(path);
          final String content = Files.toString(file, Charsets.UTF_8);
          String _apply = contentTrans.apply(content);
          String _apply_1 = pathTrans.apply(path);
          Copyer.copy(_apply, _apply_1);
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    files.forEach(_function_1);
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
  
  public void deleteNoneLines(final String path) {
    final Function<String, String> _function = (String src) -> {
      return src;
    };
    this.pathTrans = _function;
    final Function<String, String> _function_1 = (String src) -> {
      String _lineSeparator = System.lineSeparator();
      String[] _split = src.split(_lineSeparator);
      final Function1<String, Boolean> _function_2 = (String it) -> {
        String _trim = it.trim();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_trim);
        return Boolean.valueOf((!_isNullOrEmpty));
      };
      Iterable<String> _filter = IterableExtensions.<String>filter(((Iterable<String>)Conversions.doWrapArray(_split)), _function_2);
      String _lineSeparator_1 = System.lineSeparator();
      return IterableExtensions.join(_filter, _lineSeparator_1);
    };
    this.infoTrans = _function_1;
    this.copy(path);
  }
  
  public void copy(final String path, final String... ext) {
    File file = new File(path);
    boolean _isFile = file.isFile();
    if (_isFile) {
      this.transFile(file);
    } else {
      String[] exts = null;
      boolean _isEmpty = ((List<String>)Conversions.doWrapArray(ext)).isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        exts = ext;
      }
      final Collection files = FileUtils.listFiles(file, exts, true);
      final Consumer<File> _function = (File it) -> {
        this.transFile(it);
      };
      files.forEach(_function);
    }
  }
  
  public void transFile(final File srcFile) {
    try {
      String _absolutePath = srcFile.getAbsolutePath();
      String distPath = this.pathTrans.apply(_absolutePath);
      StringConcatenation _builder = new StringConcatenation();
      String _absolutePath_1 = srcFile.getAbsolutePath();
      _builder.append(_absolutePath_1, "");
      _builder.append(" ");
      _builder.append(distPath, "");
      InputOutput.<String>println(_builder.toString());
      String _absolutePath_2 = srcFile.getAbsolutePath();
      String ext = Files.getFileExtension(_absolutePath_2);
      boolean _contains = Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("java", "xtend", "txt", "xml", "proto")).contains(ext);
      if (_contains) {
        String srcInfo = Files.toString(srcFile, Charsets.UTF_8);
        String distInfo = this.infoTrans.apply(srcInfo);
        File distFile = new File(distPath);
        Files.createParentDirs(distFile);
        Files.write(distInfo, distFile, Charsets.UTF_8);
      } else {
        File distFile_1 = new File(distPath);
        Files.createParentDirs(distFile_1);
        Files.copy(srcFile, distFile_1);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Accessors
  private Function<String, String> pathTrans;
  
  @Accessors
  private Function<String, String> infoTrans;
  
  @Pure
  public Function<String, String> getPathTrans() {
    return this.pathTrans;
  }
  
  public void setPathTrans(final Function<String, String> pathTrans) {
    this.pathTrans = pathTrans;
  }
  
  @Pure
  public Function<String, String> getInfoTrans() {
    return this.infoTrans;
  }
  
  public void setInfoTrans(final Function<String, String> infoTrans) {
    this.infoTrans = infoTrans;
  }
}
