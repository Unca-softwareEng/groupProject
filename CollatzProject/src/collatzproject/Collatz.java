
package collatzproject;


import java.util.List;


public interface Collatz {
    List<Integer> getCollatzNumbers(int lowerBound, int upperBound, String predicateType, int predicateNumber);
    List<CollatzCalculation> getCalculations(int lowerBound, int upperBound, String predicateType, int predicateNumber);
}
