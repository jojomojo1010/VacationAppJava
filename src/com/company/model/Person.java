package com.company.model;

import java.util.*;

public class Person {
    public String name;
    public int id;

    public Person(String name, int id){
        this.name = name;
        this.id = id;
    }

    private void printDebt(float debt){
        System.out.println("Current debt of" + this.name + " is " + debt);
    }

    public void addDebt(float debt){
        printDebt(debt);
    }


}
