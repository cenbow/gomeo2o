package cn.com.gome.marketing.model;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Desc:店铺会员统计数据
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-05-18.
 */
@Data
public class MemberOrderCount implements Serializable {
    private static final long serialVersionUID = -1035749628648643591L;

    private Long userId;            //用户编号

    private String userName;        //用户名称

    private Long sellerId;          //卖家编号

    private String sellerName;      //卖家名称

    private Integer orderAccount;   //订单数量

    private Long priceAccount;      //订单总额

    public MemberOrderCount(ShopMember shopMember){
        this.setUserId(shopMember.getUserId());
        this.setUserName(shopMember.getUserName());
        this.setSellerId(shopMember.getSellerId());
        this.setSellerName(shopMember.getSellerName());
        this.setOrderAccount(shopMember.getOrderAccount());
        this.setPriceAccount(shopMember.getPriceAccount());
    }

    public static List<MemberOrderCount> setOrderCount(List<ShopMember> shopMembers){
        List<MemberOrderCount> memberOrderCounts = Lists.newArrayList();

        for(ShopMember shopMember : shopMembers){
            memberOrderCounts.add(new MemberOrderCount(shopMember));
        }

        return memberOrderCounts;
    }
}
