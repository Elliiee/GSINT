package easy2;
/*
 * 338. Counting Bits
 * Given an integer n, return an array ans of length n + 1 
 * such that for each i (0 <= i <= n), 
 * ans[i] is the number of 1's in the binary representation of i
 */
public class Prob338 {
    private int count(int x){
        int count = 0; 
        while (x != 0){
            count++;
            x &= x - 1; 
        }
        return count; 
    }

    public int[] countBits(int n){
        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++){
            ans[i] = count(i);
        }
        return ans; 
    }
}
