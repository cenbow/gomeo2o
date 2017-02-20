package cn.com.gome.account.bankcard;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Description TODO 绑定银行卡response
 * @author zhuwei
 * @date   2016/7/13 14:53
 */
@Data
public class BankCardResp implements Serializable{
    private static final long serialVersionUID = -5359577106939574574L;

    /**
     * 是否绑定
     */
    private boolean isBound;
}
