package com.infy.ems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int addressId;
	
	private String houseNumber;
	private String streetName;
	private String city;
	private int pin;
	
	public Address() {
		
	}
	public Address(String houseNumber, String streetName, String city, int pin) {
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.city = city;
		this.pin = pin;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	

}
