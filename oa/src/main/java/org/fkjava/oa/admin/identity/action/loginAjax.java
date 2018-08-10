package org.fkjava.oa.admin.identity.action;

import org.fkjava.oa.admin.identity.service.IdentityService;
import org.fkjava.oa.core.action.AbstractAjaxAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class loginAjax extends AbstractAjaxAction {
	
	private static final long serialVersionUID = 4088280409239782387L;
	
	private String userId;
	private String password;
	private String vcode;
	private Integer key;
	
	@Autowired(required=true)
	@Qualifier(value="identityService")
	private IdentityService identityService;

	/**
	 * 用户登录
	 */
	protected String ajaxTask() throws Exception {
		return identityService.login(userId, password, vcode, key);
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getVcode() {
		return vcode;
	}


	public void setVcode(String vcode) {
		this.vcode = vcode;
	}


	public Integer getKey() {
		return key;
	}


	public void setKey(Integer key) {
		this.key = key;
	}

	
	
}
