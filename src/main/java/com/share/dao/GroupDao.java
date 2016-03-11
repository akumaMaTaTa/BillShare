/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.share.dao;

import com.share.entity.Bill;
import com.share.entity.Group;
import java.util.List;

/**
 *
 * @author gao
 */
public interface GroupDao {
    public void save(Group group);
    public void delete(Group group);
    public Group findById(long id);
    public Group findByName(String name);
    
}
