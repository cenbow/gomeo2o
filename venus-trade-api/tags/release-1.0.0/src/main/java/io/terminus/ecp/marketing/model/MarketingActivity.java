package io.terminus.ecp.marketing.model;

import com.google.common.collect.Maps;
import io.terminus.common.utils.Splitters;
import io.terminus.ecp.marketing.enums.DiscountPeType;
import io.terminus.ecp.marketing.enums.DiscountRangType;
import lombok.Data;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static io.terminus.common.utils.Arguments.equalWith;

/**
 * Desc:优惠活动定义
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-03.
 */
@Data
public class MarketingActivity implements Serializable {
    private static final long serialVersionUID = -7232489909443792748L;
    private Long id;                    //优惠活动编号

    @NotNull(message = "activity.name.null")
    private String name;                //优惠活动名称

    private String title;               //优惠标题

    private String image;               //优惠活动的图片地址

    private Integer type;               //优惠类型（1.平台优惠，2.商家优惠）

    private Long sellerId;              //卖家编号

    private Long toolId;                //优惠的工具编号

    private Long registerId;            //优惠插件注册地址

    private Integer eventType;          //活动类型（1.交易，2.登陆, 3.注册, 4.评价, 5.收藏）

    private Integer peType;             //优惠对象类型（1.全网买家，2.店铺会员，3.标签）

    private String peVal;               //优惠对象数据（1,2,3）

    private Integer rangType;           //优惠范围类型（1.指定店铺，2.指定类目，3.指定商品）

    private String rangVal;             //优惠范围数据（1,2,3）

    private Integer priority;           //优先级

    private Boolean ifOverlap;          //是否重叠计算优惠数据

    private Date startTime;             //优惠活动的开始时间

    private Date endTime;               //优惠活动的结束时间

    private String description;         //详情介绍

    private Integer status;             //优惠活动状态（-1:活动停止，0:待发布，1:已发布，2:活动开始，3:活动结束）

    private Map<String, Object> context = Maps.newHashMap();

    private Date createdAt;             //创建时间

    private Date updatedAt;             //结束时间

    public static enum Type {
        SYSTEM(1, "平台"),
        SELLER(2, "卖家");

        private final Integer value;

        private final String display;

        private Type(Integer value, String display) {
            this.value = value;
            this.display = display;
        }

        public static Type fromNumber(Integer value) {
            for (Type type : Type.values()) {
                if (equalWith(type.value, value)) {
                    return type;
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
        STOP(-1, "活动停止"),
        WAIT_SEND(0, "待发布"),
        SEND(1, "已发布"),
        START(2, "活动开始"),
        END(3, "活动结束"),
        FROZEN(4,"已冻结");

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
     * 判断优惠活动是否有效
     */
    public Boolean isEffective() {
        DateTime now = DateTime.now();
        return isStatus(Status.START) && now.isAfter(new DateTime(this.startTime)) && now.isBefore(new DateTime(this.endTime));
    }

    /**
     * 判断优惠活动的状态
     * @param   s 优惠活动的状态
     * @return  Boolean
     * 返回是否符合
     */
    public Boolean isStatus(Status s) {
        return equalWith(this.status, s.toNumber());
    }

    /**
     * 判断优惠对象是否符合
     * @param   peType    优惠对象类型
     * @return  Boolean
     * 返回是否符合
     */
    public Boolean isPeType(DiscountPeType peType){
        return equalWith(this.peType, peType);
    }

    /**
     * 拆分优惠对象数据
     * @return List
     * 返回优惠对象信息
     */
    public List<Long> splitPeVal() throws Exception{
        return Splitters.splitToLong(this.peVal , Splitters.COMMA);
    }

    /**
     * 判断优惠范围是否符合
     * @param   rangType    优惠范围类型
     * @return  Boolean
     * 返回是否符合
     */
    public Boolean isRangType(DiscountRangType rangType){
        return equalWith(this.rangType, rangType);
    }

    /**
     * 拆分优惠范围数据
     * @return List
     * 返回优惠范围数据
     */
    public List<Long> splitRangVal() throws Exception{
        return Splitters.splitToLong(this.rangVal, Splitters.COMMA);
    }
}
