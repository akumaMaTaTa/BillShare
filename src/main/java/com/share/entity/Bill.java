/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.share.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author gao
 * Bill(int amount, Group group)
 *      About amount: + --> the amount need to pay - --> the amount need to be paid
 * bollean checkDueSum()
 *      check if the amount is right
 *
 */
@Entity
@Table(name="BILL")
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name="AMOUNT",nullable=false) 
    private int amount;
    @Column(name="SETTLED",nullable=false)
    private boolean settled=false;
    @ManyToOne
    @JoinColumn(name="GROUP_ID",nullable=false)
    private Group group;
    @OneToMany(mappedBy="bill")
    private Set<PersonDue> personalDue;
    private Date date = new Date();
    private String note;
    
    public Bill(int amount,Group group){
        this.amount=amount;
        this.group=group;
    }
    
    public boolean checkDueSum(){
        int sum=0;
        for(PersonDue p : this.personalDue){
            sum+=p.getAmount();
        }
        if(sum==0)
            return true;
        else
            return false;
        
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.share.entity.BIll[ id=" + id + " ]";
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return the settled
     */
    public boolean isSettled() {
        return settled;
    }

    /**
     * @param settled the settled to set
     */
    public void setSettled(boolean settled) {
        this.settled = settled;
    }

    /**
     * @return the group
     */
    public Group getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * @return the personalDue
     */
    public Set<PersonDue> getPersonalDue() {
        return personalDue;
    }

    /**
     * @param personalDue the personalDue to set
     */
    public void setPersonalDue(Set<PersonDue> personalDue) {
        this.personalDue = personalDue;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
}
