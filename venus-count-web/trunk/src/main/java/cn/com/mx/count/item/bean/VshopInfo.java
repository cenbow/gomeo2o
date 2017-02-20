package cn.com.mx.count.item.bean;


public class VshopInfo {

	private static final long serialVersionUID = 1L;

	private long vshopId; // 微店编码

	private long userId; // 用户编码

	private Integer vshopType; // 微店类型0:员工,1:美店,2:商户

	private String vshopIcon; // 微店图标

	private String vshopName; // 微店名称

	private String vshopDesc; // 微店描述

	private String vshopBgimage; // 微店背景图片

	private String vshopUrl; // 微店链接地址

	private double vshopX; // 微店经度

	private double vshopY; // 微店纬度

	private Integer vshopStatus; // 微店状态 0:经营中 1:冻结,2:审核中,3:审核失败

	private String vshopArea; // 微店位置

	private long provinceId; // 省ID
	
	private long cityId; // 市ID
	
	private long countyId; // 县ID
	
	public long getVshopId() {
		return vshopId;
	}
	public void setVshopId(long vshopId) {
		this.vshopId = vshopId;
	}
	public Integer getVshopType() {
		return vshopType;
	}
	public void setVshopType(Integer vshopType) {
		this.vshopType = vshopType;
	}
	public String getVshopIcon() {
		return vshopIcon;
	}
	public void setVshopIcon(String vshopIcon) {
		this.vshopIcon = vshopIcon;
	}
	public String getVshopName() {
		return vshopName;
	}
	public void setVshopName(String vshopName) {
		this.vshopName = vshopName;
	}
	public String getVshopDesc() {
		return vshopDesc;
	}
	public void setVshopDesc(String vshopDesc) {
		this.vshopDesc = vshopDesc;
	}
	public String getVshopBgimage() {
		return vshopBgimage;
	}
	public void setVshopBgimage(String vshopBgimage) {
		this.vshopBgimage = vshopBgimage;
	}
	public String getVshopUrl() {
		return vshopUrl;
	}
	public void setVshopUrl(String vshopUrl) {
		this.vshopUrl = vshopUrl;
	}
	public double getVshopX() {
		return vshopX;
	}
	public void setVshopX(double vshopX) {
		this.vshopX = vshopX;
	}
	public double getVshopY() {
		return vshopY;
	}
	public void setVshopY(double vshopY) {
		this.vshopY = vshopY;
	}
	public String getVshopArea() {
		return vshopArea;
	}
	public void setVshopArea(String vshopArea) {
		this.vshopArea = vshopArea;
	}
	public Integer getVshopStatus() {
		return vshopStatus;
	}
	public void setVshopStatus(Integer vshopStatus) {
		this.vshopStatus = vshopStatus;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(long provinceId) {
		this.provinceId = provinceId;
	}
	public long getCityId() {
		return cityId;
	}
	public void setCityId(long cityId) {
		this.cityId = cityId;
	}
	public long getCountyId() {
		return countyId;
	}
	public void setCountyId(long countyId) {
		this.countyId = countyId;
	}
	
}
