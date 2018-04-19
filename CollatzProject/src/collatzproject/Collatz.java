/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collatzproject;

import java.util.List;

/**
 * @author Stuart Pelletier
 */
public interface Collatz {
    List<Integer> getCollatzNumbers(int lowerBound, int upperBound, String predicateType, int predicateNumber);
    List<CollatzCalculation> getCalculations(int lowerBound, int upperBound, String predicateType, int predicateNumber);
}
