# 2. Variables

---
## Goals

- Learn basic Java Syntax
- Learn how to assign variables
- Learn the different variable types
- Learn how to compile and run a program

## Lesson

Variables are essentially just a value that we assign to a name. We can change the value that the name has, but it will still remain itself. Here's an example of a variable definition:
```java
public final int number = 1;
```
Let's break this down. We can break it into 6 parts
1. public
    - This is a modifier that allows that variable to be seen and edited by other classes. The oppisite of this is *private*, which limits the variable to that class. If you fail to specify, the variable will instead be available to every class within its package (shown at the top of a file)
2. final
    - This makes it so that the variable cannot be edited after this declaration. To not have this, simply don't include the *final* keyword
3. int
    - The variable type. Java is a statically typed language, meaning we have to define the type of a variable in the code. Here's a list of some common variable types:

      |Type|What it is|In code|
      |---|---|---|
      |Integer|Whole number|`int`|
      |Float|Decimal number|`float`|
      |Double|Decimal number, can represent much longer numbers than float|`double`|
      |String|Text|`String`|
      |Boolean|True/False|`boolean`|
  
4. number
    - The name of the variable
5. =
    - Assigns the variable to the value on the right
6. 1
    - The value that is assigned to the variable

## Instructions
1. Create the variable *intNumber* of the type *int* and give it the value 3, then print it out
2. Run the program (If you don't remember how, see [Exercise 1](Task-1.md))
3. Create a new file in *com/koibots* called Constants.java
4. In the file copy/paste the following:
```java
package com.koibots;

public final class Constants {
    
}
```
5. Then add your own public double inside the class using the *final* keyword, name it DOUBLE_NUMBER, and give it the value of 0.5
6. Back in Main.java, print out its value by referencing it as Constants.DOUBLE_NUMBER
   - Note: VS code *should* import Constants.java automatically, but if it doesn't, add `import com.koibots.Constants;` one line below the `import java.lang.System;`
7. Run the program (If you don't remember)
8. Your output should look like this:

    3
    0.5

9. Add, commit and push your changes to your branch
   - If the file has already been git add-ed previously, you can instead use git commit -am "Message" to add and commit at the same time :wink:

## Instructor notes
- Have them work with the style guide
- Have them make a constants file
- Different variable types
  - double
  - int
  - lists
