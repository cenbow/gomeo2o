package cn.com.gome.event.item;

import io.terminus.ecp.event.item.ItemInfoEvent;

/**
 * @author Effet
 */
public class GomeItemDistributionOffEvent extends ItemInfoEvent {
    public GomeItemDistributionOffEvent(long id) {
        super(id);
    }

    public GomeItemDistributionOffEvent(Iterable<Long> ids) {
        super(ids);
    }
}
