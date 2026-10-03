package com.learning.Kafka_order_service.service;

import com.learning.Kafka_order_service.dto.request.OrderRequestDTO;
import com.learning.Kafka_order_service.dto.response.OrderResponseDTO;

public interface OrderService {

    OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO);
}
