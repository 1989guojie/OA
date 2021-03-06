package org.fkjava.oa.admin.identity.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.fkjava.oa.admin.identity.domain.User;
import org.springframework.util.StringUtils;


/**
 * 用户管理控制器
 */
public class UserAction extends IdentityAction {

	private static final long serialVersionUID = -2738900069151863543L;
	
	private User user;
	private List<User> users;
	// 重输密码
	private String repwd;
	
	/** 多条件分页查询 */
	public String selectUser() {
		
		try {
			// 处理get请求中文乱码
			if (ServletActionContext.getRequest().getMethod().equalsIgnoreCase("get") 
					&& user != null && StringUtils.hasText(user.getName())) {
				user.setName(new String(user.getName().getBytes("iso8859-1"), "utf-8"));
			}
			
			users = identityService.getUserByPage(user, pageModel);
		//	System.out.println(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	// 添加用户
	public String addUser() {
		try {
			identityService.saveUser(user);
			this.setTip("添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			this.setTip("添加失败");
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

	public String getRepwd() {
		return repwd;
	}

	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	
}
