package org.fkjava.oa.admin.identity.action;

import org.fkjava.oa.admin.identity.service.IdentityService;
import org.fkjava.oa.core.action.AbstractAjaxAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class LoadDeptAjax extends AbstractAjaxAction {

	private static final long serialVersionUID = 4379143549410859102L;
	
	@Autowired(required=true)
	@Qualifier(value="identityService")
	private IdentityService identityService;

	/**
	 * 加载部门下拉列表
	 */
	protected String ajaxTask() throws Exception {
		return identityService.loadDept();
	}


}
