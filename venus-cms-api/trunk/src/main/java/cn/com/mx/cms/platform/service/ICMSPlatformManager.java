package cn.com.mx.cms.platform.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.mx.cms.dto.platform.RecommendDto;
import cn.com.mx.cms.dto.platform.RecommendMetaDto;

import com.gomeo2o.common.entity.CommonResultEntity;

/**
 * @Description: 推荐位后台
 * @author: 杜伟
 * @date: 2015年11月27日 下午16:39:25
 */
public interface ICMSPlatformManager {

	/**
	 * @Description 添加推荐位
	 * @author duwei
	 * @date 2015年11月27日 下午16:39:25
	 * @param entity
	 * @return CommonResultEntity 通用返回实体
	 */
	public CommonResultEntity<Map> addRecommend(List<RecommendDto> dtos, Integer type);


	/**
	 * @Description 删除推荐位
	 * @author duwei
	 * @date 2015年11月27日 下午16:39:25
	 * @param dto
	 * @return CommonResultEntity 通用返回实体
	 */
	public CommonResultEntity<String> deleteRecommend(RecommendDto dto);

	/**
	 * @Description 查询推荐位列表
	 * @author duwei
	 * @date 2015年11月27日 下午16:39:25
	 * @return CommonResultEntity 通用返回实体
	 */
	public CommonResultEntity<List<RecommendDto>> findRecommends(RecommendDto dto);
	
	
	/**
	 * @Description: 查询第三方接口信息
	 * @author duwei
	 * @param  dto
	 */
	public CommonResultEntity<String> findThirdAgentById(RecommendDto dto);
	/**
	 * 根据推荐位类型查询推荐位列表
	 * @param recommendType
	 * @return
	 */
	public CommonResultEntity<HashMap<String, Object>> findRecommendsByRecommendType(Integer recommendType);

	/**
	 * 
	 * @Description: 新增（修改）推荐位元数据
	 * @author duwei
	 * @param dto
	 */
	public CommonResultEntity<Map> addMetaRecommend(RecommendMetaDto dto);
	
	/**
	 * 
	 * @Description: 查询推荐位元数据列表
	 * @author duwei
	 */
	public CommonResultEntity<List<RecommendMetaDto>> findRecommendMetaList();
	
	/**
	 * 
	 * @Description: 通过ID查询推荐位元数据
	 * @author duwei
	 */
	public CommonResultEntity<RecommendMetaDto> findRecommendMetaById(String id);
	
	/**
	 * 
	 * @Description: 删除推荐位元数据
	 * @param id 推荐位元数据主键ID
	 */
	public CommonResultEntity<Map> delRecommendMeta(RecommendMetaDto dto);
	
	/**
	 * @Description: 获得商品返利金额
	 * @author duwei
	 * @param itemId
	 *            商品ID
	 */
	public CommonResultEntity<Map> getItemRebateAmount(long itemId);
	/**
	 * 
	 * @Description: 店铺是否返利
	 * @author duwei
	 * @param shopId
	 *            店铺ID
	 */
	public CommonResultEntity<Integer> getHasShopRebate(int shopId);
}
