package com.example.bean;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id @GeneratedValue
    @Column(name = "productid")
    int id;
    String name;
    String brand;
    String description;
    String price;

    public Product(String name, String brand, String description, String price) {
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product:<br>" +
                "id=" + id +
                "<br>name='" + name + '\'' +
                "<br>brand='" + brand + '\'' +
                "<br>description='" + description + '\'' +
                "<br>price='" + price + '\'';
    }
}
