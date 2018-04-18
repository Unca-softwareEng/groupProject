/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collatzproject;

/**
 * @author Stuart Pelletier
 */
public class CollatzProxy implements Collatz {
    public RealCollatz realCollatz;
    private int lowerBound;
    private int upperBound;
    public String predicateType;
    public int predicateNumber;


    //constructor for quick calculation of results only
    public CollatzProxy(int lowerBound, int upperBound, String predicateType, int predicateNumber) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.predicateType = predicateType;
        this.predicateNumber = predicateNumber;
    }


    //constructor for full chain of calculation. requires a realCollatz object.
    public CollatzProxy(RealCollatz realCollatz, int lowerBound, int upperBound, String predicateType, int predicateNumber) {
        this.realCollatz = realCollatz;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.predicateType = predicateType;
        this.predicateNumber = predicateNumber;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public String getPredicateType() {
        return predicateType;
    }

    public void setPredicateType(String predicateType) {
        this.predicateType = predicateType;
    }

    public int getPredicateNumber() {
        return predicateNumber;
    }

    public void setPredicateNumber(int predicateNumber) {
        this.predicateNumber = predicateNumber;
    }
}
