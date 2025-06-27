package services;

import enums.RoomType;
import entities.Booking;
import entities.Room;
import entities.User;

import java.time.LocalDate;
import java.util.ArrayList;


//// Service class to manage hotel operations such as creating users, rooms, and bookings
public class Service {

    // Lists to store rooms, users, and bookings
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();

    // This method is used to create a user and add it to the users list
    public void setUser(int userId, int balance) {
        for (User user : users) {
            if (user.getId() == userId) {
                System.out.println("User with ID" + userId + "already exists.");
                return; // Skip creation if user already exists
            }
        }
        users.add(new User(userId, balance));
    }

    // This method is used to create a room and add it to the rooms list or skip creation if it already exists
    public void setRoom(int roomId, RoomType roomType, int roomPricePerNight) {
        for (Room room : rooms) {
            if (room.getId() == roomId) {
                System.out.println("Room with ID " + roomId + "is already exists. Skipping creation.");
                return; // Skip creation if room already exists
            }
        }
        rooms.add(new Room(roomId, roomType, roomPricePerNight));
    }

    // This method is used to book a room for a user and check if the dates are valid
    public void bookRoom(int userId, int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        if (checkOut.isBefore(checkIn) || checkOut.equals(checkIn)) {
            System.out.println("Invalid dates: check-out must be after check-in.");
            return;
        }

        // Find user and check if it exists
        User user = null;
        for (User u : users) {
            if (u.getId() == userId) {
                user = u;
                break;
            }
        }
        // If user not found, print message and return
        if (user==null){
            System.out.println("User with ID " + userId + " not found.");
            return;
        }

        // Find room and check if it exists
        Room room = null;
        for (Room r : rooms){
            if (r.getId() == roomNumber){
                room = r;
                break;
            }
        }
        // If room not found, print message and return
        if (room == null) {
            System.out.println("Room with ID " + roomNumber + " not found.");
            return;
        }

        // Check if the user has enough balance to book the room and if the room is available for the selected dates
        //and the minus(1) is used to check the last day of the booking for excluding the confusion of the check-out date
        for (Booking b : bookings){
            if (b.getRoomId() == roomNumber){
                if (!(checkOut.isBefore(b.getCheckInDate()) || checkIn.isAfter(b.getCheckOutDate().minusDays(1)))){
                    System.out.println("Room with ID " + roomNumber + " is not available for the selected dates.");
                    return;
                }
            }
        }

        // Calculate the number of nights for the booking
        int nights = checkOut.getDayOfYear() - checkIn.getDayOfYear();
        int  totalCost = nights * room.getPricePerNight();

        // Check if the user has enough balance to book the room
        if (user.getBalance() < totalCost){
            System.out.println("User"+ userId + " does not have enough balance to book the room.");
            return;
        }

        //else Create a new booking and add it to the bookings list
        // Update the user's balance and print a success message
        user.setBalance(user.getBalance() - totalCost);
        bookings.add(new Booking(userId, roomNumber, checkIn, checkOut, totalCost));
        System.out.println("Room " + roomNumber + " booked successfully for user " + userId + " from " + checkIn + " to " + checkOut + ". Total cost: " + totalCost);

    }


    // This method prints all bookings and rooms in reverse order to ensure the latest changes are shown first
    public void printAll() {
        System.out.println("---- Bookings ----");
        for (int i = bookings.size() - 1; i >= 0; i--) {
            System.out.println(bookings.get(i));
        }

        // Print all rooms in reverse order to unsure the latest changes are shown first
        System.out.println("---- Rooms ----");
        for (int i = rooms.size() - 1; i >= 0; i--) {
            System.out.println(rooms.get(i));
        }
    }

    // This method prints all users in reverse order to ensure the latest changes are shown first
    public void printAllUsers() {
        System.out.println("---- Users ----");
        for (int i = users.size() - 1; i >= 0; i--) {
            System.out.println(users.get(i));
        }
    }

}
