package com.wolox.jsontest.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wolox.jsontest.controller.cons.MappingConstants;
import com.wolox.jsontest.data.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private RestTemplate template;
	
	public List<Usuario> listarUsuarios(){		
		Usuario[] usuarios = template.getForObject(MappingConstants.USERS, Usuario[].class);
		return Arrays.asList(usuarios);
	}
	
	public Usuario consultarUsuario(Integer id) {
		String url = String.format(MappingConstants.USERS.concat(MappingConstants.ID_ENDPOINT), id);
		Usuario usuario = template.getForObject(url, Usuario.class);
		return usuario;
	}
	
}
