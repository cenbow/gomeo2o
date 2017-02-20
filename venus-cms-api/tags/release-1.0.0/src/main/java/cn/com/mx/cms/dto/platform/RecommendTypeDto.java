package cn.com.mx.cms.dto.platform;

import java.io.Serializable;
import java.util.Date;

public class RecommendTypeDto implements Serializable {

	private static final long serialVersionUID = 7373295455355669901L;

	private Integer id;

	private int type;

	private String name;

	private int placeNum;

	private Date createTime;

	private Date updateTime;

	private String createOperator;

	private String updateOperator;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public int getPlaceNum() {
		return placeNum;
	}

	public void setPlaceNum(int placeNum) {
		this.placeNum = placeNum;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateOperator() {
		return createOperator;
	}

	public void setCreateOperator(String createOperator) {
		this.createOperator = createOperator == null ? null : createOperator.trim();
	}

	public String getUpdateOperator() {
		return updateOperator;
	}

	public void setUpdateOperator(String updateOperator) {
		this.updateOperator = updateOperator == null ? null : updateOperator.trim();
	}
}