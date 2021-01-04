package com.test.payment.account.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

//@Configuration
public class TopicConfig {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Value("${kafka.topic.account-status}")
    private String accountStatusTopic;

    @Value("${kafka.topic.payment}")
    private String paymentTopic;

    public KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic newAccountStatusTopic() {
        return TopicBuilder.name(accountStatusTopic)
                .partitions(2)
                .replicas(2)
                .compact()
                .build();
    }

    @Bean
    public NewTopic newPaymentTopic() {
        return TopicBuilder.name(paymentTopic)
                .partitions(2)
                .replicas(2)
                .compact()
                .build();
    }
}
