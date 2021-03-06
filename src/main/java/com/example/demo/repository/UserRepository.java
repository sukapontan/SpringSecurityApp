package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.app.PasswordResetForm;
import com.example.demo.entity.User;

/**
 * ユーザー情報 Repository
 */
@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Modifying
	@Query(value = "update user set password = :password where name = :username", nativeQuery = true)
	void save(String username, String password);
}