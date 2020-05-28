package com.project.Aperetif.Model;

import java.util.Objects;

public class FavoriteWIne {

    private Long id;

    private Long idWine;

    private Long idUser;

    private String dateAdded;

    public FavoriteWIne(Long id, Long idWine, Long idUser, String dateAdded) {
        this.id = id;
        this.idWine = idWine;
        this.idUser = idUser;
        this.dateAdded = dateAdded;
    }

    public FavoriteWIne(Long idWine, Long idUser, String dateAdded) {
        this.idWine = idWine;
        this.idUser = idUser;
        this.dateAdded = dateAdded;
    }

    public FavoriteWIne() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdWine() {
        return idWine;
    }

    public void setIdWine(Long idWine) {
        this.idWine = idWine;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "FavoriteWIne{" +
                "id=" + id +
                ", idWine=" + idWine +
                ", idUser=" + idUser +
                ", dateAdded='" + dateAdded + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoriteWIne that = (FavoriteWIne) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(idWine, that.idWine) &&
                Objects.equals(idUser, that.idUser) &&
                Objects.equals(dateAdded, that.dateAdded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idWine, idUser, dateAdded);
    }
}
