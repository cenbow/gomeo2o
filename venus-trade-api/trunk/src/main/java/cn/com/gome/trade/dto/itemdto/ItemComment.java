package cn.com.gome.trade.dto.itemdto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import cn.com.gome.trade.dto.common.EvtorDto;

@Data
public class ItemComment implements Serializable {
	private static final long serialVersionUID = 3148575950708536491L;
	
	private Long id; //商品评价id
	private EvtorDto evtor;  //评价人
	private Integer score;  //评价分数
	private String content;     //评价内容
	private Long createTime;    //评价时间
	private List<String> images;//评价图片数列表
	private String replyContent; //回复内容

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
