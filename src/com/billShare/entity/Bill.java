package com.billShare.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BILL")
public class Bill {
	@Id@GeneratedValue
	private long id;
	private String name;
	private String description;
	private int amount=0;
	private long whoPaidId;
	@ManyToOne(cascade = CascadeType.ALL)
	private Group group;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public long getWhoPaidId() {
		return whoPaidId;
	}
	public void setWhoPaidId(long whoPaidId) {
		this.whoPaidId = whoPaidId;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
}
