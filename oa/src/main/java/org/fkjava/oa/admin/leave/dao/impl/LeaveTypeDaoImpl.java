package org.fkjava.oa.admin.leave.dao.impl;

import org.fkjava.oa.admin.leave.dao.LeaveTypeDao;
import org.fkjava.oa.core.dao.impl.HibernateDaoImpl;
import org.springframework.stereotype.Repository;

@Repository("leaveTypeDao")
public class LeaveTypeDaoImpl extends HibernateDaoImpl implements LeaveTypeDao {

}
