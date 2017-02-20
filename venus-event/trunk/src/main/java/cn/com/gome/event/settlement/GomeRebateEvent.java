package cn.com.gome.event.settlement;
import cn.com.gome.settlement.dto.RebateDto;
import cn.com.gome.settlement.model.GomeSettlementAbnormalTrack;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 返利写入 mock
 * Created with IntelliJ IDEA
 * Author: songrenfei
 * Date: 15/1/5
 * Time: 下午10:25
 */
public class GomeRebateEvent {

    @Getter @Setter
    private List<RebateDto> rebateDtos;

    public GomeRebateEvent(List<RebateDto> rebateDtos){
        this.rebateDtos = rebateDtos;
    }
}
