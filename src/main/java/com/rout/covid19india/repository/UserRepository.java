package com.rout.covid19india.repository;

import com.rout.covid19india.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Sagar Rout (sagar@rout.dev)
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByAccessToken(String accessToken);

    Optional<User> findByEmailId(String emailId);
}
