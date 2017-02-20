/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.marketing.model.promo;

import io.terminus.common.utils.Splitters;
import lombok.Data;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static io.terminus.common.utils.Arguments.equalWith;

/**
 * Desc: 优惠码定义
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 3/17/15.
 */
@Data
public class PromoDefinition implements Serializable {
    private static final long serialVersionUID = 781304234532549342L;

    private Long id;

    private String name;                //优惠码名称

    private String promoNum;            //优惠码（让买家使用）

    private Integer type;               //优惠码类型(平台优惠码｜商家优惠码)

    private Integer relation;           //优惠码关系

    private String shopIds;             //作用的店铺Ids(1,2,3,4)

    private Integer maxUsed;            //最大使用上限

    private Integer usedQuantity;       //已使用的优惠码数量

    private Integer baseMoney;          //起用价格（订单满多少元可用）

    private Integer discount;           //减现

    private Long giftId;                //送礼商品Id

    private Integer discountPro;        //打折

    private Boolean shipFee;            //包邮

    private Long creatorId;             //创建人编号

    private Date startAt;               //生效时间

    private Date endAt;                 //失效时间

    private Integer status;             //状态，0->未发布,1->已发布，未生效,2->已生效,-1->失效

    private Date createdAt;             //创建时间

    private Date updatedAt;             //更新时间

    public static enum Type {
        SHOP(1, "平台优惠码"),
        PLATFORM(2, "商家优惠码");

        private final Integer value;

        private final String display;

        private Type(Integer value, String display) {
            this.value = value;
            this.display = display;
        }

        public static Type fromNumber(Integer value) {
            for (Type t : Type.values()) {
                if (equalWith(t.value, value)) {
                    return t;
                }
            }
            return null;
        }

        public Integer toNumber() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.display;
        }
    }

    public static enum Status {
        INIT(0, "未发布"),
        RELEASE(1, "已发布，未生效"),
        EFFECTIVE(2, "已生效"),
        EXPIRE(-1, "过期失效"),
        STOP(-2, "停止使用");

        private final Integer value;

        private final String display;

        private Status(Integer value, String display) {
            this.value = value;
            this.display = display;
        }

        public static Status fromNumber(Integer value) {
            for (Status t : Status.values()) {
                if (equalWith(t.value, value)) {
                    return t;
                }
            }
            return null;
        }

        public Integer toNumber() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.display;
        }
    }

    /**
     * 判断码现在是否在有效时间范围内
     */
    public Boolean isCurrentEffective() {
        DateTime now = DateTime.now();
        return now.isAfter(new DateTime(this.startAt))
                && now.isBefore(new DateTime(this.endAt));
    }

    /**
     * 判断码是否处于某种状态
     */
    public Boolean isStatus(Status s) {
        return equalWith(this.status, s.toNumber());
    }

    /**
     * 判断码是否可以使用（即码已发布且当前时间在有效时间范围内）
     */
    public Boolean canUsed() {
        return !isStatus(Status.INIT) && isCurrentEffective();
    }

    /**
     * 获取店铺列表
     * @return  List
     * 返回店铺列表
     */
    public List<Long> shopIds(){
        return Splitters.splitToLong(this.shopIds , Splitters.COMMA);
    }
}
