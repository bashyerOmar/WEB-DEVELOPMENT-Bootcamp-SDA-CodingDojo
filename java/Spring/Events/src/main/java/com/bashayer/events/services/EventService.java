package com.bashayer.events.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bashayer.events.models.Event;
import com.bashayer.events.models.User;
import com.bashayer.events.repositores.EventRepo;

@Service
public class EventService {

	
	private EventRepo eventRepo;

	public EventService(EventRepo eventRepo) {
		this.eventRepo = eventRepo;
	}

	
	public List<Event> getEventsByState(String state) {
		return eventRepo.findByState(state);
	}
	
	public Event createEvent(Event newEvent ) {
		  
		return eventRepo.save(newEvent);
	}
	
	public List<Event> eventsFromAnotherStates(String state){
		return eventRepo.findAllByStateNot(state);
	}
	
	
	public Event getEventById(Long id) {
		Optional <Event> event = eventRepo.findById(id);
		if (event.isPresent()) {
			return event.get();
		}else {
			return null;
		}
		
		
	}
	
	public Event joinUserToEvent(User user , Long event_id) {
		 Event event=getEventById(event_id);
		 event.getUsers().add(user); // add relationship between this event and user 
		 return eventRepo.save(event);
	}
	public Event Unjoin(User user , Long event_id) {
		Event event=getEventById(event_id);
		event.getUsers().remove(user); //remove the relationship between this event and user !
		 return eventRepo.save(event);
	}
	
	public Event update(Event event , Long id) {
		 Event eventToUpdate=getEventById(id);
		 eventToUpdate.setName(event.getName());
		 eventToUpdate.setDate(event.getDate());
		 eventToUpdate.setLocation(event.getLocation());
		 eventToUpdate.setState(event.getState());
		 return eventRepo.save(eventToUpdate);
		 
	}
	public void delete (Long id ) {
		eventRepo.deleteById(id);
	}

}


