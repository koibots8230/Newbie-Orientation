package com.koibots;

import java.lang.System;
import com.koibots.Constants; 

public final class Main {
    public static void main(String... args) {
        int intNumber = 6;

        if (intNumber == 3) {
            System.out.println("intNumber is three!!");
        } else if (intNumber % 2 == 1) {
            System.out.println("the remainder of intNumber divided by two is ONE :O");
        } else {
            System.out.println("booo >:(");
        }
    }
}
