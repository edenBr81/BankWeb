package com.bankweb.user.repository;



import com.bankweb.user.entity.User;
import com.bankweb.user.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(Long id);

































    //    User findByIdentification(String identification);
//    List<User> findByAccountNumber(String AccountNumber);
//    User crateUser(User user);
//
//    User findByEmail(String email);
//
//    @Query("SELECT u FROM User u WHERE u.email = ?1 ")
//    User findByEmailJPQL(String email);
//
//    @Query(value = "SELECT * FROM USER WHERE email = :email",nativeQuery = true)
//    User findByEmailNativeQuery(@Param("email") String email);
}
