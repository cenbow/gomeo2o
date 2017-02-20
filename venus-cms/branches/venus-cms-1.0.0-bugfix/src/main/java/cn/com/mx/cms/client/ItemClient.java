package cn.com.mx.cms.client;

import lombok.extern.slf4j.Slf4j;
import io.terminus.common.exception.JsonResponseException;
import io.terminus.ecp.item.dto.FullItem;
import io.terminus.ecp.item.dto.ItemFullDetail;
import io.terminus.ecp.item.model.Item;
import io.terminus.ecp.item.service.ItemReadService;
import io.terminus.pampas.common.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.terminus.ecp.item.model.Item.*;
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
public class ItemClient {

	@Autowired
	private ItemReadService itemReadService;

	/**
	 * @Description: 根据id查找商品
	 */
	public Item findItemById(RecommendDto dto) throws Exception {
		long id = getItemId(dto);
		Response<Item> itemR = itemReadService.findItemById(id);
		if (!itemR.isSuccess()) {
			log.error("调用普通--商品接口失败id={},msg={}", id, itemR.getError());
			throw CmsException.ITEM_FAILE;
		}
		Item item = itemR.getResult();
		if(item.getStatus() != Status.ON_SHELF.value()){
			throw CmsException.ITEM_FAILE;
		}
		return item;
	}

	/**
	 * 
	 * @Description: 查找商品的全部信息
	 * @param dto
	 */
	public ItemFullDetail findItemFullDetailById(RecommendDto dto) throws Exception {
		long id = getId(dto);
		Response<ItemFullDetail> itemR = itemReadService.findItemFullDetailById(id);
		if (!itemR.isSuccess()) {
			log.error("调用精品--商品接口失败id={},msg={}", id, itemR.getError());
			throw CmsException.ITEM_FAILE;
		}
		ItemFullDetail fulldetail = itemR.getResult();
		FullItem fi = fulldetail.getFullItem();
		Item item = fi.getItem();
		if(item.getStatus() != Status.ON_SHELF.value()){
			throw CmsException.ITEM_FAILE;
		}
		return fulldetail;
	}

	/**
	 * 查询某商品的上架商品数
	 */
	public long countOnShelfItemByShopId(RecommendDto dto) throws Exception {
		long id = getId(dto);
		Response<Long> idresult = itemReadService.countOnShelfItemByShopId(id);
		;
		if (!idresult.isSuccess()) {
			log.error("调用商品--上架商品数接口失败id={},msg={}", id, idresult.getError());
			throw CmsException.SHOP_ITEMNUM_FAILE;
		}
		long num = idresult.getResult();
		return num;
	}

	private long getId(RecommendDto dto) {
		return dto.getRecommendId() == null ? 0 : dto.getRecommendId();
	}

	private long getItemId(RecommendDto dto) {
		return dto.getItemid();
	}
}
