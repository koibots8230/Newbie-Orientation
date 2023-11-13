package com.koibots;
import java.lang.System;
import java.util.Random;
import java.util.Scanner;
import com.koibots.Constants;

public final class Main{
    public static void main(String[] args) {
        int x = 10;
        while (x > 0) {
            System.out.println(x);
            x--;
        }
        System.out.println("-");

        Random rand = new Random();
        int[] randomNums = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int y = 0; y < 10; y++){
            randomNums[y] = rand.nextInt(10);
        }
        for (int z = 0; z < 10; z++){
            System.out.println(randomNums[z]);
        }
        System.out.println("-");

        Scanner inputNum = new Scanner(System.in);
        System.out.println("Enter the KoiBots team number");
        while(true) {
            System.out.println(Constants.KOI_TEAM_NUM);
            int koiTeamNumUser = inputNum.nextInt();
            System.out.println(koiTeamNumUser);
            if (koiTeamNumUser != Constants.KOI_TEAM_NUM) {
                System.out.println("That is incorrect, try again.");
            }
            else {
                System.out.println("That is correct!");
                break;
            }
        }
        System.out.println("-");

        int[] plantedRandNums = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int a = 0; a < 10; a++) {
            int randPlantingNum = rand.nextInt(10);
            int plantingNumPos = a;
            plantedRandNums[plantingNumPos] = randPlantingNum;
            System.out.println(plantedRandNums[plantingNumPos]);
        }
        System.out.println("-");

        int[] randomList = {0, 0, 0, 0, 0};
        for (int b = 0; b < 5; b++) {
            int randomNum = rand.nextInt(50);
            randomList[b] = randomNum;
            if (randomNum % 2 == 0) {
                continue;
            }
            System.out.println(randomList[b]);
        }
    }
}