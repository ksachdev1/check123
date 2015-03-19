package com.dockerapis.config.quartz.queue.node;

import org.quartz.JobDetail;
import org.quartz.Trigger;

public class JobNode {
	JobDetail	job;

	public JobDetail getJob() {
		return job;
	}

	public void setJob(JobDetail job) {
		this.job = job;
	}

	public Trigger getTrigger() {
		return trigger;
	}

	public void setTrigger(Trigger trigger) {
		this.trigger = trigger;
	}

	Trigger	trigger;
}
