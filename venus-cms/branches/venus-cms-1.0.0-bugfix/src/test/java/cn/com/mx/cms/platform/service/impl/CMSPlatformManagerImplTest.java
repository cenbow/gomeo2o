package cn.com.mx.cms.platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.gomeo2o.common.entity.CommonResultEntity;

import cn.com.mx.cms.dto.platform.RecommendDto;
import cn.com.mx.cms.platform.service.ICMSPlatformManager;

/**
 * @类注释: 公用辅助类
 * @author: houchangren
 * @date 2015-2-9 下午4:12:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/venus-cms-dubbo-provider.xml", "classpath:/spring/venus-cms-dubbo-consumer.xml" })
public class CMSPlatformManagerImplTest {
	@Autowired
	private ICMSPlatformManager iCMSPlatformManager; 

	@BeforeClass
	public static void before() {

	}
	
	@Test
	public void testFindRecommendsByRecommendType(){
		CommonResultEntity<HashMap<String, Object>> recommendDtos = iCMSPlatformManager.findRecommendsByRecommendType(1);
		int code = recommendDtos.getCode();
		HashMap<String, Object> recommendDtoMap = recommendDtos.getBusinessObj();
		List<RecommendDto> recommendDtoList = (List<RecommendDto>)recommendDtoMap.get("list");
		String title = (String)recommendDtoMap.get("title");
		if(code==0){
			System.out.println("===========================title:"+title);
			for (RecommendDto dto : recommendDtoList) {
				System.out.println(JSON.toJSONString(dto));
			}
		}else {
			System.out.println("调用出错，code："+code + " message:"+recommendDtos.getMessage());
		}
		
	}
	
	@Test
	public void testAddRecommend(){
		List<RecommendDto> dtos = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			RecommendDto dto = new RecommendDto();
			dto.setSn(i);
			dto.setCreateOperator("小A");
			dto.setUpdateOperator("小B");
			dto.setExtendData("{\"shopId\":307,\"image\":\"http://10.125.31.23/v1/img/T16FxTB5dT1R4cSCrK.png\",\"type\":"+i+"}");
			dto.setIsDisabled(0);
			dto.setPictureUrl("picUrl"+i);
			dto.setRecommendType(22);
			dto.setUpdateTime(new Date());
			dto.setCreateTime(new Date());
			dtos.add(dto);
		}
	
		iCMSPlatformManager.addRecommend(dtos, 1);
	}
	
	@Test
	public void testqueryCache(){
//		iCMSPlatformManager.queryCache(KeyUtil.RECOMMEND_KEY);
	}

}
