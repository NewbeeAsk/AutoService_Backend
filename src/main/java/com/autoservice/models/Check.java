package com.autoservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "checks")
public class Check implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer check_id;

    @NotNull(message = "TotalCost cannot be empty")
    @Column(name = "totalCost")
    private Float totalCost;

    @NotNull
    @Column(name = "paid")
    private boolean paid;

    public Check() {
    }

    public Check(Float totalCost, boolean paid) {
        this.totalCost = totalCost;
        this.paid = paid;
    }

    public Integer getCheck_id() {
        return check_id;
    }

    public void setCheck_id(Integer check_id) {
        this.check_id = check_id;
    }

    public Float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

}
