package com.purduex.quigley;

public class Room {
    private int roomNumber;
    private int daysRented;
    private String occupantName;
    private String roomType;

    public Room(int number, String type) {
        roomNumber = number;
        roomType = checkRoomType(type);
        daysRented = 0;
        occupantName = null;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public String getOccupantName() {
        return occupantName;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isRoomType(String type) {
        return type.equalsIgnoreCase(roomType);
    }

    public boolean setOccupant(String guestName, int days) {
        if (guestName.isEmpty() || days < 1) {
            return false;
            //should really raise exception instead.
        }
        if (isOccupied()) {
            return false;
        }
        occupantName = guestName;
        daysRented = days;
        return true;
    }

    public void advanceDay() {
        daysRented -= 1;
        if (daysRented < 1) {
            occupantName = null;
        }
    }

    public boolean isOccupied() {
        return daysRented > 0;
    }

    private String checkRoomType(String type) {
        if (type.isEmpty()) {// || type.isBlank()) {
            type = "double queen";
        }
        String result = "";
        switch (type.toLowerCase()) {
            case "single king":
                result = type;
                break;
            case "suite":
                result = type;
                break;
            default:
                result = "double queen";
        }
        return result;
    }

    public String toString() {
        //Room 305: single king – rented
        return "Room " + roomNumber + ": " + roomType + " - " + (isOccupied() ? "rented" : "free");
    }
}
