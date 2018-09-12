package com.github.east196.xcode.common;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DefaultResp {
	
	/** 0 成功,非0失败 */
	private int code;
	/** 出错信息，成功则没有该项 */
	private String msg;
	
	public DefaultResp(){}
	
	public DefaultResp(int code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override 
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override 
	public boolean equals(Object other) {
		return EqualsBuilder.reflectionEquals(this, other);
	}

	@Override 
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.DEFAULT_STYLE);
	}
	
}
