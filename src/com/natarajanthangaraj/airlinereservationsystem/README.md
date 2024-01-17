# Airline Reservation System

## Overview
A console application designed for booking tickets, managing tickets, and viewing ticket options. The target audience is airline passengers, and the design pattern used is MVVM. The application utilizes file handling (JSON) as the database.

## Project Structure

### Packages
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

### Main Components

- **Main.java**
  - The starting point of the application.

- **Utility**
  - Contains the Scanner class and Date class for obtaining user input.

## Workflow

1. **Application**
   - UI presents available features.
   - Controls user interactions.

2. **ConsoleInputHandler**
   - Ensures correct user input.
   - Allows corrections for wrong input.

3. **dto**
   - `Flight`: Defines flight details.
   - `Ticket`: Defines ticket information.

4. **ManageReservation**
   - Allows cancellation of bookings.

5. **Repository**
   - Connects features to the database.

6. **Reservation**
   - Facilitates ticket booking.

## Technologies Used

- **Design Pattern:** MVVM
- **Database:** File Handling (JSON)

## Target Audience
Airline Passengers

## Usage
1. Run `Main.java` to start the application.
2. Choose from the presented features to book, manage, or view tickets.

Enjoy your flight!
