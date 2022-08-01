package com.bashayer.lang.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.bashayer.lang.models.Language;
import com.bashayer.lang.services.LangService;




@Controller
@RequestMapping("/languages")
public class HomeController {

	 private final LangService langService;
	    
	    public HomeController(LangService langService){
	        this.langService = langService;
	    }
	    
	@RequestMapping("")
    public String index(Model model , @ModelAttribute("lang") Language lang) {
		List<Language> langs = langService.allLangs(); //retrieve all languages
        model.addAttribute("langs",langs); // pass them to index.jsp
        
       
        return "index.jsp";
    }
	
	
	@RequestMapping(value ="" , method=RequestMethod.POST)
	public String createPoke(@Valid @ModelAttribute("lang") Language lang,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
	
		if(bindingResult.hasErrors()) {
			return "index.jsp";
		}
		langService.createLang(lang);
		redirectAttributes.addFlashAttribute("success", "Your language has been created");
		return "redirect:/languages";

	}
	
	@RequestMapping("/{id}")
	public String showOne(@PathVariable("id") Long id , Model model) {
		Language Lang = langService.findLang(id);
		model.addAttribute("lang", Lang);
        return "show.jsp";
    }
	
	@RequestMapping("/{id}/edit")
	public String updatePage(@PathVariable("id") Long id , Model model) {
		Language LangToUpdate = langService.findLang(id);
		model.addAttribute("lang", LangToUpdate);
        return "edit.jsp";
    }
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("lang") Language lang, BindingResult result , RedirectAttributes redirectAttributes , @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            langService.updateLang(lang , id);
            redirectAttributes.addFlashAttribute("success", "Your language has been updated");
            return "redirect:/languages";
        }
  }
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
		    langService.deleteLang(id);
            return "redirect:/languages";
        }
	
	
	
 }

