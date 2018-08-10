package org.fkjava.oa.admin.interceptor;

import javax.servlet.http.Cookie;

import org.fkjava.oa.admin.common.AdminConstant;
import org.fkjava.oa.admin.identity.domain.User;
import org.fkjava.oa.admin.identity.service.IdentityService;
import org.fkjava.oa.core.common.CookieTools;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 登录拦截器
 */
public class LoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 3358075254778632022L;
	
	@Autowired
	private IdentityService identityService;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 从session中获取用户
		User user = (User) invocation.getInvocationContext().getSession().get(AdminConstant.ADMIN_SESSION_USER);
//		System.out.println(user);
		
		// 判断是否记住了用户
		if (user == null) {
			// 获取cookie
			Cookie cookie = CookieTools.getCookie(AdminConstant.ADMIN_COOKIE_NAME);
			if (cookie != null) {
				// 获取cookie的值
				String userId = cookie.getValue();
				// 用userId获取用户，存入session
				user = identityService.getUser(userId);
				// 用userId获取用户，存入session
				invocation.getInvocationContext().getSession().put(AdminConstant.ADMIN_SESSION_USER, user);
			}
		}
		
		return user == null ? Action.LOGIN : invocation.invoke();  // 为空登录，否则放行
	}

}
