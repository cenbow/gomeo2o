package cn.com.gome.configuration.config;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA
 * Author: luoys
 * Date: 2015-06-29 10:51
 */
@Data
public class BaseMqConfig implements Serializable{

    private static final long serialVersionUID = 5366899816231391033L;

    private String mqAddress;       //mq的地址（10.58.47.100:9876;10.58.47.101:9876）

    private String instanceName;

    private String groupName;

    private String topic;
}
