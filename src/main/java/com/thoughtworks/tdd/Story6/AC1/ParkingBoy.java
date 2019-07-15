package com.thoughtworks.tdd.Story6.AC1;

import java.util.ArrayList;
import java.util.Optional;

public class ParkingBoy {
    private static final String NOT_ENOUGH_POSITION = "Not enough position.";
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
//        for(int i = 0;i<parkingLotsarrayList.size();i++){
//            ticket= parkingLotsarrayList.get(i).park(car);
//            if(ticket!=null){
//                break;
//            }
//        }
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
            System.out.print("Please provide your parking ticket.\n");
        }
        else if(!ticket.isStatus()){
            System.out.print("Unrecognized parking ticket.\n");
        }
    }
}
