# Airline Reservation System

## Overview
The Airline Reservation System is a Java-based application that facilitates flight management and reservation functionalities. The system allows users to book flights, manage passenger details, and perform administrative tasks related to flight and passenger information.


## Target Audience
Airline Passengers

## Packages
- **Application**
  - UI for the entire application. Displays all features and controls user-selected actions.

- **ConsoleInputHandler**
  - Handles user input, providing a chance to correct if wrong input is given.

- **dto**
  - Contains two POJO classes:
    - `Flight`: Defines all flight details.
    - `Ticket`: Defines ticket information.

- **ManageReservation**
  - Provides functionality for canceling bookings.

- **Repository**
  - Connects all features to the database.

- **Reservation**
  - Facilitates the booking of tickets.

## Features

- **User Authentication:** Secure login for administrators and users.
- **Flight Management:** Add, update, and delete flight details including flight number, airports, timings, and prices.
- **Passenger Booking:** Reserve seats for passengers on available flights.
- **Ticket Generation:** Automatically generate unique ticket numbers for each booking.
- **Flight Seat Allocation:** Manage seat availability for economy and business classes.
- **Passenger Information:** View and update passenger details.
- **Manage Tickets:**
  - **Cancel Ticket:** Allow users to cancel their booked tickets.
  - **View Ticket:** Enable users to view details of their booked tickets using the ticket number.

## Technologies Used

- Java
- MySQL Database
- JDBC for Database Connectivity

## Setup

1. **Database Configuration:**
   - Create a MySQL database named `AirlineReservation`.
   - Execute the SQL scripts in the `database-scripts` folder to set up the required tables.

2. **Java Project Setup:**
   - Open the project in your preferred Java IDE.
   - Update the database connection details in the `JDBCConnection` class.

3. **Run the Application:**
   - Run the `Main` class to start the application.

## Workflow
```
+---------------------+      +-----------------------+     +----------------------+
|      Application    |      | Console Input Handler |     |    Display Ticket    |
+---------------------+      +-----------------------+     +----------------------+
| - applicationVM     |      | - dateValidation      |     | - displayTicketVM    |
|                     |      | - timeValidation      |     |                      |
| + start()           |      | - validation           |     +----------------------+
|                     |      +-----------------------+     |      dto             |
+---------------------+             |                   |     +----------------------+
        |                         |                   |     | - Flight             |
        |                         |                   |     | - Passenger          |
        |                         |                   |     | - Trip               |
        |                         |                   |     | - User               |
        |                         |                   |     | - Ticket             |
        |                         |                   |     +----------------------+
        |                         |                   |
        V                         V                   V
+---------------------+    +-----------------------+    +----------------------+
|        login        |    | Manage Reservation    |    |      Repository      |
+---------------------+    +-----------------------+    +----------------------+
|                     |    |                       |    | - JDBCConnection      |
| + authenticate()    |    | - manageReservationVM |    | - Query               |
|                     |    |                       |    |                      |
| - UserLogin         |    | - reservation          |    +----------------------+
| - AdminLogin        |    |                       |
|                     |    +-----------------------+
+---------------------+             |
        |                          |
        V                          V
+---------------------+    +-----------------------+
|       dto           |    |      Additional       |
+---------------------+    |        Classes         |
| - Flight            |    +-----------------------+
| - Passenger         |    | - BaseView             |
| - Trip              |    | - Utility              |
| - User              |    +-----------------------+
| - Ticket            |
+---------------------+
```

## Usage
1. Run `Main.java` to start the application.
2. Choose from the presented features to book, manage, or view tickets.

Enjoy your flight!
