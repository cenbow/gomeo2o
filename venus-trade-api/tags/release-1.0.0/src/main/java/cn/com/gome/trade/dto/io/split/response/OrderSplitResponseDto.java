package cn.com.gome.trade.dto.io.split.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderSplitResponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String uuid; // 识别码

	private String resultFlag; // 成功失败标示 Y：成功 N：失败

	private CodDto codDto; // 校验信息

	private String msg;

	private List<ShippingGroupDtos> shippingGroupDtos = new ArrayList<ShippingGroupDtos>(); // 配送单的信息

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getResultFlag() {
		return resultFlag;
	}

	public void setResultFlag(String resultFlag) {
		this.resultFlag = resultFlag;
	}

	public CodDto getCodDto() {
		return codDto;
	}

	public void setCodDto(CodDto codDto) {
		this.codDto = codDto;
	}

	public List<ShippingGroupDtos> getShippingGroupDtos() {
		return shippingGroupDtos;
	}

	public void setShippingGroupDtos(List<ShippingGroupDtos> shippingGroupDtos) {
		this.shippingGroupDtos = shippingGroupDtos;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
