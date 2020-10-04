package com.wolox.jsontest.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolox.jsontest.controller.cons.MappingConstants;
import com.wolox.jsontest.controller.filters.UserFilter;
import com.wolox.jsontest.data.User;
import com.wolox.jsontest.service.provider.ProviderService;

@Service
public class UserService {
	
	@Autowired
	private ProviderService provideService;
	
	public List<User> listarUsuarios(UserFilter userFilter){	
		User[] user = provideService.setPath(MappingConstants.USERS).setQueryParams(userFilter)
						.get(User[].class);		
		return Arrays.asList(user);
	}
	
	public User consultarUsuario(Integer id) {
		String path = String.format(MappingConstants.USERS.concat(MappingConstants.ID_ENDPOINT), id);
		User user = provideService.setPath(path).get(User.class);		
		return user;
	}
	
}
