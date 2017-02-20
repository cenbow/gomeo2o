
package cn.com.mx.cms.recommend.service;

import java.util.List;

import cn.com.mx.cms.dto.platform.RecommendDto;

import com.gomeo2o.common.entity.CommonResultEntity;

/**
 * @Description 推荐位相关服务接口 
 * @author zhangxianpeng
 * @date 2015年12月1日 下午8:44:46
 */
public interface IRecommendFacade {
	

	/**
	 * @Description 生活推荐位列表 
	 * @author zhangxianpeng
	 * @date 2015年11月27日 下午8:10:30
	 * @return
	 */
	public CommonResultEntity<List<RecommendDto>> findRecommendList();
	
	/**
	 * @Description 找便宜超级返列表
	 * @author zhangxianpeng
	 * @date 2015年11月27日 下午8:10:30
	 * @return
	 */
	public CommonResultEntity<List<RecommendDto>> findSuperRebateList();

	/**
	 * @Description 根据推荐类型查询推荐列表
	 * @author zhangxianpeng
	 * @date 2015年11月27日 下午8:10:30
	 * @return
	 */
	public CommonResultEntity<List<RecommendDto>> findRecommendListByType(int type);

}
