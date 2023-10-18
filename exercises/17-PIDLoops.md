# 17. PID Loops

Read pages 24-38 of [Controls Engineering in FRC](https://file.tavsys.net/control/controls-engineering-in-frc.pdf). And look at the below diagram. Think about how this would apply to a motor running at a set velocity(RPM). 

<img src="https://cdn11.bigcommerce.com/s-t3eo8vwp22/product_images/uploaded_images/pidfdiagram2.png" height="300">

To construct a PID controller in code, use the following:
```java
PIDController pidController = new PIDController(kP, kI, kD);
```

To use the PID controller:
```java
motor.setVelocity(pidController.calculate(encoder.getVelocity(), setPoint));
```
The setPoint is the speed you want the motor to go at.