package com.automate.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automate.task.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);
	
}
