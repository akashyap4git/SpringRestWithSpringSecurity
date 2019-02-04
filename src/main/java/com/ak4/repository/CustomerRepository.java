package com.ak4.repository;

import com.ak4.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

    String USERNAME = "username";

    @Query("select cust.customerId from CustomerEntity cust where cust.username = :username")
    public String getCustomerByUserName(@Param(USERNAME) String username);
}
