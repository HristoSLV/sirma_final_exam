# Sirma Academy Final Project

### This project is made with the following criteria: 
### https://drive.google.com/file/d/1eE5OkaUS-jNqtn7x3SoSU5n4S0U6I0Rq/view

### Based on these requirements, I have come to the following goals in this task:

1. Creating a method for parsing the 4 csv files, included in the ./resources path.
3. Saving the data into a database.
4. Creating CRUD functionality and validations.
5. Creating a method to find the pair of players with the highest amount of time played in matches at the same time
    - Players will naturally have significantly more time played with their teammates, rather than opposing players.
      
### To achieve these goals, I have used the following:

1. I have created multiple Util classes with methods for parsing, validating and initializing the .csv data.
2. I have used Jakarta validation to ensure invalid data cannot be entered into the database.
3. I have created a GlobalExceptionHandler class to aide in handling exceptions.
4. I have created CRUD for players, teams & matches.
5. I have implemented an algorithm to find the pair of players with most time played together
   - I have created a service class, 2 supporting model classes and a controller to implement the functionality.

### My algorithm works in the following way:

1. The algorithm sorts the players based on their teamIds.
1. It then iterates over every possible pair of players in a team in order to find the pair with the most time played together in each team.
1. The iteration over each pair finds the total amount of time they have played together.   
1. The algorithm finds the pair of players with most time played together in each individual team out of the 24 teams.
   - This was done in order to remove unnecessary operations which test player pairs in matches between different teams, as those will never be the pairs with highest amount of time played together.
   - The controller can return the pair with the highest amount of time on the field at the same time, or the pair from each team.
   - The algorithm cannot return the individual matches and the duration the pairs played in each of them (requires further implementation).

### The master branch will no longer be updated. All further updates will be pushed to a separate branch to differentiate between updates pushed during the exam and after the exam.
