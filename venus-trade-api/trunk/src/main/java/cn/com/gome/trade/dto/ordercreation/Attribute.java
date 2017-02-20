package cn.com.gome.trade.dto.ordercreation;

import java.io.Serializable;

import lombok.Data;

@Data
public class Attribute implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -475799183474594911L;
	private String name;
	private String value;

}
