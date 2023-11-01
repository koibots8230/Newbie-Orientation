# 10. Motors and Encoders

## Lesson

### Installing REV LIb

Before we get started, first you need to have REV lib installed. REV lib is simply a library used to control things like spark maxes. To install it, either press the W icon in the top right of your VS code, or press F1 (you may have to use Fn + F1). Then, find manage vendor libraries in the search bar, hit install new libraries(online), and copy paste the following into the text box: `https://software-metadata.revrobotics.com/REVLib-2023.json`

If you check the *vendordeps* folder, REVLib.json should be there!

### Motors

Motors are the main thing that make the robot move. To put it simply, they spin. To control the motors, we use what are called CAN spark maxes. A spark max is a kind of motor controller, which allows us to easily make the motor move at variable speeds in either direction. To define an instance of a spark max, use the following:
```java
private CANSparkMax motor = new CANSparkMax(Constants.MOTOR_PORT, MotorType.kBrushless);
```
There's two things here that are new to you: motor port and motor type. 

Every spark max has a number, which we use to differentiate between them in code. This is the motor port.

The motor type simply describes if a motor is [brushed or brushless](https://www.powerelectric.com/motor-resources/motors101/what-is-the-difference-between-a-brushless-and-a-brushed-motor). For us, this will only ever be brushless.

Now that you have a motor defined, time to use it. There are many ways to control a motor, but the one we're going to use for now is:
```java
motor.set(1);
```
In this case, I am setting the motor to go at 100% in the positive direction. `motor.set()` uses a percentage-based system with 1 and -1 being the 100% in either direction, and the in-between being decimals. 

There are some other ways to control a motor, such as velocity or voltage control, but `motor.set()` is simpler to understand & tune, so we're just going to use this for now.

Motors have many, many other functions, but some of the most helpful ones are:

|Function|Purpose|In Code|
|---|---|---|
|Following|Makes one motor copy the movement of another motor|`motor.follow(otherMotor);`|
|Inversion|Flips which way 1 and -1 will spin the motor|`motor.setInverted(true);`|
|Idle Mode|Determines how the motor will act when idle. Can either be break or coast. Brake makes the motor resist being moved, coast just allows it to spin. Coast is default|`motor.setIdleMode(IdleMode.kBrake);`|

<a href="https://codedocs.revrobotics.com/java/com/revrobotics/cansparkmax" target="_blank">Here's</a> the full documentation.

### Encoders

Encoders are how we keep track of our motors. All our motors have build in encoders, or, when we need more accuracy, we can use external encoders. These two types of encoders are defined differently in code. When we want to use a built-in encoder, the syntax is:
```java
private final RelativeEncoder encoder = motor.getEncoder();
```
When we want to use an external encoder:
```java
private final RelativeEncoder encoder = motor.getAlternateEncoder(Constants.COUNTS_PER_REVOLUTION);
```

As you can see, both of these create a RelativeEncoder, so once we define them, there is virtually no difference in code. The main thing you are going to be doing with encoders is getting their position. In code, this looks like this:
```java
encoder.getPosition();
```
This gives us the total amount of rotations the <u>encoder</u> has had **since it powered on**. But, we shouldn't be power cycling the robot every time we want to test new code. So, in our teleopInit, we want to add something to reset the encoder positions. For this, we're going to use the following command:
```java 
encoder.setPosition(0);
```
As you might have guessed, this simply sets the encoder position to 0. When you add this to your code, make sure to do it for **all your encoders**, or your measurements will be all messed up. 

Some other helpful encoder methods are:

|Method|Purpose|
|---|---|
|`encoder.getVelocity()`|Gets the RPM of the <u>encoder</u>|
|`encoder.setPositionConversionFactor(factor)`|Allows you to set a number that then multiplies against the position number automatically when you call getPosition|
|`encoder.setVelocityConversionFactor(factor)`|Same thing as above but for velocity|

<a href="https://codedocs.revrobotics.com/java/com/revrobotics/relativeencoder#method.detail" target="_blank">Here's</a> the full documentation.

## Instructions

1. Create a new motor with the ID of 1. Make sure that the ID is stored in constants.
2. During teleopPeriodic, make your motor spin at 50% speed.
3. Create a new motor with the ID of 2 and have it follow your first one
4. Set both motors' idle mode to brake
5. Get the built-in encoder of your first motor.
6. Have it print out its position constantly in teleop
   -  Don't forget to reset the position on teleopInit
7. Set the position conversion factor to 2
8. Make sure the code builds
9. Commit and push your changes
