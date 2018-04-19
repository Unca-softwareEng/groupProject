/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collatzproject;

import java.util.List;

/**
 *
 * @author Stuart Pelletier
 */
public class RealCollatz implements Collatz{
    private int lowerBound;
    private int upperBound;
    public String predicateType;
    public int predicateNumber;


    @Override
    public List<Integer> generateCollatzNumbers(int lowerBound, int upperBound, String predicateType, int predicateNumber) {
        return null;
    }

    @Override
    public List<CollatzCalculation> generateCalculationChain(int lowerBound, int upperBound, String predicateType, int predicateNumber) {
        return null;
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

    public RealCollatz(int lowerBound, int upperBound, String predicateType, int predicateNumber) {

        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.predicateType = predicateType;
        this.predicateNumber = predicateNumber;
    }


}
