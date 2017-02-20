/**   
 * @Title: InvoiceDto.java 
 * @Package com.gomeo2o.facade.order.vo 
 * @Description: TODO
 * @author: liupeiqi 
 * @date 2015年3月27日 上午9:40:51 
 * @version V1.0   
 */

package cn.com.gome.trade.dto.io.save.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName: InvoiceDto
 * @Description: TODO
 * @author liupeiqi
 * @date 2015年3月27日 上午9:40:51
 * 
 */

public class InvoiceDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String invoiceType; // 发票类型 可空N

	private String head = "个人"; // 发票抬头 可空N

	private String headType; // 发票抬头类型 可空N
	
	private String contentType = "0"; 
	
	private String invoicestate = "1";
	
	private List<InvoiceClassInfosDto> invoiceClassInfos = new ArrayList<InvoiceClassInfosDto>();

	/**
	 * @return invoiceType
	 */

	public String getInvoiceType() {
		return invoiceType;
	}

	/**
	 * @param invoiceType
	 *            the invoiceType to set
	 */
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	/**
	 * @return head
	 */

	public String getHead() {
		return head;
	}

	/**
	 * @param head
	 *            the head to set
	 */
	public void setHead(String head) {
		this.head = head;
	}

	/**
	 * @return headType
	 */

	public String getHeadType() {
		return headType;
	}

	/**
	 * @param headType
	 *            the headType to set
	 */
	public void setHeadType(String headType) {
		this.headType = headType;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getInvoicestate() {
		return invoicestate;
	}

	public void setInvoicestate(String invoicestate) {
		this.invoicestate = invoicestate;
	}

	public List<InvoiceClassInfosDto> getInvoiceClassInfos() {
		return invoiceClassInfos;
	}

	public void setInvoiceClassInfos(List<InvoiceClassInfosDto> invoiceClassInfos) {
		this.invoiceClassInfos = invoiceClassInfos;
	}
	
}
