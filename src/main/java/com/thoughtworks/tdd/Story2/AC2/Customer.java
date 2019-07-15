package com.thoughtworks.tdd.Story2.AC2;

public class Customer {
    private Ticket ticket;

    public Customer(Ticket ticket) {
        this.ticket = ticket;
    }

    public Customer() {
        this.ticket = null;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
