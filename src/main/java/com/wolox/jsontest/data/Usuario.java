package com.wolox.jsontest.data;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario {
	
	private Integer id;
	private String username;
	@JsonAlias("email")
	private String correo;
	@JsonAlias("address")
	private Direccion direccion;
	@JsonAlias("phone")
	private String telefono;
	@JsonAlias("website")
	private String website;
	@JsonAlias("company")
	private Compania compania;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public Compania getCompania() {
		return compania;
	}
	public void setCompania(Compania compania) {
		this.compania = compania;
	}
	

}
