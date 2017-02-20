package io.terminus.ecp.marketing.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Desc:
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-04-03.
 */
public class DefOrderDto implements Serializable {
    private static final long serialVersionUID = -1967242931318139748L;

    @Getter
    @Setter
    private List<DefOrder> defOrders;
}
