package com.hoangdocuc.travel.service.impl;

import com.hoangdocuc.travel.repository.RoleRepository;
import com.hoangdocuc.travel.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<String> findAppRoleNames(Long userId) {
        return roleRepository.findAppRoleNames(userId);
    }
}
