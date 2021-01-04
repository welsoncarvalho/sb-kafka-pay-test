package com.test.payment.account.resource;

import com.test.payment.account.model.Account;
import com.test.payment.account.resource.response.AccountCreateResponse;
import com.test.payment.account.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class AccountResource {

    private final AccountService accountService;

    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public AccountCreateResponse create(@RequestBody Account account) {
        String accountId = accountService.create(account);
        return new AccountCreateResponse(accountId);
    }

}
