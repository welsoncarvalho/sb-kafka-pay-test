package com.test.payment.payment.service;

import com.test.payment.payment.model.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class AccountService {

    private final KafkaTemplate<String, Account> accountKafkaTemplate;
    private final String accountStatusTopic;

    public AccountService(KafkaTemplate<String, Account> accountKafkaTemplate,
                          @Value("${kafka.topic.account-status}") String accountStatusTopic) {
        this.accountKafkaTemplate = accountKafkaTemplate;
        this.accountStatusTopic = accountStatusTopic;
    }

    public void publishStatus(Account account) {
        Message<Account> message = MessageBuilder
                .withPayload(account)
                .setHeader(KafkaHeaders.TOPIC, accountStatusTopic)
                .build();

        ListenableFuture<SendResult<String, Account>> future = accountKafkaTemplate.send(message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Account>>() {

            @Override
            public void onSuccess(SendResult<String, Account> result) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + message + "] due to : " + ex.getMessage());
            }
        });
    }
}
