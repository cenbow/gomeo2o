package cn.com.gome.trade.dto.paydto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付阶段（例如分期的每一期）
 * Created with IntelliJ IDEA
 * Author: songrenfei
 * Date: 15/3/3
 * Time: 下午2:05
 */
@Data
public class PayStage implements Serializable{

    private static final long serialVersionUID = -7045090173067244272L;


    /** ID */
    private Long id;
    /** 交易支付id */
    private Long payId;
    /** 当前第几阶段 */
    private Integer currentStage;
    /** 商品内容 */
    private String content;
    /** 本阶段应还金额（支付金额） */
    private Integer fee;
    /** 交易渠道 */
    private String channel;
    /** 支付平台交易流水号  */
    private String paymentCode;
    /** 支付状态 0:未支付 1:已支付 -1:支付超时 */
    private Integer paidStatus;
    /** 支付平台佣金 */
    private Integer thirdPartyFee;
    /** 支付平台抽佣比率 单位 万分之一 */
    private Integer thirdPartyRate;
    /** 系统内部流水 */
    private String systemNo;
    /** 交易超时时间 */
    private Date expiredAt;
    /** 还款超时时间 */
    private Date repayAt;
    /** 支付时间 */
    private Date paidAt;

    private Date createdAt;

    private Date updatedAt;


}

