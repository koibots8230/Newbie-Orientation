package com.koibots;

import java.util.HashMap;

public final class Main {
    public static void main(String... args) {

        
        HashMap <Integer , String> FRC_Teams = new HashMap <Integer, String>();

        FRC_Teams.put(401, "Copperhead Robotics");
        FRC_Teams.put(449, "The Blair Robot Project");
        FRC_Teams.put(977, "Cometbots");
        FRC_Teams.put(1086, "Blue Cheese");
        FRC_Teams.put(4575, "Gemini");
        
        var teamname = FRC_Teams.values().toArray();
        var teamnumber = FRC_Teams.keySet().toArray();
       

        System.out.println(teamnumber[1]);
        System.out.println(teamnumber[4]);
        System.out.println(teamname[2]);
        System.out.println(teamname[3]);
        
        

    }
}
