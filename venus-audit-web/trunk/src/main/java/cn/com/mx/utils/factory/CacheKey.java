package cn.com.mx.utils.factory;

/**
 * @Description 缓存key 
 * @author wanggang-ds6
 * @date 2015年12月17日 下午5:28:59
 */
public final class CacheKey {
	
	/**
	 * 缓存key
	 */
	private String key;
	
	/**
	 * @param project 项目，必录
	 * @param business 业务，必录
	 * @param id id，必录
	 * @param cases 事件
	 */
	public CacheKey(String project, String business, String id, String... cases) {
		if (isBlank(project) || isBlank(business) || isBlank(id)) {
			throw new IllegalArgumentException("project、business和id都不能为空！");
		}
		
		// 拼接key
		StringBuilder sbKey = new StringBuilder(32);
		sbKey.append(project).append(":")
			 .append(business).append(":")
			 .append(id);
		if (cases != null && cases.length > 0) {
			for (int i = 0; i < cases.length; i++) {
				sbKey.append(":").append(cases[i]);
			}
		}
		key = sbKey.toString();
	}
	
	/**
	 * @Description 判断是否为空 
	 * @author wanggang-ds6
	 * @date 2015年12月17日 下午5:30:36
	 * @param value 参数
	 * @return true为空
	 */
	private boolean isBlank(String value) {
		if (value == null || value.trim().length() == 0) {
			return true;
		}		
		return false;
	}
	
	/**
	 * @Description 获取缓存key 
	 * @author wanggang-ds6
	 * @date 2015年12月17日 下午5:34:55
	 * @return 缓存key
	 */
	public String getKey() {
		return key;
	}
	
}
