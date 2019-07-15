package com.thoughtworks.tdd.Story6.AC1;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

//import static org.fest.assertions.api.Assertions.assertThat;
public class ParkingTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void should_get_a_ticker_when_park_a_car(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car("粤B 888888");
        ParkingLot parkingLot = new ParkingLot(10,0,"Lot1");
        ArrayList<ParkingLot> arrayList = new ArrayList<>();
        arrayList.add(parkingLot);
        //when
        Ticket ticket = parkingBoy.park(arrayList,car);
        //then
        Assertions.assertNotNull(ticket);
    }
    @Test
    public void should_get_tickers_when_park_cars(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car("粤B 888888");
        Car car1 = new Car("粤B 888888");
        ParkingLot parkingLot = new ParkingLot(10,8,"Lot1");
        ArrayList<ParkingLot> arrayList = new ArrayList<>();
        arrayList.add(parkingLot);
        //when
        Ticket ticket = parkingBoy.park(arrayList,car);
        Ticket ticket1 = parkingBoy.park(arrayList,car1);
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
    @Test
    public void should_get_null_when_capacity_is_full(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car("粤B 66666");
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setActualcapacity(10);
        ArrayList<ParkingLot> arrayList = new ArrayList<>();
        arrayList.add(parkingLot);
        //when
        Ticket ticket = parkingBoy.park(arrayList,car);
        //then
        Assertions.assertNull(ticket);
    }
    @Test
    public void should_failed_when_pass_null_car_to_parking_boy(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = null;
        ParkingLot parkingLot = new ParkingLot();
        ArrayList<ParkingLot> arrayList = new ArrayList<>();
        arrayList.add(parkingLot);
        //when+then
        Assertions.assertThrows(RuntimeException.class, () ->{
            parkingBoy.park(arrayList,car);
        });
    }
    @Test
    public void should_failed_when_pass_a_passed_car_to_parking_boy(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car("粤B 666666");
        ParkingLot parkingLot = new ParkingLot(10,0,"Lot1");
        ArrayList<ParkingLot> arrayList = new ArrayList<>();
        arrayList.add(parkingLot);
        parkingBoy.park(arrayList,car);
        //when+then
        Assertions.assertThrows(RuntimeException.class, () ->{
            parkingBoy.park(arrayList,car);
        });
    }
    @Test
    public void should_response_message_when_give_a_used_ticket(){
        //given
        Customer customer = new Customer( new Ticket("num:2"));
        ParkingBoy parkingBoy = new ParkingBoy();
        customer.getTicket().setStatus(false);
        ParkingLot parkingLot = new ParkingLot();
        //when
        parkingBoy.recognizedticket(customer.getTicket());
//        //then
        Assertions.assertEquals( "Unrecognized parking ticket.\n",systemOut());
//        Assertions.assertEquals("粤C 88888",car.getCarNum());
    }
    @Test
    public void should_response_message_when_do_not_give_a_ticket(){
        //given
        Customer customer = new Customer(null);
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when
        parkingBoy.recognizedticket(customer.getTicket());
//        //then
        Assertions.assertEquals( "Please provide your parking ticket.\n",systemOut());
//        Assertions.assertEquals("粤C 88888",car.getCarNum());
    }
    @Test
    public void should_response_message__when_capacity_is_full(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car("粤B 66666");
        ArrayList<ParkingLot> arrayList = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setActualcapacity(10);
        arrayList.add(parkingLot);
        //when
        parkingBoy.park(arrayList,car);
        //then
        Assertions.assertEquals( "Not enough position.\n",systemOut());
    }
    @Test
    public void should_park_second_when_fisrt_capacity_is_full(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car("粤B 66666");
        ParkingLot parkingLot = new ParkingLot(10,10,"Lot1");
      //  parkingLot.setActualcapacity(10);
        ParkingLot parkingLot1 = new ParkingLot(10,1,"Lot2");
        ArrayList<ParkingLot> arrayList = new ArrayList<>();
        arrayList.add(parkingLot);
        arrayList.add(parkingLot1);
        //when
        Ticket ticket = parkingBoy.park(arrayList,car);
        //then
        // Assertions.assertEquals( "Not enough position.\n",systemOut());
        Assertions.assertNotNull(ticket);
    }
    @Test
    public void should_park_smart_when_smart_parkingboy_to_smart(){
        //given
       // ParkingBoy parkingBoy = new ParkingBoy();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        Car car = new Car("粤B 66666");
        ParkingLot parkingLot = new ParkingLot(20,1,"Lot1");
        ParkingLot parkingLot1 = new ParkingLot(38,2,"Lot2");
        ParkingLot parkingLot2 = new ParkingLot(35,3,"Lot3");
        ArrayList<ParkingLot> arrayList = new ArrayList<>();
        arrayList.add(parkingLot);
        arrayList.add(parkingLot1);
        arrayList.add(parkingLot2);
        //when
        smartParkingBoy.park(arrayList,car);
        //then
        // Assertions.assertEquals( "Not enough position.\n",systemOut());
        Assertions.assertEquals( "Lot2",systemOut());
    }
    @Test
    public void should_park_smart_when_sup_smart_parkingboy_to_smart(){
        //given
       // ParkingBoy parkingBoy = new ParkingBoy();
        SupSmartParkingBoy smartParkingBoy = new SupSmartParkingBoy();
        Car car = new Car("粤B 66666");
        ParkingLot parkingLot = new ParkingLot(20,1,"Lot1");
        ParkingLot parkingLot1 = new ParkingLot(30,2,"Lot2");
        ParkingLot parkingLot2 = new ParkingLot(35,3,"Lot3");
        ArrayList<ParkingLot> arrayList = new ArrayList<>();
        arrayList.add(parkingLot);
        arrayList.add(parkingLot1);
        arrayList.add(parkingLot2);
        //when
        smartParkingBoy.park(arrayList,car);
        //then
        // Assertions.assertEquals( "Not enough position.\n",systemOut());
        Assertions.assertEquals( "Lot1",systemOut());
    }
    @Test
    public void should_add_parkingboy_when_manager_add(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingManager parkingManager = new ParkingManager();
        //when
        parkingManager.addParkingBoy(parkingBoy);
        //then
        // Assertions.assertEquals( "Not enough position.\n",systemOut());
        Assertions.assertEquals(2,parkingManager.getParkingBoyArrayList().size());
    }
    @Test
    public void should_manage_point_parkingboy_park_to_parkingLot_when_parkingboy_is_manage_this(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingBoy parkingBoy1 = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(10,1,"Lot1");
        ParkingLot parkingLot1 = new ParkingLot(10,1,"Lot2");
        ArrayList<ParkingLot> parkingLotArrayList = new ArrayList<>();
        parkingLotArrayList.add(parkingLot);
        parkingLotArrayList.add(parkingLot1);
        parkingBoy.setParkingLotArrayList(parkingLotArrayList);
        ParkingManager parkingManager = new ParkingManager();
        Car car = new Car("粤B 66666");
        //when
        parkingManager.addParkingBoy(parkingBoy);
        parkingManager.addParkingBoy(parkingBoy1);
        //then
        Ticket ticket = parkingManager.pointPark(parkingBoy,car);
        // Assertions.assertEquals( "Not enough position.\n",systemOut());
        Assertions.assertNotNull(ticket);
    }
    @Test
    public void should_manage_point_parkingboy_fetch_to_parkingLot_when_parkingboy_is_manage_this(){
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingBoy parkingBoy1 = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(10,1,"Lot1");
        ParkingLot parkingLot1 = new ParkingLot(10,1,"Lot2");
        ArrayList<ParkingLot> parkingLotArrayList = new ArrayList<>();
        parkingLotArrayList.add(parkingLot);
        parkingLotArrayList.add(parkingLot1);
        parkingBoy.setParkingLotArrayList(parkingLotArrayList);
        ParkingManager parkingManager = new ParkingManager();
        Ticket ticket = new Ticket("num:1");
        Car car = new Car("粤B 66666");
        parkingLot.getCarMap().put(ticket.getTicketnum(),car);
        //when
        parkingManager.addParkingBoy(parkingBoy);
        parkingManager.addParkingBoy(parkingBoy1);
        //then
        Car car1 = parkingManager.pointFetch(parkingBoy,ticket);
        // Assertions.assertEquals( "Not enough position.\n",systemOut());
        Assertions.assertEquals(car,car1);
    }
    @Test
    public void should_manage_park_car_when_parkingboy_is_manage_this(){
        //given
        ParkingLot parkingLot = new ParkingLot(10,1,"Lot1");
        ParkingLot parkingLot1 = new ParkingLot(10,1,"Lot2");
        ArrayList<ParkingLot> parkingLotArrayList = new ArrayList<>();
        parkingLotArrayList.add(parkingLot);
        parkingLotArrayList.add(parkingLot1);
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.setParkingLotArrayList(parkingLotArrayList);
       // Ticket ticket = new Ticket("num:1");
        Car car = new Car("粤B 66666");
        //when
        Ticket ticket = parkingManager.park(parkingLotArrayList,car);
        //then
        // Assertions.assertEquals( "Not enough position.\n",systemOut());
        Assertions.assertNotNull(ticket);
    }
    @Test
    public void should_get_null_when__manager_does_not_park_in_his(){
        //given
        ParkingLot parkingLot = new ParkingLot(10,1,"Lot1");
        ParkingLot parkingLot1 = new ParkingLot(10,1,"Lot2");

        ParkingLot parkingLot2 = new ParkingLot(10,1,"Lot3");
        ParkingLot parkingLot3 = new ParkingLot(10,1,"Lot4");
        ArrayList<ParkingLot> parkingLotArrayList = new ArrayList<>();
        ArrayList<ParkingLot> parkingLotArrayList1 = new ArrayList<>();
        parkingLotArrayList.add(parkingLot);
        parkingLotArrayList.add(parkingLot1);

        parkingLotArrayList1.add(parkingLot2);
        parkingLotArrayList1.add(parkingLot3);
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.setParkingLotArrayList(parkingLotArrayList);
       // Ticket ticket = new Ticket("num:1");
        Car car = new Car("粤B 66666");
        //when
        Ticket ticket = parkingManager.park(parkingLotArrayList1,car);
        //then
        // Assertions.assertEquals( "Not enough position.\n",systemOut());
        Assertions.assertNull(ticket);
    }
    @Test
    public void should_manage_fetch_car_when_parkingboy_is_manage_this(){
        //given
        ParkingLot parkingLot = new ParkingLot(10,1,"Lot1");
        ParkingLot parkingLot1 = new ParkingLot(10,1,"Lot2");
        ArrayList<ParkingLot> parkingLotArrayList = new ArrayList<>();
        Car car = new Car("粤B 66666");
        Ticket ticket = new Ticket("num:1");
        parkingLot.getCarMap().put(ticket.getTicketnum(),car);
        parkingLotArrayList.add(parkingLot);
        parkingLotArrayList.add(parkingLot1);
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.setParkingLotArrayList(parkingLotArrayList);
        //when
        Car car1  = parkingManager.getCar(parkingLot,ticket);
        //then
        // Assertions.assertEquals( "Not enough position.\n",systemOut());
        Assertions.assertEquals(car,car1);
    }
    @Test
    public void should_manage_get_null_when_manage_fetch_car_not_in_this(){
        //given
        ParkingLot parkingLot = new ParkingLot(10,1,"Lot1");
        ParkingLot parkingLot1 = new ParkingLot(10,1,"Lot2");
        ParkingLot parkingLot2 = new ParkingLot(10,1,"Lot3");
        ArrayList<ParkingLot> parkingLotArrayList = new ArrayList<>();
        Car car = new Car("粤B 66666");
        Ticket ticket = new Ticket("num:1");
        parkingLot.getCarMap().put(ticket.getTicketnum(),car);
        parkingLotArrayList.add(parkingLot);
        parkingLotArrayList.add(parkingLot1);
        ParkingManager parkingManager = new ParkingManager();
        parkingManager.setParkingLotArrayList(parkingLotArrayList);
        //when
        Car car1  = parkingManager.getCar(parkingLot2,ticket);
        //then
        // Assertions.assertEquals( "Not enough position.\n",systemOut());
        Assertions.assertNull(car1);
    }
    @Test
    public void should_response_message__when_massager_act_parkingBoyt_to_park_and_capacity_is_full(){
        //given
        ParkingLot parkingLot = new ParkingLot(10,10,"Lot1");
        ParkingLot parkingLot1 = new ParkingLot(10,10,"Lot2");
        ArrayList<ParkingLot> parkingLotArrayList = new ArrayList<>();
        Car car = new Car("粤B 66666");
        parkingLotArrayList.add(parkingLot);
        parkingLotArrayList.add(parkingLot1);
        ParkingManager parkingManager = new ParkingManager();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.setParkingLotArrayList(parkingLotArrayList);
        //when
        parkingManager.pointPark(parkingBoy,car);
        //then
        Assertions.assertEquals( "Not enough position.\n",systemOut());
    }
    private String systemOut() {
        return outContent.toString();
    }
}