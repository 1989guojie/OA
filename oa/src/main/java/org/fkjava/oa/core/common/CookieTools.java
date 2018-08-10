package org.fkjava.oa.core.common;
/**
 * Cookie工具类
 */

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

public final class CookieTools {

	/**
	 * 添加Cookie
	 */
	public static void addCookie(String cookieName, String cookieValue, int maxAge) {
		// 获取cookie
		Cookie cookie = getCookie(cookieName);
		if (cookie == null) {
			// 创建cookie
			cookie = new Cookie(cookieName, cookieValue);
		}
		// 设置有效时间
		cookie.setMaxAge(maxAge);
		// 设置访问路径 http://localhost:8080/
		cookie.setPath("/");
		// 设置跨子域访问 http://www.fkjava.com http://t.fkjava.com
		// 往用户浏览器添加cookie
		ServletActionContext.getResponse().addCookie(cookie);
	}
	
	/**
	 * 根据CookieName获取Cookie
	 */
	public static Cookie getCookie(String cookieName) {
		// 获取用户浏览器中所有的cookie
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(cookieName)) {
					return cookie;
				}
			}
		}
		
		
		return null;
	}
	
	/**
	 * 删除Cookie
	 */
	public static void removeCookie(String cookieName) {
		Cookie cookie = getCookie(cookieName);
		if (cookie != null) {
			// 设置立即失效
			cookie.setMaxAge(0);
			// 设置访问路径 http://localhost:8080/
			cookie.setPath("/");
			// 设置跨子域访问 http://www.fkjava.com http://t.fkjava.com
			// 往用户浏览器添加cookie
			ServletActionContext.getResponse().addCookie(cookie);
		}
	}
}
