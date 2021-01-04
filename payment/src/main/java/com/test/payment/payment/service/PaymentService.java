package com.test.payment.payment.service;

import com.test.payment.payment.enums.AccountStatus;
import com.test.payment.payment.model.Account;
import com.test.payment.payment.model.Payment;
import com.test.payment.payment.persistence.entity.PaymentEntity;
import com.test.payment.payment.persistence.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final AccountService accountService;

    public PaymentService(PaymentRepository paymentRepository,
                          AccountService accountService) {
        this.paymentRepository = paymentRepository;
        this.accountService = accountService;
    }

    public void create(Payment payment) {
        if (payment.getCard() != null) {

            PaymentEntity paymentEntity = payment.toEntity();
            paymentEntity.setId(UUID.randomUUID().toString());
            paymentEntity.setCreateAt(LocalDateTime.now());
            paymentEntity.setAccountId(payment.getAccountId());

            paymentRepository.save(paymentEntity);

            // update account status
            this.accountService.publishStatus(
                    buildAccountStatus(payment.getAccountId(), AccountStatus.SUCCESS, null));

        } else {

            this.accountService.publishStatus(
                    buildAccountStatus(payment.getAccountId(), AccountStatus.ERROR, "Payment data required"));
        }
    }

    private Account buildAccountStatus(String accountId, AccountStatus status, String message) {
        Account account = new Account();

        account.setAccountId(accountId);
        account.setStatus(status);
        account.setErrorMessage(message);

        return account;
    }
}
