package com.hcl.capstone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String name;
    private String category;
    private String condition;
    private double price;
    @Column(columnDefinition = "VARCHAR(MAX)")
    private String imageLink;
}
