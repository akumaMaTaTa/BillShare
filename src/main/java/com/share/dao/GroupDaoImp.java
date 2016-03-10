/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.share.dao;

import com.share.entity.Bill;
import com.share.entity.Group;
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
public class GroupDaoImp implements GroupDao {
    SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
    

    @Override
    public void save(Group group) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        session.saveOrUpdate(group);
        tran.commit();
        
    }

    @Override
    public void delete(Group group) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        session.delete(group);
        tran.commit();
    }

    @Override
    public Group findById(long id) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        Group group=session.get(Group.class, id);
        return group;

    }
        

    @Override
    public Group findByName(String name) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        Criteria criteria=session.createCriteria(Group.class);
        criteria.add(Restrictions.eq("name", name));
        Group group=(Group)criteria.uniqueResult();
        return group;
        
        
    }
    @Override
    public List<Bill> listOpenBill(Group group){
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        Criteria criteria=session.createCriteria(Bill.class);
        criteria.add(Restrictions.eq("settled", false));
        List<Bill> opens=criteria.list();
        return opens;
    }
       
    
}
