package com.bashayer.events.repositores;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bashayer.events.models.Event;

@Repository
public interface EventRepo extends CrudRepository<Event, Long> {
	
	
	    
	    Optional<Event> findById(Long id);
	    List<Event> findByState(String state);
	    List<Event> findAllByStateNot(String state);
	    
	

}
