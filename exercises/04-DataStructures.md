# 4. Data Structures

If you have any issues related to your code not seeing the neccesary libraries, for example Hasmaps, try putting this line at the top of your code:
```java
import java.util.*; 
```
If this still doesn't work use a online IDE like [this one](https://www.w3schools.com/java/tryjava.asp?filename=demo_compiler), but still add that line at the top. Also don't worry if it takes a while to run, that's normal

## Lesson

### What are Data Structures?

A data structure is simply a way of organizing data within a program. You have already been introduced to variables like integers or strings, a data structure is just a format for arranging it. 

For example, say we were writing code for last year's game and we want to model which grid spots are already filled. As a quick reminder, the grid was a 3x9 well, grid, and looked like this:

<img src="https://i.ytimg.com/vi/J70qFwiUek0/maxresdefault.jpg" height="200">

Let's say we want to model just the top row of this. If we're just using basic variables, we'd have to do it something like this:

```java
boolean piece1Placed = false;
boolean piece2Placed = false;
boolean piece3Placed = false;
boolean piece4Placed = false;
boolean piece5Placed = false;
boolean piece6Placed = false;
boolean piece7Placed = false;
boolean piece8Placed = false;
boolean piece9Placed = false;
```
In this example if our robot scored in the third position than we could change it to like this:
```java
boolean piece1Placed = false;
boolean piece2Placed = false;
boolean piece3Placed = true;
boolean piece4Placed = false;
boolean piece5Placed = false;
boolean piece6Placed = false;
boolean piece7Placed = false;
boolean piece8Placed = false;
boolean piece9Placed = false;
```

But this is cumbersome and messy, there are way to many variables. So, what if instead all of the values, we made a list that was just one variable, and we could just access the value for the position we wanted by asking the list for that value? This is exactly what data structures can do.

### A Data Structure Approach

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

### Arrays

Lets start with an array. An array is simple to use but has some limitations: 
- You cannot add values to it, when you create the array you are stuck with however many values are in it
- Every element in the array must be the same type (int, double, etc.)
- You cannot remove values from the array

However, none of these effect our application! People aren't coming onto the field and taking away scoring locations in the middle of a match so the length of our array doesn't need to change. And all of the elements in the array are booleans, so type isn't an issue.

Let's try and make our grid model with an array. To start, we have to create the array
```java
boolean[] row1Nodes = {false, false, false, false, false, false, false, false, false};
```

Now that we have the array, let's use it. Say that we placed a piece in position 3. To model this, we'd use:
```java
row1Nodes[2] = true;
```

Wait, didn't I say position 3? That says 2! The thing is, that does edit position 3. 

To edit an array, we use what is called an index, which essentially tells the computer what number element we want to access. The thing is, instead of starting at 1, like you might be used to, indices start at 0. So, when we want to access, say, the 3rd element, we have to use the index of 2. 

If we want to read an element of the list, it works pretty much the same as writing. If we wanted to simply print it out, we'd use:
```java
System.out.println(row1Nodes[2]);
```

### Hashmaps

The technical definition of a hashmap is a set of key-value pairs. But what does this mean? 

Essentially, instead of using indices to access values, hashmaps use keys. Keys can be any value, of any type. Each key directly corresponds to a value, which can also be of any type. The best way to explain this is with an example. Let's say we wanted to map years to their FRC game:

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
        FRC_Games.put(2021, "No Game, COVID Year");
        FRC_Games.put(2022, "Rapid React");
        FRC_Games.put(2023, "Charged Up");
```

Something to note here is that while keys and values can be any type, they have to be a *consistent* type. In this case, the keys are of the *int* type, and the values are of the *String* type

Like a dynamic array, hashmaps can change in size and are accessed like a class. Here's a few useful methods for hashmaps:

|Name|Purpose|Example|
|---|---|---|
|`put(key, value)`|Adds the specified key-value pair to the end of the hashmap|`map.put("Key", "Value");"`|
|`get(key)`|Returns the value with the associated key in the hashmap|`map.get("Key");` Would return "Value"|
|`remove(key)`| Removes the element with this as its key|`map.remove("Key");`|
|`size()`| Returns the number of elements in the hashmap|`map.size();`|
|`keySet()`| Returns a list of all of the keys in the hashmap|`map.keySet()`|
|`values()`| Returns a list of all of the values in the hashmap|`map.values()`|

The last 2 methods, `keySet()` and `values()` become more important once we cover loops.

### Exercise 

1. Clear previous changes
2. Make an array containing a set of values that represent something of your choosing
3. Edit one of the values & print out that value
4. [Here](https://www.thebluealliance.com/event/2024vabla) is a list of teams going to Blacksburg, what will be our first event next year. Create a hashmap that has at least 5 teams in it where the number is the key and the value is the team name.
5. Print out the name of the 2nd and 4th team in the array
6. Print out the number for the 1st and 5th team in the array
   - *Note:* The `keySet()` method technically returns a type called *Set*, but for these purposes, add `toArray()` so that it looks like this: `map.keySet().toArray()` this will get you an array, which you already know how to work with

Commit & Push your Changes