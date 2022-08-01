package com.bashayer.events.services;

import org.springframework.stereotype.Service;

import com.bashayer.events.models.Comment;
import com.bashayer.events.repositores.CommentRepo;

@Service
public class CommentService {

	final CommentRepo commentRepo;
	public CommentService (CommentRepo commentRepo) {
		this.commentRepo = commentRepo;
	}
	
	
	public Comment createCmnt(Comment comment ) {
		  
		return commentRepo.save(comment);
	}
}
