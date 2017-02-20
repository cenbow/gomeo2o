package cn.com.mx.cms.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class ChangePriceUtil {
	/**
	 * 精确到小数点以后多少位
	 */
	private static final int def_div_scale = 2;
	public static final int TEN = 10;
	public static final int HUNDRED = 100;
	public static final DecimalFormat df5 = new DecimalFormat("0.00");

	public static String changePrice(Integer price) {
		if (price != null && price != 0) {
			float fPrice = Float.valueOf(price);
			float result = fPrice / 100;
			DecimalFormat decimalFormat = new DecimalFormat("0.00");
			String format = decimalFormat.format(result);
			return format;
		} else {
			return "0.00";
		}
	}

	public static String changePriceDouble(Double fPrice) {
		if (fPrice != null && fPrice != 0) {
			double result = fPrice;
			DecimalFormat decimalFormat = new DecimalFormat("0.00");
			String format = decimalFormat.format(result);
			return format;
		} else {
			return "0.00";
		}
	}

	public static double changeToDoublePrice(Integer price) {
		return Double.valueOf(changePrice(price));
	}

	/**
	 * 保留两位小数
	 * 
	 * @param v
	 * @return
	 */
	public static BigDecimal getBigDecimal(String v) {
		BigDecimal bg = new BigDecimal(v);
		bg = bg.setScale(2, BigDecimal.ROUND_DOWN);
		return bg;
	}

	/**
	 * 提供精确的加法运算
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 提供精确的减法运算
	 * 
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */
	public static BigDecimal sub(BigDecimal v1, BigDecimal v2) {
		return v1.subtract(v2).setScale(2, BigDecimal.ROUND_HALF_DOWN);// 不进行四舍五入
	}

	/**
	 * 提供精确的乘法运算
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static BigDecimal mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.multiply(b2).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 提供精确的乘法运算
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static BigDecimal mul(BigDecimal v1, BigDecimal v2) {

		return v1.multiply(v2).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 提供精确的乘法运算(不四舍五入)
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static BigDecimal mulhd(BigDecimal v1, BigDecimal v2) {
		BigDecimal v = v1.multiply(v2);
		return v.setScale(2, BigDecimal.ROUND_DOWN);
	}

	/**
	 * @Description: 将给定的金额乘100
	 * @author duwei
	 * @param v
	 *            要乘100的金额
	 * @return 返回乘100后的金额
	 */
	public static BigDecimal mulHUNDRED(BigDecimal v) {
		return mulhd(v, new BigDecimal(HUNDRED));
	}

	

	public static double div(double v1, double v2) {
		return div(v1, v2, def_div_scale);
	}
	
	/**
	 * 两数相除，结果按四舍五入取小数点后2位
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 *            
	 * @return 两个参数的商
	 */
	public static String formatDiv(double v1, double v2) {
		return formatDiv(v1, v2, def_div_scale);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 两数相除，结果按四舍五入取小数点后scale参数指定的位数
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale 
	 *            结果保留小数点后位数  
	 *                     
	 * @return 两个参数的商
	 */
	public static String formatDiv(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return df5.format(b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue());
	}

	/**
	 * 限时折扣数用
	 * 
	 * @param v1
	 * @param v2
	 * @param scale
	 * @return
	 */
	public static BigDecimal divdis(BigDecimal v1, BigDecimal v2) {
		return v1.divide(v2);
	}

	/**
	 * 提供精确的小数位四舍五入处理
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(double v, int scale) {
		if (scale < 0) {
			scale = 0;
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 提供精确的小数位四舍五入处理
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static BigDecimal round(String v, int scale) {
		if (scale < 0) {
			scale = 0;
		}
		BigDecimal b = new BigDecimal(v);
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 比较大小
	 * 
	 * @param v1
	 * @param v2
	 * @return 返回值 -1 小于 0 等于 1 大于
	 */
	public static int compareTo(BigDecimal v1, BigDecimal v2) {
		return v1.compareTo(v2);
	}

	/**
	 * DecimalFormat("0.00");
	 */
	public static String decimalFormat(BigDecimal bigDecimal) {
		DecimalFormat formater = new DecimalFormat("0.00");
		formater.setMaximumFractionDigits(2);
		formater.setGroupingSize(0);
		formater.setRoundingMode(RoundingMode.FLOOR);
		return formater.format(bigDecimal);
	}

	public static Long ObjectToLong(Object obj) {
		if (obj instanceof Double) {
			return new Double((Double) obj).longValue();
		} else if (obj instanceof Float) {
			return new Float((Float) obj).longValue();
		} else if (obj instanceof BigDecimal) {
			BigDecimal t = (BigDecimal) obj;
			return t.longValue();
		} else {
			return (Long) obj;
		}
	}

}
