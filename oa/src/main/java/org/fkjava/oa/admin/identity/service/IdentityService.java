package org.fkjava.oa.admin.identity.service;

import java.util.List;

import org.fkjava.oa.admin.identity.domain.Job;
import org.fkjava.oa.admin.identity.domain.User;
import org.fkjava.oa.core.common.web.PageModel;

public interface IdentityService {

	List<Job> getJobs();

	/**
	 * 用户登录
	 */
	String login(String userId, String password, String vcode, Integer key) throws Exception;

	/**
	 * 根据用户Id获取用户
	 */
	User getUser(String userId);

	/** 多条件分页查询 */
	List<User> getUserByPage(User user, PageModel pageModel);

	/** 加载部门下拉列表  返回json格式字符串 */
	String loadDept();

	/** 加载部门和职位下拉框 */
	String loadDeptJob();
	
	/** 加载职位下拉列表 */
	String loadJob();

	/** 验证用户登录名 */
	boolean validUserId(String userId);

	/** 添加用户 */
	void saveUser(User user);

}
