package com.autoservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ordered_services")
public class OrderedService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer service_id;

    @NotNull(message = "cost cant be empty")
    @Column(name = "cost")
    private BigDecimal cost;

    @NotEmpty(message = "Name cannot be empty")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Category cannot be empty")
    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "done")
    private boolean done;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "check_id")
    private Check check;

    public OrderedService() {
    }

    public OrderedService(String name, String category, BigDecimal cost, String description, boolean done, Check check) {
        this.cost = cost;
        this.name = name;
        this.description = description;
        this.category = category;
        this.done = done;
        this.check = check;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
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

    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}

