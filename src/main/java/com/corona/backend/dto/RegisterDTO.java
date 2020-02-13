package com.corona.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterDTO {

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    @JsonProperty
    private String password;

    @JsonProperty
    private String email;

    @JsonProperty
    private String zipCode;

    @JsonProperty
    private String street;

    @JsonProperty
    private String city;

    @JsonProperty
    private String houseNumber;

    @JsonProperty
    private String customerCode;

    public RegisterDTO(String firstName, String lastName, String email, String password, String customerCode, String street, String city, String houseNumber, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.customerCode = customerCode;
        this.street = street;
        this.city = city;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getFirstName() { return firstName;}

    public void setFirstName(String firstName) { this.firstName = firstName; }

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

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
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
