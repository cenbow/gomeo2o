package cn.com.gome.trade.service;

import java.text.ParseException;

import cn.com.gome.trade.dto.express.request.Result;

/**
 * @author:zhangyihang
 * @Description:
 * @Date:2015年6月8日
 * @resulet 结果集
 * @orderId 订单Id
 */
public interface GomeTradeExpresslvService {
	public void save(Result result,String orderId) throws ParseException;
}
