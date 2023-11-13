# 1. Hello World

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
     - Notice how line 5 ends with a semicolon. Any statement (aka the stuff inside of these {}) must end with a semicolon. Otherwise, you will get a syntax error and your code will not run.
2. Click the terminal button in the top, then hit "New Terminal"
3. Save your file
4. Run `./gradlew run` in terminal to see it print
    - Note: If you get permission denied, run: `chmod 755 gradlew`
5. Change the message to one of your choosing (school appropriate)
6. Save the file
7. In your terminal, run:
    1. `git add *`
    2. `git commit -m "Exercise 1"`
    3. `git push`
8. Follow any instructions it may give you

## Additional git commands (do your own research!)
- `git checkout -b <branch_name>`
- `git log -a`
- `git branch -a`
- `git fetch` vs. `git pull`
- `git tag` on successful

java
    package com.koibots;

    public final class Main {
        public static void main(String... args) {
            System.out.println("Welcome to the Koibots!");
        }
    }
    