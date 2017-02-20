package io.terminus.ecp.trade.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class O2mOrderAbnormalInfo implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * ID
     */
    private Long id;
	/**
	 * 父id
	 */
	private Long pid;
	
	/**
	 * 方法
	 */
	private Integer method;
	
	/**
	 * 请求url
	 */
	private String url;
	
	/**
	 * 请求json串
	 */
	private String json;
	
	/**
	 * 异常类型，1：网络异常，2：处理异常
	 */
	private Integer type;
	
	/**
	 * 状态，0：处理日志记录，1：未处理，2：已处理
	 */
	private Integer status;
	
	/**
	 * 订单id
	 */
	private String orderIds;
	
	/**
	 * 总订单id
	 */
	private Long mergerId;
	
	/**
	 * 创建日期
	 */
	private Date createdAt;
	
	/**
	 * 修改日期
	 */
	private Date updatedAt;

}
