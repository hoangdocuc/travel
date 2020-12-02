package com.hoangdocuc.travel.service.impl;

import com.hoangdocuc.travel.entity.AppUser;
import com.hoangdocuc.travel.repository.UserRepository;
import com.hoangdocuc.travel.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public AppUser findByAppUser(String userName) {
        return userRepository.findAppUserByUserName(userName);
    }
}
