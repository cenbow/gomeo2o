package cn.com.gome.trade.dto;

import java.io.Serializable;

import io.terminus.ecp.trade.dto.PreOrder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by yangzefeng on 15/5/22
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class GomePreOrder extends PreOrder  implements Serializable{


	private static final long serialVersionUID = -4297512637912260932L;

	/**
     * 是否为国美在线商品
     */
    private Boolean isGome;
}
