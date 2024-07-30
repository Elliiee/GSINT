package easy2;
/*
 * 125. Valid Palindrome
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * after converting all uppercase letters into lowercase letters 
 * and removing all non-alphanumeric characters
 * Alphanumeric characters include letters and numbers.
 */
public class Prob125 {
    public boolean isPalindrome(String s){
        for (int i = 0, j = s.length() - 1; i < j; i++, j--){
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false; 
            }
        }
        return true; 
    }
}
