package cn.com.mx.badword.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import cn.com.mx.badword.entity.Char;

/**
 * 加载中文简体-繁体 ，繁体-简体 对照的资源文件的加载工具
 * @author zhangyihang
 * @lastEdit 2016年2月18日 17:14:54
 */
public class LoadConfig {
	
	
	/**
	 * 要加载的 繁体-简体映射文件，文件的格式是UTF-8
	 */
	public static final String fjMapUTF8="fj_map_utf8.properties";
	
	
	/**
	 * 要加载的 简体-繁体映射文件，文件格式是UTF-8
	 */
	public static final String jfMapUTF8="jf_map_utf8.properties";
	
	
	/**
	 * LoadConfig 单例
	 */
	private static LoadConfig instance = null ;
	
	
	/**
	 * 获得本单例
	 * @return
	 */
	public static LoadConfig getInstance(){
		if(instance==null){
			instance=new LoadConfig();
		}
		return instance;
	}
	
	
	/**
	 * 加载繁体-简体映射，以 Char[] 的形式输出
	 * @return
	 * @throws IOException 当和资源文件IO出现问题，或则文件中的资源对照内容出现异常时抛出
	 */
	public Char[] loadFJmapUTF8() throws IOException{
		String line=null;
		ArrayList list = new ArrayList();
		BufferedReader br = null;
		Char[] charList = null;
		try{
			br = this.getReader(fjMapUTF8);
			int index=0;
			while((line=br.readLine())!=null){
				if(line.startsWith("#")){
					continue;
				}
				if(line.trim().length()==0){
					continue;
				}
				char fChar=line.charAt(0);
				char jChar=line.charAt(2);
				if(index>=(int)fChar){
					list=null;
					throw new IOException("对不起，您的配置文件["+fjMapUTF8+"]有问题！FCharId="+(int)fChar);
				}
				index=(int)fChar;
				list.add(new Char(jChar,fChar));
			}
			charList=new Char[list.size()];
			for(int i=0;i<list.size();i++){
				charList[i]=(Char)list.get(i);
			}
			list=null;
		}catch(IOException ex){
			list=null;
			throw ex;
		}finally{
			if(br!=null){try{br.close();}catch(IOException ex){}}
		}
		return charList;
	}
	
	
	
	/**
	 * 加载 简体-繁体映射，以 Char[] 的形式输出
	 * @return
	 * @throws IOException 当和资源文件IO出现问题，或则文件中的资源对照内容出现异常时抛出
	 */
	public Char[] loadJFmapUTF8() throws IOException{
		String line=null;
		ArrayList list = new ArrayList();
		Char[] charList = null;
		BufferedReader br = null;
		try{
			br=this.getReader(jfMapUTF8);
			int index=0;
			while((line=br.readLine())!=null){
				if(line.startsWith("#")){
					continue;
				}
				if(line.trim().length()==0){
					continue;
				}
				char jChar=line.charAt(0);
				char fChar=line.charAt(2);
				if(index>=(int)jChar){
					list=null;
					throw new IOException("对不起，您的配置文件["+jfMapUTF8+"]有问题！JCharId="+(int)jChar);
				}
				index=(int)jChar;
				list.add(new Char(jChar,fChar));
			}
			
			charList=new Char[list.size()];
			for(int i=0;i<list.size();i++){
				charList[i]=(Char)list.get(i);
			}
			list=null;
		}catch(IOException ex){
			list=null;
			throw ex;
		}finally{
			if(br!=null){try{br.close();}catch(IOException ex){}}
		}
		return charList;
	}
	
	
	
	/**
	 * 给出一个本类同目录的一个文件名，就获得一个"UTF-8"读入的BufferedReader
	 * @param file 文件名
	 * @return BufferedReader对象
	 * @throws RuntimeException 当IO有异常
	 */
	protected BufferedReader getReader(String file){
		BufferedReader bufferedReader = null;
		try{
//			InputStream in = Object.class.getResourceAsStream("/imgsize.properties");  
//			InputStream in = Img.class.getClassLoader().getResourceAsStream("/imgsize.properties");
			InputStream is = this.getClass().getClassLoader().getResourceAsStream(file);
			InputStreamReader isr = new InputStreamReader(is , "UTF-8");
			bufferedReader = new BufferedReader(isr);
		}catch(IOException ex){
			bufferedReader=null;
			throw new RuntimeException(ex);
		}
		return bufferedReader;
	}
	
	
}
