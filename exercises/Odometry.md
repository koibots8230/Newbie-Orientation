# 14. Odometry

## Lesson

Oftentimes, it's helpful to know where the robot is on the field. Odometry is one way to do that. Odometry relies on having the robot start at a set position, and makes use of encoders to track movement from that position. 

Ok, so let's say that the robot starts at (1, 2) and facing forward, in meters from the bottom right corner of the felid. The robot moves forward 1 meter. Odometry would count encoder rotations, do some simple math to turn that into distance, and update the position to (1, 3) and facing forward. 


### Inaccuracy

The problem with odometry is that it looses accuracy fast. The minute the robot hits something, goes on uneven ground, is bumped by another robot, whatever. 

Let's take the example of the charge station from last year's game. The charge station was essentially a wide se-saw, and robots would get points for balancing on it at the end of auto, and at the end of the match. As a short robot with one of the most consistent balances in the district, we oftentimes were the ones balancing during auto. 

The thing is, since the charge station goes at an angle, when the robot travels 1m, it doesn't actually travel 1m forward on the field because the hypotenuse is longer than the base of a right triangle. 

While this is a big problem, odometry can still be helpful for the autonomous phase, because you most likely will not encounter obstacles, as it's uncommon for obstacles to be present in the area where autonomous is. 

### In Code

In code, odometry is defined like this:
```java
DifferentialDriveOdometry odometry = new DifferentialDriveOdometry(
    rotation2d,
    leftEncoderStarting,
    rightEncoderStarting,
    startingPose
);
```
There's 3 main things we need to break down here:
- Rotation 2d
- Starting Encoder Positions
- Starting Pose

**Rotation 2d**

This is simply the yaw rotation that the gyroscope is currently reporting. If you need a refresher on which one pitch is, here's a diagram: 

<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHRw7O9wdp_pFfY-2tVcWOFlnW5wcUXgnAbq9C6QwGsosnqZU6t5eLlQukgFNDCLAQ32I:https://upload.wikimedia.org/wikipedia/commons/f/fa/6DOF_en.jpg&usqp=CAU" height="175">

This is expressed as a rotation2d object, defined as follows:
```java
Rotation2d rotation = new Rotation2d(gyroAngleAsDouble);
```

**Starting Encoder Positions**

This is the starting positions of the encoders in meters. This is going to be zero, as you should be resetting your encoders when you initialize. 

**Starting Pose**

This is expressed as a Pose2d object, which is defined as the following:
```java
Pose2d pose = new Pose2d(xAsDouble, yAsDouble, Rotation2d);
```

*Note:* This argument is optional, but if you don't specify, you'll be assumed to be at (0, 0), which is the bottom right corner of the field. 

**Back to the Odometry Object**

Ok, so we have the odometry object, but how do we use it? There's two main things we have to do with this object: update it, and get the pose from it. The great thing is, one thing accomplishes both!

To do it:
```java
Pose2d odometryPose = odometry.update(
    leftEncoder.getPosition(),
    rightEncoder.getPosition()
);
```
This should be in a periodic. This also is assuming you set the conversion factor to change the rotations into distance. 

### Swerve

What I've taught you here is about differential, or tank drive. This year, we are planning on using swerve drive, which is done a little differently. If you want to take a look at the docs for this, it can be found [here](https://docs.wpilib.org/en/stable/docs/software/kinematics-and-odometry/swerve-drive-odometry.html).