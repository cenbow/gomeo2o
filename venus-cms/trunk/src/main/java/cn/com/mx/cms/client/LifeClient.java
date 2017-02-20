package cn.com.mx.cms.client;

import java.util.HashMap;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import io.terminus.common.exception.JsonResponseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.facade.shb.entity.SNSPostEntity;
import com.gomeo2o.facade.shb.enums.ShbInfoTypeEnum;
import com.gomeo2o.facade.shb.service.ShbInfoFacade;
import com.gomeo2o.facade.shb.service.ShbManagerFacade;

import cn.com.mx.cms.dto.platform.RecommendDto;
import cn.com.mx.cms.exception.CmsException;

/**
 * 
 * Description: 商品客户端
 * 
 * @author duwei
 * @date 2015年11月30日 下午9:01:29
 * @version V1.0
 */
@Slf4j
@Service
public class LifeClient {

	@Autowired
	private ShbManagerFacade shbManagerFacade;

	@Autowired
	private ShbInfoFacade shbInfoFacade;

	/**
	 * @Description: 根据帖子id获取帖子信息
	 */
	public SNSPostEntity findPostInfoById(long postId) throws Exception {
		CommonResultEntity<SNSPostEntity> result = shbManagerFacade.findPostInfoById(postId);
		if (result.getCode() != 0) {
			log.error("调用爱生活图片接口失败id={},msg={}", postId, result.getMessage());
//			throw new JsonResponseException(result.getMessage());
			throw CmsException.PICTRUE_INFO_FAILE;
		}
		SNSPostEntity postEntity = result.getBusinessObj();
		return postEntity;
	}

	/**
	 * @Description: 查询帖子动态列表
	 */
	public List<SNSPostEntity> findPostInfoList(long postId) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("numPerPage", 1);
		paramMap.put("type", ShbInfoTypeEnum.AISHENGHUO.getValue());
		paramMap.put("postId", postId);
		CommonResultEntity<List<SNSPostEntity>> postResult = shbInfoFacade.findPostInfoList(paramMap);
		if (postResult.getCode() != 0) {
			log.error("调用帖子动态接口失败id={},msg={}", postId, postResult.getMessage());
//			throw new JsonResponseException(postResult.getMessage());
			throw CmsException.POST_INFO_FAILE;
		}
		return postResult.getBusinessObj();
	}

	
	/**
	 * @Description: 通过用户获取postId
	 */
	public List<SNSPostEntity> getPostIdByUserId(RecommendDto dto) throws Exception {
		long id = getId(dto);
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("numPerPage", 2);
		paramMap.put("type", ShbInfoTypeEnum.AISHENGHUO.getValue());
		paramMap.put("userId", id);
		CommonResultEntity<List<SNSPostEntity>> postResult = shbInfoFacade.findPostInfoList(paramMap);
		if (postResult.getCode() != 0) {
			log.error("调用帖子动态接口失败id={},msg={}", id, postResult.getMessage());
//			throw new JsonResponseException(postResult.getMessage());
			throw CmsException.POSTID_INFO_FAILE;
		}
		return postResult.getBusinessObj();
	}
	private long getId(RecommendDto dto) {
		return dto.getRecommendId() == null ? 0 : dto.getRecommendId();
	}

}
