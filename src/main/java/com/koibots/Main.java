package com.koibots;
import com.koibots.Mouse;

public final class Main {
    public static void main(String [] args) {
        Mouse bartoloMyLove = new Mouse ("Bartolo", "black", 100); //ell oh ell.
        Mouse hippyLoser = new Mouse ("hippyLoser", "purple", 3);

        String BpublicOpinion = bartoloMyLove.publicOpinion(bartoloMyLove.name); //the B is for Bartolo
        String HpublicOpinion = hippyLoser.publicOpinion(hippyLoser.name); //the H is for hippyLoser.
        
        System.out.println(BpublicOpinion);
        System.out.println(HpublicOpinion);
    }
    }
