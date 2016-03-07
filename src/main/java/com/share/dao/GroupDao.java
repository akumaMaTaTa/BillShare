/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.share.dao;

import com.share.entity.Group;

/**
 *
 * @author gao
 */
public interface GroupDao {
    Group findById(long id);
    Group save(Group group);
    Group delete(long id);
}
