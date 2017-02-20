/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */
package io.terminus.ecp.trade.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import static io.terminus.common.utils.Arguments.equalWith;

/**
 * 订单物流<BR>
 *
 * Created by wanggen 2015-01-06 14:50:29
 * <PRE>
 *      id           Long     自增主键
 *      orderId      Long     平台订单号
 *      orderItemId  Long     子订单
 *      datetime     Date     时间戳
 *      content      String   物流内容
 * </PRE>
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "create")
@EqualsAndHashCode(of = {"orderId", "datetime"})
public class LogisticsInfo implements Serializable {
    private static final long serialVersionUID = -282888450935326389L;

    private Long        id;               //自增主键

    @NonNull
    private Long        orderId;          //平台订单号

    private Long        orderItemId;      //子订单

    private Integer     type;             //(1:发货物流，2:退货物流)

    private Integer     status;           //状态 @see DeliverStatus

    @NonNull
    private Date        datetime;         //时间戳

    @NonNull
    private String      content;          //物流内容


    public static enum Type {
        SEND(1, "发货物流"),
        REFUND(2, "退货物流");

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

    public static enum DeliverStatus {

        PREPARE_GOODS(0, "商家备货"),
        PRODUCING    (1, "工厂生产中"),
        STOCK_OUT    (2, "订单出库,正在投递给快递公司"),
        DELIVERING   (3, "快递公司揽件后,正在发货中"),
        DISPATCHING  (4, "订单已到买家就近收发网点,派件中"),
        RECEIVED     (5, "买家已签收"),
        RETURNING    (-1, "买家拒签,货物退回中"),
        RETURNED     (-2, "买家未签收货物已退回到卖家"),
        EXCEPTION    (-3, "货物寄送过程出了问题");

        public final int value;
        public final String desc;

        DeliverStatus(int status, String desc) {
            this.value = status;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return this.desc;
        }

        /**
         * 将kuaidi100的运货状态转换为的状态
         *
         * @param status 状态
         */
        public static DeliverStatus fromKd100Status(int status) {
            switch (status) {
                case 0:                         //在途
                    return STOCK_OUT;
                case 1:                         //揽件
                    return DELIVERING;
                case 5:                         //派件
                    return DISPATCHING;
                case 3:                         //签收
                    return RECEIVED;
                case 6:                         //无法签收，退回
                    return RETURNING;
                case 4:                         //退货的货物，发件人已签收
                    return RETURNED;
                case 2:                         //投递出现异常
                    return EXCEPTION;
                default:
                    return PREPARE_GOODS;
            }
        }
    }


}
