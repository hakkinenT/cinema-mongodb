package com.hakkinenT.cinemamongo.models.entities.orders.embedded;

import com.hakkinenT.cinemamongo.models.entities.orders.enums.TicketType;

public class Ticket {
    private Session session;
    private String seatCode;
    private TicketType ticketType;
    private Double ticketValue;
    
    public Ticket() {
    }

    public Ticket(Session session, String seatCode, TicketType ticketType,
            Double ticketValue) {
        this.session = session;
        this.seatCode = seatCode;
        this.ticketType = ticketType;
        this.ticketValue = ticketValue;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Double getTicketValue() {
        return ticketValue;
    }

    public void setTicketValue(Double ticketValue) {
        this.ticketValue = ticketValue;
    }
    
}
