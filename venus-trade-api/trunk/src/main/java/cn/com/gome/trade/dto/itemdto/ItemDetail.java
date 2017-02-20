package cn.com.gome.trade.dto.itemdto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @Description TODO 
 * @author wangjiatian
 * @date 2016年6月22日 下午4:14:03
 */
@Data
public class ItemDetail implements Serializable {

    private static final long serialVersionUID = 1837956092030029010L;

    /**
     * ID
     */
    private Long id;

    /**
     * 商品ID
     */
    private Long itemId;

    /**
     * 图片1
     */
    private String image1;

    /**
     * 图片2
     */
    private String image2;

    /**
     * 图片3
     */
    private String image3;

    /**
     * 图片4
     */
    private String image4;

    /**
     * 包装清单
     */
    private String packing;

    /**
     * 售后服务
     */
    private String service;

    private Date createdAt;

    private Date updatedAt;
}

