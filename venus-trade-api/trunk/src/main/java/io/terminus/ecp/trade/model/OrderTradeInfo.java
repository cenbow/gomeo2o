package io.terminus.ecp.trade.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class OrderTradeInfo implements Serializable {
	private static final long serialVersionUID = -589111883303666381L;
	
	private String region;
	private Integer provinceId;
	private String zip;
	private String phone;
	private Integer status;
	private Integer cityId;
	private String street;
	private String city;
	private Long id;
	@JsonIgnore
    private Date updatedAt;
	private String details;
	private Integer streetId;
	private Integer isDefault;
	@JsonIgnore
    private Date createdAt;
	private String name;
	private Long userId;
	private String province;
	private String mobile;
	private Integer regionId;
	private Integer updateNum;
}
