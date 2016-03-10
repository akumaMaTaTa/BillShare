/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.share.dao;

import com.share.entity.User;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author gao
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class userDaoImpTest {
    
    private User user;
    long id;
    String uName;
    public userDaoImpTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        user = new User("test","test@email","12345");
        long id=15;
        user.setId(id);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSessionFactory method, of class userDaoImp.
     */


    /**
     * Test of save method, of class userDaoImp.
     */

    /**
     * Test of findById method, of class userDaoImp.
     */
    @Test
    public void t3testFindById() {
        System.out.println("findById");
        userDaoImp instance = new userDaoImp();
        //User expResult = null;
        id=15;
        User result = instance.findById(id);
        assertEquals(user, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findByName method, of class userDaoImp.
     */
    @Test
    public void t2testFindByName() {
        System.out.println("findByName");
        String name = user.getUserName();
        userDaoImp instance = new userDaoImp();
        //User expResult = null;
        User result = instance.findByName(name);
        User nu = instance.findByName("a");
        id=result.getId();
        assertEquals(user, result);
        assertEquals(nu,null);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
