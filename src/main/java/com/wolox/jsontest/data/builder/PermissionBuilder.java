package com.wolox.jsontest.data.builder;

import com.wolox.jsontest.data.Permission;
import com.wolox.jsontest.data.entity.PermissionEntity;

public class PermissionBuilder {
	public static Permission convertirADominio(PermissionEntity entity) {
		Permission value = new Permission();
		value.setWrite(entity.getWrite());
		value.setLastUpdate(entity.getLastUpdate());
		value.setId(entity.getId());
		value.setIdAlbum(entity.getIdAlbum());
		value.setIdUser(entity.getIdUser());
		value.setRead(entity.getRead());
		return value;
	}
	
	public static PermissionEntity convertirAEntity(Permission permiso) {
		PermissionEntity entity = new PermissionEntity();		
		entity.setWrite(permiso.getWrite());
		entity.setLastUpdate(permiso.getLastUpdate());
		entity.setId(permiso.getId());
		entity.setIdAlbum(permiso.getIdAlbum());
		entity.setIdUser(permiso.getIdUser());
		entity.setRead(permiso.getRead());
		return entity;
	}
}
