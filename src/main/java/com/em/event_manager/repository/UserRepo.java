package com.em.event_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.em.event_manager.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
