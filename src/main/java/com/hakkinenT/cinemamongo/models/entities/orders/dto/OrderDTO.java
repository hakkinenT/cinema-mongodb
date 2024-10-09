package com.hakkinenT.cinemamongo.models.entities.orders.dto;

import java.time.*;
import java.util.*;

import com.hakkinenT.cinemamongo.models.entities.orders.Order;
import com.hakkinenT.cinemamongo.models.entities.orders.embedded.Payment;
import com.hakkinenT.cinemamongo.models.entities.orders.embedded.Ticket;

public class OrderDTO {
    private String id;
    private Instant moment;
    private String userEmail;
    private Double total;
    private Payment payment;
    private List<Ticket> tickets = new ArrayList<>();
    
    public OrderDTO() {
    }

    public OrderDTO(String id, Instant moment, String userEmail, Double total, Payment payment, List<Ticket> tickets) {
        this.id = id;
        this.moment = moment;
        this.userEmail = userEmail;
        this.total = total;
        this.payment = payment;
        this.tickets = tickets;
    }

    public OrderDTO(Order entity) {
        this.id = entity.getId();
        this.moment = entity.getMoment();
        this.userEmail = entity.getUserEmail();
        this.total = entity.getTotal();
        this.payment = entity.getPayment();
        this.tickets = entity.getTickets();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    
}
