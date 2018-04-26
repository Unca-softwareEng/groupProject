/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collatzproject;

import java.util.ArrayList;
import java.util.List;

public class CollatzProxy implements Collatz {
    public RealCollatz realCollatz;
    private int lowerBound;
    private int upperBound;
    public String predicateType;
    public int predicateNumber;
    List<Integer> collatzNums = new ArrayList<>();
    

    //constructor for quick calculation of results only
    public CollatzProxy(int lowerBound, int upperBound, String predicateType, int predicateNumber) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.predicateType = predicateType;
        this.predicateNumber = predicateNumber;
        collatzListInitialization(lowerBound,upperBound, collatzNums);
        
    }


    //initializer for collatz list. This will start with index 0 as lower, this may cause issues with indexing and can be changed
    private void collatzListInitialization(int lower, int upper, List<Integer> list){
        for(int i = lower; i <= upper; i++){
            int temp = i;
            int iterations = 0;
            while(temp != 1){
                iterations++;
                if(temp%2 == 0){
                    temp = temp/2;
                } else {
                    temp = (3*temp) + 1;
                }
            }
            collatzNums.add(iterations);
        }
    }
    
    //constructor for full chain of calculation. requires a realCollatz object.
    public CollatzProxy( int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;

    }


    @Override
    public List<Integer> getCollatzNumbers(int lowerBound, int upperBound, String predicateType, int predicateNumber) {
        return null;
    }

    @Override
    public List<CollatzCalculation> getCalculations(int lowerBound, int upperBound, String predicateType, int predicateNumber) {
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


}
