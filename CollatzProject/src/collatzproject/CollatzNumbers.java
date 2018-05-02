
package collatzproject;

import java.util.List;


public class CollatzNumbers {
    List<Integer> initialInts;
    List<Integer> collatzNums;
    public CollatzNumbers(List<Integer> initialInts, List<Integer> collatzNums){
        this.initialInts = initialInts;
        this.collatzNums = collatzNums;
    }
    public List<Integer> getCollatzNums(){
        return collatzNums;
    }
    public List<Integer> getInitialInts(){
        return initialInts;
    }
}
