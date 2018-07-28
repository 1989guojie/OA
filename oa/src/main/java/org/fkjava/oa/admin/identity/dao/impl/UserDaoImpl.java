package org.fkjava.oa.admin.identity.dao.impl;

import org.fkjava.oa.admin.identity.dao.UserDao;
import org.fkjava.oa.core.dao.impl.HibernateDaoImpl;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends HibernateDaoImpl implements UserDao {

}
