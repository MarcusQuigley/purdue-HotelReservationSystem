package com.purduex.quigley;

import org.junit.Test;

import static org.junit.Assert.*;

public class HotelTest {

    @Test
    public void testGetTotalRooms() {
        int totalRooms=36;
        Hotel h = new Hotel("Regis",totalRooms,3);

        assertEquals(totalRooms, h.getTotalRooms());
    }

    @Test
    public void testGetNumberOccupied() {
        Hotel h = new Hotel("Regis",14,2);
        h.rentRoom("double queen","Matt",3);
        h.rentRoom("double queen","Mary",1);
        h.rentRoom("suite","Kia",2);
        h.rentRoom("single king","Jai",13);

        assertEquals(4,h.getNumberOccupied());
    }

    @Test
    public void testGetOccupancyRate() {
        Hotel h = new Hotel("Regis",14,2);
        h.rentRoom("double queen","Matt",3);
        h.rentRoom("double queen","Mary",1);
        h.rentRoom("suite","Kia",2);
        h.rentRoom("single king","Jai",13);


        double expected = Math.round((4/14.0) * 100.0)/100.0;
        assertEquals(expected,h.getOccupancyRate(),0);
    }

    @Test
    public void testRentRoom() {
        int numRooms=14;
        Hotel h = new Hotel("Regis",numRooms,2);
        boolean result = h.rentRoom("double queen","Matt",3);

        assertTrue(result);
        assertEquals((numRooms-1),numRooms-h.getNumberOccupied());
    }
    @Test
    public void testRentRoomWithNoRoomType() {
        int numRooms=10;
        Hotel h = new Hotel("Regis",numRooms,2);
        boolean result = h.rentRoom("double queen","Matt",3);

        assertFalse(result);
        assertEquals((numRooms),numRooms-h.getNumberOccupied());
    }

    @Test
    public void testAdvanceDay() {
    }

    @Test
    public void testToString() {
        String hotelName="The Purdue Memorial Union Hotel";
        Hotel h = new Hotel(hotelName,18,2);
        h.rentRoom("suite","J",3);
        h.rentRoom("suite","K",3);
        String  expectedResult="The Purdue Memorial Union Hotel: 11% occupied";

        assertEquals(expectedResult,h.toString());

    }
}