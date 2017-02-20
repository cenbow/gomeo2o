package cn.com.gome.marketing.service;

import cn.com.gome.marketing.model.MemberOrderCount;
import cn.com.gome.marketing.model.ShopMember;
import io.terminus.common.model.Paging;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.Response;

import java.util.List;

/**
 * Desc:店铺会员消费读取服务
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-05-18.
 */
public interface ShopMemberReadService {
    /**
     * 依据编号获取消费纪录
     * @param id    编号
     * @return  ShopMember
     * 返回店铺消费
     */
    public Response<ShopMember> queryById(Long id);

    /**
     * 依据sellerId&userId查询消费纪录
     * @param sellerId  商家编号
     * @param userId    买家编号
     * @return  ShopMember
     * 返回店铺消费
     */
    public Response<ShopMember> queryByMember(Long sellerId, Long userId);

    /**
     * 根据商家信息查询用户的消费记录
     * @param user  商家用户
     * @param pageNo        当前页
     * @param pageSize      每页大小
     * @return  Paging
     * 返回店铺消费信息
     */
    public Response<Paging<ShopMember>> queryMemberByShop(BaseUser user, Integer pageNo, Integer pageSize);

    /**
     * 查询平台用户购买的消费记录
     * @return List
     * 返回消费统计记录
     */
    public Response<List<MemberOrderCount>> queryOrderCount();
}
