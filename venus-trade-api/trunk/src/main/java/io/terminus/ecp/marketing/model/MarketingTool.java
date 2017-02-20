package io.terminus.ecp.marketing.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

import static io.terminus.common.utils.Arguments.equalWith;

/**
 * Desc: 营销工具
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 15/3/5.
 */
@ToString
public class MarketingTool implements Serializable {

    private static final long serialVersionUID = -382297063416763566L;

    @Getter
    @Setter
    private Long id;                //市场营销工具                                

    @Getter
    @Setter
    private String name;            //工具名称

    @Getter
    @Setter
    private Long registerId;        //注册中心的编号(null:默认系统)

    @Getter
    @Setter
    private String category;        //工具类别

    @Getter
    @Setter
    private Integer scope;          //工具作用范围 （1.订单 2.商户 3.商品）

    @Getter
    @Setter
    private Integer priority;       //优先级

    @Getter
    @Setter
    private Integer isExclusive;    //是否是独占式（0.非独占 1.独占）

    @Getter
    @Setter
    private Integer status;         //工具状态（0:待发布，1:已发布，-1:撤销）

    @Getter
    @Setter
    private String desc;            //工具描述

    @Getter
    @Setter
    private Long createBy;          //创建人

    @Getter
    @Setter
    private Long updateBy;          //修改人

    @Getter
    @Setter
    private Date createAt;          //创建时间

    @Getter
    @Setter
    private Date updateAt;          //结束时间

    public static enum Status {
        WAIT_SEND(0, "待发布"),
        SEND(1, "已发布"),
        STOP(-1, "撤销");

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
     * 判断优惠工具的状态
     * @param   s 优惠工具的状态
     * @return  Boolean
     * 返回是否符合
     */
    public Boolean isStatus(Status s) {
        return equalWith(this.status, s.toNumber());
    }
}
