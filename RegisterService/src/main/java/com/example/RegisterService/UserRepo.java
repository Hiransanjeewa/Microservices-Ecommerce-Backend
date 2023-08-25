package com.example.RegisterService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {


    @Query(value="select COUNT(*) from users where email=:email", nativeQuery=true)
    Integer getUsersByEmail(String email);

    @Query(value="select COUNT(*) from users where username=:username", nativeQuery=true)
    Integer getUsersByName(String username);



}
