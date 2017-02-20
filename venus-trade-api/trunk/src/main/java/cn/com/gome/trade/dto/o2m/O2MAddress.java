package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;

import lombok.Data;

@Data
public class O2MAddress implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2213627974834355744L;
	private String addressAreaCode;//收货地址区域代码
	private String address0;//国家
	private String address1;//省
	private String address2;//市
	private String address3;//区/县
	private String address4;//路/乡/镇(保留)
	private String address5;//号/弄/小区/村/大队(保留)
	private String address6;//详细地址(栋/单元/楼层/门牌号)
	private String postCode;//邮政编码

}
