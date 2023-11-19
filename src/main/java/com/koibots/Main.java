package com.koibots;


public final class Main {

    public static void main(String... args) {

        int v = 10;
        
        while (v > 0){
            System.out.println(v);
            v--;
        }
       
        Fish coelacanth = new Fish(8, 2, true);
        boolean theyDidAte = coelacanth.eat("shoe");
    }

    public static class Fish {
        public int numOfFins;
        public int numOfeyes;
        public boolean hasScales;
       
        public Fish(int numOfFins, int numOfeyes, boolean hasScales) {
            this.numOfFins = 8;
            this.numOfeyes = 2;
            this.hasScales = true;
        }
        

        public boolean eat(String food) {
            System.out.println(food);

            
            if (food == "steak" ) {
                return true;
            }
            return false;
        }

    
       
    }
 
    
}
