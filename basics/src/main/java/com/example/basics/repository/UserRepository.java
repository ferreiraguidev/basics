package com.example.basics.repository;


import com.example.basics.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByLogin(String login);

    Users findByLoginIgnoreCase(String login);
}
