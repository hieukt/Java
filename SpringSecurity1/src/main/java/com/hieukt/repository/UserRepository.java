package com.hieukt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hieukt.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>  {
	UserEntity findOneByUserName(String name);
}