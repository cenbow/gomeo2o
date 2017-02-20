package io.terminus.ecp.trade.model;

import com.google.common.base.Objects;
import lombok.Data;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright (c) 2015 杭州端点网络科技有限公司
 * Date: 1/5/15
 * Time: 09:25
 * Author: 2015年 <a href="mailto:d@terminus.io">张成栋</a>
 */

@Data
public class OrderSummary implements Serializable {
    private static final long serialVersionUID = -6808928198816385414L;

    private Long id;

    private Long totalFee;      // 总销售额

    private Long perOrder;      // 每单价格

    private Long totalQuantity; // 总销量

    private Long totalOrder;    // 总单数

    private Date sumFor;        // 统计数据日期

    private Date updatedAt;

    private Date createdAt;

    /**
     * set if not exists, and return false if not equals
     * @param sumFor    统计日期
     * @return 设置是否成功
     */
    public boolean setSumForNXNE(Date sumFor) {
        if (this.sumFor==null) {
            this.sumFor = new DateTime(sumFor).withTimeAtStartOfDay().toDate();
            return true;
        } else {
            return Objects.equal(this.sumFor, new DateTime(sumFor).withTimeAtStartOfDay().toDate());
        }
    }

    public OrderSummary safeSetOrder() {
        this.perOrder = notNull(this.totalFee) / positive(this.totalOrder);
        return this;
    }

    public OrderSummary increaseTotalFee(Long totalFee) {
        this.totalFee = increase(this.totalFee, totalFee);
        return this;
    }

    public OrderSummary increaseTotalQuantity(Long totalQuantity) {
        this.totalQuantity = increase(this.totalQuantity, totalQuantity);
        return this;
    }
    
    public OrderSummary increaseTotalOrder(Long totalOrder) {
        this.totalOrder = increase(this.totalOrder, totalOrder);
        return this;
    }

    private Long increase(Long origin, Long step) {
        return notNull(origin) + notNull(step);
    }

    private Long notNull(Long num) {
        return num == null ? 0 : num;
    }

    private Long positive(Long nu) {
        return nu == null || nu <= 0 ? 1 : nu;
    }
}
