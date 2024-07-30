package easy2;
/*
 * 344. Reverse String
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class Prob344 {
    //two pointers 
    public void reverseString(String[] s){
        int left = 0; 
        int right = s.length - 1; 
        while (left < right){
            String temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
