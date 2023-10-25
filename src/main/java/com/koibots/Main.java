package com.koibots;

import java.util.HashMap;


public final class Main {
    public static void main(String... args) {
        HashMap<Integer, String> teams = new HashMap<Integer, String>();
        teams.put(1, "Copperhead Robotics");
        teams.put(2, "The Blair Robot Project");
        teams.put(3, "Cometbots");
        teams.put(4, "Blue Cheese");
        teams.put(5, "the STAGS");

        System.out.println(teams);
    }
}
