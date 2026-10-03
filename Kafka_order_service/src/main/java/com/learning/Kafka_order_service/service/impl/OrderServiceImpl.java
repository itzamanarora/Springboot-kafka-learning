package com.learning.Kafka_order_service.service.impl;

import com.learning.Kafka_order_service.dto.request.OrderRequestDTO;
import com.learning.Kafka_order_service.dto.response.OrderResponseDTO;
import com.learning.Kafka_order_service.kafka.OrderCreatedEvent;
import com.learning.Kafka_order_service.kafka.OrderEventProducer;
import com.learning.Kafka_order_service.mapper.OrderDTOMapper;
import com.learning.Kafka_order_service.model.Order;
import com.learning.Kafka_order_service.repository.OrderRepository;
import com.learning.Kafka_order_service.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderEventProducer orderEventProducer;

    public OrderServiceImpl(OrderRepository orderRepository, OrderEventProducer orderEventProducer) {
        this.orderEventProducer = orderEventProducer;
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        Order order = OrderDTOMapper.mapToOrder(orderRequestDTO);
        Order savedOrder = orderRepository.save(order);

        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent(
                savedOrder.getId(),
                savedOrder.getProductName(),
                savedOrder.getUsername(),
                savedOrder.getQuantity(),
                savedOrder.getPrice()
        );
        orderEventProducer.publishOrderCreatedEvent(orderCreatedEvent);
        return OrderDTOMapper.mapToOrderResponseDTO(savedOrder);
    }
}
