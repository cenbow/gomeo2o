/*
 * <!--
 *   ~ Copyright (c) 2014 杭州端点网络科技有限公司
 *   -->
 */

package io.terminus.ecp.marketing.model.coupon;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.joda.time.DateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

import static io.terminus.common.utils.Arguments.equalWith;

/**
 * Created by yangzefeng on 14/12/4
 */
@Data
public class CouponDefinition implements Serializable {
    private static final long serialVersionUID = 781304234532549342L;

    private Long id;

    @NotNull(message = "coupon.name.null")
    @Length(min = 3, max = 20, message = "coupon.name.error")
    private String name;                //优惠券名称

    @NotNull(message = "coupon.discount.error")
    @Min(value = 1, message = "coupon.discount.error")
    private Integer discount;           //优惠券面值

    private Integer type;               //优惠券类型(1:商家优惠券， 2:平台优惠券)
    private String picture;             //优惠券的图片
    private Long creatorId;             //优惠创建人Id
    private Long itemId;                //适用商品id
    private String itemName;            //商品名称
    private Long shopId;                //店铺id
    private String shopName;            //店铺名称
    private Integer status;             //状态，0->未发布,1->已发布，未生效,2->已生效,-1->失效,-2->停发（只能用券，不能送券）

    private String budgetCode;          //预算编号

    @Min(value = 1, message = "coupon.baseMoney.error")
    private Integer baseMoney;          //起用价格（订单满多少元可用）

    private Integer baseQuantity;       //起用数量（订单满多少件可用）
    private Integer mostUseQuantity;    //每个订单最多使用数量
    private Integer perMoney;           //每满多少金额可以使用

    private Integer allQuantity;        //全部券的数量（最多可发放的数量, NULL:无限发放）
    private Integer limitReceive;       //限制领取张数
    private Integer receiveQuantity;    //已领取的张数
    private Integer usedQuantity;       //已使用的券的数量
    private Integer givenQuantity;      //已发放券的数量（已生成优惠券码的优惠券数量）
    private String description;         //优惠券详情
    private Date startAt;               //生效时间
    private Date endAt;                 //失效时间

    private Date createdAt;             //创建时间
    private Date updatedAt;             //更新时间

    public static enum Type {
        SHOP(1, "商家优惠券"),
        PLATFORM(2, "平台优惠券");

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
        STOP(-2, "停发");

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
     * 判断券现在是否在有效时间范围内
     */
    public Boolean isCurrentEffective() {
        DateTime now = DateTime.now();
        return now.isAfter(new DateTime(this.startAt))
                && now.isBefore(new DateTime(this.endAt));
    }

    /**
     * 判断券是否处于某种状态
     */
    public Boolean isStatus(Status s) {
        return equalWith(this.status, s.toNumber());
    }

    /**
     * 判断券是否可以使用（即券已发布且当前时间在有效时间范围内）
     */
    public Boolean canUsed() {
        return !isStatus(Status.INIT) && isCurrentEffective();
    }

    /**
     * 判断是否还可以再领取该优惠券(是否已达到领取限额)
     * @param receiveNum    需要领取的数量
     * @return  Boolean
     * 返回是否还可以领取
     */
    public Boolean canReceive(Integer receiveNum) {
        return this.allQuantity == null || this.allQuantity - this.receiveQuantity >= receiveNum;
    }

    /**
     * 判断是否还可以再生成优惠券码（用于发放生成编码）
     */
    public Boolean canGiven() {
        return this.allQuantity == null || this.allQuantity > this.givenQuantity;
    }

    /**
     * 返回还可以领取的数量（否则需要生成优惠编码）
     */
    public int existNoReceive(){
        return this.givenQuantity - this.receiveQuantity;
    }

    /**
     * 判断是否已达到领取上限
     * @param getNum    已领取数量
     * @return  Boolean
     * 返回是否还可以领取
     */
    public Boolean ifLimitNum(Integer getNum){
        return this.getLimitReceive() == null || this.getLimitReceive() >= getNum;
    }
}
