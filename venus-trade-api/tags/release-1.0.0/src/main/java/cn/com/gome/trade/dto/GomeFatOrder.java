package cn.com.gome.trade.dto;

import io.terminus.ecp.trade.dto.FatOrder;
import io.terminus.ecp.trade.dto.SkuIdAndInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Created by yangzefeng on 15/5/22
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class GomeFatOrder extends FatOrder {

    private static final long serialVersionUID = 3568768558369045469L;

    private Boolean isGome;

    /**
     * 配送信息
     */
    private String remark;
}
