# ATM  Application
## Overview
The ATM Console Application is a simple banking system that provides essential banking operations through a console-based user interface.
The application is built using the Model-View-Presenter (MVP) design pattern for a clear separation of concerns, and it employs file handling using JSON for database management.

## Packages

1. **Application**
   - UI for the ATM application.

2. **Deposit**
   - Handles the logic for depositing money.

3. **Withdraw**
   - Manages the logic for withdrawing money.

4. **PinChange**
   - Allows users to change their ATM card PIN.

5. **BalanceEnquiry**
   - Provides functionality to check the user's bank balance.

6. **Repository**
   1. *Repository.java*
      - Establishes a connection with the database.
   2. *BankAccount.json*
      - Contains details of users.

7. **Dto**
   1. *CardDetails.java*
      - Plain Old Java Object (POJO) representing card details.

8. **Statement**
   - Displays the current operation statement to the user.

## Technologies Used

1. **Design Pattern**
   - Model-View-Presenter (MVP) design pattern.

2. **Database**
   - File Handling using JSON for storing user details.

## Class Diagram

```plaintext
+---------------------+      +-----------------------+     +----------------------+
|     Application     |      |       Deposit         |     |      Withdraw        |
+---------------------+      +-----------------------+     +----------------------+
| - applicationUI     |      | - depositLogic        |     | - withdrawLogic      |
| + start()           |      | + depositAmount()     |     | + withdrawAmount()   |
+---------------------+      +-----------------------+     +----------------------+
        |                          |                          |
        |                          |                          |
        V                          V                          V
+---------------------+    +-----------------------+    +----------------------+
|     PinChange       |    |  Balance Enquiry      |    |     Repository       |
+---------------------+    +-----------------------+    +----------------------+
| - pinChangeLogic    |    | - balanceEnquiryLogic |    | - Repository.java    |
| + changePin()       |    | + getBalance()        |    | - BankAccount.json   |
+---------------------+    +-----------------------+    +----------------------+
        |                                                   |
        |                                                   |
        V                                                   V
+---------------------+                                +----------------------+
|        Dto          |                                |      Statement       |
+---------------------+                                +----------------------+
| - CardDetails       |                                | - showStatement()    |
+---------------------+                                +----------------------+
