# 12. Command-Based Programming

## Lesson

### What is it?

Command based programming is a declarative programming methodology that uses commands to affect how a subsystem behaves. This means that we define actions (commands) and when they should be run instead of checking a condition every iteration like we would in a time-based program.

Time-Based:
```java
private void teleopPeriodic() {
    if (controller.x() == true) {
        motor.set(1);
    }
}
```

Command-Based:
```java
private void robotInit() {
    Trigger button = new Trigger(controller::x);
    
    button.onTrue(Commands.runOnce(
            () -> motor.set(1)
        ));
}
```

### Subsystems

In code, subsystems are mean to be kind of digital versions of actual subsystems found on the robot. Things like drivetrain, intake, midtake, shooter. Subsystems are where you initialize things like motors, encoders, and other related sensors. 

Here's what an empty subsystem looks like:
```java
public class Subsystem extends SubsystemBase {

    public Subsystem() {

    }

    @Override
    public void periodic() {

    }
}
```
As you can see, on their base level, subsystems are pretty empty. Just a constructor and a periodic function, which works similarly to how things like teleopPeriodic() work, just for this subsystem instead. 

**Initializing & Accessing Subsystems**

So the thing with subsystems is that they have to be accessed by other classes, namely commands. The easiest way that we've found to do this is simply to initialize the class within itself, then create a public method that just returns the instance.

Here's an example:
```java
public class ExampleSubsystem extends SubsystemBase {

    private static Subsystem subsystem = new Subsystem();

    private ExampleSubsystem() {

    }

    public static Subsystem get() {
        return Subsystem
    }
}
```

**Methods**

Speaking about methods, while you can do things without them, it is much easier and cleaner to setup methods for when you need to get a value or set something. For example, you'd make a set method for drivetrain that takes in a speed argument and sets all the drive motors to that speed.

**Example**

[Here's](https://github.com/koibots8230/Koibots-2023/blob/main/src/main/java/frc/robot/subsystems/IntakeSubsystem.java) an example of a subsystem from last year's bot.

### Commands

A command is made to do specific tasks. For example, you would have a command that sets drive motors to a joystick value. A command can use as many or as few subsystems as it would like. 

When you create a command it will look like this:

```java
package com.koibots.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

class ExampleCommand extends CommandBase {
    public ExampleCommand() {
        addRequirements();
    }
    
    @Override
    public void initialize() {
        
    }
    
    @Override
    public void execute() {
        
    }
    
    @Override
    public boolean isFinished() {
        
    }
    
    @Override
    public void end(boolean interrupted) {
        
    }
}
```
Here's a list of the methods you see and what they each do
|Method|Purpose|
|---|---|
|`initialize()`|Called when the command is first scheduled|
|`execute()`|Called every CPU cycle while the command is being run(50htz)|
|`isFinished()`| Tells the command when to stop. Return `false` by default|
|`end(boolean interrupted)`| Runs when the command ends. `interrupted` specifies if the command was ended or canceled|
|`addRequirements(Subsystem...)`|Records which subsystems are used by the command so that multiple commands won't use the same subsystem at the same time|

### **Safety Note**

When you are making a command, place **all subsystems** that it uses **in the addRequirements**. Otherwise, you may end up with the robot trying to go two different directions at the same time, which is not safe for the motors or, more importantly, you.

**Example**

[Here's](https://github.com/koibots8230/Koibots-2023/blob/main/src/main/java/frc/robot/commands/AutoBalance.java) an example of a command from last year's code.

### How are Commands Run?

**Scheduling**

To start off, let's discuss how we work with commands. Like other classes, commands are not automatically run. The difference is, even if you do initialize the command, it still won't run. To make a command run, you have to schedule it by:
```java
new command.schedule();
```
When you schedule a command, it performs a few steps:
1. Checks that a command isn't in a composition
   - A composition is essentially a "has a" relationship between two classes. For example, a car <u>has a</u> engine. So the car class would have an instance of the engine class inside of it.
2. Makes sure that:
   - The scheduler isn't disabled(we'll ge5 to what the scheduler is in a minute)
   - The command isn't already scheduled
   - The robot is disabled & the command doesn't have an exemption to run while disabled (wooo safety!)
3. If it's requirements are in use or not. If they are in use, it will attempt to interrupt the other command(s). If it can't the command will not be scheduled.
4. If it's gotten to this step, it runs `initialize()`!

**Default Commands**

Default commands can be assigned to a subsystem & will be used when no other command is using the subsystem. It can be set using the following code:
```java
Subsystem.setDefaultCommand(Command);
```

### The Command Scheduler

The command scheduler is a singleton that handles both subsystems and commands. The command scheduler runs every time that `CommandScheduler.getInstance().run()` is called. You should place that inside of robot periodic(this is one of the **only** things that should be in there). Whenever the command schedulers is run, it does 4 things, in order:
1. Runs subsystem periodic methods
2. Checks to see if any commands bound to triggers need to be run & runs them
3. Runs any scheduled commands `execute()` and `isFinished()`
   - This sequence is done in order for each command, so one command gets both run, then the next, etc.
4. Any default commands are scheduled, if applicable

### File Organization

In order to keep the main directory clean (`src/main/java/frc/robot`), we ask that you have subsystems in a subsystems folder, and commands in a commands folder.

## Instructions

Refactor your tank drive code to be in command based. You have all the knowledge you need, but if you need help, ask(google it first though!).