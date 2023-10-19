# Glossary

## Variables
- **Variable**: Data assigned to a name
- **Variable Type**: The type of data that is contained within a variable. Things like *double* or *int*.
- **Style Guide**: A set of rules for how code should look. We use the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)

## Conditionals
- **Conditional**: An expression that evaluates the truth of a boolean
- **Boolean Expression**: An expression that evaluates to true or false(a boolean)
- **Arithmetic Operator**: An operator used for arithmetic
- **Comparison Operator**: An operator used to compare two numbers
- **Logical Operator**: An operator used in conjunction with comparison operators. Can chain multiple boolean expressions together, or get the inverse of a boolean.
- **Body**: The area within the {}. Where code goes
- **Ternary**: An operator used to condense conditionals

## Data Structures
- **Comment**: Text in code that isn't read by the computer. Shown with a '//' before it
- **Data Structure**: A format for the storage and organization of data
- **Array**: A list of a fixed size, cheaper for the computer
- **Dynamic Array**: Similar to an array, but it can change size, and is accessed via a class
- **Hashmap**: A list of key value pairs, similar to python's dictionaries
- **Linked List**: Pretty much the same a dynamic array, but is more efficient for the computer
- **Stack**: A last in first out where the data is accessed like a stack of papers
- **Queue**: A first in first out where data is accessed from a different end than where it's inputted, like a queue at an airport
- **Binary Tree**: A series of nodes where each node makes a reference to it's "children" nodes and to it's "parent" nodes
- **Heap**: A type of overcomplicated binary tree that deals with applications involving priority
- **Graph**: A data structure where data is virtually represented as having "edges" and "vertices"

## Loops
- **While Loop**: A loop that runs while a boolean is true
- **For Loop**: A loop that runs for a certain number of iterations

## Classes
- **Class**: The basis of Object-Oriented Programming. Contains attributes and methods.
- **Attribute**: A variable within a class that "belongs" to that class
- **Method**: A function within a class used to perform a specific action related to the class
- **Instance**: A specific occurrence of a class
- **Constructor**: A method of a class used to create an instance of it

## OOP
- **Object-Oriented Programming**: A programming model focused around objects
- **Object**: An instance of a class

## Extras
- **Recursion**: An alternative to iteration(loops) where a function calls itself until a condition has been met
- **Enum**: Special classes that allow for arbitrary constants
- **Singleton**: A class where only 1 instance exists
- **Interface**: An empty "blueprint" for making a class
- **Abstract class**: Similar to an interface, but you can put default code that can be overridden

## Hello Robot
- **WPILib**: The library we(and almost every team) use to control the robot
- **___Init**: A method in Robot.java that is run when it's mode is started
- **___Periodic**: A method in Robot.java that is run continuously while its mode is enabled
- **robot___**: A mode in Robot.java that runs while the robot is on
- **disabled___**: A mode in Robot.java that runs while the robot is disabled
- **autonomous___**: A mode in Robot.java that runs while autonomous is enabled
- **teleop___**: A mode in Robot.java that runs while teleop is enabled
- **test___**: A mode in Robot.java that runs while test mode is enabled
- **simulation___**: A mode in Robot.java that runs while simulation mode is enabled

## Motors
- **REVLib**: The library used to control motors and encoders made by REV (so pretty much all of ours)
- **Motor**: The main thing that make the robot move. Produce rotational motion
- **Motor Controller**: A piece of equipment used to control the motor at varying speeds and directions
- **SparkMAX**: The type of motor controller we use
- **Percentage Control**: The main way we control motors, uses a percentage. 1 and -1 are 100% in their respective directions.
- **Following**: Makes one motor copy the movement of another
- **Inversion**: Swaps what directions 1 and -1 move
- **Idle Mode**: How a motor acts when idle
  - **Brake**: Makes the motor resist being moved
  - **Coast**: Allows the motor to spin. Is the default.

## Encoders
- **Encoder**: A piece of equipment that counts rotations of something
- **Built-In Encoder**: An encoder built into a motor
- **External Encoder**: An encoder that is external to a motor. Often we'll use a [REV Through Bore Encoder](https://www.revrobotics.com/rev-11-1271/)
- **Encoder Position**: The total count of rotations from an encoder
- **Encoder Velocity**: Rpm of the encoder
- **Conversion Factor**: A number that gets multiplied against the encoder value before it's returned

## Tank Drive
- **Drive Train**: The thing that moves the robot
- **Tank Drive**: Also known as differential drive, type of drivetrain that uses two individually controlled sides
- **Swerve Drive**: A type of drivetrain that allows for movement in any direction. Is significantly more expensive and complicated.
- **Controller**: A digital interface for a physical controller
- **Joystick**: The moving sticks on a controller

## Command Based
- **Command-Based Programming**: Command based programming is a declarative programming methodology that uses commands to affect how a subsystem behaves
- **Subsystem**: A digital reflection of a physical subsystem on the robot (i.e. drivetrain, intake, shooter, etc.)
- **Command**: A set of instructions meant to accomplish a set task. Often uses subsystems to accomplish this
- **Default Command**: A command bound to a subsystem that runs when no other command is using the subsystem
- **Command Scheduler**: A singleton that handles the processing of subsystems and commands 