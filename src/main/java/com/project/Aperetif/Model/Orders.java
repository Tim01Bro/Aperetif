package com.project.Aperetif.Model;

import java.util.Objects;


public class Orders {


    private Long id;

    private Long custrom;
    private Integer wineId;
    private String dateAdd;

    public Orders(Long id, Long custrom, Integer wineId, String dateAdd) {
        this.custrom = custrom;
        this.wineId = wineId;
        this.dateAdd = dateAdd;
        this.id = id;
    }

    public Orders(Long custrom, Integer wineId, String dateAdd) {
        this.custrom = custrom;
        this.wineId = wineId;
        this.dateAdd = dateAdd;
    }

    public Orders() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return custrom;
    }

    public void setUserId(Long userId) {
        this.custrom = userId;
    }

    public Integer getWineId() {
        return wineId;
    }

    public void setWineId(Integer wineId) {
        this.wineId = wineId;
    }

    public String getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(String dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders basket = (Orders) o;
        return Objects.equals(id, basket.id) &&
                Objects.equals(custrom, basket.custrom) &&
                Objects.equals(wineId, basket.wineId) &&
                Objects.equals(dateAdd, basket.dateAdd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, custrom, wineId, dateAdd);
    }
}
