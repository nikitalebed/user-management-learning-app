package ua.basarab.service;

import ua.basarab.User;
import ua.basarab.exception.InvalidUserException;
import ua.basarab.exception.UserNotFoundException;
import ua.basarab.repository.UserRepository;

import java.util.ArrayList;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public ArrayList<User> AllUsers (){
        return userRepository.findALl();
    }

    public User searchById(int id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new UserNotFoundException("ua.basarab.User with that ID= " + id + " not found.");
        }
        return user;
    }

    public void createNewUser(String login, String password) {
        if (login == null || password == null) {
            throw new InvalidUserException("Invalid login or password");
        }
        userRepository.newUser(login, password);
    }
}


