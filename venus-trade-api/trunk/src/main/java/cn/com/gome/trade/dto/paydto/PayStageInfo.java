package cn.com.gome.trade.dto.paydto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 分期支付没阶段支付信息封装
 * Created with IntelliJ IDEA
 * Author: songrenfei
 * Date: 15/3/19
 * Time: 下午2:56
 */
@Data
public class PayStageInfo implements Serializable{

    private static final long serialVersionUID = 872573968235665722L;


    /** 当前第几阶段 */
    private Integer currentStage;

    /** 本阶段应还金额（支付金额） */
    private Integer fee;

    /** 还款超时时间 null代表没有时间限制*/
    private Date repayAt;
}

