package com.wolox.jsontest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolox.jsontest.controller.cons.MappingConstants;
import com.wolox.jsontest.data.Comment;
import com.wolox.jsontest.data.Post;
import com.wolox.jsontest.data.dto.CommentDTO;

@Service
public class CommentService {

	@Autowired
	private ProviderService provideService;
	
	public List<Comment> get(CommentDTO commentDTO) {
		Comment[] commentsUser = new Comment[0];
		Comment[] comments = new Comment[0];
		if(commentDTO.getIdUser() != null) {
			commentsUser = getCommentsFromUser(commentDTO.getIdUser());
		}
		if(commentDTO.getName() != null) {
			comments = provideService.setPath(MappingConstants.COMMENTS).get(Comment[].class);
			List<Comment> result = new ArrayList<>();
			for(Comment comment : comments) {
				if(comment.getName().contains(commentDTO.getName().toLowerCase())) {
					result.add(comment);
				}
			}
			comments = new Comment[result.size()];
			comments = result.toArray(comments);
		}
		Set<Comment> resultadoUnion = new LinkedHashSet<Comment>();
		resultadoUnion.addAll(Arrays.asList(commentsUser));
		resultadoUnion.addAll(Arrays.asList(comments));	
		comments = new Comment[resultadoUnion.size()];
		return Arrays.asList(resultadoUnion.toArray(comments));
	}
	
	private Comment[] getCommentsFromUser(Integer idUser) {
		Post postFilter = new Post();
		List<Comment> comments = new ArrayList<Comment>();
		postFilter.setUserId(idUser);
		Post[] posts = provideService.setPath(MappingConstants.POSTS).setQueryParams(postFilter).get(Post[].class);
		for(Post post: posts) {
			String path = String.format(MappingConstants.POSTS.concat(MappingConstants.ID_ENDPOINT), post.getId());
			Comment[] commentsPost = provideService.setPath(path).setPath(MappingConstants.COMMENTS).get(Comment[].class);
			comments.addAll(Arrays.asList(commentsPost));
		}
		Comment[] commentsAll = new Comment[comments.size()];
		return comments.toArray(commentsAll);
	}

}
