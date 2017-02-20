package cn.com.mx.count.schedule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.ee.servlet.QuartzInitializerServlet;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import cn.com.mx.count.bean.ReturnBean;
import cn.com.mx.count.utils.DateUtil;
import cn.com.mx.count.utils.FindClassUtil;

/**
 * @Description 定时任务 
 * @author wanggang-ds6
 * @date 2016年1月6日 下午3:41:40
 */
@Slf4j
@WebServlet("/schedule/*")
public class ScheduleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 6433753348320570529L;
	
	private transient Scheduler scheduler = null;
	
	/**
	 * @Description 初始化，获取scheduler实例 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午3:52:08
	 * @param config
	 * @throws ServletException
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		StdSchedulerFactory factory = (StdSchedulerFactory) config.getServletContext().getAttribute(QuartzInitializerServlet.QUARTZ_FACTORY_KEY);
		try {
			scheduler = factory.getScheduler();
		} catch (SchedulerException e) {
			log.error("获取scheduler失败", e);
		}
	}
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		String type = req.getRequestURI().replace(req.getContextPath() + req.getServletPath(), "");
		String rtnValue;
		switch (type) {
		case "/add":
			rtnValue = addJob(req);
			break;
		case "/jobs":
			rtnValue = getAllJob();
			break;
		case "/triggers":
			rtnValue = getAllTrigger();
			break;
		case "/pause":
			rtnValue = pauseJob(req);
			break;
		case "/resume":
			rtnValue = resumeJob(req);
			break;
		case "/delete":
			rtnValue = deleteJob(req);
			break;
		case "/run":
			rtnValue = triggerJob(req);
			break;
		default:
			rtnValue = new ReturnBean(-1, "未知请求").toJSONString();
			break;
		}
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().println(rtnValue);
	}
	
	/**
	 * @Description 获取全部任务类 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午3:53:54
	 * @return 类列表
	 */
	private String getAllJob() {
		try {
			List<String> classList = FindClassUtil.getAllAssignedClass("cn.com.mx.count.schedule.job", Job.class);
			return new ReturnBean(classList).toJSONString();
		} catch (Exception e) {
			log.error("获取全部任务类失败", e);
			return new ReturnBean(-1, "获取全部任务类失败").toJSONString();
		}				
	}

	/**
	 * @Description 获取全部trigger 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午4:01:12
	 * @throws SchedulerException
	 * @return 任务列表
	 */
	public String getAllTrigger() {
		try {
			List<Map<String, Object>> triggerList = new ArrayList<Map<String,Object>>();
			GroupMatcher<TriggerKey> matcher = GroupMatcher.anyTriggerGroup();		
			Set<TriggerKey> triggerKeySet = scheduler.getTriggerKeys(matcher);
			for (TriggerKey triggerKey: triggerKeySet) {
				Map<String, Object> triggerDetail = new HashMap<String, Object>();
				Trigger trigger = scheduler.getTrigger(triggerKey);
				JobKey jobKey = trigger.getJobKey();
				triggerDetail.put("startTime", DateUtil.timeToString(trigger.getStartTime()));
				triggerDetail.put("endTime", DateUtil.timeToString(trigger.getEndTime()));
				triggerDetail.put("nextFireTime", DateUtil.timeToString(trigger.getNextFireTime()));
				triggerDetail.put("previousFireTime", DateUtil.timeToString(trigger.getPreviousFireTime()));
				triggerDetail.put("triggerGroup", triggerKey.getGroup());
				triggerDetail.put("triggerName", triggerKey.getName());			
				triggerDetail.put("triggerState", scheduler.getTriggerState(triggerKey));
				triggerDetail.put("jobGroup", jobKey.getGroup());
				triggerDetail.put("jobName", jobKey.getName());
				triggerDetail.put("jobClass", scheduler.getJobDetail(jobKey).getJobClass().getName());
				triggerList.add(triggerDetail);
			}
			return new ReturnBean(triggerList).toJSONString();
		} catch (Exception e) {
			log.error("获取全部trigger失败", e);
			return new ReturnBean(-1, "获取全部trigger失败").toJSONString();
		}
		
	}
	

	/**
	 * @Description 添加任务 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午4:21:29
	 * @param req 请求
	 * @return 添加结果
	 */
	@SuppressWarnings("unchecked")
	public String addJob(HttpServletRequest req) {
		try {
			boolean isSimple = Boolean.getBoolean((String) req.getAttribute("isSimple"));
			String jobClass = (String) req.getAttribute("jobClass");
			String jobGroup = (String) req.getAttribute("jobGroup");
			String jobName = (String) req.getAttribute("jobName");
			String triggerGroup = (String) req.getAttribute("triggerGroup");
			String triggerName = (String) req.getAttribute("triggerName");
			String startTime = (String) req.getAttribute("startTime");
			String endTime = (String) req.getAttribute("endTime");
			JobDetail job = JobBuilder
					.newJob((Class<? extends Job>) Class.forName(jobClass))
					.withIdentity(jobName, jobGroup).build();
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroup);
			if (startTime == null) {
				triggerBuilder.startNow();
			} else {
				triggerBuilder.startAt(DateUtil.stringToTime(startTime));
			}
			if (endTime != null) {
				triggerBuilder.endAt(DateUtil.stringToTime(endTime));
			}
			if (isSimple) {
				int interval = Integer.parseInt((String) req.getAttribute("interval"));
				int count = Integer.parseInt((String) req.getAttribute("count"));
				SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
				simpleScheduleBuilder.withIntervalInSeconds(interval);		
				if (count == -1) {
					simpleScheduleBuilder.repeatForever();
				} else {
					simpleScheduleBuilder.withRepeatCount(count);
				}
				triggerBuilder.withSchedule(simpleScheduleBuilder);
			} else {
				String cron = (String) req.getAttribute("cron");
				triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
			}		
			scheduler.scheduleJob(job, triggerBuilder.build());
			return new ReturnBean().toJSONString();
		} catch (Exception e) {
			log.error("添加任务失败", e);
			return new ReturnBean(-1, "添加任务失败：" + e.getMessage()).toJSONString();
		}				
	}
	
	/**
	 * @Description 暂停任务
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午4:26:56
	 * @param req 请求
	 * @return 暂停任务结果
	 */
	public String pauseJob(HttpServletRequest req) {
		try {
			scheduler.pauseJob(getJobKey(req));
			return new ReturnBean().toJSONString();
		} catch (Exception e) {
			log.error("暂停任务失败", e);
			return new ReturnBean(-1, "暂停任务失败：" + e.getMessage()).toJSONString();
		}
	}

	/**
	 * @Description 恢复任务 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午4:32:20
	 * @param req 请求
	 * @return 恢复任务结果
	 */
	public String resumeJob(HttpServletRequest req) {
		try {
			scheduler.resumeJob(getJobKey(req));
			return new ReturnBean().toJSONString();
		} catch (Exception e) {
			log.error("恢复任务失败", e);
			return new ReturnBean(-1, "恢复任务失败：" + e.getMessage()).toJSONString();
		}
	}
	
	/**
	 * @Description 删除任务 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午4:33:22
	 * @param req 请求
	 * @return 删除任务结果
	 */
	public String deleteJob(HttpServletRequest req) {
		try {
			scheduler.deleteJob(getJobKey(req));
			return new ReturnBean().toJSONString();
		} catch (Exception e) {
			log.error("删除任务失败", e);
			return new ReturnBean(-1, "删除任务失败：" + e.getMessage()).toJSONString();
		}
	}
	
	/**
	 * @Description 立即运行任务 
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午4:34:21
	 * @param req
	 * @return 立即运行结果
	 */
	public String triggerJob(HttpServletRequest req) {
		try {
			scheduler.triggerJob(getJobKey(req));
			return new ReturnBean().toJSONString();
		} catch (Exception e) {
			log.error("立即运行任务失败", e);
			return new ReturnBean(-1, "立即运行任务失败：" + e.getMessage()).toJSONString();
		}	
	}
	
	/**
	 * @Description 获取任务
	 * @author wanggang-ds6
	 * @date 2016年1月6日 下午4:35:18
	 * @param req 请求
	 * @return 工作键
	 */
	private JobKey getJobKey(HttpServletRequest req){
		String jobGroup = (String) req.getAttribute("jobGroup");
		String jobName = (String) req.getAttribute("jobName");
		return JobKey.jobKey(jobName, jobGroup);
	}
}
