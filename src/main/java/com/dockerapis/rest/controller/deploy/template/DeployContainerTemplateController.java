package com.dockerapis.rest.controller.deploy.template;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dockerapis.config.quartz.ServiceRequestQueueConfiguration;
import com.dockerapis.config.quartz.queue.node.JobNode;
import com.dockerapis.quartz.jobs.DeployContainersTask;

@RestController
public class DeployContainerTemplateController {
	@Autowired
	Scheduler sched;

	@Autowired
	ServiceRequestQueueConfiguration queueConfig;
	
	Logger logger = Logger.getLogger(DeployContainerTemplateController.class);

	@RequestMapping(value = "/vacscontainer/create", method = RequestMethod.POST)
	public String createVacsContainer() {
		JobNode node = new JobNode();
		JobDetail job = newJob(DeployContainersTask.class).withIdentity(
				"CreateContainerTemplateInstance", "deployContainers").build();
		Trigger trigger = newTrigger().withIdentity("Mytrigger").startNow()
				.build();
		node.setJob(job);
		node.setTrigger(trigger);
		queueConfig.addJobNode(node);
		/*try {
			sched.scheduleJob(job, trigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}*/
		return "Container creation scheduled";
	}
	

}
