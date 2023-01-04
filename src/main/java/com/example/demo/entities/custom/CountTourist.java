package com.example.demo.entities.custom;


import com.example.demo.entities.Tourist;

public class CountTourist {

    private Integer total;
    private Tourist tourist;

    public CountTourist(Integer total, Tourist tourist){
        this.total = total;
        this.tourist = tourist;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Tourist getTourist() {
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }
}
