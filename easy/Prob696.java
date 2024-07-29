package easy;

public class Prob696 {
    public int countBinarySubstrings(String s){
        /*
         * Approach 1 group by character 
         * 这题没有什么数据结构，就是算法很难想到
         */

         int[] groups = new int[s.length()];
         int t = 0; 
         groups[0] = 1;
         for (int i = 1; i < s.length(); i++){
            if (s.charAt(i-1) != s.charAt(i)){
                groups[++t] = 1;
            } else {
                groups[t]++;
            }
         }
         int ans = 0;
         for (int i = 1; i <= t; i++){
            ans += Math.min(groups[i-1], groups[i]);
         }
         return ans; 
    }
}
/*
 * Given a binary string s, return the number of non-empty substrings 
 * that have the same number of 0's and 1's, 
 * and all the 0's and all the 1's in these substrings are grouped consecutively.
 * Substrings that occur multiple times are counted the number of times they occur.
 * example: 
 * Input: s = "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: 
 * "0011", "01", "1100", "10", "0011", and "01".
 */
