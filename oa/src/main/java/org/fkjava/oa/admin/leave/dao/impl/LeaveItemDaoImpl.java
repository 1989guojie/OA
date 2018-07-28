package org.fkjava.oa.admin.leave.dao.impl;

import org.fkjava.oa.admin.leave.dao.LeaveItemDao;
import org.fkjava.oa.core.dao.impl.HibernateDaoImpl;
import org.springframework.stereotype.Repository;

@Repository("leaveItemDao")
public class LeaveItemDaoImpl extends HibernateDaoImpl implements LeaveItemDao {

}
