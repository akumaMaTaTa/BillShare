/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.share.dao;

import com.share.entity.Bill;

/**
 *
 * @author gao
 */
public interface BillDao {
    public void save(Bill bill);
    public void delete(Bill bill);
    
    
}
