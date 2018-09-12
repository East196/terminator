package io.device.uniform.resp;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PoiAllNearResp {
	
	/** 0 成功,非0失败 */
	private int code;
	/** 出错信息，成功则没有该项 */
	private String msg;
	/** 返回的具体数据 */
	private String data;
	
	public PoiAllNearResp(){}
	
	public PoiAllNearResp(int code,String msg,String data){
		this.code=code;
		this.msg=msg;
		this.data=data;
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
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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
