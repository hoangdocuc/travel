package com.hoangdocuc.travel.repository;

import com.hoangdocuc.travel.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {
    AppUser findAppUserByUserName(String userName);
}
