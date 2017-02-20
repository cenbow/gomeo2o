package cn.com.mx.cms.client;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.common.entity.CommonResultEntity;
import com.gomeo2o.facade.im.entity.ImFriendlistEntity;
import com.gomeo2o.facade.im.entity.ImUserassociationEntity;
import com.gomeo2o.facade.im.service.ImFacade;

import cn.com.mx.cms.dto.platform.RecommendDto;
import cn.com.mx.cms.exception.CmsException;

/**
 * 
 * Description: im
 * 
 * @author duwei
 * @date 2015年11月30日 下午9:01:29
 * @version V1.0
 */
@Slf4j
@Service
public class IMClient {

	@Autowired
	private ImFacade imFacade;

	/**
	 * @Description: 粉丝数
	 * @param dto
	 *            {使用：达人ID}
	 */
	public long getImFansNum(RecommendDto dto) throws Exception {
		long id = getId(dto);

		ImUserassociationEntity imUserassociationEntity = new ImUserassociationEntity();
		imUserassociationEntity.setUserId(String.valueOf(id));
		imUserassociationEntity.setRole(1);
		CommonResultEntity<Long> fanNumObj = imFacade.getImFansNum(imUserassociationEntity);
		if (fanNumObj.getCode() == 0 && fanNumObj.getBusinessObj() != null) {
			return fanNumObj.getBusinessObj();
		} else {
			log.error("方法：getById，会员中的查询当前会员粉丝人数的接口……错误信息：{},错误码：{}", fanNumObj.getMessage(), fanNumObj.getCode());
//			return 0;
			throw CmsException.FANS_NUM_FAILE;
		}
	}

	/**
	 * @Description: 是否需要关注
	 */
	public int isNeedAttention(RecommendDto dto) throws Exception {
		// 关注状态查询
		long id = getId(dto);
		ImFriendlistEntity imFriendlistEntity = new ImFriendlistEntity();
		imFriendlistEntity.setVuserid(String.valueOf(dto.getUserId())); // 发起方id
		imFriendlistEntity.setVuserRole(1); // 发起方角色
		imFriendlistEntity.setImUserId(String.valueOf(id)); // 被关注方Id
		imFriendlistEntity.setUserRole(1); // 被关注方角色
		CommonResultEntity<Boolean> obj = imFacade.isNeedAttention(imFriendlistEntity);
		if (obj.getBusinessObj()) {
			return 0;
		} else {
			return 1;
		}
	}

	private long getId(RecommendDto dto) {
		return dto.getRecommendId() == null ? 0 : dto.getRecommendId();
	}
}
