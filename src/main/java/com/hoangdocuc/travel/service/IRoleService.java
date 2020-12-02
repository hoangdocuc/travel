package com.hoangdocuc.travel.service;

import com.hoangdocuc.travel.entity.AppRole;

import java.util.List;

public interface IRoleService {
    List<String> findAppRoleNames(Long userId);
}
