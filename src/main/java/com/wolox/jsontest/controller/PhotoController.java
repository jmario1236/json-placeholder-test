package com.wolox.jsontest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.jsontest.controller.cons.MappingConstants;
import com.wolox.jsontest.data.Photo;
import com.wolox.jsontest.service.PhotoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(MappingConstants.FOTOS)
@Api(value = "REST API para la informacion de la fotos")
public class PhotoController {

	@Autowired
	private PhotoService photoService;
	
	@ApiOperation(value = "Listar fotos", notes = "Retorna una lista de todas las fotos con posibilidas de filtrar" )
	@GetMapping(MappingConstants.LISTAR)
	public List<Photo> listar(Photo filter){		
		return photoService.getAll(filter);		
	}
	
	@ApiOperation(value = "Consultar fotos", notes = "Retorna una foto con el id especificado" )
	@GetMapping(MappingConstants.CONSULTAR)
	public Photo consultar(@PathVariable(MappingConstants.ID) Integer id) {
		return photoService.getByID(id);
	}
}
