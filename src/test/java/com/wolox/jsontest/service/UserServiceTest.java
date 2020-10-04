package com.wolox.jsontest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.wolox.jsontest.controller.filters.UserFilter;
import com.wolox.jsontest.data.Album;
import com.wolox.jsontest.data.User;




@SpringBootTest
public class UserServiceTest {
	private final int DATA_SIZE = 10;
	private final int ID_ANTONETTE = 2;
	private final int ALBUMS_SIZE = 10;
	private final String USERNAME = "Antonette";
	private final String NAME = "Ervin Howell";
	
	@Autowired
	private UserService userService;
	
	
	/*
	 * El servicio expuesto entrega 10 usuarios
	 * por lo tanto se valida con el size de la lista sea igual a 10
	 * */
	@Test
	public void listarUsuarios() {		
		List<User> users = userService.getAll(null);
		assertEquals(DATA_SIZE, users.size());
	}
	
	/*
	 * El servicio expuesto se puede filtrar por campos basicos
	 * por lo tanto se valida con el usuario de id 2 de la api
	 * */
	@Test
	public void listarUsuariosFiltro() {		
		UserFilter user = new UserFilter();
		user.setUsername(USERNAME);		
		List<User> users = userService.getAll(user);
		assertEquals(1, users.size());
		assertEquals(ID_ANTONETTE, users.get(0).getId());
		assertEquals(NAME, users.get(0).getName());
	}
	
	/*
	 * Prueba para buscar usuario a partir de la id
	 * */
	@Test
	public void consultarUsuarioPorID() {			
		User user = userService.getByID(ID_ANTONETTE);		
		assertEquals(ID_ANTONETTE, user.getId());
		assertEquals(NAME, user.getName());
	}
	
	/*
	 * Prueba para buscar albumes a partir de un usuario a traves de su id
	 * lista debe retornar 10 albumes por usuario
	 * */
	@Test
	public void listarAlbumesPorUsuario() {			
		List<Album> albums = userService.getAlbumsByUserID(ID_ANTONETTE);		
		assertEquals(ALBUMS_SIZE, albums.size());		
	}
	
	
}
