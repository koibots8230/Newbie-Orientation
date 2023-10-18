# 3. Conditionals & Expressions

## Lesson

Conditionals are statements in code that check for the 'truth' of something. Most often, you will see these as 'if' statements. An example of an if statement would be:
```java
if (1 + 1 == 2) {
    System.out.println("1 + 1 = 2")
}
```
We can break this down into three parts:
1. The 'if' keyword itself
2. The boolean expression
3. The body

### Boolean Expressions
The 'if' keyword is self-explanatory, so we can get right into the boolean expression. A Boolean is a variable type that is either *true* or *false*. By making the statement *1 + 1 == 2*, we are giving the conditional a expression that will evaluate to true, because 1 + 1 does in fact equal 2. 

You can use three different kinds of operators to make boolean expressions: Arithmetic Operators, Comparison Operators, and Logical Operators.

Arithmetic operators are used for any arithmetic you would want to use, inside or outside of a boolean expression.
|Arithmetic Operator|What it means|
|---|---|
|`+`|Addition|
|`-`|Subtraction|
|`*`|Multiplication|
|`/`|Division|
|`%`|Modulus, divides and gives the remainder|

Comparison operators are what actually gives you the truth of a boolean expression, they are what "asks the question".
|Comparison Operator|What it means|
|---|---|
|`==`|Equal to|
|`!=`|Not Equal to|
|`<`|Less Than|
|`>`|Greater Than|
|`<=`|Less Than or Equal to|
|`>=`|Greater Than or Equal to|

Logical operators are used when you want to chain multiple boolean expressions together, or when you want to get the inverse of a boolean.
|Logical Operator|What it Does|In Code|
|---|---|---|
|*and*|Chains two booleans together, where both have to be true for the whole expression to be true|`a && b`|
|*or*|Chains two booleans together, where one or the other has to be true|`a || b`|
|*not*|Reverses the Boolean, if it was true, it's now false, and vice versa|`!a`|

### The Body

The body of a conditional is what is actually run if your boolean expression evaluates to true. Going back to our above example, that would be 
```java
System.out.println("1 + 1 = 2")
```
You can have as much or as little code as you want inside of a conditional. In the case of an if statement, the body is everything that is inside of the {} curly brackets. 

### Else and Else If Statements

Normally, should your if statement evaluate to false, it will simply be skipped and the program will move on. But, if you have an *else* or *else if* statement, won't. *Else if* is essentially just another if statement, it is only run if all if or else if statements above it have evaluated to false. *Else* does the same thing, only without a boolean expression, so if the code reaches else, it will always be run. 
Here's an example:

```java
if (a == 1) {
    System.out.println("a = 1")
} else if (a == 2) {
    System.out.println("a = 2")
} else {
    System.out.println("a != 1 || 2")
}
```
Breaking this down, the first thing that would be checked is if *a* = 1. If it does, print it, if not, we then check if *a* = 2. If it does, print it, if not, we print that it does not equal 1 or two.

### Ternary

In Java if statements are not the only kind of conditional. Another prominent form is the ternary operator. The ternary operator, represented by the '?', is a form of an if-else statement that returns a value. The syntax works as follows:
`(boolean expression) ? Value returned if true : Value returned if false`
The ternary operator is helpful for compactly assigning a value based on certain conditions. Here's an modified example of how we used it in last year's code:
```java
sign = (input < 0) ? -1 : 1
input = sign * Math.pow(input, 2)
```
What this does is allow us to square the variable *input* using Math.pow, but still keep its sign.

## Instructions
1. Remove all previous print statements
2. In Main.java, create an if statement that checks if the value of intNumber equals 3. In the body, have it print whatever you want (school appropriate though please)
3. Run the program, your message should print
4. Add an else if statement that checks if the remainder of intNumber divided by 2 is 1, and in the body, make it print a different message. Change the value of intNumber to 5.
5. Run the program, your new message should print
6. Add an else statement at the end, and have it print a different message from the other two
7. Instead of setting the value of intNumber to 5, now set it to a number of your choosing
8. Run your program. If the value of intNumber is 3, you should get your first print statement, if the value is odd and not 3, you should get your second, and if it is neither, you should get your third. Experiment with each of these to see how they all work.
9. Experiment with the logical operators and ternary however you see fit
10. Commit and push your changes to your branch.