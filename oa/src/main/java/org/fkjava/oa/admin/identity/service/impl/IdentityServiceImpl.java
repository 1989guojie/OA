package org.fkjava.oa.admin.identity.service.impl;

import java.util.List;

import org.fkjava.oa.admin.identity.dao.JobDao;
import org.fkjava.oa.admin.identity.dao.UserDao;
import org.fkjava.oa.admin.identity.domain.Job;
import org.fkjava.oa.admin.identity.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value="identityService")
public class IdentityServiceImpl implements IdentityService {
	
	@Autowired(required=true)
	@Qualifier(value="jobDao")
	private JobDao jobDao;

	@Autowired(required=true)
	@Qualifier(value="userDao")
	private UserDao userDao;
	
	@Override
	public List<Job> getJobs() {
		System.out.println(userDao);
		return jobDao.find(Job.class);
	}
}
