package cn.com.mx.cms.client;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.common.entity.CommonResultEntity;

import cn.com.mx.cms.dto.platform.RecommendDto;
import cn.com.mx.cms.exception.CmsException;
import cn.com.mx.social.dto.group.vo.GroupInfoVo;
import cn.com.mx.social.group.service.ISocialGroupFacade;

/**
 * Description: 群组
 * 
 * @author duwei
 * @date 2015年11月30日 下午9:12:34
 * @version V1.0
 */
@Slf4j
@Service
public class GroupClient {
	@Autowired
	private ISocialGroupFacade socialGroupFacade;

	/**
	 * @Description: 最热群组
	 * @param dto
	 */
	public GroupInfoVo getSerachGroupId(RecommendDto dto) throws Exception {
		String groupid = dto.getGroupid();
		CommonResultEntity<GroupInfoVo> result = socialGroupFacade.findSerachGroupId(groupid);
		if (result.getCode() != 0) {
			log.error("调用最热群组--群组接口失败id={},msg={}", groupid, result.getMessage());
//			throw new JsonResponseException(result.getMessage());
			throw CmsException.GROUP_INFO_FAILE;
		}
		GroupInfoVo groupInfoVo = result.getBusinessObj();
		return groupInfoVo;
	}
}
