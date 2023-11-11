package com.koibots;
import java.lang.System;
import java.util.*;

public final class Main{
    public static void main(String... args) {
        String[] gamesinlibrary = {"3", "4", "too many"};
        gamesinlibrary[2] = "too many + 1";
        System.out.println(gamesinlibrary[2]);

        HashMap<Integer, String> BlacksburgTeams = new HashMap<Integer, String>();

        BlacksburgTeams.put(8230, "KoiBots");
        BlacksburgTeams.put(401, "Copperhead Robotics");
        BlacksburgTeams.put(1086, "Blue Cheese");
        BlacksburgTeams.put(1793, "The Aviators");
        BlacksburgTeams.put(5724, "Spartan Robotics");

        Object[] BlacksburgTeamNums = BlacksburgTeams.keySet().toArray();

        System.out.println(BlacksburgTeams.get(401));
        System.out.println(BlacksburgTeams.get(1793));
        System.out.println(BlacksburgTeamNums[0]);
        System.out.println(BlacksburgTeamNums[4]);
    }
}