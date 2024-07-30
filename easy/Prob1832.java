package easy;
/*
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 * Given a string sentence containing only lowercase English letters, 
 * return true if sentence is a pangram, or false otherwise.
 */
import java.util.*;
public class Prob1832 {
    public boolean checkIfPangram(String reference){
        Set<Character> set = new HashSet<>();
        for (char c : reference.toCharArray()){
            set.add(c);
        }
        return set.size() == 26;
    }
}
