package com.koibots;

import java.lang.System;
import com.koibots.Constants;

public final class Main {
    public static void main(String... args) {
        int intNumber = 3;

        if (intNumber == 3) {
            System.out.println(intNumber);
        }

        if (intNumber % 2 == 1) {
            intNumber = 5;
            System.out.println(intNumber);
        } else {
            System.out.println(intNumber);
            System.out.println(intNumber);
            intNumber = 1987; 

        }


    }
}
