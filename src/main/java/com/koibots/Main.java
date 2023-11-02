package com.koibots;

import java.lang.System;
import com.koibots.Constants;

public final class Main {
    public static void main(String [] args) {
       if (Constants.intNumber == 3){
        System.out.println("this number is three");
       } else if (Constants.intNumber % 2 == 1){
        System.out.println("this is really weird");
       }
       else {
        System.out.println("whoopsie daisy!");
       }
    }
}