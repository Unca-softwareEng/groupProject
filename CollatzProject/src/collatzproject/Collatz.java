
package collatzproject;


import java.util.List;


public interface Collatz {
    CollatzNumbers getCollatzNumbers(int lowerBound, int upperBound);
    List<CollatzCalculation> getCalculations(int lowerBound, int upperBound);
}
