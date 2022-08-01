package com.bashayer.events.repositores;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bashayer.events.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
       
}
