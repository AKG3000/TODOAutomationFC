package com.fancode.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*
 * NOTE : This Model is developed for the current requirement
 * 		  so necessary properties are used for the Users POJO
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLocation {
	private int id;
	private Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Id : " + this.id + " ,Address : " + this.address.toString();
	}
}
