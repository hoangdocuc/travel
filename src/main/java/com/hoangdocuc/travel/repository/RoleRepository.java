package com.hoangdocuc.travel.repository;

import com.hoangdocuc.travel.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<AppRole,Long> {

    @Query(value = "select ap.ROLE_NAME from user_role ur " +
            "left join app_role ap on ur.ROLE_ID = ap.ROLE_ID " +
            "where ur.USER_ID = :userId"
            ,nativeQuery = true)
    List<String> findAppRoleNames (@Param("userId") Long userId);

}
