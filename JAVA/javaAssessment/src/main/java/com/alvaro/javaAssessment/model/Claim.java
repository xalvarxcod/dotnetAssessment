package com.alvaro.javaAssessment.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "tableClaim")
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(length = 25, nullable = false)
    private String description;

    @Column(length = 25, nullable = false)
    private String status;

    @Column(length = 20, nullable = false)
    private Date date;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_vehicle",referencedColumnName = "id")
    private Vehicle vehicle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
