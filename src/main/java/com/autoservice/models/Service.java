package com.autoservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "services")
public class Service  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer service_id;

    @NotEmpty(message = "Cost cannot be empty")
    @Column(name = "cost")
    private Float cost;

    @NotEmpty(message = "Name cannot be empty")
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Service(){}

    public Service(Float cost, String name, String description/*, Check check*/) {
        this.cost = cost;
        this.name = name;
        this.description = description;
    }

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

