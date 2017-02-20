package cn.com.mx.count.schedule.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import cn.com.mx.count.shop.template.ShopCollectTemplate;


/**
 * @Description: 统计店铺收藏数
 * @author: yangjun-ds1
 * @date: 2016年1月15日 下午5:42:54
 */
public class ShopCollectJob implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		ShopCollectTemplate.getResultForTemp();
	}

	
}
