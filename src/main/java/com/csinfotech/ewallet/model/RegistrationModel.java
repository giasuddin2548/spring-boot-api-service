package com.csinfotech.ewallet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_accounts")
public class RegistrationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String userFullName;

//    @JsonIgnore // if we want to ignore any filed for read we use jsonIgnore
    @Email
    private String userEmail;
    @JsonIgnore
    private String password;
    private String userPhone;
    private Boolean tramsChecked =false; //This is default value

    public RegistrationModel() {
    }

    public RegistrationModel(String password,String userFullName, String userEmail, String userPhone, Boolean tramsChecked) {
        this.password=password;
        this.userFullName = userFullName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.tramsChecked = tramsChecked;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Boolean getTramsChecked() {
        return tramsChecked;
    }

    public void setTramsChecked(Boolean tramsChecked) {
        this.tramsChecked = tramsChecked;
    }



}
