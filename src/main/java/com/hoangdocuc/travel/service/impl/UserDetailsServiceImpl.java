package com.hoangdocuc.travel.service.impl;

import com.hoangdocuc.travel.entity.AppUser;
import com.hoangdocuc.travel.service.IRoleService;
import com.hoangdocuc.travel.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IRoleService iRoleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = iUserService.findByAppUser(userName);

        if (appUser==null){
            System.out.println("User not found! "+userName);
            throw new UsernameNotFoundException("User "+userName+" was not found in the database");
        }
        System.out.println("Found User: "+appUser);

        List<String> roleNames = iRoleService.findAppRoleNames(appUser.getUserId());

        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roleNames != null){
            for (String role : roleNames){
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(),appUser.getEncrytedPassword(),grantList);

        return userDetails;
    }
}
