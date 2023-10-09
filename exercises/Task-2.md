# 2. Variables

---
## Goals

- Learn basic Java Syntax
- Learn how to assign variables
- Learn the different variable types
- Learn how to compile and run a program

## Lesson


Variable definition format: `public/private modifiers type name = value;`

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
5. Then add your own public double inside the class using the *final* modifier, name it DOUBLE_NUMBER, and give it the value of 0.5
6. Back in Main.java, print out its value by referencing it as Constants.DOUBLE_NUMBER
   - Note: VS code *should* import Constants.java automatically, but if it doesn't, add `import com.koibots.Constants` just below the `package com.koibots`
7. Run the program (If you don't remember)
8. Your output should look like this:
`
  3
  0.5
`

## Instructor notes
- Have them work with the style guide
- Have them make a constants file
- Different variable types
  - double
  - int
  - lists
