package com.thoughtworks.tdd.Story1.AC1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingTest {
    @Test
    public void should_get_ticker_when_park_a_car(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        //when
        Ticket ticket = parkingBoy.park(parkingLot,car);
        //then
        Assertions.assertNotNull(ticket);
    }
    @Test
    public void should_get_car_when_git_a_car(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket();
        ParkingLot parkingLot = new ParkingLot();
        //when
        Car car = parkingBoy.getCar(parkingLot,ticket);
        //then
        Assertions.assertNotNull(car);
    }
}
