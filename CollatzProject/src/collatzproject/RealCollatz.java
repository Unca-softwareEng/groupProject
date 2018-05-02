/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collatzproject;

import java.util.ArrayList;
import java.util.List;


public class RealCollatz implements Collatz{
    private int lowerBound;
    private int upperBound;

    List<CollatzCalculation> collatzNums = new ArrayList<>();

    public RealCollatz(int lowerBound, int upperBound) {

        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        collatzListInitialization();
    }

    private void collatzListInitialization(){
        for(int i = lowerBound; i <= upperBound; i++){
           CollatzCalculation calc = new CollatzCalculation(i);
           collatzNums.add(calc);
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



    @Override
    public CollatzNumbers getCollatzNumbers(int lowerBound, int upperBound) {
        List<Integer> initialInts = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < collatzNums.size(); i++){
            initialInts.add(collatzNums.get(i).getInitialInt());
            numbers.add(collatzNums.get(i).getNumIterations());
        }
        return new CollatzNumbers(initialInts, numbers);
    }
    @Override
    public List<CollatzCalculation> getCalculations(int lowerBound, int upperBound) {
        return collatzNums;
    }
}
