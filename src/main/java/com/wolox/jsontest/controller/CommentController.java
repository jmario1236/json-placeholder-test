package com.wolox.jsontest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolox.jsontest.controller.cons.MappingConstants;
import com.wolox.jsontest.data.Comment;
import com.wolox.jsontest.data.dto.CommentDTO;
import com.wolox.jsontest.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(MappingConstants.COMENTARIOS)
@Api(value = "REST API para la informacion de los comentarios")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	

	@ApiOperation(value = "Listar Comentarios", notes = "Retorna una lista de todos los comentarios segun el criterio de busqueda" )
	@GetMapping(MappingConstants.LISTAR)
	public List<Comment> listar(CommentDTO comment){		
		return commentService.get(comment);		
	}
}
