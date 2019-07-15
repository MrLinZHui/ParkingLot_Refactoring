package com.thoughtworks.tdd.Story4.AC1;

import java.util.HashMap;

public class ParkingLot {
    private String parkingLotName;
    private HashMap<String, Car> carMap;
    private final int capacity = 10;
    private int actualcapacity;

    public int getActualcapacity() {
        return actualcapacity;
    }

    public void setActualcapacity(int actualcapacity) {
        this.actualcapacity = actualcapacity;
    }

    public ParkingLot() {
        carMap = new HashMap<>();
    }

    public ParkingLot(int actualcapacity,String parkingLotName) {
        this.parkingLotName = parkingLotName;
        this.actualcapacity = actualcapacity;
        carMap = new HashMap<>();
    }

    public Ticket park(Car car) {
        if(car ==null){
          throw  new RuntimeException();
        }
        if(!car.isCarparkstatus()){
            throw  new RuntimeException();
        }
        if(actualcapacity<capacity) {
            Ticket ticket = new Ticket();
            carMap.put(ticket.getTicketnum(), car);
            actualcapacity++;
            car.setCarparkstatus(false);
            return ticket;
        }

        return null;
    }

    public Car getCar(Ticket ticket) {
        if(ticket==null||!carMap.containsKey(ticket.getTicketnum())||!ticket.isStatus()){
            return null;
        }
        Car car = carMap.get(ticket.getTicketnum());
        carMap.remove(ticket.getTicketnum());
        actualcapacity--;
        return car;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public HashMap<String , Car> getCarMap() {
        return carMap;
    }

    public void setCarMap(HashMap<String, Car> carMap) {
        this.carMap = carMap;
    }
}
