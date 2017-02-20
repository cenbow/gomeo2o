/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.trade.model;

import com.google.common.base.Objects;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单评价
 * Created by yangzefeng on 14-9-5
 */
@Data
public class OrderComment implements Serializable {

    private static final long serialVersionUID = -1552818294797199073L;

    /**
     * ID
     */
    private Long id;
    /**
     * 评价用户ID
     */
    private Long userId;
    /**
     * 评价用户名
     */
    private String userName;
    /**
     * 子订单ID
     */
    private Long orderItemId;
    /**
     * 商品ID
     */
    private Long itemId;
    /**
     * 商品名称
     */
    private String itemName;
    /**
     * 店铺ID
     */
    private Long shopId;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 卖家ID
     */
    private Long sellerId;
    /**
     * 质量评分
     */
    private Integer quality;
    /**
     * 描述评分
     */
    private Integer describe;
    /**
     * 服务评分
     */
    private Integer service;
    /**
     * 物流评分
     */
    private Integer express;
    /**
     * 评价内容
     */
    private String context;
    /**
     * 评价回复
     */
    private String reply;
    /**
     * 是否已回复
     */
    private Boolean isReply;
    /**
     * 评价人所属的公司id
     */
    private Long companyId;

    /**
     * 评价状态 1->正常 -1->删除
     */
    private Integer status;

    /**
     * 来源 1-供应商 2-达人
     */
    private String reference;

    /**
     * 来源ID
     */
    private String referenceId;

    /**
     * 评价用户头像
     */
    private String avatar;

    /**
     * 评价详情图
     */
    private String image1;

    private String image2;

    private String image3;

    private String image4;

    private String image5;

    /**
     * 是否需要推送外部系统
     */
    private Boolean isPublish;

    private Date createdAt;

    private Date updatedAt;

    public enum Status {
        NORMAL(1, "正常"),
        DELETED(-1, "删除");

        private int value;
        private String desc;

        private Status(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public int value() {
            return value;
        }

        public static Status from(int number) {
            for (Status status : Status.values()) {
                if (Objects.equal(status.value, number)) {
                    return status;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return desc;
        }
    }
}
