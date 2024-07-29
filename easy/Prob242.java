package easy;
import java.util.*;
public class Prob242 {
    public boolean isAnagram(String s, String t){
        if (s.length() != t.length()){
            return false; 
        }

        int[] countS = new int[26];
        int[] countT = new int[26];

        for (int i = 0; i < s.length(); i++){
            countS[s.charAt(i) - 'a']++;
            countT[s.charAt(i) - 'a']++;
        }
        return Arrays.equals(countS, countT);
    }
}
