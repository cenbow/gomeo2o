package cn.com.gome.trade.dto.userdto;


import static io.terminus.common.utils.Arguments.notEmpty;

import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 登录用户seesion中保存的信息
 * Mail: xiao@terminus.io <br>
 * Date: 2014-11-21 11:33 AM  <br>
 * Author: xiao
 */
@ToString
public class EcpLoginUser implements LoginUser {
    private static final long serialVersionUID = 1393404798661080944L;

    @Setter
    protected Long id;

    @Setter
    protected Integer type;

    @Getter @Setter
    protected Integer status;

    @Getter @Setter
    protected String nickname;

    @Getter @Setter
    protected String displayName;

    @Getter @Setter
    protected String email;

    @Getter @Setter
    protected String mobile;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Integer getType() {
        return type;
    }

    @Override
    public String getTypeName() {
        return null;
    }

    @Override
    public List<String> getRoles() {
        return Collections.emptyList();
    }

    public static EcpLoginUser make(User user) {
        EcpLoginUser loginUser = new EcpLoginUser();
        loginUser.setId(user.getId());
        loginUser.setType(user.getType());
        loginUser.setStatus(user.getStatus());
        loginUser.setNickname(user.getNickname());
        loginUser.setDisplayName(user.getDisplayName());
        loginUser.setEmail(user.getEmail());
        loginUser.setMobile(user.getMobile());
        return loginUser;
    }

    @Override
    public String getName() {
        if (notEmpty(nickname)) {
            return nickname;
        }
        if (notEmpty(mobile)) {
            return mobile;
        }
        return email;
    }

    @Override
    public String getName(boolean blur) {
        if (notEmpty(nickname)) {
            return nickname;
        }
        if (notEmpty(mobile)) {
            if (blur) {
                return mobile.substring(0, 3) + "****" + mobile.substring(7, mobile.length());
            }
            return mobile;
        }
        return email;
    }
}
