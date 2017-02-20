package io.terminus.ecp.marketing.model.assemble;

import com.google.common.base.Objects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 组合套餐
 * Created by yangzefeng on 14-4-21
 */
@ToString
@EqualsAndHashCode
public class ItemBundle implements Serializable {
    private static final long serialVersionUID = -1624106079813196372L;

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private Long sellerId;

    @Getter
    @Setter
    private Long itemId1;

    @Getter
    @Setter
    private Long itemId2;

    @Getter
    @Setter
    private Long itemId3;

    @Getter
    @Setter
    private Long itemId4;

    @Getter
    @Setter
    private Integer item1Quantity;

    @Getter
    @Setter
    private Integer item2Quantity;

    @Getter
    @Setter
    private Integer item3Quantity;

    @Getter
    @Setter
    private Integer item4Quantity;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String desc;

    @Getter
    @Setter
    private Integer price;

    @Getter
    @Setter
    private Integer originalPrice;


    @Getter
    @Setter
    private Integer status;

    @Getter
    @Setter
    private Date createdAt;

    @Getter
    @Setter
    private Date updatedAt;

    public static enum Status {

        OnShelf(1, "上架，可以购买"),
        OffShelf(-1, "下架，不可以购买");

        private final int value;
        private final String description;

        private Status(int value, String description) {
            this.value = value;
            this.description = description;
        }

        public int toNumber() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.description;
        }

        public static Status fromNumber(int value) {
            for(Status s : Status.values()) {
                if(Objects.equal(s.toNumber(), value))
                    return s;
            }
            return null;
        }
    }
}
