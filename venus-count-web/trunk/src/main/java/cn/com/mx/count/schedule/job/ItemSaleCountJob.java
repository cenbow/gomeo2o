package cn.com.mx.count.schedule.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import cn.com.mx.count.item.constant.ItemConstant;
import cn.com.mx.count.item.template.ItemTemplate;

/**
 * @Description: 商品销量统计任务 
 * @author: shanjie
 * @date: 2016年1月14日 下午5:42:54
 */
public class ItemSaleCountJob implements Job {

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		//商品销量全量统计
		ItemTemplate.itemSaleCountHandler(0, ItemConstant.ItemSaleCountEnum.FULL.getType());
	}
}
