package cn.com.mx.webapi.common.utils;

import static com.alibaba.fastjson.util.TypeUtils.castToBigDecimal;
import static com.alibaba.fastjson.util.TypeUtils.castToBigInteger;
import static com.alibaba.fastjson.util.TypeUtils.castToBoolean;
import static com.alibaba.fastjson.util.TypeUtils.castToByte;
import static com.alibaba.fastjson.util.TypeUtils.castToBytes;
import static com.alibaba.fastjson.util.TypeUtils.castToDate;
import static com.alibaba.fastjson.util.TypeUtils.castToDouble;
import static com.alibaba.fastjson.util.TypeUtils.castToFloat;
import static com.alibaba.fastjson.util.TypeUtils.castToInt;
import static com.alibaba.fastjson.util.TypeUtils.castToLong;
import static com.alibaba.fastjson.util.TypeUtils.castToShort;
import static com.alibaba.fastjson.util.TypeUtils.castToSqlDate;
import static com.alibaba.fastjson.util.TypeUtils.castToTimestamp;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;

import cn.com.mx.webapi.common.constant.PublicParamsConstant;
import cn.com.mx.webapi.common.model.PublicParams;

/**
 * @Description servlet参数 
 * @author wanggang-ds6
 * @date 2016年1月22日 下午6:39:18
 */
public class ResourceParameters extends HashMap<String, Object>{

	private static final long serialVersionUID = -4993881545766564163L;

	private ResourceParameters() {		
	}
	
	/**
	 * @Description 获取实例 
	 * @author wanggang-ds6
	 * @date 2016年1月25日 上午11:00:13
	 * @return 实例
	 */
	public static ResourceParameters newInstance() {
		return new ResourceParameters();
	}
	
	/**
	 * @Description 获取boolean包装类 值
	 * @author wanggang-ds6
	 * @date 2016年1月25日 上午11:02:33
	 * @param key 键
	 * @return 值
	 */
	public Boolean getBoolean(String key) {
        Object value = get(key);
        if (value == null) {
            return null;
        }
        return castToBoolean(value);
    }
	
	/**
	 * @Description 获取boolean类型值，null为false 
	 * @author wanggang-ds6
	 * @date 2016年1月25日 上午11:03:04
	 * @param key 键
	 * @return 值
	 */
	public boolean getBooleanValue(String key) {
        Object value = get(key);
        if (value == null) {
            return false;
        }
        return castToBoolean(value).booleanValue();
    }

    /**
     * @Description 获取Byte数组 
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:03:49
	 * @param key 键
	 * @return 值
     */
    public byte[] getBytes(String key) {
        Object value = get(key);
        if (value == null) {
            return null;
        }
        return castToBytes(value);
    }

    /**
     * @Description 获取Byte类型值 
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:05:03
	 * @param key 键
	 * @return 值
     */
    public Byte getByte(String key) {
        Object value = get(key);
        return castToByte(value);
    }

    /**
     * @Description 获取byte类型值 ，null为0
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:05:21
	 * @param key 键
	 * @return 值
     */
    public byte getByteValue(String key) {
        Object value = get(key);
        if (value == null) {
            return 0;
        }
        return castToByte(value).byteValue();
    }

    /**
     * @Description 获取Short类型值 
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:06:05
	 * @param key 键
	 * @return 值
     */
    public Short getShort(String key) {
        Object value = get(key);
        return castToShort(value);
    }

    /**
     * @Description 获取short类型值 ，null为0
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:06:31
	 * @param key 键
	 * @return 值
     */
    public short getShortValue(String key) {
        Object value = get(key);
        if (value == null) {
            return 0;
        }
        return castToShort(value).shortValue();
    }

    /**
     * @Description 获取integer类型值 
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:07:19
	 * @param key 键
	 * @return 值
     */
    public Integer getInteger(String key) {
        Object value = get(key);
        return castToInt(value);
    }

    /**
     * @Description 获取int类型值，null为0 
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:07:34
	 * @param key 键
	 * @return 值
     */
    public int getIntValue(String key) {
        Object value = get(key);
        if (value == null) {
            return 0;
        }
        return castToInt(value).intValue();
    }

    /**
     * @Description 获取Long类型值 
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:07:57
	 * @param key 键
	 * @return 值
     */
    public Long getLong(String key) {
        Object value = get(key);
        return castToLong(value);
    }

    /**
     * @Description 获取long类型值 ，null为0
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:08:27
	 * @param key 键
	 * @return 值
     */
    public long getLongValue(String key) {
        Object value = get(key);
        if (value == null) {
            return 0L;
        }
        return castToLong(value).longValue();
    }

    /**
     * @Description 获取Float类型值 
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:08:47
	 * @param key 键
	 * @return 值
     */
    public Float getFloat(String key) {
        Object value = get(key);
        return castToFloat(value);
    }

    /**
     * @Description 获取float类型值 ，null为0
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:09:07
	 * @param key 键
	 * @return 值
     */
    public float getFloatValue(String key) {
        Object value = get(key);
        if (value == null) {
            return 0F;
        }
        return castToFloat(value).floatValue();
    }

    /**
     * @Description 获取Double类型值 
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:09:53
	 * @param key 键
	 * @return 值
     */
    public Double getDouble(String key) {
        Object value = get(key);
        return castToDouble(value);
    }

    /**
     * @Description 获取double类型值，null为0 
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:10:11
     * @param key
     * @return
     */
    public double getDoubleValue(String key) {
        Object value = get(key);
        if (value == null) {
            return 0D;
        }
        return castToDouble(value);
    }

    /**
     * @Description 获取BigDecimal类型值 
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:10:33
	 * @param key 键
	 * @return 值
     */
    public BigDecimal getBigDecimal(String key) {
        Object value = get(key);
        return castToBigDecimal(value);
    }

    /**
     * @Description 获取BigInteger类型值 
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:10:52
	 * @param key 键
	 * @return 值
     */
    public BigInteger getBigInteger(String key) {
        Object value = get(key);
        return castToBigInteger(value);
    }

    /**
     * @Description 获取String类型值 
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:11:17
	 * @param key 键
	 * @return 值
     */
    public String getString(String key) {
        Object value = get(key);
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    /**
     * @Description 获取date类型值 
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:11:32
	 * @param key 键
	 * @return 值
     */
    public Date getDate(String key) {
        Object value = get(key);
        return castToDate(value);
    }

    /**
     * @Description 获取SqlDate类型值 
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:11:44
	 * @param key 键
	 * @return 值
     */
    public java.sql.Date getSqlDate(String key) {
        Object value = get(key);
        return castToSqlDate(value);
    }

    /**
     * @Description 获取timestamp类型值 
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:11:58
	 * @param key 键
	 * @return 值
     */
    public java.sql.Timestamp getTimestamp(String key) {
        Object value = get(key);
        return castToTimestamp(value);
    }
    
    /**
     * @Description 返回公共参数实体 
     * @author wanggang-ds6
     * @date 2016年1月25日 上午11:47:02
     * @return 公共参数实体
     */
    public PublicParams getPublicParams() {
    	return (PublicParams) get(PublicParamsConstant.PUBLIC_PARAMS_NAME);
    }
}
