package com.company.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Activity {
    public String title;
    public ArrayList<Person> attendees;
    public float cost;
    public Person payer;
    public ArrayList<Debt> debts;

    public Activity(String title, float cost, Person payer, ArrayList<Person> attendees){
        this.title = title;
        this.cost = cost;
        this.payer = payer;
        this.attendees = attendees;
        this.debts = this.calculateAllDebts(this.payer, this.attendees, this.cost);
    }

    private ArrayList<Debt> calculateAllDebts(Person payer, ArrayList<Person> attendees, float cost) {
        ArrayList<Debt> allDebtsInActivity = new ArrayList<>();

        for (Person attendee:attendees) {
            Debt tmp = new Debt(payer, attendee, cost/(attendees.size()+1));
            allDebtsInActivity.add(tmp);
        }

        return  allDebtsInActivity;
    }

    public void calculateValues(){

        float debtsTotal = 0;

        for (Debt debt: debts) {
            debtsTotal += debt.debt;
        }
        System.out.println("Die Person "+ payer.name+ " bekommt insgesamt noch " + debtsTotal+"€");

        for (Debt debt: debts){
            System.out.println(debt.debitor.name +" schuldet " + debt.creditor.name + " noch " + debt.debt+" €");
        }
    }
}
