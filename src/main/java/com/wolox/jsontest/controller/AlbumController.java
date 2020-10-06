package com.wolox.jsontest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.jsontest.controller.cons.MappingConstants;
import com.wolox.jsontest.data.Album;
import com.wolox.jsontest.service.AlbumService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(MappingConstants.ALBUMES)
@Api(value = "REST API para la informacion de los albumes")
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;
	
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
}
