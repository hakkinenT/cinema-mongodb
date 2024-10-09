package com.hakkinenT.cinemamongo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hakkinenT.cinemamongo.models.entities.orders.dto.OrderDTO;
import com.hakkinenT.cinemamongo.models.entities.orders.dto.OrderMinDTO;
import com.hakkinenT.cinemamongo.models.entities.orders.dto.TicketDTO;
import com.hakkinenT.cinemamongo.services.OrderService;
import com.hakkinenT.cinemamongo.services.TicketService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private TicketService ticketService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable String id) {
        OrderDTO orderDTO = orderService.findById(id);
        return ResponseEntity.ok(orderDTO);
    }
    
    @GetMapping("/{id}/tickets")
    public ResponseEntity<List<TicketDTO>> findTicketsByOrderId(@PathVariable String id) {
        List<TicketDTO> tickets = ticketService.findTicketsByOrderId(id);
        return ResponseEntity.ok(tickets);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderMinDTO dto){
        OrderDTO order = orderService.insert(dto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(order.getId())
                .toUri();

        return ResponseEntity.created(uri).body(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
