package com.hcl.capstone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //Basic Info
    @Id
    private String username;
    private String password;
    private String email;
    private String phone;

    //Billing Address
    private String fullName;
    private String streetName;
    private String aptNumber;
    private String city;
    private String state;
    private String country;
    private int zip;
}
