package com.thoughtworks.tdd.Story5.AC1;

import java.util.ArrayList;
import java.util.Optional;

public class SmartParkingBoy extends ParkingBoy {
    @Override
    public Ticket park(ArrayList<ParkingLot> arrayList, Car car) {
      Optional <ParkingLot> parkingLot = arrayList.stream().reduce((parkinglot1, parkinglot2) ->
              (parkinglot1.getCapacity() -parkinglot1.getActualcapacity())>(parkinglot2.getCapacity()-parkinglot2.getActualcapacity())?parkinglot1:parkinglot2);
      ParkingLot parkingLot1 =  parkingLot.get();
      System.out.print(String.format(parkingLot1.getParkingLotName(),"\n"));
      return parkingLot1.park(car);
    }
}
