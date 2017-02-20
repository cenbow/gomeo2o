package cn.com.mx.badword.entity;

import java.io.Serializable;

/**
 * 中文简体字符，繁体字符 映射对象。
 * @author zhangyihang
 * @lastEdit 2016年2月18日 17:14:54
 * 
 */
public final class Char implements Serializable{
	
	/**
	 * 序列ID
	 */
	private static final long serialVersionUID = -3712732188408051103L;


	
	/**
	 * 构造方法
	 * @param jChar 简体字符
	 * @param fChar 繁体字符
	 */
	public Char(char jChar , char fChar){
		this.jId=(int)jChar;
		this.jChar=jChar;
		this.fId=(int)fChar;
		this.fChar=fChar;
	}
	
	/**
	 * 简体字符ID ， 通过 char-int 转换得来
	 */
	public int jId=0;
	
	/**
	 * 简体字符
	 */
	public char jChar=0;
	
	/**
	 * 繁体字符ID ， 通过 char-int 转换得来
	 */
	public int fId=0;
	
	/**
	 * 繁体字符
	 */
	public char fChar=0;

	
	/**
	 * 重写的equals方法
	 */
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}
		if(obj instanceof Char){
			if(((Char)obj).jId == this.jId && ((Char)obj).fId==this.fId){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 重写的hashCode方法
	 */
	public int hashCode() {
		return this.jId + this.fId;
	}

	/**
	 * 重写的toString方法
	 */
	public String toString() {
		return this.jChar+":"+this.fChar;
	} 
	
	
	
	
	
	

}
