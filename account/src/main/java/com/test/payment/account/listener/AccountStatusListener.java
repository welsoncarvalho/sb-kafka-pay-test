package com.test.payment.account.listener;

import com.test.payment.account.model.Status;
import com.test.payment.account.service.AccountService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class AccountStatusListener {

    private final AccountService accountService;

    public AccountStatusListener(AccountService accountService) {
        this.accountService = accountService;
    }

    @KafkaListener(
            topics = "${kafka.topic.account-status}",
            groupId = "account",
            containerFactory = "accountKafkaListenerCF"
    )
    public void createListener(
            @Payload Status status,
            @Headers MessageHeaders headers) {
        accountService.updateStatus(status);
    }
}
