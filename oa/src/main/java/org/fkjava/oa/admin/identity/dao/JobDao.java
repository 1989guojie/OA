package org.fkjava.oa.admin.identity.dao;

import java.util.List;
import java.util.Map;

import org.fkjava.oa.core.dao.HibernateDao;

public interface JobDao extends HibernateDao {

	/** 加载职位列表 */
	List<Map<String, Object>> loadJobs();

}
