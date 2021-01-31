package com.hcl.capstone.dao;

import com.hcl.capstone.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, String> {
}
