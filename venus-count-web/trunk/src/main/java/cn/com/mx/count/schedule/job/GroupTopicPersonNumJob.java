package cn.com.mx.count.schedule.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import cn.com.mx.count.social.topic.Template.GroupTopicPersonNumTemplate;

/**
 * @Description 群组人数,群组下话题数,群组下话题回复数  定时任务 
 * @author yuanchangjun
 * @date 2016年1月12日 下午12:39:07
 */
public class GroupTopicPersonNumJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		GroupTopicPersonNumTemplate.GroupTopicPersonAllNumTemplate();
	}

}
