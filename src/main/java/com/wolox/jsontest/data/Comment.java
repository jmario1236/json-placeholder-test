package com.wolox.jsontest.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2583595682453917971L;
	
	private Integer id;
	private String name;
	private String email;
	private String body;
	private Integer postId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Comment) {
			Comment comment = (Comment) obj;
			return comment.getBody().equals(this.getBody()) &&
					comment.getEmail().equals(this.getEmail()) &&
					comment.getId().equals(this.getId()) &&
					comment.getName().equals(this.getName()) &&
					comment.getPostId().equals(this.getPostId());
		}
		return false;
	}
	
	@Override
	public int hashCode() {		
		return Objects.hashCode(this.getBody(), this.getEmail(), this.getId(), this.getName(), this.getPostId());
	}
	
}
