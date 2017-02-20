/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author kl_chaizhilei
 * @date 2016年1月18日 下午3:00:36
 */
package cn.com.mx.count.utils;

import java.util.UUID;

/**
 * @Description UUID工具类
 * @author kl_chaizhilei
 * @date 2016年1月18日 下午3:00:36
 */
public class UUIDUtils {
	private UUIDUtils() {
	}

	// 生成随机UUID
	public static String creatUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
