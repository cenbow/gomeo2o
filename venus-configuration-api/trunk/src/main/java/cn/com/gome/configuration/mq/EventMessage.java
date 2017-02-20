
package cn.com.gome.configuration.mq;

import com.google.common.base.Throwables;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

import static io.terminus.common.utils.Arguments.equalWith;

/**
 * Desc:MQ事件数据
 * Mail:v@terminus.io
 * author:Michael Zhao
 * Date:2015-05-26.
 */
@Data
@Slf4j
public class EventMessage implements Serializable {
    private static final long serialVersionUID = -7969906313502438360L;

    private byte[] eventData;       //消息数据

    private String tag;

    private String key;

    public EventMessage(byte[] eventData, String tag, String key) {
        this.eventData = eventData;
        this.tag = tag;
        this.key = key;
    }

    public EventMessage(Object obj, String tag, String key){
        ByteArrayOutputStream outputStream = null;
        ObjectOutputStream output = null;
        try {
            outputStream = new ByteArrayOutputStream(1024);
            output = new ObjectOutputStream(outputStream);

            output.writeObject(obj);

            this.eventData = outputStream.toByteArray();
            this.tag = tag;
            this.key = key;
        } catch (IOException e) {
            log.error("Serializable obj failed, obj={}, error code={}", obj, Throwables.getStackTraceAsString(e));
        } finally {
            if (output != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    log.error("Failed to close file, Error code={}", Throwables.getStackTraceAsString(e));
                }
            }
        }
    }

    public EventMessage(String data, String tag, String key){
        try {
            this.eventData = data.getBytes("utf-8");
            this.tag = tag;
            this.key = key;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}
