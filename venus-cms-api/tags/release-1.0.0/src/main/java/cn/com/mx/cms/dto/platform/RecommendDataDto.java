package cn.com.mx.cms.dto.platform;

import java.util.Date;
import cn.com.mx.cms.dto.CommonDto;

/**
 * 
 * @author wangzhen-ds5
 *
 */
public class RecommendDataDto extends CommonDto {

	private static final long serialVersionUID = 6456465553726373860L;

	private Long id;

	private String recommendData;

	private Long recommendMetadataId;

	private Integer isDelete;

	private Date createTime;

	private Date updateTime;

	private String createOperator;

	private String updateOperator;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRecommendData() {
		return recommendData;
	}

	public void setRecommendData(String recommendData) {
		this.recommendData = recommendData;
	}

	public Long getRecommendMetadataId() {
		return recommendMetadataId;
	}

	public void setRecommendMetadataId(Long recommendMetadataId) {
		this.recommendMetadataId = recommendMetadataId;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
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
		this.createOperator = createOperator;
	}

	public String getUpdateOperator() {
		return updateOperator;
	}

	public void setUpdateOperator(String updateOperator) {
		this.updateOperator = updateOperator;
	}
}