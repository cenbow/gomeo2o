package cn.com.gome.trade.dto.userdto;


/**
 * @author Effet
 */
public interface LoginSeller extends LoginUser {

    /**
     * 商家子帐号ID ({@code SubSeller.id}), 主账号为 {@code Seller.MAIN_ID}
     */
    Long getSubId();
}

