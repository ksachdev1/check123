package com.dockerapis.config.quartz;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class QuartzJobListener implements JobListener {
	Logger logger = Logger.getLogger(QuartzJobListener.class);
	public static final String LISTENER_NAME = "QuartzJobListener";
	@Override
	public String getName() {
		return LISTENER_NAME;
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		logger.info("Start execution for job: "+context.getJobDetail().getKey().toString()+".....");
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context,
			JobExecutionException jobException) {
		if (jobException == null) {
			logger.info("Job execution ended in success");
		}
	}

}
