package com.test.payment.account.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    private String id;

    private String address;

    private String city;

    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    private Integer main;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "account_id")
    private String accountId;

    public AddressEntity() {}

    public AddressEntity(String address, String city, String state, String zipCode, Integer main) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.main = main;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getMain() {
        return main;
    }

    public void setMain(Integer main) {
        this.main = main;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
