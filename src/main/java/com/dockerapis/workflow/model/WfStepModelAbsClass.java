package com.dockerapis.workflow.model;

public abstract class WfStepModelAbsClass {

	String	stepName;
	String	stepState;
	String	stepStartTime;
	String	stepStepStopTime;

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public abstract void actionFunction(Object o);

	public enum WfStepModelStates {
		NOT_STARTED, STARTED, SUCCESS, FAILURE
	}

	public String getStepState() {
		return stepState;
	}

	public void setStepState(String stepState) {
		this.stepState = stepState;
	}

	public String getStepStartTime() {
		return stepStartTime;
	}

	public void setStepStartTime(String stepStartTime) {
		this.stepStartTime = stepStartTime;
	}

	public String getStepStepStopTime() {
		return stepStepStopTime;
	}

	public void setStepStepStopTime(String stepStepStopTime) {
		this.stepStepStopTime = stepStepStopTime;
	}
}
