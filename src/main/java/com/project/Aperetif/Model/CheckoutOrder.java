package com.project.Aperetif.Model;

import java.util.Objects;

public class CheckoutOrder {

    private Long id;

    private String firstName;

    private String lastName;

    private String companyName;

    private String country;

    private String StreetAddress;

    private String city;

    private String postCode;

    private String phone;

    private String email;

    public CheckoutOrder() {
    }

    public CheckoutOrder(String firstName, String lastName, String companyName, String country,
                         String streetAddress, String city, String postCode,
                         String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.country = country;
        StreetAddress = streetAddress;
        this.city = city;
        this.postCode = postCode;
        this.phone = phone;
        this.email = email;
    }

    public CheckoutOrder(Long id, String firstName, String lastName, String companyName,
                         String country, String streetAddress, String city,
                         String postCode, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.country = country;
        StreetAddress = streetAddress;
        this.city = city;
        this.postCode = postCode;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetAddress() {
        return StreetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        StreetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CheckoutOrder{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", country='" + country + '\'' +
                ", StreetAddress='" + StreetAddress + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckoutOrder that = (CheckoutOrder) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(country, that.country) &&
                Objects.equals(StreetAddress, that.StreetAddress) &&
                Objects.equals(city, that.city) &&
                Objects.equals(postCode, that.postCode) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, companyName, country, StreetAddress, city, postCode, phone, email);
    }
}
