package easy;
/*
 * 13. Roman to Integer 
 */
import java.util.*;
public class Prob13 {
    /*
     * 1.用可以找打的最大数表示这个数，15是XV 而不是vvv
     * 2. 如果字母的前面是比它本身要小的数，那就是自身要减去前面这个小于的数，才是当前的数
     */
    /*
     * Approach 1: left-to-right pass 
     * M: 1000, D: 500, C: 100, L: 50, X: 10, V: 5, I: 1
     * 题目赋值都是有效的，所以不用考虑是不是无效的数的情况
     * 所以，前面一个数要么比当前这个大，要么就是等于，或者小于，分别处理这些情况
     */
    public int romanToInt(String s){
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        int sum = 0; 
        int i = 0; 
        while (i < s.length()){
            int current = map.get(s.charAt(i));

            int next = 0; 
            if (i + 1 < s.length()){
                next = map.get(s.charAt(i + 1));
            }

            if (current < next){
                sum += next - current; 
                i += 2; 
            } else {
                sum += current;
                i += 1; 
            }
        }
        return sum; 
    }
}
