package com.autoservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "checks")
public class Check implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer check_id;

    @NotNull(message = "TotalCost cannot be empty")
    @Column(name = "totalCost")
    private BigDecimal totalCost;

    @NotNull
    @Column(name = "complete")
    private boolean complete;

    @NotNull
    @Column(name = "paid")
    private boolean paid;

    public Check() {
    }

    public Check(BigDecimal totalCost, boolean paid) {
        this.totalCost = totalCost;
        this.paid = paid;
    }

    public Integer getCheck_id() {
        return check_id;
    }

    public void setCheck_id(Integer check_id) {
        this.check_id = check_id;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

}
