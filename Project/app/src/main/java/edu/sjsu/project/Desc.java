package edu.sjsu.project;

public class Desc {

    String Name;
    String Rating;
    String Details;
    public Desc(String Name, String Rating, String Details){
        this.Name = Name;
        this.Rating = Rating;
        this.Details = Details;
    }

    String getName(){
        return Name;
    }

    String getRating(){
        return Rating;
    }

    String getDetails(){
        return Details;
    }
}