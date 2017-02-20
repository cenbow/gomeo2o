package cn.com.gome.marketing.model;

import cn.com.gome.marketing.model.condition.TimeDownCondition;
import cn.com.gome.marketing.model.way.TimeDownWay;
import io.terminus.ecp.marketing.enums.WayScopeType;
import lombok.Data;

import java.io.Serializable;

/**
 * Desc:执行优惠的商品信息
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-05-07.
 */
@Data
public class TimeDownItem implements Serializable {
    private static final long serialVersionUID = 6963699263856093378L;

    private Long id;

    private Long activityId;        //活动编号

    private Long itemId;            //商品编号(用于一个条件对应一个直降商品)

    private String itemName;        //商品名称

    private Integer price;          //售价

    private Integer downPrice;      //直降价格

    /**
     * 写入条件数据(默认只支持商品订单优惠)
     * @return  TimeDownCondition
     * 返回条件数据
     */
    public TimeDownCondition makeCondition(){
        TimeDownCondition timeDownCondition = new TimeDownCondition();
        timeDownCondition.setId(id);
        timeDownCondition.setItemId(itemId);
        timeDownCondition.setItemName(itemName);
        timeDownCondition.setScope(WayScopeType.ITEM.value());

        return timeDownCondition;
    }

    /**
     * 写入方式数据（默认只支持商品订单优惠）
     * @return  TimeDownWay
     * 返回方式数据
     */
    public TimeDownWay makeWay(){
        TimeDownWay timeDownWay = new TimeDownWay();
        timeDownWay.setPrice(price);
        timeDownWay.setDownPrice(downPrice);
        timeDownWay.setScope(WayScopeType.ITEM.value());

        return timeDownWay;
    }
}
