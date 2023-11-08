package com.koibots;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public final class Main {
    public static void main(String... args) {
        int num = 10;
        BufferedReader BufReader = new BufferedReader(new InputStreamReader(System.in));
        String input = BufReader.readLine();

        while (num != 0) {
            System.out.println(num);
            num--;
        }

        while (input != "8230") {
            System.out.println("\n");
            input = BufReader.readLine();
        }
    }
}
