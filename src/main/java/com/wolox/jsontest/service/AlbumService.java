package com.wolox.jsontest.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolox.jsontest.controller.cons.MappingConstants;
import com.wolox.jsontest.data.Album;


@Service
public class AlbumService {
	@Autowired
	private ProviderService provideService;
	
	public List<Album> getAll(){
		Album[] albumes = provideService.setPath(MappingConstants.ALBUMS).get(Album[].class);
		return Arrays.asList(albumes);
	}
	
	public Album getByID(Integer id) {
		String path = String.format(MappingConstants.ALBUMS.concat(MappingConstants.ID_ENDPOINT), id);
		Album album = provideService.setPath(path).get(Album.class);
		return album;
	}
}
