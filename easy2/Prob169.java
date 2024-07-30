package easy2;
import java.util.*;
/*
 * 169. Majority Element
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times. 
 * You may assume that the majority element always exists in the array.
 */
public class Prob169 {
    public int majorityElement(int[] nums){
        int major = -1; 
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()){
            if (e.getValue() > nums.length/2){
                major = e.getKey();
            }
        }
        return major; 
    }
}
