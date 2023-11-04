package com.koibots;

import java.lang.System;
// import com.koibots.Constants; 
import java.util.HashMap;

public final class Main {
    public static void main(String... args) {
        HashMap<Integer, String> teams = new HashMap<Integer, String>();

        teams.put(8230, "Koibots");
        teams.put(1086, "Blue Cheese");
        teams.put(9003, "TuTu Turtles");
        teams.put(5804, "TORCH");
        teams.put(9403, "Starstuff");

        System.out.println(teams.values());
        System.out.println(teams.keySet());
    }
}
