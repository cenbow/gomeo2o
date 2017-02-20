package cn.com.gome.trade.service;

import cn.com.gome.trade.dto.*;
import io.terminus.common.model.Paging;
import io.terminus.ecp.trade.dto.SellerCommentDto;
import io.terminus.ecp.trade.model.OrderItem;
import io.terminus.ecp.trade.service.OrderReadService;
import io.terminus.ecp.user.dto.LoginUser;
import io.terminus.pampas.client.Export;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.InnerCookie;
import io.terminus.pampas.common.Response;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * Created by yangzefeng on 15/4/23
 */
public interface GomeOrderReadService extends OrderReadService {

    /**
     * 查询当前登录用户的永久购物车
     * @param baseUser 当前登录用户
     * @return 购物车信息
     */
    @Export(paramNames = {"baseUser", "adderssId"})
    Response<List<CartItemAndWeixinInfo>> getPermanentWithWeixinInfo(BaseUser baseUser, Integer adderssId);

    /**
     * 查询当前登录用户的永久购物车的sku的种类
     * @param baseUser 当前登录用户
     */
    @Override
    @Export(paramNames = {"baseUser"})
    Response<Integer> getPermanentCount(BaseUser baseUser);

    /**
     * 订单预览页
     * @param skus skuId和对应的sku数量
     * @param wechatInfos 微店信息
     * @param addressSelect 是否选择了地址
     * @return 订单预览页信息
     */
    @Export(paramNames = {"skus", "wechatInfos", "addressSelect", "loginer", "cookie"})
    Response<List<GomePreOrder>> gomePreViewOrder(@NotNull(message = "skus.invalid") String skus,
                                              String wechatInfos,
                                          Boolean addressSelect,
                                          @NotNull(message = "user.not.login") BaseUser loginer,
                                          @NotNull(message = "cookie.invalid") InnerCookie cookie);

    /**
     * 获取拆单后的订单数量
     * @param skuIdAndQuantity skuId和购买数量
     * @param addressId 配送地址id
     * @param loginer 当前登录用户id
     * @return 拆单后的订单数量
     */
    Response<Integer> getGomeOrderNum(Map<Long, Integer> skuIdAndQuantity, Integer addressId, BaseUser loginer);

    /**
     * 判断是否可以提醒发货
     * @param orderId 订单id
     * @return 判断结果
     */
    Response<Boolean> remindPayKeyExist(Long orderId);

    /**
     * 微店商家的订单列表
     * @param referenceId 微店id
     * @param pageNo 页码
     * @param size 每页大小
     * @return 微店商家子订单列表
     */
    Response<Paging<OrderItem>> weidianOrders(String referenceId, String status, String hasComment, Integer pageNo, Integer size);

    Response<WeidianOrderDetail> getWeidianOrderDetail(Long orderItemId);

    /**
     * 微店商品评价列表
     * @param pageNo 页码
     * @param size 每页大小
     * @param loginUser 当前登录用户
     */
    Response<Paging<SellerCommentDto>> weidianPagingOrderItem(Integer pageNo, Integer size, Long referenceId);

    /**
     * 微店客户管理列表
     * @param pageNo 页码
     * @param size 每页大小
     * @param referenceId 微店id
     */
    Response<Paging<WeidianOrderCustomerDto>> weidianPagingCustomer(Integer pageNo, Integer size, Long referenceId);

    /**
     * 查询订单记录信息
     * @param referenceId  微店id
     * @param buyerId   买家id
     * @param status    订单状态
     * @param pageNo    当前页
     * @param size      每页显示条数
     * @return  Paging
     * 返回分页数据
     */
    Response<Paging<OrderItem>> queryBuyerOrderByReferenceId(Long referenceId, Long buyerId, Integer status, Integer pageNo, Integer size);

}
