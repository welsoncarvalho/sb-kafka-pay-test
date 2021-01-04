package com.test.payment.payment.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    private String id;
    private String card;
    private String cvv;
    private String brand;
    @Column(name = "valid_date")
    private String validDate;
    @Column(name = "created_at")
    private LocalDateTime createAt;
    @Column(name = "account_id")
    private String accountId;

    public PaymentEntity() {}

    public PaymentEntity(String card,
                         String cvv,
                         String brand,
                         String validDate,
                         String accountId) {
        this.card = card;
        this.cvv = cvv;
        this.brand = brand;
        this.validDate = validDate;
        this.accountId = accountId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
