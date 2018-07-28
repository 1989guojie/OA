package org.fkjava.oa.admin.identity.dao.impl;

import org.fkjava.oa.admin.identity.dao.JobDao;
import org.fkjava.oa.core.dao.impl.HibernateDaoImpl;
import org.springframework.stereotype.Repository;

@Repository("jobDao")
public class JobDaoImpl extends HibernateDaoImpl implements JobDao {

}
