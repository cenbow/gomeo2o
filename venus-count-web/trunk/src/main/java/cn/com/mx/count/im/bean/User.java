/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package cn.com.mx.count.im.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户类 Author: haolin On: 8/26/14
 */
@ToString
@EqualsAndHashCode
public class User implements Serializable {

    private static final long serialVersionUID = -7156141639881746299L;

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String nickname; // 昵称，唯一

    @Getter
    @Setter
    private String displayName; // 显示名

    @Getter
    @Setter
    private String mobile; // 手机


    @Getter
    @Setter
    private String email; // 邮箱

    @Setter
    private Integer type; // 类型

    @Getter
    @Setter
    private String passwd; // 32位加密密码

    @Getter
    @Setter
    private Integer status; // 状态


    @Getter
    @Setter
    private String outerUserId; // 外部用户ID

    /**
     * 用户来源, 0 或 NULL 表示用户自己注册
     *
     * @see UserOrigin#getId()
     * @deprecated 用户这里不需要冗余
     */
    @Getter
    @Setter
    @Deprecated
    private Long originId;

    @Getter
    @Setter
    private String roleStr;

    @Getter
    @Setter
    private Date createdAt; // 创建时间

    @Getter
    @Setter
    private Date updatedAt; // 更新时间

}
