package cn.com.mx.cms.dto;

/**
 * 
 * Description: 通用dto
 * @author duwei
 * @date 2015年12月3日 下午12:01:42
 * @version V1.0
 */
public class CommonDto extends BaseDto {
	private static final long serialVersionUID = -2413659504128512886L;
	private String userId; // 用户ID

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
