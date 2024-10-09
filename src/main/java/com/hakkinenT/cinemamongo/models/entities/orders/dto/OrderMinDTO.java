package com.hakkinenT.cinemamongo.models.entities.orders.dto;

import java.util.*;

import com.hakkinenT.cinemamongo.models.entities.orders.Order;
import com.hakkinenT.cinemamongo.models.entities.orders.embedded.Payment;
import com.hakkinenT.cinemamongo.models.entities.orders.embedded.Ticket;

public class OrderMinDTO {
    private String userEmail;
    private Payment payment;
    private List<Ticket> tickets = new ArrayList<>();
    
    public OrderMinDTO() {
    }

    public OrderMinDTO(String userEmail, Payment payment, List<Ticket> tickets) {
        this.userEmail = userEmail;
        this.payment = payment;
        this.tickets = tickets;
    }

    public OrderMinDTO(Order entity) {
        this.userEmail = entity.getUserEmail();
        this.payment = entity.getPayment();
        this.tickets = entity.getTickets();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
