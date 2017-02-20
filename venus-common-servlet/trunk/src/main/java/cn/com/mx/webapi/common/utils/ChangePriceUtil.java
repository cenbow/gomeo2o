package cn.com.mx.webapi.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ChangePriceUtil {
	
	public static BigDecimal changePrice(Long price){
		if(price!=null && price!=0){
			double dPrice  = price/(double)100;
			DecimalFormat decimalFormat = new DecimalFormat("0.00"); 
			String strPrice = decimalFormat.format(dPrice);
			BigDecimal bd = new BigDecimal(strPrice);
			return bd;
		}else{
			return new BigDecimal("0.00"); 
		}
	}
	
	public static String changePrice(Integer price){
		if(price!=null && price !=0){
			double dPrice = Double.valueOf(price);
			double result = dPrice/100;
			DecimalFormat decimalFormat = new DecimalFormat("0.00");
			String format = decimalFormat.format(result);
			return format;
		}else{
			return "0.00";
		}
	}
	
	public static String changePriceDouble(Double fPrice){
		if(fPrice!=null && fPrice !=0){
			double result = fPrice;
			DecimalFormat decimalFormat = new DecimalFormat("0.00");
			String format = decimalFormat.format(result);
			return format;
		}else{
			return "0.00";
		}
	}
	
	public static double changeToDoublePrice(Integer price){
		return Double.valueOf(changePrice(price));
	}
	public static void main(String[] args) {
		System.out.println(changePrice(555555522));
		System.out.println(changePriceDouble(555555522.0));
	}
}
