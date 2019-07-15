package com.thoughtworks.tdd.Story1.AC1;

public class ParkingBoy {
    public Ticket park(ParkingLot parkingLot, Car car) {
        return parkingLot.getTicket(car);
    }

    public Car getCar(ParkingLot parkingLot, Ticket ticket) {
        return parkingLot.getCar(ticket);
    }
}
