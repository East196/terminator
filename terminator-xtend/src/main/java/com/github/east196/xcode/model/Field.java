package com.github.east196.xcode.model;

import java.util.List;
import javax.annotation.Generated;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.EqualsHashCode;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Accessors
@EqualsHashCode
@ToString(singleLine = true)
@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class Field {
  private String id;
  
  private String name;
  
  private String label;
  
  private String type;
  
  private String config;
  
  private String doc;
  
  private String length;
  
  private String required;
  
  private String keyType;
  
  private String show;
  
  public String getShowIn() {
    return this.show;
  }
  
  public String getOrderIndex() {
    return this.sortIndex;
  }
  
  private String projectId;
  
  private String recordId;
  
  private String defaultValue;
  
  private String fakerFunc;
  
  private String sortIndex;
  
  private String render;
  
  private String formGroup;
  
  private String formItem;
  
  private String formItemData;
  
  private String valid;
  
  public String javaName() {
    String _replace = this.name.replace(" ", "_");
    String[] _split = _replace.split("_");
    final Function1<String, String> _function = (String item) -> {
      return StringExtensions.toFirstUpper(item);
    };
    List<String> _map = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(_split)), _function);
    String _join = IterableExtensions.join(_map);
    return StringExtensions.toFirstLower(_join);
  }
  
  public String javaType() {
    String _xblockexpression = null;
    {
      String _trim = this.type.trim();
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_trim);
      if (_isNullOrEmpty) {
        return "String";
      }
      String _switchResult = null;
      String _firstLower = StringExtensions.toFirstLower(this.type);
      switch (_firstLower) {
        case "str":
          _switchResult = "String";
          break;
        case "string":
          _switchResult = "String";
          break;
        case "bool":
          _switchResult = "Boolean";
          break;
        case "boolean":
          _switchResult = "Boolean";
          break;
        case "datetime":
          _switchResult = "Date";
          break;
        case "date":
          _switchResult = "Date";
          break;
        case "int":
          _switchResult = "Integer";
          break;
        case "bigint":
          _switchResult = "long";
          break;
        case "long":
          _switchResult = "Long";
          break;
        case "double":
          _switchResult = "Double";
          break;
        case "list":
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("List<");
          int _length = this.name.length();
          int _minus = (_length - 1);
          CharSequence _subSequence = this.name.subSequence(0, _minus);
          String _string = _subSequence.toString();
          String _firstUpper = StringExtensions.toFirstUpper(_string);
          _builder.append(_firstUpper, "");
          _builder.append(">");
          _switchResult = _builder.toString();
          break;
        case "array":
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("List<");
          int _length_1 = this.name.length();
          int _minus_1 = (_length_1 - 1);
          CharSequence _subSequence_1 = this.name.subSequence(0, _minus_1);
          String _string_1 = _subSequence_1.toString();
          String _firstUpper_1 = StringExtensions.toFirstUpper(_string_1);
          _builder_1.append(_firstUpper_1, "");
          _builder_1.append(">");
          _switchResult = _builder_1.toString();
          break;
        case "object":
          _switchResult = StringExtensions.toFirstUpper(this.name);
          break;
        default:
          _switchResult = StringExtensions.toFirstUpper(this.type);
          break;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  @Pure
  public String getId() {
    return this.id;
  }
  
  public void setId(final String id) {
    this.id = id;
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  @Pure
  public String getLabel() {
    return this.label;
  }
  
  public void setLabel(final String label) {
    this.label = label;
  }
  
  @Pure
  public String getType() {
    return this.type;
  }
  
  public void setType(final String type) {
    this.type = type;
  }
  
  @Pure
  public String getConfig() {
    return this.config;
  }
  
  public void setConfig(final String config) {
    this.config = config;
  }
  
  @Pure
  public String getDoc() {
    return this.doc;
  }
  
  public void setDoc(final String doc) {
    this.doc = doc;
  }
  
  @Pure
  public String getLength() {
    return this.length;
  }
  
  public void setLength(final String length) {
    this.length = length;
  }
  
  @Pure
  public String getRequired() {
    return this.required;
  }
  
  public void setRequired(final String required) {
    this.required = required;
  }
  
  @Pure
  public String getKeyType() {
    return this.keyType;
  }
  
  public void setKeyType(final String keyType) {
    this.keyType = keyType;
  }
  
  @Pure
  public String getShow() {
    return this.show;
  }
  
  public void setShow(final String show) {
    this.show = show;
  }
  
  @Pure
  public String getProjectId() {
    return this.projectId;
  }
  
  public void setProjectId(final String projectId) {
    this.projectId = projectId;
  }
  
  @Pure
  public String getRecordId() {
    return this.recordId;
  }
  
  public void setRecordId(final String recordId) {
    this.recordId = recordId;
  }
  
  @Pure
  public String getDefaultValue() {
    return this.defaultValue;
  }
  
  public void setDefaultValue(final String defaultValue) {
    this.defaultValue = defaultValue;
  }
  
  @Pure
  public String getFakerFunc() {
    return this.fakerFunc;
  }
  
  public void setFakerFunc(final String fakerFunc) {
    this.fakerFunc = fakerFunc;
  }
  
  @Pure
  public String getSortIndex() {
    return this.sortIndex;
  }
  
  public void setSortIndex(final String sortIndex) {
    this.sortIndex = sortIndex;
  }
  
  @Pure
  public String getRender() {
    return this.render;
  }
  
  public void setRender(final String render) {
    this.render = render;
  }
  
  @Pure
  public String getFormGroup() {
    return this.formGroup;
  }
  
  public void setFormGroup(final String formGroup) {
    this.formGroup = formGroup;
  }
  
  @Pure
  public String getFormItem() {
    return this.formItem;
  }
  
  public void setFormItem(final String formItem) {
    this.formItem = formItem;
  }
  
  @Pure
  public String getFormItemData() {
    return this.formItemData;
  }
  
  public void setFormItemData(final String formItemData) {
    this.formItemData = formItemData;
  }
  
  @Pure
  public String getValid() {
    return this.valid;
  }
  
  public void setValid(final String valid) {
    this.valid = valid;
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
    Field other = (Field) obj;
    if (this.id == null) {
      if (other.id != null)
        return false;
    } else if (!this.id.equals(other.id))
      return false;
    if (this.name == null) {
      if (other.name != null)
        return false;
    } else if (!this.name.equals(other.name))
      return false;
    if (this.label == null) {
      if (other.label != null)
        return false;
    } else if (!this.label.equals(other.label))
      return false;
    if (this.type == null) {
      if (other.type != null)
        return false;
    } else if (!this.type.equals(other.type))
      return false;
    if (this.config == null) {
      if (other.config != null)
        return false;
    } else if (!this.config.equals(other.config))
      return false;
    if (this.doc == null) {
      if (other.doc != null)
        return false;
    } else if (!this.doc.equals(other.doc))
      return false;
    if (this.length == null) {
      if (other.length != null)
        return false;
    } else if (!this.length.equals(other.length))
      return false;
    if (this.required == null) {
      if (other.required != null)
        return false;
    } else if (!this.required.equals(other.required))
      return false;
    if (this.keyType == null) {
      if (other.keyType != null)
        return false;
    } else if (!this.keyType.equals(other.keyType))
      return false;
    if (this.show == null) {
      if (other.show != null)
        return false;
    } else if (!this.show.equals(other.show))
      return false;
    if (this.projectId == null) {
      if (other.projectId != null)
        return false;
    } else if (!this.projectId.equals(other.projectId))
      return false;
    if (this.recordId == null) {
      if (other.recordId != null)
        return false;
    } else if (!this.recordId.equals(other.recordId))
      return false;
    if (this.defaultValue == null) {
      if (other.defaultValue != null)
        return false;
    } else if (!this.defaultValue.equals(other.defaultValue))
      return false;
    if (this.fakerFunc == null) {
      if (other.fakerFunc != null)
        return false;
    } else if (!this.fakerFunc.equals(other.fakerFunc))
      return false;
    if (this.sortIndex == null) {
      if (other.sortIndex != null)
        return false;
    } else if (!this.sortIndex.equals(other.sortIndex))
      return false;
    if (this.render == null) {
      if (other.render != null)
        return false;
    } else if (!this.render.equals(other.render))
      return false;
    if (this.formGroup == null) {
      if (other.formGroup != null)
        return false;
    } else if (!this.formGroup.equals(other.formGroup))
      return false;
    if (this.formItem == null) {
      if (other.formItem != null)
        return false;
    } else if (!this.formItem.equals(other.formItem))
      return false;
    if (this.formItemData == null) {
      if (other.formItemData != null)
        return false;
    } else if (!this.formItemData.equals(other.formItemData))
      return false;
    if (this.valid == null) {
      if (other.valid != null)
        return false;
    } else if (!this.valid.equals(other.valid))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.id== null) ? 0 : this.id.hashCode());
    result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.label== null) ? 0 : this.label.hashCode());
    result = prime * result + ((this.type== null) ? 0 : this.type.hashCode());
    result = prime * result + ((this.config== null) ? 0 : this.config.hashCode());
    result = prime * result + ((this.doc== null) ? 0 : this.doc.hashCode());
    result = prime * result + ((this.length== null) ? 0 : this.length.hashCode());
    result = prime * result + ((this.required== null) ? 0 : this.required.hashCode());
    result = prime * result + ((this.keyType== null) ? 0 : this.keyType.hashCode());
    result = prime * result + ((this.show== null) ? 0 : this.show.hashCode());
    result = prime * result + ((this.projectId== null) ? 0 : this.projectId.hashCode());
    result = prime * result + ((this.recordId== null) ? 0 : this.recordId.hashCode());
    result = prime * result + ((this.defaultValue== null) ? 0 : this.defaultValue.hashCode());
    result = prime * result + ((this.fakerFunc== null) ? 0 : this.fakerFunc.hashCode());
    result = prime * result + ((this.sortIndex== null) ? 0 : this.sortIndex.hashCode());
    result = prime * result + ((this.render== null) ? 0 : this.render.hashCode());
    result = prime * result + ((this.formGroup== null) ? 0 : this.formGroup.hashCode());
    result = prime * result + ((this.formItem== null) ? 0 : this.formItem.hashCode());
    result = prime * result + ((this.formItemData== null) ? 0 : this.formItemData.hashCode());
    result = prime * result + ((this.valid== null) ? 0 : this.valid.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.singleLine();
    b.add("id", this.id);
    b.add("name", this.name);
    b.add("label", this.label);
    b.add("type", this.type);
    b.add("config", this.config);
    b.add("doc", this.doc);
    b.add("length", this.length);
    b.add("required", this.required);
    b.add("keyType", this.keyType);
    b.add("show", this.show);
    b.add("projectId", this.projectId);
    b.add("recordId", this.recordId);
    b.add("defaultValue", this.defaultValue);
    b.add("fakerFunc", this.fakerFunc);
    b.add("sortIndex", this.sortIndex);
    b.add("render", this.render);
    b.add("formGroup", this.formGroup);
    b.add("formItem", this.formItem);
    b.add("formItemData", this.formItemData);
    b.add("valid", this.valid);
    return b.toString();
  }
}
