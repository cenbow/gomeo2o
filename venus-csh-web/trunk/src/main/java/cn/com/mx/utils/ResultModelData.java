package cn.com.mx.utils;

import java.io.Serializable;
import java.util.List;

import net.sf.json.JSONObject;

/**
 * @Description 统一列表返回页面以及AJAX数据返回 
 * @author yuanchangjun
 * @date 2016年2月19日 上午11:51:10
 * @param <T>
 */
public class ResultModelData<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private int sEcho = 0;

	private int iTotalRecords = 0;

	private int iTotalDisplayRecords = 0;

	private List<?> aaData;

	public ResultModelData() {

	}

	public ResultModelData(JSONObject json, int iTotalRecords,int iTotalDisplayRecords, List<?> aaData) {
		super();
		this.sEcho = json.getInt("sEcho");
		this.iTotalRecords = iTotalRecords;
		this.iTotalDisplayRecords = iTotalDisplayRecords;
		this.aaData = aaData;
	}

	public int getsEcho() {
		return sEcho;
	}

	public void setsEcho(int sEcho) {
		this.sEcho = sEcho;
	}

	public int getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public List<?> getAaData() {
		return aaData;
	}

	public void setAaData(List<?> aaData) {
		this.aaData = aaData;
	}
}