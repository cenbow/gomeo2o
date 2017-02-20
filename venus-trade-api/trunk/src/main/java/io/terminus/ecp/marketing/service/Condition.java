package io.terminus.ecp.marketing.service;

import static io.terminus.common.utils.Arguments.isEmpty;
import static io.terminus.common.utils.Arguments.isNull;
import io.terminus.common.utils.JsonMapper;
import io.terminus.ecp.plugin.exception.ConditionDataException;
import io.terminus.ecp.plugin.model.FatTradeDataDto;
import io.terminus.ecp.plugin.model.MarketingOrder;
import io.terminus.ecp.plugin.model.MarketingOrderItem;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Desc: 条件接口
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 3/16/15.
 */
public abstract class Condition<T extends Serializable> {
    private static final JsonMapper JSON_MAPPER = JsonMapper.nonDefaultMapper();

    /**
     * 将Condition的json数据解析成对应的object
     * @param conValue  条件json数据
     * @return  T
     * 返回类型
     */
    public abstract T conditionObject(String conValue);

    /**
     * 校验条件数据的正确性
     * @param conObj    条件数据对象
     * @param context   条件上下文
     * @return  Boolean
     * 返回数据校验是否成功
     */
    public abstract Boolean checkCondition(T conObj, Map<String, Object> context);

    /**
     * 获得条件的描述
     * @return String
     */
    public abstract String desc(T value);

    /**
     * 获得条件的名称
     * @return String
     */
    public abstract String name();

    /**
     * 获取条件的ID
     * @return Integer
     */
    public abstract Integer id();

    /**
     * 判断是否满足条件
     * @param orderItems    子订单集合
     * @param value         数据的json字符串value
     * @return List
     * 返回一个命中该规则的子订单
     */
    public abstract List<MarketingOrderItem> isMatch(List<MarketingOrderItem> orderItems, T value);

    /**
     * 判断是否满足条件
     * @param order         总订单集合
     * @param value         数据的json字符串value
     * @return List
     * 返回命中该规则的总订单
     */
    public abstract MarketingOrder isMatch(MarketingOrder order, T value);

    /**
     * 判断是否满足条件
     * @param fatTradeDataDto   订单对象
     * @param value             数据的json字符串value
     * @return FatTradeDataDto
     * 返回一个命中该规则的订单
     */
    public abstract FatTradeDataDto isMatch(FatTradeDataDto fatTradeDataDto, T value);

    /**
     * json 数据转换分析
     * @param value JSON数据
     * @param clazz 数据对象
     * @param <T>   放回数据对象
     * @return  T
     * 返回校验数据
     */
    protected <T> T checkValue(String value, Class<T> clazz){
        if(isEmpty(value)){
            throw new ConditionDataException("can`t Analyze data with " + value + ",the data is empty.");
        }

        T t = JSON_MAPPER.fromJson(value, clazz);

        if(isNull(t)){
            throw new ConditionDataException("can`t Analyze data with " + value);
        }

        return t;
    }
}
