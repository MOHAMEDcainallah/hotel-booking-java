# Hotel Reservation System in Java

## Description

This project is a simple Java application that allows you to manage hotel room bookings.  
It supports user creation, room types, check-in and check-out dates, and automatic price calculation.

The project was developed as part of a Java technical test to practice object-oriented programming (OOP), date handling, and the use of enumerations.

## Features

- Booking creation with:
  - User identification
  - Room type selection (STANDARD, JUNIOR, SUITE)
  - Management of check-in and check-out dates
  - Automatic total price calculation
- Room types handled using an enumeration (`enum`)
- Date validation (e.g., check-out must be after check-in)
- Code is commented to improve readability and understanding
- Use of the `LocalDate` class for date management


## Design Questions (Bonus)



### 1. Is it recommended to put all functions inside a single service class?

For this simple project, grouping all functions in one `Service` class is acceptable and makes centralized data management easier.  
However, for larger and more complex projects, this approach is not recommended as it leads to a monolithic class that is hard to maintain and test.  
It is better to separate responsibilities into multiple dedicated services (user management, room management, booking management), following the Single Responsibility Principle (SRP).

### 2. In this design, the `setRoom(..)` function should not affect previous bookings. What alternative approach do you recommend?

A recommended approach is to treat bookings as immutable once created.  
Instead of modifying the room of an existing booking via `setRoom(..)`, it is better to create a new booking with the updated room.  
This avoids side effects, preserves booking history, and ensures data integrity.


