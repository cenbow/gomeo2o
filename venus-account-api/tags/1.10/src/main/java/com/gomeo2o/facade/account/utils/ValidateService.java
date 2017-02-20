package com.gomeo2o.facade.account.utils;

import java.lang.reflect.Field;
import com.gomeo2o.facade.account.exception.ScoreException;

public class ValidateService {
	
    
    public ValidateService() {
        super();
    }
     
    //解析的入口
    public static void valid(Object object){
        //获取object的类型
        Class<? extends Object> clazz=object.getClass();
        //获取该类型声明的成员
        Field[] fields=clazz.getDeclaredFields();
        //遍历属性
        for(Field field:fields){
            //对于private私有化的成员变量，通过setAccessible来修改器访问权限
            field.setAccessible(true);
            validate(field,object);
            //重新设置会私有权限
            field.setAccessible(false);
        }
    }
     
     
    public static void validate(Field field,Object object){
 
        String description;
        Object value = null;
        ValidAnnotation dv;
 
        //获取对象的成员的注解信息
        dv=field.getAnnotation(ValidAnnotation.class);
        try {
			value=field.get(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
         
        if(dv==null)return;
         
        description=dv.description().equals("")?field.getName():dv.description();
         
        /*************注解解析工作开始******************/
        if(!dv.nullable()){
            if(value==null||StringUtils.isBlank(value.toString())){
            	throw ScoreException.CHECK_FAILE.newInstance("%s不能为空", description);
            }
        }
         
        if(value.toString().length()>dv.maxLength()&&dv.maxLength()!=0){
        	throw ScoreException.CHECK_FAILE.newInstance("%s长度不能超过"+dv.maxLength(), description);
        }
         
        if(value.toString().length()<dv.minLength()&&dv.minLength()!=0){
        	throw ScoreException.CHECK_FAILE.newInstance("%s长度不能小于"+dv.minLength(), description);
        }
         
        if(dv.regexType()!=RegexType.NONE){
            switch (dv.regexType()) {
                case NONE:
                    break;
                case SPECIALCHAR:
                    if(RegexUtils.hasSpecialChar(value.toString())){
                    	throw ScoreException.CHECK_FAILE.newInstance("%s不能含有特殊字符", description);
                    }
                    break;
                case CHINESE:
                    if(RegexUtils.isChinese2(value.toString())){
                    	throw ScoreException.CHECK_FAILE.newInstance("%s不能含有中文字符", description);
                    }
                    break;
                case EMAIL:
                    if(!RegexUtils.isEmail(value.toString())){
                    	throw ScoreException.CHECK_FAILE.newInstance("%s地址格式不正确", description);
                    }
                    break;
                case IP:
                    if(!RegexUtils.isIp(value.toString())){
                    	throw ScoreException.CHECK_FAILE.newInstance("%s地址格式不正确", description);
                    }
                    break;
                case NUMBER:
                    if(!RegexUtils.isNumber(value.toString())){
                    	throw ScoreException.CHECK_FAILE.newInstance("%s不是数字", description);
                    }
                    break;
                case PHONENUMBER:
                    if(!RegexUtils.isPhoneNumber(value.toString())){
                    	throw ScoreException.CHECK_FAILE.newInstance("%s不是数字", description);
                    }
                    break;
                default:
                    break;
            }
        }
         
        if(!dv.regexExpression().equals("")){
            if(value.toString().matches(dv.regexExpression())){
            	throw ScoreException.CHECK_FAILE.newInstance("%s格式不正确", description);
            }
        }
        /*************注解解析工作结束******************/
    }
}
