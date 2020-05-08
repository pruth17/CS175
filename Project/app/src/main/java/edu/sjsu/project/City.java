package edu.sjsu.project;

public class City {

    String Name;
    String[] SEE;
    String[] DINE;
    String[] SHOP;
    String[] STAY;
    int[] Image;
    public City(String Name, String[] SEE, String[] DINE, String[] SHOP, String[] STAY, int[] Image){
        this.Name = Name;
        this.SEE = SEE;
        this.DINE = DINE;
        this.SHOP = SHOP;
        this.STAY =STAY;
        this.Image = Image;
    }

    String getName(){
        return Name;
    }

    String[] getSEE()
    {
        return SEE;
    }

    String[] getDINE()
    {
        return DINE;
    }

    String[] getSHOP(){
        return SHOP;
    }

    String[] getSTAY(){
        return STAY;
    }

    int[] getImage(){
        return Image;
    }
}