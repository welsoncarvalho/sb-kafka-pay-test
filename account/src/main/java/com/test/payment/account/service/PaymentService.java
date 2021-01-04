package com.test.payment.account.service;

import com.test.payment.account.model.Account;
import com.test.payment.account.model.Payment;
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
public class PaymentService {

    private final KafkaTemplate<String, Payment> paymentKafkaTemplate;
    private final String paymentTopic;

    public PaymentService (KafkaTemplate<String, Payment> paymentKafkaTemplate,
                           @Value("${kafka.topic.payment}") String paymentTopic) {
        this.paymentKafkaTemplate = paymentKafkaTemplate;
        this.paymentTopic = paymentTopic;
    }

    public void publishPayment(Account account, String accountId) {
        Payment payment = new Payment(
                accountId,
                account.getCard(),
                account.getCvv(),
                account.getBrand(),
                account.getValidDate()
        );

        Message message = MessageBuilder
                .withPayload(payment)
                .setHeader(KafkaHeaders.TOPIC, paymentTopic)
                .build();

        ListenableFuture<SendResult<String, Payment>> future = paymentKafkaTemplate.send(message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Payment>>() {

            @Override
            public void onSuccess(SendResult<String, Payment> result) {
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
