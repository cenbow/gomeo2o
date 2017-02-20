package cn.com.gome.trade.dto.itemdto;


import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import cn.com.gome.trade.dto.common.AttributeDto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @Description TODO 替换原有itemapi中sku
 * @author wangjiatian
 * @date 2016年6月22日 下午4:05:12
 */
@Data
public class Sku implements Serializable{


    /**
	 * 
	 */
	private static final long serialVersionUID = 7565288553648648369L;

	/**
     * ID
     */
    private Long id;

    /**
     * SKU外部ID, 如商家自己的SKU系统ID
     */
    protected String outerId;

    /**
     * 商品ID
     */
    private Long itemId;

    /**
     * 外部 item 编号
     */
    private String outerItemId;

    /**
     * 外部店铺 id
     */
    private String outerShopId;

    /**
     * 图片
     */
    private String image;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String desc;
    
    /**
     * 商品销售属性
     */
    private List<AttributeDto> attributes;

    /**
     * 价格
     */
    @NotNull(message = "sku.price.invalid")
    @Min(value = 1, message = "sku.price.invalid")
    private Integer price;

    /**
     * 属性键名称1
     */
    private String attributeKey1;

    /**
     * 属性键ID1
     */
    private Long attributeKeyId1;

    /**
     * 属性值名称1
     */
    private String attributeName1;

    /**
     * 属性值ID1
     */
    private String attributeValue1;

    /**
     * 属性键名称2
     */
    private String attributeKey2;

    /**
     * 属性键ID2
     */
    private Long attributeKeyId2;

    /**
     * 属性值名称2
     */
    private String attributeName2;

    /**
     * 属性值ID2
     */
    private String attributeValue2;

    /**
     * 库存
     */
    @NotNull(message = "sku.stock.quantity.invalid")
    @Min(value = 0, message = "sku.stock.quantity.invalid")
    private Integer stockQuantity;              //库存

    /**
     * sku额外信息
     */
    private String extra;

    private Date createdAt;

    private Date updatedAt;

    /**
     * Redis中SKU的属性id集合KEY
     * @param skuId SKU.id
     * @return skus:{skuId}:attributes
     */
    public static final String keyOfAttributes(Long skuId){
        return "skus:" + skuId + ":attributes";
    }
}
