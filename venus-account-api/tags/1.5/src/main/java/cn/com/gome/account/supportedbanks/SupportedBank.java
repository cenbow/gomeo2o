package cn.com.gome.account.supportedbanks;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @Description TODO 支持银行信息
 * @author zhuwei
 * @date   2016/7/13 11:47
 */
@Data
public class SupportedBank implements Serializable{
    private static final long serialVersionUID = 1103453031324740326L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 银行名称
     */
    private String bankName;

    /**
     * 银行Logo地址
     */
    private String bankLogo;
}
