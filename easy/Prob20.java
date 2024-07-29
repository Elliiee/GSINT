package easy;
/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 */
import java.util.*;
public class Prob20 {
    public boolean isValid(String s){
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if (map.containsKey(c)){
                if (stack.isEmpty() || stack.pop() != map.get(c)){
                    return false; 
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
