package com.wolox.jsontest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wolox.jsontest.data.Comment;
import com.wolox.jsontest.data.dto.CommentDTO;

@SpringBootTest
public class CommentServiceTest {
	
	@Autowired
	private CommentService service;

	@Test
	public void buscarComentarioPorName() {
		CommentDTO comentario = new CommentDTO();
		comentario.setName("quo vero");
		comentario.setIdUser(1);
		List<Comment> comentarios = service.get(comentario);
		assertEquals(1, comentarios.size());
		assertEquals("Jayne_Kuhic@sydney.com", comentarios.get(0).getEmail());
	}
	
	
	@Test
	public void buscarComentarioPorUsuario() {
		
	}
}
