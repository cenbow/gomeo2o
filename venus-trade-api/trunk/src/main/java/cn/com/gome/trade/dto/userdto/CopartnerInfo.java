package cn.com.gome.trade.dto.userdto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业信息(展示公司logo、名称、已加入用户数量、可享受福利数量)
 * Author: songrenfei
 * On: 11/28/14
 */
@Data
public class CopartnerInfo implements Serializable {

    private static final long serialVersionUID = 2579264868095659969L;

    private Long id;
    private Long userId;            //用户id
    private String userName;        //用户名称
    private String logo;            //公司logo
    private Long members;           //已加入成员数量
    @NotBlank(message = "user.copartner.info.company.name.empty")
    private String companyName;     //公司名称
    private String companyNum;      //公司备案号
    private String companySLD;      //公司二级域名
    private String companyRecord;   //页脚备案号
    private String key;             //用于此公司员工账号单点登录本系统加密
    private String privilege ;      //优惠描述
    private Long shopId;            //店铺id
    private Boolean protection = false;     //是否受到保护（允许用户跳过白名单手机注册)
    private Integer limitRef;       //如果不为1，为开放注册，可以通过手机邀请任何人
    private Long managerId;         //销售经理id
    private String managerName;     //销售经理姓名
    private Date createdAt;         //创建时间
    private Date updatedAt;         //更新时间
}

