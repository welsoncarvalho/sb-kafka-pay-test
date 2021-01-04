package com.test.payment.account.model;

public class Payment {

    private String accountId;
    private String card;
    private String cvv;
    private String brand;
    private String validDate;

    public Payment(String accountId,
                   String card,
                   String cvv,
                   String brand,
                   String validDate) {
        this.accountId = accountId;
        this.card = card;
        this.cvv = cvv;
        this.brand = brand;
        this.validDate = validDate;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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
}
