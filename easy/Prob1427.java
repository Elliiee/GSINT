package easy;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * You are given a string s containing lowercase English letters, 
 * and a matrix shift, where shift[i] = [directioni, amounti]:
 * direction-i can be 0 (for left shift) or 1 (for right shift).
 * amount-i is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 */
public class Prob1427 {
    //这题自己能写出来但是only beats 8%
    public String stringShift(String s, int[][] shift){
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            deque.add(c);
        }

        for (int[] ss : shift){
            if (ss[0] == 0){
                for (int i = 0; i < ss[1]; i++){
                    char element = deque.pollFirst();
                    deque.addLast(element);
                }
            } else if (ss[0] == 1){
                for (int i = 0; i < ss[1]; i++){
                    char element = deque.pollLast();
                    deque.addFirst(element);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }

    //solution 里面的解法好像很复杂，比较复杂的算法，这里先不写了。以后再看吧
}
