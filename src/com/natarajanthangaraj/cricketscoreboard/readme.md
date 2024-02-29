# CRICKET SCORER - YOUR CRICKET SCORING COMPANION

Cricket Scorer is a Java-based application that simplifies the process of scoring cricket matches. Whether you're scoring a casual game with friends or a competitive match, Cricket Scorer provides a guide to manage scores, track statistics, and keep the game organized.

**Target Audience:** Cricket match organizers

**Design Pattern:** MVVM

**Database:** MySQL

## Packages

- **Login:** 
  - Every new or existing user registers their details before starting to score. This package manages user details and stores them in the database.
  - Classes:
    1. LoginView.java
    2. LoginViewModel.java
    3. Repository.java
    4. User.java

- **Application:** 
  - This is the UI for the entire application. It is the initial part of our scoring, where we gather team details and provide them to the scorer.
  - Classes:
    1. ApplicationView.java
    2. ApplicationViewModel.java

- **DTO (Data Transfer Object):** 
  - These are POJO classes.
  - Classes:
    1. Batter.java
    2. Bowler.java
    3. Player.java
    4. Innings.java
    5. ScoreBoard.java
    6. Team.java

- **Database:** 
  - This package connects the login module with the MySQL database.
  - Classes:
    1. DatabaseConnection.java
    2. Queries.java

- **Scorer:** 
  - This is the backbone of the scoring app. It contains a lot of logic.
  - Classes:
    1. ScorerView.java
    2. ScorerViewModel.java

- **Main.java:** 
  - This is the starting point of our application.

- **BaseView.java:** 
  - It contains the Scanner class and Date class. We use this class to get input from the user.

## MySQL Database Query

```sql
create database cricketScoreBoard;
use cricketScoreBoard;
create table Login(
  userID INT AUTO_INCREMENT,
  userName varchar(200) not null,
  passWord varchar(100) not null,
  emailId varchar (200) not null,
  mobileNumber varchar(15) not null,
  PRIMARY KEY (userID)
);
```
## Working video:
[![Watch the video](https://img.youtube.com/vi/OXuAstGvZLU/maxresdefault.jpg)](https://youtu.be/OXuAstGvZLU)

