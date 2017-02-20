package cn.com.gome.trade.dto.openapi.common;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class CommonSku implements Serializable {
	private static final long serialVersionUID = -4320563021465012717L;
	
	private Long id;                            //sku id
	private String image;						//sku图片
	private List<CommonAttribute> attributes;	//商品销售属性
	private CommonItem item;					//商品信息
	private Integer quantity;					//退还数量
	private Integer price;                      //商品价格
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

}
