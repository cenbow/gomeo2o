package io.terminus.ecp.marketing.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import static io.terminus.common.utils.Arguments.equalWith;

/**
 * Desc:优惠活动关联关系
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-03-03.
 */
@Data
public class MarketingRelation implements Serializable {
    private static final long serialVersionUID = -3819988982563826624L;

    private Long id;                //优惠活动关联关系

    private Long activityRel1;      //优惠活动编号

    private Long activityRel2;      //优惠活动编号

    private Integer relation;       //优惠活动关系（1:叠加，2:互斥）

    private Date createdAt;         //创建时间

    private Date updatedAt;         //结束时间

    public static enum Relation {
        OVERLAY(1, "叠加"),
        EXCLUSION(2, "互斥");

        private final Integer value;

        private final String display;

        private Relation(Integer value, String display) {
            this.value = value;
            this.display = display;
        }

        public static Relation fromNumber(Integer value) {
            for (Relation t : Relation.values()) {
                if (equalWith(t.value, value)) {
                    return t;
                }
            }
            return null;
        }

        public Integer toNumber() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.display;
        }
    }
}
