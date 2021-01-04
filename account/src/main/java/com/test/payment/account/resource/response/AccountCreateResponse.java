package com.test.payment.account.resource.response;

public class AccountCreateResponse {

    private String accountId;

    public AccountCreateResponse(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
