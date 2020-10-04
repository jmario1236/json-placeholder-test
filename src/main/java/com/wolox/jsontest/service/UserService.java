package com.wolox.jsontest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolox.jsontest.controller.cons.MappingConstants;
import com.wolox.jsontest.controller.filters.UserFilter;
import com.wolox.jsontest.data.Album;
import com.wolox.jsontest.data.Photo;
import com.wolox.jsontest.data.User;

@Service
public class UserService {
	
	@Autowired
	private ProviderService provideService;
	
	@Autowired
	private PhotoService photoService;
	
	public List<User> getAll(UserFilter userFilter){	
		User[] user = provideService.setPath(MappingConstants.USERS).setQueryParams(userFilter)
						.get(User[].class);		
		return Arrays.asList(user);
	}
	
	public User getByID(Integer id) {
		String path = String.format(MappingConstants.USERS.concat(MappingConstants.ID_ENDPOINT), id);
		User user = provideService.setPath(path).get(User.class);		
		return user;
	}
	
	public List<Album> getAlbumsByUserID(Integer id){
		String path = String.format(MappingConstants.USERS.concat(MappingConstants.ID_ENDPOINT), id);
		Album[] albums = provideService.setPath(path).setPath(MappingConstants.ALBUMS)
				.get(Album[].class);	
		return Arrays.asList(albums);
	}

	public List<Photo> getPhotosByUserID(Integer id) {
		List<Photo> photos = new ArrayList<>();
		List<Album> albums = this.getAlbumsByUserID(id);
		for(Album album : albums) {
			Photo photo = new Photo();
			photo.setAlbumId(album.getId());
			photos.addAll(photoService.getAll(photo));
		}
		return photos;
	}
	
}
