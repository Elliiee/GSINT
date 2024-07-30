package easy;
/*
 * 2006. Count Number of Pairs With Absolute Difference K
 * Given an integer array nums and an integer k, 
 * return the number of pairs (i, j) where i < j such that |nums[i] - nums[j]| == k.
 * (absolute different is k)
 * The value of |x| is defined as:
 * x if x >= 0.
 * -x if x < 0.
 */
import java.util.*;
public class Prob2006 {
    //brute force 
    public int countKDifference(int[] nums, int k){
        int count = 0; 
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                int absDiff = Math.abs(nums[i] - nums[j]);
                if (absDiff == k) count++;
            }
        }
        return count; 
    }

    //hashmap 
    public int countKDifference2(int[] nums, int k){
        int count = 0; 
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
            count += map.getOrDefault(num - k, 0) + map.getOrDefault(num + k, 0);
        }
        return count; 
    }
}
