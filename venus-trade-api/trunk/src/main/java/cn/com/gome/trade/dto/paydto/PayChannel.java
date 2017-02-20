package cn.com.gome.trade.dto.paydto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * 支付渠道
 * Created with IntelliJ IDEA
 * Author: songrenfei
 * Date: 15/3/3
 * Time: 下午3:50
 */
@Data
public class PayChannel implements Serializable{

    private static final long serialVersionUID = -5314404418585707864L;
    /** 主键id */
    private Long id;
    /** 分期阶段id */
    private Long stageId;
    /** 支付状态 0:待处理 1:已完成 -1:失败 */
    private Integer status;
    /** 交易流水号 */
    private String tradeNo;
    /** 支付平台交易流水号  */
    private String paymentCode;
    /** 交易渠道 */
    private String channel;
    /** 支付完成时间 */
    private Date paidAt;

    /** 退款批次号 */
    private String batchNo;
    /** 退款单id */
    private Long refundOrderId;
    /** 类型 1支付2退款 */
    private Integer type;
    /** 金额 */
    private Integer fee;
    /** 支付平台佣金 */
    private Integer thirdPartyFee;
    /** 支付平台费率 */
    private Integer thirdPartyRate;
    /** 备注 
     *  如果备注信息 like 'doublePay%' 则此条信息为 二次支付退款信息 不修改订单状态
     * */
    private String  description;
    /** 退款完成时间 */
    private Date    refundAt;

    private Date createdAt;

    private Date updatedAt;
    
    private Map overseasPaymentMap;
}
