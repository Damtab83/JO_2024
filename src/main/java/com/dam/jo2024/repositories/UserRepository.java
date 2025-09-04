package com.dam.jo2024.repositories;

import com.dam.jo2024.pojo.User;
import com.dam.jo2024.pojo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByRole(Role role);
}
