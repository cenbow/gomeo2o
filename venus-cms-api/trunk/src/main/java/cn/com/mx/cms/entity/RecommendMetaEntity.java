package cn.com.mx.cms.entity;

import java.util.Date;

import com.gomeo2o.common.entity.BaseEntity;

import cn.com.mx.cms.dto.CommonDto;

/**
 * 
 * Description: 推荐位元数据实体
 * @author duwei
 * @date 2015年12月22日 下午5:33:22
 * @version V1.0
 */
public class RecommendMetaEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Long id;

    private String name;

    private String metadata;

    private int isDelete;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata == null ? null : metadata.trim();
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
    
}