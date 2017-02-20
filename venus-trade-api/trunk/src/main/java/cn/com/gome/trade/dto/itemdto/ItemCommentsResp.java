package cn.com.gome.trade.dto.itemdto;

import cn.com.gome.trade.dto.shoppingcart.ShoppingCartItem;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import io.terminus.common.model.Indexable;
import lombok.Data;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @Description TODO 将原有的itemapi中item依赖替换成此依赖
 * @author wangjiatian
 * @date 2016年6月22日 下午3:58:00
 */
@Data
public class ItemCommentsResp implements Serializable {
	
	private static final long serialVersionUID = -4091628932657224998L;

	List<ItemComment> ItemComments = Lists.newArrayList();
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
