package cn.com.gome.trade.dto.common;

import java.io.Serializable;

import lombok.Data;

@Data
public class PageParam implements Serializable {
	private static final long serialVersionUID = 6964350356246444576L;
	/**
	 * 页数
	 */
	private int pageNum;
	/**
	 * 每页条数
	 */
	private int pageSize;
}