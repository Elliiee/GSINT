package easy;
import java.util.*;
public class Prob844 {
    public boolean backspaceCompare(String s, String t){
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (char c : s.toCharArray()){
            if (c != '#'){
                stack1.push(c);
            } else if (!stack1.isEmpty()){
                stack1.pop();
            }
        }

        for (char c : t.toCharArray()){
            if (c != '#'){
                stack2.push(c);
            } else if (!stack1.isEmpty()){
                stack2.pop();
            }
        }

        return stack1.equals(stack2);
    }
    /*
     * Given two strings s and t, return true if they are equal 
     * when both are typed into empty text editors. '#' means a backspace character.
     * Note that after backspacing an empty text, the text will continue empty.
     * Input: s = "ab#c", t = "ad#c"
     * Output: true
     * Explanation: Both s and t become "ac".
     */

     public static void main(String[] args){
        Prob844 p = new Prob844();
        String s = "ab#c";
        String t = "ad#c";
        System.out.println("s and t backspace same: " + p.backspaceCompare(s, t));
     }
}
