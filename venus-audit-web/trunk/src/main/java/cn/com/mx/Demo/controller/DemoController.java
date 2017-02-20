package cn.com.mx.Demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



import cn.com.mx.Demo.service.impl.DemoServiceImpl;


@Controller
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	DemoServiceImpl demoService;

	/**
	 * 
	 * @Description 查找Demo 
	 * @author wangchangye
	 * @date 2016年1月27日 下午4:19:57
	 * @return
	 */
	 
	@RequestMapping("/find")  
    public String findFromDatabase(){  
        //mongo查找
        String mongoResult = demoService.findFromMongo();
        System.out.println("mongo查找"+mongoResult);
        //redis查找
        String redisResult = demoService.findFromRedis();
        System.out.println("redis查找"+redisResult);
        return "index";
    }  
	
	
	@RequestMapping("/logindemo")
	public String login(){
		//return "index";
		return  "group";
	}
	
	@RequestMapping("/test")
	public String test(HttpServletRequest request,Model model){
		model.addAttribute("aaa",111);
		//return "index";
		return  "test";
	}
	
	
	
	
	
}// end of class
