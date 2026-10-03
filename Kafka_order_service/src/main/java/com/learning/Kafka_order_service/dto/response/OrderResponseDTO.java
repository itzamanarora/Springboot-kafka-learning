package com.learning.Kafka_order_service.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDTO {
    private UUID id;
    private String productName;
    private int quantity;
    private BigDecimal price;
    private String username;
    private Instant createdAt;
}
