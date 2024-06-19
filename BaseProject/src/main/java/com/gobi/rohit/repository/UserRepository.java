package com.gobi.rohit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gobi.rohit.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
	@Query(value = "Select * from users where status = 'ACTIVE'",nativeQuery = true)
	Optional<Users> findByUserName(String userName);
}
