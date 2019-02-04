package com.ak4.service;

import com.ak4.entity.UserEntity;
import com.ak4.exception.AppWebApplicationException;
import com.ak4.exception.UserAlreadyExistException;
import com.ak4.mapper.AdminMapper;
import com.ak4.repository.AdminRepository;
import com.ak4.schema.UserAndRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminMapper adminMapper;

    public boolean addUserAndRole(UserAndRole userAndRole) {
        boolean createdStatus = false;
        UserEntity userEntity = adminMapper.from(userAndRole);
        UserEntity createdUserEntity = null;
        try {
            createdUserEntity = adminRepository.save(userEntity);
        } catch (RuntimeException e) {
            throw new UserAlreadyExistException("Username already exists");
        } catch (Exception e) {
            throw new AppWebApplicationException("Internal Server Error");
        }
        if(createdUserEntity != null) {
            createdStatus = true;
        }
        return createdStatus;
    }
}
