package com.koibots;
import com.koibots.Constants;
import java.lang.System;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


 public class Main {
    public static class CelsToFar {
        Integer Celsius;
        Integer Fahrenheit;

        public CelsToFar(Integer Celsius) {
            this.Celsius = Celsius;
        }

        public Integer TEMPINCELS(Integer TEMP){
            Fahrenheit = (int)((TEMP * ((double)9 / 5)) + 32);
            return Fahrenheit;
        }

        public static void main(String[] args) {
            CelsToFar far = new CelsToFar(-40);

            System.out.println(far.Celsius);

             Integer TEMPS = far.TEMPINCELS(-40);

             System.out.println(TEMPS);



            
        }
    }
}