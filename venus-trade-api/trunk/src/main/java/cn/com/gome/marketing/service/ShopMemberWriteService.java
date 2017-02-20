package cn.com.gome.marketing.service;

import cn.com.gome.marketing.model.ShopMember;
import io.terminus.pampas.common.Response;

/**
 * Desc:店铺会员消费写服务
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-05-18.
 */
public interface ShopMemberWriteService {

    /**
     * 创建店铺会员消费信息
     * @param shopMember    店铺会员消费信息
     * @return  Boolean
     */
    public Response<Boolean> createMember(ShopMember shopMember);

    /**
     * 更新店铺会员消费信息
     * @param shopMember    店铺会员消费信息
     * @return  Boolean
     */
    public Response<Boolean> updateMember(ShopMember shopMember);
}
