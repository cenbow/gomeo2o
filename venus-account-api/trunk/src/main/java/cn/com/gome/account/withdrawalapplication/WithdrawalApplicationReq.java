package cn.com.gome.account.withdrawalapplication;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 *
 * @Description TODO 提交体现申请request
 * @author zhuwei
 * @date   2016/7/12 0012 18:51
 */
@Data
public class WithdrawalApplicationReq implements Serializable {
    private static final long serialVersionUID = -1119566420989805774L;

    private Long bankCardId;
    private Integer money;
    private String paymentPassword;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
