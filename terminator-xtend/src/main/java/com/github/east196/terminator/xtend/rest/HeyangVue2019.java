package com.github.east196.terminator.xtend.rest;

import com.github.east196.terminator.xtend.meta.DocMetaParser;
import com.github.east196.terminator.xtend.model.Field;
import com.github.east196.terminator.xtend.model.GeneResult;
import com.github.east196.terminator.xtend.model.Project;
import com.github.east196.terminator.xtend.model.Record;
import com.github.east196.terminator.xtend.model.Three;
import com.github.east196.terminator.xtend.rest.Valid;
import com.google.common.base.Objects;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Generated;
import org.boon.Boon;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class HeyangVue2019 {
  public static void main(final String[] args) {
    DocMetaParser _docMetaParser = new DocMetaParser();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("D:\\hyyy\\杂件\\统一数据文档 Test.doc");
    List<Three> _action = _docMetaParser.action(_builder.toString());
    final Function1<Three, Boolean> _function = (Three three) -> {
      Record _record = three.getRecord();
      String _geneOk = _record.getGeneOk();
      String _trim = _geneOk.trim();
      return Boolean.valueOf(Objects.equal(_trim, ""));
    };
    Iterable<Three> _filter = IterableExtensions.<Three>filter(_action, _function);
    final Consumer<Three> _function_1 = (Three three) -> {
      HeyangVue2019.geneAll(three);
    };
    _filter.forEach(_function_1);
  }
  
  public static Valid toValid(final String validStr) {
    return Valid.from(validStr);
  }
  
  public static String toJson(final Valid valid) {
    return Boon.toPrettyJson(valid);
  }
  
  public static void geneAll(final Three three) {
    GeneResult _gene = HeyangVue2019.gene(three, "list");
    _gene.copy();
    GeneResult _gene_1 = HeyangVue2019.gene(three, "search");
    _gene_1.copy();
  }
  
  public static GeneResult gene(final Three three, final String type) {
    Project project = three.getProject();
    Record record = three.getRecord();
    List<Field> fields = three.getFields();
    final String webPath = project.getWebPath();
    String _webRoot = project.getWebRoot();
    String[] _split = _webRoot.split("\\.");
    final String webPackage = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(_split)), "\\");
    StringConcatenation _builder = new StringConcatenation();
    CharSequence content = _builder;
    String path = "";
    switch (type) {
      case "list":
        CharSequence _recordlist = HeyangVue2019.recordlist(project, record, fields);
        content = _recordlist;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(webPath, "");
        _builder_1.append("\\");
        _builder_1.append(webPackage, "");
        _builder_1.append("\\");
        String _name = record.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name);
        _builder_1.append(_firstUpper, "");
        _builder_1.append("List.vue");
        path = _builder_1.toString();
        break;
      case "search":
        CharSequence _recordsearch = HeyangVue2019.recordsearch(project, record, fields);
        content = _recordsearch;
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append(webPath, "");
        _builder_2.append("\\");
        _builder_2.append(webPackage, "");
        _builder_2.append("\\");
        String _name_1 = record.getName();
        String _firstUpper_1 = StringExtensions.toFirstUpper(_name_1);
        _builder_2.append(_firstUpper_1, "");
        _builder_2.append("Search.vue");
        path = _builder_2.toString();
        break;
      default:
        break;
    }
    return new GeneResult(content, path);
  }
  
  public static CharSequence recordsearch(final Project project, final Record record, final List<Field> fields) {
    CharSequence _xblockexpression = null;
    {
      final Function1<Field, Boolean> _function = (Field it) -> {
        String _show = it.getShow();
        return Boolean.valueOf(_show.contains("S"));
      };
      Iterable<Field> _filter = IterableExtensions.<Field>filter(fields, _function);
      final List<Field> searchFields = IterableExtensions.<Field>toList(_filter);
      List<Field> sfas = searchFields;
      List<Field> sfbs = CollectionLiterals.<Field>newArrayList();
      int _size = searchFields.size();
      boolean _greaterThan = (_size > 2);
      if (_greaterThan) {
        List<Field> _subList = searchFields.subList(0, 2);
        sfas = _subList;
        int _size_1 = searchFields.size();
        List<Field> _subList_1 = searchFields.subList(2, _size_1);
        sfbs = _subList_1;
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<template>");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("<div class=\"table-page-search-wrapper\">");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("<a-form layout=\"inline\" @submit=\"handleSubmit\" :autoFormCreate=\"(form)=>{this.form = form}\">");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("<a-row :gutter=\"48\">");
      _builder.newLine();
      {
        for(final Field sf : sfas) {
          {
            if ((Objects.equal(sf.getKeyType(), "M21") || Objects.equal(sf.getKeyType(), "121"))) {
              _builder.append("<a-col :md=\"8\" :sm=\"24\">");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("<a-form-item");
              _builder.newLine();
              _builder.append("\t\t  ");
              _builder.append("label=\"");
              String _label = sf.getLabel();
              _builder.append(_label, "\t\t  ");
              _builder.append("\"");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t  ");
              _builder.append("fieldDecoratorId=\"");
              String _name = sf.getName();
              _builder.append(_name, "\t\t  ");
              _builder.append("_id_LIKE\"");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t  ");
              _builder.append(":fieldDecoratorOptions=\"{rules: [");
              _builder.newLine();
              _builder.append("\t\t  ");
              _builder.append("]}\"");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append(">");
              _builder.newLine();
              _builder.append("\t\t\t");
              _builder.append("<a-select placeholder=\"请选择\" :defaultActiveFirstOption=\"false\">");
              _builder.newLine();
              _builder.append("\t\t\t  ");
              _builder.append("<a-select-option v-for=\"d in ");
              String _name_1 = sf.getName();
              _builder.append(_name_1, "\t\t\t  ");
              _builder.append("s\" :key=\"d.id\">{{d.name}}</a-select-option>");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t");
              _builder.append("</a-select>");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("</a-form-item>");
              _builder.newLine();
              _builder.append("</a-col>");
              _builder.newLine();
            } else {
              String _type = sf.getType();
              boolean _equals = Objects.equal(_type, "date");
              if (_equals) {
              } else {
                String _type_1 = sf.getType();
                boolean _equals_1 = Objects.equal(_type_1, "datetime");
                if (_equals_1) {
                } else {
                  _builder.append("<a-col :md=\"8\" :sm=\"24\">");
                  _builder.newLine();
                  _builder.append("  ");
                  _builder.append("<a-form-item");
                  _builder.newLine();
                  _builder.append("    ");
                  _builder.append("label=\"");
                  String _label_1 = sf.getLabel();
                  _builder.append(_label_1, "    ");
                  _builder.append("\"");
                  _builder.newLineIfNotEmpty();
                  _builder.append("    ");
                  _builder.append("fieldDecoratorId=\"");
                  String _name_2 = sf.getName();
                  _builder.append(_name_2, "    ");
                  _builder.append("_LIKE\"");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t  ");
                  _builder.append(":fieldDecoratorOptions=\"{rules: [");
                  _builder.newLine();
                  _builder.append("\t\t  ");
                  _builder.append("]}\"");
                  _builder.newLine();
                  _builder.append("  ");
                  _builder.append(">");
                  _builder.newLine();
                  _builder.append("    ");
                  _builder.append("<a-input/>");
                  _builder.newLine();
                  _builder.append("  ");
                  _builder.append("</a-form-item>");
                  _builder.newLine();
                  _builder.append("</a-col>");
                  _builder.newLine();
                }
              }
            }
          }
        }
      }
      _builder.append("        ");
      _builder.append("<template v-if=\"advanced\">");
      _builder.newLine();
      _builder.newLine();
      {
        for(final Field sf_1 : sfbs) {
          {
            if ((Objects.equal(sf_1.getKeyType(), "M21") || Objects.equal(sf_1.getKeyType(), "121"))) {
              _builder.append("<a-col :md=\"8\" :sm=\"24\">");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("<a-form-item");
              _builder.newLine();
              _builder.append("\t\t  ");
              _builder.append("label=\"");
              String _label_2 = sf_1.getLabel();
              _builder.append(_label_2, "\t\t  ");
              _builder.append("\"");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t  ");
              _builder.append("fieldDecoratorId=\"");
              String _name_3 = sf_1.getName();
              _builder.append(_name_3, "\t\t  ");
              _builder.append("_id_LIKE\"");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t  ");
              _builder.append(":fieldDecoratorOptions=\"{rules: [");
              _builder.newLine();
              _builder.append("\t\t  ");
              _builder.append("]}\"");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append(">");
              _builder.newLine();
              _builder.append("\t\t\t");
              _builder.append("<a-select placeholder=\"请选择\" :defaultActiveFirstOption=\"false\">");
              _builder.newLine();
              _builder.append("\t\t\t  ");
              _builder.append("<a-select-option v-for=\"d in ");
              String _name_4 = sf_1.getName();
              _builder.append(_name_4, "\t\t\t  ");
              _builder.append("s\" :key=\"d.id\">{{d.");
              {
                final Function1<Field, Boolean> _function_1 = (Field it) -> {
                  String _name_5 = it.getName();
                  return Boolean.valueOf(Objects.equal(_name_5, "label"));
                };
                Iterable<Field> _filter_1 = IterableExtensions.<Field>filter(fields, _function_1);
                List<Field> _list = IterableExtensions.<Field>toList(_filter_1);
                int _length = ((Object[])Conversions.unwrapArray(_list, Object.class)).length;
                boolean _greaterThan_1 = (_length > 0);
                if (_greaterThan_1) {
                  _builder.append("label");
                } else {
                  _builder.append("name");
                }
              }
              _builder.append("}}</a-select-option>");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t\t");
              _builder.append("</a-select>");
              _builder.newLine();
              _builder.append("\t\t");
              _builder.append("</a-form-item>");
              _builder.newLine();
              _builder.append("</a-col>");
              _builder.newLine();
            } else {
              String _type_2 = sf_1.getType();
              boolean _equals_2 = Objects.equal(_type_2, "date");
              if (_equals_2) {
              } else {
                String _type_3 = sf_1.getType();
                boolean _equals_3 = Objects.equal(_type_3, "datetime");
                if (_equals_3) {
                } else {
                  _builder.append("<a-col :md=\"8\" :sm=\"24\">");
                  _builder.newLine();
                  _builder.append("  ");
                  _builder.append("<a-form-item");
                  _builder.newLine();
                  _builder.append("    ");
                  _builder.append("label=\"");
                  String _label_3 = sf_1.getLabel();
                  _builder.append(_label_3, "    ");
                  _builder.append("\"");
                  _builder.newLineIfNotEmpty();
                  _builder.append("    ");
                  _builder.append("fieldDecoratorId=\"");
                  String _name_5 = sf_1.getName();
                  _builder.append(_name_5, "    ");
                  _builder.append("_LIKE\"");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t\t  ");
                  _builder.append(":fieldDecoratorOptions=\"{rules: [");
                  _builder.newLine();
                  _builder.append("\t\t  ");
                  _builder.append("]}\"");
                  _builder.newLine();
                  _builder.append("  ");
                  _builder.append(">");
                  _builder.newLine();
                  _builder.append("    ");
                  _builder.append("<a-input/>");
                  _builder.newLine();
                  _builder.append("  ");
                  _builder.append("</a-form-item>");
                  _builder.newLine();
                  _builder.append("</a-col>");
                  _builder.newLine();
                }
              }
            }
          }
        }
      }
      _builder.newLine();
      _builder.append("        ");
      _builder.append("</template>");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("<a-col :md=\"!advanced && 8 || 24\" :sm=\"24\">");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("<span");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("class=\"table-page-search-submitButtons\"");
      _builder.newLine();
      _builder.append("            ");
      _builder.append(":style=\"advanced && { float: \'right\', overflow: \'hidden\' } || {} \"");
      _builder.newLine();
      _builder.append("          ");
      _builder.append(">");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("<a-button type=\"primary\" htmlType=\"submit\">搜索</a-button>");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("<a-button style=\"margin-left: 8px\" htmlType=\"reset\" @click=\"handleReset\">重置</a-button>");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("<a @click=\"toggleAdvanced\" style=\"margin-left: 8px\">");
      _builder.newLine();
      _builder.append("              ");
      _builder.append("{{ advanced ? \'收起\' : \'展开\' }}");
      _builder.newLine();
      _builder.append("              ");
      _builder.append("<a-icon :type=\"advanced ? \'up\' : \'down\'\"/>");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("</a>");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("</span>");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("</a-col>");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("</a-row>");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("</a-form>");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("</div>");
      _builder.newLine();
      _builder.append("</template>");
      _builder.newLine();
      _builder.append("<script>");
      _builder.newLine();
      _builder.append("export default {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("name: \"");
      String _name_6 = record.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name_6);
      _builder.append(_firstUpper, "  ");
      _builder.append("Search\",");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      _builder.append("components: {},");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("props:[");
      {
        for(final Field f : fields) {
          {
            if ((Objects.equal(f.getKeyType(), "M21") || Objects.equal(f.getKeyType(), "121"))) {
              _builder.append("\"");
              String _name_7 = f.getName();
              _builder.append(_name_7, "  ");
              _builder.append("s\",");
            }
          }
        }
      }
      _builder.append("],");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      _builder.append("data() {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("// 高级搜索 展开/关闭");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("advanced: false,");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("// 查询参数");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("queryParam: {},");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("form: {}");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("};");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("methods: {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("toggleAdvanced() {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("this.advanced = !this.advanced;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("handleSubmit(e) {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("console.log(\"submit\");");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("e.preventDefault();");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("this.form.validateFieldsAndScroll((err, values) => {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("if (!err) {");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("console.log(\"Received values of form: \", values);");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("this.$emit(\'");
      String _name_8 = record.getName();
      _builder.append(_name_8, "          ");
      _builder.append("SearchForm\',values);");
      _builder.newLineIfNotEmpty();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("});");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("handleReset() {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("console.log(\"reset\");");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("this.form.resetFields();");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _builder.append("</script>");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public static CharSequence recordlist(final Project project, final Record record, final List<Field> fields) {
    CharSequence _xblockexpression = null;
    {
      String _webRoot = project.getWebRoot();
      String[] paths = _webRoot.split("\\.");
      final String[] _converted_paths = (String[])paths;
      int _length = paths.length;
      List<String> _subList = ((List<String>)Conversions.doWrapArray(_converted_paths)).subList(1, _length);
      final String path = IterableExtensions.join(_subList, "/");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<template>");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("<a-card title=\"");
      String _label = record.getLabel();
      _builder.append(_label, "  ");
      _builder.append("列表\" :bordered=\"false\">");
      _builder.newLineIfNotEmpty();
      _builder.append("    ");
      _builder.append("<");
      String _name = record.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name);
      _builder.append(_firstUpper, "    ");
      _builder.append("Search ");
      {
        for(final Field f : fields) {
          {
            if ((Objects.equal(f.getKeyType(), "M21") || Objects.equal(f.getKeyType(), "121"))) {
              _builder.append(":");
              String _name_1 = f.getName();
              _builder.append(_name_1, "    ");
              _builder.append("s=\"");
              String _name_2 = f.getName();
              _builder.append(_name_2, "    ");
              _builder.append("s\" ");
            }
          }
        }
      }
      _builder.append(" @");
      String _name_3 = record.getName();
      _builder.append(_name_3, "    ");
      _builder.append("SearchForm=\"handleSearchForm\" />");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("<div class=\"table-operator\">");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("<a-button type=\"primary\" icon=\"plus\" @click=\"handleCreate\">新建</a-button>");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("<a-dropdown v-if=\"selectedRowKeys.length > 0\">");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("<a-menu slot=\"overlay\">");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("<a-menu-item key=\"1\" @click=\"handleBatchDelete\">");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("<a-icon type=\"delete\"/>删除");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("</a-menu-item>");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("</a-menu>");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("<a-button style=\"margin-left: 8px\">批量操作");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("<a-icon type=\"down\"/>");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("</a-button>");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("</a-dropdown>");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("</div>");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("<s-table");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("ref=\"table\"");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("size=\"default\"");
      _builder.newLine();
      _builder.append("      ");
      _builder.append(":columns=\"columns\"");
      _builder.newLine();
      _builder.append("      ");
      _builder.append(":data=\"loadData\"");
      _builder.newLine();
      _builder.append("      ");
      _builder.append(":showAlertInfo=\"true\"");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("@onSelect=\"onChange\"");
      _builder.newLine();
      _builder.append("    ");
      _builder.append(">");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("<span slot=\"action\" slot-scope=\"text, record\">");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("<a @click=\"handleEdit(record)\">修改</a>");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("<a-divider type=\"vertical\"/>");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("<a @click=\"handleDelete(record)\">删除</a>");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("</span>");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("</s-table>");
      _builder.newLine();
      _builder.newLine();
      _builder.append("    ");
      _builder.append("<a-modal title=\"操作\" :width=\"800\" :footer=\"null\" v-model=\"visible\" >");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("<a-form @submit=\"handleSubmit\" :autoFormCreate=\"(form)=>{this.form = form}\">");
      _builder.newLine();
      _builder.newLine();
      {
        for(final Field f_1 : fields) {
          {
            String _keyType = f_1.getKeyType();
            boolean _equals = Objects.equal(_keyType, "P");
            if (_equals) {
              _builder.append("<a-form-item label=\"ID\" v-show=\"false\" :labelCol=\"labelCol\" :wrapperCol=\"wrapperCol\" fieldDecoratorId=\"id\">");
              _builder.newLine();
              _builder.append("  ");
              _builder.append("<a-input/>");
              _builder.newLine();
              _builder.append("</a-form-item>");
              _builder.newLine();
            } else {
              if ((Objects.equal(f_1.getKeyType(), "M21") || Objects.equal(f_1.getKeyType(), "121"))) {
                _builder.append("<a-form-item");
                _builder.newLine();
                _builder.append("  ");
                _builder.append(":labelCol=\"labelCol\"");
                _builder.newLine();
                _builder.append("  ");
                _builder.append(":wrapperCol=\"wrapperCol\"");
                _builder.newLine();
                _builder.append("  ");
                _builder.append("label=\"");
                String _label_1 = f_1.getLabel();
                _builder.append(_label_1, "  ");
                _builder.append("\"");
                _builder.newLineIfNotEmpty();
                _builder.append("  ");
                _builder.append("fieldDecoratorId=\"");
                String _name_4 = f_1.getName();
                _builder.append(_name_4, "  ");
                _builder.append(".id\"");
                _builder.newLineIfNotEmpty();
                _builder.append("  ");
                _builder.append(":fieldDecoratorOptions=\"{rules: [");
                _builder.newLine();
                {
                  String _valid = f_1.getValid();
                  Valid _valid_1 = HeyangVue2019.toValid(_valid);
                  boolean _requried = _valid_1.getRequried();
                  boolean _equals_1 = (_requried == true);
                  if (_equals_1) {
                    _builder.append("  ");
                    _builder.append("{ required: true, message: \'请输入");
                    String _label_2 = f_1.getLabel();
                    _builder.append(_label_2, "  ");
                    _builder.append("!\' },");
                    _builder.newLineIfNotEmpty();
                  }
                }
                _builder.append("  ");
                _builder.append("]}\"");
                _builder.newLine();
                _builder.append(">");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("<a-select placeholder=\"请选择\" :defaultActiveFirstOption=\"false\">");
                _builder.newLine();
                _builder.append("\t  ");
                _builder.append("<a-select-option v-for=\"d in ");
                String _name_5 = f_1.getName();
                _builder.append(_name_5, "\t  ");
                _builder.append("s\" :key=\"d.id\">{{d.name}}</a-select-option>");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("</a-select>");
                _builder.newLine();
                _builder.append("</a-form-item>");
                _builder.newLine();
              } else {
                String _keyType_1 = f_1.getKeyType();
                boolean _equals_2 = Objects.equal(_keyType_1, "12M");
                if (_equals_2) {
                } else {
                  String _type = f_1.getType();
                  boolean _equals_3 = Objects.equal(_type, "date");
                  if (_equals_3) {
                    _builder.append("\t\t");
                    _builder.append("<a-form-item");
                    _builder.newLine();
                    _builder.append("\t\t  ");
                    _builder.append(":labelCol=\"labelCol\"");
                    _builder.newLine();
                    _builder.append("\t\t  ");
                    _builder.append(":wrapperCol=\"wrapperCol\"");
                    _builder.newLine();
                    _builder.append("\t\t  ");
                    _builder.append("label=\"");
                    String _label_3 = f_1.getLabel();
                    _builder.append(_label_3, "\t\t  ");
                    _builder.append("\"");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t  ");
                    _builder.append("fieldDecoratorId=\"");
                    String _name_6 = f_1.getName();
                    _builder.append(_name_6, "\t\t  ");
                    _builder.append("\"");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t\t  ");
                    _builder.append(":fieldDecoratorOptions=\"{rules: [");
                    _builder.newLine();
                    {
                      String _valid_2 = f_1.getValid();
                      Valid _valid_3 = HeyangVue2019.toValid(_valid_2);
                      boolean _requried_1 = _valid_3.getRequried();
                      boolean _equals_4 = (_requried_1 == true);
                      if (_equals_4) {
                        _builder.append("\t\t  ");
                        _builder.append("{ required: true, message: \'请输入");
                        String _label_4 = f_1.getLabel();
                        _builder.append(_label_4, "\t\t  ");
                        _builder.append("!\' },");
                        _builder.newLineIfNotEmpty();
                      }
                    }
                    _builder.append("\t\t  ");
                    _builder.append("]}\"");
                    _builder.newLine();
                    _builder.append("\t\t");
                    _builder.append(">");
                    _builder.newLine();
                    _builder.append("    ");
                    _builder.append("<a-date-picker");
                    _builder.newLine();
                    _builder.append("    ");
                    _builder.append("style=\"width: 100%\"/>");
                    _builder.newLine();
                    _builder.append("</a-form-item>");
                    _builder.newLine();
                  } else {
                    String _type_1 = f_1.getType();
                    boolean _equals_5 = Objects.equal(_type_1, "datetime");
                    if (_equals_5) {
                      _builder.append("\t\t");
                      _builder.append("<a-form-item");
                      _builder.newLine();
                      _builder.append("\t\t  ");
                      _builder.append(":labelCol=\"labelCol\"");
                      _builder.newLine();
                      _builder.append("\t\t  ");
                      _builder.append(":wrapperCol=\"wrapperCol\"");
                      _builder.newLine();
                      _builder.append("\t\t  ");
                      _builder.append("label=\"");
                      String _label_5 = f_1.getLabel();
                      _builder.append(_label_5, "\t\t  ");
                      _builder.append("\"");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t  ");
                      _builder.append("fieldDecoratorId=\"");
                      String _name_7 = f_1.getName();
                      _builder.append(_name_7, "\t\t  ");
                      _builder.append("\"");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t\t  ");
                      _builder.append(":fieldDecoratorOptions=\"{rules: [");
                      _builder.newLine();
                      {
                        String _valid_4 = f_1.getValid();
                        Valid _valid_5 = HeyangVue2019.toValid(_valid_4);
                        boolean _requried_2 = _valid_5.getRequried();
                        boolean _equals_6 = (_requried_2 == true);
                        if (_equals_6) {
                          _builder.append("\t\t ");
                          _builder.append("{ required: true, message: \'请输入");
                          String _label_6 = f_1.getLabel();
                          _builder.append(_label_6, "\t\t ");
                          _builder.append("!\' },");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      _builder.append("\t\t  ");
                      _builder.append("]}\"");
                      _builder.newLine();
                      _builder.append("\t\t");
                      _builder.append(">");
                      _builder.newLine();
                      _builder.append("    ");
                      _builder.append("<a-date-picker");
                      _builder.newLine();
                      _builder.append("      ");
                      _builder.append("format=\"YYYY-MM-DD HH:mm:ss\"");
                      _builder.newLine();
                      _builder.append("      ");
                      _builder.append(":disabledDate=\"disabledDate\"");
                      _builder.newLine();
                      _builder.append("      ");
                      _builder.append(":disabledTime=\"disabledDateTime\"");
                      _builder.newLine();
                      _builder.append("      ");
                      _builder.append(":showTime=\"{ defaultValue: moment(\'00:00:00\', \'HH:mm:ss\') }\"");
                      _builder.newLine();
                      _builder.append("    ");
                      _builder.append("style=\"width: 100%\"/>");
                      _builder.newLine();
                      _builder.append("</a-form-item>");
                      _builder.newLine();
                    } else {
                      _builder.append("<a-form-item");
                      _builder.newLine();
                      _builder.append("  ");
                      _builder.append(":labelCol=\"labelCol\"");
                      _builder.newLine();
                      _builder.append("  ");
                      _builder.append(":wrapperCol=\"wrapperCol\"");
                      _builder.newLine();
                      _builder.append("  ");
                      _builder.append("label=\"");
                      String _label_7 = f_1.getLabel();
                      _builder.append(_label_7, "  ");
                      _builder.append("\"");
                      _builder.newLineIfNotEmpty();
                      _builder.append("  ");
                      _builder.append("fieldDecoratorId=\"");
                      String _name_8 = f_1.getName();
                      _builder.append(_name_8, "  ");
                      _builder.append("\"");
                      _builder.newLineIfNotEmpty();
                      _builder.append("  ");
                      _builder.append(":fieldDecoratorOptions=\"{rules: [");
                      _builder.newLine();
                      {
                        String _valid_6 = f_1.getValid();
                        Valid _valid_7 = HeyangVue2019.toValid(_valid_6);
                        boolean _requried_3 = _valid_7.getRequried();
                        boolean _equals_7 = (_requried_3 == true);
                        if (_equals_7) {
                          _builder.append("  ");
                          _builder.append("{ required: true, message: \'请输入");
                          String _label_8 = f_1.getLabel();
                          _builder.append(_label_8, "  ");
                          _builder.append("!\' },");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      {
                        String _valid_8 = f_1.getValid();
                        Valid _valid_9 = HeyangVue2019.toValid(_valid_8);
                        String _valid_10 = _valid_9.getValid();
                        boolean _equals_8 = Objects.equal(_valid_10, "cname");
                        if (_equals_8) {
                          _builder.append("  ");
                          _builder.append("{ pattern:/^[\\u4e00-\\u9fa5]{2,8}$/, message: \'");
                          String _label_9 = f_1.getLabel();
                          _builder.append(_label_9, "  ");
                          _builder.append("应当使用2至8个汉字!!\' },");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      {
                        String _valid_11 = f_1.getValid();
                        Valid _valid_12 = HeyangVue2019.toValid(_valid_11);
                        String _valid_13 = _valid_12.getValid();
                        boolean _equals_9 = Objects.equal(_valid_13, "ename");
                        if (_equals_9) {
                          _builder.append("  ");
                          _builder.append("{ pattern:/^[a-zA-Z0-9]{4,10}$/, message: \'");
                          String _label_10 = f_1.getLabel();
                          _builder.append(_label_10, "  ");
                          _builder.append("应当使用4至10个英文、数字!!\' },");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      {
                        String _valid_14 = f_1.getValid();
                        Valid _valid_15 = HeyangVue2019.toValid(_valid_14);
                        String _valid_16 = _valid_15.getValid();
                        boolean _equals_10 = Objects.equal(_valid_16, "address");
                        if (_equals_10) {
                          _builder.append("  ");
                          _builder.append("{ pattern:/^[\\u4e00-\\u9fa5A-Za-z0-9]{2,40}$/, message: \'");
                          String _label_11 = f_1.getLabel();
                          _builder.append(_label_11, "  ");
                          _builder.append("应当使用2至40个中文、英文、数字!!\' },");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      {
                        String _valid_17 = f_1.getValid();
                        Valid _valid_18 = HeyangVue2019.toValid(_valid_17);
                        String _valid_19 = _valid_18.getValid();
                        boolean _equals_11 = Objects.equal(_valid_19, "phone");
                        if (_equals_11) {
                          _builder.append("  ");
                          _builder.append("{ pattern:/^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$/, message: \'");
                          String _label_12 = f_1.getLabel();
                          _builder.append(_label_12, "  ");
                          _builder.append("格式不对!!\' },");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      {
                        String _valid_20 = f_1.getValid();
                        Valid _valid_21 = HeyangVue2019.toValid(_valid_20);
                        String _valid_22 = _valid_21.getValid();
                        boolean _equals_12 = Objects.equal(_valid_22, "password");
                        if (_equals_12) {
                          _builder.append("  ");
                          _builder.append("{ pattern:/^[a-zA-Z0-9}]{6,12}$/, message: \'");
                          String _label_13 = f_1.getLabel();
                          _builder.append(_label_13, "  ");
                          _builder.append("应当为6至12位英文、数字!!\' },");
                          _builder.newLineIfNotEmpty();
                        }
                      }
                      _builder.append("  ");
                      _builder.append("]}\"");
                      _builder.newLine();
                      _builder.append(">");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("<a-input/>");
                      _builder.newLine();
                      _builder.append("</a-form-item>");
                      _builder.newLine();
                    }
                  }
                }
              }
            }
          }
          _builder.newLine();
        }
      }
      _builder.append("\t\t");
      _builder.append("<a-form-item");
      _builder.newLine();
      _builder.append("\t\t  ");
      _builder.append(":labelCol=\"labelCol\"");
      _builder.newLine();
      _builder.append("\t\t  ");
      _builder.append(":wrapperCol=\"wrapperCol\"");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append(">");
      _builder.newLine();
      _builder.append("              ");
      _builder.append("<a-button-group>");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("<a-button type=\"primary\" htmlType=\"submit\">保存</a-button>");
      _builder.newLine();
      _builder.append("                ");
      _builder.append("<a-button type=\"default\" htmlType=\"reset\" @click=\"handleReset\">重置</a-button>");
      _builder.newLine();
      _builder.append("              ");
      _builder.append("</a-button-group>");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("</a-form-item>");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("</a-form>");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("</a-modal>");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("</a-card>");
      _builder.newLine();
      _builder.append("</template>");
      _builder.newLine();
      _builder.newLine();
      _builder.append("<script>");
      _builder.newLine();
      _builder.append("import STable from \"@/components/table/\";");
      _builder.newLine();
      _builder.append("import ATextarea from \"ant-design-vue/es/input/TextArea\";");
      _builder.newLine();
      _builder.append("import AInput from \"ant-design-vue/es/input/Input\";");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import ");
      String _name_9 = record.getName();
      String _firstUpper_1 = StringExtensions.toFirstUpper(_name_9);
      _builder.append(_firstUpper_1, "");
      _builder.append("Search from \"@/");
      _builder.append(path, "");
      _builder.append("/");
      String _name_10 = record.getName();
      String _firstUpper_2 = StringExtensions.toFirstUpper(_name_10);
      _builder.append(_firstUpper_2, "");
      _builder.append("Search\";");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("var moment = require(\"moment\");");
      _builder.newLine();
      _builder.newLine();
      _builder.append("export default {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("name: \"");
      String _name_11 = record.getName();
      String _firstUpper_3 = StringExtensions.toFirstUpper(_name_11);
      _builder.append(_firstUpper_3, "  ");
      _builder.append("List\",");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      _builder.append("components: {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("AInput,");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("ATextarea,");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("STable,");
      _builder.newLine();
      _builder.append("    ");
      String _name_12 = record.getName();
      String _firstUpper_4 = StringExtensions.toFirstUpper(_name_12);
      _builder.append(_firstUpper_4, "    ");
      _builder.append("Search");
      _builder.newLineIfNotEmpty();
      _builder.append("  ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("data() {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("return {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("visible: false,");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("labelCol: {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("xs: { span: 24 },");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("sm: { span: 5 }");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("wrapperCol: {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("xs: { span: 24 },");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("sm: { span: 12 }");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("form: null,");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("mdl: {},");
      _builder.newLine();
      _builder.newLine();
      _builder.append("      ");
      _builder.append("// 高级搜索 展开/关闭");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("advanced: true,");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("// 查询参数");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("queryParam: {},");
      _builder.newLine();
      _builder.append("      ");
      _builder.newLine();
      {
        for(final Field f_2 : fields) {
          {
            if ((Objects.equal(f_2.getKeyType(), "M21") || Objects.equal(f_2.getKeyType(), "121"))) {
              _builder.append("    ");
              String _name_13 = f_2.getName();
              _builder.append(_name_13, "    ");
              _builder.append("s: [],");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("      ");
      _builder.append("// 表头");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("columns: [");
      _builder.newLine();
      {
        for(final Field f_3 : fields) {
          {
            String _keyType_2 = f_3.getKeyType();
            boolean _equals_13 = Objects.equal(_keyType_2, "P");
            if (_equals_13) {
            } else {
              String _keyType_3 = f_3.getKeyType();
              boolean _equals_14 = Objects.equal(_keyType_3, "12M");
              if (_equals_14) {
              } else {
                if ((Objects.equal(f_3.getKeyType(), "M21") || Objects.equal(f_3.getKeyType(), "121"))) {
                  _builder.append("{");
                  _builder.newLine();
                  _builder.append("\t");
                  _builder.append("title: \"");
                  String _label_14 = f_3.getLabel();
                  _builder.append(_label_14, "\t");
                  _builder.append("\",");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("dataIndex: \"");
                  String _name_14 = f_3.getName();
                  _builder.append(_name_14, "\t");
                  _builder.append("\",");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("key: \"");
                  String _name_15 = f_3.getName();
                  _builder.append(_name_15, "\t");
                  _builder.append("\",       \t");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append("customRender: text => <span>{text.name} | {text.label}</span>");
                  _builder.newLine();
                  _builder.append("},");
                  _builder.newLine();
                } else {
                  String _type_2 = f_3.getType();
                  boolean _equals_15 = Objects.equal(_type_2, "datetime");
                  if (_equals_15) {
                    _builder.append("{");
                    _builder.newLine();
                    _builder.append("  ");
                    _builder.append("title: \"");
                    String _label_15 = f_3.getLabel();
                    _builder.append(_label_15, "  ");
                    _builder.append("\",");
                    _builder.newLineIfNotEmpty();
                    _builder.append("  ");
                    _builder.append("dataIndex: \"");
                    String _name_16 = f_3.getName();
                    _builder.append(_name_16, "  ");
                    _builder.append("\",");
                    _builder.newLineIfNotEmpty();
                    _builder.append("  ");
                    _builder.append("key: \"");
                    String _name_17 = f_3.getName();
                    _builder.append(_name_17, "  ");
                    _builder.append("\",       \t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("  ");
                    _builder.append("width: \"120px\",");
                    _builder.newLine();
                    _builder.append("\t\t  ");
                    _builder.append("customRender: text => {");
                    _builder.newLine();
                    _builder.append("\t\t    ");
                    _builder.append("if (text) {");
                    _builder.newLine();
                    _builder.append("\t\t      ");
                    _builder.append("return moment(text).format(\"YYYY-MM-DD HH:mm:ss\");");
                    _builder.newLine();
                    _builder.append("\t\t    ");
                    _builder.append("} else {");
                    _builder.newLine();
                    _builder.append("\t\t      ");
                    _builder.append("return \"\";");
                    _builder.newLine();
                    _builder.append("\t\t    ");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("\t\t  ");
                    _builder.append("}");
                    _builder.newLine();
                    _builder.append("},");
                    _builder.newLine();
                  } else {
                    String _type_3 = f_3.getType();
                    boolean _equals_16 = Objects.equal(_type_3, "date");
                    if (_equals_16) {
                      _builder.append("{");
                      _builder.newLine();
                      _builder.append("  ");
                      _builder.append("title: \"");
                      String _label_16 = f_3.getLabel();
                      _builder.append(_label_16, "  ");
                      _builder.append("\",");
                      _builder.newLineIfNotEmpty();
                      _builder.append("  ");
                      _builder.append("dataIndex: \"");
                      String _name_18 = f_3.getName();
                      _builder.append(_name_18, "  ");
                      _builder.append("\",");
                      _builder.newLineIfNotEmpty();
                      _builder.append("  ");
                      _builder.append("key: \"");
                      String _name_19 = f_3.getName();
                      _builder.append(_name_19, "  ");
                      _builder.append("\",       \t");
                      _builder.newLineIfNotEmpty();
                      _builder.append("  ");
                      _builder.append("width: \"120px\",");
                      _builder.newLine();
                      _builder.append("\t\t  ");
                      _builder.append("customRender: text => {");
                      _builder.newLine();
                      _builder.append("\t\t    ");
                      _builder.append("if (text) {");
                      _builder.newLine();
                      _builder.append("\t\t      ");
                      _builder.append("return moment(text).format(\"YYYY-MM-DD\");");
                      _builder.newLine();
                      _builder.append("\t\t    ");
                      _builder.append("} else {");
                      _builder.newLine();
                      _builder.append("\t\t      ");
                      _builder.append("return \"\";");
                      _builder.newLine();
                      _builder.append("\t\t    ");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("\t\t  ");
                      _builder.append("}");
                      _builder.newLine();
                      _builder.append("},");
                      _builder.newLine();
                    } else {
                      _builder.append("{");
                      _builder.newLine();
                      _builder.append("\t");
                      _builder.append("title: \"");
                      String _label_17 = f_3.getLabel();
                      _builder.append(_label_17, "\t");
                      _builder.append("\",");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("dataIndex: \"");
                      String _name_20 = f_3.getName();
                      _builder.append(_name_20, "\t");
                      _builder.append("\",");
                      _builder.newLineIfNotEmpty();
                      _builder.append("\t");
                      _builder.append("customRender: text => text");
                      _builder.newLine();
                      _builder.append("},");
                      _builder.newLine();
                    }
                  }
                }
              }
            }
          }
        }
      }
      _builder.append("        ");
      _builder.append("{");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("title: \"操作\",");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("dataIndex: \"action\",");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("width: \"120px\",");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("scopedSlots: { customRender: \"action\" }");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("],");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("// 加载数据方法 必须为 Promise 对象");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("loadData: parameter => {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("console.log(\"---\", parameter);");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("var body = Object.assign(parameter, this.queryParam);");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("return this.$http");
      _builder.newLine();
      _builder.append("          ");
      _builder.append(".post(");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("this.$store.state.app.approot + \"/controller/v1/");
      String _name_21 = record.getName();
      String _firstLower = StringExtensions.toFirstLower(_name_21);
      _builder.append(_firstLower, "            ");
      _builder.append("/page\",");
      _builder.newLineIfNotEmpty();
      _builder.append("            ");
      _builder.append("body,");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("{ params: parameter }");
      _builder.newLine();
      _builder.append("          ");
      _builder.append(")");
      _builder.newLine();
      _builder.append("          ");
      _builder.append(".then(res => {");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("console.log(\"-------------\", res);");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("return res.data;");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("});");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("},");
      _builder.newLine();
      _builder.newLine();
      _builder.append("      ");
      _builder.append("selectedRowKeys: [],");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("selectedRows: []");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("};");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("mounted() {");
      _builder.newLine();
      {
        for(final Field f_4 : fields) {
          {
            if ((Objects.equal(f_4.getKeyType(), "M21") || Objects.equal(f_4.getKeyType(), "121"))) {
              _builder.append("this.$http");
              _builder.newLine();
              _builder.append("      ");
              _builder.append(".get(this.$store.state.app.approot + \"/controller/v1/");
              String _name_22 = f_4.getName();
              _builder.append(_name_22, "      ");
              _builder.append("/\", {})");
              _builder.newLineIfNotEmpty();
              _builder.append("      ");
              _builder.append(".then(res => {");
              _builder.newLine();
              _builder.append("        ");
              _builder.append("console.log(\"-------------");
              String _name_23 = f_4.getName();
              _builder.append(_name_23, "        ");
              _builder.append("s\", res.data);");
              _builder.newLineIfNotEmpty();
              _builder.append("        ");
              _builder.append("this.");
              String _name_24 = f_4.getName();
              _builder.append(_name_24, "        ");
              _builder.append("s = res.data;");
              _builder.newLineIfNotEmpty();
              _builder.append("      ");
              _builder.append("});");
              _builder.newLine();
            }
          }
        }
      }
      _builder.append("  ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("methods: {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("moment,");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("range(start, end) {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("const result = [];");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("for (let i = start; i < end; i++) {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("result.push(i);");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("return result;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("disabledDate(current) {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("// Can not select days before today and today");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("return current && current < moment().endOf(\'day\');");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("disabledDateTime() {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("return {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("disabledHours: () => this.range(0, 24).splice(4, 20),");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("disabledMinutes: () => this.range(30, 60),");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("disabledSeconds: () => [55, 56],");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("};");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("handleCreate(e) {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("this.visible = true;");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("setTimeout(() => {");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("this.form.resetFields();");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("}, 50);");
      _builder.newLine();
      _builder.append("      ");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("handleEdit(record) {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("this.mdl = Object.assign({}, record);");
      _builder.newLine();
      {
        for(final Field f_5 : fields) {
          {
            String _keyType_4 = f_5.getKeyType();
            boolean _equals_17 = Objects.equal(_keyType_4, "12M");
            if (_equals_17) {
              _builder.append("      ");
              _builder.append("delete this.mdl.");
              String _name_25 = f_5.getName();
              _builder.append(_name_25, "      ");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("      ");
      _builder.append("console.log(\"modal\",this.mdl);");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("this.visible = true;");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("setTimeout(() => {");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("this.form.setFieldsValue(this.mdl);");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("}, 50);");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("handleDelete(record) {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("console.log(record);");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("let that = this;");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("const deleteModal = this.$confirm({");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("title: \"确认\",");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("content: `确认删除选中的 ${record.name}？`,");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("okText: \"确认\",");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("okType: \"danger\",");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("cancelText: \"取消\",");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("onOk() {");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("console.log(\"开始删除\");");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("that.$http");
      _builder.newLine();
      _builder.append("            ");
      _builder.append(".delete(");
      _builder.newLine();
      _builder.append("              ");
      _builder.append("that.$store.state.app.approot + \"/controller/v1/");
      String _name_26 = record.getName();
      _builder.append(_name_26, "              ");
      _builder.append("/\" + record.id");
      _builder.newLineIfNotEmpty();
      _builder.append("            ");
      _builder.append(")");
      _builder.newLine();
      _builder.append("            ");
      _builder.append(".then(res => {");
      _builder.newLine();
      _builder.append("              ");
      _builder.append("console.log(`已删除id为${record.id}的设备`);");
      _builder.newLine();
      _builder.append("              ");
      _builder.append("that.$refs.table.refresh();");
      _builder.newLine();
      _builder.append("              ");
      _builder.append("deleteModal.destroy();");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("});");
      _builder.newLine();
      _builder.append("          ");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("onCancel() {");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("console.log(\"取消删除\");");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("});");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("handleSubmit(e) {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("e.preventDefault();");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("console.log(\"selected\", this.form.values);");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("this.form.validateFieldsAndScroll((err, values) => {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("if (!err) {");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("console.log(\"Received values of form: \", values);");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("this.$http");
      _builder.newLine();
      _builder.append("            ");
      _builder.append(".post(this.$store.state.app.approot + \"/controller/v1/");
      String _name_27 = record.getName();
      _builder.append(_name_27, "            ");
      _builder.append("/\", values)");
      _builder.newLineIfNotEmpty();
      _builder.append("            ");
      _builder.append(".then(res => {");
      _builder.newLine();
      _builder.append("              ");
      _builder.append("console.log(`已添加设备${values.name}`);");
      _builder.newLine();
      _builder.append("              ");
      _builder.append("this.$refs.table.refresh();");
      _builder.newLine();
      _builder.append("              ");
      _builder.append("this.visible = false;");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("});");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("});");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("handleReset() {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("console.log(\"reset\");");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("this.form.resetFields();");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("handleSearchForm(data){");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("var keys = _.map(_.keys(data),key=>key.replace(\"_id_\", \".id_\"))");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("var values = _.values(data)");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("this.queryParam = _.zipObject(keys, values);");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("console.log(this.queryParam);");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("this.$refs.table.refresh();");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("handleBatchDelete(e) {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("console.log(this.selectedRowKeys);");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("let that = this;");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("const deleteModal = this.$confirm({");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("title: \"确认\",");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("content: `确认删除选中的${this.selectedRowKeys.length}个");
      String _label_18 = record.getLabel();
      _builder.append(_label_18, "        ");
      _builder.append("？`,");
      _builder.newLineIfNotEmpty();
      _builder.append("        ");
      _builder.append("okText: \"确认\",");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("okType: \"danger\",");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("cancelText: \"取消\",");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("onOk() {");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("console.log(\"开始删除\");");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("that.$http");
      _builder.newLine();
      _builder.append("            ");
      _builder.append(".post(");
      _builder.newLine();
      _builder.append("              ");
      _builder.append("that.$store.state.app.approot + \"/controller/v1/");
      String _name_28 = record.getName();
      _builder.append(_name_28, "              ");
      _builder.append("/deletes\",");
      _builder.newLineIfNotEmpty();
      _builder.append("              ");
      _builder.append("that.selectedRowKeys");
      _builder.newLine();
      _builder.append("            ");
      _builder.append(")");
      _builder.newLine();
      _builder.append("            ");
      _builder.append(".then(res => {");
      _builder.newLine();
      _builder.append("              ");
      _builder.append("console.log(`已删除选中的${that.selectedRowKeys.length}个");
      String _label_19 = record.getLabel();
      _builder.append(_label_19, "              ");
      _builder.append("`);");
      _builder.newLineIfNotEmpty();
      _builder.append("              ");
      _builder.append("that.$refs.table.refresh();");
      _builder.newLine();
      _builder.append("              ");
      _builder.append("deleteModal.destroy();");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("});");
      _builder.newLine();
      _builder.append("          ");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("onCancel() {");
      _builder.newLine();
      _builder.append("          ");
      _builder.append("console.log(\"取消删除\");");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("});");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("onChange(row) {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("this.selectedRowKeys = row.selectedRowKeys;");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("this.selectedRows = row.selectedRows;");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("console.log(this.selectedRowKeys);");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("console.log(this.selectedRows);");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("console.log(this.$refs.table);");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("toggleAdvanced() {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("this.advanced = !this.advanced;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("},");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("watch: {");
      _builder.newLine();
      _builder.append("　　");
      _builder.append("\'$route\': function (to, from) {");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("this.$refs.table.refresh();");
      _builder.newLine();
      _builder.append("　　");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("};");
      _builder.newLine();
      _builder.append("</script>");
      _builder.newLine();
      _builder.append("<style>");
      _builder.newLine();
      _builder.append(".table-operator button{");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("margin: 10px 10px 10px 0px;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("</style>");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
}
