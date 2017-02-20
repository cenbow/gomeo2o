package cn.com.mx.badword.utils;

import cn.com.mx.badword.entity.Char;
/**
* 字符过滤器
* 把简体字符过滤成繁体，或则把繁体字符过滤成简体
 * @author zhangyihang
 * @lastEdit 2016年2月18日 17:14:54
*/
public class CharFilter {
	
	
	/**
	 * 简体字符过滤成繁体字符，如果没有找到对照，直接返回输入的简体字符
	 * @param jan 要过滤的简体字符
	 * @param charMapList_Jan2Fan 简体-繁体对照数组
	 * @return 过滤后的繁体字符
	 */
	public static final char jan2Fan(char jan , Char[] charMapList_Jan2Fan){
		int janId = (int)jan;
		int staIndex = 0;
		int endIndex = charMapList_Jan2Fan.length-1;
		int midIndex = (staIndex+endIndex)/2;
		
		while(staIndex<midIndex && midIndex<endIndex){
			if(charMapList_Jan2Fan[midIndex].jId==janId){
				return charMapList_Jan2Fan[midIndex].fChar;
			}
			if(charMapList_Jan2Fan[midIndex].jId>janId){
				endIndex=midIndex;
				midIndex=(staIndex+endIndex)/2;
			}else{
				staIndex=midIndex;
				midIndex=(staIndex+endIndex)/2;
			}
		}
		if(charMapList_Jan2Fan[staIndex].jId==janId){
			return charMapList_Jan2Fan[staIndex].fChar;
		}
		if(charMapList_Jan2Fan[endIndex].jId==janId){
			return charMapList_Jan2Fan[endIndex].fChar;
		}
		return jan;
	}
	
	
	
	/**
	 * 繁体字符过滤成简体字符，如果没有找到对照，直接返回输入的繁体字符
	 * @param fan 要过滤的繁体字符
	 * @param charMapList_Fan2Jan 繁体-简体对照数组
	 * @return 过滤后的简体字符
	 */
	public static final char fan2Jan(char fan , Char[] charMapList_Fan2Jan){
		int fanId = (int)fan;
		int staIndex = 0 ;
		int endIndex = charMapList_Fan2Jan.length-1;
		int midIndex = (staIndex+endIndex)/2;
		
		while(staIndex<midIndex && midIndex<endIndex){
			if(charMapList_Fan2Jan[midIndex].fId==fanId){
				return charMapList_Fan2Jan[midIndex].jChar;
			}
			if(charMapList_Fan2Jan[midIndex].fId>fanId){
				endIndex=midIndex;
				midIndex=(staIndex+endIndex)/2;
			}else{
				staIndex=midIndex;
				midIndex=(staIndex+endIndex)/2;
			}
		}
		if(charMapList_Fan2Jan[staIndex].fId==fanId){
			return charMapList_Fan2Jan[staIndex].jChar;
		}
		if(charMapList_Fan2Jan[endIndex].fId==fanId){
			return charMapList_Fan2Jan[endIndex].jChar;
		}
		return fan;
	}

}
