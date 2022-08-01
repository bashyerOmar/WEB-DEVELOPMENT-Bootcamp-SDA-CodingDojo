package com.bashayer.events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @NotEmpty(message="Name is required!")
	 @Size(min=3, max=30, message="Name must be between 3 and 30 characters")
	 private String name;
	 
	 
	 @NotNull(message="Date is required!")
	 @Future(message="Date must be in the future")
     @DateTimeFormat(pattern = "yyyy-MM-dd") 
	 private Date date;
	 
	 
	 @NotEmpty(message="location is required!")
	 private String location;
	 
	 @NotEmpty(message="state is required!")
	 private String state;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "user_id")
	 private User Host;
	 
	 @OneToMany(mappedBy="event", fetch = FetchType.LAZY)
		private List<Comment> comments;
	 
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
	     name = "users_events", 
	     joinColumns = @JoinColumn(name = "event_id"), 
	     inverseJoinColumns = @JoinColumn(name = "user_id")
	 )
	 private List<User> users;
	 
	 
    //getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Comment> getComments() {
		return comments;
	}

	

	public Date getDate()  {
//		String date1 = new SimpleDateFormat("dd MMMM yyyy").format(this.date);
//		Date date11 = new SimpleDateFormat("dd MMMM yyyy").parse(date1);
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(User user) {
		this.users.add(user);
	}

	public Long getId() {
		return id;
	}

	public User getHost() {
		return Host;
	}

	public void setHost(User host) {
		Host = host;
	}

	
	
	
	
	 
	 
}
