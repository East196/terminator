package com.github.east196.xcode.bot;

import com.github.east196.xcode.bot.Bots;
import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collections;
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
public class UniformInterfaceGene {
  @Data
  public static class HttpReqResp {
    private final UniformInterfaceGene.Req req;
    
    private final List<UniformInterfaceGene.ReqItem> reqPrams;
    
    private final List<UniformInterfaceGene.ReqItem> reqBodyItems;
    
    private final List<UniformInterfaceGene.RespItem> respItems;
    
    public String methodAnnotation() {
      String _switchResult = null;
      final String _switchValue = this.req.method;
      switch (_switchValue) {
        case "GET":
          _switchResult = "@GET";
          break;
        case "POST":
          _switchResult = "@POST";
          break;
        default:
          _switchResult = "@POST";
          break;
      }
      return _switchResult;
    }
    
    public String reqBodyKlassType() {
      String _firstUpper = StringExtensions.toFirstUpper(this.req.name);
      return (_firstUpper + "ReqBody");
    }
    
    public String reqQueryKlassType() {
      String _firstUpper = StringExtensions.toFirstUpper(this.req.name);
      return (_firstUpper + "ReqQuery");
    }
    
    public String respKlassType() {
      String _xblockexpression = null;
      {
        String _firstUpper = StringExtensions.toFirstUpper(this.req.name);
        String klassType = (_firstUpper + "Resp");
        int _size = this.respItems.size();
        boolean _equals = (_size == 2);
        if (_equals) {
          klassType = "DefaultResp";
        }
        _xblockexpression = klassType;
      }
      return _xblockexpression;
    }
    
