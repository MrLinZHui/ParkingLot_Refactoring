package com.thoughtworks.tdd.Story5.AC1;

public class Ticket {
    private String ticketnum;
    static int num = 1;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Ticket() {
        this.ticketnum = "num:" + num;
        num ++;
        status = true;
    }

    public Ticket(String ticketnum) {
        this.ticketnum = ticketnum;
        status = true;
    }

    public String getTicketnum() {
        return ticketnum;
    }

    public void setTicketnum(String ticketnum) {
        this.ticketnum = ticketnum;
    }

    @Override
    public boolean equals(Object obj) {
        Ticket ticket = (Ticket)obj;
        return this.ticketnum.equals(((Ticket) obj).getTicketnum());
    }
}
