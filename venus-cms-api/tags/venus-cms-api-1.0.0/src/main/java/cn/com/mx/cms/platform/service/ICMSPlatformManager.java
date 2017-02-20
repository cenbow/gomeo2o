package cn.com.mx.cms.platform.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.mx.cms.dto.platform.RecommendDto;

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

}
