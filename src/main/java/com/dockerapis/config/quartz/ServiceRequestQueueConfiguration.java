package com.dockerapis.config.quartz;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dockerapis.config.quartz.queue.node.JobNode;

@Configuration
public class ServiceRequestQueueConfiguration {

	ConcurrentLinkedQueue<JobNode>	jobQueue;

	public  ServiceRequestQueueConfiguration() {
		jobQueue = new ConcurrentLinkedQueue<JobNode>();
	}
	/*@Bean(name="myqueueBean")
	public ServiceRequestQueueConfiguration serviceRequestQueueConfiguration() {
		
		return new ServiceRequestQueueConfiguration();
	}
*/
	public synchronized void addJobNode(JobNode node) {
		jobQueue.add(node);
	}

	public synchronized JobNode getJobNode() {
		return jobQueue.remove();
	}
	
	public synchronized int jobQueueSize() {
		return jobQueue.size();
	}
}
