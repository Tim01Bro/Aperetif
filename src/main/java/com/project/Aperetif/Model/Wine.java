package com.project.Aperetif.Model;

import java.util.Objects;

public class Wine {

    private Long id;

    private String nameWine;

    private Integer rating;

    private Integer typeWines;

    private String describe;

    private Integer quantity;

    private String filename;

    private String dateAdded;

    private Integer price;


    public Wine(Long id, String nameWine, Integer rating, Integer typeWines,
                String describe, Integer quantity, String filename, String dateAdded, Integer price) {
        this.id = id;
        this.nameWine = nameWine;
        this.rating = rating;
        this.typeWines = typeWines;
        this.describe = describe;
        this.quantity = quantity;
        this.filename = filename;
        this.dateAdded = dateAdded;
        this.price = price;
    }

    public Wine(String nameWine, Integer rating, Integer typeWines, String describe,
                Integer quantity, String filename, String dateAdded, Integer price) {
        this.nameWine = nameWine;
        this.rating = rating;
        this.typeWines = typeWines;
        this.describe = describe;
        this.quantity = quantity;
        this.filename = filename;
        this.dateAdded = dateAdded;
        this.price = price;
    }

    public Wine() {
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
                ", price='" + price + '\'' +
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
                Objects.equals(dateAdded, wine.dateAdded) &&
                Objects.equals(price, wine.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameWine, rating, typeWines, describe, quantity, filename, dateAdded, price);
    }
}
