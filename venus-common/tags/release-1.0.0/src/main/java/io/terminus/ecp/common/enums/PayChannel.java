/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.common.enums;

/**
 * <pre>
 *   功能描述: 支付渠道
 *      1. "alipay", "支付宝支付"
 *      2. "wapalipay", "wap支付宝支付"
 *      3. "ccbapppay", "建行客户端支付"
 *      4. "ccbpay", "建行支付"
 *      5. "wechatpay", "微信支付"
 *      6. "kjtpay", "快捷通支付"
 *      7. "yypay", "银盈通支付"
 * </pre>
 *
 * @author wanggen on 2014-12-18.
 */
public enum PayChannel {

    /**
     * 支付宝支付-pc
     */
    Alipay("alipay", "支付宝PC支付"),
    /**
     * wap支付宝支付-wap
     */
    Wapalipay("wapalipay", "支付宝移动终端支付"),
    /**
     * 建行二维码支付-code
     */
    Ccbapppay("ccbapppay", "建行客户端支付"),
    /**
     * 建行网页支付
     */
    Ccbpay("ccbpay", "建行PC支付"),
    /**
     * 微信支付-native
     */
    Wechatpay("wechatpay", "微信二维码支付"),
    /**
     * 微信支付-jsapi
     */
    Wechatpay_jsapi("wechatpay-jsapi", "微信客户端控件支付"),

    /**
     * 快捷通支付
     */
    Kjtpay("kjtpay", "快捷通支付"),
    
    /**
     * 银盈通支付
     */
    Yytpay("yytpay", "银盈通支付");


    public static PayChannel from(String channel) {
        for (PayChannel ch : PayChannel.values()) {
            if (ch.name.equals(channel)) return ch;
        }
        throw new IllegalArgumentException("Illegal pay channel:[" + channel + "]");
    }

    public final String name;
    public final String description;

    private PayChannel(String value, String description) {
        this.name = value;
        this.description = description;
    }

}