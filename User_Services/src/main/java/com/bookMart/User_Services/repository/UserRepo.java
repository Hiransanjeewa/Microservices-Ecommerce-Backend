package com.bookMart.User_Services.repository;


import com.ecommercesystem.registeruser.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


import java.util.List;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {


    // Register User Queries
    @Query(value="select * from users a where a.email=:Email", nativeQuery=true)
    List<User> findUserByEmail(String Email);
    @Query(value="select * from users a where a.mobile=:Mobile", nativeQuery=true)
    List<User> findUserByMobile(String Mobile);

    // Login user Queries
    @Query(value="SELECT password from users a WHERE a.email=:Email", nativeQuery=true)
    String findUserByLoginCredentials(String Email);

    @Transactional
    @Modifying
    @Query(value="update users a set a.password=?2 WHERE a.email=?1", nativeQuery=true)
    Integer changePassword(String Email,String password);


    @Transactional
    @Modifying
    @Query(value="update users a set a.active_status='1' WHERE a.email=?1", nativeQuery=true)
    void changeActiveStatus(String email);

    // Get User Address
    @Query(value="select * from users where userid=:userid", nativeQuery=true)
    List<User> getAddressBYId(Integer userid);

    // Change default address
    @Transactional
    @Modifying
    @Query(value="update users  set first_name=?1, second_name=?2 , address_line1=?3 , address_line2=?4  , district=?5 ,postal_code=?6 ,mobile=?7, province=?8  WHERE userid=?9", nativeQuery=true)
    void changeUserAddress(String firstname,String secondname,String address_line1,String address_line2,String district,String postal_code,String mobile,String province,Integer userid);


}