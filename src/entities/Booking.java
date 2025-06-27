package entities;

import java.time.LocalDate;


// Booking class represents a booking made by a user for a specific room.
public class Booking {
    private int userId;
    private int roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int totalPrice;

    // Constructor to initialize a booking with user ID, room ID, check-in date, check-out date, and total price.
    public Booking(int userId, int roomId, LocalDate checkInDate, LocalDate checkOutDate, int totalPrice) {
        this.userId = userId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;

    }

    public int getUserId() {
        return userId;
    }


    public int getRoomId() {
        return roomId;
    }


    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }



    public int getTotalPrice() {
        return totalPrice;
    }



    @Override
    public String toString() {
        return "Booking{" +
                "userId=" + userId +
                ", roomId=" + roomId +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
