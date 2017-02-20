package io.terminus.ecp.marketing.dto;

import com.google.common.collect.Ordering;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

/**
 * Desc:规则的条件类型集合数据
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-09.
 */
@Data
public class BaseRuleType implements Serializable {
    private static final long serialVersionUID = -5284961592544005058L;

    private Integer type;   //类型

    private Integer sort;   //顺序

    /**
     * 根据排序大小进行数据排序
     * @param types     数据信息
     * @param <T>       返回数据
     * @return List
     * 返回排序后的类型
     */
    public static <T extends BaseRuleType> List<T> sortBy(List<T> types){
        Ordering<T> bySort = new Ordering<T>() {
            @Override
            public int compare(T left, T right) {
                return left.getSort() - right.getSort();
            }
        };

        return bySort.immutableSortedCopy(types);
    }
}
