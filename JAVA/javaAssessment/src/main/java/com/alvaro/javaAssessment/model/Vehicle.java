package com.alvaro.javaAssessment.model;

import javax.persistence.*;
import java.security.acl.Owner;

@Entity(name = "tableVehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(length = 30, nullable = false)
    private String brand;

    @Column(length = 25, nullable = false)
    private String vin;

    @Column(length = 15, nullable = false)
    private String color;

    @Column(length = 6, nullable = false)
    private String year;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_owner",referencedColumnName = "id")
    private Owner owner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
