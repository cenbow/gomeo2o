package cn.com.gome.trade.dto.common;

import java.io.Serializable;

import lombok.Data;

@Data
public class CommonBase implements Serializable {
	private static final long serialVersionUID = 6060381563849488735L;
	private Long userId;
	private Integer userType;

}
