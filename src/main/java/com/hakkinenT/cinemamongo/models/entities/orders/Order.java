package com.hakkinenT.cinemamongo.models.entities.orders;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hakkinenT.cinemamongo.models.entities.orders.embedded.Payment;
import com.hakkinenT.cinemamongo.models.entities.orders.embedded.Ticket;

@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private Instant moment;
    private String userEmail;
    private Double total;
    private Payment payment;
    private List<Ticket> tickets = new ArrayList<>();
    
    public Order() {
    }

    public Order(String id, Instant moment, String userEmail, Double total, Payment payment, List<Ticket> tickets) {
        this.id = id;
        this.moment = moment;
        this.userEmail = userEmail;
        this.total = total;
        this.payment = payment;
        this.tickets = tickets;
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

    public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}