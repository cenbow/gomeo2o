package cn.com.gome.trade.dto.itemdto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;
import io.terminus.common.model.Indexable;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @Description TODO 将原有的itemapi中item依赖替换成此依赖
 * @author wangjiatian
 * @date 2016年6月22日 下午3:58:00
 */
@Data
public class Item implements Serializable, Indexable {


    /**
	 * 
	 */
	private static final long serialVersionUID = -5189913154487382428L;

	/**
     * ID
     */
    private Long id;

    /**
     * 外部 item 编号
     */
    private String outerItemId;

    /**
     * SPU ID
     * @see io.terminus.ecp.category.model.Spu
     */
    @NotNull(message = "spu.id.invalid")
    @Min(value = 1L, message = "spu.id.invalid")
    private Long spuId;

    /**
     * 商家ID
     */
    private Long userId;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 品牌ID
     * @see io.terminus.ecp.item.model.Brand
     */
    private Long brandId;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 商品名称
     */
    @NotNull(message = "item.name.blank")
    @Length(min = 1, max = 200, message = "item.name.1to200")
    private String name;                //商品名称

    /**
     * 主图URL
     */
    private String mainImage;

    /**
     * 售价
     */
    private Integer price;

    /**
     * 原价
     */
    private Integer originPrice;

    /**
     * 库存
     */
    @Min(value = 0, message = "item.stock.quantity.invalid")
    private Integer stockQuantity;

    /**
     * 销量
     */
    private Integer saleQuantity;

    /**
     * 所在省ID
     * @see io.terminus.ecp.user.model.Address
     */
    @Deprecated
    private Integer provinceId;

    /**
     * 所在市ID
     * @see io.terminus.ecp.user.model.Address
     */
    @Deprecated
    private Integer cityId;

    /**
     * 所在区ID
     * @see io.terminus.ecp.user.model.Address
     */
    @Deprecated
    private Integer regionId;

    /**
     * 状态
     * @see io.terminus.ecp.item.model.Item.Status
     */
    private Integer status;

    /**
     * 上架时间
     */
    private Date onShelfAt;

    /**
     * 下架时间
     */
    private Date offShelfAt;

    /**
     * 型号
     */
    private String model;

    /**
     * 备注
     */
    private String remark;

    /**
     * 商品营销活动标志, 二进制字符串, 0表示无该活动, 1表示有该活动
     */
    private String marketTag;

    /**
     * 商品类型
     *
     * @see io.terminus.ecp.item.model.ItemType
     */
    private Integer type;

    /**
     * 商品属性描述, 二进制开关标记, 每一位代表一种属性
     */
    private Integer bitMark;

    // TODO: 暂时用常量表示
    public static final int INDEXABLE = 1; // 可索引
    public static final int VISIBLE = 2; // 商品详情可见

    /**
     * 是否可被分销
     */
    private Boolean distributable;

    /**
     * 放商品扩展信息, 建议json字符串
     */
    private String extra;

    @JsonIgnore
    private Date createdAt;

    @JsonIgnore
    private Date updatedAt;

    /**
     * 商品店铺内商品某标签key
     * @param userId 用户id(用userId标识, 而非shopId)
     * @param tag 标签名
     * @return 店铺内标签key ==> shops:{userId}:tags:{tag}:items
     */
    public static final String keyOfTagItems(final Long userId, String tag){
        return  "shops:" + userId + ":tags:"+ tag +":items";
    }

    /**
     * 店铺内未打分类标签key
     * @param userId 用户id(用userId标识, 而非shopId)
     * @return 未打标签的商品key ==> shops:{userId}:tags:unknown:items
     */
    public static final String keyOfNoTagItems(final Long userId){
        return "shops:" + userId + ":tags:unknown:items";
    }

    /**
     * 店铺内某商品的tag集合key
     * @param itemId 商品id
     * @return 商品tag集合key ==> items:{itemId}:tags
     */
    public static final String keyOfItemTags(final Long itemId){
        return "items:" + itemId + ":tags";
    }

    /**
     * 店铺的上架商品数key
     * @param shopId 店铺id
     * @return shops:{shopId}:item:count
     */
    public static final String keyOfShopItemCount(Long shopId) {
        return "shops:" + shopId + ":item:count";
    }

    /**
     * 商品状态枚举
     */
    public static enum Status {
        INIT(0, "未上架"),
        ON_SHELF(1, "上架"),
        OFF_SHELF(-1, "下架"),
        FROZEN(-2, "冻结"),
        DELETED(-3, "删除");

        private int value;
        private String desc;

        private Status(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public int value() {
            return value;
        }

        public static Status from(int number) {
            for (Status status : Status.values()) {
                if (Objects.equal(status.value, number)) {
                    return status;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return desc;
        }
    }
}
