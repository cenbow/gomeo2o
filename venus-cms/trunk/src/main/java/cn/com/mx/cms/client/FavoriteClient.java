package cn.com.mx.cms.client;

import lombok.extern.slf4j.Slf4j;
import io.terminus.common.exception.JsonResponseException;
import io.terminus.ecp.item.model.Item;
import io.terminus.ecp.item.service.ItemReadService;
import io.terminus.pampas.common.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomeo2o.common.entity.CommonResultEntity;

import cn.com.gome.user.service.MemberGoodsFavoriteFacade;
import cn.com.gome.user.service.MemberShopFavoriteFacade;
import cn.com.mx.cms.dto.platform.ItemDto;
import cn.com.mx.cms.dto.platform.RecommendDto;
import cn.com.mx.cms.exception.CmsException;

/**
 * 
 * Description: 收藏客户端
 * 
 * @author duwei
 * @date 2015年11月30日 下午9:01:29
 * @version V1.0
 */
@Slf4j
@Service
public class FavoriteClient {

	/** 商品收藏服务接口 */
	@Autowired
	private MemberGoodsFavoriteFacade memberGoodsFavoriteFacade;

	@Autowired
	private MemberShopFavoriteFacade memberShopFavoriteFacade; // 店铺收藏服务接口

	public ItemDto countByProductId(RecommendDto dto, Item item, ItemDto itemDto) throws Exception {
		long id = getId(dto);
		CommonResultEntity<Long> resultnum = memberGoodsFavoriteFacade.countByProductId(item.getShopId(),
				item.getId());
		// 将收藏数量加入总对象
		if (resultnum.getCode() != 0) {
			log.error("调用收藏数接口失败id={},msg={}", id, resultnum.getMessage());
//			throw new JsonResponseException(resultnum.getMessage());
			throw CmsException.FAVORITE_ITEMNUM_FAILE;
		}
		itemDto.setCollectNum(resultnum.getBusinessObj());
		return itemDto;
	}

	/**
	 * @Description: 店铺被收藏统计
	 */
	public long countByShopId(RecommendDto dto) throws Exception {
		long id = getId(dto);
		CommonResultEntity<Long> resultnum = memberShopFavoriteFacade.countByShopId(id);
		if (resultnum.getCode() != 0) {
			log.error("调用店铺被收藏统计接口失败id={},msg={}", id, resultnum.getMessage());
//			throw new JsonResponseException(resultnum.getMessage());
			throw CmsException.FAVORITE_SHOPNUM_FAILE;
		}
		return resultnum.getBusinessObj();
	}

	private long getId(RecommendDto dto) {
		return dto.getRecommendId() == null ? 0 : dto.getRecommendId();
	}
}
