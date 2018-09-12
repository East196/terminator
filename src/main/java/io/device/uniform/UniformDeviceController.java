package io.device.uniform;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.device.uniform.req.PoiAllNearReqQuery;
import io.device.uniform.resp.PoiAllNearResp;

@RestController		
public class UniformDeviceController {
	
	/** 查询点位附近的poi信息 */
	@RequestMapping(value = "/poi/all/near", method = RequestMethod.GET)
	PoiAllNearResp poiAllNear(PoiAllNearReqQuery poiAllNearReqQuery) {
		System.out.println(poiAllNearReqQuery);
		return new PoiAllNearResp();
	}
	
	
}
