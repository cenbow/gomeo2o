/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author kl_chaizhilei
 * @date 2016年1月28日 上午11:52:24
 */
package cn.com.mx.base;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description 基本control
 * @author kl_chaizhilei
 * @date 2016年1月28日 上午11:52:24
 */
@Slf4j
public class BaseController {

	protected String id;

	protected String account;

	protected String password;

	protected String tel;

	protected final Lock lock = new ReentrantLock();

	/**
	 * 取得session值
	 * 
	 * @param request
	 */
	protected void getSessionData(HttpServletRequest request) {
		HttpSession session = request.getSession(false);// 始终不创建
		if (session == null)
			return;
		try {
			lock.lock();
			// 使用的时候需要检测是否为null,如果为null即为认证失败或者没有登录
			id = session.getAttribute(Contants.SESSION_USERID) == null ? null : String.valueOf(session
					.getAttribute(Contants.SESSION_USERID));
			account = session.getAttribute(Contants.SESSION_ACCOUNT) == null ? null : String.valueOf(session
					.getAttribute(Contants.SESSION_ACCOUNT));
		} finally {
			lock.unlock();
		}
	}

	// 移除session值
	protected void removeSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		if (session.isNew()) {
			return;
		}
		try {
			request.getSession().removeAttribute(Contants.SESSION_USERID);
			request.getSession().removeAttribute(Contants.SESSION_ACCOUNT);
		} catch (IllegalStateException e) {
			log.error("remove session attribute IllegalStateException:", e);
		}
	}

}
