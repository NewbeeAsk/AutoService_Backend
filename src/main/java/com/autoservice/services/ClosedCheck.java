package com.autoservice.services;

import com.autoservice.models.Check;
import com.autoservice.models.CostByCategory;

import java.util.List;

public class ClosedCheck {

    List<CostByCategory> costByCategoryList;
    Check check;

    public ClosedCheck(List<CostByCategory> costByCategoryList, Check check) {
        this.check = check;
        this.costByCategoryList = costByCategoryList;
    }

    public List<CostByCategory> getCostByCategoryList() {
        return costByCategoryList;
    }

    public void setCostByCategoryList(List<CostByCategory> costByCategoryList) {
        this.costByCategoryList = costByCategoryList;
    }

    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }
}
