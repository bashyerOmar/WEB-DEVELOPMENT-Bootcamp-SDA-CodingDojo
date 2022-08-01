package com.bashayer.pokebook.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bashayer.pokebook.models.PokeBook;

@Repository
public interface PokeRepository extends CrudRepository<PokeBook, Long>  {


 // this method retrieves all the Pokes from the database
 List<PokeBook> findAll();
 
 // delete Poke by its id 
 void deleteById(Long id);
 // return Poke based on the id !
 Optional<PokeBook> findById (Long id);

}

