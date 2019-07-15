package com.thoughtworks.tdd.Story1.AC3;

import java.util.HashMap;

public class ParkingLot {
    private HashMap<String, Car> carMap;
    public ParkingLot() {
        carMap = new HashMap<>();
    }

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        carMap.put(ticket.getTicketnum(),car);
        return ticket;
    }

    public Car getCar(Ticket ticket) {
        if(ticket==null||!carMap.containsKey(ticket.getTicketnum())||!ticket.isStatus()){
            return null;
        }
        Car car = carMap.get(ticket.getTicketnum());
        carMap.remove(ticket.getTicketnum());
        return car;
    }

    public HashMap<String , Car> getCarMap() {
        return carMap;
    }

    public void setCarMap(HashMap<String, Car> carMap) {
        this.carMap = carMap;
    }
}
