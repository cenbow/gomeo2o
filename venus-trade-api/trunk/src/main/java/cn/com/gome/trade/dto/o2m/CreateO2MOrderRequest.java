package cn.com.gome.trade.dto.o2m;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class CreateO2MOrderRequest   implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1672872335371241632L;
	private String outerOrderId;//外部订单ID(国美在线、国美家等渠道的订单号)
	private String tempOrderId;//o2m拆单成功成功后返回的O2M临时主订单ID
	private Integer orderType;//0正向3拒收4退货5换货
	private Integer payType;//支付方式：1-在线支付 2-货到付款
	private Long originalSubOrderId;//逆向时的原子订单ID(提交正向订单时返回的订单号)
	private String reverseReason;//申请逆向的原因
	private Integer hasReverseReport;//申请逆向时是否有检测报告 0无1有
    private String saleTime;//销售时间或申请逆向的时间
    private Integer dealAmount;//商品成交总额 单位分，不含运费，去掉优惠、去掉运费，正向订单为正值，逆向订单为负值
    private Integer discAmount;//商品折扣总额 单位分，正向订单为正值，逆向订单为负值
    private Integer deliverFee;//配送费 单位分，收顾客钱为正值，退顾客钱为负值
    private Buyer buyer;//买家信息
    private String buyerNote;//顾客留言
    private String invoiceTitle;//发票抬头
    private ConsigneeInfo consigneeInfo;//收货人信息
    private Integer deliverDateType;//1工作日2周末3全部
    private AppointmentTime deliverTime;//预约送货时间
    private AppointmentTime installTime;//预约安装时间
    private List<SubOrder> subOrders;//o2m子订单列表
    
}
