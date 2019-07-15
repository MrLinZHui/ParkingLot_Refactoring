package com.thoughtworks.tdd.Story3.AC1;

import java.util.ArrayList;

public class ParkingBoy {
    public Ticket park(ArrayList<ParkingLot> arrayList, Car car) {
//        arrayList.forEach(parkingLot ->{
//            Ticket ticket =parkingLot.park(car);
//            if(ticket!=null){
//                return;
//            }
//        });
        Ticket ticket  = null;
        for(int i = 0;i<arrayList.size();i++){
            ticket= arrayList.get(i).park(car);
            if(ticket!=null){
                break;
            }
        }
        if(ticket==null){
            System.out.print( "Not enough position.\n");
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
