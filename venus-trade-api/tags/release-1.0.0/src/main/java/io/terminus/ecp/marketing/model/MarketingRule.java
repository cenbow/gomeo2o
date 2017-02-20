package io.terminus.ecp.marketing.model;

import com.fasterxml.jackson.databind.JavaType;
import com.google.common.collect.Ordering;
import io.terminus.common.utils.JsonMapper;
import io.terminus.ecp.marketing.dto.BaseRuleType;
import io.terminus.ecp.marketing.dto.RuleCondition;
import io.terminus.ecp.marketing.dto.RuleWay;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Desc: 营销规则
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 15/3/5.
 */
@ToString
public class MarketingRule implements Serializable {
    private static final long serialVersionUID = -433004683505877931L;

    private static final JsonMapper JSON_MAPPER = JsonMapper.nonDefaultMapper();
    private static final JavaType CONDITION_TYPE = JSON_MAPPER.createCollectionType(ArrayList.class, RuleCondition.class);
    private static final JavaType WAY_TYPE = JSON_MAPPER.createCollectionType(ArrayList.class, RuleWay.class);

    @Getter
    @Setter
    private Long id;                        //营销规则

    @Getter
    @Setter
    private String name;                    //规则名称

    @Getter
    @Setter
    private String desc;                    //规则描述

    @Getter
    @Setter
    private String type;                    //类型

    @Getter
    @Setter
    private Long refToolId;                 //关联的工具id

    @Getter
    @Setter
    private String conditionIds;            //条件集合的json数据（[{type:1, sort:1},....]）

    @Getter
    @Setter
    private String wayIds;                  //方式集合的json数据（[{type:1, sort:1},....]）

    @Getter
    @Setter
    private Integer status;                 //状态（0 停用 1 启用）

    @Getter
    @Setter
    private Integer isExclusive;            //是否是独占式（0.非独占 1.独占）

    @Getter
    @Setter
    private Integer priority;               //优先级

    @Getter
    @Setter
    private Long createBy;                  //创建人

    @Getter
    @Setter
    private Long updateBy;                  //修改人

    @Getter
    @Setter
    private Date createAt;                  //创建时间

    @Getter
    @Setter
    private Date updateAt;                  //结束时间

    /**
     * 获取营销规则的条件规则集合
     * @return List
     * 返回条件规则
     */
    public List<RuleCondition> conditionTypes(){
        List<RuleCondition> conditionList = JSON_MAPPER.fromJson(this.conditionIds, CONDITION_TYPE);
        return BaseRuleType.sortBy(conditionList);
    }

    /**
     * 获取营销规则的方式规则集合
     * @return List
     * 返回方式规则
     */
    public List<RuleWay> wayTypes(){
        List<RuleWay> wayList = JSON_MAPPER.fromJson(this.wayIds, WAY_TYPE);
        return BaseRuleType.sortBy(wayList);
    }
}
