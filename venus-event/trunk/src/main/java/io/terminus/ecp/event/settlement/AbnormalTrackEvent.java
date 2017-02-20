package io.terminus.ecp.event.settlement;

import io.terminus.ecp.settlement.model.SettlementAbnormalTrack;
import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA
 * Author: songrenfei
 * Date: 15/1/5
 * Time: 下午10:25
 */
public class AbnormalTrackEvent {

    @Getter @Setter
    private SettlementAbnormalTrack settlementAbnormalTrack;

    public AbnormalTrackEvent(SettlementAbnormalTrack settlementAbnormalTrack){
        this.settlementAbnormalTrack = settlementAbnormalTrack;
    }
}
