# 1. Hello World

---
## Goals

 - Learn basic Java Syntax
 - Learn the basics of Git
 - Learn how to compile and run a program
 - Familiarity with your IDE

## Instructions 
1. Currently ```src/main/java/com/koibots/Main.java``` looks like this:

    ```java
    package com.koibots;

    public final class Main {
        public static void main(String... args) {
            System.out.println("Welcome to the Koibots!");
        }
    }
    ```
     - Notice how line 5 ends with a semicolon. Any statement (aka the stuff inside of these {} ) must end with a semicolon. Otherwise, you will get a syntax error and your code will not run.
2. Click the terminal button in the top, then hit "New Terminal"
3. Save your file
4. Run `./gradlew run` to see it print
5. Change the message to one of your choosing (school appropriate)
6. Save the file
7. In your terminal, run:
    1. `git add *`
    2. `git commit -m "Exersise 1"`
    3. `git push`
8. Follow any instructions it may give you



## Addditional git commands (do your own research!)
- `git checkout -b <branch_name>`
- `git log -a`
- `git branch -a`
- `git fetch` vs. `git pull`
- `git tag` on successful