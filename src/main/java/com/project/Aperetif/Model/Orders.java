package com.project.Aperetif.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users custrom;
    private Wine wineId;
    private String dateAdd;

    public Orders(Long id, Users custrom, Wine wineId, String dateAdd) {
        this.custrom = custrom;
        this.wineId = wineId;
        this.dateAdd = dateAdd;
        this.id = id;
    }

    public Orders() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUserId() {
        return custrom;
    }

    public void setUserId(Users userId) {
        this.custrom = custrom;
    }

    public Wine getWineId() {
        return wineId;
    }

    public void setWineId(Wine wineId) {
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
