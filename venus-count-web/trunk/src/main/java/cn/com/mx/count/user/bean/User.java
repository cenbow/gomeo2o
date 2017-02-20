package cn.com.mx.count.user.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @Description ecp_users 表对应的实体
 * @author jiale
 * @date 2016年3月3日 下午3:24:36
 */
@ToString
@EqualsAndHashCode
public class User implements Serializable {
	
	private static final long serialVersionUID = 2112245727527858532L;

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

    @Getter
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
