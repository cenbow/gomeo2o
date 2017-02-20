package cn.com.gome.trade.dto.ordercreation;

import java.io.Serializable;

import lombok.Data;

/**
 * 购物车vo
 * @author andybin
 *
 */
@Data
public class ShopCartVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 93279305072634443L;
	/*
	 * 店铺ID，店铺名称，商品ID，商品缩略图、商品标题、SKUID, SKU信息list（），
	 * 商品价格、选购数量、是否有货、是否可送（无地域信息怎么处理？）
	 */
	private long proId;              //商品id
	private long skuId;              //sku的id
	private long shopId;             //店铺id
	private String shopName;         //店铺名称
	private long vshopId;             //美店店铺id
	private String vshopName;         //美店店铺名称
	private boolean hasCoupon;         //是否可领券
	private String productTitle;     //商品标题
	private String productUrl;       //商品缩略图
	private String skuProperty;		 //商品销售属性
	private String price;        //商品价格
	private int productNum;          //选购数量
	private int status;          //状态   1：上架     -1：下架
	private int isGome;			 //是否国美商品
	private int stock;				 //库存
	private String deleteId;		//删除用的ID
	private String kId;				//返利链条的ID
	
}