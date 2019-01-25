package com.purduex.quigley;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoomTest
{
    @Test
    public void testGetRoomNumber() {
        int roomNumber = 66;
        Room r = new Room(roomNumber, "single king");

        assertTrue(r.getRoomNumber() == roomNumber);
    }
    @Test
    public void testGetNoDaysRented() {
        Room r = new Room(66,"single king");

        assertTrue(r.getDaysRented() == 0);
    }
    @Test
    public void testGetDaysRented() {
        Room r = new Room(66, "single king");
        int daysToRent = 3;
        r.setOccupant("Jim",daysToRent);

        assertTrue(r.getDaysRented()==daysToRent);
    }

    @Test
    public void testGetOccupantName(){
        Room r = new Room(66,"king size");
        String name = "Marcus";
        r.setOccupant(name,3);

        assertTrue(r.getOccupantName()==name);
    }

    @Test
    public void testGetOccupantNullName(){
        Room r = new Room(66,"king size");

        assertNull(r.getOccupantName());
    }

    @Test
    public void testGetRoomType(){
        String roomType = "single king";
        Room r = new Room(66,roomType);

        assertEquals(r.getRoomType(),roomType);
    }

    @Test
    public void testGetEmptyRoomType(){
        Room r = new Room(66,"");
        String defaultRoomType = "double queen";

        assertEquals(r.getRoomType(),defaultRoomType);
    }

    @Test
    public void testGetBadRoomType(){
        Room r = new Room(66,"BADNAME");
        String defaultRoomType = "double queen";

        assertEquals(r.getRoomType(),defaultRoomType);
    }

    @Test
    public void testIsRoomType(){
        String roomType = "single king";
        Room r = new Room(66,roomType);

        assertTrue(r.isRoomType(roomType));
    }

    @Test
    public void testIsNotRoomType(){
        String roomType = "single king";
        Room r = new Room(66,roomType);

        assertFalse(r.isRoomType("badname"));
    }

    @Test
    public void testSetOccupant(){
        Room r = new Room(66,"double queen");
        boolean result = r.setOccupant("Mick",1);

        assertTrue(result);
    }

    @Test
    public void testSetOccupantWithBadData(){
        Room r = new Room(66,"double queen");
        boolean result = r.setOccupant("",0);

        assertFalse(result);
    }

    @Test
    public void testSetOccupantAlreadyOccupied(){
        Room r = new Room(66,"double queen");
        r.setOccupant("Mick",1);
        boolean result = r.setOccupant("Mary",1);

        assertFalse(result);
    }

    @Test
    public void testAdvanceDay(){
        Room r = new Room(66,"double queen");
        r.setOccupant("Mick",2);
       r.advanceDay();

        assertEquals(r.getDaysRented(),1);
    }

    @Test
    public void testAdvanceDayFinalDay(){
        Room r = new Room(66,"double queen");
        r.setOccupant("Mick",1);
        r.advanceDay();

        assertNull(r.getOccupantName());
    }

    @Test
    public  void testToString(){
        Room r = new Room(305,"double queen");
        r.setOccupant("Joe",1);
        String result = r.toString();

        assertEquals("Room 305: double queen - rented",result);

    }

}
