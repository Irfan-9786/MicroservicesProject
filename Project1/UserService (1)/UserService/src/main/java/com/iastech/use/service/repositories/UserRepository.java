package com.iastech.use.service.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iastech.use.service.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User,String> {
	Optional<User> findByUserName(String userName);
}
