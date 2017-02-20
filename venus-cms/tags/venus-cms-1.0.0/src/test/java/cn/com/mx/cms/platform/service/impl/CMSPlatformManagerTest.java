package cn.com.mx.cms.platform.service.impl;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mortbay.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.mx.cms.constants.BaseConstants;
import cn.com.mx.cms.dto.platform.RecommendDto;
import cn.com.mx.cms.enums.RecommendType;
import cn.com.mx.cms.platform.service.ICMSPlatformManager;
import cn.com.mx.cms.utils.JsonUtil;

import com.gomeo2o.common.entity.CommonResultEntity;

/**
 * Description: 推荐位管理测试
 * 
 * @author duwei
 * @date 2015年11月30日 下午6:23:36
 * @version V1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/venus-cms-dubbo-provider.xml",
		"classpath:/spring/venus-cms-dubbo-consumer.xml" })
public class CMSPlatformManagerTest extends TestCase {

	@Autowired
	private ICMSPlatformManager manager;

	/**
	 * @Description: 查询第三方接口信息--普通--商品?????????????????????????
	 */
	@Test
	public void testFindThirdAgentById1() {
		RecommendDto dto = new RecommendDto();
		dto.setRecommendType(RecommendType.commonRec.getCode());
		dto.setType(BaseConstants.REC_COMMON_ITEM_TYPE);
		dto.setRecommendId(113);
		CommonResultEntity<String> result = manager.findThirdAgentById(dto);
		if (result.getCode() != 0) {
			Log.info(result.getMessage());
		}
		Log.info("返回结果：" + JsonUtil.toJson(result.getBusinessObj()));
		/*
		 * "{ \"bitMark\": 3, \"brandId\": 1, \"brandName\": \"麦博音箱\",
		 * \"createdAt\": 1436782015000, \"distributable\": false, \"id\": 123,
		 * \"mainImage\": \"http:
		 * //10.128.31.28/v1/img/T1JtYTBmDT1RXrhCrK.jpg\", \"name\": \"麦博音箱01\",
		 * \"offShelfAt\": 1448334855000, \"onShelfAt\": 1442890140000,
		 * \"originPrice\": 28000, \"price\": 26000, \"saleQuantity\": 113,
		 * \"shopId\": 5, \"shopName\": \"王琦的小店\", \"spuId\": 69, \"status\":
		 * -2, \"stockQuantity\": 87, \"type\": 1, \"updatedAt\": 1448618951000,
		 * \"userId\": 5 }"
		 * 
		 * 返回结果：
		 * "{\"image\":\"http://10.128.31.28/v1/img/T1JtYTBmDT1RXrhCrK.jpg\",\"productId\":123,\"shopId\":0,\"type\":0,\"url\":\"\"}"
		 */
	}
	
	/**
	 * @Description: 查询第三方接口信息--普通2--商铺0000000000000000000000000
	 */
	@Test
	public void testFindThirdAgentById5() {
		RecommendDto dto = new RecommendDto();
		dto.setRecommendType(RecommendType.superRebateRec.getCode());
		dto.setType(BaseConstants.REC_COMMON_SHOP_TYPE);
		dto.setRecommendId(5);
		CommonResultEntity<String> result = manager.findThirdAgentById(dto);
		if (result.getCode() != 0) {
			Log.info(result.getMessage());
		}
		Log.info("返回结果：" + JsonUtil.toJson(result.getBusinessObj()));
		//返回结果："{\"createTime\":1436776172000,\"displayTemplate\":\"0\",\"fxCount\":6,\"fxMoney\":3300,\"isDelete\":0,\"popId\":\"5\",\"shengId\":0,\"shiId\":0,\"updateTime\":1448876970000,\"userId\":\"5\",\"userName\":\"王琦\",\"version\":0,\"vshopArea\":\"中国北京市朝阳区麦子店街道远洋新干线霄云路35号\",\"vshopBgimage\":\"0\",\"vshopDesc\":\"张义航测试描述\",\"vshopIcon\":\"http://111.204.217.3:8086/v1/img/T1ZyxTBCCT1RXrhCrK.jpg\",\"vshopId\":5,\"vshopName\":\"王琦的小店\",\"vshopStatus\":0,\"vshopType\":\"2\",\"vshopUrl\":\"http://igome.com/5/2\",\"vshopX\":5,\"vshopY\":5,\"xianId\":0}"

	}



	/**
	 * @Description: 查询第三方接口信息--最热群组 0000000000000000000000000000000
	 */
	@Test
	public void testFindThirdAgentById2() {
		RecommendDto dto = new RecommendDto();
		dto.setRecommendType(RecommendType.groupRec.getCode());
//		dto.setType(BaseConstants.REC_HOT_GROUP_TYPE);
		dto.setGroupid("1448620338394247");
		CommonResultEntity<String> result = manager.findThirdAgentById(dto);
		if (result.getCode() != 0) {
			Log.info(result.getMessage());
		}
		Log.info("返回结果：" + JsonUtil.toJson(result.getBusinessObj()));
	}

	/**
	 * @Description: 查询第三方接口信息--话题-群组0000000000000000
	 */
	@Test
	public void testFindThirdAgentById3() {
		RecommendDto dto = new RecommendDto();
		dto.setRecommendType(RecommendType.topicRec.getCode());
//		dto.setType(BaseConstants.REC_TOPIC_GROUP_TYPE);
		dto.setGroupid("564da61c8c83eb3391cc8413");
		CommonResultEntity<String> result = manager.findThirdAgentById(dto);
		if (result.getCode() != 0) {
			Log.info(result.getMessage());
		}
		Log.info("返回结果：" + JsonUtil.toJson(result.getBusinessObj()));
		// {"businessObj":{"content":"aaaa","groupId":"144792868967965","groupName":"mojianli>","repNum":0,"topicName":"abc","topicPic":"1"},"code":0,"message":"成功"}
		//返回结果："{\"commentNum\":0,\"groupId\":\"144792868967965\",\"groupName\":\"mojianli>\",\"image\":[\"1\"],\"lookedNum\":0,\"topicContent\":\"aaaa\",\"topicId\":\"564da61c8c83eb3391cc8413\",\"topicName\":\"abc\"}"

	}

	/**
	 * @Description: 查询第三方接口信息--精品--商品4  000000000000000000000000000
	 * 表ecp_item_details中有图片信息
	 */
	@Test
	public void testFindThirdAgentById4() {
		RecommendDto dto = new RecommendDto();
		dto.setRecommendType(RecommendType.boutiqueRec.getCode());
		dto.setRecommendId(728);//608
		CommonResultEntity<String> result = manager.findThirdAgentById(dto);
		if (result.getCode() != 0) {
			Log.info(result.getMessage());
		}
		Log.info("返回结果：" + JsonUtil.toJson(result.getBusinessObj()));
		// "{\"collectNum\":0,\"mainImage\":\"http://10.128.31.28/v1/img/T1JtYTBmDT1RXrhCrK.jpg\",\"name\":\"麦博音箱01\",\"price\":26000,\"saleQuantity\":113,\"shopId\":5,\"shopName\":\"王琦的小店\"}"

	}
	

	
	/**
	 * @Description: 查询第三方接口信息--达人动态 0000000000000000000000000000000
	 */
	@Test
	public void testFindThirdAgentById6() {
		RecommendDto dto = new RecommendDto();
		dto.setRecommendType(RecommendType.expertDynRec.getCode());
		dto.setRecommendId(227);//
		CommonResultEntity<String> result = manager.findThirdAgentById(dto);
		if (result.getCode() != 0) {
			Log.info(result.getMessage());
		}
		Log.info("返回结果：" + JsonUtil.toJson(result.getBusinessObj()));
		//返回结果："{\"createTime\":1436776172000,\"displayTemplate\":\"0\",\"fxCount\":6,\"fxMoney\":3300,\"isDelete\":0,\"popId\":\"5\",\"shengId\":0,\"shiId\":0,\"updateTime\":1448876970000,\"userId\":\"5\",\"userName\":\"王琦\",\"version\":0,\"vshopArea\":\"中国北京市朝阳区麦子店街道远洋新干线霄云路35号\",\"vshopBgimage\":\"0\",\"vshopDesc\":\"张义航测试描述\",\"vshopIcon\":\"http://111.204.217.3:8086/v1/img/T1ZyxTBCCT1RXrhCrK.jpg\",\"vshopId\":5,\"vshopName\":\"王琦的小店\",\"vshopStatus\":0,\"vshopType\":\"2\",\"vshopUrl\":\"http://igome.com/5/2\",\"vshopX\":5,\"vshopY\":5,\"xianId\":0}"

	}
	
	/**
	 * @Description: 查询第三方接口信息--精选店铺 0000000000000000000000000000000000000000
	 */
	@Test
	public void testFindThirdAgentById7() {
		RecommendDto dto = new RecommendDto();
		dto.setRecommendType(RecommendType.shopRec.getCode());
//		dto.setType(BaseConstants.REC_EXCELLENT_SHOP_TYPE);
		dto.setRecommendId(3);//12
		CommonResultEntity<String> result = manager.findThirdAgentById(dto);
		if (result.getCode() != 0) {
			Log.info(result.getMessage());
		}
		Log.info("返回结果：" + JsonUtil.toJson(result.getBusinessObj()));
		//返回结果："{\"createTime\":1436776172000,\"displayTemplate\":\"0\",\"fxCount\":6,\"fxMoney\":3300,\"isDelete\":0,\"popId\":\"5\",\"shengId\":0,\"shiId\":0,\"updateTime\":1448876970000,\"userId\":\"5\",\"userName\":\"王琦\",\"version\":0,\"vshopArea\":\"中国北京市朝阳区麦子店街道远洋新干线霄云路35号\",\"vshopBgimage\":\"0\",\"vshopDesc\":\"张义航测试描述\",\"vshopIcon\":\"http://111.204.217.3:8086/v1/img/T1ZyxTBCCT1RXrhCrK.jpg\",\"vshopId\":5,\"vshopName\":\"王琦的小店\",\"vshopStatus\":0,\"vshopType\":\"2\",\"vshopUrl\":\"http://igome.com/5/2\",\"vshopX\":5,\"vshopY\":5,\"xianId\":0}"

	}
	
	/**
	 * @Description: 查询第三方接口信息--达人推荐  0000000000000000000000000000
	 */
	@Test
	public void testFindThirdAgentById8() {
		RecommendDto dto = new RecommendDto();
		dto.setRecommendType(RecommendType.expertRec.getCode());
//		dto.setType(BaseConstants.REC_EXPERT_LOVELIFE_TYPE);
		dto.setRecommendId(35);
		CommonResultEntity<String> result = manager.findThirdAgentById(dto);
		if (result.getCode() != 0) {
			Log.info(result.getMessage());
		}
		Log.info("返回结果：" + JsonUtil.toJson(result.getBusinessObj()));
		//返回结果："{\"createTime\":1436776172000,\"displayTemplate\":\"0\",\"fxCount\":6,\"fxMoney\":3300,\"isDelete\":0,\"popId\":\"5\",\"shengId\":0,\"shiId\":0,\"updateTime\":1448876970000,\"userId\":\"5\",\"userName\":\"王琦\",\"version\":0,\"vshopArea\":\"中国北京市朝阳区麦子店街道远洋新干线霄云路35号\",\"vshopBgimage\":\"0\",\"vshopDesc\":\"张义航测试描述\",\"vshopIcon\":\"http://111.204.217.3:8086/v1/img/T1ZyxTBCCT1RXrhCrK.jpg\",\"vshopId\":5,\"vshopName\":\"王琦的小店\",\"vshopStatus\":0,\"vshopType\":\"2\",\"vshopUrl\":\"http://igome.com/5/2\",\"vshopX\":5,\"vshopY\":5,\"xianId\":0}"

	}
}
