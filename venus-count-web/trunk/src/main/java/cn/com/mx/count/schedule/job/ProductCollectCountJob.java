package cn.com.mx.count.schedule.job;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import cn.com.mx.count.shop.template.ProductCollectCountTemplate;

/**
 * @Description 商品收藏，定时任务 
 * @author zhaochenyu
 * @date 2016年1月15日 下午5:03:53
 */
public class ProductCollectCountJob implements Job{
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ProductCollectCountTemplate.setProductCollectCountToRedis();
	}
}


