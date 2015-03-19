package com.dockerapis.quartz.jobs;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class DeployContainersTask implements Job{
	Logger	logger	= Logger.getLogger(DeployContainersTask.class);

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("Task execution has happened surprisingly");
	}
	
}
