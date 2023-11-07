# 4. Data Structures

If you have any issues related to your code not seeing the neccesary libraries, for example Hasmaps, try putting this line at the top of your code:
```java
import java.util.*; 
```
If this still doesn't work use a online IDE like [this one](https://www.w3schools.com/java/tryjava.asp?filename=demo_compiler), but still add that line at the top. Also don't worry if it takes a while to run, that's normal

## Lesson

### First, comments

Not part of the Data structures lesson, just a small feature you should know about. By default when you run your code it will read everything that you have written, but sometimes you want it to ignore some things. This is called commenting, because it is often used to explain code without your explanation being run as part of the code

```java
int number = 5; //this is a comment, everything after the 2 backlashes is ignored but only for this line
boolean value = true; // here is another
//int other = 10; you can also comment out lines of valid code like this, everything after the 2 backlashes is ignored
/* 
this is another way to define comments that span multiple lines, you start it with /* and end it with */
int next = 15;
```

It should be noted that making good variable names is significantly preferred to using comments, use them as little as possible and write good variable names.

### What are Data Structures?

A data structure is a way of organizing data within a program. You have already been introduced to variables like integers or strings, a data structure is just a format for arranging it. Say for example that we are writing code for the 2023 game and we want to model where game pieces have already been placed in a row on the grid. Just as a reminder the grid has 3 rows each with 9 spots for a game piece to be placed inside. If you were just trying to model one row how would you do it? Well here is one way:

```java
boolean p1 = false; //a true or false value, true means a game piece has been placed, false means it hasn't
boolean p2 = false;
boolean p3 = false;
boolean p4 = false;
boolean p5 = false;
boolean p6 = false;
boolean p7 = false;
boolean p8 = false;
boolean p9 = false;
```
In this example if our robot scored in the third position than we could change it like this:
```java
p3 = true;
```

But this is cumbersome, there are a lot of variables that are redundant. So what if instead all of the values were in a list that was just one variable, and we could just access the variable for the position we wanted by asking the list for that variable? This is exactly what data structures can do.

## A Data Structure Approach

There are a few different data structures available in Java: 

|Name|Purpose|
|---|---|
|Array|A list of fixed size that is fast|
|Dynamic Array|Another type of List but it can change in capacity and is accessed as a class|
|Hashmap| A list of key value pairs|
|Linked List|same as a Dynamic array for most practical purposes|
|Stack| A "last in first out" type of linked list|
|Queue| A "first in first out" data structure where data is removed from a different side than it is added to|
|Binary Tree| A series of nodes where each node makes a reference to it's "children" nodes and to it's "parent" nodes|
|Heap| A type of overcomplicated binary tree that deals with applications involving priority|
|Graph| A data structure where data is virtually represented as having "edges" and "vertices"|

For almost all robotics purposes the only data structures we will be using are Arrays and Hashmaps

### Array

Lets start with an array. An array is simple to use but has some limitations: 
- You cannot add values to it, when you create the array you are stuck with however many values are in it
- Every element in the array must be the same type of variable
- You cannot remove values from the array

However, none of these effect our application! People aren't coming onto the field and taking away scoring locations in the middle of a match so the length of our array doesn't need to change. And all of the elements in the array store the same **type** of variable, a boolean. Note that I said type, the actual values held by the variables can be different (and we need them to be).

```java
boolean[] Nodes = new boolean[9]; //creating a list called "Nodes" with 9 elements

Nodes[5] = true; // changing the value of the variable to true in position... 4???
```
In the first line we create a list called Nodes that holds 9 separate variables, and the variables are all of the boolean type. Each individual value is accessed by giving the name of the list and the "index" of the value. One thing to keep in mind however is that indexes don't start at one, they start at 0. To access the first value you would use
```java
Nodes[0] = true;
```
and to access the last you would use
```java
Nodes[8] = true;
```
even though the total length is 9

So here is a way we can model the 2023 grid with functions to both change the value of nodes and access the value of nodes

