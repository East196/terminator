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
public class EnumType {
  private String id;
  
  private String projectId;
  
  private String name;
  
  private String description;
  
  private String entrys;
  
  @Pure
  public String getId() {
    return this.id;
  }
  
  public void setId(final String id) {
    this.id = id;
  }
  
  @Pure
  public String getProjectId() {
    return this.projectId;
  }
  
  public void setProjectId(final String projectId) {
    this.projectId = projectId;
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  public void setName(final String name) {
    this.name = name;
  }
  
  @Pure
  public String getDescription() {
    return this.description;
  }
  
  public void setDescription(final String description) {
    this.description = description;
  }
  
  @Pure
  public String getEntrys() {
    return this.entrys;
  }
  
  public void setEntrys(final String entrys) {
    this.entrys = entrys;
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
    EnumType other = (EnumType) obj;
    if (this.id == null) {
      if (other.id != null)
        return false;
    } else if (!this.id.equals(other.id))
      return false;
    if (this.projectId == null) {
      if (other.projectId != null)
        return false;
    } else if (!this.projectId.equals(other.projectId))
      return false;
    if (this.name == null) {
      if (other.name != null)
        return false;
    } else if (!this.name.equals(other.name))
      return false;
    if (this.description == null) {
      if (other.description != null)
        return false;
    } else if (!this.description.equals(other.description))
      return false;
    if (this.entrys == null) {
      if (other.entrys != null)
        return false;
    } else if (!this.entrys.equals(other.entrys))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.id== null) ? 0 : this.id.hashCode());
    result = prime * result + ((this.projectId== null) ? 0 : this.projectId.hashCode());
    result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.description== null) ? 0 : this.description.hashCode());
    result = prime * result + ((this.entrys== null) ? 0 : this.entrys.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.singleLine();
    b.add("id", this.id);
    b.add("projectId", this.projectId);
    b.add("name", this.name);
    b.add("description", this.description);
    b.add("entrys", this.entrys);
    return b.toString();
  }
}
