# 7. Object Oriented Programming

## Lesson

Object-Oriented Programming, or OOP, is a programming model. As the name explains, it's based around objects.

Instead of focusing on pure logic, OOP focuses on objects. In java, an object is an instance of a class. The great thing about java is that almost everything is a class!

Let's take our car example from our last lesson. I'll program it in both procedural programming(not OOP) and OOP.

### Procedural Programming:
```java
public final class Main {
    public static void main(String... args) {
        String[] fordF150Attributes = {"Ford", "F150", "Grey"};
        String[] hondaAccordAttributes = {"Honda", "Accord", "Blue"};

        System.out.println(fordF150Attributes[0]);
        System.out.println(hondaAccordAttributes[0]);

        double speed = 10.5;
        double mph;
        if (speed > 10) {
            mph = speed * Constants.multVal;
        } else if (speed < 10) {
            mph = speed / Constants.divVal;
        } else {
            mph = speed + Constants.plusVal;
        }
        double fordF150Mph = mph;

        speed = 11.8;
        if (speed > 10) {
            mph = speed * Constants.multVal;
        } else if (speed < 10) {
            mph = speed / Constants.divVal;
        } else {
            mph = speed + Constants.plusVal;
        }
        double hondaAccordMph = mph;
    }
}
```
### OOP:
```java
public final class Main {

    public static class Car {
        public String brand;
        public String model;
        public String color;

        public double mph;

        public Car(String brand, String model, String color) {
            this.brand = brand;
            this.model = model;
            this.color = color;
        }

        public double driveForward(double speed) {
            double mph;
            if (speed > 10) {
                mph = speed * Constants.multVal;
            } else if (speed < 10) {
                mph = speed / Constants.divVal;
            } else {
                mph = speed + Constants.plusVal;
            }
            return mph;
        }
    }

    public static void main(String... args) {
        Car fordF150 = new Car("Ford", "F150", "Grey");
        Car hondaAccord = new Car("Honda", "Accord", "Blue");
        
        System.out.println(fordF150.brand);
        System.out.println(hondaAccord.brand);

        fordF150.mph = fordF150.driveForward(10.5);
        hondaAccord.mph = hondaAccord.driveForward(11.8);
    }
}
```
Even though the OOP version is a bit longer, it:
- A: Is much cleaner and easier to work with
- B: Is much more easily expandable to more car models
- C: Does not repeat the same code needlessly

## Instructions

Make a new instance of your class from the last lesson & call the method