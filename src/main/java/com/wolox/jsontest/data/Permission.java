package com.wolox.jsontest.data;

import java.io.Serializable;
import java.sql.Timestamp;

public class Permission  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1015606902717401696L;
	
	private Integer id;
	private Integer idUser;
	private Integer idAlbum;	
	private Boolean read;	
	private Boolean write;
	private Timestamp lastUpdate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getIdAlbum() {
		return idAlbum;
	}
	public void setIdAlbum(Integer idAlbum) {
		this.idAlbum = idAlbum;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public Boolean getRead() {
		return read;
	}
	public void setRead(Boolean read) {
		this.read = read;
	}
	public Boolean getWrite() {
		return write;
	}
	public void setWrite(Boolean write) {
		this.write = write;
	}
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
}
