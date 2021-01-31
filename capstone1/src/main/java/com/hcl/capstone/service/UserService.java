package com.hcl.capstone.service;

import com.hcl.capstone.dao.UserDao;
import com.hcl.capstone.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public boolean isValidLogin(@RequestParam("username") String name,
                                @RequestParam("password") String password) {
        if (userDao.findById(name).isPresent()) return userDao.findById(name).get().getPassword().equals(password);
        else return false;
    }

    public boolean register(@RequestParam("username") String name,
                            @RequestParam("password") String password,
                            @RequestParam("email") String email,
                            @RequestParam("phone") String phone,
                            @RequestParam("fullName") String fullName,
                            @RequestParam("streetName") String streetName,
                            @RequestParam("aptNumber") String aptNumber,
                            @RequestParam("city") String city,
                            @RequestParam("state") String state,
                            @RequestParam("country") String country,
                            @RequestParam("zip") int zip) {
        try {
            userDao.save(new User(name, password, email, phone, fullName, streetName, aptNumber, city, state, country, zip));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateUser(@RequestParam("username") String name,
                              @RequestParam("password") String password,
                              @RequestParam("email") String email,
                              @RequestParam("phone") String phone,
                              @RequestParam("fullName") String fullName,
                              @RequestParam("streetName") String streetName,
                              @RequestParam("aptNumber") String aptNumber,
                              @RequestParam("city") String city,
                              @RequestParam("state") String state,
                              @RequestParam("country") String country,
                              @RequestParam("zip") int zip) {
        try {
            userDao.deleteById(name);

            User user = new User(name, password, email, phone, fullName, streetName, aptNumber, city, state, country, zip);
            userDao.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public User getUser(String name) {
        if (userDao.findById(name).isPresent()) return userDao.findById(name).get();
        return null;
    }

    public List<User> getAllUsers() {
        return (ArrayList<User>) userDao.findAll();
    }

    public void deleteUser(String username){userDao.deleteById(username);}

}
