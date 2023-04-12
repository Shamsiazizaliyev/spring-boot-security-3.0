package com.example.springbootsecurity.repository;



import com.example.springbootsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepostory extends JpaRepository<User,Integer> {



    Optional<User> findByName(String username);


}
