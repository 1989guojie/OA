package org.fkjava.oa.admin.leave.dao.impl;

import org.fkjava.oa.admin.leave.dao.LeaveAuditDao;
import org.fkjava.oa.core.dao.impl.HibernateDaoImpl;
import org.springframework.stereotype.Repository;

@Repository("leaveAuditDao")
public class LeaveAuditDaoImpl extends HibernateDaoImpl implements LeaveAuditDao {

}
