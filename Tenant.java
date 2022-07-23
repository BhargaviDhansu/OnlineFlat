package com.cg.ofr.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
@Entity
public class Tenant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tenant_id;
	
	@Column(name="age")
	private int age;
	
	/*
	 * @OneToMany
	 * 
	 * @JoinTable(name="tenantFlat") private List<Flat> flat;
	 */
	
	
	  @OneToOne(cascade=CascadeType.MERGE)
	  @JoinTable(name="tenant_flat_address")
	  private FlatAddress flataddress;
	 
	@OneToOne
	private User user;
	
	public Tenant() {}

	public Tenant( int age, FlatAddress flataddress, User user) {
		super();
		
		this.age = age;
		this.flataddress = flataddress;
		this.user = user;
	}

	public int getTenant_id() {
		return tenant_id;
	}

	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public FlatAddress getFlataddress() {
		return flataddress;
	}

	public void setFlataddress(FlatAddress flataddress) {
		this.flataddress = flataddress;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Tenant [tenant_id=" + tenant_id + ", age=" + age + ", flataddress=" + flataddress + ", user=" + user
				+ "]";
	}

		
}
