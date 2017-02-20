package cn.com.mx.cms.utils;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	static ObjectMapper mapper = new ObjectMapper();

	/**
	 * 将json数组转换为List<Map<String, Object>>
	 * 
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> Json2ListMap(String json) {
		List<Map<String, Object>> list = null;
		try {
			list = mapper.readValue(json, List.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> json2Map(String json) {
		Map<String, Object> res = null;
		try {
			res = mapper.readValue(json, Map.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * 将如下格式的字符串转换为json字符串
	 * {id=51,name=niuniu,parent={id=35,name=aaa,roleId=1,roleType
	 * =800001},roleId=2,roleType=780101}
	 * 
	 * @param str
	 * @return
	 */
	public static String toJsonStr(String str) {
		String returnValue = "";
		if (str.length() > 0) {
			String[] arr = str.split(",");
			if (arr.length > 0) {
				for (int i = 0; i < arr.length; i++) {
					String temp = arr[i];
					String[] keyValue = temp.split("=");
					String parent = "";
					String key = "";
					String value = "";
					if (keyValue.length == 3) {
						parent = keyValue[0].trim();
						returnValue += ",\"" + parent + "\":";
						key = keyValue[1].trim();
						returnValue += "{\"" + key.substring(1) + "\":";
						value = keyValue[2].trim();
						returnValue += "\"" + value + "\"";
					} else {
						key = keyValue[0].trim();
						if (key.startsWith("{"))
							returnValue += key.substring(0, 1) + "\"" + key.substring(1) + "\":";
						else
							returnValue += ",\"" + key.substring(0) + "\":";
						value = keyValue[1].trim();
						if (value.endsWith("}"))
							returnValue += value.substring(0, value.indexOf("}")) + "}";
						else
							returnValue += "\"" + value + "\"";
					}
				}
			}
		}
		return returnValue;
	}

	private final static String NULLSTR = "";

	public static String toJson(Object obj) {
		if (obj == null) {
			return NULLSTR;
		}
		return JSON.toJSONString(obj);
	}

	public static <T> T toObj(String jsonValue, Class<T> c) {
		if (jsonValue == null || jsonValue.length() == 0) {
			return null;
		}

		return JSON.parseObject(jsonValue, c);
	}

	public static <T> List<T> toObjArray(String jsonValue, Class<T> c) {
		if (jsonValue == null || jsonValue.length() == 0) {
			return null;
		}

		return JSON.parseArray(jsonValue, c);
	}

	public static <T> String propertyFilter(List<T> list, Class<?> clazz, String... propertyNames) {

		SimplePropertyPreFilter simple = new SimplePropertyPreFilter(clazz, propertyNames);

		return JSON.toJSONString(list, simple);

	}

	public static void main(String[] args) {
		String str = "{one={one=100}, two={one=50, two=50}, three={one=33, two=33, three=34}, four={one=25, two=25, three=25, four=25}}";
		if (str.contains("one={")) {
			String temp = str;
			int i = temp.indexOf("one={") + 4;
			String s = temp.substring(i);
			int j = s.indexOf("}") + 1;
			System.out.println(s.substring(0, j));
		}
		if (str.contains("two={")) {
			String temp = str;
			int i = temp.indexOf("two={") + 4;
			String s = temp.substring(i);
			int j = s.indexOf("}") + 1;
			System.out.println(s.substring(0, j));
		}
		if (str.contains("three={")) {
			String temp = str;
			int i = temp.indexOf("three={") + 6;
			String s = temp.substring(i);
			int j = s.indexOf("}") + 1;
			System.out.println(s.substring(0, j));
		}
		if (str.contains("four={")) {
			String temp = str;
			int i = temp.indexOf("four={") + 5;
			String s = temp.substring(i);
			int j = s.indexOf("}") + 1;
			System.out.println(s.substring(0, j));
			System.out.println(json2Map(toJsonStr(s.substring(0, j))));
		}
	}

}
