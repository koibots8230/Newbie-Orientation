# 9. Hello Robot

## Before we get Started, a Warning

Robotics is super fun, but we **have to be safe**. Unsafe programming can very quickly turn a fun robot into something that can **seriously injure** someone. When we tell you to do or not do something for the purpose of safety, **you are expected to follow those instructions**. Continued failure to follow safety rules **will result in immediate disciplinary action**.

## Lesson/Instructions

Ok, now that you know the basics, we get to work with FRC code now :confetti_ball:! Once we get to the tank drive lesson, you'll even get to run code on a robot. But, first, we have to create a project.

### Creating a Robot Project

Before we can use WPI lib, we have to make a project for that. First, press the W icon in the top right of VS code(or press Fn + F1). Find create a new project. In the GUI that pops up, select the *template* project type, *java* for the language, and *Timed Robot* for the base. Select this repo's folder, name your project *yournameRobotCode*, make sure the new folder checkbox is checked, and enter 8230 for the team number. Keep desktop support off, and generate the project. 


### What's Up in this New Folder?

This is going to generate a new folder. In the taskbar at the top, select file -> Open Folder, and select this new subfolder. 

In your new folder, open src/main/java/frc/robot. Inside, you should find *Main.java* and *Robot.java*. <u>**Do not ever touch anything inside of Main.java.**</u> Main.java is used to initialize the robot, so touching it has a good chance of just making your code not work. 

Seeing as we are ignoring Main.java, that leaves Robot.java. Robot.java generates with some snippets of code that we do not need. Please delete the following code:
1. Lines 18-21
2. Everything inside of the robotInit method
3. Everything inside of the autonomousInit method
4. Everything inside of the autonomousPeriodic method
5. If you want to, you can also delete all the comments(dark green text), but it isn't necessary

Ok, with that out of the way, now onto all these methods. In Robot.java, you'll find a class with 12 methods. You'll notice that they are in pairs with an Init method, and a Periodic method. Init is short for initialize, and is executed when that mode is started. Periodic simply executes the code 50 times a second(aka at 50hz) while that mode is active. Here's a list on what each mode is.

|Mode|What it is|
|---|---|
|Robot|This essentially starts from the minute the robot powers up and ends when you power the robot off **For safety reasons, never put code in robotPeriodic unless <u>explicitly</u> told otherwise, <u>and</u> especially never put any movement code in either of the two**|
|Disabled|This is when the robot is disabled. **For safety reasons, no code that makes the robot move should <u>ever</u> be placed in here**|
|Autonomous|This is when the robot is enabled in Autonomous mode. Autonomous is the 15 seconds at the start of a match where it's only code, no drivers. **For safety reasons, be very far away from the robot when testing this**|
|Teleop|This is when the robot is enabled and being controlled by drivers|
|Test|This is when the robot is enabled in test mode, we use this for misc tasks|
|Simulation|This is when the robot is simulating. We'll get to this later, ignore it for now|

## Instructions

Double check to make sure your code works syntax-wise by hitting the W icon in the top right (or press Fn + F1) and selecting "Build Robot Code"

Commit and push your changes(remember, you made new files, so you have to git add them!). 