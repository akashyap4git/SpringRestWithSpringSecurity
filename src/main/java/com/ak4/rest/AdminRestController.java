package com.ak4.rest;

import com.ak4.schema.UserAndRole;
import com.ak4.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "service/admin")
public class AdminRestController {

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "createUserAndRole")
    public boolean createUserAndRole(@RequestBody UserAndRole userAndRole) {
        return adminService.addUserAndRole(userAndRole);
    }

}
