package cn.com.gome.account.userbankcardnumber;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Description TODO 用户银行卡个数实体
 * @author zhuwei
 * @date   2016/7/13 16:29
 */
@Data
public class UserBankCardNumberResp implements Serializable{
    private static final long serialVersionUID = 2765531413536409338L;

    /**
     * 银行卡个数
     */
    private Integer count;
}
