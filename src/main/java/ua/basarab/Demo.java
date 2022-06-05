package ua.basarab;

import ua.basarab.exception.InvalidUserException;
import ua.basarab.exception.UserNotFoundException;
import ua.basarab.service.UserService;

import java.util.ArrayList;
import java.util.Scanner;

class Demo {

    static Scanner scanner = new Scanner(System.in);
    static UserService userService = new UserService();

    public static void main(String[] args) {

        do {
            displayMenu();
            int option = scanner.nextInt();
            if (option == 1){
                displayAllUsers();
            } else if (option == 2) {
                addUser();
            } else if (option == 3) {
                findUserById();
            } else if (option == 4) {
                System.out.println("Exiting...");
                break;
            }
        } while (true);
    }

    static void displayMenu() {
        System.out.println();
        System.out.println("1 - Display ALl users");
        System.out.println("2 - Add user");
        System.out.println("3 - Find user by ID");
        System.out.println("4 - Exit");
        System.out.println("Option:");
        System.out.println();
    }

    static void displayAllUsers (){
        ArrayList<User> user = userService.AllUsers();
        System.out.println(user);
    }

    static void addUser() {

        try {
            System.out.println("Type new user`s login");
            var userLogin = scanner.next();
            System.out.println("Type new user`s password");
            var userPassword = scanner.next();
            System.out.println("New user registered");
            userService.createNewUser(userLogin, userPassword);
        } catch (InvalidUserException e) {
            System.err.println(e.getMessage());
        }
    }

    static void findUserById() {

        try {
            System.out.println("Type id of the user you’re looking for");
            var id = scanner.nextInt();
            System.out.println("Searching by ID: " + id);
            User user = userService.searchById(id);
            System.out.println("user found: " + user);
        }catch (UserNotFoundException e){
            System.err.println(e.getMessage());
        }
    }
}