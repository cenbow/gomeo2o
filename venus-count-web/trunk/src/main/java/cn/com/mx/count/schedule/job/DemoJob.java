package cn.com.mx.count.schedule.job;

import lombok.extern.slf4j.Slf4j;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Description demoJob 
 * @author wanggang-ds6
 * @date 2016年1月6日 下午4:43:07
 */
@Slf4j
public class DemoJob implements Job {

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		log.info("执行任务-------------------------------------------");
	}

}
