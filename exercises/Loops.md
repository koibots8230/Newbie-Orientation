# Java Loops Overview

## Lesson

### While Loops
A while loop is a loop that repeats *while* a boolean is true. The following is an example of a while loop being used to count from 0 to 9:
```java
public class Main {
    public static void main(String[] args) {
        int x = 0;
        while (x < 10) {
            System.out.println(x);
            x++;
        }
    }
}
```


### For Loops
A for loop in java is a loop that repeats *for* a certain number of times. The following is an example of a for loop in java. It prints out the numbers 0-9:
```java
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
```
To declare a for loop, use the keyword `for` followed by 3 statements in parentheses separated by semicolons. Then, the block of code to be executed repeatedly is placed between curly braces:
```java
for (statement 1; statement 2; statement 3) {
    //code block to be executed goes here.
}
```
The **first** statement is executed **before** the code block runs, the **second** statement is the **condition** that if met will allow the loop to continue, and the **third** statement runs **each iteration** of the loop.

In the example above, the first statement in the for loop, `int i = 0`, declares the integer `i`, a counting variable for how many iterations are done so far in the loop. The second statement, `i < 10`, is a condition: as long as `i` is less than 10, the loop will continue to run. This condition is checked before every iteration. Lastly, the third statement, `i++`, runs after each iteration of the loop.

The for loop is really a condensed version of the while loop. If you think about it, this code...

```java
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("BOO! Did I scare you?");
        }
    }
}
```
...does the exact same thing as this code...

```java
public class Main {
    public static void main(String[] args) {
        int x = 0;
        while (x < 10) {
            System.out.println("BOO! Did I scare you?");
            x++;
        }
    }
}
```

You can also run the code to test this theory.
`while` loops are more useful when the number of iterations is uncertain and the condition is more complicated than the size of a variable. Otherwise, `for` loops are best because they are more concise.

### For Loops With Lists

One of the most well-known and useful ways to use a for loop is to traverse a list with it and do something with all the elements. The following code example runs a for loop through a list of 10 numbers and prints out each of the numbers:

```java
public class Main {
    public static void main(String[] args) {
        int[] daList = {37, 45, 96, 83, 24, 19, 29, 40, 13, 100};
        for (int i = 0; i < daList.length; i++) {
            System.out.println(daList[i]);
        }
    }
}
```

## Instructions

Delete conditionals code

In your Main.java, have the following run in sequence:
1. Use a while loop to print a countdown from 10 to 0 in the console.
2. Use a for loop to traverse a **randomly generated** list of 10 numbers and print all them out.
3. Use a while loop and a *break*(do research!) statement to ask the user to input a number over and over until the user enters the number 8230.
4. Use a for loop to plant all the contents of a list of 10 numbers in random order.
5. Use a for loop and a *continue*(do research!) statement to only print the odd numbers of a randomly generated list.

Build your code (if you haven't already)

Commit & Push your changes

### Resources

Click [here](https://www.geeksforgeeks.org/generating-random-numbers-in-java/) to go to a webpage explaining how to use random in java.
Click [here](https://www.w3schools.com/java/java_user_input.asp) to go to a webpage explaining how to retrieve user input in java.