package cn.com.mx.cms.utils;

import java.util.List;

/**
 * 字符串工具类
 */
public class StringUtil {

	/**
	 * 默认的空值
	 */
	public static final String EMPTY = "";
	
	public static String toTrim(String str) {
		if (str == null)
			return "";
		if (str.trim().equalsIgnoreCase("null"))
			return "";
		else
			return str.trim();
	}

	/**
	 * 转换成字符串,如果对象为Null,则返回空字符串
	 * 
	 * @param obj
	 *            需要判断的对象数组
	 * @return boolean
	 */
	public static String valueOf(Object obj) {
		if (obj != null) {
			return obj.toString();
		}
		return "";
	}

	/**
	 * 检查字符串是否为空
	 * 
	 * @param str
	 *            字符串
	 * @return 是否为空
	 */
	public static boolean isEmpty(Object str) {
		if (str == null || valueOf(str).length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 检查字符串是否不为空
	 * 
	 * @param str
	 *            字符串
	 * @return 是否不为空
	 */
	public static boolean isNotEmpty(Object str) {
		return !isEmpty(str);
	}

	/**
	 * 截取并保留标志位之前的字符串
	 * 
	 * @param str
	 *            字符串
	 * @param expr
	 *            分隔符
	 * @return 字符串
	 */
	public static String substringBefore(String str, String expr) {
		if (isEmpty(str) || expr == null) {
			return str;
		}
		if (expr.length() == 0) {
			return EMPTY;
		}
		int pos = str.indexOf(expr);
		if (pos == -1) {
			return str;
		}
		return str.substring(0, pos);
	}

	/**
	 * 截取并保留标志位之后的字符串
	 * 
	 * @param str
	 *            字符串
	 * @param expr
	 *            分隔符
	 * @return 字符串
	 */
	public static String substringAfter(String str, String expr) {
		if (isEmpty(str)) {
			return str;
		}
		if (expr == null) {
			return EMPTY;
		}
		int pos = str.indexOf(expr);
		if (pos == -1) {
			return EMPTY;
		}
		return str.substring(pos + expr.length());
	}

	/**
	 * 截取并保留最后一个标志位之前的字符串
	 * 
	 * @param str
	 *            字符串
	 * @param expr
	 *            分隔符
	 * @return 字符串
	 */
	public static String substringBeforeLast(String str, String expr) {
		if (isEmpty(str) || isEmpty(expr)) {
			return str;
		}
		int pos = str.lastIndexOf(expr);
		if (pos == -1) {
			return str;
		}
		return str.substring(0, pos);
	}

	/**
	 * 截取并保留最后一个标志位之后的字符串
	 * 
	 * @param str
	 *            字符串
	 * @param expr
	 *            分隔符
	 * @return 字符串
	 */
	public static String substringAfterLast(String str, String expr) {
		if (isEmpty(str)) {
			return str;
		}
		if (isEmpty(expr)) {
			return EMPTY;
		}
		int pos = str.lastIndexOf(expr);
		if (pos == -1 || pos == (str.length() - expr.length())) {
			return EMPTY;
		}
		return str.substring(pos + expr.length());
	}

	/**
	 * 把字符串按分隔符转换为数组
	 * 
	 * @param string
	 *            字符串
	 * @param expr
	 *            分隔符
	 * @return 字符串数组
	 */
	public static String[] split(String string, String expr) {
		return string.split(expr);
	}

	/**
	 * 去除字符串中的空格
	 * 
	 * @param str
	 *            字符串
	 * @return 去除空格后的结果
	 */
	public static String noSpace(String str) {
		str = str.trim();
		str = str.replace(" ", "_");
		return str;
	}

	/**
	 * 截取指定长度的字符串，并将被截掉的字符转化为...
	 * 
	 * @param str
	 *            要截取的字符串
	 * @param length
	 *            要截取的长度
	 * @return 字符串
	 */
	public static String toSubSuspension(String str, int length) {
		if (StringUtil.isEmpty(str)) {
			return str;
		}
		str = str.substring(0, length) + "...";
		return str;
	}

	/**
	 * 比较字符串是否相等
	 * 
	 * @param str1
	 *            字符串
	 * @param str2
	 *            字符串
	 * @return boolean
	 */
	public static boolean equals(String str1, String str2) {
		if (str1 == null && str2 == null) {
			return true;
		}
		if ("".equals(str1) && "".equals(str2)) {
			return true;
		}
		return str1.equals(str2);
	}

	/**
	 * 字节数组获取MD5字符串
	 * 
	 * @param source
	 * @return
	 */
	public static String getMD5(byte[] source) {
		String s = null;
		char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			md.update(source);
			byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
										// 用字节表示就是 16 个字节
			char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
											// 所以表示成 16 进制需要 32 个字符
			int k = 0; // 表示转换结果中对应的字符位置
			for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
											// 转换成 16 进制字符的转换
				byte byte0 = tmp[i]; // 取第 i 个字节
				str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
															// >>>
															// 为逻辑右移，将符号位一起右移
				str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
			}
			s = new String(str); // 换后的结果转换为字符串
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
}
