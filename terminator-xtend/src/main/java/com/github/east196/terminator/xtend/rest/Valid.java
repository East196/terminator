package com.github.east196.terminator.xtend.rest;

import javax.annotation.Generated;
import lombok.Data;
import org.boon.Boon;

@Data
@SuppressWarnings("all")
@Generated("org.eclipse.xtend.core.compiler.XtendGenerator")
public class Valid {
  private boolean r = false;
  
  private String v;
  
  public static Valid from(final String validStr) {
    return Boon.<Valid>fromJson(validStr, Valid.class);
  }
  
  public boolean getRequried() {
    return this.r;
  }
  
  public String getValid() {
    return this.v;
  }
}
