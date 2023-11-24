package com.koibots;

public final class Main {
    public static void main(String... args) { 
       

        int v = 10;
      
        while (true){
            System.out.println(v);
            v--;

            if (v == -1) {
                break;
            }
        }

       
     
       Fish coelacanth = new Fish(8, 2, true);
       boolean theyDidAte = coelacanth.eat("steak");
       System.out.println(theyDidAte);
       Fish rainbowTrout = new Fish (8, 2, true);
       boolean theyDidAteAgain = rainbowTrout.eat("bug");
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







    
