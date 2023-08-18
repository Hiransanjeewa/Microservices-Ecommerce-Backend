package com.bookMart.User_Services.repository;

import com.ecommercesystem.registeruser.entity.Otps;
import com.ecommercesystem.registeruser.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface OtpRepo extends JpaRepository<Otps,Integer> {

    @Transactional
    @Modifying
    @Query(value="insert into otps VALUES (?1,?2)", nativeQuery=true)
    Integer saveOtp(String email,Integer otp);

    @Query(value="select * from otps where email=:email", nativeQuery=true)
    Otps validateEmail(String email);

    @Transactional
    @Modifying
    @Query(value="delete from otps where email=:email", nativeQuery=true)
    void deletePreviousOtp(String email);
}
