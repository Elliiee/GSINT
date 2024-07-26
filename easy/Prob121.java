package easy;

public class Prob121 {
    public int maxProfit(int[] prices){
        int minVal = Integer.MAX_VALUE;
        int maxProfit = 0; 

        for (int price : prices){
            if (price < minVal){
                minVal = price; 
            } else if (price - minVal > maxProfit) {
                maxProfit = price - minVal;
            }
        }

        return maxProfit;
    }
}
