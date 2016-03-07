/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.share.dao;

import com.share.entity.User;

/**
 *
 * @author gao
 */
public interface UserDao {
    User findById(long id);
    User findByName(String name);
    void save(User user);
    void deleteU(User user);
    
}
