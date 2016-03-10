
package com.share.dao;

//import org.hibernate.cfg.AnnotationConfiguration;
import com.share.entity.Group;
import com.share.entity.PersonDue;
import com.share.entity.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author gao
 */
@Repository
public class userDaoImp implements UserDao {

    private  SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();


    @Override
    public void save(User user) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        session.saveOrUpdate(user);
        tran.commit();
        
    }

    @Override
    public void delete(User user) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        session.delete(user);
        tran.commit();
    }

    @Override
    public User findById(long id) {
        Session session=sessionFactory.getCurrentSession();
        Transaction tran=session.beginTransaction();
        User user=session.get(User.class, id);
        
        return user;
    }           

    @Override
    public User findByName(String name) {
        Session session=sessionFactory.getCurrentSession();
        Transaction trans=session.beginTransaction();
        Criteria criteria=session.createCriteria(User.class);
        criteria.add(Restrictions.eq("userName", name));
        User user=(User)criteria.uniqueResult();
        
        return user;
    }
    
    @Override
    public void addToGroup(User user,Group group){
        Session session=sessionFactory.getCurrentSession();
        Transaction trans=session.beginTransaction();
        user.getGroups().add(group);
        session.update(user);
        trans.commit();
        
        
        
    }
    
    @Override
     public List<PersonDue> ListOpenDue(User user){
        Session session=sessionFactory.getCurrentSession();
        Transaction trans=session.beginTransaction();
        Criteria criteria=session.createCriteria(PersonDue.class);
        criteria.add(Restrictions.eq("settled", false));
        List<PersonDue> opens=criteria.list();
        return opens;
    }
}
