package cn.com.mx.count.schedule.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import cn.com.mx.count.item.template.ItemOnShelvesTemplate;

/**
 * @Description 店铺上架商品数统计定时任务 
 * @author shangpengfei
 * @date 2016年1月14日 下午2:41:53
 */
public class ItemOnShelvesCountJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		ItemOnShelvesTemplate.itemOnShelvesCount();
	}

}
