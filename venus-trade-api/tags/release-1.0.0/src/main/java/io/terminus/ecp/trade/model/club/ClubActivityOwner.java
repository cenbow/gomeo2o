package io.terminus.ecp.trade.model.club;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Author:Guo Chaopeng
 * Created on 12/23/14.
 */
@Data
public class ClubActivityOwner implements Serializable {

    private static final long serialVersionUID = 3713354286277063575L;

    private Long id;
    private Long sellerId;              //发布活动商家id
    private Long copartnerInfoId;       //可参与活动的企业id
    private String companyName;         //可参与活动的企业名称
    private Integer activityCount;      //活动数量
    private Date createdAt;             //创建时间
    private Date updatedAt;             //更新时间

}
