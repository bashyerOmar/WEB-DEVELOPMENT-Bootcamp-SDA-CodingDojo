package com.bashayer.events.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.bashayer.events.models.LoginUser;
import com.bashayer.events.models.User;
import com.bashayer.events.repositores.UserRepo;

@Service
public class UserService {


private UserRepo userRepo;

public UserService(UserRepo userRepo) {
	this.userRepo = userRepo;
}


public User register(User newUser, BindingResult result) {
    if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
        result.rejectValue("email", "Unique", "This email is already exist , enter another one !");
    }
    if(!newUser.getPassword().equals(newUser.getConfirmPW())) {
        result.rejectValue("confirmPW", "Matches", "The Confirm Password must match Password!");
    }
    if(result.hasErrors()) {
    	
        return null;
    } else {
    	
        String hashedPW = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashedPW);
        return userRepo.save(newUser);
    }
}

public User login(LoginUser newLogin, BindingResult result) {
    if(result.hasErrors()) {
        return null;
    }
    Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
    if(!potentialUser.isPresent()) {
        result.rejectValue("email", "Unique", "please make sure your email is the correct one !");
        return null;
    }
    User user = potentialUser.get();
    if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
        result.rejectValue("password", "Matches", " password is incorrect  !");
    }
    if(result.hasErrors()) {
        return null;
    } else {
        return user;
    }
}


public User getUserById(Long id) {
	Optional<User> user = userRepo.findById(id);
     if(user.isPresent()) {
         return user.get();
     } else {
         return null;
     }
	
}

}