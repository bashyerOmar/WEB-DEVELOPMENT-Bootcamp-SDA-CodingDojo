package com.bashayer.lang.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bashayer.lang.models.Language;
import com.bashayer.lang.repositories.LangRepository;


@Service
public class LangService {

private final LangRepository langRepo;
    
    public LangService(LangRepository langRepo) {
        this.langRepo = langRepo;
    }
    
    // returns all the languages
    public List<Language> allLangs() {
        return langRepo.findAll();
    }
    
    // creates a language
	 public Language createLang(Language lang) {
	     return langRepo.save(lang);
	 }
	 
	 // retrieves a book
	 public Language findLang(Long id) {
	     Optional<Language> optionalBook = langRepo.findById(id);
	     if(optionalBook.isPresent()) {
	         return optionalBook.get();
	     } else {
	         return null;
	     }
	 }
	 
	 public void updateLang(Language lang , Long id) {
		 Language langToUpdate=this.findLang(id);
		 langToUpdate.setName(lang.getName());
		 langToUpdate.setCreator(lang.getCreator());
		 langToUpdate.setVersion(lang.getVersion());
		 
		 langRepo.save(langToUpdate);
	 }
	 
	 public void deleteLang(Long id) {
	      langRepo.deleteById(id);
	     
	 }
	 
}
