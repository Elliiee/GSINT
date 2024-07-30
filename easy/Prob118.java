package easy;
/*
 * 118. Pascal's Triagnle 
 * This is different from problem 119 as 119 is only asking for 1 row. 
 * Here is the first n rows; 
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 1 <= numRows <= 30
 */
import java.util.*;
public class Prob118 {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> triangles = new ArrayList<>();
        for (int i = 0; i < numRows; i++){
            List<Integer> row = getRow(i);
            triangles.add(row);
        }
        return triangles;
    }

    private List<Integer> getRow(int rowIndex){
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
