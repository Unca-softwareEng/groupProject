package collatzproject;

import java.util.ArrayList;
import java.util.List;

public class CollatzCalculation {
    private int initialInt;
    private List<Integer> calculationSteps;
    private int numIterations;
    
    public CollatzCalculation(int initialInt) throws IllegalArgumentException{
        if(initialInt <= 0){
            throw new IllegalArgumentException("Input integer must be greater than 0");
        }
        calculationSteps = new ArrayList<>();
        this.initialInt = initialInt;
        initializer();
    }
    private void initializer(){
        int temp = initialInt;
            while(temp != 1){
                calculationSteps.add(temp);
                numIterations++;
                if(temp%2 == 0){
                    temp = temp/2;
                } else {
                    temp = (3*temp) + 1;
                }
            }
    }

    public int getInitialInt(){
        return initialInt;
    }
    
    public List<Integer> calculationSteps(){
        return calculationSteps;
    }
    
    public int getNumIterations(){
        return numIterations;
    }
    
}
