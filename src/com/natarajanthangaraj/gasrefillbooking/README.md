# GasMaster - Gas Refill Booking Application

## Introduction
GasMaster is a comprehensive application designed for gas distributors to streamline the gas refill booking process. This document provides an overview of the application's features, structure, and usage.

## Features
1. **User Login**
   - Gas distributors can securely log in to the application.

2. **Find User through Mobile Number**
   - Search functionality to locate users based on their mobile numbers.

3. **Booking the Gas**
   - Easy booking process for gas distributors to fulfill user orders.

4. **Sell Gas Products**
   - Platform for selling additional gas-related products.

5. **Get Order List**
   - Access a list of orders placed by users.

6. **Make Payments**
   - Integrated payment system for gas orders.

## Requirement Analysis
1. **Show Comments**
   - Display informative comments related to the application.

2. **Get User Choice**
   - Efficiently collect and process user preferences.

## Classes
### `chatbotapplication` Package
- **ChatBot.java**: Manages communication with users.
- **ChatBotViewModel.java**: Implements business logic for the chatbot.
- **Utility.java**: Handles splash comments.
- **UserInput.java**: Gathers user input.
- **PrintInput.java**: Prints user views.

### `distributor` Package
- **Repository.java**: Singleton class for communication with the JSON file.
- **Data.json**: JSON file storing bot comments.

### `dto` Package
- **Choice.java**: Plain Old Java Object (POJO) class for storing user selections.

## How to Use
1. **Clone the Repository**
   - Clone the GasMaster repository to your local machine.

2. **Build and Run**
   - Build and run the application using your preferred IDE.

3. **Login**
   - Log in using your credentials as a gas distributor.

4. **Navigate and Interact**
   - Utilize the user-friendly interface to find users, place orders, and manage gas-related transactions.
