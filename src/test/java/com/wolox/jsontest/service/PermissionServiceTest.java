package com.wolox.jsontest.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wolox.jsontest.data.Permission;
import com.wolox.jsontest.data.User;
import com.wolox.jsontest.exception.JsonTestException;

@SpringBootTest
public class PermissionServiceTest {

	@Autowired
	private PermissionService permisosService;
	
	@Test
	public void registrarAlbumCompartido() {
		Permission permiso = new Permission();		
		permiso.setWrite(true);
		permiso.setRead(false);
		permiso.setIdAlbum(1);
		permiso.setIdUser(2);		
		permiso = permisosService.save(permiso);
		
		Permission permisoConsulta = new Permission();	
		permisoConsulta.setIdUser(permiso.getIdUser());
		permisoConsulta.setIdAlbum(permiso.getIdAlbum());
		permisoConsulta = permisosService.get(permisoConsulta);
		assertEquals(permiso.getWrite(), permisoConsulta.getWrite());
		assertEquals(permiso.getRead(), permisoConsulta.getRead());
		assertEquals(permiso.getLastUpdate(), permisoConsulta.getLastUpdate());		
	}
	
	@Test
	public void modificarAlbumCompartido() {		
		Permission permiso = new Permission();		
		permiso.setWrite(false);
		permiso.setRead(true);
		permiso.setIdAlbum(1);
		permiso.setIdUser(3);		
		permiso = permisosService.save(permiso);
		
		
		permiso = new Permission();		
		permiso.setWrite(true);
		permiso.setRead(true);
		permiso.setIdAlbum(1);
		permiso.setIdUser(3);		
		permiso = permisosService.update(permiso);
		
		Permission permisoConsulta = new Permission();	
		permisoConsulta.setIdUser(permiso.getIdUser());
		permisoConsulta.setIdAlbum(permiso.getIdAlbum());
		permisoConsulta = permisosService.get(permisoConsulta);
		assertEquals(permiso.getWrite(), permisoConsulta.getWrite());
		assertEquals(permiso.getRead(), permisoConsulta.getRead());
		assertEquals(permiso.getLastUpdate(), permisoConsulta.getLastUpdate());		
	}
	
	@Test
	public void obtenerUsuariosPermiso() {
		Permission permiso = new Permission();	
		permiso.setWrite(false);
		permiso.setRead(true);
		permiso.setIdAlbum(1);
		permiso.setIdUser(5);		
		permiso = permisosService.save(permiso);
		
		permiso = new Permission();	
		permiso.setWrite(true);
		permiso.setRead(true);
		permiso.setIdAlbum(1);
		permiso.setIdUser(6);		
		permiso = permisosService.save(permiso);
		
		permiso = new Permission();	
		permiso.setWrite(true);
		permiso.setRead(false);
		permiso.setIdAlbum(1);
		permiso.setIdUser(4);		
		permiso = permisosService.save(permiso);
		
		permiso = new Permission();	
		permiso.setWrite(true);
		permiso.setRead(true);
		permiso.setIdAlbum(2);
		permiso.setIdUser(4);		
		permiso = permisosService.save(permiso);
		
		Permission permisoConsulta = new Permission();
		permisoConsulta.setRead(false);
		permisoConsulta.setIdAlbum(1);
		List<User> usuarios = permisosService.getUserFromAlbum(permisoConsulta);
		assertEquals(1, usuarios.size());
		assertEquals(4, usuarios.get(0).getId());
	}
	
	
	@Test
	public void registrarAlbumCompartidoMismoUsuario() {
		Permission permiso = new Permission();		
		permiso.setWrite(true);
		permiso.setRead(false);
		permiso.setIdAlbum(1);
		permiso.setIdUser(1);
		try {
			permisosService.save(permiso);
		}catch(JsonTestException e) {
			assertEquals(JsonTestException.USUARIO_NO_VALIDO, e.getMessage());
		}
		
	}
}
