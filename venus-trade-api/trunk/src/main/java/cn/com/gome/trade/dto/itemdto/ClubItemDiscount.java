package cn.com.gome.trade.dto.itemdto;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yangzefeng on 14/12/24
 */
@Data
public class ClubItemDiscount implements Serializable {
    private static final long serialVersionUID = -9150065232256051966L;

    private Long id;

    private Long itemId;            //商品id

    private Long sellerId;          //卖家id

    private String itemName;        //商品名称

    private String itemImage;       //商品主图

    private Integer itemPrice;      //团购价

    private Integer originPrice;    //原价

    private Integer specialPrice;   //专享价

    private Integer discountPercent;    //优惠折扣 x100后返回

    private Date createdAt;

    private Date updatedAt;
}

