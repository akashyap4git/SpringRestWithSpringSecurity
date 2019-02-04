package com.ak4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static java.util.UUID.randomUUID;

@Entity
@Table(name = "CUST_ADDRESS")
public class AddressEntity {

    @Id
    @Column(name = "ADDRESS_ID")
    private String addressId = randomUUID().toString();

    @Column(name = "ADDRESS_LINE")
    private String addressLine;

    @Column(name = "CITY")
    private String city;

    @Column(name = "ZIP_CODE")
    private Long zipCode;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }
}
