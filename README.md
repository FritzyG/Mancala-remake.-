Mancala Remake
Overview
Mancala Remake is a Java implementation of the classic Mancala board game built using Object-Oriented Programming (OOP) principles and Java Swing. The project recreates the traditional gameplay experience through an interactive graphical user interface while maintaining a modular and maintainable software architecture.

The application demonstrates core software engineering concepts including encapsulation, inheritance, abstraction, event-driven programming, GUI development, and game state management.

Features
Interactive Java Swing graphical user interface
Complete Mancala gameplay implementation
Turn-based game mechanics
Real-time board updates
Stone distribution logic
Player score tracking
Winner determination
Object-oriented class structure
Modular and reusable codebase
Technologies Used
Java
Java Swing
Object-Oriented Programming (OOP)
Project Structure
Main.java
│
├── Launches the application

Game.java
│
├── Controls overall game flow
├── Handles turn management
└── Enforces game rules

Board.java
│
├── Maintains board state
├── Updates pits and stores
└── Handles board operations

Player.java
│
├── Base player class
└── Defines player behavior

HumanPlayer.java
│
└── Implements human player actions

Pit.java
│
└── Defines pit structure

pitImpl.java
│
└── Implements pit functionality

MancalaGUI.java
│
├── Java Swing user interface
├── Board visualization
├── Input handling
└── Real-time game updates
Object-Oriented Design
The application follows Object-Oriented Programming principles to separate responsibilities across multiple classes.

Encapsulation
Game state, player information, and board behavior are managed within dedicated classes to maintain data integrity.

Inheritance
HumanPlayer extends functionality from the Player class, promoting code reuse and scalability.

Abstraction
Game logic is separated from graphical interface components, improving readability and maintainability.

Modularity
Each class is responsible for a specific aspect of the application, making the code easier to expand and debug.

How the Game Works
The board is initialized with an equal number of stones in each pit.
Players take turns selecting pits.
Stones are distributed counterclockwise according to Mancala rules.
Players earn points by collecting stones in their Mancala.
The game continues until one side of the board becomes empty.
Remaining stones are collected and final scores are calculated.
The winner is determined based on the highest score.
Skills Demonstrated
Software Engineering
Object-Oriented Design
Class Architecture
Code Organization
Debugging and Testing
Programming
Java Development
Event-Driven Programming
Algorithm Implementation
State Management
User Interface Design
Java Swing Development
Interactive Components
GUI Event Handling
User Experience Design
Computer Science Concepts
Data Structures
Game Logic Design
Algorithmic Thinking
Problem Solving
Running the Application
Prerequisites
Java JDK 8 or higher
Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)
Compile
javac *.java
Run
java Main
Learning Outcomes
This project was developed to strengthen understanding of object-oriented programming and desktop application development. Through implementing Mancala from scratch, the project provided experience in designing class hierarchies, managing application state, implementing game rules, and creating graphical user interfaces using Java Swing.

Future Improvements
Potential future enhancements include:

Computer AI opponent
Difficulty settings
Multiplayer support
Save and load functionality
Game statistics tracking
Improved graphical design
Online multiplayer support
Author
Fritz Guerin Jr.

GitHub: https://github.com/FritzyG

Project Purpose
This project serves as a demonstration of Java programming, object-oriented software design, and GUI development through the implementation of a complete playable Mancala game.
