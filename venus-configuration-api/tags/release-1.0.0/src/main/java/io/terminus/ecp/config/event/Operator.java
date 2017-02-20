/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.config.event;

import java.util.Objects;

/**
 * Mail: xiao@terminus.io <br>
 * Date: 2015-10-15 11:08 AM  <br>
 * Author: xiao
 */
public enum Operator {
    DELETE(-1),
    CREATE(0),
    UPDATE(1);


    public static Operator from(Integer value) {
        for (Operator op : Operator.values()) {
            if (Objects.equals(op.value, value)) return op;
        }
        throw new IllegalArgumentException("not an valid operator");
    }


    public final Integer value;

    Operator(Integer value) {
        this.value = value;
    }
    }