    public HttpReqResp(final UniformInterfaceGene.Req req, final List<UniformInterfaceGene.ReqItem> reqPrams, final List<UniformInterfaceGene.ReqItem> reqBodyItems, final List<UniformInterfaceGene.RespItem> respItems) {
      super();
      this.req = req;
      this.reqPrams = reqPrams;
      this.reqBodyItems = reqBodyItems;
      this.respItems = respItems;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.req== null) ? 0 : this.req.hashCode());
      result = prime * result + ((this.reqPrams== null) ? 0 : this.reqPrams.hashCode());
      result = prime * result + ((this.reqBodyItems== null) ? 0 : this.reqBodyItems.hashCode());
      result = prime * result + ((this.respItems== null) ? 0 : this.respItems.hashCode());
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
      UniformInterfaceGene.HttpReqResp other = (UniformInterfaceGene.HttpReqResp) obj;
      if (this.req == null) {
        if (other.req != null)
          return false;
      } else if (!this.req.equals(other.req))
        return false;
      if (this.reqPrams == null) {
        if (other.reqPrams != null)
          return false;
      } else if (!this.reqPrams.equals(other.reqPrams))
        return false;
      if (this.reqBodyItems == null) {
        if (other.reqBodyItems != null)
          return false;
      } else if (!this.reqBodyItems.equals(other.reqBodyItems))
        return false;
      if (this.respItems == null) {
        if (other.respItems != null)
          return false;
      } else if (!this.respItems.equals(other.respItems))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("req", this.req);
      b.add("reqPrams", this.reqPrams);
      b.add("reqBodyItems", this.reqBodyItems);
      b.add("respItems", this.respItems);
      return b.toString();
    }
    
    @Pure
    public UniformInterfaceGene.Req getReq() {
      return this.req;
    }
    
    @Pure
    public List<UniformInterfaceGene.ReqItem> getReqPrams() {
      return this.reqPrams;
    }
    
    @Pure
    public List<UniformInterfaceGene.ReqItem> getReqBodyItems() {
      return this.reqBodyItems;
    }
    
    @Pure
    public List<UniformInterfaceGene.RespItem> getRespItems() {
      return this.respItems;
    }
  }
  
  @Data
  public static class Req {
    private final String method;
    
    private final String url;
    
    private final String name;
    
    private final String comment;
    
    public String javaName() {
      return UniformInterfaceGene.javaNameFrom(this.name);
    }
    
    public Req(final String method, final String url, final String name, final String comment) {
      super();
      this.method = method;
      this.url = url;
      this.name = name;
      this.comment = comment;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.method== null) ? 0 : this.method.hashCode());
      result = prime * result + ((this.url== null) ? 0 : this.url.hashCode());
      result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
      result = prime * result + ((this.comment== null) ? 0 : this.comment.hashCode());
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
      UniformInterfaceGene.Req other = (UniformInterfaceGene.Req) obj;
      if (this.method == null) {
        if (other.method != null)
          return false;
      } else if (!this.method.equals(other.method))
        return false;
      if (this.url == null) {
        if (other.url != null)
          return false;
      } else if (!this.url.equals(other.url))
        return false;
      if (this.name == null) {
        if (other.name != null)
          return false;
      } else if (!this.name.equals(other.name))
        return false;
      if (this.comment == null) {
        if (other.comment != null)
          return false;
      } else if (!this.comment.equals(other.comment))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("method", this.method);
      b.add("url", this.url);
      b.add("name", this.name);
      b.add("comment", this.comment);
      return b.toString();
    }
    
    @Pure
    public String getMethod() {
      return this.method;
    }
    
    @Pure
    public String getUrl() {
      return this.url;
    }
    
    @Pure
    public String getName() {
      return this.name;
    }
    
    @Pure
    public String getComment() {
      return this.comment;
    }
  }
  
  @Data
  public static class ReqItem {
    private final String name;
    
    private final String require;
    
    private final String type;
    
    private final String comment;
    
    public String javaName() {
      return UniformInterfaceGene.javaNameFrom(this.name);
    }
    
    public ReqItem(final String name, final String require, final String type, final String comment) {
      super();
      this.name = name;
      this.require = require;
      this.type = type;
      this.comment = comment;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
      result = prime * result + ((this.require== null) ? 0 : this.require.hashCode());
      result = prime * result + ((this.type== null) ? 0 : this.type.hashCode());
      result = prime * result + ((this.comment== null) ? 0 : this.comment.hashCode());
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
      UniformInterfaceGene.ReqItem other = (UniformInterfaceGene.ReqItem) obj;
      if (this.name == null) {
        if (other.name != null)
          return false;
      } else if (!this.name.equals(other.name))
        return false;
      if (this.require == null) {
        if (other.require != null)
          return false;
      } else if (!this.require.equals(other.require))
        return false;
      if (this.type == null) {
        if (other.type != null)
          return false;
      } else if (!this.type.equals(other.type))
        return false;
      if (this.comment == null) {
        if (other.comment != null)
          return false;
      } else if (!this.comment.equals(other.comment))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("name", this.name);
      b.add("require", this.require);
      b.add("type", this.type);
      b.add("comment", this.comment);
      return b.toString();
    }
    
    @Pure
    public String getName() {
      return this.name;
    }
    
    @Pure
    public String getRequire() {
      return this.require;
    }
    
    @Pure
    public String getType() {
      return this.type;
    }
    
    @Pure
    public String getComment() {
      return this.comment;
    }
  }
  
  @Data
  public static class RespItem {
    private final String name;
    
    private final String type;
    
    private final String label;
    
    public String javaName() {
      return UniformInterfaceGene.javaNameFrom(this.name);
    }
    
    public boolean unnormal() {
      return ((!Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("string", "int", "double", "boolean")).contains(this.type.toLowerCase())) && (!this.name.startsWith("|")));
    }
    
    public RespItem(final String name, final String type, final String label) {
      super();
      this.name = name;
      this.type = type;
      this.label = label;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
      result = prime * result + ((this.type== null) ? 0 : this.type.hashCode());
      result = prime * result + ((this.label== null) ? 0 : this.label.hashCode());
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
      UniformInterfaceGene.RespItem other = (UniformInterfaceGene.RespItem) obj;
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
      if (this.label == null) {
        if (other.label != null)
          return false;
      } else if (!this.label.equals(other.label))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("name", this.name);
      b.add("type", this.type);
      b.add("label", this.label);
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
    public String getLabel() {
      return this.label;
    }
  }
  
  public static void main(final String[] args) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("E:\\workspace\\github\\east196\\java\\xcode");
    final String projectPath = _builder.toString();
    final String basePackageName = "io.device.uniform";
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/src/main/java/io/device/uniform");
    final String basePath = (projectPath + _builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("E:\\backup\\xcode\\POI接口文档160725.doc");
    String src = _builder_2.toString();
    final ArrayList<Table> tables = Bots.tables(src);
    int _size = tables.size();
    String _plus = ("--表格总数：" + Integer.valueOf(_size));
    InputOutput.<String>println(_plus);
    ArrayList<UniformInterfaceGene.HttpReqResp> httpReqResps = CollectionLiterals.<UniformInterfaceGene.HttpReqResp>newArrayList();
    for (int tableNum = 2; (tableNum < ((Object[])Conversions.unwrapArray(tables, Object.class)).length); tableNum = (tableNum + 5)) {
      {
        if (((tableNum >= 17) && (tableNum < 53))) {
          tableNum++;
        }
        UniformInterfaceGene.HttpReqResp httpReqResp = UniformInterfaceGene.httpReqRespFrom(tables, tableNum);
        httpReqResps.add(httpReqResp);
      }
    }
    final Function1<UniformInterfaceGene.HttpReqResp, Boolean> _function = (UniformInterfaceGene.HttpReqResp it) -> {
      int _size_1 = it.reqPrams.size();
      return Boolean.valueOf((_size_1 > 0));
    };
    Iterable<UniformInterfaceGene.HttpReqResp> _filter = IterableExtensions.<UniformInterfaceGene.HttpReqResp>filter(httpReqResps, _function);
    final Consumer<UniformInterfaceGene.HttpReqResp> _function_1 = (UniformInterfaceGene.HttpReqResp httpReqResp) -> {
      CharSequence content = UniformInterfaceGene.reqQuery((basePackageName + ".req"), httpReqResp);
      String klassType = httpReqResp.reqQueryKlassType();
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append(basePath, "");
      _builder_3.append("/req/");
      _builder_3.append(klassType, "");
      _builder_3.append(".java");
      String path = _builder_3.toString();
      InputOutput.<String>println(path);
      InputOutput.<CharSequence>println(content);
      Bots.copy(content, path);
    };
    _filter.forEach(_function_1);
    final Function1<UniformInterfaceGene.HttpReqResp, Boolean> _function_2 = (UniformInterfaceGene.HttpReqResp it) -> {
      int _size_1 = it.reqBodyItems.size();
      return Boolean.valueOf((_size_1 > 0));
    };
    Iterable<UniformInterfaceGene.HttpReqResp> _filter_1 = IterableExtensions.<UniformInterfaceGene.HttpReqResp>filter(httpReqResps, _function_2);
    final Consumer<UniformInterfaceGene.HttpReqResp> _function_3 = (UniformInterfaceGene.HttpReqResp httpReqResp) -> {
      CharSequence content = UniformInterfaceGene.reqBody((basePackageName + ".req"), httpReqResp);
      String klassType = httpReqResp.reqBodyKlassType();
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append(basePath, "");
      _builder_3.append("/req/");
      _builder_3.append(klassType, "");
      _builder_3.append(".java");
      String path = _builder_3.toString();
      Bots.copy(content, path);
    };
    _filter_1.forEach(_function_3);
    final Consumer<UniformInterfaceGene.HttpReqResp> _function_4 = (UniformInterfaceGene.HttpReqResp httpReqResp) -> {
      String klassType = httpReqResp.respKlassType();
      CharSequence content = UniformInterfaceGene.resp((basePackageName + ".resp"), httpReqResp);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append(basePath, "");
      _builder_3.append("/resp/");
      _builder_3.append(klassType, "");
      _builder_3.append(".java");
      String path = _builder_3.toString();
      Bots.copy(content, path);
    };
    httpReqResps.forEach(_function_4);
    final Consumer<UniformInterfaceGene.HttpReqResp> _function_5 = (UniformInterfaceGene.HttpReqResp httpReqResp) -> {
      final Function1<UniformInterfaceGene.RespItem, Boolean> _function_6 = (UniformInterfaceGene.RespItem it) -> {
        return Boolean.valueOf(it.unnormal());
      };
      Iterable<UniformInterfaceGene.RespItem> _filter_2 = IterableExtensions.<UniformInterfaceGene.RespItem>filter(httpReqResp.respItems, _function_6);
      final Function1<UniformInterfaceGene.RespItem, Integer> _function_7 = (UniformInterfaceGene.RespItem it) -> {
        return Integer.valueOf(httpReqResp.respItems.indexOf(it));
      };
      final Iterable<Integer> indexs = IterableExtensions.<UniformInterfaceGene.RespItem, Integer>map(_filter_2, _function_7);
      final Consumer<Integer> _function_8 = (Integer index) -> {
        UniformInterfaceGene.RespItem _get = httpReqResp.respItems.get((index).intValue());
        String klassType = _get.type;
        CharSequence content = UniformInterfaceGene.respSub((basePackageName + ".resp"), httpReqResp, (index).intValue());
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append(basePath, "");
        _builder_3.append("/resp/");
        _builder_3.append(klassType, "");
        _builder_3.append(".java");
        String path = _builder_3.toString();
        Bots.copy(content, path);
      };
      indexs.forEach(_function_8);
    };
    httpReqResps.forEach(_function_5);
    String klassType = "UniformDeviceHttp";
    CharSequence content = UniformInterfaceGene.http(basePackageName, klassType, httpReqResps);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append(basePath, "");
    _builder_3.append("/");
    _builder_3.append(klassType, "");
    _builder_3.append(".java");
    String path = _builder_3.toString();
    Bots.copy(content, path);
    klassType = "UniformDeviceController";
    CharSequence _controller = UniformInterfaceGene.controller(basePackageName, klassType, httpReqResps);
    content = _controller;
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append(basePath, "");
    _builder_4.append("/");
    _builder_4.append(klassType, "");
    _builder_4.append(".java");
    path = _builder_4.toString();
    Bots.copy(content, path);
  }
  
  public static UniformInterfaceGene.HttpReqResp httpReqRespFrom(final ArrayList<Table> tables, final int tableNum) {
    UniformInterfaceGene.HttpReqResp _xblockexpression = null;
    {
      Table reqTable = tables.get(tableNum);
      int _indexOf = tables.indexOf(reqTable);
      InputOutput.<Integer>println(Integer.valueOf(_indexOf));
      UniformInterfaceGene.Req req = UniformInterfaceGene.reqFrom(reqTable);
      Table reqPramsTable = tables.get((tableNum + 1));
      List<UniformInterfaceGene.ReqItem> reqPrams = UniformInterfaceGene.reqPramsFrom(reqPramsTable);
      Table reqBodyTable = tables.get((tableNum + 2));
      List<UniformInterfaceGene.ReqItem> reqBodyItems = UniformInterfaceGene.reqBodyItemsFrom(reqBodyTable);
      Table respItemsTable = tables.get((tableNum + 3));
      List<UniformInterfaceGene.RespItem> respItems = UniformInterfaceGene.respItemsFrom(respItemsTable);
      UniformInterfaceGene.HttpReqResp httpReqResp = new UniformInterfaceGene.HttpReqResp(req, reqPrams, reqBodyItems, respItems);
      _xblockexpression = httpReqResp;
    }
    return _xblockexpression;
  }
  
  public static List<UniformInterfaceGene.RespItem> respItemsFrom(final Table respItemsTable) {
    List<UniformInterfaceGene.RespItem> _xblockexpression = null;
    {
      List<UniformInterfaceGene.RespItem> respItems = CollectionLiterals.<UniformInterfaceGene.RespItem>newArrayList();
      for (int j = 1; (j < respItemsTable.numRows()); j++) {
        {
          TableRow row = respItemsTable.getRow(j);
          TableCell _cell = row.getCell(1);
          String _text = _cell.text();
          String _trim = _text.trim();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_trim);
          boolean _not = (!_isNullOrEmpty);
          if (_not) {
            TableCell _cell_1 = row.getCell(0);
            String _text_1 = _cell_1.text();
            String name = _text_1.trim();
            TableCell _cell_2 = row.getCell(1);
            String _text_2 = _cell_2.text();
            String type = _text_2.trim();
            TableCell _cell_3 = row.getCell(2);
            String _text_3 = _cell_3.text();
            String _lineSeparator = System.lineSeparator();
            String[] _split = _text_3.split(_lineSeparator);
            String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_split)));
            String comment = _join.trim();
            UniformInterfaceGene.RespItem respItem = new UniformInterfaceGene.RespItem(name, type, comment);
            respItems.add(respItem);
          }
        }
      }
      _xblockexpression = respItems;
    }
    return _xblockexpression;
  }
  
  public static List<UniformInterfaceGene.ReqItem> reqBodyItemsFrom(final Table reqBodyTable) {
    List<UniformInterfaceGene.ReqItem> _xblockexpression = null;
    {
      List<UniformInterfaceGene.ReqItem> reqBodyItems = CollectionLiterals.<UniformInterfaceGene.ReqItem>newArrayList();
      for (int j = 1; (j < reqBodyTable.numRows()); j++) {
        {
          TableRow row = reqBodyTable.getRow(j);
          TableCell _cell = row.getCell(1);
          String _text = _cell.text();
          String _trim = _text.trim();
          InputOutput.<String>println(_trim);
          TableCell _cell_1 = row.getCell(1);
          String _text_1 = _cell_1.text();
          String _trim_1 = _text_1.trim();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_trim_1);
          boolean _not = (!_isNullOrEmpty);
          if (_not) {
            TableCell _cell_2 = row.getCell(0);
            String _text_2 = _cell_2.text();
            String name = _text_2.trim();
            TableCell _cell_3 = row.getCell(1);
            String _text_3 = _cell_3.text();
            String require = _text_3.trim();
            TableCell _cell_4 = row.getCell(2);
            String _text_4 = _cell_4.text();
            String type = _text_4.trim();
            TableCell _cell_5 = row.getCell(3);
            String _text_5 = _cell_5.text();
            String _lineSeparator = System.lineSeparator();
            String[] _split = _text_5.split(_lineSeparator);
            String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_split)));
            String comment = _join.trim();
            UniformInterfaceGene.ReqItem reqItem = new UniformInterfaceGene.ReqItem(name, require, type, comment);
            reqBodyItems.add(reqItem);
          }
        }
      }
      final List<UniformInterfaceGene.ReqItem> _converted_reqBodyItems = (List<UniformInterfaceGene.ReqItem>)reqBodyItems;
      int _length = ((Object[])Conversions.unwrapArray(_converted_reqBodyItems, Object.class)).length;
      InputOutput.<Integer>println(Integer.valueOf(_length));
      _xblockexpression = reqBodyItems;
    }
    return _xblockexpression;
  }
  
  public static List<UniformInterfaceGene.ReqItem> reqPramsFrom(final Table reqPramsTable) {
    List<UniformInterfaceGene.ReqItem> _xblockexpression = null;
    {
      List<UniformInterfaceGene.ReqItem> reqPrams = CollectionLiterals.<UniformInterfaceGene.ReqItem>newArrayList();
      for (int j = 1; (j < reqPramsTable.numRows()); j++) {
        {
          TableRow row = reqPramsTable.getRow(j);
          TableCell _cell = row.getCell(1);
          String _text = _cell.text();
          String _trim = _text.trim();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_trim);
          boolean _not = (!_isNullOrEmpty);
          if (_not) {
            TableCell _cell_1 = row.getCell(0);
            String _text_1 = _cell_1.text();
            String name = _text_1.trim();
            TableCell _cell_2 = row.getCell(1);
            String _text_2 = _cell_2.text();
            String require = _text_2.trim();
            TableCell _cell_3 = row.getCell(2);
            String _text_3 = _cell_3.text();
            String type = _text_3.trim();
            TableCell _cell_4 = row.getCell(3);
            String _text_4 = _cell_4.text();
            String _lineSeparator = System.lineSeparator();
            String[] _split = _text_4.split(_lineSeparator);
            String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_split)));
            String comment = _join.trim();
            UniformInterfaceGene.ReqItem reqItem = new UniformInterfaceGene.ReqItem(name, require, type, comment);
            reqPrams.add(reqItem);
          }
        }
      }
      _xblockexpression = reqPrams;
    }
    return _xblockexpression;
  }
  
  public static UniformInterfaceGene.Req reqFrom(final Table reqTable) {
    UniformInterfaceGene.Req _xblockexpression = null;
    {
      TableRow _row = reqTable.getRow(1);
      TableCell _cell = _row.getCell(1);
      String _text = _cell.text();
      String method = _text.trim();
      TableRow _row_1 = reqTable.getRow(2);
      TableCell _cell_1 = _row_1.getCell(1);
      String _text_1 = _cell_1.text();
      String _trim = _text_1.trim();
      String _replace = _trim.replace("IP:PORT/xxx", "");
      String url = _replace.replace("IP:PORT", "");
      TableRow _row_2 = reqTable.getRow(2);
      TableCell _cell_2 = _row_2.getCell(1);
      String _text_2 = _cell_2.text();
      String _trim_1 = _text_2.trim();
      String _replace_1 = _trim_1.replace("IP:PORT/xxx/", "");
      String _replace_2 = _replace_1.replace("IP:PORT/", "");
      String _replace_3 = _replace_2.replace(".do", "");
      String[] _split = _replace_3.split("/");
      final Function1<String, String> _function = (String it) -> {
        return StringExtensions.toFirstUpper(it);
      };
      List<String> _map = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(_split)), _function);
      String _join = IterableExtensions.join(_map);
      String name = StringExtensions.toFirstLower(_join);
      TableRow _row_3 = reqTable.getRow(2);
      TableCell _cell_3 = _row_3.getCell(2);
      String _text_3 = _cell_3.text();
      String _lineSeparator = System.lineSeparator();
      String[] _split_1 = _text_3.split(_lineSeparator);
      String _join_1 = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_split_1)));
      String comment = _join_1.trim();
      UniformInterfaceGene.Req req = new UniformInterfaceGene.Req(method, url, name, comment);
      _xblockexpression = req;
    }
    return _xblockexpression;
  }
  
  public static CharSequence http(final String basePackageName, final String klassType, final List<UniformInterfaceGene.HttpReqResp> httpReqResps) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(basePackageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    {
      final Function1<UniformInterfaceGene.HttpReqResp, Boolean> _function = (UniformInterfaceGene.HttpReqResp it) -> {
        return Boolean.valueOf(Objects.equal(it.req.method, "GET"));
      };
      boolean _exists = IterableExtensions.<UniformInterfaceGene.HttpReqResp>exists(httpReqResps, _function);
      if (_exists) {
        _builder.append("import retrofit.http.GET;");
      }
    }
    _builder.newLineIfNotEmpty();
    {
      final Function1<UniformInterfaceGene.HttpReqResp, Boolean> _function_1 = (UniformInterfaceGene.HttpReqResp it) -> {
        return Boolean.valueOf(Objects.equal(it.req.method, "POST"));
      };
      boolean _exists_1 = IterableExtensions.<UniformInterfaceGene.HttpReqResp>exists(httpReqResps, _function_1);
      if (_exists_1) {
        _builder.append("import retrofit.http.POST;");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("import retrofit.http.Query;");
    _builder.newLine();
    _builder.append("import retrofit.http.QueryMap;");
    _builder.newLine();
    _builder.append("import retrofit.http.Body;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.Map;");
    _builder.newLine();
    _builder.newLine();
    {
      for(final UniformInterfaceGene.HttpReqResp http : httpReqResps) {
        {
          int _size = http.reqBodyItems.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("import ");
            _builder.append(basePackageName, "");
            _builder.append(".req.");
            String _reqBodyKlassType = http.reqBodyKlassType();
            _builder.append(_reqBodyKlassType, "");
            _builder.append(";");
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    {
      final Function1<UniformInterfaceGene.HttpReqResp, Boolean> _function_2 = (UniformInterfaceGene.HttpReqResp it) -> {
        int _size_1 = it.respItems.size();
        return Boolean.valueOf((_size_1 > 2));
      };
      Iterable<UniformInterfaceGene.HttpReqResp> _filter = IterableExtensions.<UniformInterfaceGene.HttpReqResp>filter(httpReqResps, _function_2);
      for(final UniformInterfaceGene.HttpReqResp http_1 : _filter) {
        _builder.append("import ");
        _builder.append(basePackageName, "");
        _builder.append(".resp.");
        String _respKlassType = http_1.respKlassType();
        _builder.append(_respKlassType, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("public interface ");
    _builder.append(klassType, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      for(final UniformInterfaceGene.HttpReqResp http_2 : httpReqResps) {
        _builder.append("\t");
        _builder.append("/** ");
        _builder.append(http_2.req.comment, "\t");
        _builder.append(" */");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _methodAnnotation = http_2.methodAnnotation();
        _builder.append(_methodAnnotation, "\t");
        _builder.append("(\"");
        _builder.append(http_2.req.url, "\t");
        _builder.append("\")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _respKlassType_1 = http_2.respKlassType();
        _builder.append(_respKlassType_1, "\t");
        _builder.append(" ");
        _builder.append(http_2.req.name, "\t");
        _builder.append("(");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          boolean _hasElements = false;
          for(final UniformInterfaceGene.ReqItem f : http_2.reqPrams) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",", "\t");
            }
            _builder.append("@Query(\"");
            String _javaName = f.javaName();
            _builder.append(_javaName, "\t");
            _builder.append("\")\t\t");
            _builder.append(f.type, "\t");
            _builder.append(" ");
            String _javaName_1 = f.javaName();
            _builder.append(_javaName_1, "\t");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
          }
        }
        {
          int _size_1 = http_2.reqBodyItems.size();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            _builder.append("@Body ");
            String _reqBodyKlassType_1 = http_2.reqBodyKlassType();
            _builder.append(_reqBodyKlassType_1, "\t");
            _builder.append(" ");
            String _reqBodyKlassType_2 = http_2.reqBodyKlassType();
            String _firstLower = StringExtensions.toFirstLower(_reqBodyKlassType_2);
            _builder.append(_firstLower, "\t");
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("/** ");
        _builder.append(http_2.req.comment, "\t");
        _builder.append(" */");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _methodAnnotation_1 = http_2.methodAnnotation();
        _builder.append(_methodAnnotation_1, "\t");
        _builder.append("(\"");
        _builder.append(http_2.req.url, "\t");
        _builder.append("\")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _respKlassType_2 = http_2.respKlassType();
        _builder.append(_respKlassType_2, "\t");
        _builder.append(" ");
        _builder.append(http_2.req.name, "\t");
        _builder.append("ByMap(");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          int _size_2 = http_2.reqPrams.size();
          boolean _greaterThan_2 = (_size_2 > 0);
          if (_greaterThan_2) {
            _builder.append("@QueryMap Map<String,Object> queryMap");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
          }
        }
        {
          int _size_3 = http_2.reqBodyItems.size();
          boolean _greaterThan_3 = (_size_3 > 0);
          if (_greaterThan_3) {
            _builder.append("@Body ");
            String _reqBodyKlassType_3 = http_2.reqBodyKlassType();
            _builder.append(_reqBodyKlassType_3, "\t");
            _builder.append(" ");
            String _reqBodyKlassType_4 = http_2.reqBodyKlassType();
            String _firstLower_1 = StringExtensions.toFirstLower(_reqBodyKlassType_4);
            _builder.append(_firstLower_1, "\t");
          }
        }
        _builder.append(");\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public static CharSequence controller(final String basePackageName, final String klassType, final List<UniformInterfaceGene.HttpReqResp> httpReqResps) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    _builder.append(basePackageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
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
    {
      final Function1<UniformInterfaceGene.HttpReqResp, Boolean> _function = (UniformInterfaceGene.HttpReqResp it) -> {
        int _size = it.reqPrams.size();
        return Boolean.valueOf((_size > 0));
      };
      Iterable<UniformInterfaceGene.HttpReqResp> _filter = IterableExtensions.<UniformInterfaceGene.HttpReqResp>filter(httpReqResps, _function);
      for(final UniformInterfaceGene.HttpReqResp http : _filter) {
        _builder.append("import ");
        _builder.append(basePackageName, "");
        _builder.append(".req.");
        String _reqQueryKlassType = http.reqQueryKlassType();
        _builder.append(_reqQueryKlassType, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      final Function1<UniformInterfaceGene.HttpReqResp, Boolean> _function_1 = (UniformInterfaceGene.HttpReqResp it) -> {
        int _size = it.reqBodyItems.size();
        return Boolean.valueOf((_size > 0));
      };
      Iterable<UniformInterfaceGene.HttpReqResp> _filter_1 = IterableExtensions.<UniformInterfaceGene.HttpReqResp>filter(httpReqResps, _function_1);
      for(final UniformInterfaceGene.HttpReqResp http_1 : _filter_1) {
        _builder.append("import ");
        _builder.append(basePackageName, "");
        _builder.append(".req.");
        String _reqBodyKlassType = http_1.reqBodyKlassType();
        _builder.append(_reqBodyKlassType, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      final Function1<UniformInterfaceGene.HttpReqResp, Boolean> _function_2 = (UniformInterfaceGene.HttpReqResp it) -> {
        int _size = it.respItems.size();
        return Boolean.valueOf((_size > 2));
      };
      Iterable<UniformInterfaceGene.HttpReqResp> _filter_2 = IterableExtensions.<UniformInterfaceGene.HttpReqResp>filter(httpReqResps, _function_2);
      for(final UniformInterfaceGene.HttpReqResp http_2 : _filter_2) {
        _builder.append("import ");
        _builder.append(basePackageName, "");
        _builder.append(".resp.");
        String _respKlassType = http_2.respKlassType();
        _builder.append(_respKlassType, "");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("@RestController");
    _builder.newLine();
    _builder.append("@RequestMapping(\"uniform\")\t\t");
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(klassType, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      for(final UniformInterfaceGene.HttpReqResp http_3 : httpReqResps) {
        _builder.append("\t");
        _builder.append("/** ");
        _builder.append(http_3.req.comment, "\t");
        _builder.append(" */");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("@RequestMapping(value = \"");
        _builder.append(http_3.req.url, "\t");
        _builder.append("\", method = RequestMethod.");
        _builder.append(http_3.req.method, "\t");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _respKlassType_1 = http_3.respKlassType();
        _builder.append(_respKlassType_1, "\t");
        _builder.append(" ");
        _builder.append(http_3.req.name, "\t");
        _builder.append("(");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          int _size = http_3.reqPrams.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            String _reqQueryKlassType_1 = http_3.reqQueryKlassType();
            _builder.append(_reqQueryKlassType_1, "\t");
            _builder.append(" ");
            String _reqQueryKlassType_2 = http_3.reqQueryKlassType();
            String _firstLower = StringExtensions.toFirstLower(_reqQueryKlassType_2);
            _builder.append(_firstLower, "\t");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          if (((http_3.reqPrams.size() > 0) && (http_3.reqBodyItems.size() > 0))) {
            _builder.append(",");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        {
          int _size_1 = http_3.reqBodyItems.size();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            _builder.append("@RequestBody ");
            String _reqBodyKlassType_1 = http_3.reqBodyKlassType();
            _builder.append(_reqBodyKlassType_1, "\t");
            _builder.append(" ");
            String _reqBodyKlassType_2 = http_3.reqBodyKlassType();
            String _firstLower_1 = StringExtensions.toFirstLower(_reqBodyKlassType_2);
            _builder.append(_firstLower_1, "\t");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append(") {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        {
          int _size_2 = http_3.reqPrams.size();
          boolean _greaterThan_2 = (_size_2 > 0);
          if (_greaterThan_2) {
            _builder.append("System.out.println(");
            String _reqQueryKlassType_3 = http_3.reqQueryKlassType();
            String _firstLower_2 = StringExtensions.toFirstLower(_reqQueryKlassType_3);
            _builder.append(_firstLower_2, "\t\t");
            _builder.append(");");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        {
          int _size_3 = http_3.reqBodyItems.size();
          boolean _greaterThan_3 = (_size_3 > 0);
          if (_greaterThan_3) {
            _builder.append("System.out.println(");
            String _reqBodyKlassType_3 = http_3.reqBodyKlassType();
            String _firstLower_3 = StringExtensions.toFirstLower(_reqBodyKlassType_3);
            _builder.append(_firstLower_3, "\t\t");
            _builder.append(");");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return new ");
        String _respKlassType_2 = http_3.respKlassType();
        _builder.append(_respKlassType_2, "\t\t");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public static CharSequence reqQuery(final String basePackageName, final UniformInterfaceGene.HttpReqResp httpReqResp) {
    CharSequence _xblockexpression = null;
    {
      final List<UniformInterfaceGene.ReqItem> fields = httpReqResp.reqPrams;
      String klassType = httpReqResp.reqQueryKlassType();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import java.util.HashMap;");
      _builder.newLine();
      _builder.append("import java.util.Map;");
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
      {
        final Function1<UniformInterfaceGene.ReqItem, Boolean> _function = (UniformInterfaceGene.ReqItem it) -> {
          String _javaName = it.javaName();
          return Boolean.valueOf((!Objects.equal(it.name, _javaName)));
        };
        boolean _exists = IterableExtensions.<UniformInterfaceGene.ReqItem>exists(fields, _function);
        if (_exists) {
          _builder.append("import com.google.gson.annotations.SerializedName;");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(klassType, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        for(final UniformInterfaceGene.ReqItem f : fields) {
          _builder.append("\t");
          _builder.append("/** ");
          _builder.append(f.comment, "\t");
          _builder.append(" */");
          _builder.newLineIfNotEmpty();
          {
            String _javaName = f.javaName();
            boolean _notEquals = (!Objects.equal(f.name, _javaName));
            if (_notEquals) {
              _builder.append("\t");
              _builder.append("@SerializedName(\"");
              _builder.append(f.name, "\t");
              _builder.append("\")");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("private ");
          _builder.append(f.type, "\t");
          _builder.append(" ");
          String _javaName_1 = f.javaName();
          _builder.append(_javaName_1, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public Map<String,Object> toQueryMap(){");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("Map<String,Object> queryMap=new HashMap<>();");
      _builder.newLine();
      {
        for(final UniformInterfaceGene.ReqItem f_1 : fields) {
          _builder.append("\t\t");
          _builder.append("queryMap.put(\"");
          String _javaName_2 = f_1.javaName();
          _builder.append(_javaName_2, "\t\t");
          _builder.append("\",");
          String _javaName_3 = f_1.javaName();
          _builder.append(_javaName_3, "\t\t");
          _builder.append(");");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("        ");
      _builder.append("return queryMap;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(klassType, "\t");
      _builder.append("(){}");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(klassType, "\t");
      _builder.append("(");
      final Function1<UniformInterfaceGene.ReqItem, String> _function_1 = (UniformInterfaceGene.ReqItem it) -> {
        String _javaName_4 = it.javaName();
        return ((it.type + " ") + _javaName_4);
      };
      List<String> _map = ListExtensions.<UniformInterfaceGene.ReqItem, String>map(fields, _function_1);
      String _join = IterableExtensions.join(_map, ",");
      _builder.append(_join, "\t");
      _builder.append("){");
      _builder.newLineIfNotEmpty();
      {
        for(final UniformInterfaceGene.ReqItem f_2 : fields) {
          _builder.append("\t\t");
          _builder.append("this.");
          String _javaName_4 = f_2.javaName();
          _builder.append(_javaName_4, "\t\t");
          _builder.append("=");
          String _javaName_5 = f_2.javaName();
          _builder.append(_javaName_5, "\t\t");
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
        for(final UniformInterfaceGene.ReqItem f_3 : fields) {
          _builder.append("\t");
          _builder.append("public ");
          _builder.append(f_3.type, "\t");
          _builder.append(" get");
          String _javaName_6 = f_3.javaName();
          String _firstUpper = StringExtensions.toFirstUpper(_javaName_6);
          _builder.append(_firstUpper, "\t");
          _builder.append("() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return ");
          String _javaName_7 = f_3.javaName();
          _builder.append(_javaName_7, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void set");
          String _javaName_8 = f_3.javaName();
          String _firstUpper_1 = StringExtensions.toFirstUpper(_javaName_8);
          _builder.append(_firstUpper_1, "\t");
          _builder.append("(");
          _builder.append(f_3.type, "\t");
          _builder.append(" ");
          String _javaName_9 = f_3.javaName();
          _builder.append(_javaName_9, "\t");
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("this.");
          String _javaName_10 = f_3.javaName();
          _builder.append(_javaName_10, "\t\t");
          _builder.append(" = ");
          String _javaName_11 = f_3.javaName();
          _builder.append(_javaName_11, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
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
  
  public static CharSequence reqBody(final String basePackageName, final UniformInterfaceGene.HttpReqResp httpReqResp) {
    CharSequence _xblockexpression = null;
    {
      final List<UniformInterfaceGene.ReqItem> fields = httpReqResp.reqBodyItems;
      String klassType = httpReqResp.reqBodyKlassType();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.HashCodeBuilder;");
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.EqualsBuilder;");
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.ToStringBuilder;");
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.ToStringStyle;");
      _builder.newLine();
      {
        final Function1<UniformInterfaceGene.ReqItem, Boolean> _function = (UniformInterfaceGene.ReqItem it) -> {
          String _javaName = it.javaName();
          return Boolean.valueOf((!Objects.equal(it.name, _javaName)));
        };
        boolean _exists = IterableExtensions.<UniformInterfaceGene.ReqItem>exists(fields, _function);
        if (_exists) {
          _builder.append("import com.google.gson.annotations.SerializedName;");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(klassType, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        for(final UniformInterfaceGene.ReqItem f : fields) {
          _builder.append("\t");
          _builder.append("/** ");
          _builder.append(f.comment, "\t");
          _builder.append(" */");
          _builder.newLineIfNotEmpty();
          {
            String _javaName = f.javaName();
            boolean _notEquals = (!Objects.equal(f.name, _javaName));
            if (_notEquals) {
              _builder.append("\t");
              _builder.append("@SerializedName(\"");
              _builder.append(f.name, "\t");
              _builder.append("\")");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("private ");
          _builder.append(f.type, "\t");
          _builder.append(" ");
          String _javaName_1 = f.javaName();
          _builder.append(_javaName_1, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(klassType, "\t");
      _builder.append("(){}");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(klassType, "\t");
      _builder.append("(");
      final Function1<UniformInterfaceGene.ReqItem, String> _function_1 = (UniformInterfaceGene.ReqItem it) -> {
        String _javaName_2 = it.javaName();
        return ((it.type + " ") + _javaName_2);
      };
      List<String> _map = ListExtensions.<UniformInterfaceGene.ReqItem, String>map(fields, _function_1);
      String _join = IterableExtensions.join(_map, ",");
      _builder.append(_join, "\t");
      _builder.append("){");
      _builder.newLineIfNotEmpty();
      {
        for(final UniformInterfaceGene.ReqItem f_1 : fields) {
          _builder.append("\t\t");
          _builder.append("this.");
          String _javaName_2 = f_1.javaName();
          _builder.append(_javaName_2, "\t\t");
          _builder.append("=");
          String _javaName_3 = f_1.javaName();
          _builder.append(_javaName_3, "\t\t");
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
        for(final UniformInterfaceGene.ReqItem f_2 : fields) {
          _builder.append("\t");
          _builder.append("public ");
          _builder.append(f_2.type, "\t");
          _builder.append(" get");
          String _javaName_4 = f_2.javaName();
          String _firstUpper = StringExtensions.toFirstUpper(_javaName_4);
          _builder.append(_firstUpper, "\t");
          _builder.append("() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return ");
          String _javaName_5 = f_2.javaName();
          _builder.append(_javaName_5, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void set");
          String _javaName_6 = f_2.javaName();
          String _firstUpper_1 = StringExtensions.toFirstUpper(_javaName_6);
          _builder.append(_firstUpper_1, "\t");
          _builder.append("(");
          _builder.append(f_2.type, "\t");
          _builder.append(" ");
          String _javaName_7 = f_2.javaName();
          _builder.append(_javaName_7, "\t");
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("this.");
          String _javaName_8 = f_2.javaName();
          _builder.append(_javaName_8, "\t\t");
          _builder.append(" = ");
          String _javaName_9 = f_2.javaName();
          _builder.append(_javaName_9, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
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
  
  public static CharSequence resp(final String basePackageName, final UniformInterfaceGene.HttpReqResp httpReqResp) {
    CharSequence _xblockexpression = null;
    {
      final Function1<UniformInterfaceGene.RespItem, Boolean> _function = (UniformInterfaceGene.RespItem it) -> {
        boolean _startsWith = it.name.startsWith("|");
        return Boolean.valueOf((!_startsWith));
      };
      final Iterable<UniformInterfaceGene.RespItem> fields = IterableExtensions.<UniformInterfaceGene.RespItem>filter(httpReqResp.respItems, _function);
      String _firstUpper = StringExtensions.toFirstUpper(httpReqResp.req.name);
      String klassType = (_firstUpper + "Resp");
      int _size = httpReqResp.respItems.size();
      boolean _equals = (_size == 2);
      if (_equals) {
        klassType = "DefaultResp";
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.HashCodeBuilder;");
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.EqualsBuilder;");
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.ToStringBuilder;");
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.ToStringStyle;");
      _builder.newLine();
      {
        final Function1<UniformInterfaceGene.RespItem, Boolean> _function_1 = (UniformInterfaceGene.RespItem it) -> {
          String _javaName = it.javaName();
          return Boolean.valueOf((!Objects.equal(it.name, _javaName)));
        };
        boolean _exists = IterableExtensions.<UniformInterfaceGene.RespItem>exists(fields, _function_1);
        if (_exists) {
          _builder.append("import com.google.gson.annotations.SerializedName;");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(klassType, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        for(final UniformInterfaceGene.RespItem f : fields) {
          _builder.append("\t");
          _builder.append("/** ");
          _builder.append(f.label, "\t");
          _builder.append(" */");
          _builder.newLineIfNotEmpty();
          {
            String _javaName = f.javaName();
            boolean _notEquals = (!Objects.equal(f.name, _javaName));
            if (_notEquals) {
              _builder.append("\t");
              _builder.append("@SerializedName(\"");
              _builder.append(f.name, "\t");
              _builder.append("\")");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("private ");
          _builder.append(f.type, "\t");
          _builder.append(" ");
          String _javaName_1 = f.javaName();
          _builder.append(_javaName_1, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(klassType, "\t");
      _builder.append("(){}");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(klassType, "\t");
      _builder.append("(");
      final Function1<UniformInterfaceGene.RespItem, String> _function_2 = (UniformInterfaceGene.RespItem it) -> {
        String _javaName_2 = it.javaName();
        return ((it.type + " ") + _javaName_2);
      };
      Iterable<String> _map = IterableExtensions.<UniformInterfaceGene.RespItem, String>map(fields, _function_2);
      String _join = IterableExtensions.join(_map, ",");
      _builder.append(_join, "\t");
      _builder.append("){");
      _builder.newLineIfNotEmpty();
      {
        for(final UniformInterfaceGene.RespItem f_1 : fields) {
          _builder.append("\t\t");
          _builder.append("this.");
          String _javaName_2 = f_1.javaName();
          _builder.append(_javaName_2, "\t\t");
          _builder.append("=");
          String _javaName_3 = f_1.javaName();
          _builder.append(_javaName_3, "\t\t");
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
        for(final UniformInterfaceGene.RespItem f_2 : fields) {
          _builder.append("\t");
          _builder.append("public ");
          _builder.append(f_2.type, "\t");
          _builder.append(" get");
          String _javaName_4 = f_2.javaName();
          String _firstUpper_1 = StringExtensions.toFirstUpper(_javaName_4);
          _builder.append(_firstUpper_1, "\t");
          _builder.append("() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return ");
          String _javaName_5 = f_2.javaName();
          _builder.append(_javaName_5, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void set");
          String _javaName_6 = f_2.javaName();
          String _firstUpper_2 = StringExtensions.toFirstUpper(_javaName_6);
          _builder.append(_firstUpper_2, "\t");
          _builder.append("(");
          _builder.append(f_2.type, "\t");
          _builder.append(" ");
          String _javaName_7 = f_2.javaName();
          _builder.append(_javaName_7, "\t");
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("this.");
          String _javaName_8 = f_2.javaName();
          _builder.append(_javaName_8, "\t\t");
          _builder.append(" = ");
          String _javaName_9 = f_2.javaName();
          _builder.append(_javaName_9, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
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
  
  public static CharSequence respSub(final String basePackageName, final UniformInterfaceGene.HttpReqResp httpReqResp, final int index) {
    CharSequence _xblockexpression = null;
    {
      ArrayList<UniformInterfaceGene.RespItem> fields = CollectionLiterals.<UniformInterfaceGene.RespItem>newArrayList();
      boolean break_ = false;
      for (int i = (index + 1); (i < httpReqResp.respItems.size()); i++) {
        {
          final UniformInterfaceGene.RespItem item = httpReqResp.respItems.get(i);
          if ((item.name.startsWith("|") && (break_ == false))) {
            String name = item.name.replace("|", "");
            String type = item.type;
            String comment = item.label;
            UniformInterfaceGene.RespItem respItem = new UniformInterfaceGene.RespItem(name, type, comment);
            fields.add(respItem);
          } else {
            break_ = true;
          }
        }
      }
      UniformInterfaceGene.RespItem _get = httpReqResp.respItems.get(index);
      String klassType = _get.type;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.HashCodeBuilder;");
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.EqualsBuilder;");
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.ToStringBuilder;");
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.builder.ToStringStyle;");
      _builder.newLine();
      {
        final Function1<UniformInterfaceGene.RespItem, Boolean> _function = (UniformInterfaceGene.RespItem it) -> {
          String _javaName = it.javaName();
          return Boolean.valueOf((!Objects.equal(it.name, _javaName)));
        };
        boolean _exists = IterableExtensions.<UniformInterfaceGene.RespItem>exists(fields, _function);
        if (_exists) {
          _builder.append("import com.google.gson.annotations.SerializedName;");
          _builder.newLine();
        }
      }
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(klassType, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        for(final UniformInterfaceGene.RespItem f : fields) {
          _builder.append("\t");
          _builder.append("/** ");
          _builder.append(f.label, "\t");
          _builder.append(" */");
          _builder.newLineIfNotEmpty();
          {
            String _javaName = f.javaName();
            boolean _notEquals = (!Objects.equal(f.name, _javaName));
            if (_notEquals) {
              _builder.append("\t");
              _builder.append("@SerializedName(\"");
              _builder.append(f.name, "\t");
              _builder.append("\")");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          _builder.append("private ");
          _builder.append(f.type, "\t");
          _builder.append(" ");
          String _javaName_1 = f.javaName();
          _builder.append(_javaName_1, "\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(klassType, "\t");
      _builder.append("(){}");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public ");
      _builder.append(klassType, "\t");
      _builder.append("(");
      final Function1<UniformInterfaceGene.RespItem, String> _function_1 = (UniformInterfaceGene.RespItem it) -> {
        String _javaName_2 = it.javaName();
        return ((it.type + " ") + _javaName_2);
      };
      List<String> _map = ListExtensions.<UniformInterfaceGene.RespItem, String>map(fields, _function_1);
      String _join = IterableExtensions.join(_map, ",");
      _builder.append(_join, "\t");
      _builder.append("){");
      _builder.newLineIfNotEmpty();
      {
        for(final UniformInterfaceGene.RespItem f_1 : fields) {
          _builder.append("\t\t");
          _builder.append("this.");
          String _javaName_2 = f_1.javaName();
          _builder.append(_javaName_2, "\t\t");
          _builder.append("=");
          String _javaName_3 = f_1.javaName();
          _builder.append(_javaName_3, "\t\t");
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
        for(final UniformInterfaceGene.RespItem f_2 : fields) {
          _builder.append("\t");
          _builder.append("public ");
          _builder.append(f_2.type, "\t");
          _builder.append(" get");
          String _javaName_4 = f_2.javaName();
          String _firstUpper = StringExtensions.toFirstUpper(_javaName_4);
          _builder.append(_firstUpper, "\t");
          _builder.append("() {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return ");
          String _javaName_5 = f_2.javaName();
          _builder.append(_javaName_5, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.newLine();
          _builder.append("\t");
          _builder.append("public void set");
          String _javaName_6 = f_2.javaName();
          String _firstUpper_1 = StringExtensions.toFirstUpper(_javaName_6);
          _builder.append(_firstUpper_1, "\t");
          _builder.append("(");
          _builder.append(f_2.type, "\t");
          _builder.append(" ");
          String _javaName_7 = f_2.javaName();
          _builder.append(_javaName_7, "\t");
          _builder.append(") {");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("this.");
          String _javaName_8 = f_2.javaName();
          _builder.append(_javaName_8, "\t\t");
          _builder.append(" = ");
          String _javaName_9 = f_2.javaName();
          _builder.append(_javaName_9, "\t\t");
          _builder.append(";");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
          _builder.append("\t");
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
  
  public static String javaNameFrom(final String name) {
    String _switchResult = null;
    switch (name) {
      default:
        _switchResult = name;
        break;
    }
    return _switchResult;
  }
}
