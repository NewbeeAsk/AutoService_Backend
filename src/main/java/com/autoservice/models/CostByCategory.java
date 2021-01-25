package com.autoservice.models;

import java.math.BigDecimal;

public class CostByCategory {
    BigDecimal costByCategory;
    String category;

    public CostByCategory(BigDecimal costByCategory, String category) {
        this.costByCategory = costByCategory;
        this.category = category;
    }

    public BigDecimal getCostByCategory() {
        return costByCategory;
    }

    public void setCostByCategory(BigDecimal costByCategory) {
        this.costByCategory = costByCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
