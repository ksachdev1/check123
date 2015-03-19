package com.dockerapis.workflow.model;

import java.util.Set;

public class DockerContainerTask extends WorkflowModelAbsClass {

	public DockerContainerTask() {
		AllocateDockerResourcesStep allocateResources = new AllocateDockerResourcesStep();
		DeployDockerStep deploydocker = new DeployDockerStep();

		steps.put(allocateResources.getStepName(), allocateResources);
		steps.put(deploydocker.getStepName(), deploydocker);
	}

	@Override
	public void executeSteps() {
		WfStepModelAbsClass absmodelStep;

		Set<String> keySet = steps.keySet();
		for (String stepName : keySet) {
			absmodelStep = steps.get(stepName);
			absmodelStep.actionFunction(null);
		}
	}
}
