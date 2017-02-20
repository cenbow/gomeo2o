package io.terminus.ecp.marketing.model;

import com.fasterxml.jackson.databind.JavaType;
import com.google.common.collect.Ordering;
import io.terminus.common.utils.JsonMapper;
import io.terminus.ecp.marketing.dto.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Desc: 营销工具所需要的数据
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 15/3/8.
 */
@ToString
public class MarketingToolData implements Serializable {

    private static final long serialVersionUID = -293340451733867518L;

    private static final JsonMapper JSON_MAPPER = JsonMapper.nonDefaultMapper();
    private static final JavaType CONDITION_DATA = JSON_MAPPER.createCollectionType(ArrayList.class, RuleConditionData.class);
    private static final JavaType WAY_DATA = JSON_MAPPER.createCollectionType(ArrayList.class, RuleWayData.class);

    @Getter
    @Setter
    private Long id;                    //工具的保存数据

    @Getter
    @Setter
    private Long activityId;            //活动编号

    @Getter
    @Setter
    private Long toolId;                //工具编号

    @Getter
    @Setter
    private Long ruleId;                //规则编号

    @Getter
    @Setter
    private String conditionData;       //优惠条件数据[{type:1,value:1,sort:1},...]

    @Getter
    @Setter
    private String wayData;             //优惠方式数据[{type:1,value:1,sort:1},...]

    @Getter
    @Setter
    private Integer priority;           //优先级

    @Getter
    @Setter
    private Date createAt;              //创建时间

    @Getter
    @Setter
    private Date updateAt;              //修改时间

    /**
     * 获取营销规则的条件数据集合
     * @return List
     * 返回条件集合
     */
    public List<RuleConditionData> conditionDataList(){
        List<RuleConditionData> conditionList = JSON_MAPPER.fromJson(this.conditionData, CONDITION_DATA);
        return sortBy(conditionList);
    }

    /**
     * 获取营销规则的方式数据集合
     * @return List
     * 返回方式数据
     */
    public List<RuleWayData> wayDataList(){
        List<RuleWayData> wayList = JSON_MAPPER.fromJson(this.wayData, WAY_DATA);
        return sortBy(wayList);
    }

    /**
     * 根据排序大小进行数据排序
     * @param types     数据信息
     * @param <T>       返回数据
     * @return List
     * 返回排序后的类型
     */
    private <T extends BaseRuleType> List<T> sortBy(List<T> types){
        Ordering<T> bySort = new Ordering<T>() {
            @Override
            public int compare(T left, T right) {
                return left.getSort() - right.getSort();
            }
        };

        return bySort.immutableSortedCopy(types);
    }
}
