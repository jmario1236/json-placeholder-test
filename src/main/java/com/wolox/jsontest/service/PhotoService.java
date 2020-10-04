package com.wolox.jsontest.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolox.jsontest.controller.cons.MappingConstants;
import com.wolox.jsontest.data.Photo;


@Service
public class PhotoService {
	@Autowired
	private ProviderService provideService;
	
	public List<Photo> getAll(Photo filter){
		Photo[] photos = provideService.setPath(MappingConstants.PHOTOS).setQueryParams(filter)
							.get(Photo[].class);
		return Arrays.asList(photos);
	}
	
	public Photo getByID(Integer id) {
		String path = String.format(MappingConstants.PHOTOS.concat(MappingConstants.ID_ENDPOINT), id);
		Photo photo = provideService.setPath(path).get(Photo.class);
		return photo;
	}
	
}
