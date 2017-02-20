package cn.com.mx.count.user.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description member_expert_label 表对应的实体 
 * @author jiale
 * @date 2016年3月3日 下午5:38:11
 */
@ToString
@EqualsAndHashCode
public class Expertlabel implements Serializable {

	private static final long serialVersionUID = -3368367936542139847L;
	
	@Getter
    @Setter
    private Long id;
	
	@Getter
    @Setter
    private String name;//标签名字
	
	@Getter
    @Setter
    private Integer isDisabled;//停用启用状态
	
	@Getter
    @Setter
    private Integer sort;//标签权重
	
	@Getter
    @Setter
    private Integer isDelete;//逻辑删除标示
	
	@Getter
    @Setter
    private String createOperator;//创建人账号
	
	@Getter
    @Setter
    private String updateOperator;//修改人账号
	
	@Getter
    @Setter
    private Date createTime;//创建时间
	
	@Getter
    @Setter
    private Date updateTime;//更新时间

}
