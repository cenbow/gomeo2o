/**
 * @类名: O2mOrderAbnormalInfoService.java
 * @描述: 
 * @作者 wangzhenpeng
 * @创建时间 2016年5月4日14:52:45
 */
package cn.com.gome.trade.service;

import io.terminus.ecp.trade.model.O2mOrderAbnormalInfo;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @描述: 订单服务
 * @作者 wangzhenpeng
 * @创建时间 2015年5月7日 下午5:29:28
 */

@Service("o2mOrderAbnormalInfoService")
public interface O2mOrderAbnormalInfoService {

	/**
	 * @描述:创建订单异常信息记录
	 * @作者 wangzhenpeng
	 * @创建时间 2016年5月4日14:55:35
	 * @param id
	 */
	public Long createO2mOrderAbnormalInfo(O2mOrderAbnormalInfo o2mOrderAbnormalInfo);

	/**
	 * @Description: 更新订单异常信息记录
	 * @author: wangzhenpeng
	 * @date: 2016年5月4日14:55:40
	 * @param order
	 * @return Boolean
	 */
	public Boolean updateO2mOrderAbnormalInfo(O2mOrderAbnormalInfo o2mOrderAbnormalInfo);

	/**
	 * @描述:根据id查询订单异常信息信息
	 * @作者 wangzhenpeng
	 * @创建时间 2016年5月4日15:05:18
	 * @param id
	 * @return 
	 */
	public O2mOrderAbnormalInfo findById(Long id);

	/**
	 * @描述:根据id，pid，status，type
	 * @作者 wangzhenpeng
	 * @创建时间 2015年5月9日 上午10:30:52
	 * @param id
	 * @return
	 */
	public List<O2mOrderAbnormalInfo> findBy(O2mOrderAbnormalInfo o2mOrderAbnormalInfo);

}
