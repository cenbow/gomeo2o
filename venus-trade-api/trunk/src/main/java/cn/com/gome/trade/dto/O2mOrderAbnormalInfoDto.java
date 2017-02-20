package cn.com.gome.trade.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Created by wangzhenpeng on 2016-5-4 11:57:08
 */
@Data
public class O2mOrderAbnormalInfoDto implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1498480657800349950L;

	/**
	 * 鐖秈d
	 */
	private int pid;
	
	/**
	 * 璇锋眰url
	 */
	private String url;
	
	/**
	 * 璇锋眰json涓�
	 */
	private String json;
	
	/**
	 * 寮傚父绫诲瀷锛�1锛氱綉缁滃紓甯革紝2锛氬鐞嗗紓甯�
	 */
	private int type;
	
	/**
	 * 鐘舵�侊紝0锛氬鐞嗘棩蹇楄褰曪紝1锛氭湭澶勭悊锛�2锛氬凡澶勭悊
	 */
	private int status;
	
	/**
	 * 璁㈠崟id
	 */
	private String orderIds;
	
	/**
	 * 鎬昏鍗昳d
	 */
	private Long mergerId;
	
	/**
	 * 鍒涘缓鏃ユ湡
	 */
	private Date createdAt;
	
	/**
	 * 淇敼鏃ユ湡
	 */
	private Date updatedAt;
	
}
