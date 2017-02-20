package cn.com.gome.trade.dto.common;

import java.io.Serializable;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class EvtorDto implements Serializable {
	private static final long serialVersionUID = 3023465779568608771L;
	private Long id; //评价人id
	private String url; //评价人头像
    private String name; //评价人名称
    
    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
