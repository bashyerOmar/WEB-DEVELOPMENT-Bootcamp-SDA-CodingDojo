package com.bashayer.counter;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	 @RequestMapping("/")
	    public String index(Model model , HttpSession session) {
		 Integer currentCount;
		      if (session.getAttribute("count") == null) {
				// Use setAttribute to initialize the count in session
		    	  session.setAttribute("count", 0);
		    	  currentCount = (Integer) session.getAttribute("count");
				}else {
				// increment the count by 1 
				    currentCount = (Integer) session.getAttribute("count");
					currentCount++;
					session.setAttribute("count", currentCount);
				}
		    
	        
	        return "index.jsp";
	    }
	 
	 @RequestMapping("/counter")
	 public String showCounter() {
		 return "counter.jsp";
	 }
	 
	 @RequestMapping("/reset")
	 public String resetCounter( HttpSession session) {
		 session.setAttribute("count",0); // assign counter to 0 
		 return "redirect:/counter";
	 }
}

