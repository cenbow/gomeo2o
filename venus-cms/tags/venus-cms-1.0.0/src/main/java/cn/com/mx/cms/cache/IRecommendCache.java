package cn.com.mx.cms.cache;

import java.util.List;
import java.util.Map;

import cn.com.mx.cms.dto.platform.RecommendDto;

/**
 * 
 * Description: 推荐位缓存接口
 * 
 * @author duwei
 * @date 2015年11月28日 下午3:26:28
 * @version V1.0
 */
public interface IRecommendCache {

	/**
	 * @Description 写推荐位缓存
	 * @author zhangxianpeng
	 * @date 2015年12月3日 下午2:59:29
	 * @param 推荐位类型
	 * @param dto
	 *            推荐位dto
	 */
	void writeRecommendDto(String recommendType, List<RecommendDto> dto);

	/**
	 * 
	 * @Description 读推荐位所有缓存
	 * @author zhangxianpeng
	 * @date 2015年12月3日 下午2:59:48
	 * @return
	 */
	Map<String, List<RecommendDto>> getRecommendDto();
	
	/**
	 * 
	 * @Description 读某类型推荐位缓存
	 * @author zhangxianpeng
	 * @date 2015年12月3日 下午2:59:48
	 * @return
	 */
	List<RecommendDto> getRecommendDto(String recommendType);

	/**
	 * 
	 * @Description 删除某类型推荐位缓存
	 * @author zhangxianpeng
	 * @date 2015年12月3日 下午8:51:14
	 * @param 推荐位类型
	 */
	void deleteRecommendDto(String recommendType);

	/**
	 * 
	 * @Description 删除所有推荐位缓存
	 * @author zhangxianpeng
	 * @date 2015年12月3日 下午8:51:34
	 */
	void deleteRecommendDto();
}
