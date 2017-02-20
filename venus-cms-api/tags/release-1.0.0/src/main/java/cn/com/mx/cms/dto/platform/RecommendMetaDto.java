package cn.com.mx.cms.dto.platform;

import java.util.Date;

import cn.com.mx.cms.dto.CommonDto;

/**
 * 
 * Description: 推荐位元数据DTO
 * @author duwei
 * @date 2015年12月22日 下午5:33:22
 * @version V1.0
 */
public class RecommendMetaDto extends CommonDto {

	private static final long serialVersionUID = 1L;

	private Long id;

    private String name;

    private String metadata;

    private int isDelete;

    private Date createTime;
    
    private Date updateTime;

    private String createOperator;

    private String updateOperator;
    
    /** 是否删除推荐位元数据，操作状态 (0.查询，1.删除) */
    private int delType;

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

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
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

	public int getDelType() {
		return delType;
	}

	public void setDelType(int delType) {
		this.delType = delType;
	}
    
}