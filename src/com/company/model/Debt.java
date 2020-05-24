package com.company.model;

import java.util.*;

public class Debt {

    public Person debitor;
    public Person creditor;
    public float debt;

    public Debt(Person creditor, Person debitor, float debt){
        this.debitor = debitor;
        this.creditor = creditor;
        this.debt = debt;
    }

    public boolean contains(Person x, Person y){
        if (x.name == this.creditor.name && y.name == this.debitor.name)
            return true;
        if(x.name == this.debitor.name && y.name == this.creditor.name)
            return true;

        return  false;
    }
}
