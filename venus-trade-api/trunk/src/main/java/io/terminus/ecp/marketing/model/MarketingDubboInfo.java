
package io.terminus.ecp.marketing.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

import java.util.Date;
/**
 * Desc: dubbo方法调用
 * Mail: houly@terminus.io
 * author: Hou Luyao
 * Date: 15/3/5.
 */
@ToString
public class MarketingDubboInfo implements Serializable {

    private static final long serialVersionUID = -85304953188273565L;

    @Getter
    @Setter
    private Long id;                    //dubbo调用信息

    @Getter
    @Setter
    private String name;                //dubbo名称

    @Getter
    @Setter
    private String zkpath;              //zk地址

    @Getter
    @Setter
    private String port;                //端口

    @Getter
    @Setter
    private String dubboUrl;            //dubbo调用路径

    @Getter
    @Setter
    private Date createAt;              //创建时间

    @Getter
    @Setter
    private Date updateAt;              //结束时间


}
