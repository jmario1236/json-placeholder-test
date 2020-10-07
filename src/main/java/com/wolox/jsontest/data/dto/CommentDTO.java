package com.wolox.jsontest.data.dto;

import java.io.Serializable;

public class CommentDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6053385107809629675L;
	
	private String name;
	private Integer idUser;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	
}
