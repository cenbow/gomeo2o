package cn.com.gome.trade.dto.openapi.order;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
public class Sku implements Serializable {
	private static final long serialVersionUID = 3023465779568608771L;
	private Long id; 						//sku id
	private String image; 					//商品图片
	private List<Attribute> attributes; 	//商品销售属性
	private Item item;   				//商品信息
    private Integer price; 					//价格
    
    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
