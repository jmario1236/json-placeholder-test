package com.wolox.jsontest.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolox.jsontest.data.Album;
import com.wolox.jsontest.data.Permission;
import com.wolox.jsontest.data.User;
import com.wolox.jsontest.data.builder.PermissionBuilder;
import com.wolox.jsontest.data.entity.PermissionEntity;
import com.wolox.jsontest.data.repository.PermissionRepository;
import com.wolox.jsontest.exception.JsonTestException;

@Service
public class PermissionService {
	
	@Autowired
	private PermissionRepository repository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AlbumService albumService;

	public Permission save(Permission permission) {
		User user = null;
		Album album = null;
		try {
			user = userService.getByID(permission.getIdUser());
			album = albumService.getByID(permission.getIdAlbum());
		}catch (JsonTestException e) {
			throw e;
		}
		if(album.getUserId().equals(user.getId())) {
			throw new JsonTestException(JsonTestException.USUARIO_NO_VALIDO);
		}
		PermissionEntity entity = repository.findByIdUserAndIdAlbum(user.getId(), album.getId());
		if(entity != null) {
			throw new JsonTestException(JsonTestException.PERMISO_EXISTE);
		}
		permission.setLastUpdate(new Timestamp(new Date().getTime()));
		PermissionEntity savedEntity = repository.save(PermissionBuilder.convertirAEntity(permission));
		return PermissionBuilder.convertirADominio(savedEntity);
	}
	

	public Permission get(Permission permission) {
		Permission value = null;
		value = PermissionBuilder.convertirADominio(repository.findByIdUserAndIdAlbum(permission.getIdUser(), permission.getIdAlbum()));
		return value;
	}

	public Permission update(Permission permission) {
		PermissionEntity entity = repository.findByIdUserAndIdAlbum(permission.getIdUser(), permission.getIdAlbum());
		if(entity == null) {
			throw new JsonTestException(JsonTestException.PERMISO_NO_EXISTE);
		}
		Permission permisoUpdate = PermissionBuilder.convertirADominio(entity);
		permisoUpdate.setWrite(permission.getWrite());
		permisoUpdate.setRead(permission.getRead());
		permisoUpdate.setLastUpdate(new Timestamp(new Date().getTime()));
		permisoUpdate = PermissionBuilder.convertirADominio(repository.save(PermissionBuilder.convertirAEntity(permisoUpdate)));
		return permisoUpdate;
	}


	public List<User> getUserFromAlbum(Permission permission) {
		List<User> usuarios = repository.findByReadAndWriteAndIdAlbum(permission.getRead(),permission.getWrite() , permission.getIdAlbum())
				.stream().map(id -> {
					User user = userService.getByID(id);
					return user;
				}).collect(Collectors.toList());
		return usuarios;
	}

}
