package org.fkjava.oa.admin.identity.dao.impl;

import java.util.List;
import java.util.Map;

import org.fkjava.oa.admin.identity.dao.JobDao;
import org.fkjava.oa.core.dao.impl.HibernateDaoImpl;
import org.springframework.stereotype.Repository;

@Repository("jobDao")
public class JobDaoImpl extends HibernateDaoImpl implements JobDao {

	// 加载职位列表
	public List<Map<String, Object>> loadJobs() {
		return this.find("select new map(code as code, name as name) from Job order by code desc");
	}

}
