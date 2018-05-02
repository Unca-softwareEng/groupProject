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
    private final String [] predicateTypes = {"Multiple", "Prime", "Power"};
        
        
    
    //constructor for quick calculation of results only
    public CollatzProxy(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        realCollatz = new RealCollatz(lowerBound, upperBound);
        
    }

    
    private boolean isPowerOf(int toCheck, int power){
        int temp = toCheck;
        while(temp > (power - 1) && temp%power == 0){
            temp = temp/power;
        }
        if(temp==1){
            return true;
        }
        return false;
    }
    
    private boolean isPrime(int n){
        if(n==2){
            return true;
        }
        if(n%2 == 0){
            return false;
        }
        for(int i = 3; (i^2)<n; i+=2){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    @Override
    public CollatzNumbers getCollatzNumbers(int lowerBound, int upperBound){
        return realCollatz.getCollatzNumbers(lowerBound, upperBound);
    }
    @Override
    public List<CollatzCalculation> getCalculations(int lowerBound, int upperBound){
        return realCollatz.getCalculations(lowerBound, upperBound);
    }

/**
 * This is the getCollatzNumbers function for non-prime predicates
 * @param lowerBound
 * @param upperBound
 * @param predicateType
 * @param predicateNumber
 * @return
 * @throws IllegalArgumentException 
 */
    public CollatzNumbers getCollatzNumbers(int lowerBound, int upperBound, String predicateType, int predicateNumber)throws IllegalArgumentException {
        boolean illegalPred = true;
        for(int i = 0; i < predicateTypes.length; i++){
            if(predicateType.equals(predicateTypes[i])){
                illegalPred = false;
            }
        }
        
        if(illegalPred){
            throw new IllegalArgumentException("Predicate type must be Multiple, Power, or Prime");
        }
        if(predicateType.equals("Prime")){
            throw new IllegalArgumentException("Please do not pass a predicate number for a prime predicate");
        }
        if(lowerBound < this.lowerBound) {
            throw new IllegalArgumentException("Lower bound must not be less than initial lower bound");
        }
        if(upperBound > this.upperBound) {
            throw new IllegalArgumentException("Upper bound must not be greater than initial upper bound");
        }
        CollatzNumbers unfilteredList = realCollatz.getCollatzNumbers(lowerBound, upperBound);
        List<Integer> filteredList = new ArrayList<>();
        List<Integer> initialIntList = new ArrayList<>();
        if(predicateType.equals("Multiple")){
            for(int i = 0; i < unfilteredList.getCollatzNums().size(); i++){
                if(unfilteredList.getInitialInts().get(i)%predicateNumber == 0){
                    filteredList.add(unfilteredList.getCollatzNums().get(i));
                    initialIntList.add(i);
                }
            }
        }
        if(predicateType.equals("Power")){
            for(int i = 0; i < unfilteredList.getCollatzNums().size(); i++){
                if(isPowerOf(unfilteredList.getInitialInts().get(i), predicateNumber)){
                    filteredList.add(unfilteredList.getCollatzNums().get(i));
                    initialIntList.add(i);
                }
            }
        }
        return new CollatzNumbers(initialIntList, filteredList);
    }
    
    /**
     * This is the getCollatzNumbers function for prime predicate
     * @param lowerBound
     * @param upperBound
     * @param predicateType
     * @return
     * @throws IllegalArgumentException 
     */
    public CollatzNumbers getCollatzNumbers(int lowerBound, int upperBound, String predicateType)throws IllegalArgumentException {
        if(!predicateType.equals("Prime")){
            throw new IllegalArgumentException("Predicate specify a predicate number for non-prime predicates");
        }
        if(lowerBound < this.lowerBound) {
            throw new IllegalArgumentException("Lower bound must not be less than initial lower bound");
        }
        if(upperBound > this.upperBound) {
            throw new IllegalArgumentException("Upper bound must not be greater than initial upper bound");
        }
        CollatzNumbers unfilteredList = realCollatz.getCollatzNumbers(lowerBound, upperBound);
        List<Integer> filteredList = new ArrayList<>();
        List<Integer> initialIntList = new ArrayList<>();
        for(int i = 0; i < unfilteredList.getCollatzNums().size(); i++){
            if(isPrime(unfilteredList.getInitialInts().get(i))){
                filteredList.add(unfilteredList.getCollatzNums().get(i));
                initialIntList.add(i);
            }
        }
        
        return new CollatzNumbers(initialIntList, filteredList);
    }
    /**
     * This is the getCalculations function for non-prime predicates
     * @param lowerBound
     * @param upperBound
     * @param predicateType
     * @param predicateNumber
     * @return
     * @throws IllegalArgumentException 
     */
    public List<CollatzCalculation> getCalculations(int lowerBound, int upperBound, String predicateType, int predicateNumber)throws IllegalArgumentException {
        boolean illegalPred = true;
        for(int i = 0; i < predicateTypes.length; i++){
            if(predicateType.equals(predicateTypes[i])){
                illegalPred = false;
            }
        }
        if(illegalPred){
            throw new IllegalArgumentException("Predicate type must be Multiple, Power, or Prime");
        }
        if(predicateType.equals("Prime")){
            throw new IllegalArgumentException("Please do not pass a predicate number for a prime predicate");
        }
        if(lowerBound < this.lowerBound) {
            throw new IllegalArgumentException("Lower bound must not be less than initial lower bound");
        }
        if(upperBound > this.upperBound) {
            throw new IllegalArgumentException("Upper bound must not be greater than initial upper bound");
        }
        
        
        List<CollatzCalculation> unfilteredList = realCollatz.getCalculations(lowerBound, upperBound);
        List<CollatzCalculation> filteredList = new ArrayList<>();
        if(predicateType.equals("Multiple")){
            for(int i = 0; i<unfilteredList.size(); i++){
                if(unfilteredList.get(i).getInitialInt()%predicateNumber == 0){
                    filteredList.add(unfilteredList.get(i));
                }
            }
        }
        if(predicateType.equals("Power")){
            for(int i = 0; i<unfilteredList.size(); i++){
                if(isPowerOf(unfilteredList.get(i).getInitialInt(), predicateNumber)){
                    filteredList.add(unfilteredList.get(i));
                }
            }
        }
        return filteredList;
    }
    /**
     * This is the gerCalcuations function for prime predicate
     * @param lowerBound
     * @param upperBound
     * @param predicateType
     * @return
     * @throws IllegalArgumentException 
     */
    public List<CollatzCalculation> getCalculations(int lowerBound, int upperBound, String predicateType)throws IllegalArgumentException {
        if(!predicateType.equals("Prime")){
            throw new IllegalArgumentException("Predicate specify a predicate number for non-prime predicates");
        }
        if(lowerBound < this.lowerBound) {
            throw new IllegalArgumentException("Lower bound must not be less than initial lower bound");
        }
        if(upperBound > this.upperBound) {
            throw new IllegalArgumentException("Upper bound must not be greater than initial upper bound");
        }

        List<CollatzCalculation> unfilteredList = realCollatz.getCalculations(lowerBound, upperBound);
        List<CollatzCalculation> filteredList = new ArrayList<>();
        for(int i = 0; i<unfilteredList.size(); i++){
            if(isPrime(unfilteredList.get(i).getInitialInt())){
                filteredList.add(unfilteredList.get(i));
            }
        }
        return filteredList;
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
