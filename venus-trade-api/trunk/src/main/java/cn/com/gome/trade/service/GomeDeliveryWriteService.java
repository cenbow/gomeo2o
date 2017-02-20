package cn.com.gome.trade.service;

import io.terminus.pampas.common.Response;
import cn.com.gome.trade.dto.common.CommonBase;
import cn.com.gome.trade.dto.deliveryrejection.DeliveryRejectionWarehousingReq;
import cn.com.gome.trade.dto.sellerDelivery.SellerDeliveryReq;


/**
 * 配送单改造service类
 * @author andybin
 * @createDate 2016-11-24 11:33
 */
public interface GomeDeliveryWriteService {
	
	Response<Boolean> wareHouseForRejection(CommonBase base, DeliveryRejectionWarehousingReq deliveryRejectionWarehousingReq);
	
	Response<Boolean> sellerDelivery(CommonBase base, SellerDeliveryReq sellerDeliveryReq);
}
