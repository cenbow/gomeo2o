package cn.com.gome.trade.dto.ordercreation;

import java.io.Serializable;

import lombok.Data;
/**
 * 活动类型
 * @author miaomiao
 *
 */
@Data
public class ActivityDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6444819284076924455L;
	private Integer type;
	private String id;
	
	
	public enum ActivityType{
        GROUP_PURCHASE(1, "团购"),
        CROSS_BORDER_GOODS(2, "跨境商品"),
        GOME_ONLINE_GOODS(3,"国美在线电器商品"),
        GOME_ONLINE_HWG(4,"海外购商品");
        

        public final int value;
        public final String desc;

        private ActivityType(Integer value, String desc) {
            this.value = value;
            this.desc = desc;
        }
	}

}
