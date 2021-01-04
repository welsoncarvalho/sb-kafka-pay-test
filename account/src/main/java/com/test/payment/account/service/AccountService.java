package com.test.payment.account.service;

import com.test.payment.account.enums.AccountStatus;
import com.test.payment.account.model.Account;
import com.test.payment.account.model.Status;
import com.test.payment.account.persistence.entity.AccountEntity;
import com.test.payment.account.persistence.entity.AddressEntity;
import com.test.payment.account.persistence.repository.AccountRepository;
import com.test.payment.account.persistence.repository.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AddressRepository addressRepository;

    private final PaymentService paymentService;

    public AccountService(AccountRepository accountRepository,
                          AddressRepository addressRepository,
                          PaymentService paymentService) {
        this.accountRepository = accountRepository;
        this.addressRepository = addressRepository;
        this.paymentService = paymentService;
    }

    public String create(Account account) {
        AccountEntity accountEntity = account.toAccountEntity();

        accountEntity.setId(UUID.randomUUID().toString());
        accountEntity.setStatus(AccountStatus.CREATE);
        accountEntity.setCreatedAt(LocalDateTime.now());

        accountEntity = accountRepository.save(accountEntity);

        createAddress(account, accountEntity.getId());
        createPayment(account, accountEntity.getId());

        return accountEntity.getId();
    }

    private void createAddress(Account account, String accountId) {
        AddressEntity addressEntity = account.toAddressEntity();

        addressEntity.setAccountId(accountId);
        addressEntity.setId(UUID.randomUUID().toString());
        addressEntity.setCreatedAt(LocalDateTime.now());

        addressRepository.save(addressEntity);
    }

    private void createPayment(Account account, String accountId) {
        paymentService.publishPayment(account, accountId);
    }

    @Transactional
    public void updateStatus(Status status) {
        String errorId = null;

        if (AccountStatus.ERROR.equals(status.getStatus())) {
            errorId = UUID.randomUUID().toString();
        }

        accountRepository.updateStatus(status.getAccountId(), status.getStatus(), errorId);

        // FIXME: Send to error service
    }
}
