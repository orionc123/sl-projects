package com.hcl.phase3end.service;

import com.hcl.phase3end.dao.UserDao;
import com.hcl.phase3end.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserDao userDao;

    public boolean isValidLogin(@RequestParam("username") String name, @RequestParam("password") String password) {
        if (userDao.findById(name).isPresent()) return userDao.findById(name).get().getPass().equals(password);
        else return false;
    }

    public User getUser(String name) {
        if (userDao.findById(name).isPresent()) return userDao.findById(name).get();
        return null;
    }

    public boolean register(@RequestParam("username") String name, @RequestParam("password") String password, @RequestParam("email") String email){
        try{
            userDao.save(new User(name,password,email));
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
