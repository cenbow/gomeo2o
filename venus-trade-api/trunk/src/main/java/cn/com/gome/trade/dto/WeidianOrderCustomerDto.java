package cn.com.gome.trade.dto;

import java.io.Serializable;

import lombok.Data;
import cn.com.gome.trade.dto.userdto.User;

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
