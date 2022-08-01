package com.bashayer.events.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
@Table(name="users")
public class User {
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 @NotEmpty(message="First Name is required!")
 @Size(min=3, max=30, message="First Name must be between 3 and 30 characters")
 private String firstName;
 
 @NotEmpty(message="Last Name is required!")
 @Size(min=3, max=30, message="last Name must be between 3 and 30 characters")
 private String lastName;
 
 @NotEmpty(message="Email is required!")
 @Email(message="Please enter a valid email!")
 private String email;
 
 @NotEmpty(message="Password is required!")
 @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
 private String password;
 
 @NotEmpty(message="location is required!")
 private String location;
 
 @NotEmpty(message="state is required!")
 private String state;
 
 
 @Transient
 @NotEmpty(message="Confirm Password is required!")
 @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
 private String confirmPW;
 
 @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Comment> comments;
 
 @ManyToMany(fetch = FetchType.LAZY)
 @JoinTable(
     name = "users_events", 
     joinColumns = @JoinColumn(name = "user_id"), 
     inverseJoinColumns = @JoinColumn(name = "event_id")
 )
 private List<Event> events;
 
 
 public User() {}

 
 // getters and setters


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPW() {
		return confirmPW;
	}

	public void setConfirmPW(String confirmPW) {
		this.confirmPW = confirmPW;
	}

	public Long getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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


	public List<Event> getEvents() {
		return events;
	}


	public void setEvents(Event events) {
		this.events.add(events);
	}
	
	

}
 