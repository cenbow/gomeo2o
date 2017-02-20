package cn.com.gome.trade.dto.io.returnreq.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReturnRequestFacetResponseDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String auditPassStatu; //审核状态  PASSED 通过 和 REJECT 拒绝
	
	private String state; //退款状态
	
	private Double initialRefundAmount; //原始退款金额
	
	private Double suggestedRefundAmount; //建议退款金额
	
	private List<ReturnDeDuctAmountsDto> returnDeDuctAmounts = new ArrayList<ReturnDeDuctAmountsDto>(); //扣款金额及描述
	
	private ReturnReasonDto reason = new ReturnReasonDto(); //扣款原因及相关订单 配送单 商品

	public String getAuditPassStatu() {
		return auditPassStatu;
	}

	public void setAuditPassStatu(String auditPassStatu) {
		this.auditPassStatu = auditPassStatu;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getInitialRefundAmount() {
		return initialRefundAmount;
	}

	public void setInitialRefundAmount(Double initialRefundAmount) {
		this.initialRefundAmount = initialRefundAmount;
	}

	public Double getSuggestedRefundAmount() {
		return suggestedRefundAmount;
	}

	public void setSuggestedRefundAmount(Double suggestedRefundAmount) {
		this.suggestedRefundAmount = suggestedRefundAmount;
	}

	public List<ReturnDeDuctAmountsDto> getReturnDeDuctAmounts() {
		return returnDeDuctAmounts;
	}

	public void setReturnDeDuctAmounts(
			List<ReturnDeDuctAmountsDto> returnDeDuctAmounts) {
		this.returnDeDuctAmounts = returnDeDuctAmounts;
	}

	public ReturnReasonDto getReason() {
		return reason;
	}

	public void setReason(ReturnReasonDto reason) {
		this.reason = reason;
	}
	
}
