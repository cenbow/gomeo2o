package cn.com.gome.trade.dto.shopdto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
* 店铺
* Author: haolin
* On: 8/27/14
*/
@EqualsAndHashCode(of = {"userId"})
public class Shop implements Serializable {

   private static final long serialVersionUID = -3968215958459561670L;

   @Getter @Setter
   private Long id;                                    //主键

   @Getter @Setter
   private Long userId;                                //用户id

   @Getter @Setter
   private String userName;                            //用户名

   @Getter @Setter @Length(min = 1, max = 50, message = "shop.name.1to50")
   private String name;                                //店铺名称

   @Getter @Setter
   private Integer status;                             //状态

   @Getter @Setter
   private Integer type;                               //店铺类型

   @Getter @Setter
   private String phone;                               //电话

   @Getter @Setter @Min(value = 1L, message = "shop.business.id.invalid")
   private Long shopBusinessId;                       //店铺行业id

   @Getter @Setter
   private String shopBusinessName;                       //店铺行业名称

   @Getter @Setter
   @Length(max = 128, message = "shop.image.gt128")
   private String imageUrl;                            //店铺主图

   @Getter @Setter
   @NotNull(message = "shop.province.null")
   @Length(min = 1, max = 64, message = "province.length.1to64")
   private String province;                            //省名称

   @Getter @Setter @Min(value = 1L, message = "shop.province.id.invalid")
   private Integer provinceId;                         //省id

   @Getter @Setter
   @NotNull(message = "shop.city.null")
   @Length(min = 1, max = 64, message = "city.length.1to64")
   private String city;                                //城

   @Getter @Setter @Min(value = 1L, message = "shop.city.id.invalid")
   private Integer cityId;                             //所在城市id

   @Getter @Setter  @Length(max = 64, message = "region.length.1to64")
   private String region;                              //区

   @Getter @Setter
   private Integer regionId;                           //区id

   @Getter @Setter @Length(max = 128, message = "shop.street.gt128")
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

   @Getter @Setter @JsonIgnore
   private Date createdAt;

   @Getter @Setter @JsonIgnore
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
       //休店
       PAUSE(2),
       //关闭
       CLOSE(3),
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

       public static Status from(Integer value) {
           for (Status status : Status.values()) {
               if (Objects.equal(status.value, value)) {
                   return status;
               }
           }
           return null;
       }
   }

   public static enum Type {
       NORMAL(1, "普通店铺"),
       GOME(2, "国美在线店铺");

       private final int value;

       private final String display;

       private Type(int value, String display) {
           this.value = value;
           this.display = display;
       }

       public int value() {
           return this.value;
       }

       @Override
       public String toString() {
           return this.display;
       }

       public static Type from(int value) {
           for(Type t : Type.values()) {
               if(Objects.equal(t.value, value)) {
                   return t;
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


   @Getter @Setter @JsonIgnore
   private List<Integer> statuses;
}
