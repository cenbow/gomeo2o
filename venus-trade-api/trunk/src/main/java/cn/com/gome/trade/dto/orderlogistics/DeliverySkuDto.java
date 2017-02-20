package cn.com.gome.trade.dto.orderlogistics;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import cn.com.gome.trade.dto.common.AttributeDto;

@Data
public class DeliverySkuDto implements Serializable {
	private static final long serialVersionUID = 3023465779568608771L;
	private Long id; 						// sku id
	private String image; 					// 商品图片
	private DeliveryItemDto item;   	    // 商品信息
	private List<AttributeDto> attributes; 	//商品销售属性
	private Integer price;                  // 商品单价
	
    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
