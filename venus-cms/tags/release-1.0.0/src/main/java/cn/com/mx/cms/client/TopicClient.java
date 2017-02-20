package cn.com.mx.cms.client;

import lombok.extern.slf4j.Slf4j;
import io.terminus.common.exception.JsonResponseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.common.entity.CommonResultEntity;

import cn.com.mx.cms.dto.platform.RecommendDto;
import cn.com.mx.cms.exception.CmsException;
import cn.com.mx.social.topic.service.ISocialTopicFacade;

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
public class TopicClient {

	/** 话题 */
	@Autowired
	private ISocialTopicFacade socialTopicFacade;

	public Object getGroupTopicInfo(RecommendDto dto) throws Exception {
		String groupid = dto.getGroupid();
		CommonResultEntity<Object> result = socialTopicFacade.getGroupTopicInfo(groupid);

		if (result.getCode() != 0) {
			log.error("调用话题--群组接口失败id={},msg={}", groupid, result.getMessage());
//			throw new JsonResponseException(result.getMessage());
			throw CmsException.TOPIC_INFO_FAILE;
		}
		Object obj = result.getBusinessObj();
		return obj;
	}

}
