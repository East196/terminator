package com.github.east196.xcode.xdart;

import com.github.east196.xcode.bot.Bots;
import com.github.east196.xcode.model.Field;
import com.github.east196.xcode.model.GeneResult;
import com.github.east196.xcode.model.Project;
import com.github.east196.xcode.model.Record;
import com.github.east196.xcode.model.Three;
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
public class Api2019 {
  @Data
  public static class HttpReqResp {
    private final Three project;
    
    private final Three headers;
    
    private final Three params;
    
    private final Three reqBody;
    
    private final Three reqBodyEntity;
    
    private final Three respBody;
    
    private final Three respBodyEntity;
    
    public HttpReqResp(final Three project, final Three headers, final Three params, final Three reqBody, final Three reqBodyEntity, final Three respBody, final Three respBodyEntity) {
      super();
      this.project = project;
      this.headers = headers;
      this.params = params;
      this.reqBody = reqBody;
      this.reqBodyEntity = reqBodyEntity;
      this.respBody = respBody;
      this.respBodyEntity = respBodyEntity;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.project== null) ? 0 : this.project.hashCode());
      result = prime * result + ((this.headers== null) ? 0 : this.headers.hashCode());
      result = prime * result + ((this.params== null) ? 0 : this.params.hashCode());
      result = prime * result + ((this.reqBody== null) ? 0 : this.reqBody.hashCode());
      result = prime * result + ((this.reqBodyEntity== null) ? 0 : this.reqBodyEntity.hashCode());
      result = prime * result + ((this.respBody== null) ? 0 : this.respBody.hashCode());
      result = prime * result + ((this.respBodyEntity== null) ? 0 : this.respBodyEntity.hashCode());
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
      Api2019.HttpReqResp other = (Api2019.HttpReqResp) obj;
      if (this.project == null) {
        if (other.project != null)
          return false;
      } else if (!this.project.equals(other.project))
        return false;
      if (this.headers == null) {
        if (other.headers != null)
          return false;
      } else if (!this.headers.equals(other.headers))
        return false;
      if (this.params == null) {
        if (other.params != null)
          return false;
      } else if (!this.params.equals(other.params))
        return false;
      if (this.reqBody == null) {
        if (other.reqBody != null)
          return false;
      } else if (!this.reqBody.equals(other.reqBody))
        return false;
      if (this.reqBodyEntity == null) {
        if (other.reqBodyEntity != null)
          return false;
      } else if (!this.reqBodyEntity.equals(other.reqBodyEntity))
        return false;
      if (this.respBody == null) {
        if (other.respBody != null)
          return false;
      } else if (!this.respBody.equals(other.respBody))
        return false;
      if (this.respBodyEntity == null) {
        if (other.respBodyEntity != null)
          return false;
      } else if (!this.respBodyEntity.equals(other.respBodyEntity))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("project", this.project);
      b.add("headers", this.headers);
      b.add("params", this.params);
      b.add("reqBody", this.reqBody);
      b.add("reqBodyEntity", this.reqBodyEntity);
      b.add("respBody", this.respBody);
      b.add("respBodyEntity", this.respBodyEntity);
      return b.toString();
    }
    
    @Pure
    public Three getProject() {
      return this.project;
    }
    
    @Pure
    public Three getHeaders() {
      return this.headers;
    }
    
    @Pure
    public Three getParams() {
      return this.params;
    }
    
    @Pure
    public Three getReqBody() {
      return this.reqBody;
    }
    
    @Pure
    public Three getReqBodyEntity() {
      return this.reqBodyEntity;
    }
    
    @Pure
    public Three getRespBody() {
      return this.respBody;
    }
    
    @Pure
    public Three getRespBodyEntity() {
      return this.respBodyEntity;
    }
  }
  
  public static void main(final String[] args) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("E:\\backup\\xcode\\API_EM_NEW(1).doc");
    String src = _builder.toString();
    Api2019.gene(src);
  }
  
  public static void gene(final String src) {
    final ArrayList<Table> tables = Bots.tables(src);
    int _size = tables.size();
    String _plus = ("--表格总数：" + Integer.valueOf(_size));
    InputOutput.<String>println(_plus);
    final Function1<Table, Boolean> _function = (Table it) -> {
      TableRow _row = it.getRow(0);
      TableCell _cell = _row.getCell(0);
      String _text = _cell.text();
      String _trim = _text.trim();
      return Boolean.valueOf(_trim.equalsIgnoreCase("project"));
    };
    Iterable<Table> _filter = IterableExtensions.<Table>filter(tables, _function);
    final Table projecttable = ((Table[])Conversions.unwrapArray(_filter, Table.class))[0];
    final Function1<Table, Boolean> _function_1 = (Table it) -> {
      TableRow _row = it.getRow(0);
      TableCell _cell = _row.getCell(0);
      String _text = _cell.text();
      String _trim = _text.trim();
      return Boolean.valueOf(_trim.equalsIgnoreCase("vo"));
    };
    final Iterable<Table> datatables = IterableExtensions.<Table>filter(tables, _function_1);
    final Function1<Table, Boolean> _function_2 = (Table it) -> {
      TableRow _row = it.getRow(0);
      TableCell _cell = _row.getCell(0);
      String _text = _cell.text();
      String _trim = _text.trim();
      return Boolean.valueOf(_trim.equalsIgnoreCase("rest"));
    };
    final Iterable<Table> resttables = IterableExtensions.<Table>filter(tables, _function_2);
    final Three projectThree = Api2019.table2project(projecttable);
    final Consumer<Table> _function_3 = (Table table) -> {
      final Three three = Api2019.table2data(projectThree, table);
      Project _project = projectThree.getProject();
      three.setProject(_project);
      GeneResult _threeEntityGene = Api2019.threeEntityGene(three);
      _threeEntityGene.copy();
    };
    datatables.forEach(_function_3);
    final Function1<Table, Api2019.HttpReqResp> _function_4 = (Table table) -> {
      Api2019.HttpReqResp _xblockexpression = null;
      {
        TableRow _row = table.getRow(0);
        TableCell _cell = _row.getCell(1);
        String _text = _cell.text();
        InputOutput.<String>println(_text);
        Project _project = projectThree.getProject();
        final Api2019.HttpReqResp rest = Api2019.table2rest(_project, table);
        _xblockexpression = rest;
      }
      return _xblockexpression;
    };
    Iterable<Api2019.HttpReqResp> _map = IterableExtensions.<Table, Api2019.HttpReqResp>map(resttables, _function_4);
    final List<Api2019.HttpReqResp> httpReqResps = IterableExtensions.<Api2019.HttpReqResp>toList(_map);
    final Consumer<Api2019.HttpReqResp> _function_5 = (Api2019.HttpReqResp rest) -> {
      Three project = rest.project;
      Three headers = rest.headers;
      Api2019.geneEntity(headers, project);
      Three params = rest.params;
      Api2019.geneEntity(params, project);
      Three reqBody = rest.reqBody;
      Api2019.geneEntity(reqBody, project);
      Three respBody = rest.respBody;
      Api2019.geneEntity(respBody, project);
    };
    httpReqResps.forEach(_function_5);
    Project _project = projectThree.getProject();
    String _name = _project.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    final String controllerName = (_firstUpper + "Controller");
    Project _project_1 = projectThree.getProject();
    String _name_1 = _project_1.getName();
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_1);
    final String feignName = (_firstUpper_1 + "FeignClient");
    Project _project_2 = projectThree.getProject();
    String _name_2 = _project_2.getName();
    String _firstUpper_2 = StringExtensions.toFirstUpper(_name_2);
    final String retrofit2Name = (_firstUpper_2 + "Retrofit2Client");
    Project _project_3 = projectThree.getProject();
    final String basePath = _project_3.getPath();
    Project _project_4 = projectThree.getProject();
    String _root = _project_4.getRoot();
    String[] _split = _root.split("\\.");
    final String javaPath = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_split)), "\\");
    Project _project_5 = projectThree.getProject();
    String _name_3 = _project_5.getName();
    String packageName = StringExtensions.toFirstLower(_name_3);
    CharSequence content = Api2019.controller(projectThree, httpReqResps);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(basePath, "");
    _builder.append("\\src\\main\\java\\");
    _builder.append(javaPath, "");
    _builder.append("\\");
    _builder.append(packageName, "");
    _builder.append("\\");
    Project _project_6 = projectThree.getProject();
    String _name_4 = _project_6.getName();
    String _firstUpper_3 = StringExtensions.toFirstUpper(_name_4);
    _builder.append(_firstUpper_3, "");
    _builder.append("Controller.java");
    String path = _builder.toString();
    GeneResult _geneResult = new GeneResult(content, path);
    _geneResult.copy();
    CharSequence _service = Api2019.service(projectThree, httpReqResps);
    content = _service;
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(basePath, "");
    _builder_1.append("\\src\\main\\java\\");
    _builder_1.append(javaPath, "");
    _builder_1.append("\\");
    _builder_1.append(packageName, "");
    _builder_1.append("\\");
    Project _project_7 = projectThree.getProject();
    String _name_5 = _project_7.getName();
    String _firstUpper_4 = StringExtensions.toFirstUpper(_name_5);
    _builder_1.append(_firstUpper_4, "");
    _builder_1.append("Service.java");
    path = _builder_1.toString();
    GeneResult _geneResult_1 = new GeneResult(content, path);
    _geneResult_1.copy();
    CharSequence _retrofit2 = Api2019.retrofit2(projectThree, httpReqResps);
    content = _retrofit2;
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append(basePath, "");
    _builder_2.append("\\src\\main\\java\\");
    _builder_2.append(javaPath, "");
    _builder_2.append("\\");
    _builder_2.append(packageName, "");
    _builder_2.append("\\");
    Project _project_8 = projectThree.getProject();
    String _name_6 = _project_8.getName();
    String _firstUpper_5 = StringExtensions.toFirstUpper(_name_6);
    _builder_2.append(_firstUpper_5, "");
    _builder_2.append("Retrofit2Client.java");
    path = _builder_2.toString();
    GeneResult _geneResult_2 = new GeneResult(content, path);
    _geneResult_2.copy();
    CharSequence _retrofit2remote = Api2019.retrofit2remote(projectThree, httpReqResps);
    content = _retrofit2remote;
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append(basePath, "");
    _builder_3.append("\\src\\main\\java\\");
    _builder_3.append(javaPath, "");
    _builder_3.append("\\");
    _builder_3.append(packageName, "");
    _builder_3.append("\\Retrofit2Remote.java");
    path = _builder_3.toString();
    GeneResult _geneResult_3 = new GeneResult(content, path);
    _geneResult_3.copy();
    CharSequence _feign = Api2019.feign(projectThree, httpReqResps);
    content = _feign;
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append(basePath, "");
    _builder_4.append("\\src\\main\\java\\");
    _builder_4.append(javaPath, "");
    _builder_4.append("\\");
    _builder_4.append(packageName, "");
    _builder_4.append("\\");
    Project _project_9 = projectThree.getProject();
    String _name_7 = _project_9.getName();
    String _firstUpper_6 = StringExtensions.toFirstUpper(_name_7);
    _builder_4.append(_firstUpper_6, "");
    _builder_4.append("FeignClient.java");
    path = _builder_4.toString();
    GeneResult _geneResult_4 = new GeneResult(content, path);
    _geneResult_4.copy();
    CharSequence _client = Api2019.client(projectThree, httpReqResps);
    content = _client;
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append(basePath, "");
    _builder_5.append("\\src\\main\\java\\");
    _builder_5.append(javaPath, "");
    _builder_5.append("\\");
    _builder_5.append(packageName, "");
    _builder_5.append("\\");
    Project _project_10 = projectThree.getProject();
    String _name_8 = _project_10.getName();
    String _firstUpper_7 = StringExtensions.toFirstUpper(_name_8);
    _builder_5.append(_firstUpper_7, "");
    _builder_5.append("Client.java");
    path = _builder_5.toString();
    GeneResult _geneResult_5 = new GeneResult(content, path);
    _geneResult_5.copy();
    CharSequence _dio = Api2019.dio(projectThree, httpReqResps);
    content = _dio;
    StringConcatenation _builder_6 = new StringConcatenation();
    _builder_6.append(basePath, "");
    _builder_6.append("\\src\\main\\java\\");
    _builder_6.append(javaPath, "");
    _builder_6.append("\\");
    _builder_6.append(packageName, "");
    _builder_6.append("\\");
    Project _project_11 = projectThree.getProject();
    String _name_9 = _project_11.getName();
    String _firstUpper_8 = StringExtensions.toFirstUpper(_name_9);
    _builder_6.append(_firstUpper_8, "");
    _builder_6.append("DioClient.dart");
    path = _builder_6.toString();
    GeneResult _geneResult_6 = new GeneResult(content, path);
    _geneResult_6.copy();
    CharSequence _mockResp = Api2019.mockResp(projectThree, httpReqResps);
    content = _mockResp;
    StringConcatenation _builder_7 = new StringConcatenation();
    _builder_7.append(basePath, "");
    _builder_7.append("\\src\\main\\java\\");
    _builder_7.append(javaPath, "");
    _builder_7.append("\\");
    _builder_7.append(packageName, "");
    _builder_7.append("\\");
    Project _project_12 = projectThree.getProject();
    String _name_10 = _project_12.getName();
    String _firstUpper_9 = StringExtensions.toFirstUpper(_name_10);
    _builder_7.append(_firstUpper_9, "");
    _builder_7.append("MockResp.js");
    path = _builder_7.toString();
    GeneResult _geneResult_7 = new GeneResult(content, path);
    _geneResult_7.copy();
  }
  
  protected static void geneEntity(final Three part, final Three project) {
    List<Field> _fields = part.getFields();
    int _length = ((Object[])Conversions.unwrapArray(_fields, Object.class)).length;
    boolean _greaterThan = (_length > 0);
    if (_greaterThan) {
      Project _project = project.getProject();
      part.setProject(_project);
      GeneResult _threeEntityGene = Api2019.threeEntityGene(part);
      _threeEntityGene.copy();
    }
  }
  
  protected static CharSequence threeEntityContent(final Three three) {
    CharSequence _xblockexpression = null;
    {
      Project project = three.getProject();
      Record record = three.getRecord();
      List<Field> fields = three.getFields();
      if (((!record.getName().endsWith("RespBody")) && (fields.size() == 0))) {
        StringConcatenation _builder = new StringConcatenation();
        return _builder;
      }
      CharSequence content = Api2019.entity(project, record, fields);
      _xblockexpression = content;
    }
    return _xblockexpression;
  }
  
  protected static CharSequence threeEntityPath(final Three three) {
    String _xblockexpression = null;
    {
      Project _project = three.getProject();
      final String basePath = _project.getPath();
      Project _project_1 = three.getProject();
      String _root = _project_1.getRoot();
      String[] _split = _root.split("\\.");
      final String javaPath = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_split)), "\\");
      Project _project_2 = three.getProject();
      String _name = _project_2.getName();
      String packageName = StringExtensions.toFirstLower(_name);
      Project project = three.getProject();
      Record record = three.getRecord();
      List<Field> fields = three.getFields();
      if (((!record.getName().endsWith("RespBody")) && (fields.size() == 0))) {
        StringConcatenation _builder = new StringConcatenation();
        return _builder;
      }
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(basePath, "");
      _builder_1.append("\\src\\main\\java\\");
      _builder_1.append(javaPath, "");
      _builder_1.append("\\");
      _builder_1.append(packageName, "");
      _builder_1.append("\\vo\\");
      String _name_1 = record.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name_1);
      _builder_1.append(_firstUpper, "");
      _builder_1.append(".java");
      String path = _builder_1.toString();
      _xblockexpression = path;
    }
    return _xblockexpression;
  }
  
  protected static GeneResult threeEntityGene(final Three three) {
    GeneResult _xblockexpression = null;
    {
      CharSequence content = Api2019.threeEntityContent(three);
      CharSequence path = Api2019.threeEntityPath(three);
      InputOutput.<CharSequence>println(path);
      InputOutput.<CharSequence>println(content);
      _xblockexpression = new GeneResult(content, path);
    }
    return _xblockexpression;
  }
  
  public static Api2019.HttpReqResp table2rest(final Project projectInfo, final Table table) {
    Api2019.HttpReqResp _xblockexpression = null;
    {
      Three project = Api2019.threeFrom(projectInfo, table);
      Three headers = Api2019.threeFrom(table, "Headers");
      Three params = Api2019.threeFrom(table, "Params");
      Three reqBody = Api2019.threeFrom(table, "ReqBody");
      Three reqBodyEntity = Api2019.threeFrom(table, "请求体");
      Three respBody = Api2019.threeFrom(table, "RespBody");
      Three respBodyEntity = Api2019.threeFrom(table, "响应体");
      _xblockexpression = new Api2019.HttpReqResp(project, headers, params, reqBody, reqBodyEntity, respBody, respBodyEntity);
    }
    return _xblockexpression;
  }
  
  public static Three threeFrom(final Project project, final Table table) {
    Three _xblockexpression = null;
    {
      Record record = Api2019.recordFrom(table);
      _xblockexpression = new Three(project, record, null);
    }
    return _xblockexpression;
  }
  
  public static Three threeFrom(final Table table, final String type) {
    Three _xblockexpression = null;
    {
      Project project = new Project();
      Record record = Api2019.recordFrom(table);
      String _name = record.getName();
      String _firstUpper = StringExtensions.toFirstUpper(type);
      String _plus = (_name + _firstUpper);
      record.setName(_plus);
      List<Field> _fieldsFrom = Api2019.fieldsFrom(table, type);
      _xblockexpression = new Three(project, record, _fieldsFrom);
    }
    return _xblockexpression;
  }
  
  public static Record recordFrom(final Table resttable) {
    Record _xblockexpression = null;
    {
      Record record = new Record();
      TableRow _row = resttable.getRow(1);
      TableCell _cell = _row.getCell(1);
      String _text = _cell.text();
      String _trim = _text.trim();
      record.setMethod(_trim);
      TableRow _row_1 = resttable.getRow(2);
      TableCell _cell_1 = _row_1.getCell(1);
      String _text_1 = _cell_1.text();
      String _trim_1 = _text_1.trim();
      record.setUrl(_trim_1);
      TableRow _row_2 = resttable.getRow(0);
      TableCell _cell_2 = _row_2.getCell(1);
      String _text_2 = _cell_2.text();
      String _trim_2 = _text_2.trim();
      record.setName(_trim_2);
      TableRow _row_3 = resttable.getRow(0);
      TableCell _cell_3 = _row_3.getCell(3);
      String _text_3 = _cell_3.text();
      String _trim_3 = _text_3.trim();
      record.setLabel(_trim_3);
      TableRow _row_4 = resttable.getRow(1);
      TableCell _cell_4 = _row_4.getCell(3);
      String _text_4 = _cell_4.text();
      String _trim_4 = _text_4.trim();
      record.setDoc(_trim_4);
      _xblockexpression = record;
    }
    return _xblockexpression;
  }
  
  public static List<Field> fieldsFrom(final Table resttable, final String type) {
    List<Field> _xblockexpression = null;
    {
      List<Field> fields = CollectionLiterals.<Field>newArrayList();
      for (int j = 3; (j < resttable.numRows()); j++) {
        {
          TableRow row = resttable.getRow(j);
          TableCell _cell = row.getCell(0);
          String _text = _cell.text();
          String rowType = _text.trim();
          if ((rowType.equalsIgnoreCase(type) && (!StringExtensions.isNullOrEmpty(row.getCell(1).text().trim())))) {
            Field field = new Field();
            TableCell _cell_1 = row.getCell(1);
            String _text_1 = _cell_1.text();
            String _trim = _text_1.trim();
            field.setName(_trim);
            String _name = field.getName();
            String _replace = _name.replace(" ", "_");
            String[] _split = _replace.split("_");
            final Function1<String, String> _function = (String item) -> {
              return StringExtensions.toFirstUpper(item);
            };
            List<String> _map = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(_split)), _function);
            String _join = IterableExtensions.join(_map);
            String _firstLower = StringExtensions.toFirstLower(_join);
            field.setName(_firstLower);
            TableCell _cell_2 = row.getCell(2);
            String _text_2 = _cell_2.text();
            String _trim_1 = _text_2.trim();
            field.setType(_trim_1);
            TableCell _cell_3 = row.getCell(3);
            String _text_3 = _cell_3.text();
            String _trim_2 = _text_3.trim();
            field.setLabel(_trim_2);
            TableCell _cell_4 = row.getCell(3);
            String _text_4 = _cell_4.text();
            String _trim_3 = _text_4.trim();
            field.setDoc(_trim_3);
            fields.add(field);
          }
        }
      }
      _xblockexpression = fields;
    }
    return _xblockexpression;
  }
  
  public static CharSequence entity(final Project project, final Record record, final List<Field> fields) {
    CharSequence _xblockexpression = null;
    {
      String _name = record.getName();
      String klassType = StringExtensions.toFirstUpper(_name);
      String _name_1 = project.getName();
      String packageName = StringExtensions.toFirstLower(_name_1);
      final String basePackageName = project.getRoot();
      String _root = project.getRoot();
      String[] _split = _root.split("\\.");
      String _root_1 = project.getRoot();
      String[] _split_1 = _root_1.split("\\.");
      int _length = _split_1.length;
      int _minus = (_length - 1);
      List<String> _subList = ((List<String>)Conversions.doWrapArray(_split)).subList(0, _minus);
      final String commonPackageName = IterableExtensions.join(_subList, ".");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      _builder.append(packageName, "");
      _builder.append(".vo;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.append("import java.util.Date;");
      _builder.newLine();
      _builder.append("import java.util.HashMap;");
      _builder.newLine();
      _builder.append("import java.util.Map;");
      _builder.newLine();
      _builder.append("import java.util.ArrayList;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import lombok.Data;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("import ");
      _builder.append(commonPackageName, "");
      _builder.append(".common.Converts;");
      _builder.newLineIfNotEmpty();
      _builder.append("import ");
      _builder.append(commonPackageName, "");
      _builder.append(".common.vo.*;");
      _builder.newLineIfNotEmpty();
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
          _builder.append("/** ");
          String _doc = f.getDoc();
          _builder.append(_doc, "\t");
          _builder.append(" ");
          String _label = f.getLabel();
          _builder.append(_label, "\t");
          _builder.append(" **/");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("private ");
          String _javaType = f.javaType();
          _builder.append(_javaType, "\t");
          _builder.append(" ");
          String _name_2 = f.getName();
          String _firstLower = StringExtensions.toFirstLower(_name_2);
          _builder.append(_firstLower, "\t");
          _builder.append(";\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public Map<String,Object> toMap(){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Map<String,Object> map = new HashMap<>();");
      _builder.newLine();
      {
        for(final Field f_1 : fields) {
          _builder.append("\t\t");
          _builder.append("map.put(\"");
          String _name_3 = f_1.getName();
          String _firstLower_1 = StringExtensions.toFirstLower(_name_3);
          _builder.append(_firstLower_1, "\t\t");
          _builder.append("\",");
          String _name_4 = f_1.getName();
          String _firstLower_2 = StringExtensions.toFirstLower(_name_4);
          _builder.append(_firstLower_2, "\t\t");
          _builder.append(");\t");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.append("return map;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public List<NameValuePair> toNameValuePairs(){");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("List<NameValuePair> nameValuePairs = new ArrayList<>();");
      _builder.newLine();
      {
        for(final Field f_2 : fields) {
          _builder.append("\t\t");
          _builder.append("NameValuePair ");
          String _name_5 = f_2.getName();
          String _firstLower_3 = StringExtensions.toFirstLower(_name_5);
          _builder.append(_firstLower_3, "\t\t");
          _builder.append("pair = new NameValuePair(\"");
          String _name_6 = f_2.getName();
          String _firstLower_4 = StringExtensions.toFirstLower(_name_6);
          _builder.append(_firstLower_4, "\t\t");
          _builder.append("\",");
          String _name_7 = f_2.getName();
          String _firstLower_5 = StringExtensions.toFirstLower(_name_7);
          _builder.append(_firstLower_5, "\t\t");
          _builder.append(".toString());\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t\t");
          _builder.append("nameValuePairs.add(");
          String _name_8 = f_2.getName();
          String _firstLower_6 = StringExtensions.toFirstLower(_name_8);
          _builder.append(_firstLower_6, "\t\t");
          _builder.append("pair);");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append("\t\t");
      _builder.append("return nameValuePairs;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence retrofit2remote(final Three projectThree, final List<Api2019.HttpReqResp> httpReqResps) {
    CharSequence _xblockexpression = null;
    {
      Project _project = projectThree.getProject();
      String _name = _project.getName();
      String packageName = StringExtensions.toFirstLower(_name);
      Project _project_1 = projectThree.getProject();
      final String basePackageName = _project_1.getRoot();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      _builder.append(packageName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import java.io.IOException;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.apache.commons.lang3.StringUtils;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import okhttp3.Interceptor;");
      _builder.newLine();
      _builder.append("import okhttp3.OkHttpClient;");
      _builder.newLine();
      _builder.append("import okhttp3.Request;");
      _builder.newLine();
      _builder.append("import okhttp3.Response;");
      _builder.newLine();
      _builder.append("import retrofit2.Retrofit;");
      _builder.newLine();
      _builder.append("import retrofit2.converter.gson.GsonConverterFactory;");
      _builder.newLine();
      _builder.append("import com.google.gson.GsonBuilder;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public class Retrofit2Remote {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private static final String BASE_URL = \"http://httpbin.org/\";");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private static final String TOKEN_NAME = \"X-Access-Token\";");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private static String token = null;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private static String getToken() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return token;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static OkHttpClient okHttpClient;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public static Retrofit retrofit;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("class TokenHeaderInterceptor implements Interceptor {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("@Override");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("public Response intercept(Chain chain) throws IOException {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("String token = getToken();");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("if (StringUtils.isEmpty(token)) {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("Request originalRequest = chain.request();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("return chain.proceed(originalRequest);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("} else {");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("Request originalRequest = chain.request();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("Request updateRequest = originalRequest.newBuilder().header(TOKEN_NAME, token).build();");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("return chain.proceed(updateRequest);");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(new TokenHeaderInterceptor()).build();");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("retrofit = new Retrofit.Builder().baseUrl(BASE_URL)");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append(".addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append(".client(okHttpClient).build();");
      _builder.newLine();
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
  
  public static CharSequence retrofit2(final Three projectThree, final List<Api2019.HttpReqResp> httpReqResps) {
    CharSequence _xblockexpression = null;
    {
      Project _project = projectThree.getProject();
      String _name = _project.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name);
      final String controllerName = (_firstUpper + "Controller");
      Project _project_1 = projectThree.getProject();
      String _name_1 = _project_1.getName();
      String _firstUpper_1 = StringExtensions.toFirstUpper(_name_1);
      final String feignName = (_firstUpper_1 + "FeignClient");
      Project _project_2 = projectThree.getProject();
      String _name_2 = _project_2.getName();
      String _firstUpper_2 = StringExtensions.toFirstUpper(_name_2);
      final String retrofit2Name = (_firstUpper_2 + "Retrofit2Client");
      Project _project_3 = projectThree.getProject();
      final String basePath = _project_3.getPath();
      Project _project_4 = projectThree.getProject();
      String _root = _project_4.getRoot();
      String[] _split = _root.split("\\.");
      final String javaPath = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_split)), "\\");
      Project _project_5 = projectThree.getProject();
      String _name_3 = _project_5.getName();
      String packageName = StringExtensions.toFirstLower(_name_3);
      Project _project_6 = projectThree.getProject();
      final String basePackageName = _project_6.getRoot();
      Project _project_7 = projectThree.getProject();
      String _root_1 = _project_7.getRoot();
      String[] _split_1 = _root_1.split("\\.");
      Project _project_8 = projectThree.getProject();
      String _root_2 = _project_8.getRoot();
      String[] _split_2 = _root_2.split("\\.");
      int _length = _split_2.length;
      int _minus = (_length - 1);
      List<String> _subList = ((List<String>)Conversions.doWrapArray(_split_1)).subList(0, _minus);
      final String commonPackageName = IterableExtensions.join(_subList, 
        ".");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      _builder.append(packageName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      {
        final Function1<Api2019.HttpReqResp, Boolean> _function = (Api2019.HttpReqResp it) -> {
          Record _record = it.respBody.getRecord();
          String _method = _record.getMethod();
          return Boolean.valueOf(_method.equalsIgnoreCase("GET"));
        };
        boolean _exists = IterableExtensions.<Api2019.HttpReqResp>exists(httpReqResps, _function);
        if (_exists) {
          _builder.append("import retrofit2.http.GET;");
        }
      }
      _builder.newLineIfNotEmpty();
      {
        final Function1<Api2019.HttpReqResp, Boolean> _function_1 = (Api2019.HttpReqResp it) -> {
          Record _record = it.respBody.getRecord();
          String _method = _record.getMethod();
          return Boolean.valueOf(_method.equalsIgnoreCase("POST"));
        };
        boolean _exists_1 = IterableExtensions.<Api2019.HttpReqResp>exists(httpReqResps, _function_1);
        if (_exists_1) {
          _builder.append("import retrofit2.http.POST;");
        }
      }
      _builder.newLineIfNotEmpty();
      {
        final Function1<Api2019.HttpReqResp, Boolean> _function_2 = (Api2019.HttpReqResp it) -> {
          Record _record = it.respBody.getRecord();
          String _method = _record.getMethod();
          return Boolean.valueOf(_method.equalsIgnoreCase("DELETE"));
        };
        boolean _exists_2 = IterableExtensions.<Api2019.HttpReqResp>exists(httpReqResps, _function_2);
        if (_exists_2) {
          _builder.append("import retrofit2.http.DELETE;");
        }
      }
      _builder.newLineIfNotEmpty();
      _builder.append("import retrofit2.http.Query;");
      _builder.newLine();
      _builder.append("import retrofit2.http.QueryMap;");
      _builder.newLine();
      _builder.append("import retrofit2.http.Body;");
      _builder.newLine();
      _builder.append("import retrofit2.Call;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import java.util.Map;");
      _builder.newLine();
      _builder.append("import java.util.Date;");
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("import ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      _builder.append(packageName, "");
      _builder.append(".vo.*;");
      _builder.newLineIfNotEmpty();
      _builder.append("import ");
      _builder.append(commonPackageName, "");
      _builder.append(".common.vo.*;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.newLine();
      _builder.append("public interface ");
      _builder.append(retrofit2Name, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        for(final Api2019.HttpReqResp http : httpReqResps) {
          _builder.append("/** ");
          Record _record = http.respBody.getRecord();
          String _label = _record.getLabel();
          _builder.append(_label, "");
          _builder.append(" */");
          _builder.newLineIfNotEmpty();
          _builder.append("@");
          Record _record_1 = http.respBody.getRecord();
          String _method = _record_1.getMethod();
          String _upperCase = _method.toUpperCase();
          _builder.append(_upperCase, "");
          _builder.append("(\"/yjfirewall/api/v1/");
          Record _record_2 = http.respBody.getRecord();
          String _url = _record_2.getUrl();
          _builder.append(_url, "");
          _builder.append("\")");
          _builder.newLineIfNotEmpty();
          _builder.append("Call<");
          {
            List<Field> _fields = http.respBody.getFields();
            int _size = _fields.size();
            boolean _greaterThan = (_size > 0);
            if (_greaterThan) {
              _builder.append("DataResponse<");
              Record _record_3 = http.respBody.getRecord();
              String _name_4 = _record_3.getName();
              String _firstUpper_3 = StringExtensions.toFirstUpper(_name_4);
              _builder.append(_firstUpper_3, "");
              _builder.append(">");
              _builder.newLineIfNotEmpty();
            } else {
              List<Field> _fields_1 = http.respBodyEntity.getFields();
              int _size_1 = _fields_1.size();
              boolean _greaterThan_1 = (_size_1 > 0);
              if (_greaterThan_1) {
                _builder.append("DataResponse<");
                List<Field> _fields_2 = http.respBodyEntity.getFields();
                Field _get = _fields_2.get(0);
                String _type = _get.getType();
                String _firstUpper_4 = StringExtensions.toFirstUpper(_type);
                _builder.append(_firstUpper_4, "");
                _builder.append(">");
                _builder.newLineIfNotEmpty();
              } else {
                _builder.append("Response");
              }
            }
          }
          _builder.append("> ");
          Record _record_4 = http.respBody.getRecord();
          String _name_5 = _record_4.getName();
          String _replace = _name_5.replace("RespBody", "");
          String _firstLower = StringExtensions.toFirstLower(_replace);
          _builder.append(_firstLower, "");
          _builder.append("(");
          _builder.newLineIfNotEmpty();
          {
            List<Field> _fields_3 = http.params.getFields();
            boolean _hasElements = false;
            for(final Field f : _fields_3) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(",", "");
              }
              _builder.append("@Query(\"");
              String _javaName = f.javaName();
              _builder.append(_javaName, "");
              _builder.append("\")");
              String _javaType = f.javaType();
              String _firstUpper_5 = StringExtensions.toFirstUpper(_javaType);
              _builder.append(_firstUpper_5, "");
              _builder.append(" ");
              String _javaName_1 = f.javaName();
              _builder.append(_javaName_1, "");
              _builder.newLineIfNotEmpty();
            }
          }
          {
            if (((http.reqBody.getFields().size() > 0) && (http.params.getFields().size() > 0))) {
              _builder.append(",");
            }
          }
          _builder.newLineIfNotEmpty();
          {
            List<Field> _fields_4 = http.reqBody.getFields();
            int _size_2 = _fields_4.size();
            boolean _greaterThan_2 = (_size_2 > 0);
            if (_greaterThan_2) {
              _builder.append("@Body ");
              Record _record_5 = http.reqBody.getRecord();
              String _name_6 = _record_5.getName();
              String _firstUpper_6 = StringExtensions.toFirstUpper(_name_6);
              _builder.append(_firstUpper_6, "");
              _builder.append(" ");
              Record _record_6 = http.reqBody.getRecord();
              String _name_7 = _record_6.getName();
              String _firstLower_1 = StringExtensions.toFirstLower(_name_7);
              _builder.append(_firstLower_1, "");
            }
          }
          _builder.newLineIfNotEmpty();
          {
            if (((http.reqBodyEntity.getFields().size() > 0) && (http.params.getFields().size() > 0))) {
              _builder.append(",");
            }
          }
          _builder.newLineIfNotEmpty();
          {
            List<Field> _fields_5 = http.reqBodyEntity.getFields();
            int _size_3 = _fields_5.size();
            boolean _greaterThan_3 = (_size_3 > 0);
            if (_greaterThan_3) {
              _builder.append("@Body ");
              List<Field> _fields_6 = http.reqBodyEntity.getFields();
              Field _get_1 = _fields_6.get(0);
              String _type_1 = _get_1.getType();
              String _firstUpper_7 = StringExtensions.toFirstUpper(_type_1);
              _builder.append(_firstUpper_7, "");
              _builder.append(" ");
              List<Field> _fields_7 = http.reqBodyEntity.getFields();
              Field _get_2 = _fields_7.get(0);
              String _name_8 = _get_2.getName();
              String _firstLower_2 = StringExtensions.toFirstLower(_name_8);
              _builder.append(_firstLower_2, "");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append(");");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence feign(final Three projectThree, final List<Api2019.HttpReqResp> httpReqResps) {
    CharSequence _xblockexpression = null;
    {
      Project _project = projectThree.getProject();
      String _name = _project.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name);
      final String controllerName = (_firstUpper + "Controller");
      Project _project_1 = projectThree.getProject();
      String _name_1 = _project_1.getName();
      String _firstUpper_1 = StringExtensions.toFirstUpper(_name_1);
      final String feignName = (_firstUpper_1 + "FeignClient");
      Project _project_2 = projectThree.getProject();
      String _name_2 = _project_2.getName();
      String _firstUpper_2 = StringExtensions.toFirstUpper(_name_2);
      final String retrofit2Name = (_firstUpper_2 + "Retrofit2Client");
      Project _project_3 = projectThree.getProject();
      final String basePath = _project_3.getPath();
      Project _project_4 = projectThree.getProject();
      String _root = _project_4.getRoot();
      String[] _split = _root.split("\\.");
      final String javaPath = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_split)), "\\");
      Project _project_5 = projectThree.getProject();
      String _name_3 = _project_5.getName();
      String packageName = StringExtensions.toFirstLower(_name_3);
      Project _project_6 = projectThree.getProject();
      final String basePackageName = _project_6.getRoot();
      Project _project_7 = projectThree.getProject();
      String _root_1 = _project_7.getRoot();
      String[] _split_1 = _root_1.split("\\.");
      Project _project_8 = projectThree.getProject();
      String _root_2 = _project_8.getRoot();
      String[] _split_2 = _root_2.split("\\.");
      int _length = _split_2.length;
      int _minus = (_length - 1);
      List<String> _subList = ((List<String>)Conversions.doWrapArray(_split_1)).subList(0, _minus);
      final String commonPackageName = IterableExtensions.join(_subList, ".");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      _builder.append(packageName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import java.util.Date;");
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.append("import java.util.Map;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.springframework.cloud.openfeign.FeignClient;");
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
      _builder.newLine();
      _builder.newLine();
      _builder.append("import ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      _builder.append(packageName, "");
      _builder.append(".vo.*;");
      _builder.newLineIfNotEmpty();
      _builder.append("import ");
      _builder.append(commonPackageName, "");
      _builder.append(".common.vo.*;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("@FeignClient(url = \"${feign.restcli.request.url}/\", name = \"");
      String _firstLower = StringExtensions.toFirstLower(feignName);
      _builder.append(_firstLower, "");
      _builder.append("\")");
      _builder.newLineIfNotEmpty();
      _builder.append("public interface ");
      _builder.append(feignName, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        for(final Api2019.HttpReqResp http : httpReqResps) {
          _builder.append("\t");
          _builder.append("/** ");
          Record _record = http.respBody.getRecord();
          String _label = _record.getLabel();
          _builder.append(_label, "\t");
          _builder.append(" */");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("@RequestMapping(value=\"");
          Record _record_1 = http.respBody.getRecord();
          String _url = _record_1.getUrl();
          _builder.append(_url, "\t");
          _builder.append("\",method=RequestMethod.");
          Record _record_2 = http.respBody.getRecord();
          String _method = _record_2.getMethod();
          String _upperCase = _method.toUpperCase();
          _builder.append(_upperCase, "\t");
          _builder.append(")");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            List<Field> _fields = http.respBody.getFields();
            int _size = _fields.size();
            boolean _greaterThan = (_size > 0);
            if (_greaterThan) {
              _builder.append("DataResponse<");
              Record _record_3 = http.respBody.getRecord();
              String _name_4 = _record_3.getName();
              String _firstUpper_3 = StringExtensions.toFirstUpper(_name_4);
              _builder.append(_firstUpper_3, "\t");
              _builder.append(">");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
            } else {
              List<Field> _fields_1 = http.respBodyEntity.getFields();
              int _size_1 = _fields_1.size();
              boolean _greaterThan_1 = (_size_1 > 0);
              if (_greaterThan_1) {
                _builder.append("DataResponse<");
                List<Field> _fields_2 = http.respBodyEntity.getFields();
                Field _get = _fields_2.get(0);
                String _type = _get.getType();
                String _firstUpper_4 = StringExtensions.toFirstUpper(_type);
                _builder.append(_firstUpper_4, "\t");
                _builder.append(">");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
              } else {
                _builder.append("Response");
              }
            }
          }
          _builder.append(" ");
          Record _record_4 = http.respBody.getRecord();
          String _name_5 = _record_4.getName();
          String _replace = _name_5.replace("RespBody", "");
          String _firstLower_1 = StringExtensions.toFirstLower(_replace);
          _builder.append(_firstLower_1, "\t");
          _builder.append("(");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            List<Field> _fields_3 = http.params.getFields();
            boolean _hasElements = false;
            for(final Field f : _fields_3) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(",", "\t");
              }
              _builder.append("@RequestParam(\"");
              String _javaName = f.javaName();
              _builder.append(_javaName, "\t");
              _builder.append("\")");
              String _javaType = f.javaType();
              String _firstUpper_5 = StringExtensions.toFirstUpper(_javaType);
              _builder.append(_firstUpper_5, "\t");
              _builder.append(" ");
              String _javaName_1 = f.javaName();
              _builder.append(_javaName_1, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          {
            if (((http.reqBody.getFields().size() > 0) && (http.params.getFields().size() > 0))) {
              _builder.append(",");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            List<Field> _fields_4 = http.reqBody.getFields();
            int _size_2 = _fields_4.size();
            boolean _greaterThan_2 = (_size_2 > 0);
            if (_greaterThan_2) {
              _builder.append("@RequestBody ");
              Record _record_5 = http.reqBody.getRecord();
              String _name_6 = _record_5.getName();
              String _firstUpper_6 = StringExtensions.toFirstUpper(_name_6);
              _builder.append(_firstUpper_6, "\t");
              _builder.append(" ");
              Record _record_6 = http.reqBody.getRecord();
              String _name_7 = _record_6.getName();
              String _firstLower_2 = StringExtensions.toFirstLower(_name_7);
              _builder.append(_firstLower_2, "\t");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            if (((http.reqBodyEntity.getFields().size() > 0) && (http.params.getFields().size() > 0))) {
              _builder.append(",");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            List<Field> _fields_5 = http.reqBodyEntity.getFields();
            int _size_3 = _fields_5.size();
            boolean _greaterThan_3 = (_size_3 > 0);
            if (_greaterThan_3) {
              _builder.append("@RequestBody ");
              List<Field> _fields_6 = http.reqBodyEntity.getFields();
              Field _get_1 = _fields_6.get(0);
              String _type_1 = _get_1.getType();
              String _firstUpper_7 = StringExtensions.toFirstUpper(_type_1);
              _builder.append(_firstUpper_7, "\t");
              _builder.append(" ");
              List<Field> _fields_7 = http.reqBodyEntity.getFields();
              Field _get_2 = _fields_7.get(0);
              String _name_8 = _get_2.getName();
              String _firstLower_3 = StringExtensions.toFirstLower(_name_8);
              _builder.append(_firstLower_3, "\t");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append(");");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence client(final Three projectThree, final List<Api2019.HttpReqResp> httpReqResps) {
    CharSequence _xblockexpression = null;
    {
      Project _project = projectThree.getProject();
      String _name = _project.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name);
      final String controllerName = (_firstUpper + "Controller");
      Project _project_1 = projectThree.getProject();
      String _name_1 = _project_1.getName();
      String _firstUpper_1 = StringExtensions.toFirstUpper(_name_1);
      final String clientName = (_firstUpper_1 + "Client");
      Project _project_2 = projectThree.getProject();
      String _name_2 = _project_2.getName();
      String _firstUpper_2 = StringExtensions.toFirstUpper(_name_2);
      final String retrofit2Name = (_firstUpper_2 + "Retrofit2Client");
      Project _project_3 = projectThree.getProject();
      final String basePath = _project_3.getPath();
      Project _project_4 = projectThree.getProject();
      String _root = _project_4.getRoot();
      String[] _split = _root.split("\\.");
      final String javaPath = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_split)), "\\");
      Project _project_5 = projectThree.getProject();
      String _name_3 = _project_5.getName();
      String packageName = StringExtensions.toFirstLower(_name_3);
      Project _project_6 = projectThree.getProject();
      final String basePackageName = _project_6.getRoot();
      Project _project_7 = projectThree.getProject();
      String _root_1 = _project_7.getRoot();
      String[] _split_1 = _root_1.split("\\.");
      Project _project_8 = projectThree.getProject();
      String _root_2 = _project_8.getRoot();
      String[] _split_2 = _root_2.split("\\.");
      int _length = _split_2.length;
      int _minus = (_length - 1);
      List<String> _subList = ((List<String>)Conversions.doWrapArray(_split_1)).subList(0, _minus);
      final String commonPackageName = IterableExtensions.join(_subList, ".");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      _builder.append(packageName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import java.util.Date;");
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.append("import java.util.Map;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("import ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      _builder.append(packageName, "");
      _builder.append(".vo.*;");
      _builder.newLineIfNotEmpty();
      _builder.append("import ");
      _builder.append(commonPackageName, "");
      _builder.append(".common.vo.*;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("public interface ");
      _builder.append(clientName, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        for(final Api2019.HttpReqResp http : httpReqResps) {
          _builder.append("\t");
          _builder.append("/** ");
          Record _record = http.respBody.getRecord();
          String _label = _record.getLabel();
          _builder.append(_label, "\t");
          _builder.append(" */");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            List<Field> _fields = http.respBody.getFields();
            int _size = _fields.size();
            boolean _greaterThan = (_size > 0);
            if (_greaterThan) {
              _builder.append("DataResponse<");
              Record _record_1 = http.respBody.getRecord();
              String _name_4 = _record_1.getName();
              String _firstUpper_3 = StringExtensions.toFirstUpper(_name_4);
              _builder.append(_firstUpper_3, "\t");
              _builder.append(">");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
            } else {
              List<Field> _fields_1 = http.respBodyEntity.getFields();
              int _size_1 = _fields_1.size();
              boolean _greaterThan_1 = (_size_1 > 0);
              if (_greaterThan_1) {
                _builder.append("DataResponse<");
                List<Field> _fields_2 = http.respBodyEntity.getFields();
                Field _get = _fields_2.get(0);
                String _type = _get.getType();
                String _firstUpper_4 = StringExtensions.toFirstUpper(_type);
                _builder.append(_firstUpper_4, "\t");
                _builder.append(">");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
              } else {
                _builder.append("Response");
              }
            }
          }
          _builder.append(" ");
          Record _record_2 = http.respBody.getRecord();
          String _name_5 = _record_2.getName();
          String _replace = _name_5.replace("RespBody", "");
          String _firstLower = StringExtensions.toFirstLower(_replace);
          _builder.append(_firstLower, "\t");
          _builder.append("(");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            List<Field> _fields_3 = http.params.getFields();
            boolean _hasElements = false;
            for(final Field f : _fields_3) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(",", "\t");
              }
              String _javaType = f.javaType();
              String _firstUpper_5 = StringExtensions.toFirstUpper(_javaType);
              _builder.append(_firstUpper_5, "\t");
              _builder.append(" ");
              String _javaName = f.javaName();
              _builder.append(_javaName, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          {
            if (((http.reqBody.getFields().size() > 0) && (http.params.getFields().size() > 0))) {
              _builder.append(",");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            List<Field> _fields_4 = http.reqBody.getFields();
            int _size_2 = _fields_4.size();
            boolean _greaterThan_2 = (_size_2 > 0);
            if (_greaterThan_2) {
              Record _record_3 = http.reqBody.getRecord();
              String _name_6 = _record_3.getName();
              String _firstUpper_6 = StringExtensions.toFirstUpper(_name_6);
              _builder.append(_firstUpper_6, "\t");
              _builder.append(" ");
              Record _record_4 = http.reqBody.getRecord();
              String _name_7 = _record_4.getName();
              String _firstLower_1 = StringExtensions.toFirstLower(_name_7);
              _builder.append(_firstLower_1, "\t");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            if (((http.reqBodyEntity.getFields().size() > 0) && (http.params.getFields().size() > 0))) {
              _builder.append(",");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            List<Field> _fields_5 = http.reqBodyEntity.getFields();
            int _size_3 = _fields_5.size();
            boolean _greaterThan_3 = (_size_3 > 0);
            if (_greaterThan_3) {
              List<Field> _fields_6 = http.reqBodyEntity.getFields();
              Field _get_1 = _fields_6.get(0);
              String _type_1 = _get_1.getType();
              String _firstUpper_7 = StringExtensions.toFirstUpper(_type_1);
              _builder.append(_firstUpper_7, "\t");
              _builder.append(" ");
              List<Field> _fields_7 = http.reqBodyEntity.getFields();
              Field _get_2 = _fields_7.get(0);
              String _name_8 = _get_2.getName();
              String _firstLower_2 = StringExtensions.toFirstLower(_name_8);
              _builder.append(_firstLower_2, "\t");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append(");");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence controller(final Three projectThree, final List<Api2019.HttpReqResp> httpReqResps) {
    CharSequence _xblockexpression = null;
    {
      Project _project = projectThree.getProject();
      String _name = _project.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name);
      final String controllerName = (_firstUpper + "Controller");
      Project _project_1 = projectThree.getProject();
      String _name_1 = _project_1.getName();
      String _firstUpper_1 = StringExtensions.toFirstUpper(_name_1);
      final String serviceName = (_firstUpper_1 + "Service");
      Project _project_2 = projectThree.getProject();
      String _name_2 = _project_2.getName();
      String _firstUpper_2 = StringExtensions.toFirstUpper(_name_2);
      final String feignName = (_firstUpper_2 + "FeignClient");
      Project _project_3 = projectThree.getProject();
      String _name_3 = _project_3.getName();
      String _firstUpper_3 = StringExtensions.toFirstUpper(_name_3);
      final String retrofit2Name = (_firstUpper_3 + "Retrofit2Client");
      Project _project_4 = projectThree.getProject();
      final String basePath = _project_4.getPath();
      Project _project_5 = projectThree.getProject();
      String _root = _project_5.getRoot();
      String[] _split = _root.split("\\.");
      final String javaPath = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_split)), "\\");
      Project _project_6 = projectThree.getProject();
      String _name_4 = _project_6.getName();
      String packageName = StringExtensions.toFirstLower(_name_4);
      Project _project_7 = projectThree.getProject();
      final String basePackageName = _project_7.getRoot();
      Project _project_8 = projectThree.getProject();
      String _root_1 = _project_8.getRoot();
      String[] _split_1 = _root_1.split("\\.");
      Project _project_9 = projectThree.getProject();
      String _root_2 = _project_9.getRoot();
      String[] _split_2 = _root_2.split("\\.");
      int _length = _split_2.length;
      int _minus = (_length - 1);
      List<String> _subList = ((List<String>)Conversions.doWrapArray(_split_1)).subList(0, _minus);
      final String commonPackageName = IterableExtensions.join(_subList, ".");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      _builder.append(packageName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import java.util.Date;");
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.append("import java.util.Map;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import org.springframework.beans.factory.annotation.Autowired;");
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
      _builder.newLine();
      _builder.append("import ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      _builder.append(packageName, "");
      _builder.append(".vo.*;");
      _builder.newLineIfNotEmpty();
      _builder.append("import ");
      _builder.append(commonPackageName, "");
      _builder.append(".common.vo.*;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("@RestController");
      _builder.newLine();
      _builder.append("public class ");
      _builder.append(controllerName, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Autowired");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(serviceName, "\t");
      _builder.append(" ");
      String _firstLower = StringExtensions.toFirstLower(serviceName);
      _builder.append(_firstLower, "\t");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      {
        for(final Api2019.HttpReqResp http : httpReqResps) {
          _builder.append("\t");
          _builder.append("/** ");
          Record _record = http.respBody.getRecord();
          String _label = _record.getLabel();
          _builder.append(_label, "\t");
          _builder.append(" */");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("@RequestMapping(value=\"");
          Record _record_1 = http.respBody.getRecord();
          String _url = _record_1.getUrl();
          _builder.append(_url, "\t");
          _builder.append("\",method=RequestMethod.");
          Record _record_2 = http.respBody.getRecord();
          String _method = _record_2.getMethod();
          String _upperCase = _method.toUpperCase();
          _builder.append(_upperCase, "\t");
          _builder.append(")");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("public ");
          {
            List<Field> _fields = http.respBody.getFields();
            int _size = _fields.size();
            boolean _greaterThan = (_size > 0);
            if (_greaterThan) {
              _builder.append("DataResponse<");
              Record _record_3 = http.respBody.getRecord();
              String _name_5 = _record_3.getName();
              String _firstUpper_4 = StringExtensions.toFirstUpper(_name_5);
              _builder.append(_firstUpper_4, "\t");
              _builder.append(">");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
            } else {
              List<Field> _fields_1 = http.respBodyEntity.getFields();
              int _size_1 = _fields_1.size();
              boolean _greaterThan_1 = (_size_1 > 0);
              if (_greaterThan_1) {
                _builder.append("DataResponse<");
                List<Field> _fields_2 = http.respBodyEntity.getFields();
                Field _get = _fields_2.get(0);
                String _type = _get.getType();
                String _firstUpper_5 = StringExtensions.toFirstUpper(_type);
                _builder.append(_firstUpper_5, "\t");
                _builder.append(">");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
              } else {
                _builder.append("Response");
              }
            }
          }
          _builder.append(" ");
          Record _record_4 = http.respBody.getRecord();
          String _name_6 = _record_4.getName();
          String _replace = _name_6.replace("RespBody", "");
          String _firstLower_1 = StringExtensions.toFirstLower(_replace);
          _builder.append(_firstLower_1, "\t");
          _builder.append("(");
          _builder.newLineIfNotEmpty();
          {
            List<Field> _fields_3 = http.params.getFields();
            boolean _hasElements = false;
            for(final Field f : _fields_3) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(",", "\t");
              }
              _builder.append("\t");
              _builder.append("@RequestParam(value=\"");
              String _javaName = f.javaName();
              _builder.append(_javaName, "\t");
              _builder.append("\"");
              {
                String _javaName_1 = f.javaName();
                boolean _equals = Objects.equal(_javaName_1, "pageNo");
                if (_equals) {
                  _builder.append(",required = false, defaultValue = \"1\"");
                }
              }
              {
                String _javaName_2 = f.javaName();
                boolean _equals_1 = Objects.equal(_javaName_2, "pageSize");
                if (_equals_1) {
                  _builder.append(",required = false, defaultValue = \"20\"");
                }
              }
              _builder.append(")");
              String _javaType = f.javaType();
              String _firstUpper_6 = StringExtensions.toFirstUpper(_javaType);
              _builder.append(_firstUpper_6, "\t");
              _builder.append(" ");
              String _javaName_3 = f.javaName();
              _builder.append(_javaName_3, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          {
            if (((http.reqBody.getFields().size() > 0) && (http.params.getFields().size() > 0))) {
              _builder.append(",");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            List<Field> _fields_4 = http.reqBody.getFields();
            int _size_2 = _fields_4.size();
            boolean _greaterThan_2 = (_size_2 > 0);
            if (_greaterThan_2) {
              _builder.append("@RequestBody ");
              Record _record_5 = http.reqBody.getRecord();
              String _name_7 = _record_5.getName();
              String _firstUpper_7 = StringExtensions.toFirstUpper(_name_7);
              _builder.append(_firstUpper_7, "\t");
              _builder.append(" ");
              Record _record_6 = http.reqBody.getRecord();
              String _name_8 = _record_6.getName();
              String _firstLower_2 = StringExtensions.toFirstLower(_name_8);
              _builder.append(_firstLower_2, "\t");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            if (((http.reqBodyEntity.getFields().size() > 0) && (http.params.getFields().size() > 0))) {
              _builder.append(",");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            List<Field> _fields_5 = http.reqBodyEntity.getFields();
            int _size_3 = _fields_5.size();
            boolean _greaterThan_3 = (_size_3 > 0);
            if (_greaterThan_3) {
              _builder.append("@RequestBody ");
              List<Field> _fields_6 = http.reqBodyEntity.getFields();
              Field _get_1 = _fields_6.get(0);
              String _type_1 = _get_1.getType();
              String _firstUpper_8 = StringExtensions.toFirstUpper(_type_1);
              _builder.append(_firstUpper_8, "\t");
              _builder.append(" ");
              List<Field> _fields_7 = http.reqBodyEntity.getFields();
              Field _get_2 = _fields_7.get(0);
              String _name_9 = _get_2.getName();
              String _firstLower_3 = StringExtensions.toFirstLower(_name_9);
              _builder.append(_firstLower_3, "\t");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("){");
          _builder.newLine();
          {
            List<Field> _fields_8 = http.params.getFields();
            final Function1<Field, Boolean> _function = (Field f_1) -> {
              String _javaName_4 = f_1.javaName();
              return Boolean.valueOf(Objects.equal(_javaName_4, "pageNo"));
            };
            boolean _exists = IterableExtensions.<Field>exists(_fields_8, _function);
            if (_exists) {
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("if (queryMap.containsKey(\"pageNo\") && queryMap.containsKey(\"pageSize\")) {");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("pageNo = Integer.parseInt(queryMap.get(\"pageNo\"));");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("pageSize = Integer.parseInt(queryMap.get(\"pageSize\"));");
              _builder.newLine();
              _builder.append("\t");
              _builder.append("\t");
              _builder.append("}");
              _builder.newLine();
            }
          }
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("return ");
          String _firstLower_4 = StringExtensions.toFirstLower(serviceName);
          _builder.append(_firstLower_4, "\t\t");
          _builder.append(".");
          Record _record_7 = http.respBody.getRecord();
          String _name_10 = _record_7.getName();
          String _replace_1 = _name_10.replace("RespBody", "");
          String _firstLower_5 = StringExtensions.toFirstLower(_replace_1);
          _builder.append(_firstLower_5, "\t\t");
          _builder.append("(");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            List<Field> _fields_9 = http.params.getFields();
            boolean _hasElements_1 = false;
            for(final Field f_1 : _fields_9) {
              if (!_hasElements_1) {
                _hasElements_1 = true;
              } else {
                _builder.appendImmediate(",", "\t");
              }
              String _javaName_4 = f_1.javaName();
              _builder.append(_javaName_4, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          {
            if (((http.reqBody.getFields().size() > 0) && (http.params.getFields().size() > 0))) {
              _builder.append(",");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            List<Field> _fields_10 = http.reqBody.getFields();
            int _size_4 = _fields_10.size();
            boolean _greaterThan_4 = (_size_4 > 0);
            if (_greaterThan_4) {
              Record _record_8 = http.reqBody.getRecord();
              String _name_11 = _record_8.getName();
              String _firstLower_6 = StringExtensions.toFirstLower(_name_11);
              _builder.append(_firstLower_6, "\t");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            if (((http.reqBodyEntity.getFields().size() > 0) && (http.params.getFields().size() > 0))) {
              _builder.append(",");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            List<Field> _fields_11 = http.reqBodyEntity.getFields();
            int _size_5 = _fields_11.size();
            boolean _greaterThan_5 = (_size_5 > 0);
            if (_greaterThan_5) {
              List<Field> _fields_12 = http.reqBodyEntity.getFields();
              Field _get_3 = _fields_12.get(0);
              String _name_12 = _get_3.getName();
              String _firstLower_7 = StringExtensions.toFirstLower(_name_12);
              _builder.append(_firstLower_7, "\t");
            }
          }
          _builder.append("\t\t\t\t\t");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append(");");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence service(final Three projectThree, final List<Api2019.HttpReqResp> httpReqResps) {
    CharSequence _xblockexpression = null;
    {
      Project _project = projectThree.getProject();
      String _name = _project.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name);
      final String serviceName = (_firstUpper + "Service");
      Project _project_1 = projectThree.getProject();
      String _name_1 = _project_1.getName();
      String _firstUpper_1 = StringExtensions.toFirstUpper(_name_1);
      final String feignName = (_firstUpper_1 + "FeignClient");
      Project _project_2 = projectThree.getProject();
      String _name_2 = _project_2.getName();
      String _firstUpper_2 = StringExtensions.toFirstUpper(_name_2);
      final String retrofit2Name = (_firstUpper_2 + "Retrofit2Client");
      Project _project_3 = projectThree.getProject();
      final String basePath = _project_3.getPath();
      Project _project_4 = projectThree.getProject();
      String _root = _project_4.getRoot();
      String[] _split = _root.split("\\.");
      final String javaPath = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_split)), "\\");
      Project _project_5 = projectThree.getProject();
      String _name_3 = _project_5.getName();
      String packageName = StringExtensions.toFirstLower(_name_3);
      Project _project_6 = projectThree.getProject();
      final String basePackageName = _project_6.getRoot();
      Project _project_7 = projectThree.getProject();
      String _root_1 = _project_7.getRoot();
      String[] _split_1 = _root_1.split("\\.");
      Project _project_8 = projectThree.getProject();
      String _root_2 = _project_8.getRoot();
      String[] _split_2 = _root_2.split("\\.");
      int _length = _split_2.length;
      int _minus = (_length - 1);
      List<String> _subList = ((List<String>)Conversions.doWrapArray(_split_1)).subList(0, _minus);
      final String commonPackageName = IterableExtensions.join(_subList, ".");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      _builder.append(packageName, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("import java.util.Date;");
      _builder.newLine();
      _builder.append("import java.util.List;");
      _builder.newLine();
      _builder.append("import java.util.Map;");
      _builder.newLine();
      _builder.newLine();
      _builder.newLine();
      _builder.append("import ");
      _builder.append(basePackageName, "");
      _builder.append(".");
      _builder.append(packageName, "");
      _builder.append(".vo.*;");
      _builder.newLineIfNotEmpty();
      _builder.append("import ");
      _builder.append(commonPackageName, "");
      _builder.append(".common.vo.*;");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("public interface ");
      _builder.append(serviceName, "");
      _builder.append(" {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      {
        for(final Api2019.HttpReqResp http : httpReqResps) {
          _builder.append("\t");
          _builder.append("/** ");
          Record _record = http.respBody.getRecord();
          String _label = _record.getLabel();
          _builder.append(_label, "\t");
          _builder.append(" */");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            List<Field> _fields = http.respBody.getFields();
            int _size = _fields.size();
            boolean _greaterThan = (_size > 0);
            if (_greaterThan) {
              _builder.append("DataResponse<");
              Record _record_1 = http.respBody.getRecord();
              String _name_4 = _record_1.getName();
              String _firstUpper_3 = StringExtensions.toFirstUpper(_name_4);
              _builder.append(_firstUpper_3, "\t");
              _builder.append(">");
              _builder.newLineIfNotEmpty();
              _builder.append("\t");
            } else {
              List<Field> _fields_1 = http.respBodyEntity.getFields();
              int _size_1 = _fields_1.size();
              boolean _greaterThan_1 = (_size_1 > 0);
              if (_greaterThan_1) {
                _builder.append("DataResponse<");
                List<Field> _fields_2 = http.respBodyEntity.getFields();
                Field _get = _fields_2.get(0);
                String _type = _get.getType();
                String _firstUpper_4 = StringExtensions.toFirstUpper(_type);
                _builder.append(_firstUpper_4, "\t");
                _builder.append(">");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
              } else {
                _builder.append("Response");
              }
            }
          }
          _builder.append(" ");
          Record _record_2 = http.respBody.getRecord();
          String _name_5 = _record_2.getName();
          String _replace = _name_5.replace("RespBody", "");
          String _firstLower = StringExtensions.toFirstLower(_replace);
          _builder.append(_firstLower, "\t");
          _builder.append("(");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            List<Field> _fields_3 = http.params.getFields();
            boolean _hasElements = false;
            for(final Field f : _fields_3) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder.appendImmediate(",", "\t");
              }
              String _javaType = f.javaType();
              String _firstUpper_5 = StringExtensions.toFirstUpper(_javaType);
              _builder.append(_firstUpper_5, "\t");
              _builder.append(" ");
              String _javaName = f.javaName();
              _builder.append(_javaName, "\t");
              _builder.newLineIfNotEmpty();
            }
          }
          _builder.append("\t");
          {
            if (((http.reqBody.getFields().size() > 0) && (http.params.getFields().size() > 0))) {
              _builder.append(",");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            List<Field> _fields_4 = http.reqBody.getFields();
            int _size_2 = _fields_4.size();
            boolean _greaterThan_2 = (_size_2 > 0);
            if (_greaterThan_2) {
              Record _record_3 = http.reqBody.getRecord();
              String _name_6 = _record_3.getName();
              String _firstUpper_6 = StringExtensions.toFirstUpper(_name_6);
              _builder.append(_firstUpper_6, "\t");
              _builder.append(" ");
              Record _record_4 = http.reqBody.getRecord();
              String _name_7 = _record_4.getName();
              String _firstLower_1 = StringExtensions.toFirstLower(_name_7);
              _builder.append(_firstLower_1, "\t");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            if (((http.reqBodyEntity.getFields().size() > 0) && (http.params.getFields().size() > 0))) {
              _builder.append(",");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          {
            List<Field> _fields_5 = http.reqBodyEntity.getFields();
            int _size_3 = _fields_5.size();
            boolean _greaterThan_3 = (_size_3 > 0);
            if (_greaterThan_3) {
              List<Field> _fields_6 = http.reqBodyEntity.getFields();
              Field _get_1 = _fields_6.get(0);
              String _type_1 = _get_1.getType();
              String _firstUpper_7 = StringExtensions.toFirstUpper(_type_1);
              _builder.append(_firstUpper_7, "\t");
              _builder.append(" ");
              List<Field> _fields_7 = http.reqBodyEntity.getFields();
              Field _get_2 = _fields_7.get(0);
              String _name_8 = _get_2.getName();
              String _firstLower_2 = StringExtensions.toFirstLower(_name_8);
              _builder.append(_firstLower_2, "\t");
            }
          }
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append(");");
          _builder.newLine();
        }
      }
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence dio(final Three projectThree, final List<Api2019.HttpReqResp> httpReqResps) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import \'package:dio/dio.dart\';");
    _builder.newLine();
    _builder.append("import \'package:helloflutter/dios.dart\';");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    {
      for(final Api2019.HttpReqResp http : httpReqResps) {
        _builder.append("/** ");
        Record _record = http.respBody.getRecord();
        String _label = _record.getLabel();
        _builder.append(_label, "");
        _builder.append(" */\t\t\t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("Future<Response> ");
        Record _record_1 = http.respBody.getRecord();
        String _name = _record_1.getName();
        String _replace = _name.replace("RespBody", "");
        String _firstLower = StringExtensions.toFirstLower(_replace);
        _builder.append(_firstLower, "");
        _builder.append("() async {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("print(\'");
        Record _record_2 = http.respBody.getRecord();
        String _name_1 = _record_2.getName();
        String _replace_1 = _name_1.replace("RespBody", "");
        String _firstLower_1 = StringExtensions.toFirstLower(_replace_1);
        _builder.append(_firstLower_1, "\t");
        _builder.append("\');");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("Dio dio = Dios.getInstance();");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("Response response = await dio.");
        Record _record_3 = http.respBody.getRecord();
        String _method = _record_3.getMethod();
        String _lowerCase = _method.toLowerCase();
        _builder.append(_lowerCase, "\t");
        _builder.append("<Map>(");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\"https://www.easy-mock.com/mock/5cfb5e002226854b9e1c1236/yjapp");
        Record _record_4 = http.respBody.getRecord();
        String _url = _record_4.getUrl();
        _builder.append(_url, "\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("print(response.data)");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("return response;");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public static CharSequence mockResp(final Three projectThree, final List<Api2019.HttpReqResp> httpReqResps) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Api2019.HttpReqResp http : httpReqResps) {
        _builder.append("/** ");
        Record _record = http.respBody.getRecord();
        String _label = _record.getLabel();
        _builder.append(_label, "");
        _builder.append(" */\t\t\t\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("var ");
        Record _record_1 = http.respBody.getRecord();
        String _name = _record_1.getName();
        String _replace = _name.replace("RespBody", "");
        String _firstLower = StringExtensions.toFirstLower(_replace);
        _builder.append(_firstLower, "");
        _builder.append(" = {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\"code\":200,");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\"msg\":\"ok\",");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\"result\": { // ");
        List<Field> _fields = http.respBodyEntity.getFields();
        int _size = _fields.size();
        _builder.append(_size, "\t");
        _builder.append(" ");
        List<Field> _fields_1 = http.respBody.getFields();
        int _size_1 = _fields_1.size();
        _builder.append(_size_1, "\t");
        _builder.newLineIfNotEmpty();
        {
          List<Field> _fields_2 = http.respBody.getFields();
          boolean _hasElements = false;
          for(final Field f : _fields_2) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder.appendImmediate(",\n", "\t");
            }
            _builder.append("\t");
            _builder.append("\"");
            String _name_1 = f.getName();
            _builder.append(_name_1, "\t");
            _builder.append("\":\"@string\"");
            _builder.newLineIfNotEmpty();
          }
        }
        {
          List<Field> _fields_3 = http.respBodyEntity.getFields();
          boolean _hasElements_1 = false;
          for(final Field f_1 : _fields_3) {
            if (!_hasElements_1) {
              _hasElements_1 = true;
            } else {
              _builder.appendImmediate(",\n", "\t");
            }
            _builder.append("\t");
            _builder.append("\"");
            String _name_2 = f_1.getName();
            _builder.append(_name_2, "\t");
            _builder.append("\":\"@string\"");
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public static Three table2data(final Three projectThree, final Table table) {
    Three _xblockexpression = null;
    {
      Project project = projectThree.getProject();
      TableRow recordRow = table.getRow(0);
      Record record = new Record();
      TableCell _cell = recordRow.getCell(1);
      String _text = _cell.text();
      String _trim = _text.trim();
      record.setName(_trim);
      TableCell _cell_1 = recordRow.getCell(2);
      String _text_1 = _cell_1.text();
      String _trim_1 = _text_1.trim();
      record.setLabel(_trim_1);
      TableCell _cell_2 = recordRow.getCell(3);
      String _text_2 = _cell_2.text();
      String _trim_2 = _text_2.trim();
      record.setDoc(_trim_2);
      List<Field> fields = CollectionLiterals.<Field>newArrayList();
      for (int j = 2; (j < table.numRows()); j++) {
        {
          TableRow row = table.getRow(j);
          TableCell _cell_3 = row.getCell(1);
          String _text_3 = _cell_3.text();
          String _trim_3 = _text_3.trim();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_trim_3);
          boolean _not = (!_isNullOrEmpty);
          if (_not) {
            Field field = new Field();
            TableCell _cell_4 = row.getCell(0);
            String _text_4 = _cell_4.text();
            String _trim_4 = _text_4.trim();
            field.setName(_trim_4);
            String _name = field.getName();
            String _replace = _name.replace(" ", "_");
            String[] _split = _replace.split("_");
            final Function1<String, String> _function = (String item) -> {
              return StringExtensions.toFirstUpper(item);
            };
            List<String> _map = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(_split)), _function);
            String _join = IterableExtensions.join(_map);
            String _firstLower = StringExtensions.toFirstLower(_join);
            field.setName(_firstLower);
            TableCell _cell_5 = row.getCell(1);
            String _text_5 = _cell_5.text();
            String _trim_5 = _text_5.trim();
            field.setType(_trim_5);
            TableCell _cell_6 = row.getCell(2);
            String _text_6 = _cell_6.text();
            String _trim_6 = _text_6.trim();
            field.setLabel(_trim_6);
            TableCell _cell_7 = row.getCell(3);
            String _text_7 = _cell_7.text();
            String _trim_7 = _text_7.trim();
            field.setDoc(_trim_7);
            fields.add(field);
          }
        }
      }
      _xblockexpression = new Three(project, record, fields);
    }
    return _xblockexpression;
  }
  
  public static Three table2project(final Table projectTable) {
    Three _xblockexpression = null;
    {
      final TableRow projectRow = projectTable.getRow(3);
      Project project = new Project();
      TableCell _cell = projectRow.getCell(0);
      String _text = _cell.text();
      String _trim = _text.trim();
      project.setVersion(_trim);
      TableCell _cell_1 = projectRow.getCell(1);
      String _text_1 = _cell_1.text();
      String _trim_1 = _text_1.trim();
      project.setName(_trim_1);
      TableCell _cell_2 = projectRow.getCell(2);
      String _text_2 = _cell_2.text();
      String _trim_2 = _text_2.trim();
      project.setLabel(_trim_2);
      TableCell _cell_3 = projectRow.getCell(3);
      String _text_3 = _cell_3.text();
      String _trim_3 = _text_3.trim();
      project.setPath(_trim_3);
      TableCell _cell_4 = projectRow.getCell(4);
      String _text_4 = _cell_4.text();
      String _trim_4 = _text_4.trim();
      project.setRoot(_trim_4);
      TableCell _cell_5 = projectRow.getCell(5);
      String _text_5 = _cell_5.text();
      String _trim_5 = _text_5.trim();
      project.setPort(_trim_5);
      final TableRow webRow = projectTable.getRow(4);
      TableCell _cell_6 = webRow.getCell(3);
      String _text_6 = _cell_6.text();
      String _trim_6 = _text_6.trim();
      project.setWebPath(_trim_6);
      TableCell _cell_7 = webRow.getCell(4);
      String _text_7 = _cell_7.text();
      String _trim_7 = _text_7.trim();
      project.setWebRoot(_trim_7);
      final TableRow androidRow = projectTable.getRow(5);
      TableCell _cell_8 = webRow.getCell(3);
      String _text_8 = _cell_8.text();
      String _trim_8 = _text_8.trim();
      project.setAndroidPath(_trim_8);
      TableCell _cell_9 = webRow.getCell(4);
      String _text_9 = _cell_9.text();
      String _trim_9 = _text_9.trim();
      project.setAndroidRoot(_trim_9);
      InputOutput.<Project>println(project);
      _xblockexpression = new Three(project, null, null);
    }
    return _xblockexpression;
  }
}
