package org.fkjava.oa.admin.identity.dao.impl;

import java.util.List;
import java.util.Map;

import org.fkjava.oa.admin.identity.dao.DeptDao;
import org.fkjava.oa.core.dao.impl.HibernateDaoImpl;
import org.springframework.stereotype.Repository;

@Repository("deptDao")
public class DeptDaoImpl extends HibernateDaoImpl implements DeptDao {

	// 查询部门列表
	public List<Map<String, Object>> loadDept() {
		return this.find("select new map(id as id, name as name) from Dept order by id asc");
	}

}
