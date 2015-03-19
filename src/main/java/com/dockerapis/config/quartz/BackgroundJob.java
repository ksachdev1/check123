package com.dockerapis.config.quartz;

import java.util.Queue;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;


@Configuration
public class BackgroundJob implements Job {
	Logger								logger	= Logger.getLogger(BackgroundJob.class);

	@Autowired
	ServiceRequestQueueConfiguration	queueConfig;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("Poll the job queue for queued up tasks");
		/*if (queueConfig == null) {
			logger.error("Unable to get bean queueConfig");
		} else {
			logger.info("Queue size is: " + queueConfig.jobQueueSize());
		}*/
		Queue q = TaskQueueSingelton.getInstance().queue;
		if (q != null) {
			logger.error("Q is not null and Q size is "+q.size());
		}
	}

}
