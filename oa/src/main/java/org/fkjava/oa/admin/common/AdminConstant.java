package org.fkjava.oa.admin.common;

import org.fkjava.oa.admin.identity.domain.User;

import com.opensymphony.xwork2.ActionContext;

/**
 * 子系统常量类
 */
public final class AdminConstant {
	/** admin子系统存放在session中的用户 */
	public static final String ADMIN_SESSION_USER = "admin_session_user";
	/** cookie的名称 */
	public static final String ADMIN_COOKIE_NAME = "admin_cookie_name";
	/** 有效时间 */
	public static final int ADMIN_MAX_AGE = 7 * 24 * 60 * 60;
	
	/** 获取session中的用户 */
	public static User getSessionUser() {
		return (User) ActionContext.getContext().getSession().get(ADMIN_SESSION_USER);
	}

}
