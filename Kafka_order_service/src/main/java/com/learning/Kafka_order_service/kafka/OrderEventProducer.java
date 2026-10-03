package com.learning.Kafka_order_service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderEventProducer {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public OrderEventProducer(KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishOrderCreatedEvent(OrderCreatedEvent orderCreatedEvent) {
        log.info("Publishing order created event: {}", orderCreatedEvent);
        kafkaTemplate.send(
                "order-events",
                orderCreatedEvent.getOrderId().toString(),
                orderCreatedEvent
        );
    }
}
