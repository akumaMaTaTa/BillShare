/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.share.dao;

import com.share.entity.Bill;
import com.share.entity.PersonDue;
import com.share.entity.User;
import java.util.List;

/**
 *
 * @author gao
 */
public interface PersonDueDao {
    public void save(PersonDue pd);
    public void delete(PersonDue pd);
    public List<PersonDue> listOpenDueForBill(Bill bill);
    public List<PersonDue> listOpenDueForUser(User user);
    
    
    
}
