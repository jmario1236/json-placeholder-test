package com.wolox.jsontest.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.wolox.jsontest.controller.cons.MappingConstants;
import com.wolox.jsontest.data.Album;
import com.wolox.jsontest.exception.JsonTestException;


@Service
public class AlbumService {
	@Autowired
	private ProviderService provideService;
	
	public List<Album> getAll(){
		Album[] albumes = provideService.setPath(MappingConstants.ALBUMS).get(Album[].class);
		return Arrays.asList(albumes);
	}
	
	public Album getByID(Integer id) {
		Album album = null;
		try {
			String path = String.format(MappingConstants.ALBUMS.concat(MappingConstants.ID_ENDPOINT), id);
			album = provideService.setPath(path).get(Album.class);
		}catch(RestClientException ex) {
			throw new JsonTestException(JsonTestException.ALBUM_NO_EXISTE);
		}		
		return album;
	}
}
