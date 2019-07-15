package com.thoughtworks.tdd.Story6.AC1;

import java.util.ArrayList;
import java.util.Optional;

public class ParkingBoy {
    private static final String NOT_ENOUGH_POSITION = "Not enough position.";
    private static final String PLEASE_PROVIDE_YOUR_PARKING_TICKET = "Please provide your parking ticket.";
    private static final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized parking ticket.";
    private ArrayList<ParkingLot> parkingLotArrayList;

    public ParkingBoy() {
        this.parkingLotArrayList = new ArrayList<>();
    }

    public ArrayList<ParkingLot> getParkingLotArrayList() {
        return parkingLotArrayList;
    }

    public void setParkingLotArrayList(ArrayList<ParkingLot> parkingLotArrayList) {
        this.parkingLotArrayList = parkingLotArrayList;
    }

    public Ticket park(ArrayList<ParkingLot> parkingLotsarrayList, Car car) {
        Ticket ticket  = null;
        for(ParkingLot parkingLot: parkingLotsarrayList){
            ticket = parkingLot.park(car);
            if(ticket!=null){
                break;
            }
        }
        if(ticket==null){
            System.out.print(NOT_ENOUGH_POSITION + "\n");
        }
        return ticket;
    }

    public Car getCar(ParkingLot parkingLot, Ticket ticket) {
        return parkingLot.getCar(ticket);
    }

    public void recognizedticket(Ticket ticket) {
        if(ticket==null){
            System.out.print(PLEASE_PROVIDE_YOUR_PARKING_TICKET + "\n");
        }
        else if(!ticket.isStatus()){
            System.out.print(UNRECOGNIZED_PARKING_TICKET + "\n");
        }
    }
}
