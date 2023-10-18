# 11. Tank Drive

## Lesson 

A drive train is what makes the robot move. It can come in many forms, but it will always use some form of wheels driven by motors. Tank drive(or west coast drive) is a type of drive train where two sides of non rotating wheels are controlled individually. 

<img src ="https://d2t1xqejof9utc.cloudfront.net/screenshots/pics/6478164315ddc20dbdc4f4c07864fc3a/large.png" height ="200">

### How to Control Tank Drive 

We use Xbox controllers to control the robot. More specifically, we have it so the left joystick's y-axis controls the left side, and the right joystick the right. 

Keep in mind, because the controller isn't perfect, the joysticks are not going to be at a perfect 0. So, it's a good idea to create a deadzone for them. We do this by checking if the joystick's value is greater than |0.15|, and if it isn't, just ignoring the input.

### How to Make Controllers  
To create a Xbox controller, use the following syntax: 
```java
XboxController controller = new XboxController(0);
```
To get the positions of the joysticks, use this syntax:
```java
controller.getRightY();

controller.getLeftY();
```
This will return the value of the y-axis, expressed as a percentage with 1 and -1 being 100% in either direction(just like our motors!)

## Swerve

Here, you've been taught how to do tank drive. But, this year, the team is planning on making a different kind of drivetrain called swerve drive. We aren't teaching you swerve yet because there isn't a swerve for you to test on at the moment. But, if you want to research and learn more about swerve, be our guest. You do not have to though, we will teach it when the time comes.

## Instructions  
 
1. Create a working, controllable tank drive system
  - Left side motor ID is *have to check this* right side motor ID is *have to check this* 
  - *Note:* You already have all the knowledge you need to make this. If you need to, refer back to previous lessons. Try your best to do this on your own, but if you need help, you are more than welcome to ask.
2. Commit and push your changes
3. When you are done, go see Jake to get your code running on a robot
<!--- Instructor note: This will run on cuttlefish, because jankbot doesn't have sparkmaxes --->
