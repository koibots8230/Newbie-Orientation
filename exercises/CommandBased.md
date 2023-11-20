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
public class ExampleSubsystem extends SubsystemBase {

    public ExampleSubsystem() {

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

    private static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();

    private ExampleSubsystem() {

    }

    public static ExampleSubsystem get() {
        return exampleSubsystem;
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
   - The scheduler isn't disabled(we'll get to what the scheduler is in a minute)
   - The command isn't already scheduled
   - The robot is disabled & the command doesn't have an exemption to run while disabled (wooo safety!)
3. If it's requirements are in use or not. If they are in use, it will attempt to interrupt the other command(s). If it can't the command will not be scheduled.
4. If it's gotten to this step, it runs `initialize()`!

**Default Commands**

Default commands can be assigned to a subsystem & will be used when no other command is using the subsystem. It can be set using the following code:
```java
Subsystem.setDefaultCommand(Command);
```

**Instant Commands**

Instant commands are a way to make simple commands that don't really deserve a whole class. They take in a "Runnable", or essentially a lambda to a method. There's a few kinds:

|Type|What it Does|Example|
|---|---|---|
|Instant Command|The most basic type, takes in a method, runs it. Optional parameter of a required subsystem|`new InstantCommand(() -> method(), requiredSubsystem);`
|Start End Command|Similar to an instant command, but also has a method to run when it is ended|`new StartEndCommand(() -> startMethod(), () -> stopMethod(), requiredSubsystem)`|

### The Command Scheduler

The command scheduler is a singleton that handles both subsystems and commands. The command scheduler runs every time that `CommandScheduler.getInstance().run()` is called. You should place that inside of robot periodic(this is one of the **only** things that should be in there). Whenever the command schedulers is run, it does 4 things, in order:
1. Runs subsystem periodic methods
2. Checks to see if any commands bound to triggers need to be run & runs them
3. Runs any scheduled commands `execute()` and `isFinished()`
   - This sequence is done in order for each command, so one command gets both run, then the next, etc.
4. Any default commands are scheduled, if applicable

### File Organization

In order to keep the main directory clean (`src/main/java/frc/robot`), we ask that you have subsystems in a subsystems folder, and commands in a commands folder.

### Robot Container

Robot Container is a new file that you'll find when you make a command-based project. Robot container is *intended* to be the place where you initialize subsystems, but we have a better alternative you saw earlier. Luckily, it has two other main purposes: control bindings & auto management. I'm not going to get into autos (look at the auto lesson for that), but for now, just leave the `getAutonomousCommand()` thing alone. 

Controls are the main use for robot container that we see. Controls are done using the `Trigger` and `CommandXboxController` classes, both built in to wpi lib. The `CommandXboxController` is pretty similar to the normal `XboxController` class, with joysticks even working the same (`getLeftY()`, etc). The big difference comes with the other buttons. Instead of returning a boolean value for things like the a & b buttons, it returns a trigger.

Using the trigger, we can bind that button to a certain command. We've got a few options here: `whileTrue()`, `whileFalse()`, `onTrue()` and `onFalse()`. The whiles run the command for the duration of either the trigger being pressed (true) or the duration of it being not pressed (false), then call its `end()` method when the duration ends. The ons do that, but only call the `init()`, either when its first pressed, or first released. Note: the ons never call the `end()` method, so if you set a motor, either use a while, or use the inverse (set it to whatever on true, set it back to 0 on false) Here's an example of a trigger:
```java
Trigger xButton = controller.getX();
xButton.whileTrue(command);
```

Button bindings, as you might expect, go in the `configureButtonBindings()` method. 

## Instructions

Refactor your tank drive code to be in command based. You have all the knowledge you need, but if you need help, ask(google it first though!).

Also, make the `a` button set it to brake mode and the `b` button set it back to coast (just to practice button bindings)
- *Hint*: Just make a simple method for this & use instant command

You're going to have to create a new project for this, follow the same steps as in Hello Robot, but select command based, not time based.

*Hint:* Use a default command for driving around