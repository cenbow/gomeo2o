package cn.com.gome.trade.dto.ordercreation;

import java.io.Serializable;

import lombok.Data;
/**
 * 直降活动
 * @author miaomiao
 *
 */
@Data
public class Activity implements Serializable{

	private static final long serialVersionUID = -4943937420291601163L;
	private Long id;
	private String name;
	private Integer type;
	private String budgetCode;
}
