package org.fkjava.oa.admin.identity.action;

import java.util.List;

import org.fkjava.oa.admin.identity.domain.User;

/**
 * 用户管理控制器
 */
public class UserAction extends IdentityAction {

	private static final long serialVersionUID = -2738900069151863543L;
	
	private User user;
	private List<User> users;
	
	/** 多条件分页查询 */
	public String selectUser() {

		try {
			users = identityService.getUserByPage(user, pageModel);
		//	System.out.println(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
