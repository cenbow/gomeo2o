package io.terminus.ecp.marketing.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

import java.util.Date;
/**
 * Desc: plugin class bean调用信息
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 15/3/5.
 */
@ToString
public class MarketingClassInfo implements Serializable {

    private static final long serialVersionUID = -534639167995769593L;

    @Getter
    @Setter
    private Long id;                                    //bean信息

    @Getter
    @Setter
    private String name;                                //插件bean名称

    @Getter
    @Setter
    private String location;                            //bean位置

    @Getter
    @Setter
    private Integer status;                             //（状态 1.可用 0.停用）

    @Getter
    @Setter
    private Date createAt;                              //创建时间

    @Getter
    @Setter
    private Date updateAt;                              //结束时间
}
