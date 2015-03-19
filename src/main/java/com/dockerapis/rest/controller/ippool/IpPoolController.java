package com.dockerapis.rest.controller.ippool;

import java.util.Queue;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dockerapis.config.quartz.TaskQueueSingelton;
import com.dockerapis.config.quartz.queue.node.JobNode;
import com.dockerapis.model.mongodb.IpPoolRequest;
import com.dockerapis.rest.model.ippool.IpPoolCreate;
import com.dockerapis.rest.model.ippool.IpPoolCreateRepositoryIf;
import com.dockerapis.rest.model.ippool.IpPoolCreateRepositoryImpl;

@RestController
public class IpPoolController {
	Logger	logger	= Logger.getLogger(IpPoolController.class);

	@Autowired
	IpPoolCreateRepositoryIf ipPoolrepo;
	
	@RequestMapping(value = "/ippool/{poolname}", method = RequestMethod.GET)
	public IpPoolCreate getIpPoolInfo(@PathVariable("poolname") String poolName) throws InterruptedException {
		logger.info("Pool name queried is "+poolName);
		IpPoolCreate poolr = ipPoolrepo.findByPoolName(poolName);
		Queue q = TaskQueueSingelton.getInstance().queue;
		JobNode node = new JobNode();
		q.add(node);
		poolr = new IpPoolCreate();
		poolr.setPoolName("mili");
		poolr.setSubnetMask("test123");
		logger.error("pool subnet is "+poolr.getSubnetMask());
		
		return poolr;
	}
	@RequestMapping(value = "/ippool/create", method = RequestMethod.POST)
	public ResponseEntity<IpPoolCreate> createIpPool(@RequestBody IpPoolCreate poolCreateObj) {
		
		logger.info("Create ippool with name "+poolCreateObj.getPoolName());
		ipPoolrepo.save(poolCreateObj);
		return new ResponseEntity<IpPoolCreate>(poolCreateObj, HttpStatus.CREATED);
		
	}
	
}
