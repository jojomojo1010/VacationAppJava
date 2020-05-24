package com.company;

import com.company.model.Activity;
import com.company.model.Debt;
import com.company.model.Person;

import java.lang.reflect.Array;
import java.util.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<String> person_list_input = new ArrayList<String>(Arrays.asList("Kevin","Joey","Felix","Joshua"));
        ArrayList<Person> person_list = new ArrayList<Person>();
        ArrayList<Activity> activity_list = new ArrayList<Activity>();


        for(int index = 0; index < person_list_input.size(); index++ ) {
            Person tmp = new Person(person_list_input.get(index), index);
            person_list.add(tmp);
        }


        ArrayList <Person> personInFirstActivity = new ArrayList<>();
        personInFirstActivity.add(person_list.get(0));
        personInFirstActivity.add(person_list.get(1));
        personInFirstActivity.add(person_list.get(3));
        activity_list.add(new Activity("Flug",350,person_list.get(2),personInFirstActivity));

        ArrayList <Person> personInSecondActivity = new ArrayList<>();
        personInSecondActivity.add(person_list.get(1));
        personInSecondActivity.add(person_list.get(2));
        personInFirstActivity.add(person_list.get(3));
        activity_list.add(new Activity("Hotel",600,person_list.get(0),personInSecondActivity));

        ArrayList <Person> personInThirdActivity = new ArrayList<>();
        personInThirdActivity.add(person_list.get(0));
        personInThirdActivity.add(person_list.get(2));
        personInFirstActivity.add(person_list.get(3));
        activity_list.add(new Activity("Bar",80,person_list.get(1),personInThirdActivity));

        ArrayList <Person> personInFourthActivity = new ArrayList<>();
        personInThirdActivity.add(person_list.get(0));
        personInThirdActivity.add(person_list.get(2));
        activity_list.add(new Activity("Bar",320,person_list.get(3),personInThirdActivity));

        for(Activity act: activity_list ){
            act.calculateValues();
        }

        calcAllDebts(activity_list,person_list);
    }

    public static void calcAllDebts(ArrayList<Activity> activities, ArrayList<Person> persons){
        ArrayList<Debt> allDebts = new ArrayList<Debt> ();
        ArrayList<Debt> finalDebts = new ArrayList<Debt> ();
        for(Activity activity: activities){
            allDebts.addAll(activity.debts);
        }
        for (int i = 0; i < persons.size(); i++) {
            for (int j=i+1; j < persons.size();j++) {
                Debt tmp = new Debt(persons.get(i),persons.get(j),0);
                finalDebts.add(tmp);
            }
        }
        for (Debt finalDebt : finalDebts){
            for (Debt generalDebt: allDebts){
                if (generalDebt.contains(finalDebt.creditor,finalDebt.debitor) && finalDebt.creditor.name == generalDebt.creditor.name){
                    finalDebt.debt += generalDebt.debt;



                }
                if (generalDebt.contains(finalDebt.creditor,finalDebt.debitor) && finalDebt.creditor.name != generalDebt.creditor.name){
                    finalDebt.debt -= generalDebt.debt;
                }
            }
        }
        System.out.println("----");
        for (Debt finaldebt: finalDebts){
            System.out.println(finaldebt.creditor.name +" erhält von" + finaldebt.debitor.name + " " + finaldebt.debt + "€");
        }
    }
}