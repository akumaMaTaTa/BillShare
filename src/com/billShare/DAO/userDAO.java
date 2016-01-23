/*DAO file--User.java<->table USER
 * functions:
 * 			Empty constructor;
 * 			newUser()--	add new user 
 * 			deleteUser(long id) -- delete a user by id
 * 			updateUser(long userId, String newName, String newEmail, String newPsw) -- update a user's profile
 * 			readOne(String name) -- read a user's profile by username, return a filed user object
 * 			readAll() -- read all users , return a list of user objects
 * 			authenticate(String uName, String psw) -- user authentication, return user object if success, return null if fail
 * 			addToGroup(long groupId, User user)--add a user to a group
 * TODU: 
 * 		#main() is used for test, delete after finish
 		#username and email need to be unique(capture exception)
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

public class userDAO {
	private SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();;
	public userDAO(){}
	//return : the user id if success, -1 if fail 
	public int newUser(String name, String email, String psw)
	{
		Session session = sessionFactory.openSession();
		User user=new User();
		user.setUserName(name);
		user.setEmail(email);
		user.setPassword(psw);
		session.beginTransaction();
		try{
		session.save(user);
		}catch(JDBCException e){
			return -1;
		}
		session.getTransaction().commit();
		session.close();
		return (int)user.getUserId();
		
	}
	//return: 0 if success , -1 if fail
	public int deleteUser(long id)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String query="delete from User where id= :userId";
		Query q=session.createQuery(query).setParameter("userId", id);
		try{
		q.executeUpdate();
		}catch(JDBCException e){
			return -1;
		}
		session.getTransaction().commit();
		session.close();
		return 0;
	}
	//return: 0 if success, -1 if fail
	public int updateUser(long userId,String newName, String newPsw)
	{
		Session session =sessionFactory.openSession();
		session.beginTransaction();
		String query="update User set userName=:name, password=:psw where id=:uId ";
		Query q=session.createQuery(query).setParameter("name", newName).setParameter("psw", newPsw).setParameter("psw",newPsw).setParameter("uId", userId);
		try{
		q.executeUpdate();
		}catch (JDBCException e){
			return -1;
		}
		session.getTransaction().commit();
		session.close();
		return 0;
	}
	//return: A filled User object, null if fail
	public User readOne(long id)
	{
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		User user = new User();
		//String query="from USER where userName=:uName";
		//Query q=session.createQuery(query).setParameter("uName", name);
		try{
			user = session.get(User.class,id);
		}catch(JDBCException e){
			return null;
		}
		session.getTransaction().commit();
		session.close();
		return user;
		
	}
	//return: A filled User object, null if fail
	public User authenticate(String uName, String psw)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String query = "from User where userName =:name and password=:password ";
		Query q= session.createQuery(query).setParameter("name", uName).setParameter("password", psw);
		if(q.list().isEmpty())
			return null;
		else
		{
			User user=(User)q.list().get(0);
			return user;
		}
		
	}
	//return: A list of all user
	public List<User> readAll()
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<User> users = session.createQuery("from User").list();
		session.getTransaction().commit();
		session.close();
		return users;
	}
	
	public void addToGroup(long groupId, User user)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		groupDAO d = new groupDAO();
		user.getGroups().add(d.readOne(groupId));
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}
	public static void main(String arg[])
	{
		userDAO d=new userDAO();
		d.newUser("dsdsgg", "kdj@jsdgask", "abwrwc");
		d.authenticate("aaaaa", "12345");
		
		
	}

}
