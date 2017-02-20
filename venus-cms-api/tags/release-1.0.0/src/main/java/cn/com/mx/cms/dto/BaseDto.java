package cn.com.mx.cms.dto;

import java.io.Serializable;

/**
 * Description: 基础dto
 * @author duwei
 * @date 2015年12月3日 上午11:59:27
 * @version V1.0
 */
public class BaseDto implements Serializable, Cloneable {


	private static final long serialVersionUID = -4583983681579958996L;

	@SuppressWarnings("unchecked")
	public <T> T clone(Class<T> cls) throws CloneNotSupportedException {
		return (T) clone();
	}
}
