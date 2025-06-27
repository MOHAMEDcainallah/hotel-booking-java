package entities;

import enums.RoomType;

// This class represents a hotel room with its ID, type, and price per night.
public class Room {
    private int id;
    private RoomType type;
    private int pricePerNight;

    public Room(int id, RoomType type, int pricePerNight) {
        this.id = id;
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    public int getId() {
        return id;
    }


    public RoomType getType() {
        return type;
    }


    public int getPricePerNight() {
        return pricePerNight;
    }


    // This method is used to display the room information in a readable format
    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", pricePerNight=" + pricePerNight +
                '}';
    }

}
