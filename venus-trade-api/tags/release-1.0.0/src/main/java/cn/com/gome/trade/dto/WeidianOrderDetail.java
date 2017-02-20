package cn.com.gome.trade.dto;

import io.terminus.ecp.trade.model.OrderExtra;
import io.terminus.ecp.trade.model.OrderItem;
import io.terminus.ecp.user.model.User;
import lombok.Data;

import java.io.Serializable;

/**
 * Desc:
 * Mail: F@terminus.io
 * Data: 15/8/18
 * Author: yangzefeng
 */
@Data
public class WeidianOrderDetail implements Serializable {

    private static final long serialVersionUID = -8642902631659314507L;

    private OrderItem orderItem;

    private User buyer;

    private OrderExtra orderExtra;
}
