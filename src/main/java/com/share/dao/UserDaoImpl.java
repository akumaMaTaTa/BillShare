/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.share.dao;

import com.share.entity.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gao
 */
@Repository
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findById(long id) {
        User user = getByKey(id);
        return user;

    }

    @Override
    public User findByName(String name) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("userName", name));
        User user = (User) crit.uniqueResult();
        return user;

    }

    @Override
    public void save(User user) {
        persist(user);
    }
    @Override
    public void deleteU(User user) {
        delete(user);
    }

}
