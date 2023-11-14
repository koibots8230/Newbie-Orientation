package com.koibots;
import java.lang.System;
import java.util.Random;
import java.util.Scanner;
import com.koibots.Constants;
import java.util.HashMap;

public final class Main{
    String[] reforgeModifiers = {"Keen", "Superior", "Forceful", "Broken", "Damaged", "Shoddy", "Hurtful", "Strong", "Unpleasant", "Weak", "Ruthless", "Godly", "Demonic", "Zealous"};
    HashMap<String, String> modifierDamage = new HashMap<String, String>();
    HashMap<String, String> modifierCritChance = new HashMap<String, String>();
    HashMap<String, String> modifierKnockback = new HashMap<String, String>();
    public void modifierHashMapSettup() {
        modifierDamage.put("Keen", "+0%");
        modifierCritChance.put("Keen", "+3%");
        modifierKnockback.put("Keen", "+0%");
        modifierDamage.put("Superior", "+10%");
        modifierCritChance.put("Superior", "+3%");
        modifierKnockback.put("Superior", "+10%");
        modifierDamage.put("Forceful", "+0%");
        modifierCritChance.put("Forceful", "+0%");
        modifierKnockback.put("Forceful", "+15%");
        modifierDamage.put("Broken", "-30%");
        modifierCritChance.put("Broken", "+0%");
        modifierKnockback.put("Broken", "-20%");
        modifierDamage.put("Damaged", "-15%");
        modifierCritChance.put("Damaged", "+0%");
        modifierKnockback.put("Damaged", "+0%");
        modifierDamage.put("Shoddy", "-10%");
        modifierCritChance.put("Shoddy", "+0%");
        modifierKnockback.put("Shoddy", "-15%");
        modifierDamage.put("Hurtful", "+10%");
        modifierCritChance.put("Hurtful", "+0%");
        modifierKnockback.put("Hurtful", "+0%");
        modifierDamage.put("Weak", "+0%");
        modifierCritChance.put("Weak", "+0%");
        modifierKnockback.put("Weak", "-20%");
        modifierDamage.put("Ruthless", "+18%");
        modifierCritChance.put("Ruthless", "+0%");
        modifierKnockback.put("Ruthless", "-10%");
        modifierDamage.put("Godly", "+15%");
        modifierCritChance.put("Godly", "+5%");
        modifierKnockback.put("Godly", "+15%");
        modifierDamage.put("Demonic", "+15%");
        modifierCritChance.put("Demonic", "+5%");
        modifierKnockback.put("Demonic", "+0%");
        modifierDamage.put("Zealous", "+0%");
        modifierCritChance.put("Zealous", "+5%");
        modifierKnockback.put("Zealous", "+0%");
    }
    public static class Zenith {
        Random rand = new Random();
        public String modifier;
        public String damage;
        public String critChance;
        public String knockback;
        public int zenithNum;

        public Zenith(String modifier, String damage, String critChance, String knockback){
            this.modifier = modifier;
            this.damage = damage;
            this.critChance = critChance;
            this.knockback = knockback;
        }
        
        public void zenithReforger(Zenith Zenith){
            int modifierNum = rand.nextInt(14) - 1;
            String newModifier = reforgeModifiers[modifierNum];
            String newDamage = modifierDamage.get(newModifier);
            String newCritChance = modifierCritChance.get(newModifier);
            String newKnockback = modifierKnockback.get(newModifier);
            Zenith.modifier = newModifier;
            Zenith.damage = newDamage;
            Zenith.critChance = newCritChance;
            Zenith.knockback = newKnockback;
            System.out.println("You reforged your Zenith! It has a " + newModifier + "modifier, which gives it " + newDamage + " damage, " + newCritChance + " chance to get a critical hit, and " + newKnockback + " knockback.");
        }
    }
    public static void main (String[] args) {
        Zenith zenith = new Zenith("none", "none", "none", "none");
        zenith.zenithReforger(zenith);
    }
}