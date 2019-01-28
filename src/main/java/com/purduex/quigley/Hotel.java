package com.purduex.quigley;

public class Hotel {
    private String hotelName;
    private Room[] rooms;
    private int totalRooms;

    public Hotel(String name, int numberOfRooms, int numberOfFloors) {
        hotelName = name;
        totalRooms = numberOfRooms;
        rooms = createRooms(numberOfRooms, numberOfFloors);
    }

    private Room[] createRooms(int numberOfRooms, int numberOfFloors) {
        if (numberOfFloors < numberOfFloors) {
            throw new IllegalArgumentException("Error in params");
        }
        Room[] roomsArray = new Room[numberOfRooms];
        int roomsPerFloor = numberOfRooms / numberOfFloors;
        String roomNumber = "";
        int index = 0;
        String roomType = "";
        for (int i = 0; i < numberOfFloors; i++) {
            for (int j = 0; j < roomsPerFloor; j++) {
                roomNumber = String.format("%1$s%2$s", i + 10, (roomsPerFloor - 1) - j);
                if (j == 0) {
                    roomType = "suite";
                } else if (j < 5) {
                    roomType = "single king";
                } else {
                    roomType = "double queen";
                }
                index = (i * roomsPerFloor) + j;
                //System.out.println("index: " + index);
                roomsArray[index] = new Room(Integer.parseInt(roomNumber), roomType);
            }
        }
        return roomsArray;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public int getNumberOccupied() {
        int total = 0;
        for (Room r : rooms) {
            total += (r.isOccupied() ? 1 : 0);
        }
        return total;
    }

    public double getOccupancyRate() {
        double rate = ((double) getNumberOccupied() / totalRooms);// * 100;
        double result = Math.round(rate * 100.0) / 100.0;
        return result;
        //return  (double)(totalRooms - getNumberOccupied())/totalRooms;
    }

    private int getOccupancyRateAsPercent() {
        double rate = getOccupancyRate() * 100;
        return (int) Math.ceil(rate);
    }

    public boolean rentRoom(String roomType, String guestName, int daysStaying) {
        for (int i = 0; i < rooms.length - 1; i++) {
            Room r = rooms[i];
            if (r.isRoomType(roomType) && !r.isOccupied()) {
                return r.setOccupant(guestName, daysStaying);
            }
        }
        return false;
    }

    public void advanceDay() {
        for (Room r : rooms) {
            if (r.isOccupied()) {
                r.advanceDay();
            }
        }
    }

    public String toString() {
        //  String.format("%1$s%2$s", i+10,(roomsPerFloor-1)-j);
        //return String.format("%1$: %2$  occupied",hotelName,hotelName);//getOccupancyRateAsPercent());

        return String.format("%1$s: %2$s%% occupied", hotelName, getOccupancyRateAsPercent());
    }

}
