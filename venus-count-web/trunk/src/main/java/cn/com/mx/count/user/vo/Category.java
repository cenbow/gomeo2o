package cn.com.mx.count.user.vo;

/**
 * @Description 达人种类 
 * @author jiale
 * @date 2016年3月3日 下午4:40:57
 */
public class Category {

	private Long id;	//标签Id
	private String name;	//标签名称
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
