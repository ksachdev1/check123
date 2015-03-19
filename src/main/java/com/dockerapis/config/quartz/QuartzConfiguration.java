package com.dockerapis.config.quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import com.dockerapis.config.quartz.queue.node.JobNode;

@Configuration
public class QuartzConfiguration {
	Logger	logger	= Logger.getLogger(QuartzConfiguration.class);

	@Bean
	Scheduler scheduler() throws SchedulerException {
		SchedulerFactory schedFact = new StdSchedulerFactory();
		Scheduler sched = schedFact.getScheduler();
		sched.getListenerManager().addJobListener(quartzJobListener());
		sched.start();
		logger.info("Starting the quartz scheduler........");
		createBackgroundJob(sched);
		
		
		return sched;
	}

	@Bean
	Queue<JobNode> queue() {
		return new ConcurrentLinkedQueue<JobNode>();
	}
	@Bean
	QuartzJobListener quartzJobListener() {
		return new QuartzJobListener();
	}

	private void createBackgroundJob(Scheduler sched) {

		JobDetail job = newJob(BackgroundJob.class).withIdentity(
				"BackgroundPollingJob", "backgroundJobPollQueue").build();
		Trigger trigger = newTrigger()
				.withIdentity("MyBackgroundJobTrigger")
				.withSchedule(
						simpleSchedule().repeatForever().withIntervalInSeconds(
								5)).startNow().build();
		try {
			sched.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}

	}

}
