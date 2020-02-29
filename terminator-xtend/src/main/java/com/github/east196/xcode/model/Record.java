package com.github.east196.xcode.model;

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
public class Record {
  private String id;
  
  private String name;
  
  private String label;
  
  private String config;
  
  private String doc;
  
  private String projectId;
  
  private String dbType;
  
  private String dbName;
  
  private String tableName;
  
  private String geneOk;
  
  private String method;
  
  private String url;
  
  private String action;
  
  private String dataType;
  
  private String dataName;
  
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
  public String getDbType() {
    return this.dbType;
  }
  
  public void setDbType(final String dbType) {
    this.dbType = dbType;
  }
  
  @Pure
  public String getDbName() {
    return this.dbName;
  }
  
  public void setDbName(final String dbName) {
    this.dbName = dbName;
  }
  
  @Pure
  public String getTableName() {
    return this.tableName;
  }
  
  public void setTableName(final String tableName) {
    this.tableName = tableName;
  }
  
  @Pure
  public String getGeneOk() {
    return this.geneOk;
  }
  
  public void setGeneOk(final String geneOk) {
    this.geneOk = geneOk;
  }
  
  @Pure
  public String getMethod() {
    return this.method;
  }
  
  public void setMethod(final String method) {
    this.method = method;
  }
  
  @Pure
  public String getUrl() {
    return this.url;
  }
  
  public void setUrl(final String url) {
    this.url = url;
  }
  
  @Pure
  public String getAction() {
    return this.action;
  }
  
  public void setAction(final String action) {
    this.action = action;
  }
  
  @Pure
  public String getDataType() {
    return this.dataType;
  }
  
  public void setDataType(final String dataType) {
    this.dataType = dataType;
  }
  
  @Pure
  public String getDataName() {
    return this.dataName;
  }
  
  public void setDataName(final String dataName) {
    this.dataName = dataName;
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
    Record other = (Record) obj;
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
    if (this.dbType == null) {
      if (other.dbType != null)
        return false;
    } else if (!this.dbType.equals(other.dbType))
      return false;
    if (this.dbName == null) {
      if (other.dbName != null)
        return false;
    } else if (!this.dbName.equals(other.dbName))
      return false;
    if (this.tableName == null) {
      if (other.tableName != null)
        return false;
    } else if (!this.tableName.equals(other.tableName))
      return false;
    if (this.geneOk == null) {
      if (other.geneOk != null)
        return false;
    } else if (!this.geneOk.equals(other.geneOk))
      return false;
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
    if (this.action == null) {
      if (other.action != null)
        return false;
    } else if (!this.action.equals(other.action))
      return false;
    if (this.dataType == null) {
      if (other.dataType != null)
        return false;
    } else if (!this.dataType.equals(other.dataType))
      return false;
    if (this.dataName == null) {
      if (other.dataName != null)
        return false;
    } else if (!this.dataName.equals(other.dataName))
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
    result = prime * result + ((this.config== null) ? 0 : this.config.hashCode());
    result = prime * result + ((this.doc== null) ? 0 : this.doc.hashCode());
    result = prime * result + ((this.projectId== null) ? 0 : this.projectId.hashCode());
    result = prime * result + ((this.dbType== null) ? 0 : this.dbType.hashCode());
    result = prime * result + ((this.dbName== null) ? 0 : this.dbName.hashCode());
    result = prime * result + ((this.tableName== null) ? 0 : this.tableName.hashCode());
    result = prime * result + ((this.geneOk== null) ? 0 : this.geneOk.hashCode());
    result = prime * result + ((this.method== null) ? 0 : this.method.hashCode());
    result = prime * result + ((this.url== null) ? 0 : this.url.hashCode());
    result = prime * result + ((this.action== null) ? 0 : this.action.hashCode());
    result = prime * result + ((this.dataType== null) ? 0 : this.dataType.hashCode());
    result = prime * result + ((this.dataName== null) ? 0 : this.dataName.hashCode());
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
    b.add("config", this.config);
    b.add("doc", this.doc);
    b.add("projectId", this.projectId);
    b.add("dbType", this.dbType);
    b.add("dbName", this.dbName);
    b.add("tableName", this.tableName);
    b.add("geneOk", this.geneOk);
    b.add("method", this.method);
    b.add("url", this.url);
    b.add("action", this.action);
    b.add("dataType", this.dataType);
    b.add("dataName", this.dataName);
    return b.toString();
  }
}
