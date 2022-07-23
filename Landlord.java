package com.cg.ofr.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="landlord")

public class Landlord{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Integer landlordId;
	
	@Column
	@NotEmpty(message = "Landlord name is required")
	private String landlordName;
	
	@Column
	//@NotBlank
	private int landlordAge;
	

	 //cascade=CascadeType.ALL,
	  
	  @OneToMany
	  @JoinTable(name="landlordFlat")
	  private List<Flat> flatList;
	 
	
	@OneToOne
	private User user;
	
	public Landlord() {}

	public Landlord( String landlordName,int landlordAge, List<Flat> flatList, User user) {
		super();
		//this.landlordId = landlordId;
		this.landlordName = landlordName;
		this.landlordAge = landlordAge;
		this.flatList = flatList;
		this.user = user;
	}

	public Integer getLandlordId() {
		return landlordId;
	}

	

	public String getLandlordName() {
		return landlordName;
	}

	public void setLandlordName(String landlordName) {
		this.landlordName = landlordName;
	}

	public int getLandlordAge() {
		return landlordAge;
	}

	public void setLandlordAge(int landlordAge) {
		this.landlordAge = landlordAge;
	}

	public List<Flat> getFlatList() {
		return flatList;
	}

	public void setFlatList(List<Flat> flatList) {
		this.flatList = flatList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Landlord [landlordId=" + landlordId + ", landlordName=" + landlordName + ", landlordAge=" + landlordAge
				+ ", flatList=" + flatList + ", user=" + user + "]";
	}

	
	
}