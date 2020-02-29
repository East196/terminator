package com.github.east196.terminator.xtend.model;

import javax.annotation.Generated;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.EqualsHashCode;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Accessors
@EqualsHashCode
@ToString(singleLine = true)
@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class Valid {
  private String id;
  
  private String name;
  
  private String label;
  
  private String type;
  
  private String config;
  
  private String doc;
  
  private String projectId;
  
  private String recordId;
  
  private String fieldId;
  
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
  public String getFieldId() {
    return this.fieldId;
  }
  
  public void setFieldId(final String fieldId) {
    this.fieldId = fieldId;
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
    Valid other = (Valid) obj;
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
    if (this.fieldId == null) {
      if (other.fieldId != null)
        return false;
    } else if (!this.fieldId.equals(other.fieldId))
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
    result = prime * result + ((this.projectId== null) ? 0 : this.projectId.hashCode());
    result = prime * result + ((this.recordId== null) ? 0 : this.recordId.hashCode());
    result = prime * result + ((this.fieldId== null) ? 0 : this.fieldId.hashCode());
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
    b.add("projectId", this.projectId);
    b.add("recordId", this.recordId);
    b.add("fieldId", this.fieldId);
    return b.toString();
  }
}
