package com.wolox.jsontest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.jsontest.controller.cons.MappingConstants;
import com.wolox.jsontest.data.Album;
import com.wolox.jsontest.data.Permission;
import com.wolox.jsontest.data.User;
import com.wolox.jsontest.exception.JsonTestException;
import com.wolox.jsontest.service.AlbumService;
import com.wolox.jsontest.service.PermissionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(MappingConstants.ALBUMES)
@Api(value = "REST API para la informacion de los albumes")
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private PermissionService permissionService;
	
	@ApiOperation(value = "Listar Albumes", notes = "Retorna una lista de todos los Albumes" )
	@GetMapping(MappingConstants.LISTAR)
	public List<Album> listar(){		
		return albumService.getAll();		
	}
	
	@ApiOperation(value = "Consultar album", notes = "Retorna una album con el id especificado" )
	@GetMapping(MappingConstants.CONSULTAR)
	public Album consultar(@PathVariable(MappingConstants.ID) Integer id) {
		return albumService.getByID(id);
	}
	
	@ApiOperation(value = "Compartir un album", notes = "Retorna una album con el id especificado" )
	@PostMapping(MappingConstants.ALBUMES_COMPARTIR)
	public Permission compartirAlbum(@PathVariable(MappingConstants.ID) Integer id, @RequestBody(required = true) Permission permission) {
		permission.setIdAlbum(id);
		Permission save = null;
		try {
			save = permissionService.save(permission);	
		}catch(JsonTestException e) {
			throw e.getExceptionController();
		}			
		return save;
	}
	
	@ApiOperation(value = "Modifica un album compartido", notes = "Retorna una album con el id especificado" )
	@PutMapping(MappingConstants.ALBUMES_COMPARTIR)
	public Permission ModificarAlbumCompartido(@PathVariable(MappingConstants.ID) Integer id, @RequestBody(required = true) Permission permission) {
		permission.setIdAlbum(id);
		Permission save = null;
		try {
			save = permissionService.update(permission);	
		}catch(JsonTestException e) {
			throw e.getExceptionController();
		}			
		return save;
	}
	
	@ApiOperation(value = "Obtiene los usuarios de un album compartido respecto a sus permisos", notes = "Retorna una album con el id especificado" )
	@GetMapping(MappingConstants.ALBUMES_COMPARTIR)
	public List<User> obtenerUsuarioAlbumCompartido(@PathVariable(MappingConstants.ID) Integer id, Permission permission) {
		permission.setIdAlbum(id);
		List<User> users = null;
		try {
			users = permissionService.getUserFromAlbum(permission);	
		}catch(JsonTestException e) {
			throw e.getExceptionController();
		}			
		return users;
	}
}
