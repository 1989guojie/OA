package org.fkjava.oa.admin.identity.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.fkjava.oa.admin.identity.dao.UserDao;
import org.fkjava.oa.admin.identity.domain.User;
import org.fkjava.oa.core.common.web.PageModel;
import org.fkjava.oa.core.dao.impl.HibernateDaoImpl;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository("userDao")
public class UserDaoImpl extends HibernateDaoImpl implements UserDao {

	/** 多条件分页查询 */
	public List<User> getUserByPage(User user, PageModel pageModel) {
		
		StringBuffer hql = new StringBuffer();
		hql.append("select u from User as u where 1=1");
		
		// 定义集合封装查询条件
		List<Object> params = new ArrayList<>();
		
		// 添加查询条件  
		if (user != null) {
			// 存在用户姓名 
			if (StringUtils.hasText(user.getName())) {
				hql.append(" and u.name like ? ");
				params.add("%"+user.getName()+"%");
			}
			// 手机号
			if (StringUtils.hasText(user.getPhone())) {
				hql.append(" and u.phone like ? ");
				params.add("%"+user.getPhone()+"%");
			}
			// 用户部门
			if (user.getDept() != null && user.getDept().getId() > 0) {
				hql.append(" and u.dept.id = ?");
				params.add("%"+user.getDept().getId()+"%");
			}
		}
		
		return this.findByPage(hql.toString(), pageModel, params);
	}

}
