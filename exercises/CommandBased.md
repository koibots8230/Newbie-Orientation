# 12. Command-Based Programming

---

## What is it?

---

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

## Commands

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

| Method                                      | Purpose                                                                                               |
|---------------------------------------------|-------------------------------------------------------------------------------------------------------|
| `initialize()`                              | Called every time the command is first scheduled.                                                     |
| `execute()`                                 | Called whenever the command is scheduled.                                                             |
| `isFinished()`                              | Tells the command when to stop. Return `false` by default.                                            |
| `end(boolean interrupted)`                  | Runs when the command ends. `interrupted`<sup>*</sup> specifies if the command was ended or canceled. |
| `addRequirements(Subsystem...)`<sup>*</sup> | Records which subsystems are used by the command.                                                     |
<sup>*</sup> More on these later.


### How are Commands Run?

Commands are run by the `CommandScheduler` class when `CommandScheduler.getInstance().run()` is called (typically in `robotPeriodic()`)

## Subsystems

## Code Organization

## Instructions