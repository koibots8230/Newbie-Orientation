package com.koibots;

import java.lang.System;
import java.util.Random;
//import java.util.HashMap;
// import java.util.Scanner;
//import com.koibots.Constants;

public final class Main {
    private static Main main = new Main();

    public static int Number = 0;
    public static void main(String... args) {
        Shangwen shangwen = main.new Shangwen("purple", true);
        System.out.println(shangwen.Art("robin"));
    }

    class Shangwen {
        public String hairColor; 
        public Boolean isPretty;

        Shangwen(String hairColor,Boolean isPretty) {
            this.hairColor = hairColor;
            this.isPretty = isPretty;
        }

        public String Art(String Bird) {
            return Bird;
        }
    }
}