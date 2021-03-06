package com.example.springcard.repostory;

import com.example.springcard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepostory extends JpaRepository<User,Integer> {

    boolean existsByPhoneNumber(String phoneNumber);


    Optional<User> findByPhoneNumber(String phoneNumber);
}
