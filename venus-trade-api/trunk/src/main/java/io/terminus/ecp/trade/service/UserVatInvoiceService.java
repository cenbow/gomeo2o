/*
 * Copyright (c) 2015 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.service;


import io.terminus.ecp.trade.model.UserVatInvoice;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;

/**
 *
 * 增值税发票
 *
 * Mail: xiao@terminus.io <br>
 * Date: 2014-07-05 4:54 PM  <br>
 * Author: xiao
 */
public interface UserVatInvoiceService {


    /**
     * 获取指定用户的增值税发票定义
     *
     * @param userId 用户id
     * @return 增值税发票定义信息
     */
    Response<UserVatInvoice> getByUserId(Long userId);

    /**
     * 获取当前用户的增值税发票定义
     *
     * @param user  用户
     * @return 增值税发票定义信息
     */
    @Export(paramNames = {"user"})
    Response<UserVatInvoice> getByUser(BaseUser user);


    /**
     * 更新增值税发票定义
     *
     * @param userVatInvoice  待创建的增值税发票定义
     * @param user            创建增值税发票的用户信息
     * @return  创建成功的增值税发票id
     */
    Response<Long> create(UserVatInvoice userVatInvoice, BaseUser user);

    /**
     * 更新增值税发票定义
     *
     * @param userVatInvoice  待更新的增值税发票定义
     * @param user            更新增值税发票的用户信息
     * @return  是否执行成功
     */
    Response<Boolean> update(UserVatInvoice userVatInvoice, BaseUser user);
}
