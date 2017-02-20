package io.terminus.ecp.marketing.dto;

import lombok.Data;
import java.io.Serializable;

/**
 * Desc:优惠方式返回数据
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-31.
 */
@Data
public class WayDiscount implements Serializable {
    private static final long serialVersionUID = -9123301840725418395L;

    private Integer scope;      //作用域（1：订单，2：商品）

    private Integer wayType;    //优惠方式(WayType)

    private Integer disMoney;   //优惠的金额(其余的优惠方式就只返回描述信息, 保留2位小数：0.01*100)

    private boolean noShipFee;  //是否免邮费

    private String description; //描述优惠信息（周年庆:减免50元）->activityName:way
}
