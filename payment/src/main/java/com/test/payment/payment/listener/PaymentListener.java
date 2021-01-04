package com.test.payment.payment.listener;

import com.test.payment.payment.model.Payment;
import com.test.payment.payment.service.PaymentService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PaymentListener {

    private final PaymentService paymentService;

    public PaymentListener(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @KafkaListener(
            topics = "${kafka.topic.payment}",
            groupId = "payment",
            containerFactory = "paymentKafkaListenerCF"
    )
    public void createListener(
            @Payload Payment payment,
            @Headers MessageHeaders headers) {
        paymentService.create(payment);
    }

}
