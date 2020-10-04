package com.wolox.jsontest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wolox.jsontest.data.Album;



@SpringBootTest
public class AlbumServiceTest {
	
	private final int DATA_SIZE = 100;
	private final int ID_ALBUM = 2;
	private final String TITLE = "sunt qui excepturi placeat culpa";

	@Autowired
	private AlbumService AlbumService;
	
	/*
	 * El servicio expuesto entrega 100 registro de albumes
	 * por lo tanto se valida con el size de la lista sea igual a 100
	 * */
	@Test
	public void listarAlbumes() {		
		List<Album> photos = AlbumService.getAll();
		assertEquals(DATA_SIZE, photos.size());
	}	
	
	/*
	 * Prueba para buscar album a partir de la id
	 * */
	@Test
	public void consultarAlbumPorID() {			
		Album album = AlbumService.getByID(ID_ALBUM);		
		assertEquals(TITLE, album.getTitle());		
	}
	
}
