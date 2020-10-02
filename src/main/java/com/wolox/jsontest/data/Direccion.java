package com.wolox.jsontest.data;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Direccion {
	@JsonAlias("street")
	private String calle;
	@JsonAlias("suite")
	private String departamento;
	@JsonAlias("city")
	private String ciudad;
	@JsonAlias("zipcode")
	private String codigoPostal;
	private Geoposicion geo;
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public Geoposicion getGeo() {
		return geo;
	}
	public void setGeo(Geoposicion geo) {
		this.geo = geo;
	}
}
