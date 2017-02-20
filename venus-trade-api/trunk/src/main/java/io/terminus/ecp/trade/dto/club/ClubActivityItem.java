package io.terminus.ecp.trade.dto.club;

import io.terminus.ecp.trade.model.club.ClubActivity;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import cn.com.gome.trade.dto.itemdto.ClubItemDiscount;
import cn.com.gome.trade.dto.userdto.CopartnerInfo;

/**
 * Author:Guo Chaopeng
 * Created on 12/24/14.
 */
public class ClubActivityItem implements Serializable {

    private static final long serialVersionUID = -3940061284294637995L;

    @Setter
    @Getter
    private CopartnerInfo copartnerInfo;              //发布活动的商家公司信息

    @Setter
    @Getter
    private ClubActivity clubActivity;                //活动信息

    @Setter
    @Getter
    private List<ClubItemDiscount> clubItemDiscounts; //商品信息

}
