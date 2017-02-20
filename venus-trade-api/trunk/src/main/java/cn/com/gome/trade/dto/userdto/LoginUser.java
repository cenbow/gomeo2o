package cn.com.gome.trade.dto.userdto;


import io.terminus.pampas.common.BaseUser;

/**
 * 登录用户 session 中保存的信息
 *
 * @author Effet
 */
public interface LoginUser extends BaseUser {

    /**
     * 用户状态
     */
    Integer getStatus();

    /**
     * 用户账户名称
     */
    String getNickname();


    /**
     * 用户展示名称
     */
    String getDisplayName();

    /**
     * 用户邮箱
     */
    String getEmail();

    /**
     * 用户手机
     */
    String getMobile();

    /**
     * 用户称呼 ({@code nickname} or {@code email} or {@code mobile}, first not null)
     *
     * 若 {@code blur == true}, mobile 只显示首末
     */
    String getName(boolean blur);
}

