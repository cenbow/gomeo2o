package cn.com.gome.account.bankcardAccountInfo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Description TODO 获取用户开户行姓名和身份证号
 * @author zhuwei
 * @date   2016/7/13 13:34
 */
@Data
public class BankcardAccountInfoResp implements Serializable{
    private static final long serialVersionUID = 3362640096459828746L;

    /**
     * 用户开户姓名和身份证号实体
     */
    private BankcardAccountInfo bankcardAccountInfo;
}
