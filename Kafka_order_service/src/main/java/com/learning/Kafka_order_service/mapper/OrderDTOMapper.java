package com.learning.Kafka_order_service.mapper;

import com.learning.Kafka_order_service.dto.request.OrderRequestDTO;
import com.learning.Kafka_order_service.dto.response.OrderResponseDTO;
import com.learning.Kafka_order_service.model.Order;

public class OrderDTOMapper {

    public static OrderResponseDTO mapToOrderResponseDTO(Order order) {
        return OrderResponseDTO.builder()
                .id(order.getId())
                .productName(order.getProductName())
                .quantity(order.getQuantity())
                .price(order.getPrice())
                .username(order.getUsername())
                .createdAt(order.getCreatedAt())
                .build();
    }

    public static Order mapToOrder(OrderRequestDTO orderRequestDTO) {
        return Order.builder()
                .productName(orderRequestDTO.getProductName())
                .quantity(orderRequestDTO.getQuantity())
                .price(orderRequestDTO.getPrice())
                .username(orderRequestDTO.getUsername())
                .build();
    }
}
