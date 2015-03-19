package com.dockerapis.model.mongodb;

public class IpPoolRequest {
	private String name;
	private String ipPoolInputStr;
	private String subnetMask;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIpPoolInputStr() {
		return ipPoolInputStr;
	}

	public void setIpPoolInputStr(String ipPoolInputStr) {
		this.ipPoolInputStr = ipPoolInputStr;
	}

	public String getSubnetMask() {
		return subnetMask;
	}

	public void setSubnetMask(String subnetMask) {
		this.subnetMask = subnetMask;
	}
}
