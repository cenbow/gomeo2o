package cn.com.gome.account.withdrawalbankcards;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Description TODO 提现卡列表response
 * @author zhuwei
 * @date   2016/7/13 11:00
 */
@Data
public class WithdrawalBankCardsResp implements Serializable {
    private static final long serialVersionUID = 3436553415748662632L;

    /**
     * 体现卡列表
     */
    private List<WithdrawalBankCard> withdrawalBankCards = new ArrayList<WithdrawalBankCard>();
}
