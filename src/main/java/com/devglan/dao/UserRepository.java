package com.devglan.dao;

import com.devglan.model.User;
import com.devglan.model.ReferralCode;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByMobile(String mobile);

}
