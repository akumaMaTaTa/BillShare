/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.share.dao;

import com.share.entity.Group;
import com.share.entity.PersonDue;
import com.share.entity.User;
import java.util.List;

/**
 *
 * @author gao
 */
public interface UserDao {

    /**
     *
     * @param user
     */
    public void save(User user);
    public void delete(User user);
    public User findById(long id);
    public User findByName(String name);
    public void addToGroup(User user,Group group);
    public List<PersonDue> ListOpenDue(User user);
    
    
    
}
