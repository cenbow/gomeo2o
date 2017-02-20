/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: libin-ds9
 * @date: 2015年5月26日 下午6:17:21
 */
package cn.com.gome.trade.dto;

import java.io.Serializable;

/**
 * @Description: TODO
 * @author: libin-ds9
 * @date: 2015年5月26日 下午6:17:21
 */
public class IOConstants implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9140273213171567456L;

	/**
	 * 新业务站点ID
	 */
	public static final String SITE_NAME_XYW = "xinyewuSite";

	/**
	 * 新业务线下微店站点ID
	 */
	public static final String SITE_NAME_XYWWD = "xinyewuxxwdSite";

	/**
	 * 订单取消原因 可空Y occ1-occ10 默认occ1
	 */
	public static final String ORDER_CANCEL_REASON_CODE = "occ1";

	/**
	 * 新业务支付编码 新业务全额先款支付
	 */
	public static final String ORDER_PAY_ACCOUNTCODE = "X1";

	/**
	 * 定义需要走退款审核状态
	 */
	public static final Integer ORDER_STATUS_REFUND = -2000;
}
