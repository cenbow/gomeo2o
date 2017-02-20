package cn.com.mx.badword;

import java.io.File;
import java.io.IOException;


/**
 * 接口：简体中文转换成繁体中文，繁体中文转换成简体中文的工具类接口
 * @author zhangyihang
 * @lastEdit 2016年2月18日 17:14:54
 */
public interface ChineseJF {
	
	/**
	 * 简体-繁体 文件转换的时候 一次缓存的大小，单位[char]
	 */
	public static final int cashSize=2000;
	
	/**
	 * 是否被初始化【加载字符映射文件】，true 表示已经初始化了
	 * @return
	 */
	public boolean initialized();
	
	
	/**
	 * 初始化操作[加载字符映射文件]到内存
	 */
	public void init();
	
	/**
	 * 释放加载到内存的字符映射
	 */
	public void free();
	
	/**
	 * 把简体字符串 转换成繁体字符串
	 * @param janText 简体字符串
	 * @return
	 */
	public String chineseJan2Fan(String janText);
	
	
	/**
	 * 把繁体字符串 转换成 简体字符串
	 * @param fanText 繁体字符串
	 * @return
	 */
	public String chineseFan2Jan(String fanText);
	
	
	/**
	 * 简体中文文件 转换成 繁体中文文件
	 * @param sourceFile 源文件 ， 简体中文文件
	 * @param sourceCharSet 源文件字符集
	 * @param targetFile  目标文件 ，保存繁体中文结果的文件【如果文件已经存在，将续接原先内容写入】
	 * @param targetCharSet 目标文件字符集
	 * @return 转换消耗时间，单位 ms
	 * @throws IOException
	 */
	public long chineseJan2Fan(File sourceFile , String sourceCharSet , File targetFile , String targetCharSet)throws IOException;
	
	
	/**
	 * 繁体中文文件 转换成 简体中文文件
	 * @param sourceFile  源文件 ，繁体中文文件
	 * @param sourceCharSet 源文件字符集
	 * @param targetFile 目标文件 ，保存简体中文结果的文件【如果文件已经存在，将续接原先内容写入】
	 * @param targetCharSet 目标文件字符集
	 * @return 转换消耗时间，单位 ms
	 * @throws IOException
	 */
	public long chineseFan2Jan(File sourceFile , String sourceCharSet , File targetFile , String targetCharSet)throws IOException;
	
}
