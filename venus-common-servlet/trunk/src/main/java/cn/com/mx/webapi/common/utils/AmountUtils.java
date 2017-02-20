package cn.com.mx.webapi.common.utils;

import java.math.BigDecimal;


/**
 * 
 * @Description:  金额元分之间转换工具类
 * @author: fengxin
 * @date: 2015年7月6日 下午3:16:51
 */
public class AmountUtils {
	
	/**金额为分的格式 */
	public static final String CURRENCY_FEN_REGEX = "\\-?[0-9]+";
	
	/**
	 * 
	 * @Description: 将分为单位的转换为元并返回金额格式的字符串 （除100）
     * @author: fengxin
     * @date: 2015年7月6日 下午3:17:01
     * @param amount
     * @throws Exception
     * @return String    
	 */
	public static String changeF2Y(Long amount){
		if(!amount.toString().matches(CURRENCY_FEN_REGEX)) {
			return "0.00";
		}
		
		int flag = 0;
		String amString = amount.toString();
		if(amString.charAt(0)=='-'){
			flag = 1;
			amString = amString.substring(1);
		}
		StringBuffer result = new StringBuffer();
		if(amString.length()==1){
			result.append("0.0").append(amString);
		}else if(amString.length() == 2){
			result.append("0.").append(amString);
		}else{
			String intString = amString.substring(0,amString.length()-2);
			for(int i=1; i<=intString.length();i++){
				/*if( (i-1)%3 == 0 && i !=1){
					result.append(",");
				}*/
				result.append(intString.substring(intString.length()-i,intString.length()-i+1));
			}
			result.reverse().append(".").append(amString.substring(amString.length()-2));
		}
		if(flag == 1){
			return "-"+result.toString();
		}else{
			return result.toString();
		}
	}
	
	/**
	 * 
	 * @Description: 将分为单位的转换为元 （除100）
     * @author: fengxin
     * @date: 2015年7月6日 下午3:17:17
     * @param amount
     * @throws Exception
     * @return String    
	 */
	public static String changeF2Y(String amount){
		if(!amount.matches(CURRENCY_FEN_REGEX)) {
			return "0.00";
		}
		return BigDecimal.valueOf(Long.valueOf(amount)).divide(new BigDecimal(100)).toString();
	}
	
	/**
	 * 
	 * @Description: 将元为单位的转换为分 （乘100）
     * @author: fengxin
     * @date: 2015年7月6日 下午3:17:34
     * @param amount
     * @return String    
	 */
	public static String changeY2F(Long amount){
		return BigDecimal.valueOf(amount).multiply(new BigDecimal(100)).toString();
	}
	
	/**
	 * 
	 * @Description: 将元为单位的转换为分 替换小数点，支持以逗号区分的金额
     * @author: fengxin
     * @date: 2015年7月6日 下午3:17:47
     * @param amount
     * @return
     * @return String    
     * @throws
	 */
	public static String changeY2F(String amount){
		String currency =  amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额
		int index = currency.indexOf(".");
		int length = currency.length();
		Long amLong = 0l;
		if(index == -1){
			amLong = Long.valueOf(currency+"00");
		}else if(length - index >= 3){
			amLong = Long.valueOf((currency.substring(0, index+3)).replace(".", ""));
		}else if(length - index == 2){
			amLong = Long.valueOf((currency.substring(0, index+2)).replace(".", "")+0);
		}else{
			amLong = Long.valueOf((currency.substring(0, index+1)).replace(".", "")+"00");
		}
		return amLong.toString();
	}
	
	public static void main(String[] args) throws NumberFormatException, Exception {
		Integer.valueOf("12");
		System.err.println(changeF2Y((long)123123));
	}
}

