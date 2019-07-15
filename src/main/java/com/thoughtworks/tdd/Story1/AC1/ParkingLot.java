package com.thoughtworks.tdd.Story1.AC1;

public class ParkingLot {
    public Ticket getTicket(Car car) {
        return new Ticket();
    }

    public Car getCar(Ticket ticket) {
        return new Car();
    }
}
