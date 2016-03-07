/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.share.dao;

import com.share.entity.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gao
 */
public class UserDaoImplTest {
    
    public UserDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findById method, of class UserDaoImpl.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        long id = 0L;
        UserDaoImpl instance = new UserDaoImpl();
        User expResult = null;
        User result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByName method, of class UserDaoImpl.
     */
    @Test
    public void testFindByName() {
        System.out.println("findByName");
        String name = "";
        UserDaoImpl instance = new UserDaoImpl();
        User expResult = null;
        User result = instance.findByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class UserDaoImpl.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        User user = null;
        UserDaoImpl instance = new UserDaoImpl();
        instance.save(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteU method, of class UserDaoImpl.
     */
    @Test
    public void testDeleteU() {
        System.out.println("deleteU");
        User user = null;
        UserDaoImpl instance = new UserDaoImpl();
        instance.deleteU(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
