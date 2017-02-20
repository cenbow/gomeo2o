package io.terminus.ecp.trade.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 订单附加信息
 */
@Data
@EqualsAndHashCode(of = {"orderId"})
public class OrderExtra implements Serializable {

    private static final long serialVersionUID = 6929251808713895387L;

    /**
     * ID
     */
    private Long      id;
    /**
     * 订单ID
     */
    private Long      orderId;
    /**
     * 买家收货地址json对象
     * @see io.terminus.ecp.user.model.UserTradeInfo
     */
    private String    tradeInfo;
    /**
     * 买家留言
     */
    private String    buyerNotes;
    /**
     * 卖家留言
     */
    private String    sellerNotes;
    /**
     * 发票信息
     */
    private String    invoice;
    /**
     * 发票编号 (null 表示未开)
     */
    private String    invoiceNo;
    /**
     * 开发票人 id (商家子帐号 id: {@code SubSeller.id})
     */
    private Long      invoicingSubId;
    /**
     * 更新时间
     */
    private String    updatedAt;


    public static enum Type {
        PLAIN("1", "普通发票"),
        VAT("2","增值税发票"),
        ELECT("3","电子发票");

        private final String value;
        private final String description;

        private Type(String value, String description) {
            this.value = value;
            this.description = description;
        }
        public String value() {
            return this.value;
        }
        public String toString() {
            return description;
        }
    }

}
