# Memory Grid Game

This project is a memory-based grid game implemented using Java. The game challenges the user to remember the positions of various objects placed in a 3x3 grid. Players open cells one by one and attempt to guess the arrangement of objects in the grid. The game is designed using Object-Oriented Programming (OOP) principles.

## 📌 Technologies Used
- **Java**  
- Object-Oriented Programming (OOP) concepts  
- **Scanner** for user input  
- Classes and Interfaces

## 🎮 Game Features
- A 3x3 grid is initialized with different objects like a Cup, Ball, Hat, Pen, and Unidentified item.
- Players interact with the grid, opening cells by providing row and column coordinates.
- After opening a set number of cells, players attempt to guess the original object order in the grid.
- The game evaluates the guess and determines if the player has won or lost based on the accuracy of the guess.

## 🚀 How to Run
1. Clone the repository:
git clone https://github.com/meliscann/memory-grid-game.git

3. Compile the Java program:
javac MemoryGridGame.java

5. Run the program:
java MemoryGridGame

## 📄 Game Flow
- The game begins with a grid full of 'X's, representing closed cells.
- The user opens the cells one by one, revealing their contents.
- After a set number of cells have been opened, the user guesses the original arrangement of objects.
- If the user correctly remembers 4 or more objects' positions, they win.

## 💡 Key Concepts
- **Interfaces:** Used to define a common method (`whoAmI()`) for various game objects (Cup, Ball, Hat, Pen, Unidentified).
- **Classes:** Implemented for each object type with unique behavior.
- **Arrays:** Used to manage the 3x3 grid and store objects dynamically.

