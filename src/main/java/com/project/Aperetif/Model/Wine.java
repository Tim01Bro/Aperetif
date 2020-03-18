package com.project.Aperetif.Model;

import java.util.Objects;
import java.util.Set;


public class Wine {

    private Long id;

    private String nameWine;

    private Integer rating;

    private Integer typeWines;

    private String describe;

    private Integer quantity;

    private String filename;

    private String dateAdded;

    public Wine(Long id,String nameWine, Integer rating,Integer typeWines, String describe, Integer quantity, String filename, String dateAdded) {
        this.nameWine = nameWine;
        this.rating = rating;
        this.typeWines = typeWines;
        this.describe = describe;
        this.quantity = quantity;
        this.filename = filename;
        this.dateAdded = dateAdded;
        this.id = id;
    }

    public Wine(String nameWine, Integer rating, Integer typeWines, String describe, Integer quantity, String filename, String dateAdded) {
        this.nameWine = nameWine;
        this.rating = rating;
        this.typeWines = typeWines;
        this.describe = describe;
        this.quantity = quantity;
        this.filename = filename;
        this.dateAdded = dateAdded;
    }

    public Wine() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameWine() {
        return nameWine;
    }

    public void setNameWine(String nameWine) {
        this.nameWine = nameWine;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getTypeWines() {
        return typeWines;
    }

    public void setTypeWines(Integer typeWines) {
        this.typeWines = typeWines;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "id=" + id +
                ", nameWine='" + nameWine + '\'' +
                ", rating=" + rating +
                ", typeWines=" + typeWines +
                ", describe='" + describe + '\'' +
                ", quantity=" + quantity +
                ", filename='" + filename + '\'' +
                ", dateAdded='" + dateAdded + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wine wine = (Wine) o;
        return Objects.equals(id, wine.id) &&
                Objects.equals(nameWine, wine.nameWine) &&
                Objects.equals(rating, wine.rating) &&
                Objects.equals(typeWines, wine.typeWines) &&
                Objects.equals(describe, wine.describe) &&
                Objects.equals(quantity, wine.quantity) &&
                Objects.equals(filename, wine.filename) &&
                Objects.equals(dateAdded, wine.dateAdded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameWine, rating, typeWines, describe, quantity, filename, dateAdded);
    }
}
