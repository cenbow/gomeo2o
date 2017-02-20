package cn.com.gome.configuration.exception;

/**
 * Desc: MQ消息发送异常
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date: 3/17/15.
 */
public class MqSendException extends RuntimeException{

    private static final long serialVersionUID = -7022344871135735798L;

    public MqSendException(String message){
        super(message);
    }

    public MqSendException(String message, Throwable cause){
        super(message , cause);
    }
}
