package com.koibots;

public class Mouse {
        
    public String name;
    public String color;
    public int weight;

    public Mouse (String name, String color, int weight){ //this is a really bad example. I swear i (dont) knwo wat im doing.
        this.name = name;
        this.color = color;
        this.weight = weight; 
    }
    public String publicOpinion(String Name){
        if (name == "Bartolo"){
            return "everybody loves him!";
        } else {
            return "ew, what is that?";
        }
    }

}
