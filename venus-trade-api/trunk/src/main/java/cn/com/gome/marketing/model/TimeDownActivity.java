package cn.com.gome.marketing.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Desc:国美直降活动
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-05-07.
 */
@Data
public class TimeDownActivity implements Serializable {
    private static final long serialVersionUID = 3507089339503597292L;

    private Long id;                    //优惠活动编号

    @NotNull(message = "activity.name.null")
    @Length(min = 10, max = 40, message = "activity.name.error")
    private String name;                //优惠活动名称

    private String title;               //优惠标题

    private String image;               //优惠活动的图片地址

    private Integer type;               //优惠类型（1.平台优惠，2.商家优惠）

    private Long sellerId;              //卖家编号

    private Date startTime;             //优惠活动的开始时间

    private Date endTime;               //优惠活动的结束时间

    private String description;         //详情介绍

    private Integer status;             //优惠活动状态（-1:活动停止，0:待发布，1:已发布，2:活动开始，3:活动结束）

    private Date createdAt;             //创建时间

    private Date updatedAt;             //结束时间
}
