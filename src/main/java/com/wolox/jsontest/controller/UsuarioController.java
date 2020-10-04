package com.wolox.jsontest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.jsontest.controller.cons.MappingConstants;
import com.wolox.jsontest.controller.filters.UserFilter;
import com.wolox.jsontest.data.User;
import com.wolox.jsontest.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(MappingConstants.USUARIOS)
@Api(value = "Users microservice")
public class UsuarioController {
	
	@Autowired
	private UserService service;

	@ApiOperation(value = "Listar usuarios", notes = "Retorna una lista usuarios" )
	@GetMapping(MappingConstants.LISTAR)
	public List<User> listar(UserFilter userFilter){		
		return service.listarUsuarios(userFilter);		
	}
	
	@ApiOperation(value = "Consultar usuario", notes = "Retorna un usuario con el id especificado" )
	@GetMapping(MappingConstants.CONSULTAR)
	public User consultar(@PathVariable(MappingConstants.ID) Integer id) {
		return service.consultarUsuario(id);
	}
	
	
}
