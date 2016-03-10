/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.share.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author gao
 */
@Entity
@Table( name = "USER")
public class User implements Serializable {
    public User(String name, String email, String psw){
        this.userName=name;
        this.email=email;
        this.password=psw;
        
                
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public User() {
        this.groups = new HashSet<Group>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Column (unique=true, nullable=false)
    private String userName;
    
    
    @Column(nullable=false)
    private  String password;
    @Column (unique=true, nullable=false)
    private String email;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_group",joinColumns = { 
                    @JoinColumn(name = "user_id", nullable = false, updatable = false) }, 
                    inverseJoinColumns = { @JoinColumn(name = "group_id", 
                                    nullable = false, updatable = false) })
    private Set<Group> groups;
    
    @OneToMany(mappedBy="user")
    private Set<PersonDue> dues;

    public Set<Group> getGroups() {
            return groups;
    }

    public void setGroups(Set<Group> groups) {
            this.groups = groups;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hello.share.User[ id=" + id + " ]";
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the dues
     */
    public Set<PersonDue> getDues() {
        return dues;
    }

    /**
     * @param dues the dues to set
     */
    public void setDues(Set<PersonDue> dues) {
        this.dues = dues;
    }
    
}
