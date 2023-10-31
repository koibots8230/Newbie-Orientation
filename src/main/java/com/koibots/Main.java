package com.koibots;

import java.lang.System;

public final class Main {
    public static void main(String args[]) {
        Rectangle rectangle = new Rectangle(20,30);
        if (rectangle.print('ƒ')) {System.out.println("Success!");}
    }
}

class Rectangle {
        private int length;
        private int height;

        public Rectangle(int length, int height) {
            this.length = length;
            this.height = height;
        }
        
        public boolean print(char chararcter) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < length; j++) {
                    System.out.print(chararcter);
                    System.out.print(" ");
                }
                System.out.print("\n");
            }
            return true;
        }
    }
