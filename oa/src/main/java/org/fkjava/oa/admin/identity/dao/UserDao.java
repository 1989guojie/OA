package org.fkjava.oa.admin.identity.dao;

import java.util.List;

import org.fkjava.oa.admin.identity.domain.User;
import org.fkjava.oa.core.common.web.PageModel;
import org.fkjava.oa.core.dao.HibernateDao;

public interface UserDao extends HibernateDao {

	/** 多条件分页查询 */
	List<User> getUserByPage(User user, PageModel pageModel);

}
