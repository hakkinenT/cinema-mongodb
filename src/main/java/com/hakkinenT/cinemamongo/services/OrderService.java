package com.hakkinenT.cinemamongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hakkinenT.cinemamongo.exceptions.customs.ResourceNotFoundException;
import com.hakkinenT.cinemamongo.models.entities.orders.Order;
import com.hakkinenT.cinemamongo.models.entities.orders.dto.OrderDTO;
import com.hakkinenT.cinemamongo.models.entities.orders.dto.OrderMinDTO;
import com.hakkinenT.cinemamongo.models.entities.orders.embedded.Ticket;
import com.hakkinenT.cinemamongo.repositories.OrderRepository;

import java.time.*;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderDTO findById(String id) {
        Order order = orderRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        
        return new OrderDTO(order);
    }

    public OrderDTO insert(OrderMinDTO dto){
        Order order = createOrder(dto);

        order = orderRepository.insert(order);

        return new OrderDTO(order);
    }

    private Order createOrder(OrderMinDTO dto) {
        Order order = new Order();

        order.setMoment(Instant.now());
        order.setPayment(dto.getPayment());
        order.setUserEmail(dto.getUserEmail());

        double total = calculateOrderTotal(dto);
        order.setTotal(total);

        addTickets(dto, order);

        return order;
    }

    private double calculateOrderTotal(OrderMinDTO dto) {
        return dto.getTickets()
                .stream()
                .map(ticket -> ticket.getTicketValue())
                .reduce(0.0, Double::sum);
    }

    private void addTickets(OrderMinDTO dto, Order order) {
        order.getTickets().clear();
        for(Ticket t : dto.getTickets()){
            order.addTicket(t);
        }
    }

    public void delete(String id){
        if(!orderRepository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }

        orderRepository.deleteById(id);
    }
}
