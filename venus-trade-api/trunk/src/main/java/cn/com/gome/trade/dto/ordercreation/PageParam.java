package cn.com.gome.trade.dto.ordercreation;

import java.io.Serializable;

import lombok.Data;

@Data
public class PageParam implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1653294421511886704L;
	/**
	 * 页数
	 */
	private int pageNum;
	/**
	 * 每页条数
	 */
	private int numPerPage;
}
