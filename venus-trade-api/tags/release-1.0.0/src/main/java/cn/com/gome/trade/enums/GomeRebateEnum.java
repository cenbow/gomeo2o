/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description: TODO 
 * @author: donglianxing
 * @date: 2015年3月6日 上午10:59:43
 */
package cn.com.gome.trade.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 推返利订单类型
 * @author: donglianxing
 * @date: 2015年3月6日 上午10:59:43
 */
public enum GomeRebateEnum {

	STATUS1("待支付", 1), //妥投前 正向 总订单
	STATUS2("订单取消", 2), //妥投前 逆向 总订单
	STATUS3("已拒收", 3), //妥投前 逆向 总订单
//	STATUS4("退款成功", 4), //已取消 这个不用推了
	STATUS5("订单妥投", 5), //妥投 正向 总订单 
	STATUS6("退货申请", 6), //妥投后 逆向 子订单 
	STATUS7("退货入库", 7), //妥投后 逆向 子订单   //退货款
	STATUS8("退货不成功", 8), //妥投后 逆向 子订单  //审核不通过
	STATUS9("换货申请", 9), //妥投后 逆向 子订单
	STATUS10("换货成功", 10), //妥投后 逆向 子订单 买家确认收货
	STATUS11("换货不成功", 11); //妥投后 逆向 子订单  //审核不通过 //买家拒收，卖家入库

	/** 描述 */
	private String desc;
	/** 枚举值 */
	private int value;

	private GomeRebateEnum(String desc, int value) {
		this.desc = desc;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public static GomeRebateEnum getEnum(int value){
		GomeRebateEnum resultEnum = null;
		GomeRebateEnum[] enumAry = GomeRebateEnum.values();
		for(int i = 0;i<enumAry.length;i++){
			if(enumAry[i].getValue() == value){
				resultEnum = enumAry[i];
				break;
			}
		}
		return resultEnum;
	}
	
	public static Map<String, Map<String, Object>> toMap() {
		GomeRebateEnum[] ary = GomeRebateEnum.values();
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
		for (int num = 0; num < ary.length; num++) {
			Map<String, Object> map = new HashMap<String, Object>();
			String key = String.valueOf(getEnum(ary[num].getValue()));
			map.put("value", String.valueOf(ary[num].getValue()));
			map.put("desc", ary[num].getDesc());
			enumMap.put(key, map);
		}
		return enumMap;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List toList(){
		GomeRebateEnum[] ary = GomeRebateEnum.values();
		List list = new ArrayList();
		for(int i=0;i<ary.length;i++){
			Map<String,String> map = new HashMap<String,String>();
			map.put("value",String.valueOf(ary[i].getValue()));
			map.put("desc", ary[i].getDesc());
			list.add(map);
		}
		return list;
	}


}
