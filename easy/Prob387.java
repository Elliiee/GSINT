package easy;
import java.util.*;
/*
 * Given a string s, find the first non-repeating character in it and return its index. 
 * If it does not exist, return -1. 
 */
class Prob387 {
    public int firstUniqChar(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int length = s.length();

        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < length; i++){
            if (map.get(s.charAt(i)) == 1){
                return i; 
            }
        }

        return -1; 
    }

    public static void main(String[] args){
        String s = "leetcode";
        Prob387 p = new Prob387();
        System.out.println("answer is: " + p.firstUniqChar(s));
    }
}