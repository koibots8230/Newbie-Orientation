# 16. Autonomous

## Lesson

### What Even is Autonomous?

Autonomous is a 15 second period at the start of every match, where only code is running. No human input whatsoever. 

During autonomous, scoring gives you more points than it would during teleop, so it's important to maximize what you do during those 15 seconds. 

### How does Autonomous Work?

In code, autonomous is simply a set of instructions. Things like drive forward, intake this, drive back, shoot it. Once you have all the commands set up for creating an autonomous, it immediately becomes fairly simple to create more. 

The only hard part with making an autonomous routine is figuring out driving paths. There's two parts of this that are a little tricky: distances and curves. 

Let's start with distances. To make a good autonomous, you have to make the robot travel a precise distance. There are many ways you can do this, but the most accurate way is to use encoders. Making the command that travels a certain distance isn't too bad, but the tricky part is figuring out the encoder value. The only way to really do this is to guess and check a whole bunch. 

Now onto curves. You won't be getting a perfectly straight path 100% of the time. Often, you'll have to make the robot curve to get to it's destination. The easiest way to do this is to have the two sides of the tank drive move at different speeds. When it comes down to what speeds and what encoder values, guess what? You have to guess and check again. 

*Note:* Some tools exist to make drive paths simpler and more efficient, and we are working on getting one to work, but for now, we're going to stick with this approach. 

### Command Groups

Ok, so you have all your commands, and you know what you have to do. How do you do it in code? Let's talk about command groups. 

Command groups are, as the name explains, groups of commands. There are 4 basic kinds: Sequential, Parallel, Parallel Race, and Parallel Deadline.

**Sequential**

Sequential command groups run commands in a sequence. The first command goes, then the second, then the third, etc. In almost any situation, a sequential command group is what your overall autonomous is going to be(yes, command groups can go inside of other command groups). 

**Parallel**

Parallel command groups, as the name suggests, run commands in parallel. Parallel command groups finish once <u>all commands</u> have finished.

**Parallel Race**

Parallel race groups are similar to normal parallel groups, but instead of ending when all commands are finished, they instead end once <u>any</u> of the commands have finished. This will interrupt(end) any still running commands.

A good use of these is to put one of your commands with a wait command, which just ends after a set amount of time. This makes it so your command will run for a set period of time, without having to code it into your command.

**Parallel Deadline**

Parallel deadline groups are quite similar to race groups, but instead of ending when any command finishes, it ends when a specific command finishes, interrupting any still running commands.

### Making a Command Group

There are two ways to make a command group. You can make a subclass of one of them, or do it inline.

For your overall autonomous group, you want to have it be a subclass. Here's how you do that:
```java
public class Auto extends SequentialCommandGroup {

    public Auto() {
        addCommands(
            Command1,
            Command2,
            Command3,
            etc.
        );
    }
}
```
If you want to use a different command group, simply replace "Sequential" with the type of your choosing. 

Inline command groups are generally going to be your parallel types, and they go in that `addCommands()` method. Here's how to make one:
```java
addCommands (
    new ParallelCommandGroup(Command1, Command2, Command3, etc.),
    new ParallelRaceGroup(Command1, Command2, Command3, etc.)
);
```
Don't forget to separate with commas

You can put as many commands in a group as you want, but try not to put too many in parallel, or you might strain the roboRIO(the computer on the robot). 

## **A Safety Note:**

Autonomous routines are great to make and see run on the robot, but they can be very dangerous. We do not have control over the robot during an auto, so we have to make sure we are extra cautious. Before you run an auto, make sure all of these things are met:
- You and other people are a safe distance away from the robot
- You and other people are out of the expected path of the robot
- You or someone else is ready to hit the emergency stop button (spacebar)
- You yell "enabling" **before** you enable the robot

Another thing to note: for these purposes, there is no reason to have the robot go above 50% speed in autonomous. It often decreases accuracy, and invites the opportunity for someone to get hurt. **Keep the speed below 50%.**

**Reminder: Failure to follow safety guidelines will result in <u>immediate disciplinary action</u>. This is not a joke. People can get hurt.**