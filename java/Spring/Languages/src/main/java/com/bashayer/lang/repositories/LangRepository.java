package com.bashayer.lang.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bashayer.lang.models.Language;

@Repository
public interface LangRepository extends CrudRepository<Language, Long> {

	// this method retrieves all the languages from the database
    List<Language> findAll();
}
