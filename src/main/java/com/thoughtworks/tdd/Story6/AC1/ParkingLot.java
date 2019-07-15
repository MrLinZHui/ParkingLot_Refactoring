package com.thoughtworks.tdd.Story6.AC1;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLot {
    private String parkingLotName;
    private HashMap<String, Car> carMap;
    private int capacity;
    private int actualcapacity;
    private ArrayList<Ticket> ticketArrayList = new ArrayList<>();
    public int getActualcapacity() {
        return actualcapacity;
    }

    public void setActualcapacity(int actualcapacity) {
        this.actualcapacity = actualcapacity;
    }

    public ParkingLot() {
        carMap = new HashMap<>();
    }

    public ParkingLot(int capacity,int actualcapacity,String parkingLotName) {
        this.capacity = capacity;
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
            ticketArrayList.add(ticket);
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Ticket> getTicketArrayList() {
        return ticketArrayList;
    }

    public void setTicketArrayList(ArrayList<Ticket> ticketArrayList) {
        this.ticketArrayList = ticketArrayList;
    }
}
