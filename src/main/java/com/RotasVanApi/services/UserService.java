package com.RotasVanApi.services;

import com.RotasVanApi.models.UserModel;
import com.RotasVanApi.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Object save(UserModel userModel){
        return userRepository.save(userModel);
    }

    public List<UserModel> findAll(){
        return userRepository.findAll();
    }

    public Optional<UserModel> findById(Long id){
        return userRepository.findById(id);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public void delete(UserModel userModel){
        userRepository.delete(userModel);
    }

    public Optional<UserModel> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
