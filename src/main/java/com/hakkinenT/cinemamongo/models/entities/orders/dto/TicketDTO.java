package com.hakkinenT.cinemamongo.models.entities.orders.dto;

import com.hakkinenT.cinemamongo.models.entities.orders.embedded.Session;
import com.hakkinenT.cinemamongo.models.entities.orders.embedded.Ticket;
import com.hakkinenT.cinemamongo.models.entities.orders.enums.TicketType;

public class TicketDTO {
    private Session session;
    private String seatCode;
    private TicketType ticketType;
    private Double ticketValue;
    
    public TicketDTO() {
    }

    public TicketDTO(Session session, String seatCode, TicketType ticketType, Double ticketValue) {
        this.session = session;
        this.seatCode = seatCode;
        this.ticketType = ticketType;
        this.ticketValue = ticketValue;
    }

    public TicketDTO(Ticket entity) {
        this.session = entity.getSession();
        this.seatCode = entity.getSeatCode();
        this.ticketType = entity.getTicketType();
        this.ticketValue = entity.getTicketValue();
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
