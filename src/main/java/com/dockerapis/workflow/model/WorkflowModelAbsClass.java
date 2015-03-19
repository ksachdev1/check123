package com.dockerapis.workflow.model;

import java.util.LinkedHashMap;

public abstract class WorkflowModelAbsClass {
	String										workflowName;
	LinkedHashMap<String, WfStepModelAbsClass>	steps;

	public WorkflowModelAbsClass() {
		steps = new LinkedHashMap<String, WfStepModelAbsClass>();
	}

	public enum WfModelStates {
		NOT_STARTED, STARTED, SUCCESS, FAILURE
	}
	
	public abstract void executeSteps();
}
