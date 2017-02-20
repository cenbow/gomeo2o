package cn.com.gome.event.settlement;
import cn.com.gome.settlement.model.GomeSettlementAbnormalTrack;
import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA
 * Author: songrenfei
 * Date: 15/1/5
 * Time: 下午10:25
 */
public class GomeAbnormalTrackEvent {

    @Getter @Setter
    private GomeSettlementAbnormalTrack gomeSettlementAbnormalTrack;

    public GomeAbnormalTrackEvent(GomeSettlementAbnormalTrack gomeSettlementAbnormalTrack){
        this.gomeSettlementAbnormalTrack = gomeSettlementAbnormalTrack;
    }
}
