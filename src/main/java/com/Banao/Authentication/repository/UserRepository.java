package com.Banao.Authentication.repository;

import com.Banao.Authentication.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Integer> {

    Optional<Users> findByUsername(String S);

    Users findByEmail(String s);

    //@Query(value="select * from users r where r.verification_code=?1",nativeQuery=true)
    Users findByVerificationcode(String s);
}
