package com.thoughtworks.tdd.Story6.AC1;

import java.util.ArrayList;
import java.util.Optional;

public class SupSmartParkingBoy extends ParkingBoy {
    @Override
    public Ticket park(ArrayList<ParkingLot> arrayList, Car car) {
        Optional<ParkingLot> parkingLot = arrayList.stream().reduce((parkinglot1, parkinglot2) ->
                ( (double)parkinglot1.getActualcapacity()/parkinglot1.getCapacity())<((double)parkinglot2.getActualcapacity()/parkinglot2.getCapacity())?parkinglot1:parkinglot2);

        ParkingLot parkingLot1 =  parkingLot.get();
        System.out.print(String.format(parkingLot1.getParkingLotName(),"\n"));
        return parkingLot1.park(car);
    }
}
