package com.koibots;

import java.lang.System;
import java.util.HashMap;

import com.koibots.Constants;

public final class Main {
    public static void main(String... args) {
        int intNumber = 150;
        System.out.println("Jake is a cutie.");
        if (intNumber == 3) {
           System.out.println("Java is hard.");
        } else if (intNumber % 2 == 1) {
            System.out.println("Carson finally comes to a meeting!");
        } else {
            System.out.println("Anna is very pretty.");
        }
         HashMap<Integer, String> FRCTeamNames = new HashMap<Integer, String>();

        FRCTeamNames.put(8230, "Koibots");
        FRCTeamNames.put(4099, "Falcons");
        FRCTeamNames.put(5115, "Night Riders");
        FRCTeamNames.put(401, "Copperhead robotics");
        FRCTeamNames.put(2363, "Triple Helix");
        
        String teamname = FRCTeamNames.get(8230);
        System.out.println(teamname);
    }
}
