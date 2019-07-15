package com.thoughtworks.tdd.Story6.AC1;

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
