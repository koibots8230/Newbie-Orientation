package com.koibots;

import java.lang.System;
// import java.util.Scanner;
// import java.util.Random;
// import com.koibots.Constants; 
// import java.util.HashMap;

class Toaster {
    public int strength;

    public Toaster(int strength) {
        this.strength = strength;
    }

    public String toast(String food) {
        if (this.strength < 1) {
            return food;
        } else if (this.strength > 5) {
            return "ash";
        } else {
            // Normal strength
            if (food == "bread") {
                return "toast";
            } else {
                return "toasted " + food;
            }
        }
    }
}


public final class Main {
    public static void main(String... args) {
        Toaster niftyToaster = new Toaster(2);
        Toaster weirdToaster = new Toaster(8);
        Toaster brokenToaster = new Toaster(0);

        System.out.println(niftyToaster.toast("waffle"));
        System.out.println(niftyToaster.toast("bread"));

        System.out.println(weirdToaster.toast("bread"));

        System.out.println(brokenToaster.toast("singular banana coin"));
    }
}
