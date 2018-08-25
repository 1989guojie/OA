package org.fkjava.oa.admin.identity.action;

import org.fkjava.oa.admin.identity.service.IdentityService;
import org.fkjava.oa.core.action.AbstractAjaxAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 加载部门职位
 */
public class LoadDeptJobAjax extends AbstractAjaxAction {

	private static final long serialVersionUID = 4379143549410859102L;
	
	@Autowired(required=true)
	@Qualifier(value="identityService")
	private IdentityService identityService;

	/**
	 * 加载部门和职位下拉列表
	 */
	protected String ajaxTask() throws Exception {
		return identityService.loadDeptJob();
	}


}
