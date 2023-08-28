package com.example.LoginService;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@EnableJpaRepositories
@Repository
public interface LoginRepo extends JpaRepository<logins,Integer> {

    @Query(value="select session_token from logins where user_id=:user_id", nativeQuery=true)
    Integer getSessionToken(int user_id);


}
