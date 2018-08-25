package org.fkjava.oa.admin.identity.dao;

import java.util.List;
import java.util.Map;

import org.fkjava.oa.core.dao.HibernateDao;

public interface DeptDao extends HibernateDao {

	/** 查询部门 (id name) */
	List<Map<String, Object>> loadDept();

}
