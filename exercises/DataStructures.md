# 4. Data Structures

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

For almost all robotics purposes the only data structures we will be using are Arrays, Linked lists and Hashmaps

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

		void changeNode(int level, boolean value, int number){
			//level represents Low, Mid or High as 1,2 or 3
			//value represents if we are changing it to true or false
			//number represents the number of the scoring location within the row, between 1 and 9
			if (level == 1){
				LowNodes[level - 1] = value; //subtract 1 because we want the input to be between 1 and 9 but indexes start at 0
			}
			if (level == 2){
				MidNodes[level - 1] = value;
			}
			if (level == 3){
				HighNodes[level - 1] = value;
			}
		}

		boolean GetNodeValue(int level, int number){
			if (level == 1){
				return LowNodes[level - 1];
			}
			if (level == 2){
				return MidNodes[level - 1];
			}
			if (level == 3){
				return HighNodes[level - 1];
			}
		}
	    
	}
}
```

### Array Exercise

In the 2017 game there were 4 "hoppers", two on the red side and two on the blue side. These were large ball dispensing machines. They held literally dozens of balls at the start of the match and when a team hit a lever they would all be released onto the field. Model the behavior of these hoppers with arrays, make a `ChangeHopperValue` function and a `GetHopperValue` function. In the game when a hopper was triggered it was triggered for the whole match, the balls were not going back in. How can you use this to simplify the `ChangeHopperValue` function?

As an optional exercise arrays can also hold arrays as elements, try changing my code for the grid to only contain 1 array. A "multi-dimensional array" as they are called can be defined like this:
```java
int[][] arrays = { array1, array2, array3, array4, array5 };
```
This creates a array called array containing 5 arrays. The curly braces are another way of defining arrays, we don't need a number for the length because we have shown in the braces that there will be 5 elements

Commit & Push your changes

### Dynamic arrays

A Dynamic array is very similar to a Array with a couple key differences

- The list can change in size
- used as a class

Vector classes are a type of linked list and have a unusual definition

```java
Vector<Integer> myvector = new Vector<Integer>(20); //creates a vector of 20 integers
myvector.add(15); //adds a additional value of 15 to the end of the vector
myvector.get(20); //gets the value we just added (indexes start at 0)
```
The syntax is a little scary, don't worry you don't have to understand the purpose of the <> symbols just understand that whatever is inside is the type of variable used. `add()` and `get()`are methods that are called on the vector. Think of them like functions that only work for vectors. In fact there are dozens of methods that you can use on vectors, you can see them all [here](https://www.geeksforgeeks.org/java-util-vector-class-java/) but these are the only ones that you need to know how to use, and don't feel obligated to memorize them:

|Name|Purpose|
|---|---|
|`add(value)`|Appends the specified element to the end of this Vector.|
|`get(index)`|Returns the element at the specified position in this Vector.|
|`removeElement(value)`| Removes the first (lowest-indexed) occurrence of the argument from this vector.|
|`removeElementAt(index)`| Deletes the component at the specified index.|
|`size()`| Returns the number of components in this vector.|



### Hashmaps

A hashmap is like a vector but instead of using an index it uses a 'key'. Every element is actually a key value pair, both the key and the value can be any type of variable but it has to be consistent throughout the Hashmap. 

basically instead of accessing your value with a number you access it with a variable of your choice. For example if you want to know what the FRC game was for a particular year you can use a hashmap, instead of using a regular index that starts at 0 you can use whatever kind of index you want! Since we are using year we can still input an integer but we don't need to start at zero

```java
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

String lastYear = FRC_Games.get(2023);
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