package io.terminus.ecp.marketing.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

import java.util.Date;
/**
 * Desc: HTTP协议调用
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 15/3/5.
 */
@ToString
public class MarketingHttpInfo implements Serializable {

    private static final long serialVersionUID = -293086193601306947L;

    @Getter
    @Setter
    private Long id;                        //通过http调用的信息

    @Getter
    @Setter
    private String name;                    //方式名称

    @Getter
    @Setter
    private String port;                    //端口

    @Getter
    @Setter
    private String protocol;                //协议 https 还是http访问

    @Getter
    @Setter
    private String url;                     //url路径

    @Getter
    @Setter
    private Integer status;                 //状态 1.可用 0.停用

    @Getter
    @Setter
    private Date createAt;                  //创建时间

    @Getter
    @Setter
    private Date updateAt;                  //修改时间

}
