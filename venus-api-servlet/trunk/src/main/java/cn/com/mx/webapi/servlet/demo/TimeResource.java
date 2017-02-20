package cn.com.mx.webapi.servlet.demo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.annotation.WebServlet;
import org.springframework.stereotype.Controller;
import cn.com.mx.webapi.common.servlet.BaseResource;
import cn.com.mx.webapi.common.utils.ResourceParameters;

@Controller
@WebServlet("/demo/time")
public class TimeResource extends BaseResource {
	
	private static final long serialVersionUID = 8649068082426891507L;

	@Override
	public Map<String, Object> get(ResourceParameters resourceParameters) {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("timestamp", new Date().getTime());
		return data;
	}

}
