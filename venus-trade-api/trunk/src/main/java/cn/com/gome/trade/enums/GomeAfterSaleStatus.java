package cn.com.gome.trade.enums;

/**
 * Created by yangzefeng on 15/5/12
 */
public enum  GomeAfterSaleStatus {

    WAIT_FOR_RETURNS(-101, "退货单待审核"),
    RETURNS_EXPIRE  (-111, "商家审核超时,自动审核通过"),
    SELLER_CONFIRM_RECEIVE (-115, "商家收到退货"),
    DONE            (-109, "退货款完成"),


    WAIT_FOR_EXCHANGES(-117, "换货等待审核"),
    EXCHANGES_SELLER_DELIVER(-123, "卖家已发货"),
    BUYER_CONFIRM_RECEIVE(-124, "买家收到退货"),

    /**
     * 退货换货共用状态
     */
    BUYER_DELIVERED (-107, "客户已发货，商家待收货"),
    AGREED  (-103, "审核通过"),
    REFUSED (-105, "审核不通过"),
    BUYER_REJECTED(-127, "买家拒收"),
    SELLER_REJECTED(-129, "卖家拒收"),
    CANCEL_BY_BUYER_REJECT(-131, "买家拒收后，运营或商家关闭退款单"),
    APPLY_AGAIN     (-113, "再次申请退货"),
    CANCEL(-133, "买家取消申请"),
    Refunding(-135, "正在退款");


    public final Integer value;

    public final String display;

    private GomeAfterSaleStatus(int value, String display) {
        this.value = value;
        this.display = display;
    }

    public static GomeAfterSaleStatus from(int value) {
        for(GomeAfterSaleStatus ta: GomeAfterSaleStatus.values()) {
            if(ta.value==value) {
                return ta;
            }
        }

        return null;
    }

    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
