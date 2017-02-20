package cn.com.gome.trade.dto.orderlogistics;

import java.io.Serializable;
import java.util.List;

import cn.com.gome.trade.dto.ordercreation.ActivityDto;
import lombok.Data;

@Data
public class OrderDeliveryDetailDto implements Serializable {
	
	private static final long serialVersionUID = 7789593496817950459L;

	private Long id;
    
    private DeliverySkuDto sku;

    private Integer quantity;
    
    //活动信息,type = 1：团购类型   2：跨境商品  3：国美在线电器商品  4：海外购商品
    private List<ActivityDto> activities;

}