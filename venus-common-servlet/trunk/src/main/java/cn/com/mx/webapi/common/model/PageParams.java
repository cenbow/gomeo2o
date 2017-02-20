package cn.com.mx.webapi.common.model;
/**
 * @description 分页参数
 * @date 2015-04-24
 * @author shangshengfang
 * @version 1.0
 */
public class PageParams {
	int numPerPage;			//每页的数量
	int pageNum;				//第几页
	Long lastRecordId;		//上一页最后一条记录的ID
	
	
	public int getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public Long getLastRecordId() {
		return lastRecordId;
	}
	public void setLastRecordId(Long lastRecordId) {
		this.lastRecordId = lastRecordId;
	}
	
	@Override
	public String toString() {
		return "PageParams [numPerPage=" + numPerPage + ", pageNum=" + pageNum
				+ ", lastRecordId=" + lastRecordId + "]";
	}
}
