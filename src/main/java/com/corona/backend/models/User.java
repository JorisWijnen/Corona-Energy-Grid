package com.corona.backend.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String houseNumber;

    @Column(nullable = false)
    private int customerNumber;

    public void setStatus(Set<Status> status) {
        this.status = status;
    }

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "user_status", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "status_id"))
    private Set<Status> status;

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(String firstName, String lastName, String password, String email, String zipCode, String houseNumber, int customerNumber  ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email= email;
        this.zipCode = zipCode;
        this.houseNumber = houseNumber;
        this.customerNumber = customerNumber;
    }

    public User(){

    }
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Status> getStatus() {
        return status;
    }
}
