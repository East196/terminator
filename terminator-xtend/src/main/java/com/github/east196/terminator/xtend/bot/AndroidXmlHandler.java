package com.github.east196.terminator.xtend.bot;

import com.google.common.base.Charsets;
import com.google.common.base.Objects;
import com.google.common.io.Files;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Generated;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class AndroidXmlHandler {
  private static int i = 1;
  
  public static void main(final String[] args) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("C:\\Users\\threepangpang\\Desktop\\entity");
    String dir = _builder.toString();
    AndroidXmlHandler.entity2beanByDir(dir);
  }
  
  public static void entity2beanByDir(final String javaDir) {
    File _file = new File(javaDir);
    File[] _listFiles = _file.listFiles();
    final Consumer<File> _function = (File it) -> {
      String _path = it.getPath();
      AndroidXmlHandler.entity2bean(_path);
    };
    ((List<File>)Conversions.doWrapArray(_listFiles)).forEach(_function);
  }
  
  public static void entity2bean(final String javaFile) {
    try {
      InputOutput.<String>println(javaFile);
      File _file = new File(javaFile);
      List<String> _readLines = Files.readLines(_file, Charsets.UTF_8);
      final Function1<String, Boolean> _function = (String it) -> {
        return Boolean.valueOf(((!((((((it.contains("@") || it.contains("spring")) || it.contains("javax")) || it.contains("hibernate")) || it.contains("jackson")) || it.contains("jeecg")) || it.contains("testDemo"))) || it.contains("@Data")));
      };
      Iterable<String> _filter = IterableExtensions.<String>filter(_readLines, _function);
      List<String> _list = IterableExtensions.<String>toList(_filter);
      String _lineSeparator = System.lineSeparator();
      String lines = IterableExtensions.join(_list, _lineSeparator);
      File _file_1 = new File(javaFile);
      Files.write(lines, _file_1, Charsets.UTF_8);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void handleXml(final String path) {
    try {
      SAXReader reader = new SAXReader();
      final File file = new File(path);
      String _name = file.getName();
      String[] _split = _name.split("\\.");
      String _get = _split[0];
      InputOutput.<String>println(_get);
      String _name_1 = file.getName();
      String[] _split_1 = _name_1.split("\\.");
      final String fileId = _split_1[0];
      Document document = reader.read(file);
      Element root = document.getRootElement();
      AndroidXmlHandler.addAttr(fileId, root);
      AndroidXmlHandler.java(fileId, root);
      AndroidXmlHandler.writeData2Xml(file, document);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * 将document数据写入file文件中
   * @param xmlFile
   * @param document
   * @throws IOException
   */
  public static void writeData2Xml(final File xmlFile, final Document document) throws IOException {
    OutputFormat format = OutputFormat.createPrettyPrint();
    FileOutputStream _fileOutputStream = new FileOutputStream(xmlFile);
    Writer xmlwriter = new OutputStreamWriter(_fileOutputStream, "UTF-8");
    format.setEncoding("UTF-8");
    XMLWriter writer = new XMLWriter(xmlwriter, format);
    writer.write(document);
    writer.close();
    xmlwriter.close();
  }
  
  public static void addAttr(final String fileId, final Element book) {
    String _name = book.getName();
    String _plus = ("=====开始遍历=====" + _name);
    System.out.println(_plus);
    List<Attribute> bookAttrs = book.attributes();
    final Function1<Attribute, Boolean> _function = (Attribute attr) -> {
      String _qualifiedName = attr.getQualifiedName();
      return Boolean.valueOf(_qualifiedName.equals("android:id"));
    };
    Iterable<Attribute> _filter = IterableExtensions.<Attribute>filter(bookAttrs, _function);
    int _length = ((Object[])Conversions.unwrapArray(_filter, Object.class)).length;
    boolean _equals = (_length == 0);
    if (_equals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@+id/");
      _builder.append(fileId, "");
      _builder.append("_");
      String _name_1 = book.getName();
      String[] _split = _name_1.split("\\.");
      String _last = IterableExtensions.<String>last(((Iterable<String>)Conversions.doWrapArray(_split)));
      String _lowerCase = _last.toLowerCase();
      _builder.append(_lowerCase, "");
      _builder.append("_");
      int _plusPlus = AndroidXmlHandler.i++;
      _builder.append(_plusPlus, "");
      book.addAttribute("android:id", _builder.toString());
    }
    for (final Attribute attr : bookAttrs) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("属性名：");
      String _name_2 = attr.getName();
      _builder_1.append(_name_2, "");
      _builder_1.append(" ");
      String _qualifiedName = attr.getQualifiedName();
      _builder_1.append(_qualifiedName, "");
      _builder_1.append("--属性值：");
      String _value = attr.getValue();
      _builder_1.append(_value, "");
      System.out.println(_builder_1);
    }
    Iterator<Element> itt = book.elementIterator();
    while (itt.hasNext()) {
      {
        Element _next = itt.next();
        Element bookChild = ((Element) _next);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("节点名：");
        String _name_3 = bookChild.getName();
        _builder_2.append(_name_3, "");
        System.out.println(_builder_2);
        AndroidXmlHandler.addAttr(fileId, bookChild);
      }
    }
    String _name_3 = book.getName();
    String _plus_1 = ("=====结束遍历=====" + _name_3);
    System.out.println(_plus_1);
  }
  
  public static void java(final String fileId, final Element element) {
    List<Attribute> bookAttrs = element.attributes();
    final Function1<Attribute, Boolean> _function = (Attribute attr) -> {
      String _qualifiedName = attr.getQualifiedName();
      return Boolean.valueOf(_qualifiedName.equals("android:id"));
    };
    final Attribute attr = IterableExtensions.<Attribute>findFirst(bookAttrs, _function);
    StringConcatenation _builder = new StringConcatenation();
    String _name = element.getName();
    _builder.append(_name, "");
    _builder.append(" ");
    String _value = attr.getValue();
    String[] _split = _value.split("/");
    String _get = _split[1];
    _builder.append(_get, "");
    _builder.append(" = findViewById(R.id.");
    String _value_1 = attr.getValue();
    String[] _split_1 = _value_1.split("/");
    String _get_1 = _split_1[1];
    _builder.append(_get_1, "");
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    {
      String _name_1 = element.getName();
      boolean _equals = Objects.equal(_name_1, "TextView");
      if (_equals) {
        String _value_2 = attr.getValue();
        String[] _split_2 = _value_2.split("/");
        String _get_2 = _split_2[1];
        _builder.append(_get_2, "");
        _builder.append(".setText(\"\");");
      }
    }
    _builder.newLineIfNotEmpty();
    final String code = _builder.toString();
    InputOutput.<String>println(code);
    Iterator<Element> itt = element.elementIterator();
    while (itt.hasNext()) {
      {
        Element _next = itt.next();
        Element bookChild = ((Element) _next);
        AndroidXmlHandler.java(fileId, bookChild);
      }
    }
  }
}
