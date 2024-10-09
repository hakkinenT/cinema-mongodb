package com.hakkinenT.cinemamongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hakkinenT.cinemamongo.models.entities.orders.Order;
import com.hakkinenT.cinemamongo.models.entities.orders.dto.TicketDTO;
import com.hakkinenT.cinemamongo.models.entities.orders.embedded.Ticket;
import com.hakkinenT.cinemamongo.repositories.OrderRepository;

import java.util.*;

@Service
public class TicketService {
    @Autowired
    private OrderRepository orderRepository;

    public List<TicketDTO> findTicketsByOrderId(String id) {
        Order order = orderRepository.searchTicketsByOrderId(id);
        List<TicketDTO> tickets = new ArrayList<>();
        for(Ticket t : order.getTickets()){
            tickets.add(new TicketDTO(t));
        }
        
        return tickets;
    }

}
