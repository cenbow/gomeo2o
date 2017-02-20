package cn.com.gome.trade.service.openapi;

import io.terminus.pampas.common.Response;
import cn.com.gome.trade.dto.openapi.common.CommonBase;
import cn.com.gome.trade.dto.openapi.deliverylogistics.DeliveryLogisticsReq;
import cn.com.gome.trade.dto.openapi.deliverylogistics.DeliveryLogisticsResp;
import cn.com.gome.trade.dto.openapi.orderdelivery.OrderDeliveryReq;
import cn.com.gome.trade.dto.openapi.orderdelivery.OrderDeliveryResp;

public interface GomeOpenApiOrderWriteService {
	
	Response<OrderDeliveryResp> createOrderDelivery(CommonBase base, OrderDeliveryReq orderDeliveryReq);
	
	Response<DeliveryLogisticsResp> createDeliveryLogistics(CommonBase base, DeliveryLogisticsReq deliveryLogisticsReq);
}
