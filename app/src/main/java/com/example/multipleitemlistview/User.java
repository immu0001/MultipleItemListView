package com.example.multipleitemlistview;

public class User {
    private String FirstName;
    private String LastName;
    private String fColour;

    public User(String fName, String lName, String fcolor) {
        FirstName = fName;
        LastName = lName;
        fColour = fcolor;
    }

    public String getFirstName() {
        return FirstName;
    }
    public String getLastName(){
        return LastName;
    }
    public String getFavColor(){
        return fColour;
    }

}
