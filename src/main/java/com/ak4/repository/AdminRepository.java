package com.ak4.repository;

import com.ak4.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<UserEntity, String> {

}
