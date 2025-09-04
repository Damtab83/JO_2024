package com.dam.jo2024.services;

import com.dam.jo2024.pojo.User;
import com.dam.jo2024.pojo.model.Role;
import com.dam.jo2024.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User>getAllUsers() {return userRepository.findAll();}

    public User getUserById(Long id) {

        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        if(user.getRole() == Role.ADMIN) {
            boolean adminExists = userRepository.existsByRole(Role.ADMIN);
            if(adminExists) {
                throw new IllegalStateException("un seul Admin est autorisé");
            }
        }
        if(user.getRole() == null) {
            user.setRole(Role.CLIENT);
            user.setUserKey(AuthKey(user));
        }
        return userRepository.save(user);
    }

    public void updateUser(Long id, User newUser) {

        User oldUser = this.getUserById(id);
        if(oldUser != null) {
            oldUser.setFirstName(newUser.getFirstName());
            oldUser.setLastName(newUser.getLastName());
            oldUser.setEmail(newUser.getEmail());
            if(oldUser.getEmail().equals(newUser.getEmail())) {
                oldUser.setEmail(newUser.getEmail());
            }
            else {
                throw new IllegalStateException("le mot de passe est identique à l'ancien");
            }

            userRepository.save(oldUser);

        }
    }

    public Boolean deleteUser(Long id) {

        Boolean toDelete = userRepository.existsById(id);
        if(toDelete) {
            userRepository.deleteById(id);
        }
        return toDelete;
    }

    public String AuthKey(User user) {
        String myUserFirstName = user.getFirstName().toLowerCase().trim();
        myUserFirstName.substring(0, myUserFirstName.length()/2);
        String myUserLastName = user.getLastName().toLowerCase().trim();
        myUserLastName.substring(0, myUserLastName.length()/2);

        return myUserFirstName + user.getEmail()+myUserLastName;
    }
}
