package cn.com.mx.cms.client;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.common.entity.CommonResultEntity;

import cn.com.gome.user.model.MemberExpertInfo;
import cn.com.gome.user.service.UserBaseInfoFacade;
import cn.com.mx.cms.dto.platform.RecommendDto;
import cn.com.mx.cms.exception.CmsException;

/**
 * Description: 达人
 * 
 * @author duwei
 * @date 2015年11月30日 下午9:12:34
 * @version V1.0
 */
@Slf4j
@Service
public class ExpertClient {
	
	@Autowired
	private UserBaseInfoFacade infoFacade;

	/**
	 * @Description: 达人相关信息 
	 */
	public MemberExpertInfo queryExpertInfoByMemberId(RecommendDto dto) throws Exception {
		long id = dto.getRecommendId() == null ? 0 : dto.getRecommendId();
		CommonResultEntity<MemberExpertInfo> result = infoFacade.queryExpertInfoByMemberId(id);
		if (result.getCode() != 0) {
			log.error("调用达人--达人信息接口失败id={},msg={}", id, result.getMessage());
//			throw new JsonResponseException(result.getMessage());
			throw CmsException.EXPERT_INFO_FAILE;
		}
		return result.getBusinessObj();
	}
}
