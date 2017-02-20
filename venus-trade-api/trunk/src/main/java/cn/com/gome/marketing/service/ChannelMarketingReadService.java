//package cn.com.gome.marketing.service;
//
//import io.terminus.common.model.Paging;
//import io.terminus.pampas.client.Export;
//import io.terminus.pampas.common.Response;
//
//import java.util.List;
//
//import cn.com.gome.marketing.model.ChannelMarketing;
//
//public interface ChannelMarketingReadService {
//	
//	/**
//	 * @Description 根据渠道号获取渠道详细信息 
//	 * @author miaomiao
//	 * @date 2016年3月22日 下午3:30:29
//	 * @param couponChannels 渠道号集合
//	 * @return 渠道集合
//	 */
//	public Response<List<ChannelMarketing>> findChannelMarketingByCouponChannel(List<Long> couponChannels);
//	
//	/**
//	 * @Description 查询可用渠道 
//	 * @author miaomiao
//	 * @date 2016年3月22日 下午3:32:59
//	 * @param isUseable 1，可用；0，不可用
//	 * @return 渠道集合
//	 */
//	public Response<List<ChannelMarketing>>  queryChannelMarketing(Integer isUseable);
//	
//	/**
//	 * @Description 分页查询渠道信息 
//	 * @author miaomiao
//	 * @date 2016年3月22日 下午5:57:37
//	 * @param pageNo
//	 * @param size
//	 * @param params
//	 * @return
//	 */
//	@Export(paramNames = {"pageNo","size","couponChannel","couponChannelName","isUseable"})
//	public Response<Paging<ChannelMarketing>> channelMarketingPaging(Integer pageNo, Integer size,Long couponChannel,
//			                                                        String couponChannelName,Integer isUseable);
//
//}
