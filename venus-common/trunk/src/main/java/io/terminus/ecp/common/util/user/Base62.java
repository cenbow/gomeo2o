package io.terminus.ecp.common.util.user;

import java.util.regex.Pattern;


/**
 * 
 * @Description 数字转成62进制 
 * @author zhangchunsheng
 * @date 2016年4月28日 下午12:22:15
 */
public class Base62 {

	public static final String TEMPLETE = "XXXXXX";
    public static final String ALPHABET = "abcdefghjkmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWYZ023456789";
    public static final int BASE = ALPHABET.length();

    public static String encoding(long num) {
        StringBuilder str = new StringBuilder();
        while (num > 0) {
            str.insert(0, ALPHABET.charAt((int)(num % BASE)));
            num = num / BASE;
        }
        int l = str.toString().length();
        if(l >= 6) return getPrefix().concat(str.toString());
        
        String suffix = TEMPLETE.substring(l) ;
        return getPrefix().concat(str.append(suffix).toString());
    }
    
    public static String decode(String base62) {
        long num = 0;
        for (int i = 0; i < base62.length(); i++) {
            num = num * BASE + ALPHABET.indexOf(base62.charAt(i));
        }
        return String.valueOf(num);
    }
    
    public static String decodeForPrefix(String base62) {
    	if(null == base62 || "".equals(base62)) return "";
    	if(!isBase62(base62)){ 
    		//非base62类型，就判断必须全数字
    		if(!Pattern.matches("\\d+", base62)){
    			return "";
    		}else{
    			return base62;
    		}
    	}
    	base62 = removePrefix(base62);
    	return decode(base62);
    }

    
    public static String getPrefix() {
    	return "X";
    }
    

    
    public static boolean isBase62(String str) {
    	if(null == str || "".equals(str)) return false;
    	return str.charAt(0) == 'X';
    }
    
    public static String removePrefix(String str) {
    	if(null == str || "".equals(str)) return "";
    	return str.substring(1);
    }

    
    
    public static void main(String []args) {
//    	System.out.println(ALPHABET.length());
//    	System.out.print(encode(Integer.MAX_VALUE));
/*    	Long id = 56800235583L;
    	System.out.println(encoding(id));
    	System.out.println(id.equals(decode(removePrefix(encoding(id)))));*/
    	
    	
    	System.out.println(encoding(100010473022L));
    	System.out.println(decodeForPrefix("XBTOF52QM"));
    }
}