package io.terminus.ecp.marketing.model.coupon;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import static io.terminus.common.utils.Arguments.equalWith;

/**
 * Desc:优惠券的编号绑定处理
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-04-25.
 */
@Data
public class CouponGrant implements Serializable {
    private static final long serialVersionUID = -4823158140679136737L;

    private Long id;            //编号

    private Long couponDefId;   //对应优惠券定义Id

    private String grantNum;    //优惠券的优惠编码

    private Integer receiveType;//优惠券领取类型（1:发放，2:领取）

    private Long userId;        //优惠券绑定的用户

    private String userName;    //绑定的用户名

    private Integer status;     //1->未使用,2->已使用

    private Date createdAt;     //创建时间

    private Date updatedAt;     //更新时间

    public static enum Status {
        NO_USED(1, "未使用"),
        USED(2, "已使用");

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

    public static enum ReceiveType {
        SEND(1, "发放"),
        RECEIVE(2, "领取");

        private final Integer value;

        private final String display;

        private ReceiveType(Integer value, String display) {
            this.value = value;
            this.display = display;
        }

        public static ReceiveType fromNumber(Integer value) {
            for (ReceiveType t : ReceiveType.values()) {
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
}
