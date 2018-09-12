package io.device.uniform.req;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PoiAllNearReqQuery {
	
	/** 经度 */
	private double lon;
	/** 纬度 */
	private double lat;
	/** 查询范围 */
	private int meters;
	/** 是否查询场景信息 */
	private boolean hasPlace;
	/** 是否查询房产信息 */
	private boolean hasHouse;
	/** 是否查询商圈 */
	private boolean hasArea;
	/** 是否查询公交线路站点 */
	private boolean hasBusline;
	
	public Map<String,Object> toQueryMap(){
        Map<String,Object> queryMap=new HashMap<>();
		queryMap.put("lon",lon);
		queryMap.put("lat",lat);
		queryMap.put("meters",meters);
		queryMap.put("hasPlace",hasPlace);
		queryMap.put("hasHouse",hasHouse);
		queryMap.put("hasArea",hasArea);
		queryMap.put("hasBusline",hasBusline);
        return queryMap;
	}
	
	
	public PoiAllNearReqQuery(){}
	
	public PoiAllNearReqQuery(double lon,double lat,int meters,boolean hasPlace,boolean hasHouse,boolean hasArea,boolean hasBusline){
		this.lon=lon;
		this.lat=lat;
		this.meters=meters;
		this.hasPlace=hasPlace;
		this.hasHouse=hasHouse;
		this.hasArea=hasArea;
		this.hasBusline=hasBusline;
	}
	
	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}
	
	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}
	
	public int getMeters() {
		return meters;
	}

	public void setMeters(int meters) {
		this.meters = meters;
	}
	
	public boolean getHasPlace() {
		return hasPlace;
	}

	public void setHasPlace(boolean hasPlace) {
		this.hasPlace = hasPlace;
	}
	
	public boolean getHasHouse() {
		return hasHouse;
	}

	public void setHasHouse(boolean hasHouse) {
		this.hasHouse = hasHouse;
	}
	
	public boolean getHasArea() {
		return hasArea;
	}

	public void setHasArea(boolean hasArea) {
		this.hasArea = hasArea;
	}
	
	public boolean getHasBusline() {
		return hasBusline;
	}

	public void setHasBusline(boolean hasBusline) {
		this.hasBusline = hasBusline;
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
