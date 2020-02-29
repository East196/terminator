package com.github.east196.terminator.xtend.bot;

import com.github.east196.terminator.xtend.bot.Person;
import java.util.List;
import javax.annotation.Generated;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.EqualsHashCode;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class TransGene {
  @Accessors
  @EqualsHashCode
  @ToString
  public static class TransInfo {
    private List<String> fromFields;
    
    private String toField;
    
    @Pure
    public List<String> getFromFields() {
      return this.fromFields;
    }
    
    public void setFromFields(final List<String> fromFields) {
      this.fromFields = fromFields;
    }
    
    @Pure
    public String getToField() {
      return this.toField;
    }
    
    public void setToField(final String toField) {
      this.toField = toField;
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
      TransGene.TransInfo other = (TransGene.TransInfo) obj;
      if (this.fromFields == null) {
        if (other.fromFields != null)
          return false;
      } else if (!this.fromFields.equals(other.fromFields))
        return false;
      if (this.toField == null) {
        if (other.toField != null)
          return false;
      } else if (!this.toField.equals(other.toField))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.fromFields== null) ? 0 : this.fromFields.hashCode());
      result = prime * result + ((this.toField== null) ? 0 : this.toField.hashCode());
      return result;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("fromFields", this.fromFields);
      b.add("toField", this.toField);
      return b.toString();
    }
  }
  
  public static void main(final String[] args) {
    Person person = new Person();
    person.setName("snow");
    person.setSex("girl");
  }
}
