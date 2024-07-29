package easy;
/*
 * You are given an array of integers nums. 
 * You are also given an integer "original" which is the first number 
 * that needs to be searched for in nums.
 * You then do the following steps:
 * If original is found in nums, multiply it by two (i.e., set original = 2 * original).
 * Otherwise, stop the process.
 * Repeat this process with the new number as long as you keep finding the number.
 * Return the final value of original.
 */
import java.util.*;
public class Prob2154 {
    public int findFinalValue(int[] nums, int original){
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            set.add(num);
        }
        while (true){
            if (set.contains(original)){
                original *= 2; 
            } else {;
                break;
            }
        }
        return original;
    }
}
