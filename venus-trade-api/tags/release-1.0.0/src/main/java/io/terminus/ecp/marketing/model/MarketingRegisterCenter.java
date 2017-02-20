package io.terminus.ecp.marketing.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

import java.util.Date;

import static io.terminus.common.utils.Arguments.equalWith;

/**
 * Desc: 注册中心
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 15/3/5.
 */
@ToString
public class MarketingRegisterCenter implements Serializable {

    private static final long serialVersionUID = -766566276949389218L;

    @Getter
    @Setter
    private Long id;                                    //注册中心

    @Getter
    @Setter
    private String name;                                //插件名称

    @Getter
    @Setter
    private Integer callType;                           //调用类型（1.本地class，2.远程http，3.远程dubbo，4.脚本调用）

    @Getter
    @Setter
    private String type;                                //分类

    @Getter
    @Setter
    private String status;                              //状态（1.启用，0.停用）

    @Getter
    @Setter
    private Long orderFlowId;                           //插件关联的流程切入点（与交易关联）

    @Getter
    @Setter
    private Long refInfoId;                             //关联的调用插件地址

    @Getter
    @Setter
    private String description;                         //信息介绍

    @Getter
    @Setter
    private Long createBy;                              //创建人

    @Getter
    @Setter
    private Long updateBy;                              //修改人

    @Getter
    @Setter
    private Date createAt;                              //创建时间

    @Getter
    @Setter
    private Date updateAt;                              //结束时间

    public static enum Status {
        STOP(0, "停用"),
        START(1, "启用");

        private final Integer value;

        private final String display;

        private Status(Integer value, String display) {
            this.value = value;
            this.display = display;
        }

        public static Status fromNumber(Integer value) {
            for (Status t : Status.values()) {
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

    public static enum CallType {
        CLASS(1, "本地class"),
        HTTP(2, "远程http"),
        DUBBO(3, "远程dubbo");

        private final Integer value;

        private final String display;

        private CallType(Integer value, String display) {
            this.value = value;
            this.display = display;
        }

        public static CallType fromNumber(Integer value) {
            for (CallType t : CallType.values()) {
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
