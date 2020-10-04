package com.wolox.jsontest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wolox.jsontest.data.Photo;

@SpringBootTest
public class PhotoServiceTest {
	private final int DATA_SIZE = 5000;
	private final int ID_PHOTO = 4;
	private final int PHOTOS_ALBUM_SIZE = 50;
	private final int ALBUM_ID = 1;
	private final String TITLE = "culpa odio esse rerum omnis laboriosam voluptate repudiandae";
	private final String URL = "https://via.placeholder.com/600/d32776";
	
	@Autowired
	private PhotoService photoService;
	
	/*
	 * El servicio expuesto entrega 5000 registro de fotos
	 * por lo tanto se valida con el size de la lista sea igual a 5000
	 * */
	@Test
	public void listarFotos() {		
		List<Photo> photos = photoService.getAll(null);
		assertEquals(DATA_SIZE, photos.size());
	}	
	
	/*
	 * Prueba para buscar foto a partir de la id
	 * */
	@Test
	public void consultarFotoPorID() {			
		Photo photo = photoService.getByID(ID_PHOTO);		
		assertEquals(TITLE, photo.getTitle());
		assertEquals(URL, photo.getUrl());
	}
	
	/*
	 * Prueba para buscar a partir del id del album las fotos 
	 * El servicio expone 50 fotos por album
	 * */
	@Test
	public void consultarFotoPorAlbumID() {	
		Photo filter = new Photo();
		filter.setAlbumId(ALBUM_ID);
		List<Photo> photos = photoService.getAll(filter);			
		assertEquals(PHOTOS_ALBUM_SIZE, photos.size());		
	}
	
}
