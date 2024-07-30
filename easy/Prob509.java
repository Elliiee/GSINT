package easy;

public class Prob509 {
    public int fib(int n){
        if (n < 2) return n; 

        int[] dp = new int[n+1];
        dp[0] = 0; //array default value is 0, we can skip this step 
        dp[1] = 1; 
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
