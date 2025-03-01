package easy;
//14. Longest Common Prefix 
/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 */
public class Prob14 {
    public String longestCommonPrefix(String[] strs){
        if (strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(prefix) != 0){ //in order to be a prefix, the index has to be 0
                prefix = prefix.substring(0, prefix.length() - 1);
                //trim 
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix; 
    }
}
