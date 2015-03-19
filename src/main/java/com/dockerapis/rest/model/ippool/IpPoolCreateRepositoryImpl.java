package com.dockerapis.rest.model.ippool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class IpPoolCreateRepositoryImpl implements IpPoolCreateRepositoryIf {

	@Autowired
	private MongoTemplate mongo;

	@Override
	public void save(IpPoolCreate ipPoolObj) {
		mongo.save(ipPoolObj);

	}

	@Override
	public IpPoolCreate findByPoolName(String poolName) {
		Query query = new Query(Criteria.where("subnetMask").is(poolName));
		return mongo.findOne(query, IpPoolCreate.class);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(IpPoolCreate ipPoolObj) {
		mongo.remove(ipPoolObj);
		
	}

}
