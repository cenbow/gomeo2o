package cn.com.gome.trade.dto;

import io.terminus.ecp.trade.model.OrderExtra;
import io.terminus.ecp.trade.model.OrderItem;
import io.terminus.ecp.user.model.User;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: luoys
 * Date: 2015-08-27 15:57
 */
@Data
public class WeidianOrderCustomerDto implements Serializable {

    private static final long serialVersionUID = -1047266545385465950L;

    private User buyer;

    private Integer allTradeCount;

    private Integer allTradeMoney;

}
