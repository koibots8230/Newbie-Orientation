# 6. Classes

## Lesson

As you might remember from the introduction slideshow, a class is an object that holds other objects. A class is made up of two things: methods and attributes. 

Let's take the example of a car. A car can have certain attributes: brand, model, color. A car can also have certain methods or functions: drive forward, drive backward, brake, turn. 

Let's keep going with the idea of a car. First, we have to define our car class. 
```java
public class Car {

}
```
You might recognize that kind of deceleration. In fact, you've been seeing one this whole time. Java, as an object-oriented language, requires every file to have a class, and every piece of code to be in that class. So, your Main.java and your Constants.java both have a class deceleration. 

### Constructors

Before we can do anything with our class, we have to create a constructor. A constructor is run whenever a class is instantiated(when an instance of it is created). When the class is instantiated, it can be given a set of data in the form of arguments. These arguments can be of any type.
Here's an example of a constructor for our car example:
```java
public class Car {
    public String brand;
    public String model;
    public String color;

    public Car(String brand, String model, String color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }
}
```
You may notice that we are defining our variables *before* we set their values. This is helpful in this case, because it allows us to set them in the constructor, once we have their values.

### Attributes

An attribute is just a variable that is inside of a class. That's it. It can be any type, it can be public or private, whatever. 

Here we take in 3 arguments: *brand*, *model*, and *color*, all of the *String* type. We then use these arguments to set the attributes of the class to those same values. 

For anyone wondering, the *this* keyword simply refers to the current object. You'll most often see it used just like this, to differentiate between arguments and attributes. 

### Initializing the Class

Now that we have our constructor, let's initialize our class. To do that back in main(), we simply have to put:
```java
Car greyFordF150 = new Car("Ford", "F150", "Grey");
```
You'll notice that, in this case, the type of the variable is Car, as the class serves as it's own data type. 

Another thing you might notice is the *new* keyword. *New* is how you tell java that you want to initialize this class. Without it, it just won't initialize the class. 

You can also make multiple instances of a class, with different attributes. For example, we can create a blue honda accord:
```java
Car blueHondaAccord = new Car("Honda", "Accord", "Blue");
```

### Methods

Ok, now onto the other main piece of a class: methods. If you know what a function is, a method is similar, but it has some small differences.

A method is a block of code generally meant to perform a specific task. The code is only run when the method is called. The method can take in arguments, and it can return a value, but it does not have to. Here's an example using our car class(this is still inside of the car class!):
```java
public double driveForward(double speed) {
    Block of code goes here
    return mph
}
```
Because java is statically typed, functions are required to specify their return type. In this case, the function returns a double, so we specify double. If it returns nothing, we would instead use *void* as the type.

Here's where methods become different than functions. Methods belong to a class, so they can't just be called out of the blue. You have to call a method using an already initialized instance of the class. Let's take our Ford F150 for example:
```java
double milesPerHour = greyFordF150.driveForward(10.5);
```
This calls the driveForward command for the ford F150, but <u>not</u> any other instance of the car class, like our Honda Accord. In this case, we're passing it the value of 10.5, and setting it's result to the `milesPerHour` variable.

## Instructions

1. Delete any previous code
2. In your Main class, create a new class representing an object of your choosing (school appropriate)
   - Make sure the object can realistically have both attributes and a method
3. Define your attributes
4. Make the constructor, and set the attributes by passing them in as arguments
5. Create a method relevant to your object with at least one argument, and create some form of program to represent the action that changes depending on the argument
6. Make your method returns something(if it doesn't really fit, this can be as simple as a confirmation message)
7. Initialize your class in the main(String... args) method
8. Call your method and print out what it returns
9. Run your code
10. Commit & Push your code