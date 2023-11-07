package com.koibots;

import java.lang.System;
import java.util.Scanner;
import java.util.Random;
// import com.koibots.Constants; 
// import java.util.HashMap;

public final class Main {
    public static void main(String... args) {
        // Countdown

        System.out.println("Countdown \n");

        int countdown = 10;
        while (countdown >= 0) {
            System.out.println(countdown);
            countdown--;
        }

        // Generate random number list

        System.out.println("\nList loop \n");

        int[] numberList = new int[10];
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int randomNumber = rand.nextInt(100);
            numberList[i] = randomNumber;
        }

        // Print random list

        for (int i = 0; i < numberList.length; i++) {
            System.out.println(numberList[i]);
        }

        // Input

        System.out.println("\nType in 8230 (please?) \n");

        Scanner scan = new Scanner(System.in);
        int givenNumber = 0;
        while (givenNumber != 8230) {
            givenNumber = scan.nextInt();
        }
        scan.close();

        // Random list in random order??

            // I don't know where to start

        // Only odd numbers of a randomly generated list

        System.out.println("\nOnly odd numbers \n");

        for (int i = 0; i < numberList.length; i++) {
            if (numberList[i] % 2 == 0) {
                continue;
            }
            System.out.println(numberList[i]);
        }
    }
}