```java
import java.util.*;

class ArrayDemo {

	public static void main (String[] args) {

	    boolean[] LowNodes = new boolean[9];
		boolean[] MidNodes = new boolean[9];
		boolean[] HighNodes = new boolean[9];

		HighNodes[0] = true; // changes value of the first node on the high row to true, remember, indexes start at 0 not 1
		MidNodes[8] = true; // changes value of the last Mid node to true
		System.out.println(HighNodes[0]); // gets the value of the first high node and prints it, should print "true"
	    
	}
}
```

### Array Exercise

In the 2019 game there were 4 "rocket ships", The rocket ship had 3 columns, each of the columns had 3 scoring locations. Model 1 rocket ship with 3 arrays:
* Two of the columns contained locations to place "hatches", create 2 arrays called `HatchColumnClose` and `HatchColumnFar` which should each store 3 boolean values for where hatches have and haven't been placed
* In the middle there was a column where you placed large balls in one of three scoring locations. Create a `BallColumn` array of 3 **integers**, integers because instead of saying wether or not a ball was placed it will store how many balls were placed. In your excersice change it so that `HatchColumnClose` and `HatchColumnFar` have both had their bottom scoring location scored on and there are 2 balls in the top scoring location of `BallColumn`, then print out each of their values to make sure it worked. It doesn't matter but it is preffered if you model the bottom as `[0]`.

As an optional exercise arrays can also hold arrays as elements, try changing my code for the 2023 grid to only contain 1 array. A "multi-dimensional array" as they are called can be defined like this:
```java
int[][] arrays = { array1, array2, array3, array4, array5 };
```
This creates a array called array containing 5 arrays. The curly braces are another way of defining arrays, we don't need a number for the length because we have shown in the braces that there will be 5 elements

Commit & Push your changes

### Hashmaps

A hashmap is like a vector but instead of using an index it uses a 'key'. Every element is actually a key value pair, both the key and the value can be any type of variable but it has to be consistent throughout the Hashmap. 

basically instead of accessing your value with a number you access it with a variable of your choice. For example if you want to know what the FRC game was for a particular year you can use a hashmap, instead of using a regular index that starts at 0 you can use whatever kind of index you want! Since we are using year we can still input an integer but we don't need to start at zero

```java
import java.util.*;

class ArrayDemo {

	public static void main (String[] args) {

	    HashMap<Integer, String> FRC_Games = new HashMap<Integer, String>();

        FRC_Games.put(2011, "Logo Motion");
        FRC_Games.put(2012, "Rebound Rumble");
        FRC_Games.put(2013, "Ultimate Ascent");
        FRC_Games.put(2014, "Aerial Assist");
        FRC_Games.put(2015, "Recycle Rush");
        FRC_Games.put(2016, "Stronghold");
        FRC_Games.put(2017, "Steamworks");
        FRC_Games.put(2018, "Power Up");
        FRC_Games.put(2019, "Deep Space");
        FRC_Games.put(2020, "Infinite Recharge");
        FRC_Games.put(2021, "No Game");
        FRC_Games.put(2022, "Rapid React");
        FRC_Games.put(2023, "Charged Up");

        System.out.println(FRC_Games.get(2023));//should print "Charged Up"
	    
	}
}
```

Like a dynamic array hashmaps can change in size and are accessed like a class, here are a few useful methods for hashmaps:

|Name|Purpose|
|---|---|
|`put(key, value)`|Appends the specified element to the end of the hashmap.|
|`get(key)`|Returns the value with the associated key in the hashmap.|
|`remove(key)`| Removes the element with this as its key|
|`size()`| Returns the number of elements in the hashmap|
|`keySet()`| Returns a list of all of the keys in the hashmap|
|`values()`| Returns a list of all of the values in the hashmap|

The last 2 methods, `keySet()` and `values()` become more important once we cover loops.

### Exercise 

[Here](https://www.thebluealliance.com/event/2024vabla) is a list of teams going to Blacksburg, what will be our first event next year. Create a hashmap that has at least 5 teams in it. Print out all of the team names, then all of the team numbers. (i.e. Koibots, Copperhead Robotics, Newton Squared, then 8230, 401, 8592)

Commit & Push your Changes