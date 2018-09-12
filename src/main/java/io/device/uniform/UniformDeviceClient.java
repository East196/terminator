package io.device.uniform;

import io.device.uniform.req.PoiAllNearReqQuery;
import io.device.uniform.resp.PoiAllNearResp;
import retrofit.RestAdapter;

public class UniformDeviceClient {
	public static void main(String[] args) {
		RestAdapter adapter = new RestAdapter.Builder().setEndpoint("http://localhost:18080")
				.setLogLevel(RestAdapter.LogLevel.FULL).build();
		UniformDeviceHttp http = adapter.create(UniformDeviceHttp.class);
		PoiAllNearReqQuery poiAllNearReqQuery=new PoiAllNearReqQuery(2.1, 1.2, 1, true, true, true, true);
		PoiAllNearResp poiAllNearResp=http.poiAllNearByMap(poiAllNearReqQuery.toQueryMap());
		System.out.println(poiAllNearResp);
	}

}
