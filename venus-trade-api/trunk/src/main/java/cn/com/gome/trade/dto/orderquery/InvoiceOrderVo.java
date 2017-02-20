package cn.com.gome.trade.dto.orderquery;

public class InvoiceOrderVo {
	private int type;			//发票类型   1：普通发票。2：增值税发票
	private String title;		//发票抬头类型内容
	private int titleType;		//发票抬头类型
	private String content;		//发票内容
	
	public int getTitleType() {
		return titleType;
	}
	public void setTitleType(int titleType) {
		this.titleType = titleType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
