package cn.com.gome.account.bankcardAccountInfo;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Description TODO 用户开户行姓名和身份证号
 * @author zhuwei
 * @date   2016/7/13 13:32
 */
@Data
public class BankcardAccountInfo implements Serializable{
    private static final long serialVersionUID = 3043593133539502089L;

    /**
     * 身份证号
     */
    private String identificationCard;

    /**
     * 姓名
     */
    private String accountName;
}
