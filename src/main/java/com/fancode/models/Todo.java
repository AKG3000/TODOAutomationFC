package com.fancode.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*
 * NOTE : This Model is developed for the current requirement
 * 		  so necessary properties are used for the Todo POJO
 * */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Todo {
	private int userId;
	private int id;
	private boolean completed;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
}
