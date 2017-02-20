package cn.com.mx.cms.dto.platform;

import java.util.Date;
import cn.com.mx.cms.dto.CommonDto;

/**
 * 
 * Description: 推荐位Dto
 * @author duwei
 * @date 2015年12月3日 下午12:25:50
 * @version V1.0
 */
public class RecommendDto extends CommonDto {

	private static final long serialVersionUID = 444127458540005848L;

	private Integer recommendId;

	private int sn;

	private String pictureUrl;

	private String extendData;

	private int isDisabled;

	private Integer recommendType;

	private Date createTime;

	private Date updateTime;

	private String createOperator;

	private String updateOperator;
	
	private int type;//小类型:商品，商铺，达人等
	
	private String groupid;
	
	private long itemid;
	
	

	public RecommendDto() {
	}

	public RecommendDto(long itemid) {
		this.itemid = itemid;
	}

	public Integer getRecommendId() {
		return recommendId;
	}

	public void setRecommendId(Integer recommendId) {
		this.recommendId = recommendId;
	}

	public int getSn() {
		return sn;
	}

	public void setSn(int sn) {
		this.sn = sn;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
	}

	public String getExtendData() {
		return extendData;
	}

	public void setExtendData(String extendData) {
		this.extendData = extendData == null ? null : extendData.trim();
	}

	public int getIsDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(int isDisabled) {
		this.isDisabled = isDisabled;
	}

	public Integer getRecommendType() {
		return recommendType;
	}

	public void setRecommendType(Integer recommendType) {
		this.recommendType = recommendType;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public long getItemid() {
		return itemid;
	}

	public void setItemid(long itemid) {
		this.itemid = itemid;
	}
	
	
}