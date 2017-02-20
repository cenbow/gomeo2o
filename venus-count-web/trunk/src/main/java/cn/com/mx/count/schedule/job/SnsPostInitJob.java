/**
 * gomeo2o.com 
 * Copyright (c) 2015-2025 All Rights Reserved.
 * @Description TODO 
 * @author kl_chaizhilei
 * @date 2016年1月15日 上午11:58:31
 */
package cn.com.mx.count.schedule.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import cn.com.mx.count.sns.post.template.SnsLovelifePostNumTemplate;

/**
 * @Description 爱生活帖子评论数点赞数定时任务
 * @author kl_chaizhilei
 * @date 2016年1月15日 上午11:58:31
 */
public class SnsPostInitJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		SnsLovelifePostNumTemplate.snsLovelifePostAllNumTemplate();
	}

}
