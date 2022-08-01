package com.bashayer.events.repositores;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bashayer.events.models.Comment;

public interface CommentRepo extends CrudRepository<Comment, Long>  {

	List<Comment> findAll();
	
}
