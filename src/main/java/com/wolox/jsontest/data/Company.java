package com.wolox.jsontest.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {

	private String name;
	private String catchPhrase;
	private String bs;
	

	public String getCatchPhrase() {
		return catchPhrase;
	}
	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}
	public String getBs() {
		return bs;
	}
	public void setBs(String bs) {
		this.bs = bs;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
