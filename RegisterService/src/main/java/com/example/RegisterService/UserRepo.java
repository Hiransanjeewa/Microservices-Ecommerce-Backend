package com.example.RegisterService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {


    @Query(value="select COUNT(*) from users where email=?1 AND password=?2", nativeQuery=true)
    Integer ValidateUsersByEmail(String email, String password);

    @Query(value="select COUNT(*) from users where username=:username AND password=:password", nativeQuery=true)
    Integer ValidateUsersByName(String username, String password);

    @Query(value="select COUNT(*) from users where email=?1 ", nativeQuery=true)
    Integer getUsersByEmail(String email);

    @Query(value="select COUNT(*) from users where username=:username", nativeQuery=true)
    Integer getUsersByName(String username);




}
