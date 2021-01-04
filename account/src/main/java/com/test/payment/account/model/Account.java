package com.test.payment.account.model;

import com.test.payment.account.persistence.entity.AccountEntity;
import com.test.payment.account.persistence.entity.AddressEntity;

public class Account {

    private String name;

    private String email;

    private String password;

    private String address;

    private String city;

    private String state;

    private String zipCode;

    private String card;

    private String cvv;

    private String brand;

    private String validDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public AccountEntity toAccountEntity() {
        return new AccountEntity(this.name, this.email, this.password);
    }

    public AddressEntity toAddressEntity() {
        return new AddressEntity(this.address, this.city, this.state, this.zipCode, 1);
    }
}
