package cn.com.gome.trade.dto.comment;
import java.util.Arrays;

import lombok.Data;

@Data
public class CommentProductBean {
	
	private Long orderItemId;//商品id
	private Integer commentScore;//评价分数
	private String commentContent;//评价内容
	private Boolean isLoveLife;//是否分享到爱生活
	private String shareUrl;//分享链接
	
	private String[] imageUrlArray;//评价图片 addtime 2016年4月5日18:05:49 author wangjiatian
	
	private Integer serviceGrade;//服务评分 addtime 2016年5月12日10:56:31 author wangjiatian
	private Integer expressService;//物流评分 addtime 2016年5月12日10:56:36 author wangjiatian
	
	@Override
	public String toString() {
		return "CommentProductBean [orderItemId=" + orderItemId + ", commentScore="
				+ commentScore + ", commentContent=" + commentContent
				+ ", isLoveLife=" + isLoveLife + ", shareUrl=" + shareUrl
				+ ", imageUrlArray=" + Arrays.toString(imageUrlArray)
				+ ", serviceGrade=" + serviceGrade + ", expressService="
				+ expressService + "]";
	}
}