package com.hoangdocuc.travel.service;

import com.hoangdocuc.travel.entity.AppUser;

public interface IUserService {
    AppUser findByAppUser(String userName);
}
