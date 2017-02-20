package cn.com.gome.account.withdrawalbankcards;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Description TODO 提现卡
 * @author zhuwei
 * @date   2016/7/13 11:03
 */
@Data
public class WithdrawalBankCard implements Serializable{
    private static final long serialVersionUID = -479691640949344930L;

    /**
     * 体现卡id  主键
     */
    private Long id;

    /**
     * 提现卡类型
     */
    private Integer type;

    /**
     * 类型描述
     */
    private String typeDesc;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 尾号
     */
    private String tailNumber;
}
