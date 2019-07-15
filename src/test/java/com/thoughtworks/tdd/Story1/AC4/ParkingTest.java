package com.thoughtworks.tdd.Story1.AC4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class ParkingTest {
    @Test
    public void should_get_a_ticker_when_park_a_car(){
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
    public void should_get_tickers_when_park_cars(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        Car car1 = new Car();
        ParkingLot parkingLot = new ParkingLot();
        //when
        Ticket ticket = parkingBoy.park(parkingLot,car);
        Ticket ticket1 = parkingBoy.park(parkingLot,car1);
        //then
        Assertions.assertEquals(2,parkingLot.getCarMap().size());
        // Assertions.assertNotNull(ticket.ticketnum);
        // Assertions.assertNotNull(ticket1.ticketnum);
    }
    @Test
    public void should_get_right_car_when_give_a_ticket(){
        //given
        HashMap<String, Car> hashMap = new HashMap<>();
        hashMap.put("num:1",new Car("粤B 99800"));
        hashMap.put("num:2",new Car("粤C 88888"));
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket("num:2");
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCarMap(hashMap);
        //when
        Car car = parkingBoy.getCar(parkingLot,ticket);
        //then
        Assertions.assertEquals("粤C 88888",car.getCarNum());
    }
    @Test
    public void should_get_null_car_when_give_a_wrong_ticket(){
        //given
        HashMap<String, Car> hashMap = new HashMap<>();
        hashMap.put("num:1",new Car("粤B 99800"));
        hashMap.put("num:2",new Car("粤C 88888"));
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket("num:3");
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCarMap(hashMap);
        //when
        Car car = parkingBoy.getCar(parkingLot,ticket);
        //then
        Assertions.assertNull(car);
    }
    @Test
    public void should_get_null_car_when_give_null(){
        //given
        HashMap<String, Car> hashMap = new HashMap<>();
        hashMap.put("num:1",new Car("粤B 99800"));
        hashMap.put("num:2",new Car("粤C 88888"));
        ParkingBoy parkingBoy = new ParkingBoy();
       // Ticket ticket = new Ticket("num:3");
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCarMap(hashMap);
        //when
        Car car = parkingBoy.getCar(parkingLot,null);
        //then
        Assertions.assertNull(car);
    }
    @Test
    public void should_get_null_car_when_give_used_ticket(){
        //given
        HashMap<String, Car> hashMap = new HashMap<>();
        hashMap.put("num:1",new Car("粤B 99800"));
        hashMap.put("num:2",new Car("粤C 88888"));
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket("num:2");
        ticket.setStatus(false);
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCarMap(hashMap);
        //when
        Car car = parkingBoy.getCar(parkingLot,ticket);
        //then
        Assertions.assertNull(car);;
    }
}
