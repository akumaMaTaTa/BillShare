/*DAO file -- Group.java<-> Table GROUP
 * 		addGroup(String name, String des) -- add a new group
 * 		deleteGroup(long id) -- remove a group
 * 		updateGroup(long id, String newName, String newDescription)-- edit a group(name/description)
 * 		readOne(long id) -- load a group's detail
 * TODU:
 * 	#Change to be catched exception
 * */
package com.billShare.DAO;

import java.util.List;

import org.hibernate.JDBCException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.billShare.entity.Group;
import com.billShare.entity.User;

public class groupDAO {
	private SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();;
	public groupDAO(){}
	
	//return: group id if success, -1 if fail
	public int addGroup(String name, String des)
	{
		Session session = sessionFactory.openSession();
		Group group = new Group();
		group.setName(name);
		group.setDescription(des);
		session.beginTransaction();
		try{
		session.save(group);
		}catch(JDBCException e){
			return -1;
		}
		session.getTransaction().commit();
		session.close();
		return (int)group.getId();
	}
	
	//return : 0 if success, -1 if fail
	public int deleteGroup(long id)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String query="delete from Group where id= :groupId";
		Query q=session.createQuery(query).setParameter("groupId", id);
		try{
		q.executeUpdate();
		}catch(JDBCException e){
			return -1;
		}
		session.getTransaction().commit();
		session.close();
		return 0;
		
	}
	
	//return: 0  if success, -1 if fail
	public int updateGroup(long id, String newName, String newDescription)
	{
		Session session = sessionFactory.openSession();
		Group group = new Group(newName,newDescription);
		group.setId(id);
		session.beginTransaction();
		try{
			session.update(group);
		}catch(JDBCException e){
			return -1;
		}
		session.getTransaction().commit();
		session.close();
		return 0;
	}
	
	//return: a filled group object if success, null if fail
	public Group readOne(long id)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Group group = new Group();
		try{
			group = session.get(Group.class,id);
		}catch(JDBCException e){
			return null;
		}
		session.getTransaction().commit();
		session.close();
		return group;
		
		
	}
	
	public static void main(String arg[])
	{
		groupDAO d = new groupDAO();
		d.addGroup("hello",null);
		d.updateGroup(4, "hello", "world");
	}


}
