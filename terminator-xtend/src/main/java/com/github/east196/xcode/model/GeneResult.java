package com.github.east196.xcode.model;

import com.github.east196.xcode.bot.Bots;
import javax.annotation.Generated;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.EqualsHashCode;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Accessors
@EqualsHashCode
@ToString(singleLine = true)
@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class GeneResult {
  private CharSequence content;
  
  private CharSequence path;
  
  public GeneResult(final CharSequence content, final CharSequence path) {
    this.content = content;
    this.path = path;
  }
  
  public void copy() {
    if ((StringExtensions.isNullOrEmpty(this.content.toString()) || StringExtensions.isNullOrEmpty(this.path.toString()))) {
      InputOutput.<String>println("content or path is null or empty!");
      return;
    }
    String _string = this.path.toString();
    Bots.copy(this.content, _string);
  }
  
  @Pure
  public CharSequence getContent() {
    return this.content;
  }
  
  public void setContent(final CharSequence content) {
    this.content = content;
  }
  
  @Pure
  public CharSequence getPath() {
    return this.path;
  }
  
  public void setPath(final CharSequence path) {
    this.path = path;
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
    GeneResult other = (GeneResult) obj;
    if (this.content == null) {
      if (other.content != null)
        return false;
    } else if (!this.content.equals(other.content))
      return false;
    if (this.path == null) {
      if (other.path != null)
        return false;
    } else if (!this.path.equals(other.path))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.content== null) ? 0 : this.content.hashCode());
    result = prime * result + ((this.path== null) ? 0 : this.path.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.singleLine();
    b.add("content", this.content);
    b.add("path", this.path);
    return b.toString();
  }
}
