package com.corona.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterDTO {

    @JsonProperty
    private String email;

    @JsonProperty
    private String password;

    @JsonProperty
    private int customerNumber;

    @JsonProperty
    private String houseNumber;

    @JsonProperty
    private String zipCode;

    public RegisterDTO(String email, String password, int customerNumber, String houseNumber, String zipCode) {
        this.email = email;
        this.password = password;
        this.customerNumber = customerNumber;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
    }

    public RegisterDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
