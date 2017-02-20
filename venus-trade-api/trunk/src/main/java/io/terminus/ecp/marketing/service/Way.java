package io.terminus.ecp.marketing.service;

import static io.terminus.common.utils.Arguments.isEmpty;
import static io.terminus.common.utils.Arguments.isNull;
import static io.terminus.common.utils.Arguments.notEmpty;
import static io.terminus.common.utils.Arguments.notNull;
import io.terminus.common.utils.JsonMapper;
import io.terminus.ecp.marketing.dto.WayDiscount;
import io.terminus.ecp.plugin.exception.WayDataException;
import io.terminus.ecp.plugin.model.DiscountData;
import io.terminus.ecp.plugin.model.FatTradeDataDto;
import io.terminus.ecp.plugin.model.MarketingOrder;
import io.terminus.ecp.plugin.model.MarketingOrderItem;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.dozer.util.ReflectionUtils;

/**
 * Desc: 优惠方式接口
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 3/16/15.
 */
public abstract class Way<T extends Serializable> {
    private static final JsonMapper JSON_MAPPER = JsonMapper.nonDefaultMapper();

    /**
     * 将way的json数据转换成Object
     * @param wayValue  条件json数据
     * @return  T
     * 返回类型
     */
    public abstract T wayObject(String wayValue);

    /**
     * 校验way的数据是否符合标准
     * @param wayObj    方式对象
     * @param context   依据context校验数据正确性
     * @return  Boolean
     * @throws WayDataException
     * 返回校验是否成功
     */
    public abstract Boolean checkValue(T wayObj, Map<String, Object> context) throws WayDataException;

    /**
     * 获得条件的描述
     * @return  String
     * 返回条件描述
     */
    public abstract String desc(T value);

    /**
     * 获得条件的名称
     * @return  String
     * 返回条件名称
     */
    public abstract String name();

    /**
     * 获取条件的ID
     * @return  Integer
     * 返回条件编号
     */
    public abstract Integer id();


    /**
     * 获取作用域
     * @return  Integer
     * 返回数据的作用域
     */
    public Integer scope(T value){
        Method method = ReflectionUtils.getMethod(value, "getScope");
        if(!isNull(method)){
            return (Integer)ReflectionUtils.invoke(method, value, null);
        }
        return null;
    }

    /**
     * 是否影响价格
     * @return  Boolean
     * 返回是否影响价格
     */
    public abstract Boolean isEffectPrice();

    /**
     * 计算价格
     * @param originalPrice 原始价格
     * @return  Integer
     * 返回计算价格
     */
    public abstract Integer calculate(Integer originalPrice, T value);

    /**
     * 获取优惠价格
     * @param fatTradeDataDto   订单数据
     * @param value             优惠方式数据
     * @return  List
     * 返回优惠结果
     */
    public abstract List<DiscountData> getPreferentialPrice(FatTradeDataDto fatTradeDataDto, T value);

    /**
     * 获取子订单优惠数据
     * @param orderItem     子订单
     * @param value         优惠方式数据
     * @return  List
     * 返回优惠结果
     */
    public abstract WayDiscount calculateOrderItem(MarketingOrderItem orderItem, T value);

    /**
     * 获取总订单优惠数据
     * @param order         总订单数据
     * @param value         优惠方式数据
     * @return  DiscountData
     * 返回优惠结果
     */
    public abstract WayDiscount calculateOrder(MarketingOrder order, T value);

    /**
     * 执行优惠
     * @param fatTradeDataDto   订单数据
     * @param value             优惠方式数据
     * @return  Boolean
     * 返回执行优惠结果
     */
    public abstract Boolean invokeWay(FatTradeDataDto fatTradeDataDto, T value);

    /**
     * 执行优惠
     * @param discountData      优惠数据
     * @param value             优惠方式数据
     * @return  Boolean
     * 返回执行优惠结果
     */
    public abstract Boolean invokeWay(DiscountData discountData, T value);

    /**
     * 执行活动优惠
     * @param buyerId   操作用户
     * @param value 优惠方式数据
     * @return  Boolean
     * 返回执行优惠是否成功
     */
    public abstract Boolean invokeEvent(Long buyerId, T value);

    /**
     * json 数据转换分析
     * @param value 方式数据
     * @param clazz 对应的Class
     * @param <T>   校验数据
     * @return  T
     * 返回校验数据
     */
    protected <T> T checkValue(String value, Class<T> clazz){
        if(isEmpty(value)){
            throw new WayDataException("can`t Analyze data with " + value + ",the data is empty.");
        }

        T t = JSON_MAPPER.fromJson(value, clazz);

        if(isNull(t)){
            throw new WayDataException("can`t Analyze data with " + value);
        }

        return t;
    }


    protected void setScope(T value, List<DiscountData> discountDatas){
        Integer scope = scope(value);
        if(notNull(value) && notEmpty(discountDatas)){
            for(DiscountData data : discountDatas){
                data.setScope(scope);
            }
        }
    }
}
