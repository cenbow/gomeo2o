package cn.com.mx.webapi.common.utils;

import cn.com.mx.webapi.common.exceptions.BaseExceptionMessage;
import cn.com.mx.webapi.common.exceptions.code.C422Exception;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by neowyp on 2016/4/7.
 */
@Slf4j
public class ValidateJsonUtil {
    private static final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();

    private static final Map<String, JsonSchema> schemas = new HashMap<String, JsonSchema>();

    /**
     * 根据module，resource，method获取对应的json schema
     *
     * @param module
     * @param resource
     * @param method
     * @return 返回json schema，用于校验
     * @throws Exception
     */
    private static JsonSchema getJsonSchema(String module, String resource, String method) throws Exception {
        String path = "/validate/json/" + module + "/" + resource + "_" + method + ".json";

        if (schemas.containsKey(path)) {
            return schemas.get(path);
        } else {
            JsonNode jsonSchema = JsonLoader.fromResource(path);
            JsonSchema schema = factory.getJsonSchema(jsonSchema);
            schemas.put(path, schema);
            return schema;
        }
    }

    public static void validateJsonString(String module, String resource, String method, String jsonStr) throws Exception {
            JsonSchema schema = getJsonSchema(module, resource, method);
            JsonNode jsonNode = JsonLoader.fromString(jsonStr);
            ProcessingReport report = schema.validate(jsonNode);
            if (report.isSuccess())
                return;
        Iterator<ProcessingMessage> iterator = report.iterator();
        while (iterator.hasNext()) {
            ProcessingMessage msg = iterator.next();
//                JsonNode node = msg.asJson();
            log.info("message is {}", msg.getMessage());
            throw new C422Exception(new BaseExceptionMessage("%s", msg.getMessage()));
        }
    }
}
