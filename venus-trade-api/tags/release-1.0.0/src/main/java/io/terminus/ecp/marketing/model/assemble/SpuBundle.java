package io.terminus.ecp.marketing.model.assemble;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 组合套餐模版
 * CREATED BY: IntelliJ IDEA
 * AUTHOR: haolin
 * ON: 14-4-21
 */
@ToString
public class SpuBundle implements Serializable {

    private static final long serialVersionUID = -9039472734062099303L;

    @Getter
    @Setter
    private Long id;                //主键

    @Getter
    @Setter
    private Long userId;            //创建用户主键

    @Getter
    @Setter
    private String name;            //名称

    @Getter
    @Setter
    private String description;     //描述

    @Getter
    @Setter
    private Long idOne;             //第一个SPU ID

    @Getter
    @Setter
    private Integer quantityOne;    //第一个商品数量

    @Getter
    @Setter
    private Long idTwo;             //第二个SPU ID

    @Getter
    @Setter
    private Integer quantityTwo;    //第二个商品数量

    @Getter
    @Setter
    private Long idThree;           //第三个SPU ID

    @Getter
    @Setter
    private Integer quantityThree;  //第三个商品数量

    @Getter
    @Setter
    private Long idFour;            //第四个SPU ID

    @Getter
    @Setter
    private Integer quantityFour;   //第四个商品数量

    @Getter
    @Setter
    private String nameOne;     //第一个SPU名称

    @Getter
    @Setter
    private String nameTwo;     //第二个SPU名称

    @Getter
    @Setter
    private String nameThree;   //第三个SPU名称

    @Getter
    @Setter
    private String nameFour;    //第四个SPU名称

    @Getter
    @Setter
    private Long usedCount=0L;         //被商家使用的次数, 默认0

    @Getter
    @Setter
    private Integer status = Status.OFF.value();    //状态: 1上架, 2下架;默认下架

    @Getter
    @Setter
    private Date createdAt;         //创建时间

    @Getter
    @Setter
    private Date updatedAt;         //更新时间

    /**
     * 状态，分上架,下架
     */
    public static enum Status{
        ON(1, "上架"),
        OFF(2, "下架");

        private final int value;
        private final String display;

        private Status(int value, String display){
            this.value = value;
            this.display = display;
        }

        public int value(){
            return this.value;
        }

        public String display(){
            return this.display;
        }

        public static Status from(Integer value){
            for(Status s : Status.values()){
                if(Objects.equal(value, s.value)){
                    return s;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.display;
        }
    }
}
