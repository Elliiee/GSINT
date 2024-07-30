package easy;
/*
 * 119. Pascal's Triangle II 
 * Constraints:0 <= rowIndex <= 33
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it
 */
import java.util.*;
public class Prob119 {
    public List<Integer> getRow(int rowIndex){
        List<Integer> result = new ArrayList<>();
        result.add(1);

        for (int i = 1; i <= rowIndex; i++){
            for (int j = i - 1; j >= 1; j--){
                int temp = result.get(j - 1) + result.get(j);
                result.set(j, temp);
            }
            result.add(1); //add 1 to the end of the row 
        }
        return result; 
    }
}
