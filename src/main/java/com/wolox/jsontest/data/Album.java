package com.wolox.jsontest.data;

import java.io.Serializable;

public class Album implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1205406537130477888L;
	
	private Integer id;
	private String title;
	private Integer userId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
