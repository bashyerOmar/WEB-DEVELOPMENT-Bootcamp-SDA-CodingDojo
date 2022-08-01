package com.bashayer.events.controllers;


import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.bashayer.events.models.Comment;
import com.bashayer.events.models.Event;
import com.bashayer.events.models.LoginUser;
import com.bashayer.events.models.User;
import com.bashayer.events.services.CommentService;
import com.bashayer.events.services.EventService;
import com.bashayer.events.services.UserService;


@Controller
public class HomeController {
	
	    @Autowired
	    private HttpSession session;
	    @Autowired
	    private UserService userServ;
	    @Autowired
	    private EventService eventServ;
	    @Autowired
	    private CommentService commentServ;
	    
	    
	    
	    
	    @GetMapping("/")
	    public String index( @ModelAttribute("newUser") User newUser , 
	    		@ModelAttribute("newLogin") LoginUser newLogin) {
	        return "index.jsp";
	    }
	    
	    
	    @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, @ModelAttribute("newLogin") LoginUser newLogin) {
	    	
	        userServ.register(newUser, result); // create new user 
	       
	        if(result.hasErrors()) { // if there is error return to the register form 
	            return "index.jsp";
	        }// no errors 
	        session.setAttribute("user_id", newUser.getId()); // add user id to the session 
	        return "redirect:/events";
	    }
	    
	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model,  @ModelAttribute("newUser") User newUser) {
	    	
	        User user = userServ.login(newLogin, result);
	        
	        if(result.hasErrors()) {
	            return "index.jsp";
	        }
	        session.setAttribute("user_id", user.getId()); // add user id to the session 
	        return "redirect:/events";
	    }
	    
	    
	    @GetMapping("/events")
	    public String Home (Model model , RedirectAttributes redirectAttributes , @ModelAttribute("event") Event event ) {
	    	
	    	if (IsAuth(redirectAttributes)) { //check authentication 
	    		
	    	User current_user = GetCurrentUser();
	    	List<Event> eventsInYourState = eventServ.getEventsByState(current_user.getState());
	    	List<Event> eventsFromAnotherState = eventServ.eventsFromAnotherStates(current_user.getState());
	    	model.addAttribute("user" , current_user);
	    	model.addAttribute("anotherEvents" , eventsFromAnotherState);
	    	model.addAttribute("eventsInState",eventsInYourState);    	
	    	return "events.jsp";
	    	}else {
	    		return "redirect:/";
	    	}
	    }
	    
	    @PostMapping("/events/create")
	    public String CreateEvent(@Valid @ModelAttribute("event") Event event ,  BindingResult result , Model model  ) {
	    	
	    	User current_user = GetCurrentUser();
	    
	    	
	    	if(result.hasErrors()) {
	    		
		    	List<Event> eventsInYourState = eventServ.getEventsByState(current_user.getState());
		    	List<Event> eventsFromAnotherState = eventServ.eventsFromAnotherStates(current_user.getState());
		    	model.addAttribute("user" , current_user);
		    	model.addAttribute("anotherEvents" , eventsFromAnotherState);
		    	model.addAttribute("eventsInState",eventsInYourState);  
	            return "events.jsp";
	        }
		     
	    	event.setHost(current_user);
	        eventServ.createEvent(event);
	        return "redirect:/events";
	    
	  }
	    
	    @GetMapping("/events/{id}")
	    public String ShowEvent(@ModelAttribute("cmnt") Comment cmnt ,  Model model ,
	    		 @PathVariable("id") Long id , RedirectAttributes redirectAttributes){
	    	
	    	if (IsAuth(redirectAttributes)) {
	        model.addAttribute("event",eventServ.getEventById(id));
	        return "show.jsp";
	        
	    	}else {
	    		return "redirect:/";
	    	}
	  }
	    
	    @PostMapping("/comment/create/{id}")
	    public String createComment (@Valid @ModelAttribute("cmnt") Comment cmnt , BindingResult result,
	    		@PathVariable("id") Long event_id  ) {
	    	
	    	Event current_event=eventServ.getEventById(event_id);
	    	User current_user = GetCurrentUser();
	    	
	    	if(result.hasErrors()) {
	            return "show.jsp";
            }
	    	
	    	cmnt.setEvent(current_event);
	    	cmnt.setUser(current_user);
	    	commentServ.createCmnt(cmnt);
	    	return"redirect:/events/"+event_id;
	    	
	    }
	    
	    @GetMapping("/events/{id}/edit")
	    public String editForm ( @ModelAttribute("event") Event event , @PathVariable("id") Long event_id , 
	    		Model model , RedirectAttributes redirectAttributes) {
	    	
	    	if (IsAuth(redirectAttributes)) {
	    	model.addAttribute("event", eventServ.getEventById(event_id));
	    	return "edit.jsp";
	    }else {
	    	return "redirect:/";
	    }
	    }
	    
	    
	    @RequestMapping(value="/events/{id}/update")
	    public String update(@Valid @ModelAttribute("event") Event event ,	BindingResult result ,
	    		@PathVariable("id") Long event_id ) {
	    	if(result.hasErrors()) {
	            return "edit.jsp";
            }
	    	eventServ.update(event , event_id);
	    	return "redirect:/events";
	    }
	    
	    @GetMapping("/join/{id}")
	    public String join(@PathVariable("id") Long event_id  ,  RedirectAttributes redirectAttributes ) {
	    	
	    	if (IsAuth(redirectAttributes)) {
	    	User current_user = GetCurrentUser();
	    	eventServ.joinUserToEvent(current_user , event_id);
	    	
	    	return "redirect:/events";
	    }else {
	    	return "redirect:/";
	    }
	    }
	    
	    @GetMapping("/unjoin/{id}")
	    public String Unjoin(@PathVariable("id") Long event_id , RedirectAttributes redirectAttributes ) {
	    	
	    	if (IsAuth(redirectAttributes)) {
	    	User current_user = GetCurrentUser();
	    	eventServ.Unjoin(current_user , event_id);
	    	
	    	return "redirect:/events";
	    }else {
	    	return "redirect:/";
	    }
	    }
	    
	    @RequestMapping(value="/events/{id}" , method=RequestMethod.DELETE)
	    public String delete(@PathVariable("id") Long event_id , RedirectAttributes redirectAttributes) {
	    	if (IsAuth(redirectAttributes)) {
	    	eventServ.delete(event_id);
	    	return "redirect:/events";
	    }else {
	    	return "redirect:/";
	    }
	    }
	    
	    @GetMapping("/logout")
	    public String logout( RedirectAttributes redirectAttributes) {
	    	session.invalidate(); // remove all values at the session 
	    	redirectAttributes.addFlashAttribute("success", "you logged out successfuly !");
	    	return "redirect:/";
	    }
	    
	    public User GetCurrentUser (){
	    	
	    	Long user_id = (Long) session.getAttribute("user_id");
	    	User current_user = userServ.getUserById(user_id);
	    	return current_user;
	    }
	    

	    public boolean IsAuth(RedirectAttributes redirectAttributes) {
	    	Long user_id = (Long) session.getAttribute("user_id");
	    	boolean auth =false;
	    	
	    	if (user_id == null ) { // user not in the session (didn't login)
	    		redirectAttributes.addFlashAttribute("authntication", "you must login before reach this page !");
	    		
	    	}else {
	    		auth =true;
	    	}
	    	
	    	return auth;
	    }
}
