package com.cg.ofr.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="flat_booking")
public class FlatBooking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int	bookingNo;

	@OneToOne(cascade=CascadeType.MERGE)
	@JoinTable(name="flat_FlatBooking")
	private Flat flat;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinTable(name="tenant_FlatBooking")
	private Tenant tenant;
	
	@Column
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingFromDate;
	
	@Column
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate bookingToDate;
	
	private String location;
	
	
	public FlatBooking() {}


	public FlatBooking(int bookingNo, Flat flat, Tenant tenant, @NotNull LocalDate bookingFromDate,
			@NotNull LocalDate bookingToDate, String location) {
		super();
		this.bookingNo = bookingNo;
		this.flat = flat;
		this.tenant = tenant;
		this.bookingFromDate = bookingFromDate;
		this.bookingToDate = bookingToDate;
		this.location = location;
	}


	public int getBookingNo() {
		return bookingNo;
	}


	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}


	public Flat getFlat() {
		return flat;
	}


	public void setFlat(Flat flat) {
		this.flat = flat;
	}


	public Tenant getTenant() {
		return tenant;
	}


	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}


	public LocalDate getBookingFromDate() {
		return bookingFromDate;
	}


	public void setBookingFromDate(LocalDate bookingFromDate) {
		this.bookingFromDate = bookingFromDate;
	}


	public LocalDate getBookingToDate() {
		return bookingToDate;
	}


	public void setBookingToDate(LocalDate bookingToDate) {
		this.bookingToDate = bookingToDate;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public String toString() {
		return "FlatBooking [bookingNo=" + bookingNo + ", flat=" + flat + ", tenant=" + tenant + ", bookingFromDate="
				+ bookingFromDate + ", bookingToDate=" + bookingToDate + ", location=" + location + "]";
	}
	

}
