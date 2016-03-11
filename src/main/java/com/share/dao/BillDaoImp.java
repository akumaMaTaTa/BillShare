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
public class BillDaoImp implements BillDao{
    SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

    @Override
    public void save(Bill bill) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        session.saveOrUpdate(bill);
        tran.commit();
        
    }

    @Override
    public void delete(Bill bill) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        session.delete(bill);
        tran.commit();
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
