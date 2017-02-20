package com.gomeo2o.common.page;

import java.io.Serializable;

/**
 * 
 * @描述: 分页参数传递工具类 .
 * @作者: Donglx .
 * @创建时间: 2015-02-24,下午2:23:47 .
 * @版本: 1.0 .
 */
public class PageParam implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6297178964005032338L;
	private int pageNum; // 当前页数
	private int numPerPage; // 每页记录数
	private int offset; //起始位置
	
	public PageParam(){
		super();
	}
	
	public PageParam(int pageNum, int numPerPage) {
		super();
		this.pageNum = pageNum;
		this.numPerPage = numPerPage;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public int getOffset() {
		//计算起始位置
		if(pageNum==0){
			pageNum =1;
		}
		return (pageNum-1)*numPerPage;
	}

}
