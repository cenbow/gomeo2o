package cn.com.mx.badword.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


/**
 * 输入输出的IO工具
 * @author zhangyihang
 * @lastEdit 2016年2月18日 17:14:54
 *
 */
public class IOUtil {
	
	public static BufferedReader getReader(File source , String charSet ) throws IOException{
		InputStream is = new FileInputStream(source);
		InputStreamReader isr = new InputStreamReader(is,charSet);
		return new BufferedReader(isr);
	}
	
	
	public static BufferedWriter getWriter(File target , String charSet , boolean append) throws IOException{
		
		OutputStream os = new FileOutputStream(target , append );
		OutputStreamWriter osw = new OutputStreamWriter(os , charSet );
		return new BufferedWriter(osw);
	}
	
	

}
