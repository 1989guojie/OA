package org.fkjava.oa.admin.identity.action;

import org.fkjava.oa.admin.identity.service.IdentityService;
import org.fkjava.oa.core.action.AbstractAjaxAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * 验证用户名
 */
public class ValidUserAjax extends AbstractAjaxAction {

	private static final long serialVersionUID = 4379143549410859102L;
	
	@Autowired(required=true)
	@Qualifier(value="identityService")
	private IdentityService identityService;
	
	private String userId;

	/**
	 * 验证用户名是否重复
	 */
	protected String ajaxTask() throws Exception {
		return String.valueOf(identityService.validUserId(userId));
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
