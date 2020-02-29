package com.github.east196.terminator.xtend.model;

import com.github.east196.terminator.xtend.model.Field;
import com.github.east196.terminator.xtend.model.Project;
import com.github.east196.terminator.xtend.model.Record;
import java.util.List;
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
public class Three {
  private Project project;
  
  private Record record;
  
  private List<Field> fields;
  
  public Three() {
  }
  
  public Three(final Project project, final Record record, final List<Field> fields) {
    this.project = project;
    this.record = record;
    this.fields = fields;
  }
  
  @Pure
  public Project getProject() {
    return this.project;
  }
  
  public void setProject(final Project project) {
    this.project = project;
  }
  
  @Pure
  public Record getRecord() {
    return this.record;
  }
  
  public void setRecord(final Record record) {
    this.record = record;
  }
  
  @Pure
  public List<Field> getFields() {
    return this.fields;
  }
  
  public void setFields(final List<Field> fields) {
    this.fields = fields;
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
    Three other = (Three) obj;
    if (this.project == null) {
      if (other.project != null)
        return false;
    } else if (!this.project.equals(other.project))
      return false;
    if (this.record == null) {
      if (other.record != null)
        return false;
    } else if (!this.record.equals(other.record))
      return false;
    if (this.fields == null) {
      if (other.fields != null)
        return false;
    } else if (!this.fields.equals(other.fields))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.project== null) ? 0 : this.project.hashCode());
    result = prime * result + ((this.record== null) ? 0 : this.record.hashCode());
    result = prime * result + ((this.fields== null) ? 0 : this.fields.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.singleLine();
    b.add("project", this.project);
    b.add("record", this.record);
    b.add("fields", this.fields);
    return b.toString();
  }
}
