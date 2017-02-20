/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description 国美币交易限额信息
 * @author fengxin
 * @date 2015年11月13日 下午4:19:18
 */
package com.gomeo2o.service.account.dao.impl;

import org.springframework.stereotype.Repository;

import com.gomeo2o.common.core.dao.BaseDaoImpl;
import com.gomeo2o.facade.account.entity.VirtualLimitInfo;
import com.gomeo2o.service.account.dao.VirtualLimitInfoDao;

/**
 * @Description 国美币交易限额信息dao实现
 * @author fengxin
 * @date 2015年11月13日 下午4:19:18
 */
@Repository("virtualLimitInfoDao")
public class VirtualLimitInfoDaoImpl extends BaseDaoImpl<VirtualLimitInfo> implements VirtualLimitInfoDao{

}
