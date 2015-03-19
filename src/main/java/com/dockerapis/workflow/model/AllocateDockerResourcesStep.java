package com.dockerapis.workflow.model;

import org.apache.log4j.Logger;

public class AllocateDockerResourcesStep extends WfStepModelAbsClass {

	Logger logger = Logger.getLogger(AllocateDockerResourcesStep.class);
	@Override
	public void actionFunction(Object o) {
		logger.info("Allocate Docker Resources");
	}
	
		
}
