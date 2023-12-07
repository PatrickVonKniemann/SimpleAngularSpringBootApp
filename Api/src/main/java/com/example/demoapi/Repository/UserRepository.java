package com.example.demoapi.Repository;

import com.example.demoapi.Models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
}