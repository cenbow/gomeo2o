package cn.com.mx.badword;

import java.io.File;
import java.io.IOException;

import cn.com.mx.badword.CJFBeanFactory;
import cn.com.mx.badword.ChineseJF;

/**
 * 
 * @author Saiya wyd1011@126.com
 *
 */
public class Demo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("测试开始");
		
		System.out.println("***************************************");
		
		Demo.test02();
		
		
		
		
		System.out.println("测试结束");
	}
	
	
	//测试 简体字符串 转换成 繁体字符串
	public static void test01(){
		
		String janText="中华人民共和国";
		
		// 获得繁体-简体转换器
		ChineseJF chinesdJF = CJFBeanFactory.getChineseJF();
		
		String fanText=chinesdJF.chineseJan2Fan(janText);
		
		System.out.println("简体：\n"+janText+"\n转换后繁体：\n"+fanText);
	}
	
	
	
	//测试 繁体字符串 转换成 简体字符串
	public static void test02(){
		
		String fanText="法论功援交援交援交援交援交援交援交學學學學學學生妹服务";
		//获得繁体-简体转换器
		ChineseJF chinesdJF = CJFBeanFactory.getChineseJF();
		
		String janText = chinesdJF.chineseFan2Jan(fanText);
		
		System.out.println("繁体：\n"+fanText+"\n转换后简体：\n"+janText);
	}

	
	
	/**
	 * 测试 简体文件（GBK） 转换成 繁体文件（UTF-8）
	 * 注意，如果目标文件是UTF-8 字符集格式的，那么需要用UTF-8的文本编辑器来打开，否则乱码
	 * @throws IOException 
	 */
	public static void test03() throws IOException{
		File source_jan_file=new File("D:\\名老中医之路.txt");
		
		String source_jan_file_charSet="GBK";
		
		File target_fan_file=new File("D:\\名老中医之路-繁体.txt");
	
		String target_fan_file_charSet="UTF-8";
		
		//获得繁体-简体转换器
		ChineseJF chinesdJF = CJFBeanFactory.getChineseJF();
		
		long useTime = chinesdJF.chineseJan2Fan(source_jan_file, source_jan_file_charSet, target_fan_file, target_fan_file_charSet);
		
		System.out.println("简体文件->繁体文件 ，用时：[ "+useTime+" ] ms");
	}

	
	/**
	 * 测试 繁体文件(UTF-8) 转换成 简体文件(GBK)
	 * 如果文件是UTF-8 字符集格式的，那么需要用UTF-8的文本编辑器来打开，否则乱码
	 * @throws IOException 
	 */
	public static void test04() throws IOException{
		File source_fan_file=new File("D:\\名老中医之路-繁体.txt");
		
		String source_fan_file_charSet="UTF-8";
		
		File target_jan_file=new File("D:\\名老中医之路-简体.txt");
	
		String target_jan_file_charSet="GBK";
		
		//获得繁体-简体转换器
		ChineseJF chinesdJF = CJFBeanFactory.getChineseJF();
		
		long useTime = chinesdJF.chineseFan2Jan(source_fan_file, source_fan_file_charSet, target_jan_file, target_jan_file_charSet);
		
		System.out.println("繁体文件-->简体文件 ，用时：[ "+useTime+" ] ms");
	
	
	}
	

}
