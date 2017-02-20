package io.terminus.ecp.marketing.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Desc: 活动执行数据的记录
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 15/3/5.
 */
@ToString
public class MarketingActivityLog implements Serializable {

    private static final long serialVersionUID = -108211283999807860L;

    @Getter
    @Setter
    private Long id;                //编号

    @Getter
    @Setter
    private Long activityId;        //活动编号

    @Getter
    @Setter
    private Long buyerId;           //买家

    @Getter
    @Setter
    private Long sellerId;          //卖家

    @Getter
    @Setter
    private Long orderId;           //订单编号

    @Getter
    @Setter
    private Long orderItemId;       //子订单编号

    @Getter
    @Setter
    private Integer originalFee;    //原始价格

    @Getter
    @Setter
    private Integer discountFee;    //优惠价格

    @Getter
    @Setter
    private String resultDesc;      //优惠记录

    @Getter
    @Setter
    private Date createdAt;

    @Getter
    @Setter
    private Date updatedAt;

    public static MarketingActivityLog getInstance(){
        return new MarketingActivityLog();
    }

    public MarketingActivityLog id(Long id){
        this.id = id;
        return this;
    }

    public MarketingActivityLog activityId(Long activityId){
        this.activityId = activityId;
        return this;
    }

    public MarketingActivityLog buyerId(Long buyerId){
        this.buyerId = buyerId;
        return this;
    }

    public MarketingActivityLog sellerId(Long sellerId){
        this.sellerId = sellerId;
        return this;
    }

    public MarketingActivityLog orderId(Long orderId){
        this.orderId = orderId;
        return this;
    }

    public MarketingActivityLog originalFee(Integer originalFee){
        this.originalFee = originalFee;
        return this;
    }

    public MarketingActivityLog actualFee(Integer discountFee){
        this.discountFee = discountFee;
        return this;
    }

    public MarketingActivityLog resultDesc(String resultDesc){
        this.resultDesc = resultDesc;
        return this;
    }

    public MarketingActivityLog createdAt(Date createdAt){
        this.createdAt = createdAt;
        return this;
    }

    public MarketingActivityLog updatedAt(Date updatedAt){
        this.updatedAt = updatedAt;
        return this;
    }

}
