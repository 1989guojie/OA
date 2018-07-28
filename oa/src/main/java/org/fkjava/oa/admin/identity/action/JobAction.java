package org.fkjava.oa.admin.identity.action;

import java.util.List;

import org.fkjava.oa.admin.identity.domain.Job;
import org.fkjava.oa.admin.identity.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

public class JobAction extends ActionSupport {

	private static final long serialVersionUID = -2660755801894984486L;

	@Autowired(required=true) // 按类型注入
	@Qualifier(value="identityService")
	private IdentityService identityService;  // 接口
	
	@Override
	public String execute() throws Exception {
		List<Job> jobs = identityService.getJobs();
		System.out.println(jobs);
		return SUCCESS;
	}
}
