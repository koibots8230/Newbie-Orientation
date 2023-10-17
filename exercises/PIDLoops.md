# 17. PID Loops

Read pages 24-38 of [Controls Engineering in FRC](https://file.tavsys.net/control/controls-engineering-in-frc.pdf). Think about how this would apply to a motor running at a set velocity(RPM). 

To construct a PID controller in code, use the following:
```java
PIDController pidController = new PIDController(kP, kI, kD);
```

To use the PID controller:
```java
motor.setVelocity(pidController.calculate(encoder.getVelocity(), setPoint));
```
The setPoint is the speed you want the motor to go at.