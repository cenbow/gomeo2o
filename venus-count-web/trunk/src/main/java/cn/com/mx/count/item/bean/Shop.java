/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package cn.com.mx.count.item.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 店铺
 * Author: haolin
 * On: 8/27/14
 */
@SuppressWarnings("all")
public class Shop implements Serializable {

    private static final long serialVersionUID = -3968215958459561670L;

    @Getter @Setter
    private Long id;                                    //主键

    @Getter @Setter
    private Long userId;                                //用户id

    @Getter @Setter
    private String userName;                            //用户名

    private String name;                                //店铺名称

    @Getter @Setter
    private Integer status;                             //状态

    @Getter @Setter
    private Integer type;                               //店铺类型

    @Getter @Setter
    private String phone;                               //电话

    @Getter @Setter 
    private Long shopBusinessId;                       //店铺行业id

    @Getter @Setter
    private String shopBusinessName;                       //店铺行业名称

    @Getter @Setter
    private String imageUrl;                            //店铺主图

    @Getter @Setter
    private String province;                            //省名称

    @Getter @Setter 
    private Integer provinceId;                         //省id

    @Getter @Setter
    private String city;                                //城

    @Getter @Setter
    private Integer cityId;                             //所在城市id

    @Getter @Setter
    private String region;                              //区

    @Getter @Setter
    private Integer regionId;                           //区id

    @Getter @Setter
    private String street;                              //所在街道地址

    @Getter @Setter
    private Boolean isCod;                              //是否支持货到付款

    @Getter @Setter
    private Boolean isEinvoice;                         //是否支持电子发票

    @Getter @Setter
    private Boolean isVatInvoice;                       //是否支持增值税发票

    @Getter @Setter
    private Long serviceScore;                          // 服务平均评分

    @Getter @Setter
    private Long expressScore;                          // 快递平均评分

    @Getter @Setter
    private Long describeScore;                         // 描述平均评分

    @Getter @Setter
    private Long qualityScore;                          // 质量平均评分

    private Date createdAt;

    private Date updatedAt;




    /**
     * Redis中保存店铺宝贝数的KEY
     * @param shopId 店铺id
     * @return shops:{shopId}:item:count
     */
    public static String keyOfItemCount(Long shopId) {
        return "shops:" + shopId + "item:count";
    }

    /**
     * Redis中保存店铺销量的KEY
     * @param shopId 店铺id
     * @return shops:{shopId}:sale:quantity
     */
    public static String keyOfSaleQuantity(Long shopId) {
        return "shops:" + shopId + "sale:quantity";
    }

    /**
     * Redis中保存店铺销售额的KEY
     * @param shopId 店铺id
     * @return shops:{shopId}:sales
     */
    public static String keyOfSales(Long shopId) {
        return "shops:" + shopId + "sales";
    }

    public static enum Status {
        INIT(0), OK(1), FAIL(-2), FROZEN(-1),
        /**
         * 未申请过(数据库中无纪录)
         */
        OUTSIDER(-99);

        private final int value;

        private Status(int value) {
            this.value = value;
        }

        public int value() {
            return value;
        }

        public static Status from(Integer number) {
        	for (Status status : Status.values()) {
                if (Integer.valueOf(number).compareTo(status.value) == 0) {
                    return status;
                }
            }
            return null;
        }
    }


    public static Shop safeFilter(Shop shop) {
        Shop safe = new Shop();
        safe.setId(shop.getId());
        safe.setPhone(shop.getPhone());
        safe.setShopBusinessId(shop.getShopBusinessId());
        safe.setShopBusinessName(shop.getShopBusinessName());
        safe.setImageUrl(shop.getImageUrl());
        safe.setProvince(shop.getProvince());
        safe.setProvinceId(shop.getProvinceId());
        safe.setCity(shop.getCity());
        safe.setCityId(shop.getCityId());
        safe.setRegion(shop.getRegion());
        safe.setRegionId(shop.getRegionId());
        safe.setStreet(shop.getStreet());
        safe.setIsCod(shop.getIsCod());
        safe.setIsEinvoice(shop.getIsEinvoice());
        safe.setIsVatInvoice(shop.getIsVatInvoice());
        return safe;
    }


    private List<Integer> statuses;
}
