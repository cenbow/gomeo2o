/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户的增值税发票信息
 *
 * Mail: xiao@terminus.io <br>
 * Date: 2014-07-04 1:56 PM  <br>
 * Author: xiao
 */
@ToString
@EqualsAndHashCode
public class UserVatInvoice implements Serializable {

    private static final long serialVersionUID = 5430922742527658656L;

    @Getter
    @Setter
    private Long id;                        // id 主键

    @Getter
    @Setter
    private Long userId;                    // 用户id

    @Getter
    @Setter
    private String companyName;             // 公司名称

    @Getter
    @Setter
    private String taxRegisterNo;           // 税务登记号

    @Getter
    @Setter
    private String registerAddress;         // 注册地址

    @Getter
    @Setter
    private String registerPhone;           // 注册电话

    @Getter
    @Setter
    private String registerBank;            // 注册银行

    @Getter
    @Setter
    private String bankAccount;             // 银行帐号

    @Getter
    @Setter
    private String taxCertificate;          // 税务登记证

    @Getter
    @Setter
    private String taxpayerCertificate;     // 一般纳税人证书

    @Getter
    @Setter
    private Date createdAt;                 // 创建时间

    @Getter
    @Setter
    private Date updatedAt;                 // 更新时间

}
