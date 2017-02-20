package cn.com.gome.trade.dto.aftersalesorder;

import java.io.Serializable;
/**
 * 
 * @Description: 返回给app的产品信息 
 * @author: hanminglei
 * @date: 2015-5-30 下午4:34:51
 */
public class OrderProductVo implements Serializable {
	private String pname;//产品名称
	private long  productId;//产品ID
	private String pic;//产品图片
	private String price;//单价
	private String modelName;//产品型号名称
	private Integer num;//购买数量
	private int itemStatus;         //子订单的状态
	private String itemStatusName; //子订单状态名称
	private boolean returnGoodsForSevenDays; //7天退换
	private boolean changeGoodsForFifteenDays; //15天换货
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(int itemStatus) {
		this.itemStatus = itemStatus;
	}
	public boolean isReturnGoodsForSevenDays() {
		return returnGoodsForSevenDays;
	}
	public void setReturnGoodsForSevenDays(boolean returnGoodsForSevenDays) {
		this.returnGoodsForSevenDays = returnGoodsForSevenDays;
	}
	public boolean isChangeGoodsForFifteenDays() {
		return changeGoodsForFifteenDays;
	}
	public void setChangeGoodsForFifteenDays(boolean changeGoodsForFifteenDays) {
		this.changeGoodsForFifteenDays = changeGoodsForFifteenDays;
	}
	public String getItemStatusName() {
		return itemStatusName;
	}
	public void setItemStatusName(String itemStatusName) {
		this.itemStatusName = itemStatusName;
	}
	
}
