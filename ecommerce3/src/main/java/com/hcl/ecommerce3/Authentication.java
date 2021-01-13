package com.hcl.ecommerce3;

import com.hcl.ecommerce3.model.User;

import java.util.HashSet;
import java.util.Set;

public class Authentication {
    public static Set<User> list = new HashSet<>();
    private User currentUser;

    public boolean login(String name, String password){
        if(list.stream().anyMatch(user -> user.getName().equals(name) && user.getPassword().equals(password))){
            currentUser=getUser(name, password);
            return true;
        } else{
            return false;
        }
    }

    public User getUser(String name, String password){
        return list.stream().filter(user -> user.getName().equals(name) && user.getPassword().equals(password)).findFirst().get();
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public boolean isAdmin(){
        return currentUser.getName().equals("admin") && currentUser.getPassword().equals("admin");
    }
}
