/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.share.dao;

import com.share.entity.Bill;
import com.share.entity.PersonDue;
import com.share.entity.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gao
 */
public class PersonDueDaoImp implements PersonDueDao{
    SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

    @Override
    public void save(PersonDue pd) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        session.saveOrUpdate(pd);
        tran.commit();
        
    }

    @Override
    public void delete(PersonDue pd) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        session.delete(pd);
        tran.commit();
    }

    @Override
    public List<PersonDue> listOpenDueForBill(Bill bill) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        Criteria criteria=session.createCriteria(PersonDue.class);
        criteria.add(Restrictions.eq("bill", bill)).add(Restrictions.eq("settled", false));
        List<PersonDue> opens=criteria.list();
        return opens;
    }

    @Override
    public List<PersonDue> listOpenDueForUser(User user) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        Criteria criteria=session.createCriteria(PersonDue.class);
        criteria.add(Restrictions.eq("user",user)).add(Restrictions.eq("settled",false ));
        List<PersonDue> opens=criteria.list();
        return opens;
    }
    
    
}
