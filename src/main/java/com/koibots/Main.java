package com.koibots;

import java.lang.System;
import java.util.Random;
//import java.util.HashMap;
// import java.util.Scanner;
//import com.koibots.Constants;

public final class Main {
    public static int Number = 0;
    public static void main(String... args) {
        int x = 10;
        while (x >= 0) {
            System.out.println(x);
            x--;
        }
        Random rand = new Random();
        int[] daList = {1, 10, 2, 8, 3, 4, 5, 9, 6, 7};
        for (int i = 0; i < daList.length; i++) {
           daList[i] = rand.nextInt(10);
            System.out.println(daList[i]);
        }
        
        // Scanner in = new Scanner(System.in);
        // System.out.println("Enter a number:");
        // while (true){
        //     if (in.hasNextInt()){
        //         Number = in.nextInt();
        //         in.nextLine();
        //         if (Number == 8230){
        //             System.out.println("\ncorrect");
        //             break;
        //         } else {
        //             System.out.println("\nwrong");
        //         }
        //     }
        // }
        // in.close();

    }
}