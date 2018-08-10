package org.fkjava.oa.admin.identity.service;

import java.util.List;

import org.fkjava.oa.admin.identity.domain.Job;

public interface IdentityService {

	List<Job> getJobs();

	/**
	 * 用户登录
	 */
	String login(String userId, String password, String vcode, Integer key);

}
