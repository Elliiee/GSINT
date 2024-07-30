package easy;
/*
 * Given a non-negative integer x, 
 * return the square root of x rounded down to the nearest integer. 
 * The returned integer should be non-negative as well.
 * You must not use any built-in exponent function or operator.
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 */
public class Prob69 {
    public int mySqrt(int x){
        if (x < 2) return x; 

        long num; 
        int pivot;
        int left = 2; 
        int right = x / 2; 
        while (left <= right){
            pivot = (right + left)/2;
            num = (long)pivot * pivot;
            if (num > x){
                right = pivot - 1; 
            } else if (num < x){
                left = pivot + 1; 
            } else {
                return pivot; 
            }
        }
        return right; 
    }
    /*
     * as there is a saying, but I'm not sure if it's right or wrong: 
     * 1. use left <= right when you assign mid = right - 1 or mid = left + 1;
     * 2. use left < right when you assign the left and right directly to mid: 
     * right = mid; 
     * left = mid + 1 
     * ??? not sure if it's correct or not ...
     */
}
