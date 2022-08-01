package com.bashayer.pokebook.service;


import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.bashayer.pokebook.models.PokeBook;
import com.bashayer.pokebook.repositories.PokeRepository;



@Service
public class PokeService {

	// adding the book repository as a dependency
	  private final PokeRepository pokeRepository;
	 
	 public PokeService(PokeRepository pokeRepository) {
	     this.pokeRepository = pokeRepository;
	 }
	 // retrieve all the pokes
	 public List<PokeBook> allPokes() {
	     return pokeRepository.findAll();
	 }
	 // creates a poke
	 public PokeBook createPoke(PokeBook b) {
	     return pokeRepository.save(b);
	 }
	 // retrieves a one poke 
	 public PokeBook findpoke(Long id) {
	     Optional<PokeBook> optionalPoke= pokeRepository.findById(id);
	     if(optionalPoke.isPresent()) {
	         return optionalPoke.get();
	     } else {
	         return null; 
	     }
	 }
	 
	 public void deletePoke(Long id) {
		 pokeRepository.deleteById(id);
	     
	 }
	 
	 public PokeBook updatePoke(PokeBook poke, Long id) {
		 
		 PokeBook pokeToUpdate=this.findpoke(id); //retrieve the desired poke !
		 //update all values 
		 pokeToUpdate.setExpense(poke.getExpense());
		 pokeToUpdate.setDesc(poke.getDesc());
		 pokeToUpdate.setVendor(poke.getVendor());
		 pokeToUpdate.setAmount(poke.getAmount());
		 pokeRepository.save(pokeToUpdate); //save changes (update)
		 return pokeToUpdate;
	 }
	 
	 
}
