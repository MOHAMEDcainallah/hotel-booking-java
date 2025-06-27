import enums.RoomType;
import services.Service;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        Service service = new Service();

        // Create rooms
        service.setRoom(1, RoomType.STANDARD, 1000);
        service.setRoom(2, RoomType.JUNIOR, 2000);
        service.setRoom(3, RoomType.SUITE, 3000);

        // Create users
        service.setUser(1, 5000);
        service.setUser(2, 10000);

        // Bookings
        service.bookRoom(1, 2, LocalDate.of(2026, 6, 30), LocalDate.of(2026, 7, 7)); // OK 7 nights
        service.bookRoom(2, 2, LocalDate.of(2026, 7, 7), LocalDate.of(2026, 6, 30)); // KO wrong range
        service.bookRoom(1, 1, LocalDate.of(2026, 7, 7), LocalDate.of(2026, 7, 8));  // OK 1 night
        service.bookRoom(2, 1, LocalDate.of(2026, 7, 7), LocalDate.of(2026, 7, 9));  // KO already booked
        service.bookRoom(2, 3, LocalDate.of(2026, 7, 7), LocalDate.of(2026, 7, 8));  // OK 1 night

        // Test non-impacting room change
        service.setRoom(1, RoomType.SUITE, 10000);

        // Print all bookings and rooms from the service
        System.out.println("=== All Bookings and Rooms ===");
        service.printAll();

        // Print all users
        System.out.println("\n=== All Users ===");
        service.printAllUsers();
    }

}

