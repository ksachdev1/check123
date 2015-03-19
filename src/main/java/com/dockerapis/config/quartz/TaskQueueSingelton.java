package com.dockerapis.config.quartz;

import java.util.concurrent.ConcurrentLinkedQueue;

import com.dockerapis.config.quartz.queue.node.JobNode;

public class TaskQueueSingelton {

	public static TaskQueueSingelton		singelton;
	public ConcurrentLinkedQueue<JobNode>	queue;

	public static TaskQueueSingelton getInstance() {
		if (singelton == null) {
			singelton = new TaskQueueSingelton();
		}
		return singelton;
	}

	private TaskQueueSingelton() {
		queue = new ConcurrentLinkedQueue<>();
	}

	public synchronized void QJob(JobNode node) {

		queue.add(node);
	}
	
}
