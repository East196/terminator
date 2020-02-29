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
public class Project {
  private String id;
  
  private String name;
  
  private String label;
  
  private String path;
  
  private String root;
  
  private String language;
  
  private String port;
  
  private String version;
  
  private String config;
  
  private String doc;
  
  private String webPath;
  
  private String webRoot;
  
  private String androidPath;
  
  private String androidRoot;
  
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
  public String getPath() {
    return this.path;
  }
  
  public void setPath(final String path) {
    this.path = path;
  }
  
  @Pure
  public String getRoot() {
    return this.root;
  }
  
  public void setRoot(final String root) {
    this.root = root;
  }
  
  @Pure
  public String getLanguage() {
    return this.language;
  }
  
  public void setLanguage(final String language) {
    this.language = language;
  }
  
  @Pure
  public String getPort() {
    return this.port;
  }
  
  public void setPort(final String port) {
    this.port = port;
  }
  
  @Pure
  public String getVersion() {
    return this.version;
  }
  
  public void setVersion(final String version) {
    this.version = version;
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
  public String getWebPath() {
    return this.webPath;
  }
  
  public void setWebPath(final String webPath) {
    this.webPath = webPath;
  }
  
  @Pure
  public String getWebRoot() {
    return this.webRoot;
  }
  
  public void setWebRoot(final String webRoot) {
    this.webRoot = webRoot;
  }
  
  @Pure
  public String getAndroidPath() {
    return this.androidPath;
  }
  
  public void setAndroidPath(final String androidPath) {
    this.androidPath = androidPath;
  }
  
  @Pure
  public String getAndroidRoot() {
    return this.androidRoot;
  }
  
  public void setAndroidRoot(final String androidRoot) {
    this.androidRoot = androidRoot;
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
    Project other = (Project) obj;
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
    if (this.path == null) {
      if (other.path != null)
        return false;
    } else if (!this.path.equals(other.path))
      return false;
    if (this.root == null) {
      if (other.root != null)
        return false;
    } else if (!this.root.equals(other.root))
      return false;
    if (this.language == null) {
      if (other.language != null)
        return false;
    } else if (!this.language.equals(other.language))
      return false;
    if (this.port == null) {
      if (other.port != null)
        return false;
    } else if (!this.port.equals(other.port))
      return false;
    if (this.version == null) {
      if (other.version != null)
        return false;
    } else if (!this.version.equals(other.version))
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
    if (this.webPath == null) {
      if (other.webPath != null)
        return false;
    } else if (!this.webPath.equals(other.webPath))
      return false;
    if (this.webRoot == null) {
      if (other.webRoot != null)
        return false;
    } else if (!this.webRoot.equals(other.webRoot))
      return false;
    if (this.androidPath == null) {
      if (other.androidPath != null)
        return false;
    } else if (!this.androidPath.equals(other.androidPath))
      return false;
    if (this.androidRoot == null) {
      if (other.androidRoot != null)
        return false;
    } else if (!this.androidRoot.equals(other.androidRoot))
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
    result = prime * result + ((this.path== null) ? 0 : this.path.hashCode());
    result = prime * result + ((this.root== null) ? 0 : this.root.hashCode());
    result = prime * result + ((this.language== null) ? 0 : this.language.hashCode());
    result = prime * result + ((this.port== null) ? 0 : this.port.hashCode());
    result = prime * result + ((this.version== null) ? 0 : this.version.hashCode());
    result = prime * result + ((this.config== null) ? 0 : this.config.hashCode());
    result = prime * result + ((this.doc== null) ? 0 : this.doc.hashCode());
    result = prime * result + ((this.webPath== null) ? 0 : this.webPath.hashCode());
    result = prime * result + ((this.webRoot== null) ? 0 : this.webRoot.hashCode());
    result = prime * result + ((this.androidPath== null) ? 0 : this.androidPath.hashCode());
    result = prime * result + ((this.androidRoot== null) ? 0 : this.androidRoot.hashCode());
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
    b.add("path", this.path);
    b.add("root", this.root);
    b.add("language", this.language);
    b.add("port", this.port);
    b.add("version", this.version);
    b.add("config", this.config);
    b.add("doc", this.doc);
    b.add("webPath", this.webPath);
    b.add("webRoot", this.webRoot);
    b.add("androidPath", this.androidPath);
    b.add("androidRoot", this.androidRoot);
    return b.toString();
  }
}
