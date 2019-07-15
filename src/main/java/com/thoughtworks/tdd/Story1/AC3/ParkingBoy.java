package com.thoughtworks.tdd.Story1.AC3;

public class ParkingBoy {
    public Ticket park(ParkingLot parkingLot, Car car) {
        return parkingLot.park(car);
    }

    public Car getCar(ParkingLot parkingLot, Ticket ticket) {
        return parkingLot.getCar(ticket);
    }
}
