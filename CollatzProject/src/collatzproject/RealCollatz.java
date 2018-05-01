/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collatzproject;

import java.util.ArrayList;
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

    List<List<Integer>> collatzNums = new ArrayList<>();
    
    public RealCollatz(int lowerBound, int upperBound) {

        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        collatzListInitialization(lowerBound, upperBound, collatzNums);
    }

    //initializer for collatz list. This will start with index 0 as lower, this may cause issues with indexing and can be changed
    //the size of each sublist will be the number of iterations
    //we should test this by comparing this in testing to the iteration number in the proxy
    private void collatzListInitialization(int lower, int upper, List<List<Integer>> list){
        for(int i = lower; i <= upper; i++){
            int temp = i;
            List<Integer> tempList = new ArrayList<>();
            while(temp != 1){
                tempList.add(temp);
                if(temp%2 == 0){
                    temp = temp/2;
                } else {
                    temp = (3*temp) + 1;
                }
            }
           list.add(tempList);
        }
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


    @Override
    public List<Integer> getCollatzNumbers(int lowerBound, int upperBound, String predicateType, int predicateNumber) {
        return null;
    }

    @Override
    public List<List<Integer>> getCalculations(int lowerBound, int upperBound, String predicateType, int predicateNumber) {
        return null;
    }
}
