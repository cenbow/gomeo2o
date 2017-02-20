package cn.com.mx.webapi.servlet.demo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;

import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;

import cn.com.mx.webapi.common.exceptions.code.C422Exception;
import cn.com.mx.webapi.common.servlet.BaseResource;
import cn.com.mx.webapi.common.utils.ResourceParameters;

@Controller
@WebServlet("/demo/nothing")
public class NothingResource extends BaseResource {
	private static final long serialVersionUID = 1L;

	@Override
	public Map<String, Object> get(ResourceParameters resourceParameters) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("theThing", "Nothing");
		return data;
	}
	
	@Override
	public Map<String, Object> put(ResourceParameters resourceParameters, JSONObject body)  {
		if (!body.getString("theThing").equals("Nothing")) {
			throw new C422Exception(ExceptionMessage.ONLY_NOTHING_THETHING_CAN_BE);
		}
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("theThing", "Nothing");
		return data;
	}
	
	public Map<String, Object> post(ResourceParameters resourceParameters, JSONObject body)  {
		return put(resourceParameters, body);
	}
}
