package org.fkjava.oa.admin.identity.service.impl;

import java.util.List;
import java.util.Map;

import org.fkjava.oa.admin.common.AdminConstant;
import org.fkjava.oa.admin.identity.dao.DeptDao;
import org.fkjava.oa.admin.identity.dao.JobDao;
import org.fkjava.oa.admin.identity.dao.UserDao;
import org.fkjava.oa.admin.identity.domain.Job;
import org.fkjava.oa.admin.identity.domain.User;
import org.fkjava.oa.admin.identity.service.IdentityService;
import org.fkjava.oa.core.action.VerifyAction;
import org.fkjava.oa.core.common.CookieTools;
import org.fkjava.oa.core.common.web.PageModel;
import org.fkjava.oa.core.exception.OAException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service(value="identityService")
@Transactional(readOnly=false, rollbackFor=RuntimeException.class)
public class IdentityServiceImpl implements IdentityService {
	
	@Autowired(required=true)
	@Qualifier(value="jobDao")
	private JobDao jobDao;

	@Autowired(required=true)
	@Qualifier(value="userDao")
	private UserDao userDao;
	
	@Autowired(required=true)
	@Qualifier(value="deptDao")
	private DeptDao deptDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Job> getJobs() {
		System.out.println(userDao);
		return jobDao.find(Job.class);
	}

	
	/**
	 * 用户登录
	 */
	@Transactional(readOnly=true)
	public String login(String userId, String password, String vcode, Integer key) {
		try {
			
			// 定义提示信息
			JSONObject json = new JSONObject();
			json.put("tip", "验证码不正确");
			json.put("status", "1");
			
			// 1.校验验证码
			String oldCode = (String) ActionContext.getContext().getSession().get(VerifyAction.VERIFY_CODE);
			if (StringUtils.hasText(oldCode) && oldCode.equalsIgnoreCase(vcode)) {
				// 2.对用户名和密码做判断
				if (StringUtils.hasText(userId) && StringUtils.hasText(password)) {
					// 3.根据用户名和密码查询用户
					User user = userDao.get(User.class, userId);
					if (user != null && user.getPassWord().equals(password)) {
						// 4.存入session
						ActionContext.getContext().getSession().put(AdminConstant.ADMIN_SESSION_USER, user);
						// 5.是否要记住用户
						if (key == 1) {
							// 6.记住密码，操作cookie,把userId存入cookie
							CookieTools.addCookie(AdminConstant.ADMIN_COOKIE_NAME, user.getUserId(), AdminConstant.ADMIN_MAX_AGE);
						} 
						json.put("tip", "用户登录成功");
						json.put("status", "0");
					} else {
						json.put("tip", "用户名密码不正确");
						json.put("status", "3");
					}
				} else {
					json.put("tip", "用户名密码不能为空");
					json.put("status", "2");
				}
			}
			// 返回提示信息
			return json.toString();
		} catch (OAException e) {
			throw new OAException("用户登录时出现异常", e);
		}
		
	}

	// 根据用户Id获取用户
	@Transactional(readOnly=true)
	public User getUser(String userId) {
		
		try {
			return userDao.get(User.class, userId);
		} catch (Exception e) {
			throw new OAException("用户登录时出现异常", e);
		}
	}


	/** 多条件分页查询 */
	@Transactional(readOnly=true)  // 扩大session作用范围
	public List<User> getUserByPage(User user, PageModel pageModel) {
		
		try {
			 List<User> users = userDao.getUserByPage(user, pageModel);
			// 加载延迟属性,需要在业务层加载，此时session未关闭
			for (User u : users) {
				if (u.getDept() != null) {
					u.getDept().getName();  // get立即获取,load延迟加载
				}
				if (u.getJob() != null) {
					u.getJob().getName();
				}
				if (u.getCreater() != null) {
					u.getCreater().getName();
				}
				if (u.getChecker() != null) {
					u.getChecker().getName();
				}
			}
			
			return users;
		} catch (Exception e) {
			throw new OAException("多条件分页查询用户时出现异常", e);
		}
	}


	// 加载部门下拉列表  返回json格式字符串 
	@Transactional(readOnly=true)  // 扩大session作用范围
	public String loadDept() {
		try {
			// data [{id:1, name:'技术部'}, {}, {}]
			// [] list
			// {} Map new map(code as code, name as name)
			List<Map<String, Object>> depts = deptDao.loadDept();
			// 把集合转换为json数组
			return JSONArray.fromObject(depts).toString();
			
		} catch (Exception e) {
			throw new OAException("加载部门时出现异常", e);
		}
	}

	// 加载职位下拉列表
	public String loadJob() {
		try {
			// data [{code:1, name:'java开发工程师'}, {}, {}]
			List<Map<String, Object>> jobs = jobDao.loadJobs();
			// 把集合转换为json数组
			return JSONArray.fromObject(jobs).toString();
			
		} catch (Exception e) {
			throw new OAException("加载部门时出现异常", e);
		}
	}
	
	

	// 加载部门职位下拉列表
	@Transactional(readOnly=true)
	public String loadDeptJob() {
		try {
			// data : {"depts" : [{},{}], "jobs" : [{}, {}]}  一次返回职位和部门下拉列表
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("depts", loadDept());
			jsonObject.put("jobs", loadJob());
			
			return jsonObject.toString();
			
		} catch (Exception e) {
			throw new OAException("加载部门与职位时出现异常", e);
		}
	}


	// 验证用户名
	@Transactional(readOnly=true)
	public boolean validUserId(String userId) {
		try {
			return getUser(userId) == null;
			
		} catch (Exception e) {
			throw new OAException("加载部门与职位时出现异常", e);
		}
	}
}
