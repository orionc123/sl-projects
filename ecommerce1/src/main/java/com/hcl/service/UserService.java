package com.hcl.service;

import com.hcl.dao.UserDao;
import com.hcl.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    public boolean loginValid(@RequestParam("username") String name) {
        return userDao.findById(name).isPresent();
    }

    public boolean updateUser(String name, String password, String email){
            User u = new User(name,password,email);
            userDao.deleteById(name);
            userDao.save(u);
            return true;
    }

    public User findUser(String name){
        if(userDao.findById(name).isPresent())return userDao.findById(name).get();
        return null;
    }

}
