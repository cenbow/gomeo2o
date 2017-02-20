package cn.com.gome.account.checkingbankcardbound;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Description TODO 校验银行卡是否已经被绑定实体
 * @author zhuwei
 * @date   2016/7/13 14:07
 */
@Data
public class CheckingBankcardBoundResp implements Serializable{
    private static final long serialVersionUID = -2329027807782229287L;

    /**
     * 是否被绑定
     */
    private Boolean isBound;
}
