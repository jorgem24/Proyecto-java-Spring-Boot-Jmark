package com.example.demo.service;

import com.example.demo.model.User;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;

@Service
public class UserService {
    static ArrayList<User> users = new ArrayList<>();

    static {

        // locale in english
        Faker faker = new Faker(new Locale("en-GB"));
        // ref variable creation UUID
        String uniqueID;

        for (int i = 0; i <100 ; i++ ){

            uniqueID = UUID.randomUUID().toString();
            users.add(new User ( uniqueID,
                                faker.name().name() ,
                                faker.address().fullAddress(),
                                faker.number().numberBetween(10,99)
            ));
            }

    }

    // return users to controller
    // get users from list static from class and return as signature
    public ArrayList<User> getAllUsers (){
        return users;
    }

    public User findUserById(String id) {

        User userFound = null;

        for (User user : users) {
            boolean checkUser = user.getId().equals(id);
            if (checkUser)

            {userFound = user;
              break;}

        }


        return userFound;
    }

    public int qtyUsers (){
        return users.size();
    }

    public boolean deleteAllUsers(){
        //delete all users with clear

        users.clear();
        int qty = qtyUsers();
        boolean deletedUsers = true;

        if ( qty > 0) deletedUsers = false ;
        //else null;
        return deletedUsers;
    }

    public User deleteById(String id) {

        User user = findUserById(id);
        boolean userRemoved = false;

        if (user != null) {

            userRemoved = users.remove(user);
            return user;

        } else return null;
    }

    public User createBook(User user) {

        boolean userAdded = users.add(user);

        if (userAdded) return user; else return null;
    }

    public User updateBook (String id, User user){

        User userFound = findUserById(id);
        //boolean userUpdated = false;

        if (userFound != null) {
            int index = users.indexOf(userFound);
            User userUpdated = users.set(index, user);
            return userUpdated;

        } else return null;

    }

    public User createUser(User user) {

        return null;
    }

    public User updateUser(String id, User user) {
        return null;
    }
}
