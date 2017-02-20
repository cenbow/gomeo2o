/*
 * Copyright (c) 2014 杭州端点网络科技有限公司
 */

package io.terminus.ecp.config.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Mail: xiao@terminus.io <br>
 * Date: 2015-03-27 2:01 PM  <br>
 * Author: xiao
 */
@Data
public class Config implements Serializable {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = -6948740810152111780L;
	
	private Long id;
    private String key;             // 键
    private String value;           // 值
    private String description;    //描述
    private Date createdAt;         // 创建时间
    private Date updatedAt;         // 更新时间
    private String scope;//作用范围

}
