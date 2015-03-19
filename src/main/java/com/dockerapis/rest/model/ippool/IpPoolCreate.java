package com.dockerapis.rest.model.ippool;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "StaticIpPools")
public class IpPoolCreate {
	@Id
	String poolName;
	String ipAddressRange;
	String subnetMask;

	public String getPoolName() {
		return poolName;
	}

	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}

	public String getIpAddressRange() {
		return ipAddressRange;
	}

	public void setIpAddressRange(String ipAddressRange) {
		this.ipAddressRange = ipAddressRange;
	}

	public String getSubnetMask() {
		return subnetMask;
	}

	public void setSubnetMask(String subnetMask) {
		this.subnetMask = subnetMask;
	}
}
