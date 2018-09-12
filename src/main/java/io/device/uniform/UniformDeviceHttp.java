package io.device.uniform;

import java.util.Map;

import io.device.uniform.resp.PoiAllNearResp;
import retrofit.http.GET;
import retrofit.http.Query;
import retrofit.http.QueryMap;

public interface UniformDeviceHttp {
	
	/** 查询点位附近的poi信息 */
	@GET("/poi/all/near")
	PoiAllNearResp poiAllNear(
			@Query("lon") double lon,
			@Query("lat") double lat,
			@Query("meters") int meters,
			@Query("hasPlace") boolean hasPlace,
			@Query("hasHouse") boolean hasHouse,
			@Query("hasArea") boolean hasArea,
			@Query("hasBusline") boolean hasBusline
	);
	
	/** 查询点位附近的poi信息 */
	@GET("/poi/all/near")
	PoiAllNearResp poiAllNearByMap(@QueryMap Map<String,Object> queryMap);
	
}
