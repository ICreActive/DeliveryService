package com.shkubel.application.service;

import com.shkubel.application.database.DataBase;
import com.shkubel.application.exception.ObjectNotFoundException;
import com.shkubel.application.model.User;

import java.util.List;

public class UserService implements ShowDelInterface {

    DataBase db = new DataBase();

    public void createUser(String name, String lastname, int age, String address) {
        List<User> users = db.loadUserList();
        var user = new User();
        user.setName(name);
        user.setLastName(lastname);
        try {
            user.setAge(age);
            user.setAddress(address);
            user.setId(users.size() + 1L);
            users.add(user);
            db.saveUserList(users);
            System.out.println(user);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(long id, String name, int age, String address) {
        User userInDb = null;
        try {
            userInDb = db.findUserById(id);
        } catch (ObjectNotFoundException e) {
            e.printStackTrace();
        }
        List<User> users = db.loadUserList();
        for (User user : users
        ) {
            if (user.equals(userInDb)) {
                System.out.println(user);
                user.setName(name);
                user.setAge(age);
                user.setAddress(address);
            }
        }
        db.saveUserList(users);
    }

    @Override
    public void delete(long id) {
        try {
            db.findUserById(id);
            List<User> users = db.loadUserList();
            users.removeIf(userElem -> userElem.getId() == id);
            db.saveUserList(users);
            System.out.println("Deleted");
        } catch (ObjectNotFoundException e) {
            System.err.println(e);
        }
    }

    @Override
    public void show() {
        db.loadUserList().forEach(System.out::println);
    }
}
