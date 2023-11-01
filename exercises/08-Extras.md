# 8. Extras

## Lesson

### Recursion

Recursion is an alternative to iteration where a function calls itself until a condition has been met. For example, 
```java
class Main {

    public static int factorial( int n ) {
        if (n != 0)  // termination condition
            return n * factorial(n - 1); // recursive call
        else
            return 1;
    }

    public static void main(String[] args) {
        int number = 4, result;
        result = factorial(number);
        System.out.println(number + "! = " + result);
    }
}
```
as opposed to,
```java
class Main {
    public static int factorial( int n ) {
        int out;
        
        for (int i; i < n; i++) {
            result *= i;
        }
        
        return out;
    }
    
    public static void main(String[] args) {
        int number = 4, result;
        result = factorial(number);
        System.out.println(number + "! = " + result);
    }
}
```
Both of these solutions do the same thing and look the same from the perspective of the main function. Recursion is useful in some cases for readability and in some rarer cases performance.

### Enums

Enums are special classes that allow you to store arbitrary constants. Enums are not instantiated by the user, they reference constants that can be accesses with `enum.Value`.
```java
public enum DayOfWeek {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}
```

Enums can also have values.

```java
public enum Elements {
    HYDROGEN(1.00797),
    HELIUM(4.00260),
    LITHIUM(6.941),
    BERYLLIUM(9.01218),
    BORON(10.81),
    CARBON(12.011),
    NITROGEN(14.0067),
    OXYGEN(15.9994),
    FLUORINE(18.998403);

    public final double atomicWeight;

    Element(double atomicWeight) {
        this.atomicWeight = atomicWeight;
    }
}
```

### Lambdas

Java allows you to reference a function with lambda expressions. This is useful when you need to pass a function as a parameter. Generally lambda functions look like:
```java
// Without parameters
() -> motor.set(0)

// With parameters
(x) -> motor.set(x)
```

They can also be defined inline
```java
motor::set
```

### Singletons

A class is a singleton when only one instance of a class should exist. Usually this looks like:
```java
class Singleton {
    private static Singleton instance = new Singleton();
    
    public static Singleton getInstance() {
        return instance;
    }
}
```

They can also be statically initialized:
```java
class Singleton {
    private static Singleton instance;
    
    static { // Called the first time a class is accessed statically
        instance = new Singleton();
    }
    
    public static Singleton getInstance() {
        return instance;
    }
}
```

### Interfaces & Abstract Classes

Interfaces and abstract classes allow you to template a class. This allows other classes to use any class that implements or extends the interface or abstract class.

```java
public interface ExampleInterface {
    private double interfaceVariable;
    
    private double interfaceMethod(double x);
}
```

```java
public abstract class ExampleAbstractClass {
    private double abstractClassVariable;
    
    private double abstractClassMethod(double x) {
        return x;
    }
}
```

Abstract classes allow you to define default definitions for methods that can be overloaded while still preventing the class from being instantiated.

## Instructions

There aren't any for this one, but this stuff will be talked about later, so make sure you understand it.

Have main.java just print out a message saying something along the lines of "done with extras"

Commit & Push