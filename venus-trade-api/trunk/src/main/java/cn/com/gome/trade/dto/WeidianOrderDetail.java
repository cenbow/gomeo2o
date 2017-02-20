package cn.com.gome.trade.dto;

import io.terminus.ecp.trade.model.OrderExtra;
import io.terminus.ecp.trade.model.OrderItem;

import java.io.Serializable;

import lombok.Data;
import cn.com.gome.trade.dto.userdto.User;

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
