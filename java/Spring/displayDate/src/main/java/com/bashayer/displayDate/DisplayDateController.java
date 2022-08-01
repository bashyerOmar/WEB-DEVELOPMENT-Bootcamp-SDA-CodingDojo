package com.bashayer.displayDate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayDateController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp"; //render that page 
	}
	
	@RequestMapping("/date")
	public String Date(Model model) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE,");  
	    String dayname= formatter.format(new Date());
	    SimpleDateFormat formatter2 = new SimpleDateFormat("dd");  
	    String daynumber= formatter2.format(new Date()); 
	    SimpleDateFormat formatter3 = new SimpleDateFormat("MMMM , yyyy");   
	    String monthYear= formatter3.format(new Date()); 
	    
		model.addAttribute("dayName" , dayname);
		model.addAttribute("dayNumber" , daynumber);
		model.addAttribute("monthyear" , monthYear);
		return "date.jsp"; 
	}
	
	@RequestMapping("/time")
	public String Time(Model model) {
		String time = new SimpleDateFormat("hh:mm aa").format(new Date());
		model.addAttribute("time" , time);
		return "time.jsp"; 
	}
}
