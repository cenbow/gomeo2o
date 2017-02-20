/*
 *
 *  * Copyright (c) 2014 杭州端点网络科技有限公司
 *
 */

package io.terminus.ecp.common.util;

import com.google.common.base.Strings;

/**
 * 二进制操作工具
 * Author: haolin
 * On: 12/25/14
 */
public abstract class BinaryUtil {

    /**
     * 将二进制字符串第index(从右往左, 从0开始)位置为0
     * @param binaryStr 二进制字符串
     * @param index 索引 从右往左, 从0开始
     * @return 更新的字符串
     */
    public static String set0(String binaryStr, int index){
        return set(binaryStr, index, '0');
    }

    /**
     * 将二进制字符串第index(从右往左, 从0开始)位置为1
     * @param binaryStr 二进制字符串
     * @param index 索引 从右往左, 从0开始
     * @return 更新的字符串
     */
    public static String set1(String binaryStr, int index){
        return set(binaryStr, index, '1');
    }

    /**
     * 将二进制字符串第index(从右往左, 从0开始)位置为0或1
     * @param binaryStr 二进制字符串
     * @param index 索引 从右往左, 从0开始
     * @param val 0或1
     * @return 更新的字符串
     */
    private static String set(String binaryStr, int index, char val) {
        if (index < 0){
            throw new IllegalArgumentException("index must >= 0");
        }
        StringBuilder updating = Strings.isNullOrEmpty(binaryStr) ? new StringBuilder() : new StringBuilder(binaryStr);
        if (index + 1 > updating.length()){
            updating = leftPadding(updating, index + 1 - updating.length(), '0');
        }
        updating.setCharAt(updating.length() - index - 1, val);
        return updating.toString();
    }

    /**
     * 判断二进制字符串某一位是否为1
     * @param binaryStr 二进制字符串
     * @param index 索引 从右往左, 从0开始
     * @return 为1返回true, 反之false
     */
    public static Boolean has(String binaryStr, int index){
        if (Strings.isNullOrEmpty(binaryStr)){
            return Boolean.FALSE;
        }
        if (index + 1 > binaryStr.length()){
            return Boolean.FALSE;
        }
        return '1' == binaryStr.charAt(binaryStr.length() - index - 1) ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 对字符串进行左填充
     * @param str 字符串
     * @param many 填充多少位
     * @param paddingChar 填充字符串
     * @return 填充后的字符串
     */
    private static StringBuilder leftPadding(StringBuilder str, int many, char paddingChar) {
        StringBuilder paddingStr = new StringBuilder(str);
        for (int i=0; i<many; i++){
            paddingStr.insert(0, paddingChar);
        }
        return paddingStr;
    }
}
