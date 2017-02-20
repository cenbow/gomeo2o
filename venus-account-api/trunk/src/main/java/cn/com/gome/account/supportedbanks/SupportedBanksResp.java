package cn.com.gome.account.supportedbanks;

import com.gomeo2o.facade.account.entity.SupportBank;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @Description TODO 支持银行列表
 * @author zhuwei
 * @date   2016/7/13 11:47
 */
@Data
public class SupportedBanksResp implements Serializable{
    private static final long serialVersionUID = -1183905986405546989L;

    /**
     * 支持银行列表
     */
    private List<SupportBank> supportedBanks = new ArrayList<SupportBank>();
}
