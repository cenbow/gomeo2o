package io.terminus.ecp.config.constants.settle;

/**
 * Created with IntelliJ IDEA
 * Author: songrenfei
 * Date: 15/4/3
 * Time: 下午2:12
 */
public class SettlementSetting {

    public static final String RAT  = "the.max.commission.rate"; //最高佣金费率
    /**
     * 结算业务类型
     * 业务场景1 代理商抽佣从平台抽佣中进行二次抽佣，平台抽佣参与商家收入，代理商抽佣不参与商家收入
     * 业务场景2 代理商抽佣从订单金额中进行抽佣，代理商抽佣参与商家收入（平台抽佣是否存在要根据实际业务需求）
     */
    public static final String BUSINESS_TYPE  = "settle.business.type";
    //1代表正式环境，0代表测试环境
    public static final String ENVIRONMENT_TYPE  = "settle.environment.type";

}
