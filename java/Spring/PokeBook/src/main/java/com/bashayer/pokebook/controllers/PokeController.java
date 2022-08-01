package com.bashayer.pokebook.controllers;



import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.bashayer.pokebook.models.PokeBook;
import com.bashayer.pokebook.service.PokeService;

@Controller
@RequestMapping("/expenses")
public class PokeController {
	private final PokeService PokeService;
	
	
	public PokeController(PokeService PokeService) {
		this.PokeService = PokeService;
	}


	@RequestMapping("")
	public String expenses(Model model , @ModelAttribute("poke") PokeBook poke) {
		List<PokeBook> pokes = PokeService.allPokes();
		model.addAttribute("allPokes", pokes);

		return "index.jsp";
	}
	
	
	@PostMapping("/create" )
	public String createPoke(@Valid @ModelAttribute("poke") PokeBook poke,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
	
		if(bindingResult.hasErrors()) {
			return "index.jsp";
		}
		PokeService.createPoke(poke);
		redirectAttributes.addFlashAttribute("success", "Your poke has been created");
		return "redirect:/expenses";

	
	}
	
	
	@RequestMapping("/{id}")
    public String showOne(@PathVariable("id") Long id , Model model) throws Exception  {
        PokeBook poke = PokeService.findpoke(id); //retrieve the poke
        
        if(poke == null) {
			throw new Exception("Poke with id "+ id+" not found ");
		}
		
        model.addAttribute("poke",poke); // pass it to the show.jsp page to display it there !!
        
        return "show.jsp";
    }
	
	@RequestMapping("/edit/{id}")
	public String updatePage(@PathVariable("id") Long id , Model model , @ModelAttribute("pokeModel") PokeBook poke) {
		PokeBook pokeToUpdate = PokeService.findpoke(id);
		model.addAttribute("poke", pokeToUpdate);
        return "edit.jsp";
    }
	
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("pokeModel") PokeBook poke, BindingResult result , RedirectAttributes redirectAttributes , @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	PokeService.updatePoke(poke , id);
            redirectAttributes.addFlashAttribute("success", "Your poke has been updated");
            return "redirect:/expenses";  
        }
  }
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
		
        PokeService.deletePoke(id);
        return "redirect:./";
    }
	
}
