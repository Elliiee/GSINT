package easy;
import java.util.*;
public class Prob1 {
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if (map.containsKey(diff)){
                return new int[]{i, map.get(diff)};
            } else {
                map.put(nums[i], i); //note it's not putting diff, putting current nums[i]!
            }
        }
        return null;
    }
}
