package com.dockerapis.rest.model.ippool;

public interface IpPoolCreateRepositoryIf {
	public long count();
	public void save(IpPoolCreate ipPoolObj);
	public void delete(IpPoolCreate ipPoolObj);
	public IpPoolCreate findByPoolName(String poolName);
}
